package com.dolphln.hooks;

import com.dolphln.ColorPerms;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

import java.util.logging.Level;

public class Vault {

    private final ColorPerms colorPerms;

    private Permission perms;
    private Boolean hooked;

    public Vault(ColorPerms colorPerms) {
        this.colorPerms = colorPerms;

        this.hooked = Bukkit.getServer().getPluginManager().getPlugin("Vault").isEnabled();

        if (!this.hooked) {
            Bukkit.getServer().getLogger().log(Level.SEVERE, "Could not hook to Vault.");
            return;
        }

        if (!setupPermissions()) {
            Bukkit.getServer().getLogger().log(Level.SEVERE, "Could not hook to Vault Permissions.");
        }
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = Bukkit.getServer().getServicesManager().getRegistration(Permission.class);
        this.perms = rsp.getProvider();
        return this.perms != null;
    }

    public Boolean isHooked() {
        return this.hooked;
    }

    public Permission getPerms() {
        return perms;
    }

}
