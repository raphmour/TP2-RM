package tests;

import java.time.LocalDate;
import java.util.List;

import livres.*;

/**
 * CoursPOO 1
 *
 * @author Julien.Brunet màj Jocelyn
 * @since H25
 */
public class TestOuvrage {

    public static void main(String[] args) {
        TestOuvrage test = new TestOuvrage();
        test.testOuvrages();
        test.testTrouver();
        test.testSerie();
        test.testPays();
    }


    public void testSerie(){
        System.out.println("===============testSerie==============");
        System.out.println("Création de Serie1");
        Serie serie1 = new Serie("Serie1");
        System.out.println(serie1.toString());
        Auteur auteur1 = new Auteur();
        System.out.println("Ajout d'un ouvrage test à la Serie1");
        Ouvrage ouvrage1 = new OuvragePapier("OuvrageTest1",auteur1);
        serie1.listeOuvrages.add(ouvrage1);
        System.out.println(serie1.toString());
        System.out.println("Suppression d'un ouvrage dans la serie");
        serie1.listeOuvrages.remove(ouvrage1);
        System.out.println(serie1.toString());
        System.out.println("===============testSerie==============");
    }

    public void testPays(){
        System.out.println("===============testPays==============");
        System.out.println("Test avec un code pays INVALIDE (Québec, code : Libre)");
        Pays quebec = new Pays("Québec","Libre");
        System.out.println(quebec.toString());
        System.out.println("Test avec un code pays VALIDE");
        Pays mexique = new Pays("Mexique","MEX");
        System.out.println(mexique.toString());
        System.out.println("===============testPays==============");
    }

    public void testOuvrages() {
        //Deux auteurs deja prets pour les tests...
        Pays suisse = new Pays("Suisse", "SUI");
        Pays usa = new Pays("États-Unis", "USA");
        Pays canada = new Pays("Canada", "CAN");
        Auteur albertine = new Auteur("Albertine", "Tremblay", canada);
        Auteur john = new Auteur("John", "Smith", usa);

        //Voici une partie des tests! Il faut en ajouter, pour les fonctionnalités non testées!
        System.out.println("-----Test des constructeurs d'ouvrage et des diverses validations-----------");
        Ouvrage livreA = new OuvragePapier("Titre assez long", john);
        Ouvrage livreA = new OuvrageAudio("Titre assez long", john);
        System.out.println(livreA);
        Ouvrage livreB = new OuvrageVideo("Ti", john);
        Ouvrage livreB = new OuvragePapier("Ti", john);
        System.out.println(livreB);
        Ouvrage livreC = new OuvragePapier(null, john);
        System.out.println(livreC);

        //bibliotheque.Auteur null et valeur par défaut de l'bibliotheque.Auteur
        Ouvrage livreA1 = new OuvrageAudio("Titre assez long", null);
        Ouvrage livreA1 = new OuvragePapier("Titre assez long", null);
        System.out.println(livreA1);
        //bibliotheque.Auteur fonctionnel
        Ouvrage livre1 = new OuvragePapier("Tout va bien", albertine);
        Ouvrage livre1 = new OuvrageVideo("Tout va bien", albertine);
        System.out.println(livre1);

        //Date null et valeur par défaut de la date
        livre1.setDate(null);
        System.out.println(livre1);
        livre1.setDate(LocalDate.now().minusYears(5));
        System.out.println(livre1);

        //Test de la validation sur le nb d'exemplaires (valide et non valide)
        Ouvrage livre2 = new OuvragePapier("Tout va bien", albertine, Ouvrage.Format.AUDIO, LocalDate.now(), -10, 100);
        Ouvrage livre2 = new OuvrageAudio("Tout va bien", albertine, Ouvrage.Format.AUDIO, LocalDate.now(), -10,60, OuvrageAudio.NumeriqueAnalogique.analogique);
        System.out.println(livre2);

        livre2 = new OuvrageVideo("Tout va bien", albertine, Ouvrage.Format.PAPIER, LocalDate.now(), 20,61,2048);
        livre2 = new OuvragePapier("Tout va bien", albertine, Ouvrage.Format.PAPIER, LocalDate.now(), 20, 101);
        System.out.println(livre2);

        System.out.println("\n-----Tests des méthodes acheter et vendre-----------");

        Ouvrage livre3 = new OuvragePapier("Musique du hasard", new Auteur("Paul", "Auster", usa), Ouvrage.Format.PAPIER, LocalDate.now(), 5, 102);
        System.out.println(livre3);

        livre3.acheter(5);
        System.out.println(livre3);

        System.out.println("On peut vendre 8 livres? " + livre3.vendre(8));
        System.out.println(livre3);

        System.out.println("On peut vendre 10 livres? " + livre3.vendre(10));
        System.out.println(livre3);

        Ouvrage livre4 = new OuvragePapier("Test", new Auteur("A", "B", usa), Ouvrage.Format.PAPIER, LocalDate.now(), 5, 103);

        System.out.println("\n-----Tests de la  méthode equals()-----------");
        //Deux ouvrages égaux
        Ouvrage livre5 = new OuvragePapier("Test", new Auteur("A", "B", usa), Ouvrage.Format.PAPIER, null, 5,104);
        Ouvrage livre6 = new OuvragePapier("Test", new Auteur("A", "B", usa), Ouvrage.Format.PAPIER, LocalDate.now(), 10,105);
        Ouvrage livre5 = new OuvrageAudio("Test", new Auteur("A", "B", usa), Ouvrage.Format.PAPIER, null, 5,60, OuvrageAudio.NumeriqueAnalogique.numerique);
        Ouvrage livre6 = new OuvrageAudio("Test", new Auteur("A", "B", usa), Ouvrage.Format.PAPIER, LocalDate.now(), 10,60, OuvrageAudio.NumeriqueAnalogique.numerique);
        //Un qui ne l'est pas
        Ouvrage livre7 = new OuvrageAudio("Test", new Auteur("Z", "B", usa), Ouvrage.Format.PAPIER, LocalDate.now(), 5,66, OuvrageAudio.NumeriqueAnalogique.analogique);
        Ouvrage livre7 = new OuvragePapier("Test", new Auteur("Z", "B", usa), Ouvrage.Format.PAPIER, LocalDate.now(), 5,106);

        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + livre4.equals(livre5));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + livre4.equals(livre6));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals(livre7));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals(john));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals(null));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals("Test"));
    }


    private void testTrouver() {
        Librairie bibliotheque = new Librairie();
        Auteur john = bibliotheque.getAuteurs().get(1);

        Pays france = new Pays("France", "FRA");
        Pays canada = new Pays("Canada", "CAN");

        System.out.println("\n-----Test de votre méthode trouverOuvrage-----------");
        List<Ouvrage> resultat = bibliotheque.trouverOuvrages(new Auteur("Albertine", "Tremblay", canada));
        System.out.println("Livres de albertine: " + resultat);

        resultat = bibliotheque.trouverOuvrages(john);
        System.out.println("Livres de john: " + resultat);

        resultat = bibliotheque.trouverOuvrages(new Auteur("Jacques", "Beaulieu", france));
        System.out.println("Livres de Jacques: " + resultat);
    }


}

