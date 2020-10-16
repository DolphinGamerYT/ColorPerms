package com.dolphln;

import com.dolphln.enums.Colors;
import com.dolphln.hooks.Vault;
import com.dolphln.listener.ChatListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class ColorPerms extends JavaPlugin {

    private ColorPerms instance;
    private Colors[] colors;
    private Vault vault;

    @Override
    public void onEnable() {
        Bukkit.getLogger().log(Level.INFO, "ColorPerms is starting...");

        this.instance = this;
        vault = new Vault(this);

        colors = Colors.values();

        Bukkit.getPluginManager().registerEvents(new ChatListener(this), this);

        Bukkit.getLogger().log(Level.INFO, "ColorPerms has started correctly!");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().log(Level.INFO, "ColorPerms is closing...");

        Bukkit.getLogger().log(Level.FINEST, "ColorPerms has closed correctly.");
    }

    public ColorPerms getInstance() {
        return instance;
    }

    public Vault getVault() {
        return vault;
    }

    public Colors[] getColors() {
        return colors;
    }

}
