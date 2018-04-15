package de.marvnet.minecraft.essentialspro.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class EssentialsPro extends JavaPlugin {

    public static EssentialsPro plugin = null;
    public static String name = "§6Essentials Pro§f";

    public static EssentialsPro getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        Bukkit.getConsoleSender().sendMessage(name + " §aThe plugin has been loaded successfully!");
        super.onEnable();
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(name + " §cThe plugin has been disabled successfully!");
        super.onDisable();
    }
}
