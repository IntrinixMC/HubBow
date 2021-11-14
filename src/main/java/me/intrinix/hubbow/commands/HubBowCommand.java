package me.intrinix.hubbow.commands;

import me.intrinix.hubbow.HubBow;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class HubBowCommand implements CommandExecutor {


    HubBow plugin;

    public HubBowCommand(HubBow plugin) {
        this.plugin = plugin;
        plugin.getCommand("hubbow").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            player.getInventory().addItem(plugin.teleportBow());
            player.getInventory().addItem(new ItemStack(Material.ARROW));
        }
        return true;
    }
}
