import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TestListeRecCaracteres {

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

		System.out.println("*********************************************");
		System.out.println("Programme Test pour la classe ListeCaracteres");
		System.out.println("*********************************************");
		int choix = 0;
		do {
			System.out.println("1 -> Tester la methode contient");
			System.out.println("2 -> Tester la methode nombreOccurrences");
			System.out.println("3 -> Tester la methode remplacer");
			System.out.println("4 -> Tester la methode remplacerTout");
			System.out.println("5 -> Tester la methode max");
			System.out.println("6 -> Tester la methode enArrayList");
			System.out.println("7 -> Tester la methode estEgalA");
			System.out.println("8 -> Tester la methode clone (defi)");
			System.out.println("9 -> Tester la methode supprimerToutesLesOccurrences (defi)");
			System.out.println();
			System.out.print("Entrez votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
			case 1:
				testContient();
				break;
			case 2:
				testNombreOccurrences();
				break;
			case 3:
				testRemplacer();
				break;
			case 4:
				testRemplacerTout();
				break;
			case 5:
				testMax();
				break;	
			case 6:
				testEnArrayList();
				break;
			case 7:
				testEstEgalA();
				break;
			case 8:
				testClone();
				break;	
			case 9:
				testsupprimerToutesLesOccurrencess();
				break;
			default:
				break;
			}
		} while (choix >= 1 && choix <= 9 );
	}


	private static void testClone() {
		char [] caracteres = {'a','b','a','c','b','a'};
		ListeRecCaracteres l = new ListeRecCaracteres(caracteres);
		System.out.print("Test 1 : liste testee : "+l + " : ");
		ListeRecCaracteres lClone = l.clone();
		assertEquals("ko : contenu liste modifie "," a b a c b a",l.toString());
		assertEquals("ko : contenu nouvelle liste "," a b a c b a",lClone.toString());
		l.remplacerToutParX();
		if(!lClone.toString().equals(" a b a c b a")){
			System.out.println("ko : la copie referencie des memes noeuds que this ");
			return;
		}
		System.out.println("ok");
		
		l = new ListeRecCaracteres();
		System.out.print("Test 2 : liste vide : ");
		lClone = l.clone();
		assertEquals("ko : contenu nouvelle liste ","",lClone.toString());
		System.out.println("ok");
		
		
		System.out.println("Tous les tests ont reussi!");
		System.out.println();
		System.out.println();	

	}

	private static void testEnArrayList() {
		char [] caracteres = {'a','b','a','c','b','a'};
		ListeRecCaracteres l = new ListeRecCaracteres(caracteres);
		ArrayList<Character> attendue = new ArrayList<Character>();
		for (int i = 0; i < caracteres.length; i++) {
			attendue.add(caracteres[i]);
		}
		System.out.print("Test 1 : liste testee : "+ l + " : ");
		ArrayList<Character> recue = l.enArrayList();
		assertEquals("ko : contenu liste modifie : "," a b a c b a",l.toString());
		assertEquals("ko : contenu arrayList : ",attendue.toString(),recue.toString());
		System.out.println("ok");

		l = new ListeRecCaracteres();
		attendue = new ArrayList<Character>();
		System.out.print("Test 2 : liste vide : ");
		recue = l.enArrayList();
		assertEquals("ko : contenu arrayList : ",attendue.toString(),recue.toString());
		System.out.println("ok");

		System.out.println("Tous les tests ont reussi!");
		System.out.println();
		System.out.println();	

	}

	private static void testMax() {

		char [] caracteres1 = {'a','b','a','c','z','a'};
		ListeRecCaracteres l = new ListeRecCaracteres(caracteres1);
		System.out.print("Test 1 : liste testee : "+l + " : max : ");
		assertEquals("caractere renvoye ko ",'z',l.max());
		assertEquals("contenu liste modifie "," a b a c z a",l.toString());
		System.out.println("ok");

		char[] caracteres2 = {'a','b','a','c','a','x'};
		l = new ListeRecCaracteres(caracteres2);
		System.out.print("Test 2 : liste testee : "+l + " : max : ");
		assertEquals("caractere renvoye ko ",'x',l.max());
		System.out.println("ok");

		char[] caracteres3 = {'z','b'};
		l = new ListeRecCaracteres(caracteres3);
		System.out.print("Test 3 : liste testee : "+l + " : max : ");
		assertEquals("caractere renvoye ko ",'z',l.max());
		System.out.println("ok");

		char[] caracteres4 = {'z'};
		l = new ListeRecCaracteres(caracteres4);
		System.out.print("Test 4 : liste testee : "+l + " : max : ");
		assertEquals("caractere renvoye ko ",'z',l.max());
		System.out.println("ok");

		l = new ListeRecCaracteres();
		System.out.print("Test 5 : liste vide : max : ");
		try{
			l.max();
			System.out.print("ko, il fallait une exception de type NoSuchElementException");
			return;
		}catch (NoSuchElementException e){

		}catch (Exception e){
			System.out.print("ko, il fallait une exception de type NoSuchElementException");
			return;
		}

		System.out.println("ok");


		System.out.println("Tous les tests ont reussi!");
		System.out.println();
		System.out.println();	
	}

	private static void testRemplacerTout() {
		char [] caracteres = {'a','b','a','c','a','d'};
		ListeRecCaracteres l = new ListeRecCaracteres(caracteres);
		System.out.print("Test 1 : liste testee : "+l + " : remplacerTout c par x : ");
		l.remplacerTout('c', 'x');
		assertEquals("contenu liste ko "," a b a x a d",l.toString());
		System.out.println("ok");

		l = new ListeRecCaracteres(caracteres);
		System.out.print("Test 2 : liste testee : "+l + " : remplacerTout a par x : ");
		l.remplacerTout('a', 'x');
		assertEquals("contenu liste ko "," x b x c x d",l.toString());
		System.out.println("ok");

		l = new ListeRecCaracteres(caracteres);
		System.out.print("Test 3 : liste testee : "+l + " : remplacerTout d par x : ");
		l.remplacerTout('d', 'x');
		assertEquals("contenu liste ko "," a b a c a x",l.toString());
		System.out.println("ok");

		l = new ListeRecCaracteres(caracteres);
		System.out.print("Test 4 : liste testee : "+l + " : remplacerTout y par x : ");
		l.remplacerTout('y', 'x');
		assertEquals("contenu liste ko "," a b a c a d",l.toString());
		System.out.println("ok");


		l = new ListeRecCaracteres();
		System.out.print("Test 5 : liste vide : remplacer a par x: ");
		l.remplacerTout('a', 'x');
		assertEquals("contenu liste ko ","",l.toString());
		System.out.println("ok");


		System.out.println("Tous les tests ont reussi!");
		System.out.println();
		System.out.println();	


	}

	private static void testRemplacer() {
		char [] caracteres = {'a','b','a','c','a','d'};
		ListeRecCaracteres l = new ListeRecCaracteres(caracteres);
		System.out.print("Test 1 : liste testee : "+l + " : remplacer c par x : ");
		l.remplacer('c', 'x');
		assertEquals("contenu liste ko "," a b a x a d",l.toString());
		System.out.println("ok");

		l = new ListeRecCaracteres(caracteres);
		System.out.print("Test 2 : liste testee : "+l + " : remplacer a par x : ");
		l.remplacer('a', 'x');
		assertEquals("contenu liste ko "," x b a c a d",l.toString());
		System.out.println("ok");

		l = new ListeRecCaracteres(caracteres);
		System.out.print("Test 3 : liste testee : "+l + " : remplacer d par x : ");
		l.remplacer('d', 'x');
		assertEquals("contenu liste ko "," a b a c a x",l.toString());
		System.out.println("ok");

		l = new ListeRecCaracteres(caracteres);
		System.out.print("Test 4 : liste testee : "+l + " : remplacer y par x : ");
		l.remplacer('y', 'x');
		assertEquals("contenu liste ko "," a b a c a d",l.toString());
		System.out.println("ok");


		l = new ListeRecCaracteres();
		System.out.print("Test 5 : liste vide : remplacer a par x: ");
		l.remplacer('a', 'x');
		assertEquals("contenu liste ko ","",l.toString());
		System.out.println("ok");


		System.out.println("Tous les tests ont reussi!");
		System.out.println();
		System.out.println();	

	}


	private static void testEstEgalA() {
		char [] caracteres1 = {'a','b','c'};
		char [] caracteres2 = {'a','b','x'};
		char [] caracteres3 = {'a','b'};
		char [] caracteres4 = {'x','b','c'};

		ListeRecCaracteres l1 = new ListeRecCaracteres(caracteres1);
		ListeRecCaracteres l1Bis = new ListeRecCaracteres(caracteres1);
		ListeRecCaracteres l2 = new ListeRecCaracteres(caracteres2);
		ListeRecCaracteres l3 = new ListeRecCaracteres(caracteres3);
		ListeRecCaracteres l4 = new ListeRecCaracteres(caracteres4);
		ListeRecCaracteres lVide = new ListeRecCaracteres();
		ListeRecCaracteres lVideBis = new ListeRecCaracteres();

		System.out.print("Test 1 : this : "+l1+ "   parametre : "+l1Bis+" : ");
		assertEquals("booleen renvoye ko ",true,l1.estEgalA(l1Bis));
		assertEquals("Attention contenu modifie!", " a b c", l1.toString());
		assertEquals("Attention contenu modifie!", " a b c", l1Bis.toString());
		System.out.println("ok");

		System.out.print("Test 2 : this : "+l1+ "   parametre : "+l2+" : ");
		assertEquals("booleen renvoye ko ",false,l1.estEgalA(l2));
		System.out.println("ok");

		System.out.print("Test 3 : this : "+l1+ "   parametre : "+l4+" : ");
		assertEquals("booleen renvoye ko ",false,l1.estEgalA(l4));
		System.out.println("ok");

		System.out.print("Test 4 : this : "+l1+ "   parametre : "+l3+" : ");
		assertEquals("booleen renvoye ko ",false,l1.estEgalA(l3));
		System.out.println("ok");

		System.out.print("Test 5 : this : "+l3+ "   parametre : "+l1+" : ");
		assertEquals("booleen renvoye ko ",false,l3.estEgalA(l1));
		System.out.println("ok");

		System.out.print("Test 6 : this : liste vide   parametre : "+l1+" : ");
		assertEquals("booleen renvoye ko ",false,lVide.estEgalA(l1));
		System.out.println("ok");

		System.out.print("Test 7 : this : "+l1+"   parametre : liste vide : ");
		assertEquals("booleen renvoye ko ",false,l1.estEgalA(lVide));
		System.out.println("ok");

		System.out.print("Test 8 : this : liste vide   parametre : liste vide : ");
		assertEquals("booleen renvoye ko ",true,lVide.estEgalA(lVideBis));
		System.out.println("ok");

		System.out.println("Tous les tests ont reussi");
		System.out.println();
	}

	private static void testNombreOccurrences(){
		char [] caracteres = {'a','a','b','a'};

		ListeRecCaracteres l = new ListeRecCaracteres(caracteres);
		System.out.print("Test 1 : liste testee : "+l +" nombre occurrences a : ");
		assertEquals("nombre occurrences ko ",3,l.nombreOccurrences('a'));
		assertEquals("la liste a ete modifiee! "," a a b a",l.toString());
		System.out.println("ok");

		l = new ListeRecCaracteres(caracteres);
		System.out.print("Test 2 : liste testee : "+l +" nombre occurrences b : ");
		assertEquals("nombre occurrences ko ",1,l.nombreOccurrences('b'));
		assertEquals("la liste a ete modifiee! "," a a b a",l.toString());
		System.out.println("ok");

		l = new ListeRecCaracteres(caracteres);
		System.out.print("Test 3 : liste testee : "+l +" nombre occurrences x : ");
		assertEquals("nombre occurrences ko ",0,l.nombreOccurrences('x'));
		assertEquals("la liste a ete modifiee! "," a a b a",l.toString());
		System.out.println("ok");

		l = new ListeRecCaracteres();
		System.out.println("Test 4 : liste vide : nombre occurrences a");
		assertEquals("nombre occurrences ko ",0,l.nombreOccurrences('a'));
		System.out.println("ok");

		System.out.println("Tous les tests ont reussi!");
		System.out.println();
		System.out.println();
	}

	private static void testSupprimerPremiereOccurrence(){
		char [] caracteres = {'a','b','a','c'};
		ListeRecCaracteres l = new ListeRecCaracteres(caracteres);

		l = new ListeRecCaracteres(caracteres);
		System.out.print("Test 1 : liste testee : "+l+" suppression b : ");
		assertEquals("booleen renvoye ko ",true,l.supprimerPremiereOccurrence('b'));
		assertEquals("nouveau contenu ko "," a a c",l.toString());
		System.out.println("ok");

		l = new ListeRecCaracteres(caracteres);
		System.out.print("Test 2 : liste testee : "+l +" suppression a : ");
		assertEquals("booleen renvoye ko ",true,l.supprimerPremiereOccurrence('a'));
		assertEquals("nouveau contenu ko "," b a c",l.toString());
		System.out.println("ok");

		l = new ListeRecCaracteres(caracteres);
		System.out.print("Test 3 : liste testee : "+l+" suppression c : ");
		assertEquals("suppression c ko ",true,l.supprimerPremiereOccurrence('c'));
		assertEquals("nouveau contenu ko "," a b a",l.toString());
		System.out.println("ok");


		l = new ListeRecCaracteres(caracteres);
		System.out.print("Test 4 : liste testee : "+l+" suppression x : ");
		assertEquals("booleen renvoye ko ",false,l.supprimerPremiereOccurrence('x'));
		assertEquals("contenu ko (contenu modifie)"," a b a c",l.toString());
		System.out.println("ok");

		l = new ListeRecCaracteres();
		System.out.print("Test 5 : liste vide : suppression a : ");
		assertEquals("booleen renvoye ko ",false,l.supprimerPremiereOccurrence('a'));
		assertEquals("contenu ko (contenu modifie)","",l.toString());
		System.out.println("ok");

		System.out.println("Tous les tests ont reussi!");
		System.out.println();
		System.out.println();
	}

	private static void testsupprimerToutesLesOccurrencess(){
		char [] caracteres = {'a','b','a','c','a','b'};
		ListeRecCaracteres l = new ListeRecCaracteres(caracteres);
		System.out.print("Test 1 : liste testee : "+l + " : suppression a : ");
		assertEquals("nombre renvoye ko ",3,l.supprimerToutesLesOccurrences('a'));
		assertEquals("contenu liste ko "," b c b",l.toString());
		System.out.println("ok");

		l = new ListeRecCaracteres(caracteres);
		System.out.print("Test 2 : liste testee : "+l + " : suppression b : ");
		assertEquals("nombre renvoye ko ",2,l.supprimerToutesLesOccurrences('b'));
		assertEquals("contenu liste ko "," a a c a",l.toString());
		System.out.println("ok");

		l = new ListeRecCaracteres(caracteres);
		System.out.print("Test 3 : liste testee : "+l+ " : suppression c : ");
		assertEquals("nombre renvoye ko ",1,l.supprimerToutesLesOccurrences('c'));
		assertEquals("contenu liste ko "," a b a a b",l.toString());
		System.out.println("ok");

		l = new ListeRecCaracteres(caracteres);
		System.out.print("Test 4 : liste testee : "+l+ " : suppression x : ");
		assertEquals("nombre renvoye ko ",0,l.supprimerToutesLesOccurrences('x'));
		assertEquals("contenu liste ko "," a b a c a b",l.toString());
		System.out.println("ok");

		l = new ListeRecCaracteres();
		System.out.print("Test 5 : liste vide : suppression a : ");
		assertEquals("nombre renvoye ko ",0,l.supprimerToutesLesOccurrences('a'));
		assertEquals("contenu liste ko ","",l.toString());
		System.out.println("ok");
		
		char [] caracteres2 = {'a'};
		l = new ListeRecCaracteres(caracteres2);
		System.out.print("Test 6 : liste testee : "+l+ " : suppression a : ");
		assertEquals("nombre renvoye ko ",1,l.supprimerToutesLesOccurrences('a'));
		assertEquals("contenu liste ko ","",l.toString());
		System.out.println("ok");
		
		char [] caracteres3 = {'a','a','a','a'};
		l = new ListeRecCaracteres(caracteres3);
		System.out.print("Test 7 : liste testee : "+l+ " : suppression a : ");
		assertEquals("nombre renvoye ko ",4,l.supprimerToutesLesOccurrences('a'));
		assertEquals("contenu liste ko ","",l.toString());
		System.out.println("ok");
		
		char [] caracteres4 = {'a','a','a','a','b','b','a','a'};
		l = new ListeRecCaracteres(caracteres4);
		System.out.print("Test 8 : liste testee : "+l+ " : suppression a : ");
		assertEquals("nombre renvoye ko ",6,l.supprimerToutesLesOccurrences('a'));
		assertEquals("contenu liste ko "," b b",l.toString());
		System.out.println("ok");
		
		System.out.println("Tous les tests ont reussi!");
		System.out.println();
		System.out.println();	
	}

	private static void testContient(){
		char [] caracteres = {'a','b','c','d'};
		ListeRecCaracteres l;
		l = new ListeRecCaracteres(caracteres);
		System.out.print("Test 1 : liste testee : "+l+" contient c : ");
		assertEquals("booleen renvoye ko",true,l.contient('c'));
		assertEquals("Attention, liste modifiee! "," a b c d",l.toString());
		System.out.println("ok");


		l = new ListeRecCaracteres(caracteres);
		System.out.print("Test 2 : liste testee : "+l+ " contient f : ");
		assertEquals("booleen renvoye ko ",false,l.contient('f'));
		System.out.println("ok");


		l = new ListeRecCaracteres(caracteres);
		System.out.print("Test 3 : liste testee : "+l+" contient d : ");
		assertEquals("booleen renvoye ko ",true, l.contient('d'));
		System.out.println("ok");


		l = new ListeRecCaracteres(caracteres);
		System.out.print("Test 4 : liste testee : "+l+" contient a : ");
		assertEquals("booleen renvoye ko ",true, l.contient('a'));
		System.out.println("ok");


		l = new ListeRecCaracteres();
		System.out.print("Test 5 : liste vide : contient a : ");
		assertEquals("booleen renvoye ko ",false,l.contient('a'));
		System.out.println("ok");

		char [] caractereA = {'a'};
		l = new ListeRecCaracteres(caractereA);
		System.out.print("Test 6 : liste testee : "+l+" contient a : ");
		assertEquals("booleen renvoye ko ",true,l.contient('a'));
		System.out.println("ok");

		System.out.println("Tous les tests ont reussi!");
		System.out.println();
		System.out.println();

	}



}
