package it.unicam.cs.mpgc.rpg130675.gui;

public interface GameUIListener {
    void aggiornaStatistiche(int turno, int conoscenza, int energia, int stress, int denaro);
    void mostraMessaggio(String titolo, String messaggio);
    void triggerGameOver(String nomeStudente);
    void triggerVittoria(String nomeStudente);
}
