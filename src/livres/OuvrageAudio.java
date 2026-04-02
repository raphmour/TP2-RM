package livres;

import java.time.LocalDate;

public class OuvrageAudio extends Ouvrage {
    public int dureeMinutes;
    public enum NumeriqueAnalogique {
        numerique, analogique
    }
    public NumeriqueAnalogique numeriqueAnalogique;

    public OuvrageAudio(String titre, Auteur auteur, Format type, LocalDate date, int nombreExemplaires, int dureeMinutes, NumeriqueAnalogique numeriqueAnalogique) {
        super(titre, auteur, type, date, nombreExemplaires);
        this.dureeMinutes = dureeMinutes;
        this.numeriqueAnalogique = numeriqueAnalogique;
    }

    public OuvrageAudio(String titre, Auteur auteur, Format type) {
        super(titre, auteur, type);
    }

    public OuvrageAudio(String titre, Auteur auteur) {
        super(titre, auteur);
    }
}
