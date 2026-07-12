package it.unicam.cs.mpgc.rpg130675.controller;

import it.unicam.cs.mpgc.rpg130675.model.esame.Esame;
import it.unicam.cs.mpgc.rpg130675.model.esame.EsameOrale;
import it.unicam.cs.mpgc.rpg130675.model.esame.EsameScritto;

import java.util.ArrayList;
import java.util.List;

public class PianoChimica implements GeneratorePianoDiStudi{
    @Override
    public List<Esame> generaEsami() {
        List<Esame> esamiDaSostenere = new ArrayList<>();
        esamiDaSostenere.add(new EsameScritto("Matematica 1", 50, 12));
        esamiDaSostenere.add(new EsameOrale("Chimica generale", 60, 14));
        esamiDaSostenere.add(new EsameScritto("Inglese", 20, 6));
        esamiDaSostenere.add(new EsameOrale("Matematica 2", 40, 6));
        esamiDaSostenere.add(new EsameScritto("Fisica 1", 30, 6));
        esamiDaSostenere.add(new EsameOrale("Chimica analitica 1", 20, 14));
        esamiDaSostenere.add(new EsameOrale("Chimica Fisica 1", 60, 12));
        esamiDaSostenere.add(new EsameOrale("Chimica Organica 1", 50, 12));
        return esamiDaSostenere;
    }
}
