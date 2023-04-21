import java.util.Scanner;


public class TestABRDEntiers {

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
				System.out.println(messageErreur+". Attendu="+attendu+" recu="+recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {
			System.out.println(messageErreur+". Attendu="+attendu+" recu="+recu);
			System.exit(0);			
		}
	}



	public static void main(String[] args) {
		
		System.out.println("******************");
		System.out.println("Programme Test ABR");
		System.out.println("******************");
		int choix= 0;
		System.out.println("Pour le bon fonctionnement de cette classe de tests,");
		System.out.println("la methode insere() doit etre verifiee en premier!");
		System.out.println();
		testInsere();
		
		System.out.println();
		do {
			System.out.println("1 ->  Tester la methode contient()");
			System.out.println("2 ->  Tester la methode min() (Pour ex defi)");
			System.out.println("3 ->  Tester la methode supprimeMin() (Pour ex defi)");
			System.out.println("4 ->  Tester la methode supprime() (Ex defi)");
			System.out.println("5 ->  Tester la methode toArray() (Ex defi)");
			
			System.out.println();
			System.out.print("Entrez votre choix : ");
			choix=scanner.nextInt();
			switch (choix) {
			case 1:
				testContient();	
				break;
			case 2:
				testMin();
				break;
			case 3:
				testSupprimeMin();
				break;
			case 4:
				testSupprime();
				break;
			case 5:
				testToArray();
				break;
			default:
				break;
			}
		} while (choix >= 1 && choix <= 5);
		
	}
		
		

	
	
		
	

		
	
	private static void testInsere() {
		System.out.println("Tests methode insere()");
		System.out.println("ABR sans ex-aequo");
		ABRDEntiers a = new ABRDEntiers();
		a.insere(12);
		System.out.println("insere 12");
		System.out.println(a.toStringLoic());
		assertEquals("insere 12 contenu ko", "12", a.toString());
		assertEquals("insere 12 taille ko", 1, a.taille());
		a.insere(5);
		System.out.println("insere 5");
		System.out.println(a.toStringLoic());
		assertEquals("insere 5 contenu ko", "5 12", a.toString());
		assertEquals("insere 5 taille ko", 2, a.taille());
		
		a.insere(8);
		System.out.println("insere 8");
		System.out.println(a.toStringLoic());
		assertEquals("insere 8 contenu ko", "5 8 12", a.toString());
		
		a.insere(17);
		System.out.println("insere 17");
		System.out.println(a.toStringLoic());
		assertEquals("insere 17 contenu ko", "5 8 12 17", a.toString());
		
		a.insere(2);
		System.out.println("insere 2");
		System.out.println(a.toStringLoic());
		assertEquals("insere 2 contenu ko", "2 5 8 12 17", a.toString());
		
		a.insere(15);
		System.out.println("insere 15");
		System.out.println(a.toStringLoic());
		assertEquals("insere 15 contenu ko", "2 5 8 12 15 17", a.toString());
		
		a.insere(25);
		System.out.println("insere 25");
		System.out.println(a.toStringLoic());
		assertEquals("insere 25 contenu ko", "2 5 8 12 15 17 25", a.toString());
		
		a.insere(6);
		System.out.println("insere 6");
		System.out.println(a.toStringLoic());
		assertEquals("insere 6 contenu ko", "2 5 6 8 12 15 17 25", a.toString());
		
		a.insere(3);
		System.out.println("insere 3");
		System.out.println(a.toStringLoic());
		assertEquals("insere 3 contenu ko", "2 3 5 6 8 12 15 17 25", a.toString());
		
		a.insere(1);
		System.out.println("insere 1");
		System.out.println(a.toStringLoic());
		assertEquals("insere 1 contenu ko", "1 2 3 5 6 8 12 15 17 25", a.toString());
		
		a.insere(30);
		System.out.println("insere 30");
		System.out.println(a.toStringLoic());
		assertEquals("insere 30 contenu ko","1 2 3 5 6 8 12 15 17 25 30" , a.toString());
		
		a.insere(16);
		System.out.println("insere 16");
		System.out.println(a.toStringLoic());
		assertEquals("insere 16 contenu ko", "1 2 3 5 6 8 12 15 16 17 25 30", a.toString());
		
		System.out.println("ABR avec ex-aequo");
		ABRDEntiers b = new ABRDEntiers();
		
		b.insere(1);
		System.out.println("insere 1");
		System.out.println(b.toStringLoic());
		assertEquals("insere 1", "1", b.toString());
		
		b.insere(2);
		System.out.println("insere 2");
		System.out.println(b.toStringLoic());
		assertEquals("insere 2", "1 2", b.toString());
		
		b.insere(1);
		System.out.println("insere 1");
		System.out.println(b.toStringLoic());
		assertEquals("insere 1", "1 1 2", b.toString());
		
		b.insere(0);
		System.out.println("insere 0");
		System.out.println(b.toStringLoic());
		assertEquals("insere 1", "0 1 1 2", b.toString());
		
		b.insere(2);
		System.out.println("insere 2");
		System.out.println(b.toStringLoic());
		assertEquals("insere 1", "0 1 1 2 2", b.toString());
		System.out.println("--> Tous les tests de la methode insere() ont reussi.");
		System.out.println();
		
	}

