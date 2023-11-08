import java.util.ArrayList;
import java.util.List;

    public class Main {
        public static void main(String[] args) {

            Voiture voiture1 = new Voiture("233 TN 1234", "Toyota", 50000.0);
            Voiture voiture2 = new Voiture("220 TN 4321", "Honda", 600000.0);
            Voiture voiture3 = new Voiture("78 TN 5241", "Super5", 7000.0);

            Client client1 = new Client(1, "Attia", "Imed");
            Client client2 = new Client(2, "Chargui", "MedWassef");

            // Création de l'agence
            Agence agence = new Agence("KaryaBehiya");
            agence.getParking().ajouterVoiture(voiture1);
            agence.getParking().ajouterVoiture(voiture2);
            agence.getParking().ajouterVoiture(voiture3);

            // Louer une voiture à un client
            agence.louerVoiture(client1, voiture1);
            agence.louerVoiture(client1, voiture2);
            agence.louerVoiture(client2, voiture3);

            // Afficher les voitures en location
            List<Voiture> voituresEnLocation = agence.voituresEnLocation();
            System.out.println("Voitures en location :");
            for (Voiture voiture : voituresEnLocation) {
                System.out.println(voiture.getImmatriculation() + " - " + voiture.getMarque());
            }

            // Retourner une voiture louée par un client
            agence.retournerVoiture(client1, voiture2);

            // Afficher les clients et leurs voitures louées
            System.out.println("\nClients et leurs voitures louées :");
            agence.afficherClientsEtVoituresLouees();

            // Trier les clients par code
            List<Client> clients = new ArrayList<>(agence.clientsAyantLoueVoiture());
            agence.trierClientsParCode(clients);
            System.out.println("\nClients triés par code :");
            for (Client client : clients) {
                System.out.println(client.getCode() + " - " + client.getNom() + " " + client.getPrenom());
            }

            // Trier les clients par nom
            agence.trierClientsParNom(clients);
            System.out.println("\nClients triés par nom :");
            for (Client client : clients) {
                System.out.println(client.getNom() + " " + client.getPrenom() + " - " + client.getCode());
            }
        }
    }