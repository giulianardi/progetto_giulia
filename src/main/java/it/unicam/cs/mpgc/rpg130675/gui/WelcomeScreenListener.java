package it.unicam.cs.mpgc.rpg130675.gui;

/**
 * Interfaccia per gestire gli eventi generati dalla schermata di benvenuto.
 * Questo ci permette di disaccoppiare la GUI dalla logica di gioco.
 */
public interface WelcomeScreenListener {
    void onGameStartRequested(String studentName, String faculty);
}
