package de.founntain.lifestealplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class ResetHeartsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        /*for(Player player : Bukkit.getOnlinePlayers()){
            player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);
        }*/

        int playersskipped = 0;

        for(OfflinePlayer player : Bukkit.getOfflinePlayers()){
            Player p = player.getPlayer();

            if(p == null) {
                playersskipped++;
                continue;
            }

            p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);
        }

        commandSender.sendMessage(ChatColor.GREEN + "Reseted hearts of "
                + ChatColor.YELLOW + (Bukkit.getOfflinePlayers().length - playersskipped)
                + ChatColor.GREEN + " players. "
                + ChatColor.YELLOW + playersskipped
                + ChatColor.GOLD + " player(s) skipped due to beeing offline!");

        return true;
    }
}
