import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ABR2022 implements Iterable<Integer> {

	private NoeudEntier racine;

	public ABR2022() {
		racine = null;
	}

	public boolean estVide() {
		return racine == null;
	}

	//! CONTRAINTE : cette methode doit être iterative
	public int nombreNegatifsVI(){
		int nbrNeg = 0;
		for (Integer integer : this) {
			if (integer < 0)
				nbrNeg++;
		}
		return nbrNeg;
	}

	//! CONTRAINTE : cette methode doit être recursive
	public int nombreNegatifsVR(){
		return nombreNegatifsVR(racine);
	}

	public int nombreNegatifsVR(NoeudEntier noeud){
		if (noeud == null) return 0;
		if (noeud.entier >= 0)
			return nombreNegatifsVR(noeud.gauche);
		return 1 + nombreNegatifsVR(noeud.gauche) + nombreNegatifsVR(noeud.droit);
	}

	//! CONTRAINTE : cette methode doit être iterative
	//! N'utilisez pas une methode nombrePositifs()!
	public boolean tousPositifsVI() {
		for (Integer integer : this) {
			if (integer < 0)
				return false;
		}
		return true;
	}

	//! CONTRAINTE : cette methode doit être recursive
	//! N'utilisez pas une methode nombrePositifs()!
	public boolean tousPositifsVR() {
		return tousPositifsVR(racine);
	}

	public boolean tousPositifsVR(NoeudEntier noeud){
		if (noeud == null) return true;
		if (noeud.entier > 0)
			return tousPositifsVR(noeud.gauche);
		if (noeud.entier < 0)
			return false;
		return tousPositifsVR(noeud.gauche) && tousPositifsVR(noeud.droit);
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterateur();
	}

	private class Iterateur implements Iterator<Integer> {
		private ArrayDeque<Integer> fileDEntiers;

		public Iterateur () {
			fileDEntiers = new ArrayDeque<Integer>();
			remplirFile(racine);
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
			if(!hasNext())
				throw new NoSuchElementException();
			return fileDEntiers.removeFirst();
		}

	}

	public class NoeudEntier {

		private int entier;
		private NoeudEntier gauche;
		private NoeudEntier droit;

		private NoeudEntier (int entier) {
			this.entier = entier;
			this.gauche = null;
			this.droit = null;
		}

		private NoeudEntier (NoeudEntier g, int entier, NoeudEntier d) {
			this.entier = entier;
			this.gauche = g;
			this.droit = d;
		}
	}

	// pour les tests

	public ABR2022 (int entier) {
		this.racine = new NoeudEntier(entier) ;
	}

	// pour les tests - attention ne verifie pas si tri ABR respecte!
	public ABR2022 (ABR2022 filsGauche, int entier, ABR2022 filsDroit) {
		this.racine = new NoeudEntier(filsGauche.racine, entier, filsDroit.racine);

	}
}
