package de.mecrytv.legacy.bedWars.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(null);

        Player player = e.getPlayer();

        Bukkit.getOnlinePlayers().forEach(players -> {
            players.sendMessage("§e" + player.getDisplayName() + " §7hat das Spiel betreten.");
        });
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(null);

        Player player = e.getPlayer();

        Bukkit.getOnlinePlayers().forEach(players -> {
            players.sendMessage("§e" + player.getDisplayName() + " §7hat das Spiel verlassen.");
        });
    }
}
