
public interface FileDePrioriteDEntiers {
	
	/**
	 * renvoie le nombre d entiers dans la file de priorite
	 * @return
	 */
	int taille ();
	
	/**
	 * verifie si la file de priorite est vide
	 * @return true si la file de priorite est vide, false sinon
	 */
	boolean estVide();
	
	/**
	 * insere un nouvel entier dans la file de priorite. 
	 * Plus l'entier est grand, plus il a une plus grande priorite.
	 * @param entier le nouvel entier a inserer
	 */
	void insere (int entier);
	
	/**
	 * supprime l'entier le plus grand
	 * @return l'entier le plus grand qui a ete supprime
	 * @throws FileVideException si la file est vide
	 */
	int supprimeMax ();
}
