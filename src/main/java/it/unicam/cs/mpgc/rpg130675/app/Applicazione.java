package it.unicam.cs.mpgc.rpg130675.app;

import it.unicam.cs.mpgc.rpg130675.controller.GameController;
import it.unicam.cs.mpgc.rpg130675.gui.GameUIListener;
import it.unicam.cs.mpgc.rpg130675.gui.MainGameView;
import it.unicam.cs.mpgc.rpg130675.gui.WelcomeView;
import it.unicam.cs.mpgc.rpg130675.model.azioni.Festa;
import it.unicam.cs.mpgc.rpg130675.model.azioni.Lavoro;
import it.unicam.cs.mpgc.rpg130675.model.azioni.Riposo;
import it.unicam.cs.mpgc.rpg130675.model.azioni.Studio;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * Punto di ingresso dell'applicazione (Composition Root).
 * Si occupa di inizializzare l'interfaccia grafica JavaFX, caricare i fogli di stile (CSS)
 * e iniettare le dipendenze collegando Model, View e Controller.
 */
public class Applicazione extends Application {

    private Stage primaryStage;
    private Scene mainScene;

    public static void main(String[] args) {
        // Avvia il ciclo di vita nativo di JavaFX
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("UniSurvive");

        // 1. Creazione della Vista Iniziale
        WelcomeView welcomeView = new WelcomeView();

        // 2. Creazione della Scena (che conterrà tutte le nostre Viste)
        mainScene = new Scene(welcomeView, 600, 500);

        // 3. Caricamento del CSS per separare la presentazione dalla logica (SRP)
        caricaStili(mainScene);

        // 4. Setup del listener per il cambio schermata
        welcomeView.setWelcomeScreenListener((nome, facolta) -> avviaGioco(nome, facolta));

        this.primaryStage.setScene(mainScene);
        this.primaryStage.show();
    }

    private void caricaStili(Scene scene) {
        try {
            String cssPath = Objects.requireNonNull(getClass().getResource("/css/style.css")).toExternalForm();
            scene.getStylesheets().add(cssPath);
        } catch (NullPointerException e) {
            System.err.println("Attenzione: file style.css non trovato in /src/main/resources/css/." +
                    " L'applicazione userà il tema di default di JavaFX.");
        }
    }

    private void avviaGioco(String nome, it.unicam.cs.mpgc.rpg130675.model.studente.Facolta facolta) {
        // Creazione componenti architetturali
        MainGameView gameView = new MainGameView();

        // NB: Ora GameUIListener riceve il primaryStage di JavaFX, non più il JFrame!
        GameUIListener uiListener = new GameUIListener(gameView, primaryStage);
        GameController controller = new GameController(uiListener);

        // Inizializzazione della partita
        controller.avviaPartita(nome, facolta);

        // Registrazione degli eventi provenienti dalla UI
        gameView.setMainGameListener(azioneScelta -> {
            System.out.println("Azione ricevuta dalla UI: " + azioneScelta);

            try {
                // Sfruttiamo lo switch moderno (Java 14+) che è più leggibile e previene bug da 'break' mancanti
                switch (azioneScelta) {
                    case STUDIA -> controller.eseguiAzione(new Studio());
                    case LAVORA -> controller.eseguiAzione(new Lavoro());
                    case FESTA -> controller.eseguiAzione(new Festa());
                    case DORMI -> controller.eseguiAzione(new Riposo());
                    case LIBRETTO -> controller.mostraLibretto();
                    default -> System.out.println("Azione non supportata!");
                }
            } catch (Exception ex) {
                System.err.println("Errore durante l'esecuzione dell'azione:");
                ex.printStackTrace();
            }
        });

        // Cambio schermata fluido: aggiorniamo solo il "nodo radice" della scena
        mainScene.setRoot(gameView);
    }
}