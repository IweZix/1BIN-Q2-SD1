import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

public class ABRDEntiers implements Iterable<Integer> {
	private NoeudEntier racine; 
	private int taille;

	public ABRDEntiers () {
		this.racine=null ;
		this.taille=0;
	}

	public ABRDEntiers (int entier) {
		this.racine=new NoeudEntier(entier) ;
		this.taille=1;
	}

	public ABRDEntiers (ABRDEntiers gauche, int entier, ABRDEntiers droit) {
		if (gauche==null)
			throw new IllegalArgumentException();
		if (droit==null)
			throw new IllegalArgumentException();
		if (!gauche.estVide()) {
			if (gauche.max()>=entier)
				throw new IllegalArgumentException();
		}
		if (!droit.estVide()) {
			if (droit.min()<entier)
				throw new IllegalArgumentException();
		}
		this.racine = new NoeudEntier(gauche.racine,entier,droit.racine) ;
		this.taille = 1 + gauche.taille + droit.taille;
	}

	public boolean estVide () {
		return  this.racine == null;
	}

	public int taille () {
		return taille;
	}
	
	public void insere (int entier) {
		racine = insere(racine, entier);
	}
	
	private NoeudEntier insere (NoeudEntier n, int entier) {	
		if (n == null) {
			taille ++;
			return new NoeudEntier(entier);
		} else {
			if (entier < n.entier)
				n.gauche = insere(n.gauche, entier);
			else 
				n.droit = insere(n.droit, entier);
		}
		return n;
	}
	
	public Iterator<Integer> iterator () {
		return new InIterateur(this);
	}

	//-1 si vide
	public int min () {
		if (estVide())
			return -1;
		return min(racine);
	}

	private int min (NoeudEntier n) {
		if (n.gauche == null)
			return n.entier;
		return min(n.gauche);
	}

	//-1 si vide
	public int max () {
		if (estVide())
			return -1;
		return max(racine);
	}

	private int max (NoeudEntier n) {
		if (n.droit == null)
			return n.entier;
		return max(n.droit);
	}

	public ABRDEntiers equilibre() {
		Iterator<Integer> it = iterator();
		return construit(taille(),it);
	}
	
	

	private static ABRDEntiers construit (int n, Iterator<Integer> it) {
		//TODO      
		return null;
	}

	

	public boolean equals (ABRDEntiers a) {
		return equals(this.racine, a.racine);
	}

	public boolean equals (NoeudEntier n1, NoeudEntier n2) {
		if (n1 == null || n2 == null)
			return n1 == n2;
		if (n1.entier != n2.entier)
			return false;
		return equals(n1.gauche,n2.gauche) && equals(n1.droit, n2.droit);
	}
	

	/**********************************************
	 * Debut du toString de Loic LeCharlier
	 **********************************************/
	public String toStringLoic() {
		String arbre = "" ;
		if (racine!=null) {
			ArrayList<ArrayList<Object>> niveaux = niveau() ;
			int nbNiveaux = niveaux.size()-1;
			int nbBlanc = (int) Math.pow(2, nbNiveaux)-1 ;
			arbre = arbre  + this.addBlanc(nbBlanc) + racine.entier +'\n';
			for (int i=2 ; i<=nbNiveaux ;i++) {
				ArrayList<Object> niv = niveaux.get(i) ;
				int nbNoeuds = niv.size() ;
				int nbBlancInt = 1 ;
				int nbBlancExt = (int) Math.pow(2, nbNiveaux-i+3)-3 ;
				int nbLignes = (int) Math.pow(2, nbNiveaux-i+1)-1 ;
				for (int k=0 ; k<nbLignes ; k++) {
					nbBlanc-- ;
					arbre = arbre + addBlanc(nbBlanc);
					for (int j=0 ; j<nbNoeuds/2 ; j++) {
						if (niveaux.get(i-1).get(j) instanceof String) {
							arbre = arbre + " " + addBlanc(nbBlancInt) + " " ;
						} else {
							if (niv.get(2*j) instanceof String) {
								arbre = arbre + " " ;
							} else {
								arbre = arbre + "/" ;
							}
							arbre = arbre + addBlanc(nbBlancInt) ;
							if (niv.get(2*j+1) instanceof String) {
								arbre = arbre + " " ;
							} else {
								arbre = arbre + "\\" ;
							}
						}
						arbre = arbre + addBlanc(nbBlancExt) ;	
					}
					arbre = arbre + '\n' ;
					nbBlancInt+=2 ;
					nbBlancExt-=2 ;
				}
				nbBlanc = (int) Math.pow(2, nbNiveaux-i+1)-1 ;
				arbre = arbre + addBlanc(nbBlanc-1) ;
				for (int j=0 ; j<nbNoeuds ; j++) {
					if (niv.get(j) instanceof String)
						arbre = arbre + "   " ;
					else
						arbre = arbre + format((int) niv.get(j)) ;
					if (j!=nbNoeuds-1)
						arbre = arbre + addBlanc((int) Math.pow(2, nbNiveaux-i+2)-3) ;
				}
				arbre = arbre + '\n' ;
			}
		}
		return arbre ;
	}

