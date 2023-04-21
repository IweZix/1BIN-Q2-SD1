
public class ArbreDEntiersPlus extends ArbreDEntiers {

	public ArbreDEntiersPlus () {
		super();
	}

	public ArbreDEntiersPlus (ArbreDEntiersPlus sousArbreGauche, int entier, ArbreDEntiersPlus sousArbreDroit) {
		super(sousArbreGauche, entier, sousArbreDroit);
	}

	public ArbreDEntiersPlus (int entier) {
		super(new ArbreDEntiersPlus(),entier,new ArbreDEntiersPlus());
	}
	
	public int hauteur(){
		return hauteur(racine);
	}

	public int hauteur(NoeudEntier noeud){
		if (noeud == null) return -1;
		return 1 + Math.max(hauteur(noeud.gauche), hauteur(noeud.droit));
	}

	public boolean estCompletementRempli () {
		//TODO
		// Ex supplementaire
		//La definition (non recursive!) de cette methode est donnee dans l'enonce
		return false;
	}

	public boolean estComplet () {
		//TODO
		// Ex supplementaire
		//La definition recursive! de cette methode est donnee dans l'enonce
		return false;
	}	

}
