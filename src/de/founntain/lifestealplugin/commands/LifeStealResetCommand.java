package de.founntain.lifestealplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LifeStealResetCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length != 1) {
            commandSender.sendMessage(ChatColor.RED + "Wrong amount of arguments. Usage: ");
            return false;
        }

        Player player = Bukkit.getPlayerExact(strings[0]);

        if(player == null){
            commandSender.sendMessage(ChatColor.RED + "Player " + ChatColor.YELLOW + strings[0] + ChatColor.RED + " not found!");
            return true;
        }

        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);

        commandSender.sendMessage(ChatColor.GREEN + "Hearts of " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.GREEN + " successfully reseted!");
        player.sendMessage(ChatColor.GOLD + "Your health was set back to default.");

        return true;
    }
}
