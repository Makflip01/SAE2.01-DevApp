/*
 * Différents traitements les durées
 * DureeHMS.java
 */

package lesdurees;

import java.util.Scanner;

/**
 * Traitements sur les durées exprimées en heure/minute/seconde Les minutes et
 * les secondes sont comprises entre 0 et 59 Un nombre d'heures est un entier
 * positif ou nul. Une durée est représentée par un tableau de 3 entiers.
 * 
 * @author INFO1
 */
public class DureeHMS {

    /**
     * Saisie d'un entier. La saisie est recommencée en cas d'erreur
     * @return l'entier saisi (un entier quelconque)
     */
    public static int saisirEntier() {
        Scanner entree = new Scanner(System.in);
        int valeur = 0;
        boolean correct = false;    // on suppose que la saisie est incorrecte

        // on recommence la saisie jusqu'à ce qu'elle soit correcte
        do {
            System.out.print("Entrez un entier : ");
            if (entree.hasNextInt()) {      // l'utilisateur a entré un entier
                valeur = entree.nextInt();
                correct = true;
            }
            entree.nextLine();              // on vide le tampon d'entrée
        } while (!correct);
        return valeur;                      // on renvoie l'entier saisi
    }

    
    /**
     * Saisie d'un entier positif ou nul. La saisie est recommencée en cas
     * d'erreur
     * @param message affiché pour l'utilisateur
     * @return l'entier saisi
     */
    public static int saisirEntierPositif(String message) {
        Scanner entree = new Scanner(System.in);
        int valeur = -1; // initialisée avec un entier incorrect

        // on recommence la saisie jusqu'à obtenir un entier positif ou nul
        do {
            System.out.print(message);
            if (entree.hasNextInt()) {  // l'utilisateur a entré un entier
                valeur = entree.nextInt();
            }
            entree.nextLine();          // on vide le tampon d'entrée
        } while (valeur < 0);

        return valeur;                  // on renvoie l'entier saisi
    }

    
    /**
     * Saisie d'un entier appartenant à un intervalle. La saisie est recommencée
     * en cas d'erreur
     * @param message affiché pour l'utilisateur
     * @param inferieur borne inférieure de l'intervalle
     * @param superieur borne supérieure de l'intervalle
     * @return l'entier saisi
     */
    public static int saisirEntierIntervalle(String message, int inferieur,
                                             int superieur) {
        Scanner entree = new Scanner(System.in);
        int valeur = inferieur - 1;         // initialisée avec un entier incorrect

        /*
         * on recommence la saisie jusqu'à obtenir un entier
         * appartenant à l'intervalle
         */
        do {
            System.out.print(message);
            if (entree.hasNextInt()) {      // l'utilisateur a entré un entier
                valeur = entree.nextInt();
            }
            entree.nextLine();              // on vide le tampon d'entrée
        } while (valeur < inferieur || valeur > superieur);
        return valeur; // on renvoie l'entier saisi
    }

    
    /**
     * Affiche une durée exprimée en heures, minutes et secondes

     * @param duree
     *            tableau de 3 entiers contenant les heures, minutes et secondes
     */
    public static void afficher(int[] duree) {
        System.out.println(duree[0] + " heure(s) " + duree[1] + " minute(s) "
                + duree[2] + " seconde(s) ");
    }

    /**
     * Saisie d'une durée en heures, minutes et secondes La saisie de chaque
     * valeur est recommencée en cas d'erreur
     * 
     * @param message
     *            affiché pour l'utilisateur
     * @return un tableau contenant les 3 entiers saisis
     */
    public static int[] saisirDuree(String message) {
        int[] duree = new int[3]; // durée saisie

        System.out.println(message);
        // saisie des heures, puis des minutes, puis des secondes
        duree[0] = saisirEntierPositif(" Heures ? ");
        duree[1] = saisirEntierIntervalle(" Minutes ? ", 0, 59);
        duree[2] = saisirEntierIntervalle(" Secondes ? ", 0, 59);

        return duree; // on renvoie la durée saisie
    }

   

