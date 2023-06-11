import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class SessionDeVente {
	
	private ArrayDeque<String> fileAttente;
	private HashSet<Client> ensembleClientsActuellementDansFile;
	private HashMap<Client, Commande> mapClientCommande;
	private ArrayList<Commande> listeCommandes;
	private int nombreCasiersRestants;
	private final static int MAX_CASIERS_CLIENT = 3;
	
	
	/**
	 * debute une session de vente
	 * @param nombreCasiersMisEnVente le nombre de casiers mis en vente
	 * @throws IllegalArgumentException s'il n'y a pas au moins un casier a vendre 
	 */
	public SessionDeVente(int nombreCasiersMisEnVente) {
		if(nombreCasiersMisEnVente<=0)
			throw new IllegalArgumentException();
		this.nombreCasiersRestants = nombreCasiersMisEnVente;
		fileAttente = new ArrayDeque<String>();
		ensembleClientsActuellementDansFile = new HashSet<Client>();
		mapClientCommande = new HashMap<Client, Commande>();
		listeCommandes = new ArrayList<Commande>();
	}

	
	public int getNombreCasiersRestants() {
		return nombreCasiersRestants;
	}
	
	/**
	 * ajoute, si possible, le client dans la file d'attente
	 * le client ne peut pas deja y etre
	 * si client a deja une commande lors de cette session de vente, le max de casiers autorise n'est pas deja atteint
	 * s'il reste encore des casiers a vendre
	 * @param client le client a ajouter
	 * @return true si l'ajout a pu se faire, false sinon
	 * @throws IllegalArgumentException si le client est null ou vide
	 */
	public boolean placerDansFileAttente(Client client){
		if (client == null)
			throw new IllegalArgumentException("placerDansFileAttente KO car -> client == null || client.eq()");
		if (ensembleClientsActuellementDansFile.contains(client))
			return false;
		if (mapClientCommande.containsKey(client)){
			if (mapClientCommande.get(client).getNombreCasiersDemandes() == MAX_CASIERS_CLIENT)
				return false;
		}
		if (nombreCasiersRestants == 0)
			return false;
		fileAttente.addLast(client.getNom());
		ensembleClientsActuellementDansFile.add(client);
		return true;
	}
		
	/**
	 * retire de la file d'attente le client de tete
	 * @return le client de tete ou null si la file est vide
	 */
	public String selectionnerClientSuivant(){
		if (ensembleClientsActuellementDansFile.isEmpty())
			return null;
		String client = fileAttente.removeFirst();
		ensembleClientsActuellementDansFile.remove(client);
		return client;
	}
	
	/**
	 * ajoute, si possible, une nouvelle commande  
	 * * le nombre de casiers restants doit etre suffisant pour satisfaire completement la commande
	 * * (il n'y a pas de commande partielle)
	 * * le nombre de casiers demandes ne peut depasser le max autorise
	 * @param client le client qui fait la demande
	 * @param nombreCasiersDemandes le nombre de casiers demandes
	 * @return true si la commande a pu etre faite, false sinon
	 * @throws IllegalArgumentException si le client est null ou vide
	 *  	ou si le nombre de casiers demandés est <=0
	 * @throws IllegalStateException si le client a deja fait une commande  
	 */
	public boolean passerNouvelleCommande(Client client, int nombreCasiersDemandes){
		if (client == null || nombreCasiersDemandes <= 0)
			throw new IllegalArgumentException();
		if (mapClientCommande.containsKey(client))
			throw new IllegalStateException();
		if (nombreCasiersDemandes > nombreCasiersRestants)
			return false;
		if (nombreCasiersDemandes > MAX_CASIERS_CLIENT)
			return false;
		Commande commande = new Commande(client, nombreCasiersDemandes);
		nombreCasiersRestants -= nombreCasiersDemandes;
		mapClientCommande.put(client, commande);
		listeCommandes.add(commande);
		ensembleClientsActuellementDansFile.remove(client);
		client.setPriorite(client.getPriorite()-1);
		return true;
	}	
		
	
	/**
	 * modifie, si possible, une commande existante
	 * le nombre de casiers restants doit etre suffisant
	 * (il n'y a pas de commande partielle)
	 * le nombre total de casiers apres ajout de ce nombre de casiers supplementaires ne peut depasser le max autorise
	 * @param client le client qui veut modifier sa commande
	 * @param nombreCasiersDemandesEnPlus le nombre de casiers a ajouter au nombre de casiers deja commande
	 * @return true si la commande a pu etre modifiee, false sinon
	 * @throws IllegalArgumentException si le client est null ou vide
	 *  	ou si le nombre de casiers demandes est <= 0
	 * @throws IllegalStateException si le client n'a pas encore fait de commande lors de cette session de commande
	 */
	public boolean modifierCommande(Client client,int nombreCasiersDemandesEnPlus){
		if (client == null || nombreCasiersDemandesEnPlus <= 0)
			throw new IllegalArgumentException();
		if (!aDejaCommande(client))
			throw new IllegalStateException();
		if (!nombreCasierSuffisant(nombreCasiersDemandesEnPlus))
			return false;
		Commande commande = mapClientCommande.get(client);
		int nbrCasierTotal = commande.getNombreCasiersDemandes() + nombreCasiersDemandesEnPlus;
		if (nbrCasierTotal > MAX_CASIERS_CLIENT)
			return false;
		nombreCasiersRestants -= nombreCasiersDemandesEnPlus;
		commande.setNombreCasiersDemandes(nbrCasierTotal);
		mapClientCommande.put(client, commande);
		return true;
	}


	/**
	 * vérifie si le client à déjà passer une commande
	 * @param client le client à vérifier
	 * @return true si déjà commandé, sinon false
	 */
	private boolean aDejaCommande(Client client){
		return mapClientCommande.containsKey(client);
	}

	/**
	 * vérifie si il reste assez de casiers
	 * @param nbrCasierDemander me nombre de casier demander
	 * @return true si il reste assez de casier, sinon false
	 */
	private boolean nombreCasierSuffisant(int nbrCasierDemander){
		return nombreCasiersRestants - nbrCasierDemander > 0;
	}


	
	
	public String toString(){
		// cette methode ne sera pas evaluee
		// elle peut-etre interessante a appeler en cas de bug
		// n'hesitez pas a la completer
		return "le nombre de casiers restants : "+ nombreCasiersRestants 
				+ "\nla file d'attente : "+ fileAttente +  "\nles commandes " + listeCommandes;
	}

}

		
	
	
	
	
	

