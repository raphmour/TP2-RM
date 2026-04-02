package livres;

import java.util.ArrayList;

public class Serie {
    public String nom;
    public ArrayList<Ouvrage> listeOuvrages = new ArrayList<>();

    public Serie(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return nom + ": Ouvrages dans la serie : " + listeOuvrages;
    }
}
