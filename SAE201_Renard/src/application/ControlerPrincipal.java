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
public class ControlerPrincipal implements Initializable {
    
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
    public void initialize(URL location, ResourceBundle resources) {
    }


}
