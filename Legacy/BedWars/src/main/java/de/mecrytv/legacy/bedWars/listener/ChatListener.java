package de.mecrytv.legacy.bedWars.listener;

import de.mecrytv.legacy.bedWars.BedWars;
import de.mecrytv.legacy.bedWars.utils.GameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if(BedWars.getGameState().equals(GameState.LOBBY) || BedWars.getGameState().equals(GameState.RESTART)){
            e.setFormat("§a%s§8" + " » " + "§7%s");
        } else {
            e.setFormat("§c%s§8" + " » " + "§7%s");
        }
    }
}
