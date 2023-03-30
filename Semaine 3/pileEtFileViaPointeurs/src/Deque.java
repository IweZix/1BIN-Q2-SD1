public interface Deque<E> {

	/**
	 * verifie si le deque est vide
	 * @return true si le deque est vide, false sinon
	 */
	boolean estVide();
	
	
	/**
	 * renvoie le nombre d'elements qui se trouvent dans le deque
	 * @return nombre d'elements
	 */
	int taille();
	
	
	/**
	 * ajoute un element au debut du deque (tete)
	 * @param element l'element a ajouter
	 */	
	void ajouterEnPremier(E element);
	
	
	/**
	 * renvoie l'element qui se trouve en tete du deque et l'enleve du deque
	 * @return l'element en tete
	 * @throws DequeVideException si le deque est vide
	 */
	E retirerPremier() throws DequeVideException;

	
	/**
	 * ajoute un element en fin du deque (queue)
	 * @param element l'element a ajouter
	 */	
	void ajouterEnDernier(E element);

	
	/**
	 * renvoie l'element qui se trouve en queue du deque et l'enleve du deque
	 * @return l'element en queue
	 * @throws DequeVideException si le deque est vide
	 */
	E retirerDernier() throws DequeVideException;
	
	
	/**
	 * renvoie l'element qui se trouve en tete du deque sans l'enlever du deque
	 * @return l'element en tete
	 * @throws DequeVideException si le deque est vide
	 */
	E premier()throws DequeVideException;

	
	/**
	 * renvoie l'element qui se trouve en queue du deque sans l'enlever du deque
	 * @return l'element en queue
	 * @throws DequeVideException si le deque est vide
	 */
	E dernier()throws DequeVideException;

}
