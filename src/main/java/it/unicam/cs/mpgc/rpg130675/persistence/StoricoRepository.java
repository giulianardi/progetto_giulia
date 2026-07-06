package it.unicam.cs.mpgc.rpg130675.persistence;

import it.unicam.cs.mpgc.rpg130675.model.esame.Esame;

public interface StoricoRepository {

    // Aggiunge un singolo esame al file permanente
    void salvaEsameSuperato(Esame nomeEsame);

    // Legge il file e ci restituisce il libretto completo (utile se vuoi mostrarlo nella View)
    LibrettoUniversitario caricaStorico();

    // Svuota il file per una nuova partita
    void azzeraStorico();
}