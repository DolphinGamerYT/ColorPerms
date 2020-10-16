package com.dolphln.enums;

import org.bukkit.ChatColor;

public enum Colors {

    BLACK("Black", ChatColor.BLACK, "&0", "colorperms.black"),
    DARK_BLUE("Dark Blue", ChatColor.DARK_BLUE, "&1", "colorperms.dark_blue"),
    DARK_GREEN("Dark Green", ChatColor.DARK_GREEN, "&2", "colorperms.dark_green"),
    DARK_AQUA("Dark Aqua", ChatColor.DARK_AQUA, "&3", "colorperms.dark_aqua"),
    DARK_RED("Dark Red", ChatColor.DARK_RED, "&4", "colorperms.dark_red"),
    DARK_PURPLE("Dark Purple", ChatColor.DARK_PURPLE, "&5", "colorperms.dark_purple"),
    GOLD("Gold", ChatColor.GOLD, "&6", "colorperms.gold"),
    GRAY("Gray", ChatColor.GRAY, "&7", "colorperms.gray"),
    DARK_GRAY("Dark Gray", ChatColor.DARK_GRAY, "&8", "colorperms.dark_gray"),
    BLUE("Blue", ChatColor.BLUE, "&9", "colorperms.blue"),
    LIME_GREEN("Lime Green", ChatColor.GREEN, "&a", "colorperms.lime_green"),
    AQUA("Aqua", ChatColor.AQUA, "&b", "colorperms.aqua"),
    RED("Red", ChatColor.RED, "&c", "colorperms.red"),
    PINK("Pink", ChatColor.LIGHT_PURPLE, "&d", "colorperms.pink"),
    YELLOW("Yellow", ChatColor.YELLOW, "&e", "colorperms.yellow"),
    WHITE("White", ChatColor.WHITE, "&f", "colorperms.white"),
    BOLD("Bold", ChatColor.BOLD, "&l", "colorperms.bold"),
    STRIKETHROUGH("Strikethrough", ChatColor.STRIKETHROUGH, "&m", "colorperms.strikethrough"),
    UNDERLINED("Underlined", ChatColor.UNDERLINE, "&n", "colorperms.underlined"),
    ITALIC("Italic", ChatColor.ITALIC, "&o", "colorperms.italic");

    private final String name;
    private final ChatColor color;
    private final String code;
    private final String permission;

    Colors(String name, ChatColor color, String code, String permission) {
        this.name = name;
        this.color = color;
        this.code = code;
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public ChatColor getColor() {
        return color;
    }

    public String getCode() {
        return code;
    }

    public String getPermission() {
        return permission;
    }

}
