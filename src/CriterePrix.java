public class CriterePrix implements Critere {
    private double prix;

    public CriterePrix(double prixMaximum) {
        this.prix = prixMaximum;
    }

    @Override
    public boolean estSatisfaitPar(Voiture v) {
        return v.getPrix() <= prix;
    }
}
