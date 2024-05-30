/* Controleur de la vue principale 05/23
 *
 */
package test;
import javafx.fxml.FXML;
/**
 * Classe contrôleur associée à la vue de la fenêtre principale.
 * La vue est dotée de 2 boutons :
 * - addition => permet de modifier la vue,
 * c'est celle de l'addition qui s'affiche
 * - soustraction => permet de modifier la vue,
 * c'est celle de la soustraction qui s'affiche
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
	
}