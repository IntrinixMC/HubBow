package me.intrinix.hubbow.events;

import me.intrinix.hubbow.HubBow;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;

public class ProjectileHit implements Listener {

    HubBow plugin;
    public ProjectileHit(HubBow plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }



    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event){


        ItemStack bow = new ItemStack(Material.BOW);
        String teleportMessage = plugin.getConfig().getString("teleport-message");
        if(teleportMessage == null){
            teleportMessage = "&6Woosh!!!";
        }

        if(event.getEntity().getShooter() instanceof Player){
            if(event.getEntity() instanceof Arrow){
                Player player = (Player) event.getEntity().getShooter();
                if(player.getInventory().getItemInMainHand().isSimilar(plugin.teleportBow())){
                    player.teleport(event.getEntity().getLocation());
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', teleportMessage));
                    player.spawnParticle(Particle.PORTAL, player.getLocation(), 10);
                    event.getEntity().remove();
                }
            }
        }



    }

}
