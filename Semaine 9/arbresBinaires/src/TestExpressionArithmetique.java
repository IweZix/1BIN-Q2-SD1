import java.util.Scanner;


public class TestExpressionArithmetique {

	private final static Scanner scanner = new Scanner(System.in);

	/**
	 * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
	 * 
	 * @param messageErreur message a afficher en cas de probleme
	 * @param attendu la valeur qu'on s'attendait a recevoir
	 * @param recu la valeur qu'on a recu en realite
	 */

	private static void assertEquals(String messageErreur, Object attendu, Object recu) {
		if (attendu==null) {
			if (recu!=null) {
				System.out.println(messageErreur+". Attendu="+attendu+" recu="+recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {
			System.out.println(messageErreur+". Attendu="+attendu+" recu="+recu);
			System.exit(0);			
		}
	}
	
	public static ExpressionArithmetique exp (int i){
		if(i==1){
			ExpressionArithmetique ag = new ExpressionArithmetique('3');
			ExpressionArithmetique ad = new ExpressionArithmetique('2');
			ExpressionArithmetique a = new ExpressionArithmetique('-',ag,ad);			
			ag = new ExpressionArithmetique('9');
			ad = new ExpressionArithmetique('3');		
			ad = new ExpressionArithmetique('/',ag,ad);
			ag = new ExpressionArithmetique('4');
			ad = new ExpressionArithmetique('*',ag,ad);
			a = new ExpressionArithmetique('+',a,ad);		
			return a;
		}
		if(i==2){
			ExpressionArithmetique bg = new ExpressionArithmetique('4');
			ExpressionArithmetique bd = new ExpressionArithmetique('1');
			bd = new ExpressionArithmetique('-',bg,bd);
			bg = new ExpressionArithmetique('8');		
			bg = new ExpressionArithmetique('*',bg,bd);
			bd = new ExpressionArithmetique('4');
			bg = new ExpressionArithmetique('+',bg,bd);
			bd = new ExpressionArithmetique('1');
			bd = new ExpressionArithmetique('-',bg,bd);
			bg = new ExpressionArithmetique('4');
			ExpressionArithmetique b = new ExpressionArithmetique('+',bg,bd);
			return b;	
		}
		if(i==3){
			ExpressionArithmetique ag = new ExpressionArithmetique('3');
			ExpressionArithmetique ad = new ExpressionArithmetique('2');
			ExpressionArithmetique a = new ExpressionArithmetique('+',ag,ad);			
			ag = new ExpressionArithmetique('9');
			ad = new ExpressionArithmetique('3');		
			ad = new ExpressionArithmetique('+',ag,ad);
			ag = new ExpressionArithmetique('4');
			ad = new ExpressionArithmetique('+',ag,ad);
			a = new ExpressionArithmetique('+',a,ad);		
			return a;
		}
		if(i==4){
			return new ExpressionArithmetique('3');
		}
		return null;	
	}
	

	public static void main(String[] args) {

		System.out.println("****************************************************");
		System.out.println("Programme Test pour la classe ExpressionArithmetique");
		System.out.println("****************************************************");

		int choix = 0;
		do {
			System.out.println();
			System.out.println("1 -> Tester la methode nombreOperations()");
			System.out.println("2 -> Tester la methode uniquementDesAdditions()");
			System.out.println("3 -> Tester la methode nombreEntiersDifferents()");
			System.out.println("4 -> Tester la methode resultat()");
			System.out.println("5 -> Tester la methode notationInfixe()");
			System.out.println("6 -> Tester le defi");
			System.out.println();
			System.out.print("Votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
			case 1:
				testNombreOperations();
				break;
			case 2:
				testUniquementDesAdditions();
				break;
			case 3:
				testNombreEntiersDifferents();
				break;
			case 4:
				testResultat();
				break;
			case 5:
				testNotationInfixe();
				break;
			case 6:
				testDefi();
				break;
			default:
				break;
			}

		} while (choix >= 1 && choix <= 6);

	}

	private static void testDefi() {
		System.out.println("exp KO1");
		ArbreDeCaracteres ag = new ArbreDeCaracteres('3');
		ArbreDeCaracteres ad = new ArbreDeCaracteres();	// operateur unaire
		ArbreDeCaracteres a = new ArbreDeCaracteres('-',ag,ad);
			
		ag = new ArbreDeCaracteres('9');
		ad = new ArbreDeCaracteres('3');		
		ad = new ArbreDeCaracteres('/',ag,ad);
		ag = new ArbreDeCaracteres('4');
		ad = new ArbreDeCaracteres('*',ag,ad);
		a = new ArbreDeCaracteres('+',a,ad);
		try{
			ExpressionArithmetique exKO1 = new ExpressionArithmetique(a);
			System.out.println("test KO1 ko, l'arbre possede un operateur unaire");
			System.exit(0);	
			
		}catch (IllegalArgumentException e){
			System.out.println("IllegalArgumentException");
		}
		
		System.out.println("exp KO2");
		ag = new ArbreDeCaracteres('3');
		ad = new ArbreDeCaracteres('2');	
		a = new ArbreDeCaracteres('-',ag,ad);
			
		ag = new ArbreDeCaracteres('9');
		ad = new ArbreDeCaracteres('3');		
		ad = new ArbreDeCaracteres('7',ag,ad); // chiffre dans un noeud
		ag = new ArbreDeCaracteres('4');
		ad = new ArbreDeCaracteres('*',ag,ad);
		a = new ArbreDeCaracteres('+',a,ad);
		try{
			ExpressionArithmetique exKO12 = new ExpressionArithmetique(a);
			System.out.println("test KO2 ko, l'arbre possede un chiffre dans un noeud");
			System.exit(0);	
		}catch (IllegalArgumentException e){
			System.out.println("IllegalArgumentException");
		}
     
		
		System.out.println("exp KO3");
		ag = new ArbreDeCaracteres('3');
		ad = new ArbreDeCaracteres('2');	
		a = new ArbreDeCaracteres('-',ag,ad);
			
		ag = new ArbreDeCaracteres('9');
		ad = new ArbreDeCaracteres('3');		
		ad = new ArbreDeCaracteres('/',ag,ad); 
		ag = new ArbreDeCaracteres('4');
		ad = new ArbreDeCaracteres('*',ag,ad);
		a = new ArbreDeCaracteres('!',a,ad); //pas un operateur connu
		try{
			ExpressionArithmetique exKO3 = new ExpressionArithmetique(a);
			System.out.println("test KO3 ko, l'arbre possede un operateur inconnu");
			System.exit(0);	
		}catch (IllegalArgumentException e){
			System.out.println("IllegalArgumentException");
		}
     
		System.out.println("Tous les tests ont reussi");
		System.out.println();	
		
	}

	private static void testNotationInfixe() {
		ExpressionArithmetique exp1 = exp(1);
		assertEquals("test exp1 ko","((3-2)+(4*(9/3)))",exp1.notationInfixe());
		ExpressionArithmetique exp2 = exp(2);
		assertEquals("test exp2 ko","(4+(((8*(4-1))+4)-1))",exp2.notationInfixe());
		ExpressionArithmetique exp3 = exp(3);
		assertEquals("test exp3 ko","((3+2)+(4+(9+3)))",exp3.notationInfixe());
		ExpressionArithmetique exp4 = exp(4);
		assertEquals("test exp4 ko","3",exp4.notationInfixe());
		System.out.println("Tous les tests ont reussi");
		System.out.println();	
	}

	private static void testResultat() {
		ExpressionArithmetique exp1 = exp(1);
		assertEquals("test exp1 ko",13.0,exp1.resultat());
		ExpressionArithmetique exp2 = exp(2);
		assertEquals("test exp2 ko",31.0,exp2.resultat());
		ExpressionArithmetique exp3 = exp(3);
		assertEquals("test exp3 ko",21.0,exp3.resultat());
		ExpressionArithmetique exp4 = exp(4);
		assertEquals("test exp4 ko",3.0,exp4.resultat());
		System.out.println("Tous les tests ont reussi");
		System.out.println();	
	}

	private static void testNombreOperations() {
		// TODO Auto-generated method stub
		ExpressionArithmetique exp1 = exp(1);
		assertEquals("test exp1 avec '+' ko",1,exp1.nombreOperations('+'));
		ExpressionArithmetique exp2 = exp(2);
		assertEquals("test exp2 avec '-' ko",2,exp2.nombreOperations('-'));
		assertEquals("test exp2 avec '/' ko",0,exp2.nombreOperations('/'));
		ExpressionArithmetique exp3 = exp(3);
		assertEquals("test exp3 ko avec '+' ko",4,exp3.nombreOperations('+'));
		ExpressionArithmetique exp4 = exp(4);
		assertEquals("test exp4 avec '+' ko",0,exp4.nombreOperations('+'));
		try{
			exp3.nombreOperations('$');
			System.out.println("test exp3 ko, $ n'est pas un operateur, il fallait lancer une exception");
			System.exit(0);
		}catch(IllegalArgumentException e){
			
		}
		System.out.println("Tous les tests ont reussi");
		System.out.println();	
	}
	
	private static void testUniquementDesAdditions() {
		ExpressionArithmetique exp1 = exp(1);
		assertEquals("test exp1 - uniquement des + ko",false,exp1.uniquementDesAdditions());
		ExpressionArithmetique exp3 = exp(3);
		assertEquals("test exp3 - uniquement des +  ko",true,exp3.uniquementDesAdditions());
		ExpressionArithmetique exp4 = exp(4);
		assertEquals("test exp4 - uniquement des +  ko",true,exp4.uniquementDesAdditions());
		System.out.println("Tous les tests ont reussi");
		System.out.println();	
	}
	
	private static void testNombreEntiersDifferents() {
		ExpressionArithmetique exp1 = exp(1);
		assertEquals("test exp1 ko",4,exp1.nombreEntiersDifferents());
		ExpressionArithmetique exp2 = exp(2);
		assertEquals("test exp2 ko",3,exp2.nombreEntiersDifferents());
		ExpressionArithmetique exp4 = exp(4);
		assertEquals("test exp4 ko",1,exp4.nombreEntiersDifferents());
		System.out.println("Tous les tests ont reussi");
		System.out.println();	
		
	}





}
