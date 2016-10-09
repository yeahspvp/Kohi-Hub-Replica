package me.iran.hub.listeners;

import me.iran.hub.Hub;
import me.iran.hub.kits.RankArmor;
import me.iran.hub.kits.RankItems;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnJoinListeners
  implements Listener
{
  Hub plugin;
  RankArmor rank = new RankArmor(plugin);
  RankItems items = new RankItems(plugin);
  
  public OnJoinListeners(Hub plugin)
  {
    this.plugin = plugin;
  }
  
  @EventHandler
  public void onJoin(PlayerJoinEvent event) {
	  Player player = event.getPlayer();
	  items.onJoinHand(player);
	  
	  if(player.hasPermission("hub.basic")) {
		  rank.setBasic(player);
	  } else if(player.hasPermission("hub.silver")) {
		  rank.setSilver(player);
	  }else if(player.hasPermission("hub.gold")) {
		  rank.setGold(player);
	  }else if(player.hasPermission("hub.platinum")) {
		  rank.setPlatinum(player);
	  }else {
		  player.sendMessage(ChatColor.YELLOW + "Your rank is " + ChatColor.WHITE + "Default");
	  }
  }
}
