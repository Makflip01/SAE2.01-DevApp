/*
 * Pion.java                                           17 mai 2024
 * IUT Rodez, Info1 2023-2024 groupe TP1, pas de copyrigth
 */
package jeu;

/**
 * Un pion pouvant être un renard ou une oie et localisé
 * sur le plateau par des coordonnées, seules les coordonnées
 * peuvent êtres modifiées après la création. L'origine correspond
 * au coin en haut à gauche du plateau et l'axe des ordonnées est inversé
 * (considéré comme un rectangle de dimensions inconnues)
 */
public class Pion {
    
    private boolean estRenard;
    
    private int abcisse;
    
    private int ordonnee;
    
    /**
     * pion pouvant être un renard ou une oie et localisé
     * sur le plateau par des coordonnées
     * @param estRenard true si le pion est un renard,
     *                  false si c'est une oie
     * @param abcisse abscisse >= 0 représentant la colonne
     *                du plateau sur laquelle le pion est placé
     * @param ordonnee ordonnée >= 0 représentant la ligne
     *                 du plateau sur laquelle le pion est placé
     * @throws IllegalArguementException si coordonnées invalides
     */
    public Pion(boolean estRenard, int abcisse, int ordonnee) {
        
        if (!coordonneesValides(abcisse, ordonnee)) {
            throw new IllegalArgumentException();
        }
        
        this.estRenard = estRenard;
        this.abcisse = abcisse;
        this.ordonnee = ordonnee;
    }

    /**
     * @param abcisse abscisse >= 0 représentant la colonne
     *                du plateau sur laquelle le pion est placé
     * @param ordonnee ordonnée >= 0 représentant la ligne
     *                 du plateau sur laquelle le pion est placé
     * @return true si les coordonnées sont valides, false sinon
     */
    private static boolean coordonneesValides(int abcisse, int ordonnee) {
        return abcisse >= 0 && ordonnee >= 0;
    }

    /**
     * @return valeur de estRenard
     */
    public boolean getEstRenard() {
        return estRenard;
    }

    /**
     * @return valeur de abcisse
     */
    public int getAbcisse() {
        return abcisse;
    }

    /**
     * @return valeur de ordonnee
     */
    public int getOrdonnee() {
        return ordonnee;
    }
    
    /**
     * déplace le pion aux coordonnées données si elles correspondent
     * à un déplacement possible et si elles sont valides
     * @param x abscisse >= 0 représentant la colonne
     *          du plateau sur laquelle le pion est placé
     * @param y ordonnée >= 0 représentant la ligne
     *          du plateau sur laquelle le pion est placé
     * @throws IllegalArgumentException si coordonnées invalides
     *                                  ou déplacement impossible
     */
    public void deplacement(int x, int y) {
        
        if (!coordonneesValides(x, y)
            || !verifieDeplacementPossible(x, y)) {
            throw new IllegalArgumentException();
        }
        
        this.abcisse = x;
        this.ordonnee = y;
    }
    
    /**
     * vérifie que le déplacement représenté par les coordonnées
     * est possible
     * @param x abscisse >= 0 représentant la colonne
     *          du plateau sur laquelle le pion est placé
     * @param y ordonnée >= 0 représentant la ligne
     *          du plateau sur laquelle le pion est placé
     * @return true si déplacement possible, false sinon
     */
    private boolean verifieDeplacementPossible(int x, int y) {
        
        for (int[] coordonne : deplacementsPossibles()) {
            if (x == coordonne[0] && y == coordonne[1]) {
                return true;
            }
        }
        
        return false;
    }

    /**
     * calcul les coordonnées d'arrivées de déplacement possibles
     * @return une matrice de dimensions (x, 2) dont chaque ligne
     *         correspond à une coordonnée possible de déplacement du pion
     */
    public int[][] deplacementsPossibles() {
        
        int[][] resultat;
        
        int x = getAbcisse();
        
        int y = getOrdonnee();
        
        if (getEstRenard()) {
            resultat = new int[8][2];
            
            resultat[3] = new int[] {x - 1, y - 1};
            resultat[4] = new int[] {x, y - 1};
            resultat[5] = new int[] {x + 1, y - 1};
            resultat[6] = new int[] {x - 1, y + 1};
            resultat[7] = new int[] {x + 1, y + 1};
        } else {
            resultat = new int[3][2];
        }
        
        resultat[0] = new int[] {x + 1, y};
        resultat[1] = new int[] {x - 1, y};
        resultat[2] = new int[] {x, y + 1};
        
        return resultat;
    }
}
