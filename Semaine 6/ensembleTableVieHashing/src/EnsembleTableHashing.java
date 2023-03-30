/**
 * implementation de l'interface Ensemble via une table de listes
 * @author 
 *
 */

public class EnsembleTableHashing<E> implements Ensemble<E>{
	
	private ListeSimpleImpl<E>[] tableListes;
	private int taille;
	private double loadFactor;  //pour le defi 

	// taille : taille logique 
	// capacite : taille physique 
	public EnsembleTableHashing(int capacite){
		taille = 0;
		tableListes = new ListeSimpleImpl[capacite];
		for (int i = 0; i < capacite; i++) {
			tableListes[i] = new ListeSimpleImpl<>();
		}
	}
	
	// taille : taille logique 
	// capacite : taille physique 
	public EnsembleTableHashing(int capacite, double loadFactor){	
		// pour le  defi
		this(capacite);
		this.loadFactor = loadFactor;
	}

	/**
	 * verifie si l'ensemble est vide
	 * @return true si l'ensemble est vide, false sinon
	 */
	public boolean estVide(){
		return taille == 0;
	}

	/**
	 * renvoie le cardinal de l�ensemble
	 * @return le nombre d'elements presents
	 */
	public int taille(){
		return taille;
	}

	/**
	 * verifie la presence d'un element dans l'ensemble
	 * @param element l'element recherche
	 * @return true si l'element est present, false sinon
	 */
	public boolean contient(E element){
		// Attention la methode hashCode() renvoie un entier quelconque
		// Il n'est donc pas necessairement compris entre 0 et taille physique de la table
		// Il pourrait meme etre negatif
		// solution pbm compris entre 0 et taille physique : % taille physiqye
		// solution pbm negatif : Math.abs()
		return tableListes[Math.abs(element.hashCode()) % tableListes.length].contient(element);
	}

	/**
	 * ajoute element si element n�appartient pas a l�ensemble
	 * @param element l'element a ajouter
	 * @return true si l'element a ete ajoute, false sinon
	 */
	public boolean ajouter(E element) {
		if (!contient(element)){
			tableListes[Math.abs(element.hashCode()) % tableListes.length].insererEnTete(element);
			taille++;
			return true;
		}
		return false;
	}

	/**
	 * retire element si element appartient a l�ensemble
	 * @param element l'element a retirer
	 * @return true si l'element a ete retire, false sinon
	 */
	public boolean enlever(E element) {
		if (contient(element)){
			tableListes[Math.abs(element.hashCode()) % tableListes.length].supprimer(element);
			taille--;
			return true;
		}
		return false;
	}
	
	
	public String toString(){
	
		// Pour le debug cette methode renvoie le contenu de la structure de donnees utilisee
		// on y voit apparaitre une table avec les differentes listes, meme celles qui sont vides!
		// la methode proposee est utilisee par la classe de tests pour le defi

		// Cette methode devrait renvoyer uniquement les donnees comprises dans l'ensemble
		// Ex supplementaire 
		
		
		String aRenvoyer="";
		for (int i = 0; i < tableListes.length; i++) {
			aRenvoyer += "\ntable"+i+tableListes[i];
		}
		return aRenvoyer;
	}



}

