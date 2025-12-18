package de.mecrytv.legacy.bedWars;

import de.mecrytv.legacy.bedWars.Countdown.LobbyCountdown;
import de.mecrytv.legacy.bedWars.listener.CancelListener;
import de.mecrytv.legacy.bedWars.listener.ChatListener;
import de.mecrytv.legacy.bedWars.listener.ConnectionListener;
import de.mecrytv.legacy.bedWars.utils.GameState;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class BedWars extends JavaPlugin {

    private static BedWars instance;
    private static GameState gameState;

    @Override
    public void onEnable() {
        instance = this;
        gameState = GameState.LOBBY;

        PluginManager plm = Bukkit.getPluginManager();
        plm.registerEvents(new ConnectionListener(), this);
        plm.registerEvents(new ChatListener(), this);
        plm.registerEvents(new CancelListener(), this);

        LobbyCountdown lobbyCountdown = new LobbyCountdown();
        lobbyCountdown.startCountdown(61);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static BedWars getInstance() {
        return instance;
    }

    public static GameState getGameState() {
        return gameState;
    }
}
