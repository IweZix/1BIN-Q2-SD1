import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListeSDImpl<E> implements ListeSD<E>,Iterable<E> {

	private Noeud tete, queue;
	private HashMap<E, Noeud> mapElementNoeud;

	public ListeSDImpl () {
		mapElementNoeud = new HashMap<>();
		tete = new Noeud();
		queue = new Noeud();
		tete.suivant = queue;
		queue.precedent = tete;
	}

	/**
	 * renvoie le nombre d elements dans la liste
	 * @return
	 */
	public int taille () {
		return mapElementNoeud.size();
	}

	/**
	 * verifie si la liste est vide
	 * @return true si la liste est vide, false sinon
	 */
	public boolean estVide () {
		return taille() == 0;
	}

	/**
	 * verifie la presence de l element passe en parametre dans la liste
	 * @param element l element recherche
	 * @return true si l element est present, false sinon
	 */
	public boolean contient (E element) {
		return mapElementNoeud.containsKey(element);
	}

	/**
	 * renvoie l element de tete sans l enlever
	 * @return l element de tete ou null s'il n'y a plus d'element
	 */
	public E premier() {
		return tete.suivant.element;
	}

	/**
	 * renvoie l element de queue sans l enlever
	 * @return l element de queue ou null s'il n'y a plus d'element
	 */
	public E dernier() {
		return queue.precedent.element;

	}

	/**
	 * donne l element qui se trouve avant l element passe en parametre
	 * @param element
	 * @return l'element ou null si l element passe en parametre n est pas present ou est le premier
	 */
	public E donnerPrecedent (E element) {
		if (!mapElementNoeud.containsKey(element))
			return null;
		return mapElementNoeud.get(element).precedent.element;
	}

	/**
	 * donne l element qui se trouve apres l element passe en parametre
	 * @param element
	 * @return l'element ou null si l element passe en parametre n est pas present ou est le dernier
	 */
	public E donnerSuivant (E element) {
		if (!mapElementNoeud.containsKey(element))
			return null;
		return mapElementNoeud.get(element).suivant.element;

	}

	/**
	 * insere un nouvel element en tete de liste si celui-ci n'etait pas deja present
	 * @param element le nouvel element a inserer en tete
	 * @return true si l'element a ete ajoute, false sinon
	 */
	public boolean insererEnTete (E element){
		if (mapElementNoeud.containsKey(element))
			return false;

		Noeud n = new Noeud(element);
		Noeud nAvant = tete;
		Noeud nApres = tete.suivant;

		nAvant.suivant = n;
		n.precedent = tete;

		n.suivant = nApres;
		nApres.precedent = n;
		mapElementNoeud.put(element, n);
		return true;
	}

	/**
	 * insere un nouvel element en queue de liste si celui-ci n'etait pas deja present
	 * @param element le nouvel element a inserer en queue
	 * @return true si l'element a ete ajoute, false sinon
	 */
	public boolean insererEnQueue (E element) {
		if (mapElementNoeud.containsKey(element))
			return false;

		Noeud n = new Noeud(element);
		Noeud nAvant = queue.precedent;
		Noeud nApres = queue;

		nAvant.suivant = n;
		n.precedent = nAvant;

		n.suivant = nApres;
		nApres.precedent = n;

		mapElementNoeud.put(element, n);

		return true;

	}

	/**
	 * insere le 2eme element passe en parametre apres le 1er element passe en parametre
	 * l'insertion reussit si l'element a inserer n'est pas deja present
	 * et si l'element apres lequel le nouvel element doit etre insere est present
	 * @param element l element apres lequel un nouvel element doit etre insere
	 * @param elementAInserer le nouvel element a inserer
	 * @return true si l'insertion a reussi, false sinon
	 */
	public boolean insererApres (E element, E elementAInserer) {
		if (mapElementNoeud.containsKey(elementAInserer))
			return false;

		Noeud n = new Noeud(elementAInserer);
		Noeud nAvant = mapElementNoeud.get(element);
		if (nAvant == null)
			return false;
		Noeud nApres = nAvant.suivant;

		nAvant.suivant = n;
		n.precedent = nAvant;

		n.suivant = nApres;
		nApres.precedent = n;

		mapElementNoeud.put(elementAInserer,n);
		return true;
	}

	/**
	 * insere le 2eme element passe en parametre avant le 1er element passe en parametre
	 * l'insertion reussit si l'element a inserer n'est pas deja present
	 * et si l'element avant lequel le nouvel element doit etre insere est present
	 * @param element l element avant lequel un nouvel element doit etre insere
	 * @param elementAInserer le nouvel element a inserer
	 * @return true si l'insertion a reussi, false sinon
	 */
	public boolean insererAvant (E element, E elementAInserer) {
		if (mapElementNoeud.containsKey(elementAInserer))
			return false;

		Noeud n = new Noeud(elementAInserer);
		Noeud nApres = mapElementNoeud.get(element);
		if (nApres == null)
			return false;
		Noeud nAvant = nApres.precedent;

		nAvant.suivant = n;
		n.precedent = nAvant;

		n.suivant = nApres;
		nApres.precedent = n;

		mapElementNoeud.put(elementAInserer, n);
		return true;
	}

	/**
	 * supprime de la liste l element passe en parametre
	 * @param element l element a supprimer
	 * @return true si l element etait bien present, false sinon
	 */
	public boolean supprimer (E element) {
		Noeud nASupprimer = mapElementNoeud.get(element);
		if (nASupprimer == null)
			return false;

		Noeud nAvant = nASupprimer.precedent;
		Noeud nApres = nASupprimer.suivant;

		nAvant.suivant = nApres;
		nApres.precedent = nAvant;
		mapElementNoeud.remove(element);
		return true;
	}

	/**
	 * permute les 2 elements (pas les noeuds) passes en parametre
	 * @param element1
	 * @param element2
	 * @return true si les 2 elements sont bien presents, false sinon
	 */
	public boolean permuter (E element1, E element2) {
		Noeud noeud1 = mapElementNoeud.get(element1);
		Noeud noeud2 = mapElementNoeud.get(element2);
		if (noeud1 == null || noeud2 == null)
			return false;

		E elt1 = noeud1.element;

		noeud1.element = noeud2.element;
		noeud2.element = elt1;

		mapElementNoeud.put(element1, noeud2);
		mapElementNoeud.put(element2, noeud1);
		return true;
	}

	public Iterator<E> iterator() {
		return new IterateurImpl<E>();
	}

	public String toString () {
		String aRenvoyer = "";
		int num = 1;
		Noeud baladeur = tete.suivant;
		while (baladeur != queue) {
			aRenvoyer += num + " - " + baladeur.element + "\n";
			baladeur = baladeur.suivant;
			num++;
		}
		return aRenvoyer;   
	}



	// Classe interne Noeud
	private class Noeud{
		private E element;
		private Noeud suivant;
		private Noeud precedent;

		private Noeud() {
			this(null, null, null);
		}

		private Noeud(E element) {
			this(null, element, null);
		}

		private Noeud(Noeud precedent, E element, Noeud suivant) {
			this.element = element;
			this.suivant = suivant;
			this.precedent = precedent;
		}
	}

	

	// Classe interne IterateurImpl
	private class IterateurImpl<E> implements Iterator<E> {

		private Noeud noeudCourant;

		private IterateurImpl() {
			noeudCourant = tete.suivant;
		}

		// si il y a encore des elements
		public boolean hasNext() {
			return noeudCourant != queue;
		}

		// elements suivant
		public E next() {
			if (!hasNext()) throw new NoSuchElementException();
			E aRenvoyer = (E) noeudCourant.element;
			noeudCourant = noeudCourant.suivant;
			return aRenvoyer;
		}

		// A NE PAS COMPLETER : Les suppressions sont interdites
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	// pour les tests
	public ListeSDImpl(E[] tableACopier) {
		mapElementNoeud = new HashMap<E, Noeud>();
		tete = new Noeud();   // sentinelle de tete
		queue = new Noeud();  // sentinelle de queue
		Noeud prec = tete;
		for (int i = 0; i < tableACopier.length; i++) {
			Noeud nouveauNoeud = new Noeud(tableACopier[i]);
			mapElementNoeud.put(tableACopier[i], nouveauNoeud);
			nouveauNoeud.precedent = prec;
			prec.suivant = nouveauNoeud;
			prec = nouveauNoeud;
		}
		prec.suivant = queue;
		queue.precedent = prec;
	}

	// pour les tests
	public String teteQueue(){
		try{
			String aRenvoyer = "(";
			Noeud baladeur = tete.suivant;
			int cpt=0;
			while (baladeur != queue) {
				if(cpt==0)
					aRenvoyer += baladeur.element;
				else
					aRenvoyer += ","+baladeur.element;
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
			Noeud baladeur = queue.precedent;
			int cpt=0;
			while (baladeur != tete) {
				if(cpt==0)
					aRenvoyer += baladeur.element;
				else
					aRenvoyer += ","+baladeur.element;
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

}
