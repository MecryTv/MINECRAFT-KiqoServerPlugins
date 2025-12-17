package de.mecrytv.legacy.bedWars.Countdown;

import org.bukkit.Bukkit;

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

            if (remaining == 30 || remaining == 15 || remaining == 10 || remaining <= 5) {
                Bukkit.broadcastMessage("Das Spiel startet in " + remaining + " Sekunden!");
            }

            Bukkit.getOnlinePlayers().forEach(players -> {
                players.setLevel(getRemainingSeconds());
                players.setExp((float) getRemainingSeconds() / (float) getStartedSeconds());
            });
        } else {
            this.setRemainingSeconds(61);
        }
    }
}
