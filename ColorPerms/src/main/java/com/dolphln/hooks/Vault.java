package com.dolphln.hooks;

import com.dolphln.ColorPerms;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

import java.util.logging.Level;

public class Vault {

    private ColorPerms colorPerms;

    private Permission perms;
    private Boolean hooked;

    public Vault(ColorPerms colorPerms) {
        this.colorPerms = colorPerms;

        hooked = !Bukkit.getServer().getPluginManager().getPlugin("Vault").isEnabled();

        if (!hooked) {
            Bukkit.getServer().getLogger().log(Level.SEVERE, "Could not hook to Vault.");
            return;
        }

        if (!setupPermissions()) {
            Bukkit.getServer().getLogger().log(Level.SEVERE, "Could not hook to Vault Permissions.");
        }
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = Bukkit.getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }

    public Boolean isHooked() {
        return hooked;
    }

    public Permission getPerms() {
        return perms;
    }

}
