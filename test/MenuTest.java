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
 * Au lancement de l'application, la vue principale contient 3 boutons :
 * le lancement du jeu, option, règle du jeu.
 * Selon le bouton cliqué, une scène différente prend la place de la vue principale :
 * soit celle du lancement du jeu, soit celle des options,
 * soit celle des règles du jeu.
 * Sur chacune de ces 4 vues, il y a un bouton retour permettant d'afficher à
 * nouveau la vue principale
 * @author Matthias AJUTO
 * @version 1.1
 *
 */
public class MenuTest extends Application {
	/** Scène principale de l'application, celle qui contient les 3 boutons */
	private static Scene scenePrincipale;
	
	/** Scène permettant de gérer les option */
	private static Scene sceneOption;
	
	/** Scène permettant de regarder les règles */
	private static Scene sceneRegle;
	
	/** Scène permettant de gérer les option de la partie */
	private static Scene sceneOptionPartie;
	
	/** Scène permettant d'accéder à la partie */
	private static Scene scenePartie;
	
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
	
	/**
	 * Permet de modifier la scène de la fenêtre principale
	 * pour qu'elle devienne la scène des règles du jeu
	 * pour que le joueur apprene comment jouer
	 */
	public static void activerRegle() {
		fenetrePrincipale.setScene(sceneRegle);
	}
	
	/**
	 * Permet de modifier la scène de la fenêtre principale
	 * pour qu'elle devienne la scène des options de partie
	 * avant de commençer le jeu
	 */
	public static void activerOptionPartie() {
		fenetrePrincipale.setScene(sceneOptionPartie);
	}
	
	/**
	 * Permet de modifier toute les scènes sauf celle 
	 * de la scène principale principale
	 * pour qu'elle deviennent la scène principale
	 */
	public static void revenirDebut() {
		fenetrePrincipale.setScene(scenePrincipale);
	}
	
	/**
	 * Permet de modifier la scène de la fenêtre principale
	 * pour qu'elle devienne la scène des options de partie
	 * avant de commençer le jeu
	 */
	public static void activerPartie() {
		fenetrePrincipale.setScene(scenePartie);
	}
	
	/**
	 * Attribuer sur un bouton pour lançer la fermeture du programme
	 * sans que l'utilisateur appuie sur la croix.
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
			primaryStage.setTitle("Le Jeu de l'oie et du Renard");
			
			/*
			 * Chargement de la vue des options et
			 * création de la scène associée à cette vue
			 */
			FXMLLoader chargeurFXMLOption = new FXMLLoader();
			chargeurFXMLOption.setLocation(getClass().getResource("testOption.fxml"));
			conteneur = chargeurFXMLOption.load();
			sceneOption = new Scene(conteneur, 600, 400);
			
			/*
			 * Chargement de la vue des règles du jeu et
			 * création de la scène associée à cette vue
			 */
			FXMLLoader chargeurFXMLRegle = new FXMLLoader();
			chargeurFXMLRegle.setLocation(getClass().getResource("regle.fxml"));
			conteneur = chargeurFXMLRegle.load();
			sceneRegle = new Scene(conteneur, 600, 400);
			
			/*
			 * Chargement de la vue des options de partie et
			 * création de la scène associée à cette vue
			 */
			FXMLLoader chargeurFXMLOptionPartie = new FXMLLoader();
			chargeurFXMLOptionPartie.setLocation(getClass().getResource("testOptionPartie.fxml"));
			conteneur = chargeurFXMLOptionPartie.load();
			sceneOptionPartie = new Scene(conteneur, 600, 400);
			
			/*
			 * Chargement de la vue des options de partie et
			 * création de la scène associée à cette vue
			 */
			FXMLLoader chargeurFXMLPartie = new FXMLLoader();
			chargeurFXMLPartie.setLocation(getClass().getResource("PlateauJeu.fxml"));
			conteneur = chargeurFXMLPartie.load();
			scenePartie = new Scene(conteneur, 600, 400);
			
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