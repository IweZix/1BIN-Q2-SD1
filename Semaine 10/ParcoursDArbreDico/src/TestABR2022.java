import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class TestABR2022 {
	
	private static Scanner scanner = new Scanner(System.in);

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
				System.out.println("KO");
				System.out.println("     "+messageErreur+". Attendu="+attendu+" recu="+recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {
			System.out.println("KO");
			System.out.println("    "+messageErreur+". Attendu="+attendu+" recu="+recu);
			System.exit(0);
		}
	}

	public static void main(String[] args) {

		System.out.println("*********************************");
		System.out.println("Programme Test ABR2022(juin20022)");
		System.out.println("*********************************");
		int choix= 0;
		do {
			System.out.println();
			System.out.println("1 ->  Tester la methode nombreNegatifsVI()");
			System.out.println("2 ->  Tester la methode nombreNegatifsVR()");
			System.out.println("3 ->  Tester la methode tousPositifsVI()");
			System.out.println("4 ->  Tester la methode tousPositifsVR()");

			System.out.println();
			System.out.print("Entrez votre choix : ");
			choix=scanner.nextInt();
			switch (choix) {
				case 1:
					testNombreNegatifsVI();
					break;
				case 2:
					testNombreNegatifsVR();
					break;
				case 3:
					testTousPositifsVI();
					break;
				case 4:
					testTousPositifsVR();
					break;
				default:
					break;
			}
		} while (choix >= 1 && choix <= 4);

	}

	private static void testNombreNegatifsVI() {
		ABR2022 ABR;
		System.out.println();
		ABR = ABR1();
		boolean auMoins1EntierItere = false;
		for (int entier : ABR
		) {
			auMoins1EntierItere = true;
		}
		if(!auMoins1EntierItere){
			System.out.println("Attention votre iterateur n'itere rien");
			System.out.println("Peut-etre avez-vous oublie de completer la methode remplirFile() !");
			System.exit(0);
		}
		System.out.println("test ABR1");
		ABR = ABR1();
		assertEquals("test ABR1 ko",4,ABR.nombreNegatifsVI());
		System.out.println("test ABR1 ok");

		System.out.println();
		System.out.println("test ABR2");
		ABR = ABR2();
		assertEquals("test ABR2 ko",1,ABR.nombreNegatifsVI());
		System.out.println("test ABR2 ok");

		System.out.println();
		System.out.println("test ABR3");
		ABR = ABR3();
		assertEquals("test ABR3 ko",0,ABR.nombreNegatifsVI());
		System.out.println("test ABR3 ok");

		System.out.println();
		System.out.println("test ABR4");
		ABR = ABR4();
		assertEquals("testABR4 ko",8,ABR.nombreNegatifsVI());
		System.out.println("test ABR4 ok");

		System.out.println();
		System.out.println("test ABR5");
		ABR = ABR5();
		assertEquals("test ABR5 ko",9,ABR.nombreNegatifsVI());
		System.out.println("test ABR5 ok");

		System.out.println();
		System.out.println("test ABRVide");
		ABR = ABRVide();
		assertEquals("test ABRVide ko",0,ABR.nombreNegatifsVI());
		System.out.println("test ABRVide ok");

		System.out.println();
		System.out.println("Tous les tests ont reussi !");
	}

	private static void testNombreNegatifsVR() {
		ABR2022 ABR;
		System.out.println();
		System.out.println("test ABR1");
		ABR = ABR1();
		assertEquals("test ABR1 ko",4,ABR.nombreNegatifsVR());
		System.out.println("test ABR1 ok");

		System.out.println();
		System.out.println("test ABR2");
		ABR = ABR2();
		assertEquals("test ABR2 ko",1,ABR.nombreNegatifsVR());
		System.out.println("test ABR2 ok");

		System.out.println();
		System.out.println("test ABR3");
		ABR = ABR3();
		assertEquals("test ABR3 ko",0,ABR.nombreNegatifsVR());
		System.out.println("test ABR3 ok");

		System.out.println();
		System.out.println("test ABR4");
		ABR = ABR4();
		assertEquals("testABR4 ko",8,ABR.nombreNegatifsVR());
		System.out.println("test ABR4 ok");

		System.out.println();
		System.out.println("test ABR5");
		ABR = ABR5();
		assertEquals("test ABR5 ko",9,ABR.nombreNegatifsVR());
		System.out.println("test ABR5 ok");

		System.out.println();
		System.out.println("test ABRVide");
		ABR = ABRVide();
		assertEquals("test ABRVide ko",0,ABR.nombreNegatifsVR());
		System.out.println("test ABRVide ok");

		System.out.println();
		System.out.println("Tous les tests ont reussi !");
	}

	private static void testTousPositifsVI() {
		ABR2022 ABR;
		System.out.println();
		ABR = ABR1();
		boolean auMoins1EntierItere = false;
		for (int entier : ABR
			 ) {
			auMoins1EntierItere = true;
		}
		if(!auMoins1EntierItere){
			System.out.println("Attention votre iterateur n'itere rien");
			System.out.println("Peut-etre avez-vous oublie de completer la methode remplirFile()");
			System.exit(0);
		}

		System.out.println("test ABR1");
		ABR = ABR1();
		assertEquals("test ABR1 ko",false,ABR.tousPositifsVI());
		System.out.println("test ABR1 ok");

		System.out.println();
		System.out.println("test ABR2");
		ABR = ABR2();
		assertEquals("test ABR2 ko",false,ABR.tousPositifsVI());
		System.out.println("test ABR2 ok");

		System.out.println();
		System.out.println("test ABR3");
		ABR = ABR3();
		assertEquals("test ABR3 ko",true,ABR.tousPositifsVI());
		System.out.println("test ABR3 ok");

		System.out.println();
		System.out.println("test ABR4");
		ABR = ABR4();
		assertEquals("testABR4 ko",false,ABR.tousPositifsVI());
		System.out.println("test ABR4 ok");

		System.out.println();
		System.out.println("test ABR5");
		ABR = ABR5();
		assertEquals("test ABR5 ko",false,ABR.tousPositifsVI());
		System.out.println("test ABR5 ok");

		System.out.println();
		System.out.println("test ABRVide");
		ABR = ABRVide();
		assertEquals("test ABRVide ko",true,ABR.tousPositifsVI());
		System.out.println("test ABRVide ok");

		System.out.println();
		System.out.println("Tous les tests ont reussi !");
	}

	private static void testTousPositifsVR() {
		ABR2022 ABR;
		System.out.println();
		System.out.println("test ABR1");
		ABR = ABR1();
		assertEquals("test ABR1 ko",false,ABR.tousPositifsVR());
		System.out.println("test ABR1 ok");

		System.out.println();
		System.out.println("test ABR2");
		ABR = ABR2();
		assertEquals("test ABR2 ko",false,ABR.tousPositifsVR());
		System.out.println("test ABR2 ok");

		System.out.println();
		System.out.println("test ABR3");
		ABR = ABR3();
		assertEquals("test ABR3 ko",true,ABR.tousPositifsVR());
		System.out.println("test ABR3 ok");

		System.out.println();
		System.out.println("test ABR4");
		ABR = ABR4();
		assertEquals("testABR4 ko",false,ABR.tousPositifsVR());
		System.out.println("test ABR4 ok");

		System.out.println();
		System.out.println("test ABR5");
		ABR = ABR5();
		assertEquals("test ABR5 ko",false,ABR.tousPositifsVR());
		System.out.println("test ABR5 ok");

		System.out.println();
		System.out.println("test ABRVide");
		ABR = ABRVide();
		assertEquals("test ABRVide ko",true,ABR.tousPositifsVR());
		System.out.println("test ABRVide ok");

		System.out.println();
		System.out.println("Tous les tests ont reussi !");
	}


	// negatifs et positifs
	public static ABR2022 ABR1(){
		ABR2022 ag = new ABR2022(-5);
		ABR2022 ad = new ABR2022(10);
		ad = new ABR2022(ag,-4,ad);
		ag = new ABR2022(-8);
		ABR2022 a = new ABR2022(ag,-6,ad);
		ad = new ABR2022(15);
		ag = new ABR2022(ABRVide(),13,ad);
		ad = new ABR2022(ag,18,ABRVide());
		a = new ABR2022(a,12,ad);
		return a;
	}


	// positifs et un negatif
	public static ABR2022 ABR2(){
		ABR2022 ag = new ABR2022(6);
		ABR2022 ad = new ABR2022(10);
		ad = new ABR2022(ag,8,ad);
		ag = new ABR2022(-4);
		ABR2022 a = new ABR2022(ag,6,ad);
		ad = new ABR2022(12);
		ag = new ABR2022(ABRVide(),12,ad);
		ad = new ABR2022(ag,18,ABRVide());
		a = new ABR2022(a,12,ad);
		return a;
	}


	// tous positifs
	public static ABR2022 ABR3(){
		ABR2022 ag = new ABR2022(7);
		ABR2022 ad = new ABR2022(10);
		ad = new ABR2022(ag,8,ad);
		ag = new ABR2022(4);
		ABR2022 a = new ABR2022(ag,6,ad);
		ad = new ABR2022(15);
		ag = new ABR2022(ABRVide(),13,ad);
		ad = new ABR2022(ag,18,ABRVide());
		a = new ABR2022(a,12,ad);
		return a;
	}



	// negatifs et 1 positif
	public static ABR2022 ABR4(){
		ABR2022 ag = new ABR2022(-18);
		ABR2022 ad = new ABR2022(-12);
		ad = new ABR2022(ag,-16,ad);
		ag = new ABR2022(-25);
		ABR2022 a = new ABR2022(ag,-20,ad);
		ad = new ABR2022(-5);
		ag = new ABR2022(ABRVide(),-6,ad);
		ad = new ABR2022(ag,4,ABRVide());
		a = new ABR2022(a,-10,ad);
		return a;
	}

	// tous negatifs
	public static ABR2022 ABR5(){
		ABR2022 ag = new ABR2022(-18);
		ABR2022 ad = new ABR2022(-12);
		ad = new ABR2022(ag,-16,ad);
		ag = new ABR2022(-25);
		ABR2022 a = new ABR2022(ag,-20,ad);
		ad = new ABR2022(-5);
		ag = new ABR2022(ABRVide(),-6,ad);
		ad = new ABR2022(ag,-4,ABRVide());
		a = new ABR2022(a,-10,ad);
		return a;
	}

	// ABR vide
	public static ABR2022 ABRVide(){
		return new ABR2022();
	}


}

