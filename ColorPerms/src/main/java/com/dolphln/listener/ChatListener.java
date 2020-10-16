package com.dolphln.listener;

import com.dolphln.ColorPerms;
import com.dolphln.enums.Colors;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    private ColorPerms plugin;
    private Colors[] colors;

    public ChatListener(ColorPerms plugin, Colors[] colors) {
        this.plugin = plugin;
        this.colors = colors;
    }

    @EventHandler
    public void onPlayerMessage(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String baseMessage = e.getMessage();

        if (plugin.getVault().isHooked()) {
            for (Colors color : colors) {
                if (plugin.getVault().getPerms().has(p, color.getPermission()) || p.hasPermission(color.getPermission()) || p.isOp()) {
                    baseMessage = baseMessage.replaceAll(color.getCode(), color.getColor().toString());
                }
            }
        } else {
            for (Colors color : colors) {
                if (p.hasPermission(color.getPermission()) || p.isOp()) {
                    baseMessage = baseMessage.replaceAll(color.getCode(), color.getColor().toString());
                }
            }
        }



        e.setMessage(baseMessage);
    }

}
