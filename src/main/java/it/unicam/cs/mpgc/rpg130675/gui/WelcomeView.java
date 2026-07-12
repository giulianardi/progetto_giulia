package it.unicam.cs.mpgc.rpg130675.gui;

import it.unicam.cs.mpgc.rpg130675.model.studente.Facolta;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class WelcomeView extends GridPane {

    private TextField nameField;
    private ComboBox<Facolta> facultyComboBox;
    private Button startButton;
    private WelcomeScreenListener listener;

    public WelcomeView() {
        initializeComponents();
        setupLayout();
        setupInteractions();
    }

    public void setWelcomeScreenListener(WelcomeScreenListener listener) {
        this.listener = listener;
    }

    private void initializeComponents() {
        nameField = new TextField();
        facultyComboBox = new ComboBox<>();
        facultyComboBox.getItems().addAll(Facolta.values());
        if (!facultyComboBox.getItems().isEmpty()) {
            facultyComboBox.getSelectionModel().selectFirst();
        }
        startButton = new Button("Inizia la tua Carriera Universitaria");
    }

    private void setupLayout() {
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(15);
        this.setPadding(new Insets(20));

        Label titleLabel = new Label("UniSurvive");
        titleLabel.getStyleClass().add("title-label");
        GridPane.setHalignment(titleLabel, HPos.CENTER);
        this.add(titleLabel, 0, 0, 2, 1);

        this.add(new Label("Nome dello Studente:"), 0, 1);
        this.add(nameField, 1, 1);

        this.add(new Label("Scegli la Facoltà:"), 0, 2);
        this.add(facultyComboBox, 1, 2);

        GridPane.setHalignment(startButton, HPos.CENTER);
        this.add(startButton, 0, 3, 2, 1);
    }

    private void setupInteractions() {
        nameField.setOnAction(e -> startButton.fire());

        startButton.setOnAction(e -> {
            String enteredName = nameField.getText().trim();
            Facolta selectedFaculty = facultyComboBox.getValue();

            if (enteredName.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Errore");
                alert.setHeaderText(null);
                alert.setContentText("Il nome dello studente non può essere vuoto!");
                alert.showAndWait();
                return;
            }

            if (listener != null) {
                listener.onGameStartRequested(enteredName, selectedFaculty);
            }
        });
    }
}