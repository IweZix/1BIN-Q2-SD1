import java.util.HashMap;

public class ListeBalPromo {

	private Noeud tete; 
	private Noeud queue; 
	private HashMap<Lyceen, Noeud> mapLyceenNoeud;

	public ListeBalPromo() {
		mapLyceenNoeud = new HashMap<Lyceen, Noeud>();
		tete=null;
		queue=null;
	}
	
	/**
	 * determine le nombre de lyceens 
	 * @return le nombre de lyceens
	 */
	public int taille () {
		return mapLyceenNoeud.size();
	}

	/**
	 * verifie si la liste ne contient aucun lyceen
	 * @return true si la liste est vide, false sinon
	 */
	public boolean estVide () {
		return mapLyceenNoeud.isEmpty();
	}
	
	
	/**
	 * determine le nombre de lyceens ages de 18 ans ou plus
	 * @return le nombre de lyceens majeurs
	 */
	public int donnerNombreLyceensMajeurs(){
		//TODO
		// contrainte : cette methode doit etre iterative
		return 0;
	
	}
	
	
	
	/**
	 * verifie si tous les lyceens ont bien 16 ans ou plus
	 * @return true si tous les lyceens ont bien 16 ans ou plus, false sinon
	 */
	public boolean ontTous16AnsOuPlus(){
		//TODO
		//contrainte : cette methode doit etre recursive
		return false;
	}
	
	
	/**
	 * donne le partenaire du lyceen passe en parametre
	 * @param lyceen le lyceen dont on cherche le partenaire
	 * @return le partenaire ou null si le lyceen n'est pas present dans la liste
	 * @throws IllegalArgumentException si le parametre est null
	 */
	public Lyceen donnerPartenaire(Lyceen lyceen){
		if(lyceen==null)
			throw new IllegalArgumentException();
		//TODO
		return null;
	}
		
	/**
	 * ajoute les 2 lyceens en fin de liste
	 * les 2 lyceens doivent etre de sexe oppose et ne peuvent pas encore etre presents dans la liste
	 * @param lyceen1 un des lyceens du couple
	 * @param lyceen2 l'autre lyceen du couple
	 * @return true si l'ajout a pu se faire, false sinon
	 * @throws IllegalArgumentException si un des parametres est null
	 * 
	 */
	public boolean ajouterCouple (Lyceen lyceen1, Lyceen lyceen2) {
		if(lyceen1==null||lyceen2==null)
			throw new IllegalArgumentException();
		//TODO
		return false;
	}


	// pour les tests
	public ListeBalPromo(Lyceen[] tableACopier) {	
		mapLyceenNoeud = new HashMap<Lyceen, Noeud>();
		if(tableACopier.length==0)
			return;
		tete = new Noeud(tableACopier[0]);
		mapLyceenNoeud.put(tableACopier[0], tete);
		Noeud prec = tete;
		for (int i = 1; i < tableACopier.length; i++) {
			Noeud nouveauNoeud = new Noeud(tableACopier[i]);
			mapLyceenNoeud.put(tableACopier[i], nouveauNoeud);
			nouveauNoeud.precedent = prec;
			prec.suivant = nouveauNoeud;
			prec = nouveauNoeud;
		}
		queue = prec;
	}

	// pour les tests
	public String teteQueue(){
		try{
			String aRenvoyer = "(";
			Noeud baladeur = tete;
			int cpt=0;
			while (baladeur != null) {
				if(cpt==0)
					aRenvoyer += baladeur.lyceen.getNom();
				else
					aRenvoyer += ","+baladeur.lyceen.getNom();
				baladeur = baladeur.suivant;
				cpt++;
				if(cpt==100){
					return "boucle infinie";
				}
			}
			return aRenvoyer+")";
		}catch (NullPointerException e){
			return "nullPointerException";
		}
	}

	// pour les tests
	public String queueTete(){
		try{
			String aRenvoyer = "(";
			Noeud baladeur = queue;
			int cpt=0;
			while (baladeur != null) {
				if(cpt==0)
					aRenvoyer += baladeur.lyceen.getNom();
				else
					aRenvoyer += ","+baladeur.lyceen.getNom();
				baladeur = baladeur.precedent;
				cpt++;
				if(cpt==100){
					return "boucle infinie";
				}
			}
			return aRenvoyer+")";
		}catch (NullPointerException e){
			return "nullPointerException";
		}
	}

	// Classe interne Noeud
	private class Noeud{
		
		private Noeud precedent;
		private Lyceen lyceen;
		private Noeud suivant;
		
		
		private Noeud(Lyceen lyceen) {
			this(null, lyceen, null);
		}

		private Noeud(Noeud precedent, Lyceen lyceen, Noeud suivant) {
			this.precedent = precedent;
			this.lyceen = lyceen;
			this.suivant = suivant;
			
		}
	}

}
