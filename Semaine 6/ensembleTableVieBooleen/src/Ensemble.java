// interface Ensemble
public interface Ensemble<E>{
  
	/**
	 * verifie si l'ensemble est vide
	 * @return true si l'ensemble est vide, false sinon
	 */
	public boolean estVide();


	/**
	 * verifie la presence d'un element dans l'ensemble
	 * @param element l'element recherche
	 * @return true si l'element est present, false sinon
	 */
	public boolean contient(E element);


	/**
	 * ajoute element si element n’appartient pas a l’ensemble
	 * @param element l'element a ajouter
	 * @return true si l'element a ete ajoute, false sinon
	 */
	public boolean ajouter(E element);


	/**
	 * retire element si element appartient a l’ensemble
	 * @param element l'element a retirer
	 * @return true si l'element a ete retire, false sinon
	 */
	public boolean enlever(E element);


	/**
	 * renvoie le cardinal de l’ensemble
	 * @return le nombre d'elements presents
	 */
	public int taille();
}
