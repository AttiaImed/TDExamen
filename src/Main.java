import Exceptions.VoitureException;

import java.util.ArrayList;
import java.util.List;

    public class Main {
        public static void main(String[] args) {

            Voiture voiture1 = new Voiture("233 TN 1234", "Toyota", 50000);
            Voiture voiture2 = new Voiture("220 TN 4321", "Honda", 600000);
            Voiture voiture3 = new Voiture("78 TN 5241", "Super5", 7000);

            Client client1 = new Client(1, "Attia", "Imed");
            Client client2 = new Client(2, "Chargui", "MedWassef");

            Agence agence = new Agence("KaryaBehiya");
            try {
                agence.getParking().ajouterVoiture(voiture1);
            } catch (VoitureException e) {
                throw new RuntimeException(e);
            }
            try {
                agence.getParking().ajouterVoiture(voiture2);
            } catch (VoitureException e) {
                throw new RuntimeException(e);
            }
            try {
                agence.getParking().ajouterVoiture(voiture3);
            } catch (VoitureException e) {
                throw new RuntimeException(e);
            }

            try {
                agence.louerVoiture(client1, voiture1);
            } catch (VoitureException e) {
                throw new RuntimeException(e);
            }
            try {
                agence.louerVoiture(client1, voiture2);
            } catch (VoitureException e) {
                throw new RuntimeException(e);
            }
            try {
                agence.louerVoiture(client2, voiture3);
            } catch (VoitureException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Voitures en location :");
            for (Voiture voiture : agence.voituresEnLocation()) {
                System.out.println(voiture.getImmatriculation() + " / " + voiture.getMarque());
            }




            CriterePrix cp = new CriterePrix(50000);
            System.out.println("Voiture ayant un critére de 50000 prix");
            for (Voiture v:agence.voitureCritere(cp)
                 ) {
                System.out.println(v);
            }

            System.out.println("Clients et leurs voitures louées :");
            agence.afficheLesClientsEtLeursListesVoitures();


            try {
                agence.retournerVoiture(client2,voiture3);
            } catch (VoitureException e) {
                throw new RuntimeException(e);
            }

            List<Client> clients = new ArrayList<>(agence.clientsAyantLoueVoiture());
            agence.trierClientsParCode(clients);
            System.out.println("Clients triés par code :");
            for (Client client : clients) {
                System.out.println(client.getCode() + " - " + client.getNom() + " " + client.getPrenom());
            }


            agence.trierClientsParNom(clients);
            System.out.println("Clients triés par nom :");
            for (Client client : clients) {
                System.out.println(client.getCode() + " - " + client.getNom() + " " + client.getPrenom());
            }

        }
    }