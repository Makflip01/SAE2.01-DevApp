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
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.fxml.FXML;
import jeu.Joueur;
import jeu.ModeleJeu;
import jeu.PartieJeu;
import jeu.Pion;
import javafx.scene.Node;

/**
 * Classe contrôleur associée à la vue de la fenêtre principale.
 * Et des autres scène possible
 * @version 1.1
 */
public class ControlerPlateauJeu implements Initializable {
    
    private int x;
    
    private int y;
    
    private ModeleJeu model;
    
    private Image imgRenard = new Image("application/renard.png");
    
    private Image imgOie = new Image("application/oie.png");
    
    private Image imgPoint = new Image("application/indicateur.png");
    
    @FXML
    private GridPane plateau;
    
    @FXML
    private Label pseudoJoueur;
    
    @FXML
    private ControlerPrincipal controlerGeneral;
    
    @FXML
    private void stopProg() {
        // permet de quitter l'application sans appuyer sur la croix de la fenetre
        Alert boiteAlerte = new Alert(Alert.AlertType.WARNING,
                "Confirmez-vous l'arrêt du programme ?",
                ButtonType.YES,
                ButtonType.NO);
        boiteAlerte.setTitle("ATTENTION");
        boiteAlerte.setHeaderText("Vous allez fermer le jeu, êtes-vous sûr ?");
        boiteAlerte.showAndWait();
        
        if (boiteAlerte.getResult() == ButtonType.YES) {
            Main.sortirProgramme();
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        coordonneePions();
        
    }
    
    /** TODO commenter le rôle de cette méthode (SRP)
     * @param pseudoRenard 
     * @param pseudoOie 
     * @param OiesSupplementaires 
     * 
     */
    public void initData(String pseudoRenard, String pseudoOie, boolean OiesSupplementaires) {
        
        model = new ModeleJeu(new PartieJeu(OiesSupplementaires,
                              new Joueur(false, true, pseudoRenard),
                              new Joueur(false, false, pseudoOie)));
        
        changerPseudoJoueur();
        updateView();
        
    }

    /**
     * Cette méthode change le texte du label pseudoJoueur.
     */
    public void changerPseudoJoueur() {
        pseudoJoueur.setText(model.getJoueurActuel().getPseudo());
    }
    
    private void updateView() {

        for (Pion pion : model.getPartie().getPionJeu()) {

            if (pion != null) {

                ImageView affichagePion = new ImageView();

                if (pion.equals(model.getPionSelectionne())) {
                    affichagePion
                    .setEffect(new DropShadow(15, 0, 0,
                            new Color(1, 0, 0, 1)));
                }

                affichagePion.setFitHeight(44.0);
                affichagePion.setFitWidth(46.0);

                if (pion.getEstRenard()) {
                    affichagePion.setImage(imgRenard);
                    
                    if (model.getJoueurActuel().getEstRenard()
                        && model.getPionSelectionne() == null) {
                        
                        affichagePion
                        .setEffect(new DropShadow(15, 0, 0,
                                                  new Color(0, 1, 0, 1)));
                    }

                } else {
                    affichagePion.setImage(imgOie);
                    
                    if (!model.getJoueurActuel().getEstRenard()
                        && model.getPionSelectionne() == null) {
                        
                        affichagePion
                        .setEffect(new DropShadow(15, 0, 0,
                                                  new Color(0, 1, 0, 1)));
                    }
                }

                plateau.add(affichagePion,
                        pion.getAbscisse(),
                        pion.getOrdonnee());
            }
        }
        
        if (model.getPionSelectionne() != null) {
            // cas mettre en valeur les déplacements possibles
            for (int[] deplacement : model.deplacementPossible()) {
                ImageView indicationDeplacement = new ImageView(imgPoint);
                
                indicationDeplacement.setFitHeight(44.0);
                indicationDeplacement.setFitWidth(46.0);
                
                indicationDeplacement
                .setEffect(new DropShadow(15, 0, 0, new Color(0, 0, 1, 1)));
                
                plateau.add(indicationDeplacement,
                            deplacement[0],
                            deplacement[1]);
            }
        }
    }

    /**
     * Cette méthode imprime les coordonnées des pions sur le plateau.
     */
    @FXML
    public void coordonneePions() {
        
        plateau.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->{
            x = (int) e.getX() / 46;
            y = (int) e.getY() / 44;
            
            if (model.getPionSelectionne() == null) {
                model.choixPion(x, y);
            } else {
                model.choixDeplacement(x, y);
            }
            
            plateau.getChildren().clear();
            updateView();
            
            changerPseudoJoueur();
            
            int nbOie = 0;
            for (Pion pion : model.getPartie()
                             .pionsPossibles(model.getPartie()
                                             .getJoueurOie())) {
                if (pion != null) {
                    nbOie++;
                }
            }
            
            if (nbOie < 6) {
                // victoire renard
                Alert boiteAlerte = new Alert(Alert.AlertType.NONE,
                        "Le renard a gagné !",
                        ButtonType.OK);
                boiteAlerte.setTitle("FIN DU JEU");
                boiteAlerte.showAndWait();
                Main.revenirDebut();
            }
            
            if (model.getPionSelectionne() != null
                && model.getJoueurActuel().getEstRenard()
                && model.deplacementPossible().length == 0) {
                //vicoire Oies
                Alert boiteAlerte = new Alert(Alert.AlertType.NONE,
                    "Les oies ont gagné !",
                    ButtonType.OK);
                boiteAlerte.setTitle("FIN DU JEU");
                boiteAlerte.showAndWait();
                Main.revenirDebut();
            }
           
        });
        
        
    }
}