    /**
     * Détermine si les 2 durées argument sont identiques ou pas
     * 
     * @param d1
     *            première durée à tester
     * @param d2
     *            deuxième durée à tester
     * @return un booléen égal à vrai ssi les 2 durées argument sont égales
     */
    public static boolean egalite(int[] d1, int[] d2) {
        // on renvoie vrai ssi les heures, les minutes et les secondes sont
        // 2 à 2 égales
        return d1[0] == d2[0] && d1[1] == d2[1] && d1[2] == d2[2];
    }

    /**
     * Détermine si les 2 durées argument sont ordonnées ou pas
     * 
     * @param d1
     *            première durée à tester
     * @param d2
     *            deuxième durée à tester
     * @return un booléen égal à vrai ssi les 2 durées argument sont ordonnées
     *         ou égales
     */
    public static boolean ordre(int[] d1, int[] d2) {
        // comparaison des heures, puis éventuellement des minutes, puis
        // éventuellement des secondes
        return d1[0] < d2[0] || // heure de d1 < heure de d2
                (d1[0] == d2[0] && (d1[1] < d2[1] ||
                // les heures de d1 et de d2 sont égales
                // et minute de d1 < minute de d2
                (d1[1] == d2[1] && d1[2] <= d2[2])));
        // les minutes de d1 et d2 sont égales
        // et les secondes de d1 < secondes de d2
    }

    /**
     * Détermine si les 3 durées argument sont ordonnées ou pas
     * 
     * @param d1
     *            première durée à tester
     * @param d2
     *            deuxième durée à tester
     * @param d3
     *            troisième durée à tester
     * @return un booléen égal à vrai ssi les 3 durées argument sont ordonnées
     *         ou égales
     */
    public static boolean ordre(int[] d1, int[] d2, int[] d3) {
        return ordre(d1, d2) && ordre(d2, d3);
    }

    /**
     * Détermine combien de durées sont différentes parmi les 3 passées en
     * paramètres
     * 
     * @param d1
     *            première durée
     * @param d2
     *            deuxième durée
     * @param d3
     *            troisième durée
     * @return un entier compris entre 1 et 3 égal au nombre de durées
     *         différentes passées en paramètre
     */
    public static int combienDifferentes(int[] d1, int[] d2, int[] d3) {
        int differente = 3;
        if (egalite(d1, d2)) {
            if (egalite(d2, d3)) { // les 3 durées sont identiques
                differente = 1;
            } else {
                differente = 2; // d1 == d2 et d3 différente
            }
        } else if (egalite(d2, d3)) {
            differente = 2; // d2 == d3 et d1 différente
        } else if (egalite(d1, d3)) {
            differente = 2; // d1 == d3 et d2 différente
        }

        // on renvoie le résultat
        return differente;
    }


    /**
     * Détermine si un caractère est un chiffre
     * 
     * @param caractere
     *            caractère à tester
     * @return un booléen égal à vrai ssi le caractère est un chiffre
     */
    public static boolean estUnChiffre(char caractere) {
        return caractere >= '0' && caractere <= '9';
    }

    /**
     * Détermine si la chaîne argument contient le motif suivant à partir de la
     * position début : un séparateur ( un caractère autre qu'un chiffre) un
     * chiffre ou 2 chiffres
     * 
     * @param chaine
     *            la chaîne dans laquelle le motif est vérifié
     * @param debut
     *            l'indice à partir duquel la vérification est faite
     * @return un entier égal à -1 si le motif n'a pas été trouvé l'indice du
     *         caractère qui fait suite au motif
     */
    public static int motif(String chaine, int debut) {
        boolean correct;
        int indiceFin = -1;

        // on vérifie si le caractère d'indice debut existe et contient un
        // séparateur
        correct = debut < chaine.length()
                && !estUnChiffre(chaine.charAt(debut));

        // on vérifie si le caractère d'indice début+1 existe
        // et est un chiffre
        correct = correct && debut + 1 < chaine.length()
                && estUnChiffre(chaine.charAt(debut + 1));

        if (correct) {
            indiceFin = debut + 2; // fin présumé du motif
            if (indiceFin < chaine.length()
                    && estUnChiffre(chaine.charAt(indiceFin))) {
                // il y a un chiffre à l'indiceFin
                indiceFin++;
            }
        }

        // on renvoie le résultat
        return correct ? indiceFin : -1;
    }

