package de.mecrytv.legacy.bedWars.Countdown;

import de.mecrytv.legacy.bedWars.BedWars;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

public abstract class Countdown implements Runnable {

    private boolean running = false;
    private int startedSeconds;
    private int remainingSeconds;
    private BukkitTask task;

    /**
     * Startet den Countdown
     * @param remainingSeconds Die verbleibenden Sekunden
     * @throws IllegalStateException wenn der Countdown bereits läuft
     */
    public void startCountdown(int remainingSeconds) {
        if (this.running) {
            throw new IllegalStateException("Countdown läuft bereits!");
        }

        if (remainingSeconds <= 0) {
            throw new IllegalArgumentException("Sekunden müssen größer als 0 sein!");
        }

        this.running = true;
        this.startedSeconds = remainingSeconds;
        this.remainingSeconds = remainingSeconds;

        this.onStart();

        this.task = Bukkit.getScheduler().runTaskTimer(
                BedWars.getInstance(),
                this::tick,
                0L,
                20L
        );
    }

    /**
     * Interne Tick-Methode
     */
    private void tick() {
        if (this.remainingSeconds <= 0) {
            this.stopCountdown(true);
            return;
        }

        this.run();
        this.remainingSeconds--;
    }

    /**
     * Stoppt den Countdown
     * @param callOnEnd ob onEnd() aufgerufen werden soll
     */
    private void stopCountdown(boolean callOnEnd) {
        if (!this.running) {
            return;
        }

        this.running = false;

        if (this.task != null) {
            this.task.cancel();
            this.task = null;
        }

        if (callOnEnd) {
            this.onEnd();
        }
    }

    /**
     * Wird beim Start des Countdowns aufgerufen
     */
    public abstract void onStart();

    /**
     * Wird aufgerufen wenn der Countdown zu Ende ist
     */
    public abstract void onEnd();

    /**
     * Bricht den Countdown ab (ohne onEnd aufzurufen)
     */
    public void cancelCountdown() {
        this.stopCountdown(false);
    }

    /**
     * Beendet den Countdown vorzeitig (ruft onEnd auf)
     */
    public void finishCountdown() {
        this.stopCountdown(true);
    }

    /**
     * Setzt die verbleibenden Sekunden während des Countdowns
     * @param remainingSeconds neue verbleibende Sekunden
     * @return diese Instanz für Method Chaining
     * @throws IllegalArgumentException wenn Sekunden negativ sind
     */
    public Countdown setRemainingSeconds(int remainingSeconds) {
        if (remainingSeconds < 0) {
            throw new IllegalArgumentException("Sekunden können nicht negativ sein!");
        }
        this.remainingSeconds = remainingSeconds;
        return this;
    }

    public boolean isRunning() {
        return running;
    }

    public int getStartedSeconds() {
        return startedSeconds;
    }

    public int getRemainingSeconds() {
        return remainingSeconds;
    }

    public BukkitTask getTask() {
        return task;
    }
}