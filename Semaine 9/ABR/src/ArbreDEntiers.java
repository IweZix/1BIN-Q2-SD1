import java.util.ArrayList;

public class ArbreDEntiers{
	protected NoeudEntier racine; 
	protected int taille;
	
	public ArbreDEntiers () {
		this.racine=null ;
		this.taille=0;
	}

	public ArbreDEntiers (int entier) {
		this.racine=new NoeudEntier(entier) ;
		this.taille=1;
	}
	
	public ArbreDEntiers (ArbreDEntiers gauche, int entier, ArbreDEntiers droit) {
		this.racine=new NoeudEntier(gauche.racine,entier,droit.racine) ;
		this.taille= 1 + gauche.taille + droit.taille;
	}

	public boolean estVide () {
		return  this.racine == null;
	}

	public int taille () {
		return taille;
	}


	/**********************************************
	 * Debut du toString de Loic LeCharlier
	 **********************************************/
	public String toString() {
		String arbre = "\n" ;
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

	protected class NoeudEntier {
		protected int entier; 
		protected NoeudEntier gauche;
		protected NoeudEntier droit;

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

}