	private static void testContient() {
		System.out.println("Tests methode contient()");
		ABRDEntiers a = new ABRDEntiers();
		a.insere(12);
		a.insere(5);
		a.insere(8);
		a.insere(17);
		a.insere(2);
		a.insere(15);
		a.insere(25);
		a.insere(6);
		a.insere(3);
		a.insere(1);
		a.insere(30);
		a.insere(16);
		System.out.println(a.toStringLoic());
		assertEquals("contient 16 ko",true ,a.contient(16) );
		assertEquals("contient 16 contenu ko", "1 2 3 5 6 8 12 15 16 17 25 30", a.toString());
		assertEquals("contient 1 ko",true ,a.contient(1) );
		assertEquals("contient 2 ko",true ,a.contient(2) );
		assertEquals("contient 3 ko",true ,a.contient(3) );
		assertEquals("contient 5 ko",true ,a.contient(5) );
		assertEquals("contient 6 ko",true ,a.contient(6) );
		assertEquals("contient 8 ko",true ,a.contient(8) );
		assertEquals("contient 12 ko",true ,a.contient(12) );
		assertEquals("contient 15 ko",true ,a.contient(15) );
		assertEquals("contient 17 ko",true ,a.contient(17) );
		assertEquals("contient 25 ko",true ,a.contient(25) );
		assertEquals("contient 30 ko",true ,a.contient(30) );
		assertEquals("contient 7 ko",false ,a.contient(7) );
		assertEquals("contient 22 ko",false ,a.contient(22) );
		System.out.println("--> Tous les tests de la methode contient() ont reussi.");  
		System.out.println();

		
	}

	

	private static void testMin() {
		System.out.println("Tests methode min()");
		ABRDEntiers c = new ABRDEntiers();
		try {
			int min = c.min() ;
			System.out.println("Il faut generer une ArbreVideException si l'arbre est vide");
			System.exit(0);
		} catch (ArbreVideException e) {
			
		}
		
		c.insere(2);
		c.insere(4);
		c.insere(3);
		System.out.println(c.toStringLoic());
		assertEquals("min 2 3 4 ko",2 ,c.min());
		
		ABRDEntiers b = new ABRDEntiers();
		b.insere(1);
		b.insere(2);
		b.insere(1);	
		b.insere(0);	
		b.insere(2);
		System.out.println(b.toStringLoic());
		assertEquals("min 0 1 1 2 2 ko",0, b.min());
		
		ABRDEntiers a = new ABRDEntiers();
		a.insere(12);
		a.insere(5);
		a.insere(8);
		a.insere(17);
		a.insere(2);
		a.insere(15);
		a.insere(25);
		a.insere(6);
		a.insere(3);
		a.insere(1);
		a.insere(30);
		a.insere(16);	
		System.out.println(a.toStringLoic());
		assertEquals("min 1 2 3 5 6 8 12 15 16 17 25 30 ko",1 ,a.min());
		assertEquals("min 1 2 3 5 6 8 12 15 16 17 25 30 contenu ko", "1 2 3 5 6 8 12 15 16 17 25 30", a.toString());
		
		System.out.println("--> Tous les tests de la methode min() ont reussi."); 
		System.out.println();
		
	}

