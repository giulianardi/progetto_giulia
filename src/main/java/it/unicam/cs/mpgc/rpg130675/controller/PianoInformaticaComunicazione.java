package it.unicam.cs.mpgc.rpg130675.controller;

import it.unicam.cs.mpgc.rpg130675.model.esame.Esame;
import it.unicam.cs.mpgc.rpg130675.model.esame.EsameOrale;
import it.unicam.cs.mpgc.rpg130675.model.esame.EsameScritto;

import java.util.ArrayList;
import java.util.List;

public class PianoInformaticaComunicazione implements GeneratorePianoDiStudi{

    @Override
    public List<Esame> generaEsami() {
        List<Esame> esamiDaSostenere = new ArrayList<>();
        esamiDaSostenere.add(new EsameScritto("Matematica", 50, 12));
        esamiDaSostenere.add(new EsameScritto("Programmazione", 60, 12));
        esamiDaSostenere.add(new EsameScritto("Inglese", 20, 6));
        esamiDaSostenere.add(new EsameScritto("Fondamenti dell'informatica", 40, 6));
        esamiDaSostenere.add(new EsameScritto("Architettura degli elaboratori", 30, 6));
        esamiDaSostenere.add(new EsameScritto("Diritto dei prodotti digitali", 20, 6));
        esamiDaSostenere.add(new EsameOrale("Comunicazione e marketing", 60, 12));
        esamiDaSostenere.add(new EsameScritto("Modellazione della conoscenza", 50, 12));
        return esamiDaSostenere;
    }
}
