public interface EnsembleTrie<E>{
	
	/**
	 * verifie si l'ensemble est vide
	 * @return true si l'ensemble est vide, false sinon
	 */
	public boolean estVide();

	
	/**
	 * renvoie le cardinal de l ensemble
	 * @return le nombre d'elements presents
	 */
	public int taille();
	

	
	/**
	 * renvoie le plus petit element de l ensemble
	 * @return le min ou null si l'ensemble est vide
	 */
	public E min();


	/**
	 * ajoute element si element n appartient pas a l ensemble
	 * @param element l'element a ajouter
	 * @return true si l'element a ete ajoute, false sinon
	 */
	public boolean ajouter(E element);

	
	/**
	 * renvoie le plus grand element qui est strictement plus petit que l'element passe en parametre
	 * @param element l'element dont on recherche le predecesseur
	 * @return l'element predecesseur ou null si un tel element n'existe pas
	 */
	public E predecesseur(E element);

	
	
}