	private static void testSupprimeMin() {
		System.out.println("Tests methode supprimeMin()");
		ABRDEntiers a = new ABRDEntiers();
		a.insere(12);
		a.insere(5);
		a.insere(8);
		a.insere(17);
		a.insere(2);
		a.insere(15);
		a.insere(25);
		a.insere(6);
		a.insere(3);
		a.insere(1);
		a.insere(30);
		a.insere(16);
		System.out.println();
		
		System.out.println(a.toStringLoic());
		System.out.println("supprimeMin()");
		try {
			a.supprimeMin();
		} catch (ArbreVideException e) {
			System.out.println("supprimeMin 1 2 3 5 6 8 12 15 16 17 25 30 : il ne fallait pas d'exception");
			System.exit(0);
		}
		System.out.println(a.toStringLoic());
		assertEquals("supprimeMin 1 2 3 5 6 8 12 15 16 17 25 30 taille ko", 11 ,a.taille());
		assertEquals("supprimeMin 1 2 3 5 6 8 12 15 16 17 25 30 contenu ko", "2 3 5 6 8 12 15 16 17 25 30", a.toString());
		
		System.out.println("supprimeMin()");
		try {
			a.supprimeMin();
		} catch (ArbreVideException e) {
			System.out.println("supprimeMin 2 3 5 6 8 12 15 16 17 25 30 : il ne fallait pas d'exception");
			System.exit(0);
		}
		System.out.println(a.toStringLoic());
		assertEquals("supprimeMin 2 3 5 6 8 12 15 16 17 25 30 taille ko", 10 ,a.taille());
		assertEquals("supprimeMin 2 3 5 6 8 12 15 16 17 25 30 contenu ko", "3 5 6 8 12 15 16 17 25 30", a.toString());
		
		
		System.out.println("supprimeMin()");
		try {
			a.supprimeMin();
		} catch (ArbreVideException e) {
			System.out.println("supprimeMin 3 5 6 8 12 15 16 17 25 30 : il ne fallait pas d'exception");
			System.exit(0);
		}
		System.out.println(a.toStringLoic());
		assertEquals("supprimeMin 3 5 6 8 12 15 16 17 25 30 taille ko", 9 ,a.taille());
		assertEquals("supprimeMin 3 5 6 8 12 15 16 17 25 30 contenu ko", "5 6 8 12 15 16 17 25 30", a.toString());
		
		
		
		System.out.println("supprimeMin()");
		try {
			a.supprimeMin();
		} catch (ArbreVideException e) {
			System.out.println("supprimeMin 5 6 8 12 15 16 17 25 30 : il ne fallait pas d'exception");
			System.exit(0);
		}
		System.out.println(a.toStringLoic());
		assertEquals("supprimeMin 5 6 8 12 15 16 17 25 30 taille ko", 8 ,a.taille());
		assertEquals("supprimeMin 5 6 8 12 15 16 17 25 30 contenu ko", "6 8 12 15 16 17 25 30", a.toString());
		
		
		System.out.println("supprimeMin()");
		try {
			a.supprimeMin();
		} catch (ArbreVideException e) {
			System.out.println("supprimeMin 6 8 12 15 16 17 25 30 : il ne fallait pas d'exception");
			System.exit(0);
		}
		System.out.println(a.toStringLoic());
		assertEquals("supprimeMin 6 8 12 15 16 17 25 30 taille ko", 7 ,a.taille());
		assertEquals("supprimeMin 6 8 12 15 16 17 25 30 contenu ko", "8 12 15 16 17 25 30", a.toString());
		
		
		System.out.println("supprimeMin()");
		try {
			a.supprimeMin();
		} catch (ArbreVideException e) {
			System.out.println("supprimeMin 8 12 15 16 17 25 30 : il ne fallait pas d'exception");
			System.exit(0);
		}
		System.out.println(a.toStringLoic());
		assertEquals("supprimeMin 8 12 15 16 17 25 30 taille ko", 6 ,a.taille());
		assertEquals("supprimeMin 8 12 15 16 17 25 30 contenu ko", "12 15 16 17 25 30", a.toString());
		
		
		System.out.println("supprimeMin()");
		try {
			a.supprimeMin();
		} catch (ArbreVideException e) {
			System.out.println("supprimeMin 12 15 16 17 25 30 : il ne fallait pas d'exception");
			System.exit(0);
		}
		System.out.println(a.toStringLoic());
		assertEquals("supprimeMin 12 15 16 17 25 30 taille ko", 5 ,a.taille());
		assertEquals("supprimeMin 12 15 16 17 25 30 contenu ko", "15 16 17 25 30", a.toString());
		
		
		System.out.println("supprimeMin()");
		try {
			a.supprimeMin();
		} catch (ArbreVideException e) {
			System.out.println("supprimeMin 15 16 17 25 30 : il ne fallait pas d'exception");
			System.exit(0);
		}
		System.out.println(a.toStringLoic());
		assertEquals("supprimeMin 15 16 17 25 30 taille ko", 4 ,a.taille());
		assertEquals("supprimeMin 15 16 17 25 30 contenu ko", "16 17 25 30", a.toString());
		
		
		System.out.println("supprimeMin()");
		try {
			a.supprimeMin();
		} catch (ArbreVideException e) {
			System.out.println("supprimeMin 16 17 25 30 : il ne fallait pas d'exception");
			System.exit(0);
		}
		System.out.println(a.toStringLoic());
		assertEquals("supprimeMin 16 17 25 30 taille ko", 3 ,a.taille());
		assertEquals("supprimeMin 16 17 25 30 contenu ko", "17 25 30", a.toString());
		
		
		System.out.println("supprimeMin()");
		try {
			a.supprimeMin();
		} catch (ArbreVideException e) {
			System.out.println("supprimeMin 17 25 30 : il ne fallait pas d'exception");
			System.exit(0);
		}
		System.out.println(a.toStringLoic());
		assertEquals("supprimeMin 17 25 30 taille ko", 2 ,a.taille());
		assertEquals("supprimeMin 17 25 30 contenu ko", "25 30", a.toString());
		
		
		System.out.println("supprimeMin()");
		try {
			a.supprimeMin();
		} catch (ArbreVideException e) {
			System.out.println("supprimeMin 25 30 : il ne fallait pas d'exception");
			System.exit(0);
		}
		System.out.println(a.toStringLoic());
		assertEquals("supprimeMin 25 30 taille ko", 1 ,a.taille());
		assertEquals("supprimeMin 25 30 contenu ko", "30", a.toString());
		
		
		System.out.println("supprimeMin()");
		try {
			a.supprimeMin();
		} catch (ArbreVideException e) {
			System.out.println("supprimeMin 30 : il ne fallait pas d'exception");
			System.exit(0);
		}
		System.out.println(a.toStringLoic());
		assertEquals("supprimeMin 30 taille ko", 0 ,a.taille());
		assertEquals("supprimeMin 30 contenu ko", "", a.toString());
		
		
		System.out.println("supprimeMin()");
		try {
			a.supprimeMin();
			System.out.println("supprimeMin arbre vide: il fallait une exception de type ArbreVideException");
			System.exit(0);
		} catch (ArbreVideException e) {
		}
		System.out.println("arbre vide");
		assertEquals("supprimeMin 30 taille ko", 0 ,a.taille());
		assertEquals("supprimeMin 30 contenu ko", "", a.toString());
		
		System.out.println("--> Tous les tests de la methode supprimeMin() ont reussi.");
		System.out.println();

		
	}

