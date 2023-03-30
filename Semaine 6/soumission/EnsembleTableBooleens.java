/**
 * @author NICOLAS Luca
 */


// implementation de l'interface Ensemble via un tableau de booleens

public class EnsembleTableBooleens<E> implements Ensemble<E>{
   
 	private boolean[] table; 
	private int taille;

	// capacité = nombre d'elements de l'univers
	public EnsembleTableBooleens(int capacite){
		table = new boolean[capacite];	
		taille = 0;		
	}

	/**
	 * Renvoie le cardinal de l'ensemble
	 * @return le nombre d'élements presents
	 */
	public int taille(){
		return taille;
	}

	/**
	 * Vérifie si l'ensemble est vide
	 * @return true si l'ensemble est vide, false sinon
	 */
	public boolean estVide(){
		for (boolean b : table) {
			if (b)
				return false;
		}
		return true;
	}

	/**
	 * verifie la presence d'un element dans l'ensemble
	 * @param element l'element recherche
	 * @return true si l'element est present, false sinon
	 */
	public boolean contient(E element){
		return table[element.hashCode()];
	}

	/**
	 * ajoute element si element n'appartient pas a l'ensemble
	 * @param element l'element a ajouter
	 * @return true si l'element a ete ajoute, false sinon
	 */
	public boolean ajouter(E element){
		if (table[element.hashCode()])
			return false;
		table[element.hashCode()] = true;
		taille++;
		return true;
	}

	/**
	 * ajoute element si element nappartient pas a lensemble
	 * @param element l'element a ajouter
	 * @return true si l'element a ete ajoute, false sinon
	 */
	public boolean enlever(E element){
		if (!table[element.hashCode()])
			return false;
		table[element.hashCode()] = false;
		taille--;
		return true;

	}

}