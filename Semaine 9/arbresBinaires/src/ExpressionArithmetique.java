import java.util.HashMap;
import java.util.HashSet;


public class ExpressionArithmetique extends ArbreDeCaracteres { 
	
	/**
	 * Cree une expression arithmetique a partir d'un arbre de caracteres
	 * @param a
	 */
	public ExpressionArithmetique (ArbreDeCaracteres a) {
		super(a);
	}

	public ExpressionArithmetique (char c) {
		super(c);
	}
	
	public ExpressionArithmetique (char c, ArbreDeCaracteres ag, ArbreDeCaracteres ad) {
		super(c, ag, ad);
	}
	
	
	/**
	 * calcule le nombre d'operations correspondant au type d'operateur passe en parametre que contient l'expression arithmetique
	 * Par ex : exp1 : + --> 1
	 *                 / --> 1
	 *                 ...
	 *          exp3 : + --> 4 
	 * @param operateur l'operateur verifie
	 * @return le nombre d'operations
	 * @throws IllegalArgumentException si le caractere passe en parametre n'est pas un operateur (+,-,*,/)
	 */
	public int nombreOperations(char operateur) {
		if (operateur != '+' && operateur != '-' && operateur != '*' && operateur != '/')
			throw new IllegalArgumentException("Opérateur inconnu");
		return nombreOperation(operateur, racine);
	}

	public int nombreOperation(char op, NoeudCaractere noeud){
		if (noeud == null)
			return 0;
		if (noeud.caractere == op)
			return 1 + nombreOperation(op, noeud.gauche) + nombreOperation(op, noeud.droit);
		return nombreOperation(op, noeud.gauche) + nombreOperation(op, noeud.droit);
	}


	
	/**
	 * verifie si l'arbre ne contient que des additions
	 * Par ex : exp3 ne contient que des +
	 * @return true si l'expression arithmetique contient uniquement des additions, false sinon
	 */
	public boolean uniquementDesAdditions(){
		return uniquementDesAdditions(racine);
	}

	public boolean uniquementDesAdditions(NoeudCaractere noeud){
		if (noeud == null)
			return true;
		if (noeud.caractere != '+' && noeud.caractere != '-' && noeud.caractere != '*' && noeud.caractere != '/')
			return uniquementDesAdditions(noeud.gauche) && uniquementDesAdditions(noeud.droit);
		if (noeud.caractere != '+')
			return false;
		return uniquementDesAdditions(noeud.gauche) && uniquementDesAdditions(noeud.droit);
	}
	

	
	/**
	 * calcule le nombre d'entiers differents contenus dans l'expression arithmetique
	 * Par ex : exp2 contient 3 entiers differents : 1, 4 et 8
	 * @return le nombre d'entiers differents
	 */
	public int nombreEntiersDifferents(){
		HashSet<Character> characterHashSet = new HashSet<Character>();
		return nombreEntiersDifferents(racine, characterHashSet);
	}

	public int nombreEntiersDifferents(NoeudCaractere noeud, HashSet<Character> hashSet){
		if (noeud == null)
			return 0;
		if (noeud.caractere != '+' && noeud.caractere != '-' && noeud.caractere != '*' && noeud.caractere != '/'){
			if (hashSet.add(noeud.caractere))
				return 1 + nombreEntiersDifferents(noeud.gauche, hashSet) + nombreEntiersDifferents(noeud.droit, hashSet);
		}
		return nombreEntiersDifferents(noeud.gauche, hashSet) + nombreEntiersDifferents(noeud.droit, hashSet);
	}



	/**
	 * calcule la valeur de l'expression stockee dans l'arbre
	 * Par ex : exp1 --> 13
	 * @return le resultat 
	 */
	public double resultat(){
		return resultat(racine);
	}

	public double resultat(NoeudCaractere noeud){
		if (noeud == null)
			return 0;
		if (noeud.caractere != '+' && noeud.caractere != '-' && noeud.caractere != '*' && noeud.caractere != '/')
			// return noeud.caractere - '0';
			return Character.getNumericValue(noeud.caractere);
		if (noeud.caractere == '+')
			return resultat(noeud.gauche) + resultat(noeud.droit);
		if (noeud.caractere == '-')
			return resultat(noeud.gauche) - resultat(noeud.droit);
		if (noeud.caractere == '*')
			return resultat(noeud.gauche) * resultat(noeud.droit);
		if (noeud.caractere == '/')
			return resultat(noeud.gauche) / resultat(noeud.droit);
		return 0;
	}
	
	

	/**
	 * renvoie l'expression stockee dans l'arbre en notation infixe
	 * Par exp : exp1 --> ((3-2)+(4*(9/3)))
	 * @return la notation infixe
	 */
	public String notationInfixe(){
		return notationInfixe(racine);
	}

	public String notationInfixe(NoeudCaractere noeud){
		if (noeud == null)
			return "";
		if (noeud.caractere != '+' && noeud.caractere != '-' && noeud.caractere != '*' && noeud.caractere != '/')
			return Character.toString(noeud.caractere);
		return "(" + notationInfixe(noeud.gauche) + noeud.caractere + notationInfixe(noeud.droit) + ")";
	}
}