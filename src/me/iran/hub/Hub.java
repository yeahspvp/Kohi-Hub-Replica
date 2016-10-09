package me.iran.hub;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import me.iran.hub.hotbar.Hotbar;
import me.iran.hub.kits.RankArmor;
import me.iran.hub.kits.RankItems;
import me.iran.hub.listeners.OnJoinListeners;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class Hub
  extends JavaPlugin
  implements PluginMessageListener
{
  private int playersOnline = 0;
  File file = null;
  
  public void onEnable()
  {
    Bukkit.getPluginManager().registerEvents(new OnJoinListeners(this), this);
    Bukkit.getPluginManager().registerEvents(new Hotbar(this), this);
    
    Bukkit.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    Bukkit.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
    
    this.file = new File(getDataFolder(), "servers.yml");
    if (!this.file.exists())
    {
      this.file = new File(getDataFolder(), "servers.yml");
      
      new YamlConfiguration();
      
      YamlConfiguration server = YamlConfiguration.loadConfiguration(this.file);
      
      server.createSection("servers.servers");
      server.createSection("servers.lobbies");
      
      List<String> serverList = server.getStringList("servers.servers");
      List<String> lobbyList = server.getStringList("servers.lobbies");
      
      lobbyList.add("lobby");
      serverList.add("hcf");
      
      server.set("servers.servers", serverList);
      server.set("servers.lobbies", lobbyList);
      try
      {
        server.save(this.file);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
  }
  
  public void connect(Player player, String server)
  {
    ByteArrayOutputStream b = new ByteArrayOutputStream();
    DataOutputStream out = new DataOutputStream(b);
    try
    {
      out.writeUTF("Connect");
      out.writeUTF(server);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    player.sendPluginMessage(this, "BungeeCord", b.toByteArray());
  }
  
  public void onPluginMessageReceived(String channel, Player player, byte[] message)
  {
    if (!channel.equals("BungeeCord")) {
      return;
    }
    ByteArrayDataInput in = ByteStreams.newDataInput(message);
    String subchannel = in.readUTF();
    if (subchannel.equals("PlayerCount"))
    {
      @SuppressWarnings("unused")
	String server = in.readUTF();
      int count = in.readInt();
      this.playersOnline = count;
    }
  }
  
  public int getServerPlayerCount(Player player, String servername)
  {
    ByteArrayOutputStream b = new ByteArrayOutputStream();
    DataOutputStream out = new DataOutputStream(b);
    try
    {
      out.writeUTF("PlayerCount");
      out.writeUTF(servername);
    }
    catch (Exception e1)
    {
      e1.printStackTrace();
    }
    player.sendPluginMessage(this, "BungeeCord", b.toByteArray());
    return this.playersOnline;
  }
  
  RankArmor ra = new RankArmor(this);
  RankItems ri = new RankItems(this);
  
}
