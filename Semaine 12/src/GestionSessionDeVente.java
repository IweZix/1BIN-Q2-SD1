import java.util.HashMap;
import java.util.Scanner;

public class GestionSessionDeVente {
	
	private static Scanner scanner = new Scanner(System.in);
	private static SessionDeVente session;
	private static HashMap<String,Client> mapClientsEnregistres = new HashMap<>();

	public static void main(String[] args) {

		System.out.println("Enregistrement des clients");
		System.out.println("Combien y a-t-il de clients : ");
		int nombreClients = scanner.nextInt();
		for (int i = 0; i < nombreClients; i++) {
			System.out.println("Donnez son login : ");
			String login = scanner.next();
			System.out.println("Donnez son nom : ");
			String nom = scanner.next();
			System.out.println("Donnez sa priorite ");
			int priorite = scanner.nextInt();
			scanner.nextLine();
			mapClientsEnregistres.put(login,new Client(nom,priorite));
		}
	
		System.out.println("******************************");
		System.out.println("Gestion d'une session de vente");
		System.out.println("******************************");
	    System.out.println();
		System.out.print("Entrez le nombre de casiers a vendre : ");
		int nombreCasiersMisEnVente= scanner.nextInt();
		scanner.nextLine();
		session = new SessionDeVente(nombreCasiersMisEnVente);
		System.out.println();
		int choix = 0;
		do {
			System.out.println();
			System.out.println("1 -> afficher quelques informations sur l'etat des ventes");
			System.out.println("2 -> mettre un client dans la file d'attente");
			System.out.println("3 -> traiter le client en tete de la file d'attente");
			System.out.println();
			System.out.print("Votre choix : ");
			choix = scanner.nextInt();
			scanner.nextLine();
			switch (choix) {
			case 1:
				afficherInfo();
				break;
			case 2:
				mettreEnAttente();
				break;
			case 3:
				traiterClient();
				break;
			}
		
		} while (session.getNombreCasiersRestants()>0);

		System.out.println("Fin des ventes");
		System.out.println("Tous les casiers sont vendus");
		session.cloturerSession();
		System.out.println(mapClientsEnregistres);
	}

	private static void afficherInfo() {
		// vous pouvez modifier cette methode comme vous voulez
		// cette classe ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!

		System.out.println(session);
		System.out.println("ATTENTION, l'ordre des clients dans la file de priorite, ne correspond pas (nessecairement) a l'ordre ou ils seront traites ! ");
		System.out.println("cfr ex defi !");
		
		
	}

	private static void mettreEnAttente() {
		// vous pouvez modifier cette methode comme vous voulez
		// cette classe ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!
		System.out.print("Entrez le login du client : ");
		String login = scanner.nextLine();
		Client client = mapClientsEnregistres.get(login);
		if(client==null){
			System.out.println("Le login est inconnu");
		}else {
			if (session.placerDansFileAttente(client)) {
				System.out.println("Le client a ete mis en attente");
			} else {
				System.out.println("Le client n'a pas ete mis en attente");
			}
		}

	}

	private static void traiterClient() {
		// vous pouvez modifier cette methode comme vous voulez
		// cette classe ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!
		Client client = session.selectionnerClientSuivant();
		if(client==null){
			System.out.println("Il n'y a actuellement aucun client en attente");
		}else{
			System.out.println("Le client traite est "+ client);
			System.out.println("Il reste actuellement "+ session.getNombreCasiersRestants() + " casiers en vente");
			System.out.println("Entrez le nombre de casiers que vous desirez ( ou 0 pour arreter) : ");
			System.out.println("(Si vous avez deja fait une commande, ce nombre sera ajoute au nombre de casiers que vous avez deja commandes)");
			int nombreCasiersDemandes = scanner.nextInt();
			if(nombreCasiersDemandes>0){
				try{
					// le client a deja une commande
					// --> modifierCommande()
					if(session.modifierCommande(client, nombreCasiersDemandes)){
						System.out.println("La demande a ete acceptee");
						System.out.println("La commande a ete modifiee");
					}else{
						System.out.println("La demande n'a pas ete acceptee");
					}
				}
				catch (IllegalStateException e){
				}
				try{

					// le client n'a pas encore de commande
					// --> passerNouvelleCommande()	
					if(session.passerNouvelleCommande(client, nombreCasiersDemandes)){
						System.out.println("La demande a ete acceptee");
						System.out.println("Une commande a ete creee");
					}else{
						System.out.println("La demande n'a pas ete acceptee");
					}
				}
				catch (IllegalStateException e){
				}

			}
		}
	}

}
