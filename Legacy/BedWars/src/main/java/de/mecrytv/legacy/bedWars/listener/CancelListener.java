package de.mecrytv.legacy.bedWars.listener;

import de.mecrytv.legacy.bedWars.BedWars;
import de.mecrytv.legacy.bedWars.utils.GameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class CancelListener implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if(BedWars.getGameState().equals(GameState.LOBBY) || BedWars.getGameState().equals(GameState.RESTART)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if(BedWars.getGameState().equals(GameState.LOBBY) || BedWars.getGameState().equals(GameState.RESTART)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e){
        if(BedWars.getGameState().equals(GameState.LOBBY) || BedWars.getGameState().equals(GameState.RESTART)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        if(BedWars.getGameState().equals(GameState.LOBBY) || BedWars.getGameState().equals(GameState.RESTART)) {
            e.setCancelled(true);
        }
    }
}
