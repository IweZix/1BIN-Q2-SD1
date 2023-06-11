public class FileDePrioriteDEntiersImpl implements FileDePrioriteDEntiers {
	
	private int [] arbre ; 
	private int taille; 	//taille logique 

	
	public FileDePrioriteDEntiersImpl(int capacite) {
		arbre = new int[capacite];
		taille=0;
	}
	
	
	public FileDePrioriteDEntiersImpl() {
		this(4);
	}

	/**
	 * renvoie le nombre d entiers dans la file de priorite
	 * @return la taille
	 */
	public int taille() {	
		return taille;
	}


	/**
	 * verifie si la file de priorite est vide
	 * @return true si la file de priorite est vide, false sinon
	 */
	public boolean estVide() {
		return taille==0;
	}

	
	private int indiceParent(int i) { 
		return ((i-1)/2); 
	} 
	
	
	private int indiceGauche(int i) { 
		return (2*i+1); 
	} 
	
	
	private int indiceDroit(int i) { 
		return (2*i + 2); 
	} 
	
	
	private void pushUp(int i){
		// cas bete : i est la racine
		if(i==0)
			return;
		// cas récursif : i n'est pas la racine
		// si le parent est plus grand que l'entier à la position i, on ne fait rien
		if(arbre[indiceParent(i)]>=arbre[i])
			return;
		// sinon, on permute le parent et l'entier à la position i
		int temp = arbre[indiceParent(i)];
		arbre[indiceParent(i)]=arbre[i];
		arbre[i]=temp;
		// et on rappelle la methode pushUp() à partir du parent
		pushUp(indiceParent(i));
	}


	/**
	 * insere un nouvel entier dans la file de priorite.
	 * Plus l'entier est grand, plus il a une plus grande priorite.
	 * @param entier le nouvel entier a inserer
	 */
	public void insere(int entier) {
		// agrandissement de la table si celle-ci est pleine
		if(arbre.length==taille){
			int[] arbreTemp = new int[arbre.length*2];
			for (int i = 0; i < arbre.length; i++) {
				arbreTemp[i]=arbre[i];
			}
			arbre = arbreTemp;
		}
		// on place l'entier en fin de table (taille logique)
		arbre[taille]=entier;
		// on reorganise l'arbre pour qu'il soit complet
		// appel de la methode recursive pushUp() a partir du nouvel entier insere
		pushUp(taille);
		// ne pas oublier d'augmenter la taille logique de la table
		taille++;

	}
	

	private void pushDown(int i){

		// feuille

		// une feuille n'a pas de fils, donc il n'y a pas de permutation a envisager
		// c'est termine : cas bete 1
		// l'arbre est complet, donc si pas de fils gauche, d'office il n'a pas de fils droit
		if(indiceGauche(i)>=taille)
			return;


		// noeud interne avec uniquement fils droit
		// l'arbre est complet, donc ce n'est pas possible


		// noeud interne avec uniquement fils gauche

		// Ce cas ne doit pas etre prevu si le pushDown est uniquement utilise par supprimeMax()
		// L'"ancien" fils droit est d'office <= que son parent
		/*
		if(indiceDroit(i)>=taille){
			if(arbre[i]>=arbre[indiceGauche(i)])
				return;
			int temp = arbre[i];
			arbre[i]=arbre[indiceGauche(i)];
			arbre[indiceGauche(i)]=temp;
			return;
		}
		*/


		// noeud interne avec 2 fils

		// Si le parent est plus grand que ses 2 fils, il n'y a pas de permutation a faire
		// L'arbre est complet
		// C'est termine : cas bete 2
		if(arbre[i]>=arbre[indiceGauche(i)]&&arbre[i]>=arbre[indiceDroit(i)])
			return;

		// Au moins un des 2 fils est plus grand
		// Pour que l'arbre soit complet, le plus grand doit devenir le parent
		// Il faut faire une permutation et un appel recursif
		// Recherche du fils le plus grand
		// Si c'est le gauche :
		if(arbre[indiceGauche(i)]>=arbre[indiceDroit(i)]){
			int temp = arbre[i];
			arbre[i]=arbre[indiceGauche(i)];
			arbre[indiceGauche(i)]=temp;
			pushDown(indiceGauche(i));
			return;
		}
		// Si c'est le droit :
		int temp = arbre[i];
		arbre[i]=arbre[indiceDroit(i)];
		arbre[indiceDroit(i)]=temp;
		pushDown(indiceDroit(i));
	}

	/**
	 * supprime l'entier le plus grand
	 * @return l'entier le plus grand qui a ete supprime
	 * @throws FileVideException si la file est vide
	 */
	public int supprimeMax(){
		if(estVide())
			throw new FileVideException();
		// on recupere l'entier le plus grand
		int aRenvoyer = arbre[0];
		// on le remplace par le dernier entier de la table
		arbre[0]=arbre[taille-1];
		// on diminue la taille logique de la table
		taille--;
		// on reorganise l'arbre pour qu'il soit complet
		// appel de la methode recursive pushDown() a partir de la racine
		pushDown(0);
		// on renvoie l'entier le plus grand
		return aRenvoyer;
	}
	
	
	// A NE PAS MODIFIER!!!
	// VA SERVIR POUR LES TESTS
	public String toString(){
		String aRenvoyer = "";
		for (int i = 0; i < taille; i++) {
			aRenvoyer+=" "+arbre[i];
		}
		return aRenvoyer;
	}

}
