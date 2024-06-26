/*
 * JoueurTest.java                                           17 mai 2024
 * IUT Rodez, Info1 2023-2024 groupe TP1, pas de copyrigth
 */
package jeu.test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jeu.Joueur;

/**
 * Classe de test permettant de vérifier le bon fonctionnement
 * de la classe instance Joueur
 */
class JoueurTest {

    /**
     * Méthode de test pour le constructeur Joueur
     */
    @Test
    void testJoueur() {
        Joueur joueur1 = new Joueur(false, false, "Joueur1");
        assertFalse(joueur1.getEstIA());
        assertFalse(joueur1.getEstRenard());
        assertEquals("Joueur1", joueur1.getPseudo());

        Joueur joueur2 = new Joueur(true, true, "JoueurIA");
        assertTrue(joueur2.getEstIA());
        assertTrue(joueur2.getEstRenard());
        assertEquals("JoueurIA", joueur2.getPseudo());

        Joueur joueur3 = new Joueur(false, true, "");
        assertFalse(joueur3.getEstIA());
        assertTrue(joueur3.getEstRenard());
        assertEquals("", joueur3.getPseudo());
    }

    /**
     * méthode de test pour GetEstIA
     */
    @Test
    void testGetEstIA() {
        //A faire si le temps
    }

    /**
     * méthode de test pour GetEstRenard
     */
    @Test
    void testGetEstRenard() {
        assertTrue(new Joueur(false, true, "oui").getEstRenard());
        assertTrue(new Joueur(true, true, "non").getEstRenard());
        
        assertFalse(new Joueur(false, false, "").getEstRenard());
        assertFalse(new Joueur(true, false, "123456789").getEstRenard());

    }

    /**
     * méthode de test pour GetPseudo
     */
    @Test
    void testGetPseudo() {
    }

}