	private String addBlanc(int n) {
		String st = "" ;
		for (int i=0 ; i<n ; i++) {
			st = st + " " ;
		}
		return st ;
	}

	private String format(int nombre) {
		String st = ""+nombre ;
		if (st.length()==1)
			st = " "+st+" " ;
		else if (st.length()==2)
			st = " "+st ;
		return st ;
	}
	private ArrayList<ArrayList<Object>> niveau() {
		ArrayList<ArrayList<Object>> niveaux = new ArrayList<ArrayList<Object>>() ;
		niveaux.add(null) ;
		niveau(racine,1,niveaux) ;
		int nbNiveaux = niveaux.size() ;
		ArrayList<Object> liste = niveaux.get(nbNiveaux-1) ;
		int taille = liste.size();
		boolean vide = true ;
		int ni=0 ;
		while (ni<taille && vide) {
			vide = liste.get(ni) instanceof String ;
			ni++ ;
		}
		if (vide) {
			niveaux.remove(nbNiveaux-1) ;
		}
		nbNiveaux = niveaux.size() ;
		for (int i=3 ;i<nbNiveaux ; i++) {
			ArrayList<Object> listep = niveaux.get(i-1) ;
			liste = niveaux.get(i) ;
			int lo = listep.size();
			for (int j=0 ; j<lo ; j++) {
				if (listep.get(j) instanceof String) {
					liste.add(2*j,"null") ;
					liste.add(2*j,"null") ;
				}
			}
		}

		return niveaux ;
	}

	private void niveau(NoeudEntier noeud, int hauteur, ArrayList<ArrayList<Object>> niveaux) {
		if (niveaux.size()<=hauteur)
			niveaux.add(new ArrayList<Object>()) ;
		niveaux.get(hauteur).add(noeud.entier) ;
		if (noeud.gauche!=null) {
			niveau(noeud.gauche,hauteur+1,niveaux) ;
			if (noeud.droit==null) {
				if (niveaux.size()<=hauteur+1)
					niveaux.add(new ArrayList<Object>()) ;
				niveaux.get(hauteur+1).add("null") ;
			} else {
				niveau(noeud.droit,hauteur+1,niveaux) ;
			}
		} else if (noeud.droit !=null) {
			if (noeud.gauche==null) {
				if (niveaux.size()<=hauteur+1)
					niveaux.add(new ArrayList<Object>()) ;
				niveaux.get(hauteur+1).add("null") ;
			} 
			niveau(noeud.droit,hauteur+1,niveaux) ;
		} else {
			if (niveaux.size()<=hauteur+1)
				niveaux.add(new ArrayList<Object>()) ;
			niveaux.get(hauteur+1).add("null") ;
			niveaux.get(hauteur+1).add("null") ;
		}
	}

	/*************************************************
	 * Fin du toString de Loic LeCharlier
	 **********************************************/ 



	public class NoeudEntier {
		private int entier; 
		private NoeudEntier gauche;
		private NoeudEntier droit;

		private NoeudEntier (int entier) {
			this.entier = entier;
			this.gauche = null;
			this.droit = null;
		}

		private NoeudEntier (NoeudEntier g,int entier,NoeudEntier d) {
			this.entier = entier;
			this.gauche = g;
			this.droit = d;
		}
	}

	private class InIterateur implements Iterator<Integer> {

		private ArrayDeque<Integer> fileDEntiers;

		public InIterateur (ABRDEntiers a) {
			fileDEntiers = new ArrayDeque<Integer>(taille);
			remplirFile(a.racine);
		}

		private void remplirFile (NoeudEntier n) {
			if (n == null) return;
			remplirFile(n.gauche);
			fileDEntiers.addLast(n.entier);
			remplirFile(n.droit);
		}

		public boolean hasNext () {
			return !fileDEntiers.isEmpty();
		}

		public Integer next () {
			return fileDEntiers.removeFirst();
		}
	}

}
