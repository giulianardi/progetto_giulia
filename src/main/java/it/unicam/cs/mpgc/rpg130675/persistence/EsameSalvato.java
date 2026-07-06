package it.unicam.cs.mpgc.rpg130675.persistence;

public class EsameSalvato {
    private String nomeMateria;
    private int cfuGuadagnati;

    public EsameSalvato(String nomeMateria, int cfuGuadagnati) {
        this.nomeMateria = nomeMateria;
        this.cfuGuadagnati = cfuGuadagnati;
    }

    public String getNomeMateria() { return nomeMateria; }
    public int getCfuGuadagnati() { return cfuGuadagnati; }
}