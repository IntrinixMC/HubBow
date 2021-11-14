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

public final class HubBow extends JavaPlugin {

    @Override
    public void onEnable() {
        new HubBowCommand(this);
        new ProjectileHit(this);

    }


    public ItemStack teleportBow(){

        ItemStack hubBow = new ItemStack(Material.BOW);
        ItemMeta hubMeta = hubBow.getItemMeta();


        String displayName = ChatColor.translateAlternateColorCodes('&', "&aTeleport Bow");
        ArrayList<String> lore = new ArrayList<>();
        boolean unbreakable = true;

        hubMeta.setDisplayName(displayName);
        hubMeta.setUnbreakable(unbreakable);
        hubMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
        hubMeta.setLore(lore);

        hubBow.setItemMeta(hubMeta);

        return hubBow;
    }

}
