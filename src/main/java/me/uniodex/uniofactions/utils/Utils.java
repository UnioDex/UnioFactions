package me.uniodex.uniofactions.utils;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import me.uniodex.uniofactions.UnioFactions;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utils {

    public static Date parseTime(String time) {
        try {
            String[] frag = time.split("-");
            if (frag.length < 2) {
                return new Date();
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(frag[0] + "-" + frag[1] + "-" + frag[2]);
        } catch (Exception ignored) {
        }
        return new Date();
    }

    public static ChatColor stringToChatColor(String color) {
        switch (color.toLowerCase()) {
            case "yeşil":
                return ChatColor.GREEN;
            case "açık_mavi":
                return ChatColor.AQUA;
            case "açık_kırmızı":
                return ChatColor.RED;
            case "eflatun":
                return ChatColor.LIGHT_PURPLE;
            case "sarı":
                return ChatColor.YELLOW;
            case "beyaz":
                return ChatColor.WHITE;
            case "siyah":
                return ChatColor.BLACK;
            case "koyu_mavi":
                return ChatColor.DARK_BLUE;
            case "koyu_yeşil":
                return ChatColor.DARK_GREEN;
            case "turkuaz":
                return ChatColor.DARK_AQUA;
            case "koyu_kırmızı":
                return ChatColor.DARK_RED;
            case "koyu_mor":
                return ChatColor.DARK_PURPLE;
            case "turuncu":
                return ChatColor.GOLD;
            case "gri":
                return ChatColor.GRAY;
            case "koyu_gri":
                return ChatColor.DARK_GRAY;
            case "mavi":
                return ChatColor.BLUE;
            default:
                return null;
        }
    }

    public static String colorizeMessage(String message) {
        return ChatColor.translateAlternateColorCodes('&', message.replaceAll("%hataprefix%", UnioFactions.hataPrefix).replaceAll("%bilgiprefix%", UnioFactions.bilgiPrefix).replaceAll("%dikkatprefix%", UnioFactions.dikkatPrefix).replaceAll("%prefix%", UnioFactions.bilgiPrefix));
    }

    public static boolean isLocationInArea(Location location, String area) {
        List<String> regionIds = new ArrayList<>();
        RegionManager regionManager = WorldGuardPlugin.inst().getRegionManager(location.getWorld());
        ApplicableRegionSet regionsAtLocation = regionManager.getApplicableRegions(location);

        for (ProtectedRegion region : regionsAtLocation) {
            regionIds.add(region.getId());
        }

        return regionIds.contains(area);
    }

    public static ItemStack stringToItemStack(String item) {
        String type;
        short data;
        if (item.contains(":")) {
            type = item.split(":")[0];
            data = Short.valueOf(item.split(":")[1]);
        } else {
            type = item;
            data = 0;
        }
        return new ItemStack(Material.valueOf(type), 1, data);
    }

    public static int countOccurences(String str, String word) {
        String[] a = str.split(" ");
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i].contains(word))
                count++;
        }

        return count;
    }
}
