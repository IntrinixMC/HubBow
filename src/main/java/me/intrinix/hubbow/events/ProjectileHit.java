package me.intrinix.hubbow.events;

import me.intrinix.hubbow.HubBow;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ProjectileHit implements Listener {

    HubBow plugin;
    public ProjectileHit(HubBow plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }



    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event){


        if(event.getEntity() instanceof Arrow){

            ItemStack bow = new ItemStack(Material.BOW);

            Player player = (Player) event.getEntity().getShooter();
            Location location = event.getEntity().getLocation();

            if(plugin.teleportBow().isSimilar(bow)){
                player.teleport(location);
                player.sendMessage("Woosh");
            }
        }



    }

}
