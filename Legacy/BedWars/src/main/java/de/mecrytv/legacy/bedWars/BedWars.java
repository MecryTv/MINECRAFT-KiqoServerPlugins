package de.mecrytv.legacy.bedWars;

import org.bukkit.plugin.java.JavaPlugin;

public final class BedWars extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("[LEGACY] BedWars Plugin has been enabled.");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
