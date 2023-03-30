// interface File 

public interface File<E> {

	/**
	 * verifie si la file est vide
	 * @return true si la file est vide, false sinon
	 */
	public boolean estVide();


	/**
	 * ajoute un element en fin de file (queue)
	 * @param element l'element a ajouter
	 */	
	public void enfile(E element);



	/**
	 * renvoie l'element qui se trouve en tete de file et l'enleve de la file
	 * @return l'element en tete
	 * @throws FileVideException si la file est vide
	 */
	public E defile() throws FileVideException;



	/**
	 * renvoie l'element qui se trouve en tete de file sans l'enlever de la file
	 * @return l'element en tete
	 * @throws FileVideException si la file est vide
	 */
	public E premier()throws FileVideException;



	/**
	 * renvoie le nombre d'elements qui se trouvent dans la file
	 * @return nombre d'elements
	 */
	public int taille();
		 
} // interface
