public class DequeImplChaineeSS<E> implements Deque<E> {

	private Noeud tete ;
	private Noeud queue ;
	private int taille ;
	
	public DequeImplChaineeSS(){
		tete=null;
		queue=null;
		taille=0;
	}

	public int taille() {
		return this.taille ;
	}

	public boolean estVide() {
		return (taille==0) ;
	}

	public void ajouterEnPremier(E element) {
		//TODO
	}

	public E retirerPremier() {
		//TODO
		return null;
	}

	public void ajouterEnDernier(E element) {
		//TODO
	}

	public E retirerDernier() throws DequeVideException {
		//TODO
		return null;
	}

	public E premier()throws DequeVideException {
		//TODO
		return null;
	}

	public E dernier()throws DequeVideException {
		//TODO
		return null;
	}

	// A NE PAS MODIFIER --> POUR LES TESTS!!!
	// tete 'a' 'b' 'c' queue : ['a','b','c']
	public DequeImplChaineeSS(Object[] table) {
		if(table == null)
			throw new IllegalArgumentException();
		taille = 0 ;
		tete = null ;
		queue = null ;
		if(table.length==0)
			return;
		for (int i = table.length-1; i>=0;i--) {
			this.ajouterTest((E) table[i]) ;
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
			}
			aRenvoyer+=baladeur.element;
			if (baladeur.suivant !=null)
				aRenvoyer += " " ;
			baladeur=baladeur.suivant;
		}
		return aRenvoyer;
	}

	// A NE PAS MODIFIER --> POUR LES TESTS!!!
	public String parcoursInverse(){
		String aRenvoyer="";
		Noeud baladeur=queue;
		int cpt = 0;
		while(baladeur!=null) {
			cpt++;
			if(cpt>taille){
				aRenvoyer = "boucle infinie dans toString(), chainage a verifier";
			}
			aRenvoyer+=baladeur.element;
			if (baladeur.precedent !=null)
				aRenvoyer += " " ;
			baladeur=baladeur.precedent;
		}
		return aRenvoyer;
	}

	// A NE PAS MODIFIER --> POUR LES TESTS!!!
	private void ajouterTest(E element) {
		if (estVide()) {
			tete = new Noeud(element,null,null) ;
			queue = tete ;
		} else {
			tete.precedent = new Noeud(element,null,tete) ;
			tete = tete.precedent;
		}
		taille = taille + 1 ;
	}

	
	// classe interne
	private class Noeud{
		private E element;
		private Noeud precedent;
		private Noeud suivant;

		private Noeud(E element, Noeud precedent, Noeud suivant){
			this.element = element;
			this.precedent = precedent ;
			this.suivant = suivant;
		}
	}

}
