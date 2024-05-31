/*
 * PartieJeuTest.java                                           24 mai 2024
 * IUT Rodez, Info1 2023-2024 groupe TP1, pas de copyrigth
 */
package jeu.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jeu.Joueur;
import jeu.PartieJeu;
import jeu.Pion;

/** TODO commenter les responsabilités de cette classe
 * 
 */
class PartieJeuTest {
    
    Joueur renard = new Joueur(false, true, "renard");
    
    Joueur oie = new Joueur(false, false, "oie");

    PartieJeu partie = new PartieJeu(false, renard, oie);
    
    /**
     * Test method for {@link jeu.PartieJeu#PartieJeu(boolean, jeu.Joueur, jeu.Joueur)}.
     */
    @Test
    void testPartieJeu() {
        assertThrows(IllegalArgumentException.class,
                ()-> new PartieJeu(false, 
                        new Joueur(false, false, ""),
                        new Joueur(false, false, "")));
        assertThrows(IllegalArgumentException.class,
                ()-> new PartieJeu(false, 
                        new Joueur(false, false, "oui"),
                        new Joueur(false, true, "non")));

        assertDoesNotThrow(()-> new PartieJeu(false, 
                new Joueur(false, true, ""),
                new Joueur(false, false, "")));
        assertDoesNotThrow(()-> new PartieJeu(false, 
                new Joueur(false, true, "oui"),
                new Joueur(false, false, "non")));
    }

    /**
     * Test method for {@link jeu.PartieJeu#enregistrerPartie()}.
     */
    @Test
    void testEnregistrerPartie() {
        //A tester plus tard
    }

    /**
     * Test method for {@link jeu.PartieJeu#pionsPossibles(jeu.Joueur)}.
     */
    @Test
    void testPionsPossibles() {
                      
        Pion[] pionRenard = new Pion[20];
        pionRenard[0] = new Pion(true, 3, 5);
        
        Pion[] pionOie = {
                new Pion(false, 2, 0),
                new Pion(false, 3, 0),
                new Pion(false, 4, 0),
                new Pion(false, 2, 1),
                new Pion(false, 3, 1),
                new Pion(false, 4, 1),
                new Pion(false, 0, 2),
                new Pion(false, 1, 2),
                new Pion(false, 2, 2),
                new Pion(false, 3, 2),
                new Pion(false, 4, 2),
                new Pion(false, 5, 2),
                new Pion(false, 6, 2),
                null,
                null,
                null,
                null,
                null,
                null,
                null};
        
        assertArrayEquals(partie.pionsPossibles(renard), pionRenard);
        
        assertArrayEquals(partie.pionsPossibles(oie), pionOie);
    }

    /**
     * Test method for {@link jeu.PartieJeu#getPionJeu()}.
     */
    @Test
    void testGetPionJeu() {
        Pion[] tableauPionsTest
             = {new Pion(false, 2, 0),
                new Pion(false, 3, 0),
                new Pion(false, 4, 0),
                new Pion(false, 2, 1),
                new Pion(false, 3, 1),
                new Pion(false, 4, 1),
                new Pion(false, 0, 2),
                new Pion(false, 1, 2),
                new Pion(false, 2, 2),
                new Pion(false, 3, 2),
                new Pion(false, 4, 2),
                new Pion(false, 5, 2),
                new Pion(false, 6, 2),
                new Pion(true, 3, 5),
                null,
                null,
                null,
                null,
                null,
                null};
        
        assertArrayEquals(new PartieJeu(false, 
                new Joueur(false, true, ""),
                new Joueur(false, false, "")).getPionJeu()
                ,
                tableauPionsTest);
        
        tableauPionsTest[15] = tableauPionsTest[13];
        tableauPionsTest[13] = new Pion(false, 0, 3);
        tableauPionsTest[14] = new Pion(false, 6, 3);
        
        assertArrayEquals(new PartieJeu(true, 
                new Joueur(false, true, ""),
                new Joueur(false, false, "")).getPionJeu()
                ,
                tableauPionsTest);
        
    }

    /**
     * Test method for {@link jeu.PartieJeu#getPlateau()}.
     */
    @Test
    void testGetPlateau() {

        boolean[][] matricePlateau = {
                {false, false, true, true, true, false, false},
                {false, false, true, true, true, false, false},
                {true,  true,  true, true, true, true,  true},
                {true,  true,  true, true, true, true,  true},
                {true,  true,  true, true, true, true,  true},
                {false, false, true, true, true, false, false},
                {false, false, true, true, true, false, false}};
        
        assertArrayEquals(new PartieJeu(false,
                new Joueur(false, true, ""),
                new Joueur(false, false, "")).getPlateau(),
                matricePlateau);
    }

    /**
     * Test method for {@link jeu.PartieJeu#getJoueurRenard()}.
     */
    @Test
    void testGetJoueurRenard() {
              
        assertEquals(partie.getJoueurRenard(), renard);
        assertNotEquals(partie.getJoueurRenard(), oie);
    }

    /**
     * Test method for {@link jeu.PartieJeu#getJoueurOie()}.
     */
    @Test
    void testGetJoueurOie() {
        
        assertEquals(partie.getJoueurOie(), oie);
        assertNotEquals(partie.getJoueurOie(), renard);
    }

}
