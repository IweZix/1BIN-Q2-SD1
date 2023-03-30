/**
 * @author NICOLAS Luca
 *
 */

public class VecteurDeCaracteresImpl implements VecteurDeCaracteres{
	
	private static final int CAPACITE_MIN = 4;		// taille physique de depart pour le constructeur sans parametre
	private char[] table;
	private int taille;

	/**
	 * construit un vecteur avec 0 caractere mais pouvant contenir jusqu'a CAPACITE_MIN caracteres
	 */
	public VecteurDeCaracteresImpl() {
		this.table=new char[CAPACITE_MIN];
		this.taille=0;
	}

	/**
	 * construit un vecteur avec 0 caractere mais pouvant contenir jusqu'a capacite caracteres
	 * @param capacite capacite de depart
	 * @throws IllegalArgumentException si la capacite de depart est negative ou nulle
	 */
	public VecteurDeCaracteresImpl(int capacite) {
		if(capacite<=0){
			throw new IllegalArgumentException("la capacite ne peut etre negative ou nulle");
		}
		this.table=new char[capacite];
		this.taille=0;
	}
	
	// A ne pas modifier!!! Va servir pour les tests
	/**
	 * constructeur par recopie
	 * @param capacite taille physique du vecteur
	 * @param tableARecopier table contenant les caracteres a recopier
	 * @throws IllegalArgumentException si la capacite de depart est negative ou nulle
	 *                               ou si la table a recopier est null 
	 *                               ou si taille physique < taille logique 
	 */
	public VecteurDeCaracteresImpl(int capacite,char[]tableARecopier){
		if(capacite<=0)
			throw new IllegalArgumentException("capacite negative ou nulle");
		if(tableARecopier==null)
			throw new IllegalArgumentException("table a recopier null");
		if(tableARecopier.length>capacite)
			throw new IllegalArgumentException("taille physique < taille logique");
		this.table=new char[capacite];
		this.taille=tableARecopier.length;
		for (int i = 0; i < tableARecopier.length; i++) {
			table[i]=tableARecopier[i];
		}
	}
	
	// A ne pas modifier!!! Va servir pour les tests
	public String toString(){
		String aRenvoyer="";
		if(taille>0){
			aRenvoyer+="'"+table[0]+"'";
			for (int i = 1; i < taille; i++) {
				aRenvoyer+=" "+"'"+ table[i]+"'";
			}
		}
		return aRenvoyer;
	}
	
	// taille logique de la table
	public int taille() {
		return taille;
	}
	
	
	public boolean estVide() {
		return (taille==0);
	}

	/**
	 * renvoie le caractere qui se trouve au rang passe en parametre
	 * @param rang
	 * @return un caractere
	 * @throws VecteurOutException s'il n'y a pas d'element correspondant a ce rang
	 */
	public char element(int rang) throws VecteurOutException {
		if (rang < 0 || rang >= taille)
			throw new VecteurOutException("rang invalide");
		return table[rang];
	}

	public void doublerCapacite(){
		char[] maTabe = new char[taille * 2];
		for (int i = 0; i < taille; i++) {
			maTabe[i] = table[i];
		}
		table = maTabe;
	}

	/**
	 * insere un caractere au rang passe en parametre
	 * l'ordre des caracteres doit etre conserve
	 * @param rang
	 * @param caractere
	 * @throws VecteurOutException si ce n'est pas possible de mettre un caractere a ce rang
	 */
	public void insere(int rang, char caractere) throws VecteurOutException {
		if (rang < 0 || rang > taille) throw new VecteurOutException();

		if (table.length == taille) doublerCapacite();

		for (int i = table.length-1; i > rang; i--) {
			table[i] = table[i-1];
		}
		table[rang] = caractere;
		taille++;
	}

	/**
	 * ajoute le caractere a la fin du vecteur
	 * @param caractere
	 */
	public void ajoute(char caractere) {
		insere(taille, caractere);
	}

	/**
	 * remplace un caractere par le caractere passe en parametre
	 * @param rang le rang du caractere a remplacer
	 * @param caractere le nouveau caractere
	 * @return le caractere qui a ete remplace
	 * @throws VecteurOutException s'il n'y a pas d'element correspondant a ce rang
	 */
	public char remplace(int rang, char caractere)throws VecteurOutException {
		if (rang < 0 || rang > taille-1) throw new VecteurOutException();
		char c = table[rang];
		table[rang] = caractere;
		return c;
	}

	/**
	 * supprime le caractere au rang passe en parametre
	 * l'ordre des caracteres doit etre conserve
	 * @param rang
	 * @return le caractere qui a ete supprime
	 * @throws VecteurOutException s'il n'y a pas d'element correspondant a ce rang
	 */
	public char supprime(int rang) throws VecteurOutException {
		if (rang < 0 || rang > taille-1)
			throw new VecteurOutException();
		char c = table[rang];
		for (int i = rang; i < taille-1; i++) {
			table[i] = table[i+1];
		}
		taille--;
		return c;
	}
}
