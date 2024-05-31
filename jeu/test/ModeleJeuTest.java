/*
 * ModeleJeuTest.java                                           30 mai 2024
 * IUT Rodez, Info1 2023-2024 groupe TP1, pas de copyrigth
 */
package jeu.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jeu.Joueur;
import jeu.ModeleJeu;
import jeu.PartieJeu;
import jeu.Pion;

/** TODO commenter les responsabilités de cette classe
 * 
 */
class ModeleJeuTest {
    
    private Joueur renard = new Joueur(false, true, "renard");
    
    private Joueur oie = new Joueur(false, false, "oie");
    
    private PartieJeu partie = new PartieJeu(false, renard, oie);
    
    private ModeleJeu modele = new ModeleJeu(partie);
    
    /**
     * Test method for {@link jeu.ModeleJeu#ModeleJeu(jeu.PartieJeu)}.
     */
    @Test
    void testModeleJeu() {
        
        Joueur renard = new Joueur(false, true, "renard");
        
        Joueur oie = new Joueur(false, false, "oie");
        
        assertDoesNotThrow(
            ()-> new ModeleJeu(new PartieJeu(false, renard, oie)));
        
    }

    /**
     * Test method for {@link jeu.ModeleJeu#getJoueurActuel()}.
     */
    @Test
    void testGetJoueurActuel() {
        assertEquals(renard, modele.getJoueurActuel());
    }

    /**
     * Test method for {@link jeu.ModeleJeu#getPartie()}.
     */
    @Test
    void testGetPartie() {
        assertEquals(partie, modele.getPartie());
    }

    /**
     * Test method for {@link jeu.ModeleJeu#getPionSelectionne()}.
     */
    @Test
    void testGetPionSelectionne() {
        assertEquals(null, modele.getPionSelectionne());
    }

    /**
     * Test method for {@link jeu.ModeleJeu#finTour()}.
     */
    @Test
    void testFinTour() {
        
        assertEquals(renard, modele.getJoueurActuel());
        modele.finTour();
        assertEquals(oie, modele.getJoueurActuel());
        
        modele.choixPion(3, 5);
        assertEquals(null, modele.getPionSelectionne());
        
        modele.finTour();
        modele.choixPion(3, 5);
        assertEquals(new Pion(true, 3, 5), modele.getPionSelectionne());
        
    }

    /**
     * Test method for {@link jeu.ModeleJeu#choixPion(int, int)}.
     */
    @Test
    void testChoixPion() {
        modele.choixPion(3, 5);
        assertEquals(new Pion(true, 3, 5), modele.getPionSelectionne());
    }

    /**
     * Test method for {@link jeu.ModeleJeu#choixDeplacement(int, int)}.
     */
    @Test
    void testChoixDeplacement() {
        modele.choixPion(3, 5);
        modele.choixDeplacement(4, 4);
        assertEquals(null, modele.getPionSelectionne()); //test fin tour
        
        modele.choixPion(3, 2);
        modele.choixDeplacement(3, 3);
        
        modele.choixPion(4, 4);
        //test déplacement renard
        assertEquals(new Pion(true, 4, 4), modele.getPionSelectionne());
        
        modele.choixDeplacement(2, 2);
        //test déplacement impossible
        assertEquals(new Pion(true, 4, 4), modele.getPionSelectionne());
        
        modele.choixDeplacement(4, 3);
        
        modele.choixPion(3, 3);
        //test déplacement oie
        assertEquals(new Pion(false, 3, 3), modele.getPionSelectionne());
        modele.finTour();
        
        modele.choixPion(4, 3);
        modele.choixDeplacement(2, 3);
        //test saut renard
        assertEquals(new Pion(true, 2, 3), modele.getPionSelectionne());
        modele.finTour();
        
        modele.choixPion(3, 3);
        //test oie mangée
        assertEquals(null, modele.getPionSelectionne());
        
        //tests sortie impossible oie
        modele.choixPion(2, 0);
        modele.choixDeplacement(1, 0);
        assertEquals(new Pion(false, 2, 0), modele.getPionSelectionne());
        
        modele.choixPion(1, 0);
        assertEquals(null, modele.getPionSelectionne());
        
        //test sortie impossible renard
        modele.finTour();
        
        modele.choixPion(2, 3);
        modele.choixDeplacement(2, 4);
        modele.finTour();
        modele.choixPion(2, 4);
        assertEquals(new Pion(true, 2, 4), modele.getPionSelectionne());
        
        modele.choixDeplacement(1, 5);
        assertEquals(new Pion(true, 2, 4), modele.getPionSelectionne());
        
        modele.choixPion(1, 5);
        assertEquals(null, modele.getPionSelectionne());
    }
    
    /**
     * Test method for {@link jeu.ModeleJeu#deplacementPossible()}.
     */
    @Test
    void testDeplacementPossible() {
        
        int[][] testRenardCentre = {
            {4, 3},
            {2, 3},
            {3, 4},
            {2, 4},
            {4, 4}};
         
        modele.choixPion(3, 5);
        modele.choixDeplacement(3, 4);
        modele.finTour();
        
        modele.choixPion(3, 4);
        modele.choixDeplacement(3, 3);
        modele.finTour();
        
        modele.choixPion(3, 3);
        assertArrayEquals(testRenardCentre, modele.deplacementPossible());
        
    }
    
}
