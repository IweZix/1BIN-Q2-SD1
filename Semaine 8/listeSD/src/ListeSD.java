import java.util.Iterator;

public interface ListeSD<E> extends Iterable<E>{
	
	/**
	 * renvoie le nombre d elements dans la liste
	 * @return
	 */
	public int taille();

	
	/**
	 * verifie si la liste est vide
	 * @return true si la liste est vide, false sinon
	 */
	public boolean estVide();

	
	/**
	 * verifie la presence de l element passe en parametre dans la liste
	 * @param element l element recherche
	 * @return true si l element est present, false sinon
	 */
	boolean contient(E element);

	
	/**
	 * renvoie l element de tete sans l enlever
	 * @return l element de tete ou null s'il n'y a plus d'element
	 */
	E premier();
	
	
	/**
	 * renvoie l element de queue sans l enlever
	 * @return l element de queue ou null s'il n'y a plus d'element
	 */
	E dernier();


	/**
	 * donne l element qui se trouve avant l element passe en parametre
	 * @param element
	 * @return l'element ou null si l element passe en parametre n est pas present ou est le premier
	 */
	E donnerPrecedent(E element);


	/**
	 * donne l element qui se trouve apres l element passe en parametre
	 * @param element
	 * @return l'element ou null si l element passe en parametre n est pas present ou est le dernier
	 */
	E donnerSuivant(E element);

	
	/**
	 * insere un nouvel element en tete de liste si celui-ci n'etait pas deja present
	 * @param element le nouvel element a inserer en tete
	 * @return true si l'element a ete ajoute, false sinon
	 */
	boolean insererEnTete(E element);

	
	/**
	 * insere un nouvel element en queue de liste si celui-ci n'etait pas deja present
	 * @param element le nouvel element a inserer en queue
	 * @return true si l'element a ete ajoute, false sinon
	 */
	boolean insererEnQueue(E element);


	
	/**
	 * insere le 2eme element passe en parametre apres le 1er element passe en parametre
	 * l'insertion reussit si l'element a inserer n'est pas deja present 
	 * et si l'element apres lequel le nouvel element doit etre insere est present
	 * @param element l element apres lequel un nouvel element doit etre insere
	 * @param elementAInserer le nouvel element a inserer
	 * @return true si l'insertion a reussi, false sinon
	 */
	boolean insererApres(E element, E elementAInserer);
	
	
	/**
	 * insere le 2eme element passe en parametre avant le 1er element passe en parametre
	 * l'insertion reussit si l'element a inserer n'est pas deja present 
	 * et si l'element avant lequel le nouvel element doit etre insere est present
	 * @param element l element avant lequel un nouvel element doit etre insere
	 * @param elementAInserer le nouvel element a inserer
	 * @return true si l'insertion a reussi, false sinon
	 */
	boolean insererAvant(E element, E elementAInserer);
	
	
	/**
	 * supprime de la liste l element passe en parametre
	 * @param element l element a supprimer
	 * @return true si l element etait bien present, false sinon
	 */
	boolean supprimer(E element);

	
	/**
	 * permute les 2 elements passes en parametre
	 * @param element1
	 * @param element2
	 * @return true si les 2 elements sont bien presents, false sinon
	 */
	boolean permuter(E element1, E element2);
	
	

}
