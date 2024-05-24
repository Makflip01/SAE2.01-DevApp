/*
 * Classe principale de l'application permettant d'afficher des fenêtres au contenu
 * différent : addition, soustraction ... (ce sont les vues qui changent)
 */
package test;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
/**
 * Cette classe est la classe principale de l'application permettant à l'utilisateur
 * d'effectuer plusieurs calculs via des vues différentes.
 * Le but est d'illustrer comment changer la scène associée associée à la fenêtre
 * principale.
 *
 * Au lancement de l'application, la vue principale contient 2 boutons : addition
 * et soustraction.
 * Selon le bouton cliqué, une scène différente prend la place de la vue principale :
 * soit celle de l'addition, soit celle de la soustraction.
 * Sur chacune de ces 2 vues, il y a un bouton retour permettant d'afficher à
 * nouveau la vue principale
 * @author Ajuto Matthias
 * @version 1.0
 *
 */
public class MenuTest extends Application {
	/** Scène principale de l'application, celle qui contient les 2 boutons */
	private static Scene scenePrincipale;
	
	/** Scène permettant de gérer les options */
	private static Scene sceneOption;
	
	/** Scène permettant de visualiser les règles du jeu */
	private static Scene sceneRegle;
	
	/** Scène permettant de visualiser le plateau de jeux pour y jouer dessus*/
	private static Scene scenePlateau;
	
	/** Scène permettant de gérer les options de partie */
	private static Scene sceneOptionPartie;
	
	/** Fenêtre principale de l'application
	 * La scène qui lui est associée sera modifiée en fonction
	 * des clics de l'utilisateur
	 */
	private static Stage fenetrePrincipale;
	
	/**
	 * Permet de modifier la scène de la fenêtre principale
	 * pour qu'elle devienne celle des options
	 */
	public static void activerOption() {
		fenetrePrincipale.setScene(sceneOption);
	}
	
	public static void desactiverOption() {
		fenetrePrincipale.setScene(scenePrincipale);
	}
	
	public static void activerRegle() {
		fenetrePrincipale.setScene(sceneRegle);
	}
	
	public static void activerPlateau() {
		fenetrePrincipale.setScene(scenePlateau);
	}
	
	public static void activerOptionPartie() {
		fenetrePrincipale.setScene(sceneOptionPartie);
	}
	
	/**
	 * Classe permettant l'apparition d'une pop-up de sauvegarde quand on veut
	 * quitter la partie a partir du bouton sur plateauJeu.fxml
	 */
	public static void sauvegardePartieQuitter() {
		//TODO pop-up pour la sauvegarde pour quitter la partie
	}
	
	/**
	 * Classe permettant d'arrêter le programme en cours
	 * Pour éviter de le fermer avec la croix de la fenêtre
	 */
	public static void sortirProgramme() {
		System.exit(0);
	}
	
	/**
	 * Permet de modifier la scène de la fenêtre principale
	 * pour qu'elle devienne la scène principale, celle qui
	 * affiche les bouton du menu
	 */
	public static void activerPrincipale() {
		fenetrePrincipale.setScene(scenePrincipale);
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			/*
			 * chargement de la vue de la scène principale dans le conteneur
			 * de type Parent
			 */
			FXMLLoader chargeurFXML = new FXMLLoader();
			chargeurFXML.setLocation(getClass().getResource("testBuilder.fxml"));
			Parent conteneur = chargeurFXML.load();
			/*
			 * Création de la scène principale
			 */
			scenePrincipale = new Scene(conteneur, 600, 400);
			
			/*
			 * Chargement de la vue des option et
			 * création de la scène associée à cette vue
			 */
			FXMLLoader chargeurFXMLOption = new FXMLLoader();
			chargeurFXMLOption.setLocation(getClass().getResource("testOption.fxml"));
			conteneur = chargeurFXMLOption.load();
			sceneOption = new Scene(conteneur, 600, 400);
			
			/*
			 * Chargement de la vue des option et
			 * création de la scène associée à cette vue
			 */
			FXMLLoader chargeurFXMLRegle = new FXMLLoader();
			chargeurFXMLRegle.setLocation(getClass().getResource("regle.fxml"));
			conteneur = chargeurFXMLRegle.load();
			sceneRegle = new Scene(conteneur, 600, 400);
			
			/*
			 * Chargement de la vue des option et
			 * création de la scène associée à cette vue
			 */
			FXMLLoader chargeurFXMLPlateau = new FXMLLoader();
			chargeurFXMLPlateau.setLocation(getClass().getResource("plateauJeu.fxml"));
			conteneur = chargeurFXMLPlateau.load();
			scenePlateau = new Scene(conteneur, 600, 400);
			
			/*
			 * Chargement de la vue des option et
			 * création de la scène associée à cette vue
			 */
			FXMLLoader chargeurFXMLOptionPartie = new FXMLLoader();
			chargeurFXMLOptionPartie.setLocation(getClass().getResource("testOptionPartie.fxml"));
			conteneur = chargeurFXMLOptionPartie.load();
			sceneOptionPartie = new Scene(conteneur, 600, 400);
			/*
			 * on associe la scène principale à la fenêtre principale
			 * Cette dernière est stockée en tant qu'attribut afin d'être accessible
			 * dans les méthodes activer... Celles qui permettent de rendre active
			 * l'une des 3 scènes
			 */
			primaryStage.setScene(scenePrincipale);
			fenetrePrincipale = primaryStage;
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Programme principal
	 * @param args non utilisé
	 */
	public static void main(String[] args) {
		launch(args);
	}
}