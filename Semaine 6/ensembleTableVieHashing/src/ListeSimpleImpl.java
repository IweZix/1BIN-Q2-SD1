import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * implementation de l'interface ListeSimple avec une liste simplement chainee 
 * 
 * @author annick dupont
 * 
 */
public class ListeSimpleImpl<E> implements ListeSimple<E> {
	
	private Noeud tete;
	private int taille;
	private int numVersion; //pour l iterateur
	

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

	
	public int taille(){
		return taille;
	}
		
	public boolean estVide(){
		return taille==0;
	}
	
	// renvoie l element contenu dans le noeud de tete
	public E premier()throws ListeVideException{
			if(this.estVide())
			throw new ListeVideException();
		return tete.element;
	}


	// insere un nouveau noeud en tete de liste avec l element 
	public void insererEnTete(E element) {
		tete = new Noeud(element,tete);
		taille++;
		numVersion++;
	}
	

	// verifie la presence d un noeud contenant l element passe en parametre
	public boolean contient(E element){
		Noeud baladeur = tete;

		while(baladeur != null){
			if(baladeur.element.equals(element))return true;
			baladeur = baladeur.suivant;
		}		
		return false;
	}

	

	
	// insere un nouveaud noeud apres le noeud contenant la premiere occurrence de l'element passe en parametre
	public boolean insererApres(E element, E elementAInserer){
		Noeud baladeur = tete;
		while(baladeur != null){
			if(baladeur.element.equals(element)){
				Noeud nouveauNoeud = new Noeud(elementAInserer,baladeur.suivant);
				baladeur.suivant = nouveauNoeud;
				taille++;
				numVersion++;
				return true;
			}
			baladeur = baladeur.suivant;
		}
		return false;
	}
	
	//supprime le noeud contenant la premiere occurrence de l'element passe en parametre
	public boolean supprimer(E element){
		if(taille==0)
			return false;
		if(tete.element.equals(element)){
			tete = tete.suivant;
			taille--;
			numVersion++;
			return true;
		}
		Noeud baladeur = tete;
		while(baladeur.suivant != null){
			if(baladeur.suivant.element.equals(element)){
				baladeur.suivant = baladeur.suivant.suivant;
				taille--;
				numVersion++;
				return true;
			}
			baladeur = baladeur.suivant;
		}
		return false;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new IterateurImpl<E>();
	}
	
	
	private class Noeud{
		private E element;
		private Noeud suivant;

		public Noeud(E element, Noeud suivant){
			this.element = element;
			this.suivant = suivant;
		}
	}
	
	
	private class IterateurImpl<E> implements Iterator<E>{
		
		private Noeud noeudNext;
		private int version;
		
	
		// Au depart le noeud "next" est le noeud de tete
		private IterateurImpl() {
			noeudNext =   tete;
			version = numVersion;
		}
		
		@Override
		public boolean hasNext() {
			return noeudNext!=null;
		}

		@Override
		// renvoie l element qui se trouve dans le noeud "next"
		// le noeud "next" passe au noeud suivant
		public E next() {
		   if (!hasNext()) throw new NoSuchElementException();
		   if(version!=numVersion)
			   throw new ConcurrentModificationException();
		   E aRenvoyer = (E)noeudNext.element;
		   noeudNext = noeudNext.suivant;
		   return aRenvoyer;
		}

		@Override
		// A NE PAS COMPLETER : Les suppressions sont interdites
		public void remove() {
			throw new UnsupportedOperationException();			
		}
		
	}

}
