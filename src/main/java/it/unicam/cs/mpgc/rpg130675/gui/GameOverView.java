package it.unicam.cs.mpgc.rpg130675.gui;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class GameOverView extends VBox {

    private Runnable onRestartListener;

    public GameOverView(String nomeStudente) {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.getStyleClass().add("game-over-root");

        Label titleLabel = new Label("GAME OVER - BURNOUT TOTALE");
        titleLabel.getStyleClass().add("game-over-title");

        Label messageLabel = new Label(
                "Mi dispiace " + nomeStudente + ", lo stress ha superato il limite sopportabile.\n" +
                        "Hai abbandonato gli studi per preservare la tua salute mentale."
        );
        messageLabel.getStyleClass().add("game-over-message");
        messageLabel.setWrapText(true);

        Button restartButton = new Button("Ricomincia la partita");
        restartButton.setOnAction(e -> {
            if (onRestartListener != null) {
                onRestartListener.run();
            }
        });

        this.getChildren().addAll(titleLabel, messageLabel, restartButton);
    }

    public void setOnRestartListener(Runnable onRestartListener) {
        this.onRestartListener = onRestartListener;
    }
}