import Exceptions.VoitureException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListVoiture {
    private List<Voiture> voitures;

    public ListVoiture() {
        voitures= new ArrayList<>();
    }

    public void ajouterVoiture(Voiture voiture) throws VoitureException  {
        if(!voitures.contains(voiture))
            voitures.add(voiture);
        else
            throw new VoitureException("Voiture deja existe !");
    }

    public void supprimerVoiture(Voiture voiture) throws VoitureException{
        if(voitures.contains(voiture))
            voitures.remove(voiture);
        else
            throw new VoitureException("Voiture n'exsite pas !");
    }

    public List<Voiture> getVoitures() {
        return voitures;
    }


    public Iterator<Voiture>
    iterateur(){ return voitures.iterator();
    }
    public int size(){
        return voitures.size();
    }
    public void affiche(){
        for (Voiture v:voitures
             ) {
            System.out.println(v);
        }
    }
}
