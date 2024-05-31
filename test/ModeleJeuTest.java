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
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link jeu.ModeleJeu#finTour()}.
     */
    @Test
    void testFinTour() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link jeu.ModeleJeu#choixPion(int, int)}.
     */
    @Test
    void testChoixPion() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link jeu.ModeleJeu#choixDeplacement(int, int)}.
     */
    @Test
    void testChoixDeplacement() {
        fail("Not yet implemented");
    }

}
