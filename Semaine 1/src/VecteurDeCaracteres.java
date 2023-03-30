// implementation d'un vecteur en utilisant un tableau de taille variable redimensionnable

public interface VecteurDeCaracteres {
	
	/**
	 * verifie si le vecteur est vide
	 * @return true si le vecteur est vide, false sinon
	 */
	boolean estVide();
	
	
	/**
	 * renvoie la taille logique
	 * @return le nombre de caracteres contenu dans le vecteur
	 */
	int taille(); 
	
	
	String toString();
	
	
	
	/**
	 * renvoie le caractere qui se trouve au rang passe en parametre
	 * @param rang 
	 * @return un caractere
	 * @throws VecteurOutException s'il n'y a pas d'element correspondant a ce rang
	 */
	char element(int rang)throws VecteurOutException;
	
	
	
	/**
	 * insere un caractere au rang passe en parametre
	 * l'ordre des caracteres doit etre conserve 
	 * @param rang
	 * @param caractere
	 * @throws VecteurOutException si ce n'est pas possible de mettre un caractere a ce rang
	 */
	void insere(int rang, char caractere)throws VecteurOutException;

	
	
	/**
	 * ajoute le caractere a la fin du vecteur
	 * @param caractere
	 */
	void ajoute(char caractere); 
	
	
	
	
	/**
	 * remplace un caractere par le caractere passe en parametre
	 * @param rang le rang du caractere a remplacer
	 * @param caractere le nouveau caractere
	 * @return le caractere qui a ete remplace
	 * @throws VecteurOutException s'il n'y a pas d'element correspondant a ce rang
	 */
	char remplace(int rang, char caractere)throws VecteurOutException;
	
	
	
	/**
	 * supprime le caractere au rang passe en parametre
	 * l'ordre des caracteres doit etre conserve 
	 * @param rang
	 * @return le caractere qui a ete supprime
	 * @throws VecteurOutException s'il n'y a pas d'element correspondant a ce rang
	 */
	char supprime(int rang)throws VecteurOutException;

}
