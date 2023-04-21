// Arbre binaire contenant des caracteres

public class ArbreDeCaracteres {
		
	protected NoeudCaractere racine; 
	
	public ArbreDeCaracteres () {
		this.racine=null ;
	}
	
	/**
	 * Cree un arbre a partir d'un arbre.
	 * Attention prend juste la reference, ne fait pas une copie.
	 * @param arbre
	 */
	public ArbreDeCaracteres (ArbreDeCaracteres arbre) {
		this.racine = arbre.racine;
	}

	public ArbreDeCaracteres (char caractere) {
		this.racine = new NoeudCaractere(caractere) ;
	}
	
	public ArbreDeCaracteres (char caractere, ArbreDeCaracteres filsGauche, ArbreDeCaracteres filsDroit) {
		this.racine = new NoeudCaractere(caractere, filsGauche.racine, filsDroit.racine) ;
	}

	public boolean estVide () {
		return  this.racine == null;
	}
	
	protected class NoeudCaractere {
		protected char caractere; 
		protected NoeudCaractere gauche;
		protected NoeudCaractere droit;

		public NoeudCaractere (char caractere) {
			this.caractere = caractere;
			this.gauche = null;
			this.droit = null;
		}
		
		public NoeudCaractere (char caractere, NoeudCaractere gauche, NoeudCaractere droit) {
			this.caractere = caractere;
			this.gauche = gauche;
			this.droit = droit;
		}
	} 

}