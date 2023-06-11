import java.util.Scanner;

public class GestionSessionDeVente {
	
	private static Scanner scanner = new Scanner(System.in);
	private static SessionDeVente session;
	
	public static void main(String[] args) {
	
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
			System.out.println("4 -> modifier la commande d'un client déjà existante");
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
				case 4:
					modifierCommande();
					break;

			}
		
		} while (session.getNombreCasiersRestants()>0);
		System.out.println("Fin des ventes");
		System.out.println("Tous les casiers sont vendus");	
	}

	private static void afficherInfo() {
		// vous pouvez modifier cette methode comme vous voulez
		// cette classe ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!
		System.out.println(session);
	}

	private static void mettreEnAttente() {
		// vous pouvez modifier cette methode comme vous voulez
		// cette classe ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!
		System.out.print("Entrez le client : ");
		String client = scanner.nextLine();
		if(session.placerDansFileAttente(new Client(client))){
			System.out.println("Le client a ete mis en attente");
		}else{
			System.out.println("Le client n'a pas ete mis en attente");
		}

	}

	private static void traiterClient() {
		// vous pouvez modifier cette methode comme vous voulez
		// cette classe ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!
		String client = session.selectionnerClientSuivant();
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
					if(session.modifierCommande(new Client(client), nombreCasiersDemandes)){
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
					if(session.passerNouvelleCommande(new Client(client), nombreCasiersDemandes)){
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

	private static void modifierCommande(){
		System.out.print("Entrez le nom du client : ");
		String client = scanner.nextLine();
		System.out.println("Entrez le nombre de casier en plus : ");
		int casier = scanner.nextInt();

		if (session.modifierCommande(new Client(client), casier))
			System.out.println("La modification de la commande à été acceptée");
		else
			System.out.println("La modification de la commande à été refusée");
	}

}