	private static void testSupprime() {
		
		System.out.println("Tests methode supprime()");
		ABRDEntiers a = new ABRDEntiers();
		a.insere(12);
		a.insere(5);
		a.insere(8);
		a.insere(17);
		a.insere(2);
		a.insere(15);
		a.insere(25);
		a.insere(6);
		a.insere(3);
		a.insere(1);
		a.insere(30);
		a.insere(16);
		System.out.println("l'arbre teste ne contient pas d'ex-aequo");
		System.out.println(a.toStringLoic());	
		
		
		System.out.println("supprime 3");
		assertEquals("supprime 3 dans 1 2 3 5 6 8 12 15 16 17 25 30",true ,a.supprime(3) );
		System.out.println(a.toStringLoic());
		assertEquals("supprime 3 dans 1 2 3 5 6 8 12 15 16 17 25 30 contenu ko", "1 2 5 6 8 12 15 16 17 25 30", a.toString());
		assertEquals("supprime 3 dans 1 2 3 5 6 8 12 15 16 17 25 30 taille ko",11, a.taille());
		
		
		
		System.out.println("supprime 25");
		assertEquals("supprime 25 dans 1 2 5 6 8 12 15 16 17 25 30",true ,a.supprime(25) );
		System.out.println(a.toStringLoic());
		assertEquals("supprime 25 dans 1 2 5 6 8 12 15 16 17 25 30 contenu ko", "1 2 5 6 8 12 15 16 17 30", a.toString());
		assertEquals("supprime 25 dans 1 2 5 6 8 12 15 16 17 25 30 taille ko", 10, a.taille());
		
		
		System.out.println("supprime 12");
		assertEquals("supprime 12 dans 1 2 5 6 8 12 15 16 17 30",true ,a.supprime(12) );
		System.out.println(a.toStringLoic());
		assertEquals("supprime 12 dans 1 2 5 6 8 12 15 16 17 30 contenu ko", "1 2 5 6 8 15 16 17 30", a.toString());
		assertEquals("supprime 12 dans 1 2 5 6 8 12 15 16 17 30 taille ko", 9, a.taille());
		
		
		System.out.println("supprime 7");
		assertEquals("supprime 7 dans 1 2 5 6 8 15 16 17 30",false ,a.supprime(7) );
		System.out.println(a.toStringLoic());
		assertEquals("supprime 7 dans 1 2 5 6 8 15 16 17 30 contenu ko", "1 2 5 6 8 15 16 17 30", a.toString()); 
		assertEquals("supprime 7 dans 1 2 5 6 8 15 16 17 30 taille ko",9, a.taille()); 
		
		
		System.out.println("supprime 17");
		assertEquals("supprime 17 dans 1 2 5 6 8 15 16 17 30",true ,a.supprime(17) );
		System.out.println(a.toStringLoic());
		assertEquals("supprime 17 dans 1 2 5 6 8 15 16 17 30 contenu ko", "1 2 5 6 8 15 16 30", a.toString());
		
		
		System.out.println("supprime 17");
		assertEquals("supprime 17 dans 1 2 5 6 8 15 16 30",false ,a.supprime(17) );
		System.out.println(a.toStringLoic());
		assertEquals("supprime 17 dans 1 2 5 6 8 15 16 30 contenu ko", "1 2 5 6 8 15 16 30", a.toString());
		
		
		System.out.println("supprime 1");
		assertEquals("supprime 1 dans 1 2 5 6 8 15 16 30",true ,a.supprime(1) );
		System.out.println(a.toStringLoic());
		assertEquals("supprime 1 dans 1 2 5 6 8 15 16 30 contenu ko", "2 5 6 8 15 16 30", a.toString());
		
		
		System.out.println("supprime 8");
		assertEquals("supprime 8 dans 2 5 6 8 15 16 30",true ,a.supprime(8) );
		System.out.println(a.toStringLoic());
		assertEquals("supprime 8 dans 2 5 6 8 15 16 30 contenu ko", "2 5 6 15 16 30", a.toString());
		
		
		System.out.println("supprime 15");
		assertEquals("supprime 15 dans 2 5 6 15 16 30",true ,a.supprime(15) );
		System.out.println(a.toStringLoic());
		assertEquals("supprime 15 dans 2 5 6 15 16 30 contenu ko", "2 5 6 16 30", a.toString());
		
		
		System.out.println("supprime 30");
		assertEquals("supprime 30 dans 2 5 6 16 30",true ,a.supprime(30) );
		System.out.println(a.toStringLoic());
		assertEquals("supprime 30 dans 2 5 6 16 30 contenu ko", "2 5 6 16", a.toString());
		
		
		System.out.println("supprime 2");
		assertEquals("supprime 2 dans 2 5 6 16",true ,a.supprime(2) );
		System.out.println(a.toStringLoic());
		assertEquals("supprime 2 dans 2 5 6 16 contenu ko", "5 6 16", a.toString());
		
		
		System.out.println("supprime 5");
		assertEquals("supprime 5 dans 5 6 16",true ,a.supprime(5) );
		System.out.println(a.toStringLoic());
		assertEquals("supprime 5 dans 5 6 16 contenu ko", "6 16", a.toString());
		
		
		
		System.out.println("supprime 6");
		assertEquals("supprime 6 dans 6 16",true ,a.supprime(6) );
		System.out.println(a.toStringLoic());
		assertEquals("supprime 6 dans 6 16 contenu ko", "16", a.toString());
		
		assertEquals("supprime 16 dans 16",true ,a.supprime(16) );
		System.out.println("supprime 16");
		a.supprime(16);
		System.out.println(a.toStringLoic());
		assertEquals("supprime 16 dans 16 contenu ko", "", a.toString());
		
	
		
		System.out.println("supprime 3");		
		System.out.println(a.toStringLoic());
		assertEquals("supprime 3 dans arbre vide", false, a.supprime(3));
		assertEquals("supprime 3 dans arbre vide contenu ko", "", a.toString());

		a = new ABRDEntiers();
		a.insere(12);
		a.insere(5);
		a.insere(8);
		a.insere(17);
		a.insere(2);
		a.insere(15);
		a.insere(25);
		a.insere(6);
		a.insere(3);
		a.insere(1);
		a.insere(30);
		a.insere(16);
		System.out.println("Arbre avant supprime 5 ") ;
		System.out.println(a.toStringLoic()) ;
		assertEquals("supprime 5 dans 1 2 3 5 6 8 12 15 16 17 25 30",true ,a.supprime(5) );
		System.out.println("Arbre obtenu apres supprime 5 ") ;
		System.out.println(a.toStringLoic()) ;
		assertEquals("supprime 5 dans 1 2 3 5 6 8 12 15 16 17 25 30 contenu ko", "1 2 3 6 8 12 15 16 17 25 30", a.toString());
		assertEquals("supprime 5 dans 1 2 3 5 6 8 12 15 16 17 25 30 taille ko",11, a.taille());

		System.out.println("l'arbre contient des ex-aequos");
		ABRDEntiers b = new ABRDEntiers();
		b.insere(1);
		b.insere(2);
		b.insere(1);	
		b.insere(0);	
		b.insere(2);
		System.out.println(b.toStringLoic());
		
		System.out.println("supprime 1");
		b.supprime(1);
		System.out.println(b.toStringLoic());
		assertEquals("supprime 1 dans 0 1 1 2 2 (contenu ko) ", "0 1 2 2", b.toString());
		
		System.out.println("supprime 1");
		b.supprime(1);
		System.out.println(b.toStringLoic());
		assertEquals("supprime 1 dans 0 1 2 2 (contenu ko) ", "0 2 2", b.toString());
		
		System.out.println("supprime 2");
		b.supprime(2);
		System.out.println(b.toStringLoic());
		assertEquals("supprime 2 dans 0 2 2 (contenu ko) ", "0 2", b.toString());
		
		System.out.println("supprime 2");
		b.supprime(2);
		System.out.println(b.toStringLoic());
		assertEquals("supprime 2 dans 0 2 (contenu ko) ", "0", b.toString());
		
		System.out.println("supprime 0");
		b.supprime(0);
		System.out.println(b.toStringLoic());
		assertEquals("supprime 0 dans 0 (contenu ko) ", "", b.toString());
		
		System.out.println("Encore un test avec un arbre qui contient des ex-aequos!");
		ABRDEntiers d = new ABRDEntiers() ;
		d.insere(2) ;
		d.insere(0);
		d.insere(1);
		d.insere(3);
		d.insere(4);
		d.insere(3);
		System.out.println(d.toStringLoic());
		
		System.out.println("supprime 3");
		d.supprime(3);
		System.out.println(d.toStringLoic());
		assertEquals("supprime 3 dans 0 1 2 3 3 4 (contenu ko) ", "0 1 2 3 4", d.toString());
		
		System.out.println("supprime 3");
		d.supprime(3);
		System.out.println(d.toStringLoic());
		assertEquals("supprime 3 dans 0 1 2 3 4 (contenu ko) ", "0 1 2 4", d.toString());
		System.out.println("--> Tous les tests de la methode supprime() ont reussi.");	
		System.out.println();



	}

	
	private static void testToArray() {
		System.out.println("test toArray()");
		System.out.println("test1 : arbre enonce");
		ABRDEntiers a = new ABRDEntiers();
		a.insere(8);
		a.insere(4);
		a.insere(2);
		a.insere(6);
		a.insere(5);
		a.insere(7);
		a.insere(12);
		a.insere(9);
		a.insere(11);
		int[] t = a.toArray();
		int[] tSol = {2,4,5,6,7,8,9,11,12};
		if(t.length!=9){
			System.out.println("test1 ko");
			System.exit(0);
		}
		for (int i = 0; i < t.length; i++) {
			if(t[i]!=tSol[i]){
				System.out.println("test1 ko");
				System.exit(0);
			}
		}

		System.out.println("test2 : arbre vide");
		a = new ABRDEntiers();
		t = a.toArray();
		if(t.length!=0){
			System.out.println("test2 ko");
			System.exit(0);
		}
		
		System.out.println();
		System.out.println("--> Tous les tests de la methode toArray() ont reussi");
		
	}
	
}
