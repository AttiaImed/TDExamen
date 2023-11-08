import Exceptions.VoitureException;

import java.util.*;

public class Agence {
    private String nom;
    private ListVoiture parking = new ListVoiture();
    private Map<Client, ListVoiture> clientVoitureLoue = new HashMap<>();

    public Agence(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ListVoiture getParking() {
        return parking;
    }

    public void setParking(ListVoiture parking) {
        this.parking = parking;
    }
    public Map<Client, ListVoiture> getClientVoitureLoue() {
        return clientVoitureLoue;
    }

    public void setClientVoitureLoue(Map<Client, ListVoiture> clientVoitureLoue) {
        this.clientVoitureLoue = clientVoitureLoue;
    }



    public void ajoutVoiture(Voiture v)
            throws VoitureException {
        if(!parking.getVoitures().contains(v)){
            parking.ajouterVoiture(v);
        }else
            throw new VoitureException("Voiture Existe");
    }
    public void supprimerVoiture(Voiture v)
            throws VoitureException {
        if(parking.getVoitures().contains(v)){
            parking.supprimerVoiture(v);
        }else
            throw new VoitureException("Voiture ,'existe pas");
    }

    public void louerVoiture(Client client, Voiture voiture) throws VoitureException {
        if (!clientVoitureLoue.containsKey(client)) {
            clientVoitureLoue.put(client, new ListVoiture());
        }
        clientVoitureLoue.get(client).ajouterVoiture(voiture);
    }



    public void retournerVoiture(Client client, Voiture voiture) throws VoitureException {
        if (clientVoitureLoue.containsKey(client)) {
            ListVoiture listeVoituresLouees = clientVoitureLoue.get(client);
            listeVoituresLouees.supprimerVoiture(voiture);
        }else
            throw new VoitureException("Voiture n'existe pas dans ce client");
    }

    public List<Voiture> voitureCritere(Critere critere) {
        List<Voiture> voituresCritere = new ArrayList<>();
        for (Voiture voiture : parking.getVoitures()) {
            if (critere.estSatisfaitPar(voiture)) {
                voituresCritere.add(voiture);
            }
        }
        return voituresCritere;
    }

    public Set<Client> clientsAyantLoueVoiture() {
        return clientVoitureLoue.keySet();
    }

    public List<Voiture> voituresEnLocation() {
        List<Voiture> voituresEnLocation = new ArrayList<>();
        for (ListVoiture listeVoituresLouees : clientVoitureLoue.values()) {
            voituresEnLocation.addAll(listeVoituresLouees.getVoitures());
        }
        return voituresEnLocation;
    }

    public void afficheLesClientsEtLeursListesVoitures(){
        for (Map.Entry<Client, ListVoiture> map : clientVoitureLoue.entrySet()) {
            System.out.println("Client: " + map.getKey().getNom() + " " + map.getKey().getPrenom());
            for (Voiture voiture : map.getValue().getVoitures()) {
                System.out.println(voiture.getImmatriculation() + " / " + voiture.getMarque());
            }
        }
    }
    public void trierClientsParCode(List<Client> clients) {
        Collections.sort(clients, new TriCode());
    }

    public void trierClientsParNom(List<Client> clients) {
        Collections.sort(clients, new TriNom());
    }
}