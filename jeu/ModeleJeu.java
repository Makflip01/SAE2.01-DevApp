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
        
        pionSelectionne = null;
        
        if (getJoueurActuel().getEstRenard()) {
            joueurActuel = getPartie().getJoueurOie();
        } else {
            joueurActuel = getPartie().getJoueurRenard();
        }
    }

    /**
     * définit le pion sélectionné en fonction des coordonnées
     * @param x abscisse du pion à chercher
     * @param y ordonnée du pion à chercher
     */
    public void choixPion(int x, int y) {
        
        pionSelectionne = null;
        
        Pion[] test = getPartie().pionsPossibles(joueurActuel);
        
        for (Pion pion : getPartie().pionsPossibles(joueurActuel)) {
            if (pion != null && pion.getAbscisse() == x
                && pion.getOrdonnee() == y) {
                System.out.println(pion.getAbscisse() + " " + pion.getOrdonnee());
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
        
        boolean sautRenard;
        boolean oieAManger;
        
        int indicePionSuppr;
        
        Pion[] pionPartie;
        
        sautRenard = Math.abs(x - pionSelectionne.getAbscisse()) >= 2
                   || Math.abs(y - pionSelectionne.getOrdonnee()) >= 2;
     
        oieAManger = false;
        
        indicePionSuppr = 0;
        
        pionPartie = getPartie().getPionJeu();
        for (int i = 0 ; i < pionPartie.length ; i++) {
            
            if (sautRenard && !oieAManger) {
                oieAManger = pionPartie[i] != null
                           && pionPartie[i].getAbscisse()
                              == (x + pionSelectionne.getAbscisse()) / 2
                           && pionPartie[i].getOrdonnee()
                              == (y + pionSelectionne.getOrdonnee()) / 2;
                
                // sauvegarde oie à manger
                if (oieAManger) {
                    indicePionSuppr = i;
                }
            }
        }
        
        if (verifiePosition(new int[] {x, y})) {
            try {
                
                pionSelectionne.deplacement(x, y);
                
                if (!oieAManger) {
                    finTour();
                } else {
                    getPartie().getPionJeu()[indicePionSuppr] = null;
                }
            } catch (IllegalArgumentException e) {
                // pas de déplacement
            }
        }
    }
    
    /**
     * calcul tous les déplacements possibles du pion sélectionné
     * en prenant en compte la forme du plateau, les autres pions,
     * le saut du renard quand il mange une oie et les
     * déplacements différents des oies et du renard.
     * @return une matrice d'entiers de dimensions
     *         (nombre de déplacements possibles, 2)
     *         représentant tous les déplacements possibles
     */
    public int[][] deplacementPossible() {
        
        int[][] resultat;
        
        int[][] deplacementPion;
        
        int[] indiceDeplacementValide;
        
        indiceDeplacementValide = new int[8];
        
        deplacementPion = getPionSelectionne().deplacementsPossibles();
        
        int indiceValide = 0;
        for (int indice = 0 ; indice < deplacementPion.length ; indice++) {
            if (verifiePosition(deplacementPion[indice])) {
                indiceDeplacementValide[indiceValide] = indice;
                indiceValide++;
            }
        }
        
        resultat = new int[indiceValide][2];
        for (int indice = 0 ;
             indice < indiceValide ;
             indice++) {
            
            resultat[indice] = deplacementPion[indiceDeplacementValide[indice]];
            
        }
        
        return resultat; //stub
    }

    /** TODO commenter le rôle de cette méthode (SRP)
     * @param position
     * @return
     */
    private boolean verifiePosition(int[] position) {
        // TODO Auto-generated method stub
        
        int x;
        int y;
        
        boolean placeLibre;
        boolean sautRenard;
        boolean oieAManger;
        
        Pion deplacementFutur;
        
        Pion[] pionPartie;
        
        x = position[0];
        y = position[1];
                
        placeLibre = true;
        
        sautRenard = Math.abs(x - pionSelectionne.getAbscisse()) >= 2
                   || Math.abs(y - pionSelectionne.getOrdonnee()) >= 2;
     
        oieAManger = false;
        
        deplacementFutur = new Pion(pionSelectionne.getEstRenard(), x, y);
        
        pionPartie = getPartie().getPionJeu();
        for (int i = 0 ; i < pionPartie.length ; i++) {
            
            placeLibre = placeLibre && (pionPartie[i] == null
                         || (deplacementFutur.getAbscisse()
                             != pionPartie[i].getAbscisse()
                             || deplacementFutur.getOrdonnee()
                                != pionPartie[i].getOrdonnee()));
            
            if (sautRenard && !oieAManger) {
                oieAManger = pionPartie[i] != null
                           && pionPartie[i].getAbscisse()
                              == (x + pionSelectionne.getAbscisse()) / 2
                           && pionPartie[i].getOrdonnee()
                              == (y + pionSelectionne.getOrdonnee()) / 2;
                
            }
        }
        
        return placeLibre && (!sautRenard || oieAManger)
               && getPartie().getPlateau()[x][y];
    }
}