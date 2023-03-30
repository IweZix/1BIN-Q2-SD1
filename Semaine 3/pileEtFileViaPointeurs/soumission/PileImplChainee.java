/**
 * @author NICOLAS Luca
 */

public class PileImplChainee<E> implements Pile<E>{

	private Noeud sommet;
	private int taille;

	
	public PileImplChainee(){
		this.sommet=null;
		this.taille = 0;
	}

	// A NE PAS MODIFIER --> POUR LES TESTS!!!
	// base 'a' 'b' 'c' sommet : ['a','b','c']
	public PileImplChainee(Object[] table) {
		if(table == null)
			throw new IllegalArgumentException();
		this.taille = table.length;
		Noeud noeud = null;
		for (int i = 0; i < table.length; i++) {
			noeud = new Noeud((E)table[i],noeud);
		}
		this.sommet=noeud;
	}

	// A ne pas modifier ! Methode utilisee pour les tests
	public String toString(){
		String aRenvoyer="";
		Noeud baladeur=sommet;
		int cpt = 0;
		while(baladeur!=null) {
			cpt++;
			if(cpt>taille){
				return "boucle infinie dans toString(), chainage a verifier";
			}
			aRenvoyer=" "+baladeur.element+aRenvoyer;
			baladeur=baladeur.suivant;
		}
		return aRenvoyer;
	}
	
	
	public int taille() {
		return this.taille;
	}
		
	
	public boolean estVide() {
		return this.taille == 0;
	}

	/**
	 * ajoute un element sur la pile
	 * @param element l'element a ajouter
	 */
	public void push(E element) {
		Noeud n = new Noeud(element);
		n.suivant = sommet;
		sommet = n;
		taille++;
	}

	/**
	 * renvoie l'element qui se trouve au sommet de la pile et l'enleve de la pile
	 * @return l'element au sommet
	 * @throws PileVideException si la pile est vide
	 */
	public E pop() throws PileVideException {
		if (estVide()) throw new PileVideException();
		Noeud n = sommet;
		sommet = sommet.suivant;
		taille--;
		return n.element;
	}

	/**
	 * renvoie l'element qui se trouve au sommet de la pile sans l'enlever de la pile
	 * @return l'element au sommet
	 * @throws PileVideException si la pile est vide
	 */
	public E sommet() throws PileVideException {
		if (estVide()) throw new PileVideException();
		return sommet.element;
	}


	
	// classe interne
	private class Noeud{
		private E element;
		private Noeud suivant;

		private Noeud(E element, Noeud suivant){
			this.element = element;
			this.suivant = suivant;
		}

		public Noeud(E element) {
			this.element = element;
			this.suivant = null;
		}
		
		
	}

}
