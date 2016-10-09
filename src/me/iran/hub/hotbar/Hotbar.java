package me.iran.hub.hotbar;

import java.io.File;
import java.util.List;

import me.iran.hub.Hub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Hotbar
  implements Listener
{
  Hub plugin;
  public Inventory compass;
  public Inventory lobby;
  
  public Hotbar(Hub plugin)
  {
    this.plugin = plugin;
  }
  
  public File file = null;
  
  public Inventory serverInv(Player player)
  {
    this.compass = Bukkit.createInventory(null, 18, ChatColor.GOLD + "List of servers");
    
    this.file = new File(this.plugin.getDataFolder(), "servers.yml");
    if (this.file.exists())
    {
      this.file = new File(this.plugin.getDataFolder(), "servers.yml");
      
      new YamlConfiguration();
      
      YamlConfiguration server = YamlConfiguration.loadConfiguration(this.file);
      
      ItemStack ender = new ItemStack(Material.EYE_OF_ENDER);
      ItemMeta enderMeta = ender.getItemMeta();
      
      List<String> servers = server.getStringList("servers.servers");
      for (int i = 0; i < servers.size(); i++)
      {
        enderMeta.setDisplayName((String)servers.get(i));
        ender.setItemMeta(enderMeta);
        this.compass.setItem(i, ender);
      }
    }
    return this.compass;
  }
  
  public Inventory lobbyInv(Player player)
  {
    this.lobby = Bukkit.createInventory(null, 18, ChatColor.AQUA + "List of Lobbies");
    
    this.file = new File(this.plugin.getDataFolder(), "servers.yml");
    if (this.file.exists())
    {
      this.file = new File(this.plugin.getDataFolder(), "servers.yml");
      
      new YamlConfiguration();
      
      YamlConfiguration server = YamlConfiguration.loadConfiguration(this.file);
      
      ItemStack ender = new ItemStack(Material.ENDER_PEARL);
      ItemMeta enderMeta = ender.getItemMeta();
      
      List<String> servers = server.getStringList("servers.lobbies");
      for (int i = 0; i < servers.size(); i++)
      {
        enderMeta.setDisplayName((String)servers.get(i));
        ender.setItemMeta(enderMeta);
        this.lobby.setItem(i, ender);
      }
    }
    return this.lobby;
  }
  
  @EventHandler
  public void onClick(PlayerInteractEvent event)
  {
    Player player = event.getPlayer();
    if (event.getAction() == null) {
      return;
    }
    if (((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
      (player.getInventory().getItemInHand().getType() == Material.COMPASS)) {
      player.openInventory(serverInv(player));
    }
    if (((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
      (player.getInventory().getItemInHand().getType() == Material.NETHER_STAR)) {
      player.openInventory(lobbyInv(player));
    }
  }
  
  @EventHandler
  public void onDrop(PlayerDropItemEvent event)
  {
    if (event.getItemDrop().getItemStack().getType() == Material.NETHER_STAR) {
      event.setCancelled(true);
    }
    if (event.getItemDrop().getItemStack().getType() == Material.COMPASS) {
      event.setCancelled(true);
    }
  }
  
  @EventHandler
  public void onInvClick(InventoryClickEvent event)
  {
    Player player = (Player)event.getWhoClicked();
    if ((event.getSlotType().equals(InventoryType.SlotType.QUICKBAR)) && (!event.getCurrentItem().getType().equals(Material.AIR))) {
      event.setCancelled(true);
    }
    if (event.getInventory().getTitle().equals(ChatColor.GOLD + "List of servers"))
    {
      String server = event.getCurrentItem().getItemMeta().getDisplayName();
      this.plugin.connect(player, server);
    }
  }
}
