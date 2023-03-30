import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * implementation de l'interface ListeSimple avec une liste simplement chainee 
 * 
 * @author NICOLAS Luca
 * 
 */
public class ListeSimpleImpl<E> implements ListeSimple<E> {
	
	private Noeud tete;
	private int taille;
	

	public ListeSimpleImpl(){
		tete = null;
		taille=0;
	}

	// A NE PAS MODIFIER --> POUR LES TESTS!!!
	public ListeSimpleImpl(Object[] table) {
		if(table==null)
			throw new IllegalArgumentException();
		this.taille = table.length;
		for (int i = table.length-1; i>=0; i--) {
			E element = (E)table[i];
			this.tete=new Noeud(element,tete);
		}	
	}
	
	// A NE PAS MODIFIER --> POUR LES TESTS!!!
	public String toString(){
		String aRenvoyer="";
		Noeud baladeur=tete;
		int cpt = 0;
		while(baladeur!=null) {
			cpt++;
			if(cpt>taille){
				aRenvoyer = "boucle infinie dans toString(), chainage a verifier";
				return aRenvoyer;
			}
			aRenvoyer+=" "+baladeur.element;
			baladeur=baladeur.suivant;
		}
		return aRenvoyer;
	}

	/**
	 * renvoie le nombre d elements dans la liste
	 * @return
	 */
	public int taille(){
		return taille;
	}

	/**
	 * verifie si la liste est vide
	 * @return true si la liste est vide, false sinon
	 */
	public boolean estVide(){
		return taille==0;
	}

	/**
	 * renvoie l element de tete sans l enlever
	 * @return l element de tete
	 * @throws ListeVideException si la liste est vide
	 */
	// renvoie l element contenu dans le noeud de tete
	public E premier()throws ListeVideException{
		if (estVide()) throw new ListeVideException("Liste vide");
		return tete.element;
	}

	/**
	 * insere un nouvel element en tete de liste
	 * @param element le nouvel element a inserer en tete
	 */
	// insere un nouveau noeud en tete de liste avec l element 
	public void insererEnTete(E element) {
		Noeud n = new Noeud(element, tete);
		tete = n;
		taille++;
	}


	/**
	 * verifie la presence de l element passe en parametre dans la liste
	 * @param element l element recherche
	 * @return true si l element est present, false sinon
	 */
	// verifie la presence d un noeud contenant l element passe en parametre
	public boolean contient(E element){
		Noeud baladeur = tete;
		while (baladeur != null){
			if (baladeur.element.equals(element))
				return true;
			else
				baladeur = baladeur.suivant;
		}
		return false;
	}

	/**
	 * insere le 2eme element passe en parametre apres la premiere occurrence du 1er element passe en parametre
	 * @param element l element apres lequel un nouvel element doit etre insere
	 * @param elementAInserer le nouvel element a inserer
	 * @return true si le 1er element passe en parametre est present dans la liste, false sinon
	 */
	// insere un nouveaud noeud apres le noeud contenant la premiere occurrence de l'element passe en parametre
	public boolean insererApres(E element, E elementAInserer){
		if (!contient(element))
			return false;

		Noeud baladeur = tete;
		while (baladeur != null){
			if (baladeur.element.equals(element)){
				Noeud fin = new Noeud(elementAInserer, baladeur.suivant);
				fin.suivant = baladeur.suivant;
				baladeur.suivant = fin;
				taille++;
				return true;
			} else {
				baladeur = baladeur.suivant;
			}
		}
		return false;
	}


	/**
	 * supprime de la liste la 1ere occurrence de l element passe en parametre
	 * @param element l element a supprimer
	 * @return true si l element est present, false sinon
	 */
	//supprime le noeud contenant la premiere occurrence de l'element passe en parametre
	public boolean supprimer(E element){

		Noeud b = tete;
		Noeud pb = null;

		while (b != null){
			// si baladeur à trouver element
			if (b.element.equals(element)){
				// si pb == null -> ça veut dire que element à trouver était la tête
				if (pb == null){
					// on remplace la tête
					tete = tete.suivant;
				} else {
					// chainage
					pb.suivant = b.suivant;
				}
				taille--;
				return true;
			} else {
				// si le baladeur n'était pas = à l'élément rechercher
				pb = b;
				b = b.suivant;
			}
		}
		return false;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new IterateurImpl();
	}
	
	
	private class Noeud{
		private E element;
		private Noeud suivant;

		public Noeud(E element, Noeud suivant){
			this.element = element;
			this.suivant = suivant;
		}
	}
	
	
	private class IterateurImpl implements Iterator{
		
		private Noeud noeudNext;
		
	
		// Au depart le noeud "next" est le noeud de tete
		private IterateurImpl() {
			noeudNext =  tete;
		}
		
		@Override
		// verifie si le noeud "next" est null
		public boolean hasNext() {
			return noeudNext != null;
		}

		
		@Override
		// renvoie l element qui se trouve dans le noeud "next"
		// le noeud "next" passe au noeud suivant
		public E next() {
			if (estVide()){
				throw new NoSuchElementException();
			}
			E elementNext= noeudNext.element;
			noeudNext=noeudNext.suivant;
		   return null;
		}

		
		@Override
		// A NE PAS COMPLETER : Les suppressions sont interdites
		public void remove() {
			throw new UnsupportedOperationException();			
		}
		
	}

}
