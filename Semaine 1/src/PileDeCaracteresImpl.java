// implementation d'une pile en utilisant un tableau de taille variable redimensionnable

/**
 * @author NICOLAS Luca
 *
 */

public class PileDeCaracteresImpl implements PileDeCaracteres{

	private char[] table; 			// ne modifiez pas cet identifiant, va servir pour les tests
	private int nombreCaracteres; 	// taille logique
								  	//ne mofifiez pas cet identifiant, va servir pour les tests

	
	public PileDeCaracteresImpl(){
		table = new char[4];
		nombreCaracteres = 0;
	}

	
	public PileDeCaracteresImpl(int capacite){
		if (capacite <= 0)
			throw new IllegalArgumentException("la taille physique ne peut etre negative ou nulle");
		table = new char[capacite];
		nombreCaracteres = 0;
	}

	
	public int taille(){
		return nombreCaracteres;
	}

	
	public boolean estVide(){
		return nombreCaracteres == 0;
	}

	/**
	 * ajoute le caractere c sur la pile
	 * @param c le caractere a ajouter
	 */
	public void push(char c){
		if (nombreCaracteres == table.length){
			char[] nouvelleTable = new char[table.length * 2];
			for (int i = 0; i < table.length; i++)
				nouvelleTable[i] = table[i];
			table = nouvelleTable;
		}
		table[nombreCaracteres++] = c;
	}

	/**
	 * renvoie le caractere qui se trouve au sommet de la pile et l'enleve de la pile
	 * @return le caractere au sommet
	 * @throws PileVideException si la pile est vide
	 */
	public char pop() throws PileVideException{
		if (estVide()) throw new PileVideException("KO car pile vide");
		char c = table[nombreCaracteres - 1];
		table[nombreCaracteres-- - 1] = ' ';
		return c;
	}

	/**
	 * renvoie le caractere qui se trouve au sommet de la pile sans l'enlever de la pile
	 * @return le caractere au sommet
	 * @throws PileVideException si la pile est vide
	 */
	public char sommet()throws PileVideException{
		if (estVide()) throw new PileVideException("KO car pile vide");
		return table[nombreCaracteres-1];
	}

} 
