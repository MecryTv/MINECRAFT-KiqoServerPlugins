package de.mecrytv.legacy.bedWars.Countdown;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class LobbyCountdown extends Countdown{
    /**
     * Wird beim Start des Countdowns aufgerufen
     */
    @Override
    public void onStart() {
        Bukkit.broadcastMessage("DAS SPIEL STARTET JETZT!");
    }

    /**
     * Wird aufgerufen wenn der Countdown zu Ende ist
     */
    @Override
    public void onEnd() {
        Bukkit.broadcastMessage("Der Countdown ist zu Ende!");
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        if (Bukkit.getOnlinePlayers().size() >= 1) {
            int remaining = this.getRemainingSeconds();

            if (remaining == 30 || remaining == 15 || remaining == 10 || remaining == 5 || remaining <= 3) {
                Bukkit.broadcastMessage("Das Spiel startet in " + remaining + " Sekunden!");

                for (Player players : Bukkit.getOnlinePlayers()) {
                    players.playSound(players.getLocation(), Sound.NOTE_PLING, 1.0f, 1.0f);

                    if (remaining <= 3) {
                        players.playSound(players.getLocation(), Sound.NOTE_BASS_DRUM, 1.0f, 0.5f);
                    }
                }
            }

            Bukkit.getOnlinePlayers().forEach(players -> {
                if (remaining == 10) {
                    players.sendTitle("TESTMAP", "§eBUILD TEAM");
                }

                players.setLevel(getRemainingSeconds());
                players.setExp((float) getRemainingSeconds() / (float) getStartedSeconds());
            });
        } else {
            this.setRemainingSeconds(31);
        }
    }
}
