package com.dolphln.listener;

import com.dolphln.ColorPerms;
import com.dolphln.enums.Colors;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    private ColorPerms plugin;

    public ChatListener(ColorPerms plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerMessage(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String baseMessage = e.getMessage();

        if (plugin.getVault().isHooked()) {
            for (Colors color : plugin.getColors()) {
                if (plugin.getVault().getPerms().has(p, color.getPermission()) || p.hasPermission(color.getPermission()) || p.isOp()) {
                    baseMessage = baseMessage.replaceAll(color.getCode(), color.getColor().toString());
                }
            }
        } else {
            for (Colors color : plugin.getColors()) {
                if (p.hasPermission(color.getPermission()) || p.isOp()) {
                    baseMessage = baseMessage.replaceAll(color.getCode(), color.getColor().toString());
                }
            }
        }



        e.setMessage(baseMessage);
    }

}
