package de.founntain.lifestealplugin;

import de.founntain.lifestealplugin.commands.LifeStealResetCommand;
import de.founntain.lifestealplugin.commands.ResetHeartsCommand;
import de.founntain.lifestealplugin.events.OnPlayerDeathEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class LifeStealPlugin extends JavaPlugin {
    private final Server server;
    private final String consolePrefix = ChatColor.WHITE + "[" + ChatColor.LIGHT_PURPLE +"Life Steal Plugin" + ChatColor.WHITE + "] ";

    public LifeStealPlugin(){
        this.server = Bukkit.getServer();
    }

    @Override
    public void onEnable() {
        this.sendConsoleMessage("Plugin enabled");

        this.sendConsoleMessage("Registering events");

        this.registerEvents();

        this.sendConsoleMessage("Successfully registered events");

        this.sendConsoleMessage("Registering commands");

        this.registerCommands();

        this.sendConsoleMessage("Successfully registered commands");
    }

    @Override
    public void onLoad() {
        this.sendConsoleMessage("Plugin loaded");
        this.sendConsoleMessage("Plugin made by " + ChatColor.GOLD + "Founntain");
        this.sendConsoleMessage("GitHub: " + ChatColor.YELLOW + "https://github.com/Founntain/Minecraft-LifeStealPlugin");
    }

    @Override
    public void onDisable() {
        this.sendConsoleMessage("Plugin disabled");
    }

    private void sendConsoleMessage(String msg) {
        this.server.getConsoleSender().sendMessage(this.consolePrefix + msg);
    }

    private void registerCommand(String command, CommandExecutor commandExecutor){

        this.sendConsoleMessage(ChatColor.RED + commandExecutor.getClass().getSimpleName() + ChatColor.WHITE + " registered ");

        getCommand(command).setExecutor(commandExecutor);
    }

    private void registerEvent(Listener listener){
        this.sendConsoleMessage(ChatColor.RED + listener.getClass().getSimpleName() + ChatColor.WHITE + " registered ");

        this.server.getPluginManager().registerEvents(listener, this);
    }

    private void registerEvents(){
        this.registerEvent(new OnPlayerDeathEvent());
    }


    private void registerCommands(){
        this.registerCommand("resethearts", new ResetHeartsCommand());
        this.registerCommand("lsreset", new LifeStealResetCommand());
    }
}
