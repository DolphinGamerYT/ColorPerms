package com.dolphln.listener;

import com.dolphln.ColorPerms;
import com.dolphln.enums.Colors;
import com.dolphln.hooks.Vault;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    private ColorPerms plugin;
    private Vault vault;

    public ChatListener(ColorPerms plugin) {
        this.plugin = plugin;
        vault = plugin.getVault();
    }

    @EventHandler
    public void onPlayerMessage(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String baseMessage = e.getMessage();

        if (p.isOp() || p.hasPermission("colorperms.*") || (vault.isHooked() && vault.getPerms().has(p, "colorperms.*"))) {
            baseMessage = ChatColor.translateAlternateColorCodes('&', baseMessage);
        } else {
            for (Colors color : plugin.getColors()) {
                if (p.hasPermission(color.getPermission()) || (vault.isHooked() && vault.getPerms().has(p, color.getPermission()))) {
                    baseMessage = baseMessage.replaceAll(color.getCode(), color.getColor().toString());
                }
            }
        }



        e.setMessage(baseMessage);
    }

}
