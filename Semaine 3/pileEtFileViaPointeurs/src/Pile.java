
public interface Pile<E> {

	/**
	 * verifie la presence d'elements sur la pile
	 * @return true si la pile est vide, false sinon
	 */
	public boolean estVide();


	/**
	 * ajoute un element sur la pile
	 * @param element l'element a ajouter
	 */	
	public void push(E element);


	/**
	 * renvoie l'element qui se trouve au sommet de la pile et l'enleve de la pile
	 * @return l'element au sommet
	 * @throws PileVideException si la pile est vide
	 */
	public E pop() throws PileVideException;

	/**
	 * renvoie l'element qui se trouve au sommet de la pile sans l'enlever de la pile
	 * @return l'element au sommet
	 * @throws PileVideException si la pile est vide
	 */
	public E sommet()throws PileVideException;

	/**
	 * renvoie le nombre d'elements qui se trouvent sur la pile
	 * @return nombre d'elements
	 */
	public int taille();

} // interface
