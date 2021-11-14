package me.intrinix.hubbow;

import me.intrinix.hubbow.commands.HubBowCommand;
import me.intrinix.hubbow.events.ProjectileHit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class HubBow extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        new HubBowCommand(this);
        new ProjectileHit(this);
    }


    public ItemStack teleportBow(){

        ItemStack hubBow = new ItemStack(Material.BOW);
        ItemMeta hubMeta = hubBow.getItemMeta();


        String displayName = getConfig().getString("teleport-bow-name");

        if(displayName == null){
            displayName = ChatColor.translateAlternateColorCodes('&', "&aTeleportBow");
        }

        displayName = ChatColor.translateAlternateColorCodes('&', displayName);
        ArrayList<String> lore = new ArrayList<>();
        List<String> lores = getConfig().getStringList("teleport-bow-description");
        for(int i = 0; i > lores.size(); i++ ){
           lore.add(lores.get(i));
        }


        boolean unbreakable = getConfig().getBoolean("bow-unbreakable");

        hubMeta.setDisplayName(displayName);
        hubMeta.setUnbreakable(unbreakable);
        hubMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
        hubMeta.setLore(lore);

        hubBow.setItemMeta(hubMeta);

        return hubBow;
    }

}
