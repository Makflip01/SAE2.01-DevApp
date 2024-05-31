/*
 * ModeleJeu.java                                           30 mai 2024
 * IUT Rodez, Info1 2023-2024 groupe TP1, pas de copyrigth
 */
package jeu;

/** TODO commenter les responsabilités de cette classe
 * 
 */
public class ModeleJeu {
    
    private Joueur joueurActuel;
    
    private Pion pionSelectionne;
    
    private PartieJeu partie;

    /**
     * créé un modèle permettant de sélectionner et de déplacer
     * les pions du joueur dont c'et le tour
     * @param partie de jeu gérée par le modèle
     */
    public ModeleJeu(PartieJeu partie) {
        
        this.partie = partie;
        joueurActuel = partie.getJoueurRenard();
    }

    /**
     * @return valeur de joueurActuel
     */
    public Joueur getJoueurActuel() {
        return joueurActuel;
    }

    /**
     * @return valeur de partie
     */
    public PartieJeu getPartie() {
        return partie;
    }

    /**
     * @return valeur de pionSelectionne
     */
    public Pion getPionSelectionne() {
        return pionSelectionne;
    }

    /**
     * passe au joueur suivant et réinitialise le pion sélectionné
     */
    public void finTour() {
        
        
    }

    /**
     * définit le pion sélectionné en fonction des coordonnées
     * @param x abscisse du pion à chercher
     * @param y ordonnée du pion à chercher
     */
    public void choixPion(int x, int y) {
        
        pionSelectionne = null;
        
        for (Pion pion : getPartie().pionsPossibles(joueurActuel)) {
            if (pion.getAbcisse() == x && pion.getOrdonnee() == y) {
                pionSelectionne = pion;
            }
        }
    }
    
    /**
     * déplace le pion sélectionné en fonction des coordonnées
     * @param x abscisse de l'arrivée du déplacement
     * @param y ordonnée de l'arrivée du déplacement
     */
    public void choixDeplacement(int x, int y) {
        
        /*TODO prendre en compte renard mange donc changer PartieJeu
         * pour déplacement par elle au lieu de Pion*/
        try {
            pionSelectionne.deplacement(x, y);
        } catch (IllegalArgumentException e) {
            // pas de déplacement
        }
        
    }
    
}