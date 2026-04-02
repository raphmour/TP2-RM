package livres;

import java.time.LocalDate;

public class OuvragePapier extends Ouvrage {
    public int nbPage;

    public OuvragePapier(String titre, Auteur auteur, Format type, LocalDate date, int nombreExemplaires, int nbPage) {
        super(titre, auteur, type, date, nombreExemplaires);
        this.nbPage = nbPage;
    }

    public OuvragePapier(String titre, Auteur auteur, Format type) {
        super(titre, auteur, type);
    }

    public OuvragePapier(String titre, Auteur auteur) {
        super(titre, auteur);
    }
}
