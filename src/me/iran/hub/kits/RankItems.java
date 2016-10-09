package me.iran.hub.kits;

import java.util.Arrays;
import me.iran.hub.Hub;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RankItems
{
  Hub plugin;
  
  public RankItems(Hub plugin)
  {
    this.plugin = plugin;
  }
  
  public void onJoinHand(Player player)
  {
    ItemStack compass = new ItemStack(Material.COMPASS);
    ItemMeta cMeta = compass.getItemMeta();
    
    cMeta.setDisplayName(ChatColor.GOLD + "Server Selector");
    cMeta.setLore(Arrays.asList(new String[] { ChatColor.GRAY + "Right Click to open the Server Selector" }));
    compass.setItemMeta(cMeta);
    
    ItemStack star = new ItemStack(Material.NETHER_STAR);
    ItemMeta sMeta = star.getItemMeta();
    
    sMeta.setDisplayName(ChatColor.AQUA + "Lobby Selector");
    sMeta.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Right Click to open and view all available Lobbies" }));
    star.setItemMeta(sMeta);
    
    player.getInventory().clear();
    player.getInventory().setItem(0, compass);
    player.getInventory().setItem(8, star);
    player.updateInventory();
  }
}
