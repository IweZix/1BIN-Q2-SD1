/**
 * @author NICOLAS Luca
 */

public class Patrouille {

	private String nomPatrouille;
	private Noeud tete; 
	private int nombreScouts; // le CP est compris dans ce nombre

	/**
	 * construit une patrouille avec, comme CP, le scout passe en parametre
	 * @param nomPatrouille le nom de la patrouille
	 * @param CP le scout qui est le CP
	 * @throws IllegalArgumentException en cas de parametres null ou vide
	 */
	public Patrouille(String nomPatrouille, String CP){
		if(nomPatrouille == null || nomPatrouille.length()==0)
			throw new IllegalArgumentException();
		if(CP == null || CP.length()==0)
			throw new IllegalArgumentException();
		nomPatrouille = nomPatrouille;
		tete = new Noeud(CP);
		nombreScouts = 1;
	}
	
	public int getNombreScouts(){
		return nombreScouts;
	}

	/**
	 * ajoute le scout apres son CP	
	 * (les homonymes sont acceptes)
	 * @param scout le scout a ajouter
	 * @throws IllegalArgumentException en cas de parametre null ou vide
	 */
	public void ajouterScout(String scout){
		if(scout == null || scout.length()==0)
			throw new IllegalArgumentException();
		Noeud n = new Noeud(scout);
		if (tete.suivant == null){
			tete.suivant = n;
			nombreScouts++;
		} else {
			Noeud s = tete.suivant;
			n.suivant = s;
			tete.suivant = n;
			nombreScouts++;
		}
	}
	

	// A NE PAS MODIFIER
	// VA SERVIR POUR LES TESTS
	public String  toString(){
		String aRenvoyer="["+tete.scout;
		Noeud baladeur = tete.suivant;
		int cpt = 0;
		while(baladeur!=null) {
			cpt++;
			if(cpt>nombreScouts){
				return "boucle infinie dans toString(), chainage a verifier";
			}
			aRenvoyer=aRenvoyer+ ", "+baladeur.scout;
			baladeur=baladeur.suivant;
		}
		return aRenvoyer+"]";

	}

	// Classe interne Noeud
	private class Noeud{
		
		private String scout;
		private Noeud suivant;
		
		public Noeud(String scout) {
			this.scout = scout;
		}

		public Noeud(String scout, Noeud suivant) {
			super();
			this.scout = scout;
			this.suivant = suivant;
		}		
	}
}
