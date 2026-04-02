package livres;

import java.util.Scanner;

public class Pays {
    public String nom;
    public String code;

    public Pays(String nom, String codeSaisi) {
        Scanner sc = new Scanner(System.in);
        this.nom = nom;
        while (codeSaisi == null || codeSaisi.length() != 3 || !codeSaisi.matches("[A-Z]{3}")) {
            System.out.print("Code '"+ codeSaisi +"' invalide. Entrez 3 lettres MAJ : ");
            codeSaisi = sc.nextLine();
        }
        System.out.println("Code saisi: " + codeSaisi + " est valide.");
        this.code = codeSaisi;
    }

    @Override
    public String toString() {
        return "Nom du pays:"+ this.nom +" code:"+this.code;
    }
}