    /**
     * Détermine si une chaîne de caractères contient une durée dans le format
     * suivant : une suite de chiffres non vide un séparateur (autre qu'un
     * chiffre) un ou 2 chiffres un séparateur un ou 2 chiffres
     * 
     * @param chaine
     *            chaîne à tester
     * @return un booléen égal à vrai ssi la chaîne contient bien une durée
     */
    public static boolean estChaineDuree(String chaine) {
        boolean correct;
        int indice; // indice de parcours de la chaîne

        // on vérifie qu'il y a bien au moins un chiffre en début de chaîne
        correct = chaine != null && chaine.length() > 0
                && estUnChiffre(chaine.charAt(0));
        if (correct) {
            // on amène l'indice sur le 1er séparateur
            for (indice = 0; indice < chaine.length()
                    && estUnChiffre(chaine.charAt(indice)); indice++)
                ;

            correct = indice < chaine.length(); // le caractère courant
                                                // n'est pas un chiffre
            if (correct) {

                // on teste si l'on a un motif à partir de l'indice
                // motif = séparateur puis un ou 2 chiffres
                indice = motif(chaine, indice);
                correct = indice > -1 && indice < chaine.length();

                if (correct) {
                    // on teste la présence du deuxième motif
                    indice = motif(chaine, indice);
                    correct = indice > -1 && indice == chaine.length();
                }
            }
        }

        return correct;
    }
	
	  /**
     * Affiche une durée exprimée en heures, minutes et secondes
     * 
     * @param h
     *            heures
     * @param m
     *            minutes
     * @param s
     *            seconcdes
     */
    public static void afficher(int h, int m, int s) {
        System.out.println(h + " heure(s) " + m + " minute(s) " + s
                + " seconde(s) ");
    }

   

    // ////////////////////////////////////////////////////////////////////
    // Méthodes utilisées pour tester les méthodes précédentes //
    // ////////////////////////////////////////////////////////////////////

    

    public static void testDifferente() {
        int[] d1; // première durée
        int[] d2; // deuxième durée
        int[] d3; // troisième

        d1 = DureeHMS.saisirDuree("Saisie de la première durée : ");
        d2 = DureeHMS.saisirDuree("Saisie de la deuxième durée : ");
        d3 = DureeHMS.saisirDuree("Saisie de la troisième durée : ");

        System.out.println("Parmi ces 3 durées, "
                + combienDifferentes(d1, d2, d3) + " sont différentes.");

    }

    public static void testOrdre() {
        int[] d1; // première durée
        int[] d2; // deuxième durée
        int[] d3; // troisième

        d1 = DureeHMS.saisirDuree("Saisie de la première durée : ");
        d2 = DureeHMS.saisirDuree("Saisie de la deuxième durée : ");
        d3 = DureeHMS.saisirDuree("Saisie de la troisième durée : ");

        System.out.println("ces 3 durées sont "
                + (ordre(d1, d2, d3) ? " ordonnées " : " dans le désordre"));

    }

  

    public static void testChaine() {
        Scanner entree = new Scanner(System.in);
        String phrase;
        System.out.print("Entrez une chaine : ");
        phrase = entree.nextLine();
        if (estChaineDuree(phrase)) {
            System.out.println("OK !!");
        } else {
            System.out.println("ERREUR !!! ");
        }
    }

}
