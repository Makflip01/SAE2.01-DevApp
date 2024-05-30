/*
 * model                            13 mai 2024
 * Cambon Mathias, aucun droit d'auteur
 */

package jeu;

/**
 * Classe permet d'enregistrer les caractéristiques d'un joueur,
 * Si le joueur est un ordinateur, un algorithme prend le relais,
 * Si le joueur est un humain, alors il joue avec un pseudo,
 * qu'il aura préciser avant
 * @author Cambon Mathias
 */
public class Joueur {

    /** Boolean qui indique si IA ou pas */
    private boolean estIA;	
    
    /** Boolean qui indique si joueur est renard ou pas */
    private boolean estRenard;
    
    /** String qui indique le nom de chaque joueur */
    private String pseudo;

    /** 
     * créer un joueur pouvant être un ordinateur ou un utilisateur,
     * le renard ou les oies et possédant un pseudonyme
     * @param estIA si joueur est un ordinateur ou pas
     * @param estRenard si joueur est le renard ou pas
     * @param pseudo indique pseudo du joueur
     */
    public Joueur(boolean estIA, boolean estRenard, String pseudo) {
        this.estIA = estIA;
        this.estRenard = estRenard;
        this.pseudo = pseudo;
    }

    /** 
     * @return true si le joueur est un ordinateur, sinon false
     */
    public boolean getEstIA() {
        return estIA;
    }
    
    /**
     * @return true si le joueur est un renard, sinon false
     */
    public boolean getEstRenard() {
        return estRenard;
    }
    
    /** 
     * Le pseudo peut être vide ou similaire avec son adversaire
     * @return le pseudo de chaque joueur
     */
    public String getPseudo() {
        return pseudo;
    }

}
