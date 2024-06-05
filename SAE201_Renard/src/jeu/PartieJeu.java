/*
 * PartieJeu.java                                           24 mai 2024
 * IUT Rodez, Info1 2023-2024 groupe TP1, pas de copyrigth
 */
package jeu;

/** TODO commenter les responsabilités de cette classe
 * 
 */
public class PartieJeu {
    
    final static int NOMBRE_MAX_PION = 20;
    
    Pion[] pionJeu;
    boolean[][] plateau;
    Joueur joueurRenard;
    Joueur joueurOie;
    
    /** créer une partie, avec une certaine difficulté,
     * avec deux joueurs
     * @param oiesSupplementaires si joueur souhaite plus d'oie sur le plateau
     * @param joueurRenard est joueur jouant le renard
     * @param joueurOie est joueur jouant les oies
     * @throws IllegalArgumentException si le premier joueur n'est pas un renard, 
     *                                  ou si le second n'est pas une oie
     */
    public PartieJeu(boolean oiesSupplementaires, Joueur joueurRenard, Joueur joueurOie) 
            throws IllegalArgumentException {
        
        if(!joueurRenard.getEstRenard() || joueurOie.getEstRenard()) {
            throw new IllegalArgumentException();
        }
        this.joueurRenard = joueurRenard;
        this.joueurOie = joueurOie;
        
        this.pionJeu = new Pion[NOMBRE_MAX_PION];
        
        //créer le plateau
        this.plateau = new boolean[7][7];

        for (int numLigne = 0 ; numLigne < 7 ; numLigne++) {
            this.plateau[numLigne][2] = true;
            this.plateau[numLigne][3] = true;
            this.plateau[numLigne][4] = true;
            
            if (numLigne > 1 && numLigne < 5) {
                this.plateau[numLigne][0] = true;
                this.plateau[numLigne][1] = true;
                this.plateau[numLigne][5] = true;
                this.plateau[numLigne][6] = true;
            }
        }
        
        // remplir notre plateau des pions initiaux
        int indicePion = 0;
        for (int numLigne = 0 ; numLigne < 3 ; numLigne++) {
            for (int numCol = 0 ; numCol < 7 ; numCol++) {
                
                if (plateau[numLigne][numCol]) {
                    this.pionJeu[indicePion] = new Pion(false, numCol, numLigne);
                    indicePion++;
                }
            }
        }
        
        if (oiesSupplementaires) {
            this.pionJeu[indicePion] = new Pion(false, 0, 3);
            this.pionJeu[indicePion + 1] = new Pion(false, 6, 3);
            indicePion += 2;
        }
        
        this.pionJeu[indicePion] = new Pion (true, 3, 5);
    }
  
    /** 
     * @param joueur 
     * @return pions disponible pour un joueur dans un tableau
     *         de taille NOMBRE_MAX_PION
     */
    public Pion[] pionsPossibles(Joueur joueur) {
        Pion[] tableauPion = new Pion[NOMBRE_MAX_PION];
        
        int indicePion = 0;
        for (int indiceParcours = 0 ;
             indiceParcours < pionJeu.length;
             indiceParcours++) {
            
            if (pionJeu[indiceParcours] != null
                && joueur.getEstRenard()
                   == pionJeu[indiceParcours].getEstRenard()) {
                
                tableauPion[indicePion] = pionJeu[indiceParcours];
                indicePion++;
            }
        }
        return tableauPion;
    }

    /**
     * @return tous les pions dans la partie
     */
    public Pion[] getPionJeu() {
        return pionJeu;
    }

    /**
     * @return le plateau de jeu
     */
    public boolean[][] getPlateau() {
        return plateau;
    }

    /**
     * @return le joueur jouant le renard
     */
    public Joueur getJoueurRenard() {
        return joueurRenard;
    }

    /**
     * @return le joueur jouant les oies
     */
    public Joueur getJoueurOie() {
        return joueurOie;
    }
}
