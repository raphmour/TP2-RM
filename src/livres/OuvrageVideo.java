package livres;

import java.time.LocalDate;

public class OuvrageVideo extends Ouvrage {

    public int dureeMinutes;
    public int tailleMb;

    public OuvrageVideo(String titre, Auteur auteur, Format type, LocalDate date, int nombreExemplaires, int dureeMinutes, int tailleMb) {
        super(titre, auteur, type, date, nombreExemplaires);
        this.dureeMinutes = dureeMinutes;
        this.tailleMb = tailleMb;
    }

    public OuvrageVideo(String titre, Auteur auteur, Format type) {
        super(titre, auteur, type);
    }

    public OuvrageVideo(String titre, Auteur auteur) {
        super(titre, auteur);
    }
}
