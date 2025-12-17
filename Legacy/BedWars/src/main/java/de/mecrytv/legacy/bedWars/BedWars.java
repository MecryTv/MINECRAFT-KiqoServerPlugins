package de.mecrytv.legacy.bedWars;

import org.bukkit.plugin.java.JavaPlugin;

public final class BedWars extends JavaPlugin {

    private static BedWars instance;

    @Override
    public void onEnable() {
        instance = this;

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static BedWars getInstance() {
        return instance;
    }
}
