public class CritereMarque implements Critere {
    private String marque;

    public CritereMarque(String marqueRecherchee) {
        this.marque = marqueRecherchee;
    }

    @Override
    public boolean estSatisfaitPar(Voiture v) {
        return v.getMarque().toLowerCase().equals(marque.toLowerCase());
    }
}
