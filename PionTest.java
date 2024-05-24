/*
 * PionTest.java                                           17 mai 2024
 * IUT Rodez, Info1 2023-2024 groupe TP1, pas de copyrigth
 */
package jeu.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jeu.Pion;

/**
 * tests unitaires de jeu.Pion
 */
class PionTest {

    /**
     * Test method for {@link jeu.Pion#Pion(boolean, int, int)}.
     */
    @Test
    void testPion() {
        assertDoesNotThrow(()-> new Pion(false, 0, 0));
        assertDoesNotThrow(()-> new Pion(true, 12, 32));
        
        assertThrows(IllegalArgumentException.class,
                     ()-> new Pion(false, -1, 0));
        assertThrows(IllegalArgumentException.class,
                ()-> new Pion(true, 2, -3));
        assertThrows(IllegalArgumentException.class,
                ()-> new Pion(false, -9, -12));
    }

    /**
     * Test method for {@link jeu.Pion#getEstRenard()}.
     */
    @Test
    void testGetEstRenard() {
        assertTrue(new Pion(true, 1, 3).getEstRenard());
        assertTrue(new Pion(true, 21, 4).getEstRenard());
        assertFalse(new Pion(false, 0, 5).getEstRenard());
        assertFalse(new Pion(false, 0, 0).getEstRenard());
    }

    /**
     * Test method for {@link jeu.Pion#getCoordonneeX()}.
     */
    @Test
    void testGetCoordonneeX() {
        assertEquals(new Pion(true, 1, 3).getAbcisse(), 1);
        assertEquals(new Pion(false, 12, 43).getAbcisse(), 12);
        assertEquals(new Pion(true, 0, 1).getAbcisse(), 0);
    }

    /**
     * Test method for {@link jeu.Pion#getCoordonneeY()}.
     */
    @Test
    void testGetCoordonneeY() {
        assertEquals(new Pion(true, 1, 3).getOrdonnee(), 3);
        assertEquals(new Pion(true, 12, 0).getOrdonnee(), 0);
        assertEquals(new Pion(false, 0, 7).getOrdonnee(), 7);
    }

    /**
     * Test method for {@link jeu.Pion#deplacement(int, int)}.
     */
    @Test
    void testDeplacement() {

        assertThrows(IllegalArgumentException.class,
                     ()-> new Pion(true, 3, 3).deplacement(0, 0));
        assertThrows(IllegalArgumentException.class,
                     ()-> new Pion(true, 0, 0).deplacement(-1, 0));
        assertThrows(IllegalArgumentException.class,
                     ()-> new Pion(true, 0, 0).deplacement(0, -1));
        assertThrows(IllegalArgumentException.class,
                     ()-> new Pion(true, 0, 0).deplacement(-1, -1));
        
        Pion test1 = new Pion(true, 0, 0);
        test1.deplacement(1, 1);
        assertEquals(test1.getAbcisse(), 1);
        assertEquals(test1.getOrdonnee(), 1);
        
        Pion test2 = new Pion(false, 4, 5);
        test2.deplacement(5, 5);
        assertEquals(test2.getAbcisse(), 5);
        assertEquals(test2.getOrdonnee(), 5);
    }
    
    /**
     * Test method for {@link jeu.Pion#deplacementsPossibles()}.
     */
    @Test
    void testDeplacementsPossibles() {
        
        int[][] testOie = {{1, 0}, {-1, 0}, {0, 1}};
        
        int[][] testRenard = {{1, 0}, {-1, 0}, {0, 1}, {-1, -1},
                              {0, -1}, {1, -1}, {-1, 1}, {1, 1}};
        
        assertArrayEquals(new Pion(false, 0, 0).deplacementsPossibles(), testOie);
        
        assertArrayEquals(new Pion(true, 0, 0).deplacementsPossibles(), testRenard);
    }
}
