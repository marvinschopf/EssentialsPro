package de.marvnet.minecraft.essentialspro.main;

import de.marvnet.minecraft.essentialspro.commands.GamemodeCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class EssentialsPro extends JavaPlugin {

    private static EssentialsPro plugin = null;
    private static String prefix = "§7[§6EssentialsPro§7]§f";
    private static String noPermission  = "§cYou don't have the permission to execute this command!";
    private static String onlyPlayer = "§cOnly players can execute this command!";
    private static String unknownPlayer = "§cYou specified an unknown player!";

    private static boolean async = true;

    public static String getUnknownPlayer() {
        return unknownPlayer;
    }

    public static boolean getAsync() {
        return async;
    }

    public static String getNoPermission() {
        return noPermission;
    }

    public static String getOnlyPlayer() {
        return onlyPlayer;
    }

    public static EssentialsPro getPlugin() {
        return plugin;
    }

    public static String getPrefix() {
        return prefix;
    }

    @Override
    public void onEnable() {
        plugin = this;
        registerEvents();
        registerCommands();
        Bukkit.getConsoleSender().sendMessage(prefix + " §aThe plugin has been loaded successfully!");
        super.onEnable();
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(prefix + " §cThe plugin has been disabled successfully!");
        super.onDisable();
    }

    public static void registerEvents() {

    }

    public void registerCommands() {
        getCommand("gamemode").setExecutor(new GamemodeCommand());
    }
}
