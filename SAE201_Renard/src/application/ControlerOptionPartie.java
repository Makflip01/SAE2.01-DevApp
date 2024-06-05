package application;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import jeu.PartieJeu;
import javafx.fxml.FXML;

/**
 * Classe contrôleur associée à la vue de la fenêtre principale.
 * Et des autres scène possible
 * @version 1.1
 */
public class ControlerOptionPartie implements Initializable {
    
    private String[] difficult = {"Normal", "+2 oies"};
    
    /** TODO commenter le rôle du champ (attribut, lien associatif) */
    @FXML
    public TextField pseudo1;

    /** TODO commenter le rôle du champ (attribut, lien associatif) */
    @FXML
    public TextField pseudo2;

    /** TODO commenter le rôle du champ (attribut, lien associatif) */
    @FXML
    public ChoiceBox<String> choiceBoxDifficulte;
    
    @FXML
    private void fenetrePrincipale() {
        // échanger la vue courante avec celle du menu principal
        Main.revenirDebut();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialisation de la ChoiceBox avec des valeurs de difficulté
        if (choiceBoxDifficulte != null) {
            choiceBoxDifficulte.getItems().addAll(difficult);
            choiceBoxDifficulte.setValue("Normal");
        } else {
            System.out.println("merde");
        }
    }

    @FXML
    private void fenetrePartie() {
        if (pseudo1.getText().isBlank() || pseudo2.getText().isBlank()) {
            Alert boiteAlerte = new Alert(Alert.AlertType.WARNING,
                    "Penser a bien avoir 2 pseudos pour les 2 joueurs sinon le jeu est injouable",
                    ButtonType.OK);
            boiteAlerte.setTitle("ATTENTION");
            boiteAlerte.setHeaderText("Tout les champs ne sont pas compléter");
            boiteAlerte.showAndWait();
        } else {
            Main.activerPartie();
        }
    }
}
