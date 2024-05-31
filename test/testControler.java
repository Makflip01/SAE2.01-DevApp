/* Controleur de la vue principale 05/23
 *
 */
package test;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
/**
 * Classe contrôleur associée à la vue de la fenêtre principale.
 * Et des autres scène possible
 * @author Matthias AJUTO
 * @version 1.1
 *
 */
public class testControler {

	@FXML
	private void sceneOption() {
		// échanger la vue courante avec celle des options
		MenuTest.activerOption();
	}

	@FXML
	private void fenetrePrincipale() {
		// échanger la vue courante avec celle du menu principal
		MenuTest.revenirDebut();
	}

	@FXML
	private void sceneRegle() {
		// échanger la vue courante avec celle des règles
		MenuTest.activerRegle();
	}

	@FXML
	private void sceneOptionPartie() {
		// échanger la vue courante avec celle des options d'avant partie
		MenuTest.activerOptionPartie();
	}

	@FXML
	private void stopProg() {
		// permet de quitter l'application sans appuyer sur la croix de la fenetre
		MenuTest.sortirProgramme();
	}

	@FXML
	private TextField Pseudo1;

	@FXML
	private TextField Pseudo2;

	@FXML
	private String Joueur1;

	@FXML
	private String Joueur2;

	@FXML
	private String Joueur;

	@FXML
	private Label PseudoJoueur;

	/**
	 * Classe permettant d'aller dans la partie de jeu
	 * Vérification de si les 2 pseudo sont présent sinon message d'erreur
	 * TODO Vérifier si la difficulté est sélectionner
	 */
	@FXML
	private void fenetrePartie(){
		Joueur1 = Pseudo1.getText();
		Joueur2 = Pseudo2.getText();
		if(Joueur1.isBlank() || Joueur2.isBlank()) {
			Alert boiteAlerte =
					new Alert(Alert.AlertType.WARNING,
							"Penser a bien avoir 2 pseudos pour les 2 joueurs sinon le jeu est injouable",
							ButtonType.OK);
			boiteAlerte.setTitle("ATTENTION");
			boiteAlerte.setHeaderText("Tout les champs ne sont pas compléter");
			boiteAlerte.showAndWait();
		} else {
			MenuTest.activerPartie();
			Joueur = Joueur1;
		}
	}

	@FXML
	private void changerJoueur() {
		if(Joueur == Joueur1) {
			Joueur = Joueur2;
			PseudoJoueur.setText(Joueur);
			System.out.print(Joueur);
		} else if(Joueur == Joueur2) {
			Joueur = Joueur1;
			PseudoJoueur.setText(Joueur);
			System.out.print(Joueur);
		}
	}
}