import java.util.Iterator;


public interface ListeSimple<E> extends Iterable<E>{
	
	/**
	 * renvoie le nombre d elements dans la liste
	 * @return
	 */
	int taille();

	
	/**
	 * verifie si la liste est vide
	 * @return true si la liste est vide, false sinon
	 */
	boolean estVide();

	
	/**
	 * verifie la presence de l element passe en parametre dans la liste
	 * @param element l element recherche
	 * @return true si l element est present, false sinon
	 */
	boolean contient(E element);

	
	/**
	 * renvoie l element de tete sans l enlever
	 * @return l element de tete
	 * @throws ListeVideException si la liste est vide
	 */
	E premier()throws ListeVideException;

	
	/**
	 * insere un nouvel element en tete de liste
	 * @param element le nouvel element a inserer en tete
	 */
	void insererEnTete(E element);

	
	
	/**
	 * insere le 2eme element passe en parametre apres la premiere occurrence du 1er element passe en parametre
	 * @param element l element apres lequel un nouvel element doit etre insere
	 * @param elementAInserer le nouvel element a inserer
	 * @return true si le 1er element passe en parametre est present dans la liste, false sinon
	 */
	boolean insererApres(E element, E elementAInserer);
	
	
	/**
	 * supprime de la liste la 1ere occurrence de l element passe en parametre
	 * @param element l element a supprimer
	 * @return true si l element est present, false sinon
	 */
	boolean supprimer(E element);
	
}
