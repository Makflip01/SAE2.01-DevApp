/* Controleur de la vue principale 05/23
 *
 */
package application;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import jeu.ModeleJeu;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
/**
 * Classe contrôleur associée à la vue de la fenêtre principale.
 * Et des autres scène possible
 * @author Matthias AJUTO
 * @version 1.1
 *
 */
public class Controler  implements Initializable {

        @FXML
        private void sceneOption() {
                // échanger la vue courante avec celle des options
                Menu.activerOption();
        }

        @FXML
        private void fenetrePrincipale() {
                // échanger la vue courante avec celle du menu principal
            Menu.revenirDebut();
        }

        @FXML
        private void sceneRegle() {
                // échanger la vue courante avec celle des règles
            Menu.activerRegle();
        }

        @FXML
        private void sceneOptionPartie() {
                // échanger la vue courante avec celle des options d'avant partie
            Menu.activerOptionPartie();
        }

        @FXML
        private void stopProg() {
                // permet de quitter l'application sans appuyer sur la croix de la fenetre
            Menu.sortirProgramme();
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
        private String Joueur = Joueur1;

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
                    Menu.activerPartie();
                        coordonneePions();
                        //TODO changer le pseudo suivant a qui c'est le tour
                        Joueur = Joueur1;
                        changerPseudoJoueur();
                }
        }
        
        @FXML
        private ChoiceBox<String> choiceBoxDifficulté;
        
        private String[] Difficult = {"Normal", "+2 oies" };

            @Override
            public void initialize(URL arg0, ResourceBundle arg1) {
                if (choiceBoxDifficulté != null) {
                    choiceBoxDifficulté.getItems().addAll(Difficult);
                    
                } 
            }
            
            /** TODO commenter le rôle de cette méthode (SRP)
             * @param event
             */
            public void getDifficult(ActionEvent event) {
                
                String myDifficult = choiceBoxDifficulté.getValue();
                //Utilisé myDifficult pour changer les points du plateau
                
            }

        @FXML
        //TODO changer le pseudo suivant a qui c'est le tour
        private void changerJoueur() {
                if(Joueur == Joueur1) {
                        Joueur = Joueur2;
                        changerPseudoJoueur();
                        System.out.println(Joueur);
                } else {
                        Joueur = Joueur1;
                        changerPseudoJoueur();
                        System.out.println(Joueur);
                }
        }

        /** TODO commenter le rôle de cette méthode (SRP)
         * 
         */
        public void changerPseudoJoueur() {
                PseudoJoueur.setText(Joueur);
        }

        @FXML
        private static GridPane plateau;

        /** TODO commenter le rôle de cette méthode (SRP)
         * 
         */
        @FXML
        public void coordonneePions() {
                // Récupérer les coordonnées du bouton "bouton1"
                Button bouton1 = (Button) plateau.lookup("#pion1");
                double posX1 = bouton1.getLayoutX();
                double posY1 = bouton1.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton1"
                Button bouton2 = (Button) plateau.lookup("#pion2");
                double posX2 = bouton2.getLayoutX();
                double posY2 = bouton2.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton1"
                Button bouton3 = (Button) plateau.lookup("#pion3");
                double posX3 = bouton3.getLayoutX();
                double posY3 = bouton3.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton1"
                Button bouton4 = (Button) plateau.lookup("#pion4");
                double posX4 = bouton4.getLayoutX();
                double posY4 = bouton4.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton1"
                Button bouton5 = (Button) plateau.lookup("#pion5");
                double posX5 = bouton1.getLayoutX();
                double posY5 = bouton5.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton6"
                Button bouton6 = (Button) plateau.lookup("#pion6");
                double posX6 = bouton6.getLayoutX();
                double posY6 = bouton6.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton7"
                Button bouton7 = (Button) plateau.lookup("#pion7");
                double posX7 = bouton7.getLayoutX();
                double posY7 = bouton7.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton8"
                Button bouton8 = (Button) plateau.lookup("#pion8");
                double posX8 = bouton8.getLayoutX();
                double posY8 = bouton8.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton9"
                Button bouton9 = (Button) plateau.lookup("#pion9");
                double posX9 = bouton9.getLayoutX();
                double posY9 = bouton9.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton10"
                Button bouton10 = (Button) plateau.lookup("#pion10");
                double posX10 = bouton10.getLayoutX();
                double posY10 = bouton10.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton11"
                Button bouton11 = (Button) plateau.lookup("#pion11");
                double posX11 = bouton11.getLayoutX();
                double posY11 = bouton11.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton12"
                Button bouton12 = (Button) plateau.lookup("#pion12");
                double posX12 = bouton12.getLayoutX();
                double posY12 = bouton12.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton13"
                Button bouton13 = (Button) plateau.lookup("#pion13");
                double posX13 = bouton13.getLayoutX();
                double posY13 = bouton13.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton14"
                Button bouton14 = (Button) plateau.lookup("#pion14");
                double posX14 = bouton14.getLayoutX();
                double posY14 = bouton14.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton15"
                Button bouton15 = (Button) plateau.lookup("#pion15");
                double posX15 = bouton15.getLayoutX();
                double posY15 = bouton15.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton16"
                Button bouton16 = (Button) plateau.lookup("#pion16");
                double posX16 = bouton16.getLayoutX();
                double posY16 = bouton16.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton17"
                Button bouton17 = (Button) plateau.lookup("#pion17");
                double posX17 = bouton17.getLayoutX();
                double posY17 = bouton17.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton18"
                Button bouton18 = (Button) plateau.lookup("#pion18");
                double posX18 = bouton18.getLayoutX();
                double posY18 = bouton18.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton19"
                Button bouton19 = (Button) plateau.lookup("#pion19");
                double posX19 = bouton19.getLayoutX();
                double posY19 = bouton19.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton20"
                Button bouton20 = (Button) plateau.lookup("#pion20");
                double posX20 = bouton20.getLayoutX();
                double posY20 = bouton20.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton21"
                Button bouton21 = (Button) plateau.lookup("#pion21");
                double posX21 = bouton21.getLayoutX();
                double posY21 = bouton21.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton22"
                Button bouton22 = (Button) plateau.lookup("#pion22");
                double posX22 = bouton22.getLayoutX();
                double posY22 = bouton22.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton23"
                Button bouton23 = (Button) plateau.lookup("#pion23");
                double posX23 = bouton23.getLayoutX();
                double posY23 = bouton23.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton24"
                Button bouton24 = (Button) plateau.lookup("#pion24");
                double posX24 = bouton24.getLayoutX();
                double posY24 = bouton24.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton25"
                Button bouton25 = (Button) plateau.lookup("#pion25");
                double posX25 = bouton25.getLayoutX();
                double posY25 = bouton25.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton26"
                Button bouton26 = (Button) plateau.lookup("#pion26");
                double posX26 = bouton26.getLayoutX();
                double posY26 = bouton26.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton27"
                Button bouton27 = (Button) plateau.lookup("#pion27");
                double posX27 = bouton27.getLayoutX();
                double posY27 = bouton27.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton28"
                Button bouton28 = (Button) plateau.lookup("#pion28");
                double posX28 = bouton28.getLayoutX();
                double posY28 = bouton28.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton29"
                Button bouton29 = (Button) plateau.lookup("#pion29");
                double posX29 = bouton29.getLayoutX();
                double posY29 = bouton29.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton30"
                Button bouton30 = (Button) plateau.lookup("#pion30");
                double posX30 = bouton30.getLayoutX();
                double posY30 = bouton30.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton31"
                Button bouton31 = (Button) plateau.lookup("#pion31");
                double posX31 = bouton31.getLayoutX();
                double posY31 = bouton31.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton32"
                Button bouton32 = (Button) plateau.lookup("#pion32");
                double posX32 = bouton32.getLayoutX();
                double posY32 = bouton32.getLayoutY();

                // Récupérer les coordonnées du bouton "bouton33"
                Button bouton33 = (Button) plateau.lookup("#pion33");
                double posX33 = bouton33.getLayoutX();
                double posY33 = bouton33.getLayoutY();
                
                System.out.println("Coordonnees du pion1 : X: " + posX1 + ", Y: " + posY1);
                System.out.println("Coordonnees du pion1 : X: " + posX2 + ", Y: " + posY2);
                System.out.println("Coordonnees du pion1 : X: " + posX3 + ", Y: " + posY3);
                System.out.println("Coordonnees du pion1 : X: " + posX4 + ", Y: " + posY4);
                System.out.println("Coordonnees du pion1 : X: " + posX5 + ", Y: " + posY5);
                System.out.println("Coordonnees du pion1 : X: " + posX6 + ", Y: " + posY6);
                System.out.println("Coordonnees du pion1 : X: " + posX7 + ", Y: " + posY7);
                System.out.println("Coordonnees du pion1 : X: " + posX8 + ", Y: " + posY8);
                System.out.println("Coordonnees du pion1 : X: " + posX9 + ", Y: " + posY9);
                System.out.println("Coordonnees du pion1 : X: " + posX10 + ", Y: " + posY10);
                System.out.println("Coordonnees du pion1 : X: " + posX11 + ", Y: " + posY11);
                System.out.println("Coordonnees du pion1 : X: " + posX12 + ", Y: " + posY12);
                System.out.println("Coordonnees du pion1 : X: " + posX13 + ", Y: " + posY13);
                System.out.println("Coordonnees du pion1 : X: " + posX14 + ", Y: " + posY14);
                System.out.println("Coordonnees du pion1 : X: " + posX15 + ", Y: " + posY15);
                System.out.println("Coordonnees du pion1 : X: " + posX16 + ", Y: " + posY16);
                System.out.println("Coordonnees du pion1 : X: " + posX17 + ", Y: " + posY17);
                System.out.println("Coordonnees du pion1 : X: " + posX18 + ", Y: " + posY18);
                System.out.println("Coordonnees du pion1 : X: " + posX19 + ", Y: " + posY19);
                System.out.println("Coordonnees du pion1 : X: " + posX20 + ", Y: " + posY20);
                System.out.println("Coordonnees du pion1 : X: " + posX21 + ", Y: " + posY21);
                System.out.println("Coordonnees du pion1 : X: " + posX22 + ", Y: " + posY22);
                System.out.println("Coordonnees du pion1 : X: " + posX23 + ", Y: " + posY23);
                System.out.println("Coordonnees du pion1 : X: " + posX24 + ", Y: " + posY24);
                System.out.println("Coordonnees du pion1 : X: " + posX25 + ", Y: " + posY25);
                System.out.println("Coordonnees du pion1 : X: " + posX26 + ", Y: " + posY26);
                System.out.println("Coordonnees du pion1 : X: " + posX27 + ", Y: " + posY27);
                System.out.println("Coordonnees du pion1 : X: " + posX28 + ", Y: " + posY28);
                System.out.println("Coordonnees du pion1 : X: " + posX29 + ", Y: " + posY29);
                System.out.println("Coordonnees du pion1 : X: " + posX30 + ", Y: " + posY30);
                System.out.println("Coordonnees du pion1 : X: " + posX31 + ", Y: " + posY31);
                System.out.println("Coordonnees du pion1 : X: " + posX32 + ", Y: " + posY32);
                System.out.println("Coordonnees du pion1 : X: " + posX33 + ", Y: " + posY33);
        }
}