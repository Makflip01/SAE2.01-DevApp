package application;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import jeu.ModeleJeu;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.fxml.FXML;

/**
 * Classe contrôleur associée à la vue de la fenêtre principale.
 * Et des autres scène possible
 * @author Matthias AJUTO
 * @version 1.1
 *
 */
public class Controler implements Initializable {
    
    @FXML
    private TextField pseudo1;

    @FXML
    private TextField pseudo2;

    @FXML
    private String joueur1;

    @FXML
    private String joueur2;

    @FXML
    private ChoiceBox<String> choiceBoxDifficulté;

    @FXML
    private GridPane plateau;
    
    @FXML
    private Label pseudoJoueur;

    private String[] difficult = {"Normal", "+2 oies"};
    
    @FXML
    private void sceneOption() {
        // échanger la vue courante avec celle des options
        Main.activerOption();
    }

    @FXML
    private void fenetrePrincipale() {
        // échanger la vue courante avec celle du menu principal
        Main.revenirDebut();
    }

    @FXML
    private void sceneRegle() {
        // échanger la vue courante avec celle des règles
        Main.activerRegle();
    }

    @FXML
    private void sceneOptionPartie() {
        // échanger la vue courante avec celle des options d'avant partie
        Main.activerOptionPartie();
    }

    @FXML
    private void stopProg() {
        // permet de quitter l'application sans appuyer sur la croix de la fenetre
        Main.sortirProgramme();
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        if (choiceBoxDifficulté != null) {
            choiceBoxDifficulté.getItems().addAll(difficult);
        }
    }

    @FXML
    private void fenetrePartie() {
    	System.out.print("aaaaa");
        joueur1 = pseudo1.getText();
        joueur2 = pseudo2.getText();
        if (joueur1.isBlank() || joueur2.isBlank()) {
            Alert boiteAlerte = new Alert(Alert.AlertType.WARNING,
                    "Penser a bien avoir 2 pseudos pour les 2 joueurs sinon le jeu est injouable",
                    ButtonType.OK);
            boiteAlerte.setTitle("ATTENTION");
            boiteAlerte.setHeaderText("Tout les champs ne sont pas compléter");
            boiteAlerte.showAndWait();
        } else {
            Main.activerPartie();
            coordonneePions();
            changerPseudoJoueur();
        }
    }

    public void getDifficult(ActionEvent event) {
        String myDifficult = choiceBoxDifficulté.getValue();
        // Utilisé myDifficult pour changer les points du plateau
    }

    public void changerPseudoJoueur() {
        pseudoJoueur.setText("test");
        pseudoJoueur.autosize();
    }

    @FXML
    public void coordonneePions() {
        if (plateau != null) {
            for (int i = 1; i <= 33; i++) {
                Button bouton = (Button) plateau.lookup("#pion" + i);
                if (bouton != null) {
                    double posX = bouton.getLayoutX();
                    double posY = bouton.getLayoutY();
                    System.out.println("Coordonnees du pion" + i + " : X: " + posX + ", Y: " + posY);
                }
            }
        }
    }
}
