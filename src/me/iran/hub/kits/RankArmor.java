package me.iran.hub.kits;

import java.util.ArrayList;
import java.util.List;

import me.iran.hub.Hub;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class RankArmor
{
  Hub plugin;
  
  public RankArmor(Hub plugin)
  {
    this.plugin = plugin;
  }
  
  public void setBasic(Player player)
  {
    ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
    ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
    ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
    ItemStack compass = new ItemStack(Material.COMPASS);
    
    ItemMeta cmeta = compass.getItemMeta();
    cmeta.setDisplayName(ChatColor.GOLD + "Server Selector");
    compass.setItemMeta(cmeta);
    
    LeatherArmorMeta meta = (LeatherArmorMeta)chestplate.getItemMeta();
    List<String> lore = new ArrayList<String>();
    
    leggings.addEnchantment(Enchantment.DURABILITY, 3);
    chestplate.addEnchantment(Enchantment.DURABILITY, 3);
    boots.addEnchantment(Enchantment.DURABILITY, 3);
    
    lore.add(ChatColor.GREEN + "You are currently Basic rank.");
    lore.add(ChatColor.GREEN + "Purchased at: store.mcpots.org");
    
    meta.setLore(lore);
    meta.setColor(Color.TEAL);
    meta.setDisplayName(ChatColor.GREEN + "Thanks for donating!");
    
    boots.setItemMeta(meta);
    leggings.setItemMeta(meta);
    chestplate.setItemMeta(meta);
    
    player.getInventory().clear();
    player.getInventory().setChestplate(chestplate);
    player.getInventory().setLeggings(leggings);
    player.getInventory().setBoots(boots);
    player.getInventory().setItem(0, compass);
    player.updateInventory();
    player.sendMessage(ChatColor.YELLOW + "Your rank is " + ChatColor.GOLD + "Basic");
  }
  
  public void setSilver(Player player)
  {
    ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
    ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
    ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
    
    ItemStack compass = new ItemStack(Material.COMPASS);
    
    ItemMeta cmeta = compass.getItemMeta();
    cmeta.setDisplayName(ChatColor.GOLD + "Server Selector");
    compass.setItemMeta(cmeta);
    
    
    LeatherArmorMeta meta = (LeatherArmorMeta)chestplate.getItemMeta();
    leggings.addEnchantment(Enchantment.DURABILITY, 3);
    chestplate.addEnchantment(Enchantment.DURABILITY, 3);
    boots.addEnchantment(Enchantment.DURABILITY, 3);
    List<String> lore = new ArrayList<String>();
    lore.add(ChatColor.GREEN + "You are currently Silver rank.");
    lore.add(ChatColor.GREEN + "Purchased at: store.mcpots.org");
    meta.setLore(lore);
    meta.setColor(Color.GRAY);
    meta.setDisplayName(ChatColor.GREEN + "Thanks for donating!");
    boots.setItemMeta(meta);
    leggings.setItemMeta(meta);
    chestplate.setItemMeta(meta);
    player.getInventory().clear();
    player.getInventory().setChestplate(chestplate);
    player.getInventory().setLeggings(leggings);
    player.getInventory().setBoots(boots);
    player.getInventory().setItem(0, compass);
    player.updateInventory();
    player.sendMessage(ChatColor.YELLOW + "Your rank is " + ChatColor.GOLD + "Silver");
  }
  
  public void setGold(Player player)
  {
    ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
    ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
    ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
    ItemStack compass = new ItemStack(Material.COMPASS);
    
    ItemMeta cmeta = compass.getItemMeta();
    cmeta.setDisplayName(ChatColor.GOLD + "Server Selector");
    compass.setItemMeta(cmeta);
    
    LeatherArmorMeta meta = (LeatherArmorMeta)chestplate.getItemMeta();
    leggings.addEnchantment(Enchantment.DURABILITY, 3);
    chestplate.addEnchantment(Enchantment.DURABILITY, 3);
    boots.addEnchantment(Enchantment.DURABILITY, 3);
    List<String> lore = new ArrayList<String>();
    lore.add(ChatColor.GREEN + "You are currently Gold rank.");
    lore.add(ChatColor.GREEN + "Purchased at: store.mcpots.org");
    meta.setLore(lore);
    meta.setColor(Color.YELLOW);
    meta.setDisplayName(ChatColor.GREEN + "Thanks for donating!");
    boots.setItemMeta(meta);
    leggings.setItemMeta(meta);
    chestplate.setItemMeta(meta);
    player.getInventory().clear();
    player.getInventory().setChestplate(chestplate);
    player.getInventory().setLeggings(leggings);
    player.getInventory().setBoots(boots);
    player.getInventory().setItem(0, compass);
    player.updateInventory();
    player.sendMessage(ChatColor.YELLOW + "Your rank is " + ChatColor.GOLD + "Gold");
  }
  
  public void setPlatinum(Player player)
  {
    ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
    ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
    ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
    ItemStack compass = new ItemStack(Material.COMPASS);
    
    ItemMeta cmeta = compass.getItemMeta();
    cmeta.setDisplayName(ChatColor.GOLD + "Server Selector");
    compass.setItemMeta(cmeta);
    
    LeatherArmorMeta meta = (LeatherArmorMeta)chestplate.getItemMeta();
    leggings.addEnchantment(Enchantment.DURABILITY, 3);
    chestplate.addEnchantment(Enchantment.DURABILITY, 3);
    boots.addEnchantment(Enchantment.DURABILITY, 3);
    List<String> lore = new ArrayList<String>();
    lore.add(ChatColor.GREEN + "You are currently Platinum rank.");
    lore.add(ChatColor.GREEN + "Purchased at: store.mcpots.org");
    meta.setLore(lore);
    meta.setColor(Color.TEAL);
    meta.setDisplayName(ChatColor.GREEN + "Thanks for donating!");
    boots.setItemMeta(meta);
    leggings.setItemMeta(meta);
    chestplate.setItemMeta(meta);
    player.getInventory().clear();
    player.getInventory().setChestplate(chestplate);
    player.getInventory().setLeggings(leggings);
    player.getInventory().setBoots(boots);
    player.getInventory().setItem(0, compass);
    player.updateInventory();
    player.sendMessage(ChatColor.YELLOW + "Your rank is " + ChatColor.GOLD + "Platinum");
  }
}
