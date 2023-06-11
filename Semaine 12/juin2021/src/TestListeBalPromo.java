import java.util.Scanner;

public class TestListeBalPromo{
	
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
			
				System.out.println(messageErreur+"\n --> Attendu="+attendu+" recu="+recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {
		
			System.out.println(messageErreur+"\n --> Attendu="+attendu+" recu="+recu);
			System.exit(0);			
		}
	}
	
	/**
	 * Cette methode appelle la methode assertEquals avec un message d'erreur adequat
	 * @param numeroMessage le numero du message a afficher en cas d'erreur
	 * @param attendu la valeur qu'on s'attendait a recevoir
	 * @param recu la valeur qu'on a recu en realite
	 */
	private static void assertEquals(int numeroMessage, Object attendu, Object recu) {
		String[] message = new String[10];
		message[0]="Test ko, la methode n'a pas renvoye ce qui etait attendu";
		message[1]="Test ko, apres appel de la methode, le nombre d'elements dans le map n'est pas celui attendu";
		message[2]="Test ko, apres appel de la methode, Il y a un probleme dans le chainage dans le sens -->";
		message[3]="Test ko, apres appel de la methode, Il y a un probleme dans le chainage dans le sens <--";
		message[4]="Test ko, apres appel de la methode, la liste a ete modifiee";
		assertEquals(message[numeroMessage],attendu,recu);
	}
	
	public static void main(String[] args) {
		System.out.println("*******************************************");
		System.out.println("Programme Test pour la classe ListeBalPromo");
		System.out.println("*******************************************");
		int choix = 0;
		do {	
			System.out.println("1 -> Tester la methode nombreLyceensMajeurs()");
			System.out.println("2 -> Tester la methode ontTous16AnsOuPlus()");			
			System.out.println("3 -> Tester la methode donnerPartenaire()");
			System.out.println("4 -> Tester la methode ajouterCouple()");	
			System.out.println();
			System.out.print("Entrez votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
			case 1:
				testNombreLyceensMajeurs();
				break;
			case 2:
				test16Plus();
				break;		
			case 3:
				testDonnerPartenaire();
				break;
			case 4:
				testAjouterCouple();
				break;

			default:
				break;
			}
		} while (choix >= 1 && choix <= 4 );	
		System.out.println();
		System.out.println("Fin des tests");
	}


	private static void testNombreLyceensMajeurs() {
		ListeBalPromo listeBal ;
		System.out.println();
	
		Lyceen[] tableTestee = new Lyceen[6];
		tableTestee[0] = new Lyceen("adam",'G',18);
		tableTestee[1] = new Lyceen("eve",'F',18);
		tableTestee[2] = new Lyceen("william",'G',20);
		tableTestee[3] = new Lyceen("kate",'F',19);
		tableTestee[4] = new Lyceen("serge",'G',18);
		tableTestee[5] = new Lyceen("jane",'F',18);
		
		System.out.println();
		System.out.println("Test1 : liste testee : adam(18) eve(18) william(20) kate(19) serge(18) jane(18)");
		listeBal = new ListeBalPromo(tableTestee);	
		assertEquals(0, 6 , listeBal.donnerNombreLyceensMajeurs());
		assertEquals(4, "(adam,eve,william,kate,serge,jane)", listeBal.teteQueue());
		System.out.println("Test ok");
		
		
		System.out.println();
		System.out.println("Test2 : liste testee : adam(18) eve(18) william(19) kate(14) serge(18) jane(17)");
		tableTestee[3] = new Lyceen("kate",'F',14);
		tableTestee[5] = new Lyceen("jane",'F',17);
		listeBal = new ListeBalPromo(tableTestee);	
		assertEquals(0, 4 , listeBal.donnerNombreLyceensMajeurs());
		System.out.println("Test ok");	
		
		System.out.println();
		System.out.println("Test3 : liste testee : liste vide");
		listeBal = new ListeBalPromo();	
		assertEquals(0, 0 , listeBal.donnerNombreLyceensMajeurs());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();
		
		
	}

	private static void test16Plus() {
		ListeBalPromo listeBal ;
		System.out.println();
	
		Lyceen[] tableTestee = new Lyceen[6];
		tableTestee[0] = new Lyceen("adam",'G',18);
		tableTestee[1] = new Lyceen("eve",'F',18);
		tableTestee[2] = new Lyceen("william",'G',18);
		tableTestee[3] = new Lyceen("kate",'F',18);
		tableTestee[4] = new Lyceen("serge",'G',18);
		tableTestee[5] = new Lyceen("jane",'F',18);
		
		System.out.println();
		System.out.println("Test1 : liste testee : adam(18) eve(18) william(18) kate(18) serge(18) jane(18)");
		listeBal = new ListeBalPromo(tableTestee);	
		assertEquals(0, true, listeBal.ontTous16AnsOuPlus());
		assertEquals(4, "(adam,eve,william,kate,serge,jane)", listeBal.teteQueue());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test2 : liste testee : adam(18) eve(18) william(18) kate(14) serge(18) jane(18)");
		tableTestee[3] = new Lyceen("kate",'F',14);
		listeBal = new ListeBalPromo(tableTestee);	
		assertEquals(0, false, listeBal.ontTous16AnsOuPlus());
		System.out.println("Test ok");
		
		
		System.out.println();
		System.out.println("Test3 : liste testee : adam(14) eve(18) william(18) kate(18) serge(18) jane(18)");
		tableTestee[0] = new Lyceen("adam",'G',14);
		tableTestee[3] = new Lyceen("kate",'F',18);
		listeBal = new ListeBalPromo(tableTestee);	
		assertEquals(0, false, listeBal.ontTous16AnsOuPlus());
		System.out.println("Test ok");
			
		System.out.println();
		System.out.println("Test4 : liste testee : adam(18) eve(18) william(18) kate(18) serge(18) jane(14)");
		tableTestee[0] = new Lyceen("adam",'G',18);
		tableTestee[5] = new Lyceen("jane",'F',14);
		listeBal = new ListeBalPromo(tableTestee);	
		assertEquals(0, false, listeBal.ontTous16AnsOuPlus());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test5 : liste testee : liste vide");
		listeBal = new ListeBalPromo();	
		assertEquals(0, true, listeBal.ontTous16AnsOuPlus());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();
		
	}


	private static void testDonnerPartenaire() {
		ListeBalPromo listeBal ;
		System.out.println();
			
		Lyceen[] tableTestee = new Lyceen[6];
		tableTestee[0] = new Lyceen("adam",'G',18);
		tableTestee[1] = new Lyceen("eve",'F',18);
		tableTestee[2] = new Lyceen("william",'G',18);
		tableTestee[3] = new Lyceen("kate",'F',18);
		tableTestee[4] = new Lyceen("serge",'G',18);
		tableTestee[5] = new Lyceen("jane",'F',18);
		
		Lyceen kate = new Lyceen("kate",'F',18);
		Lyceen william = new Lyceen("william",'G',18);
		Lyceen eve = new Lyceen("eve",'F',18);
		Lyceen adam = new Lyceen("adam",'G',18);
		Lyceen jane = new Lyceen("jane",'F',18);
		Lyceen serge = new Lyceen("serge",'G',18);
		Lyceen pierre = new Lyceen("pierre",'G',18);
		
		
		System.out.println();
		System.out.println("Test1 : liste testee : adam eve william kate serge jane : donnerPartenaire william");
		listeBal = new ListeBalPromo(tableTestee);	
		assertEquals(0, kate, listeBal.donnerPartenaire(william));
		assertEquals(4, "(adam,eve,william,kate,serge,jane)", listeBal.teteQueue());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test2 : liste testee : adam eve william kate serge jane : donnerPartenaire kate");	
		listeBal = new ListeBalPromo(tableTestee);
		assertEquals(0, william, listeBal.donnerPartenaire(kate));
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test3 : liste testee : adam eve william kate serge jane : donnerPartenaire serge");	
		listeBal = new ListeBalPromo(tableTestee);
		assertEquals(0, jane, listeBal.donnerPartenaire(serge));
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test4 : liste testee : adam eve william kate serge jane : donnerPartenaire eve");	
		listeBal = new ListeBalPromo(tableTestee);
		assertEquals(0, adam, listeBal.donnerPartenaire(eve));
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test5 : liste testee : adam eve william kate serge jane : donnerPartenaire pierre");	
		listeBal = new ListeBalPromo(tableTestee);
		assertEquals(0, null, listeBal.donnerPartenaire(pierre));
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();

	}

	private static void testAjouterCouple() {
		
		ListeBalPromo listeBal ;
		System.out.println();
			
		Lyceen[] tableTestee = new Lyceen[6];
		tableTestee[0] = new Lyceen("adam",'G',18);
		tableTestee[1] = new Lyceen("eve",'F',18);
		tableTestee[2] = new Lyceen("william",'G',18);
		tableTestee[3] = new Lyceen("kate",'F',18);
		tableTestee[4] = new Lyceen("serge",'G',18);
		tableTestee[5] = new Lyceen("jane",'F',18);
			
		System.out.println();
		System.out.println("Test1 : liste testee : adam eve william kate serge jane : ajouterCouple philippe mathilde");
	
		listeBal = new ListeBalPromo(tableTestee);
		
		assertEquals(0, true, listeBal.ajouterCouple(new Lyceen("philippe", 'G', 18),new Lyceen("mathilde",'F',18)));
		assertEquals(1, 8, listeBal.taille());
		assertEquals(2, "(adam,eve,william,kate,serge,jane,philippe,mathilde)", listeBal.teteQueue());
		assertEquals(3, "(mathilde,philippe,jane,serge,kate,william,eve,adam)", listeBal.queueTete());
		System.out.println("Test ok");
		
		
		System.out.println();
		System.out.println("Test2 : liste testee : adam eve william kate serge jane : ajouterCouple mathilde philippe");
	
		listeBal = new ListeBalPromo(tableTestee);
		
		assertEquals(0, true, listeBal.ajouterCouple(new Lyceen("mathilde",'F',18),new Lyceen("philippe", 'G', 18)));
		assertEquals(1, 8, listeBal.taille());
		assertEquals(2, "(adam,eve,william,kate,serge,jane,philippe,mathilde)", listeBal.teteQueue());
		assertEquals(3, "(mathilde,philippe,jane,serge,kate,william,eve,adam)", listeBal.queueTete());
		System.out.println("Test ok");
		
		
		System.out.println();
		System.out.println("Test3 : liste testee : adam eve william kate serge jane : ajouterCouple william marie");
	
		listeBal = new ListeBalPromo(tableTestee);
		
		assertEquals(0, false, listeBal.ajouterCouple(new Lyceen("william",'G',18),new Lyceen("marie", 'F', 18)));
		assertEquals(1, 6, listeBal.taille());
		assertEquals(2, "(adam,eve,william,kate,serge,jane)", listeBal.teteQueue());
		assertEquals(3, "(jane,serge,kate,william,eve,adam)", listeBal.queueTete());
		System.out.println("Test ok");
		
		
		System.out.println();
		System.out.println("Test4 : liste testee : adam eve william kate serge jane : ajouterCouple pierre jane");
	
		listeBal = new ListeBalPromo(tableTestee);
		
		assertEquals(0, false, listeBal.ajouterCouple(new Lyceen("pierre",'G',18),new Lyceen("jane", 'F', 18)));
		assertEquals(1, 6, listeBal.taille());
		assertEquals(2, "(adam,eve,william,kate,serge,jane)", listeBal.teteQueue());
		assertEquals(3, "(jane,serge,kate,william,eve,adam)", listeBal.queueTete());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test5 : liste testee : adam eve william kate serge jane : ajouterCouple pierre paul");
	
		listeBal = new ListeBalPromo(tableTestee);
		
		assertEquals(0, false, listeBal.ajouterCouple(new Lyceen("pierre",'G',18),new Lyceen("paul", 'G', 18)));
		assertEquals(1, 6, listeBal.taille());
		assertEquals(2, "(adam,eve,william,kate,serge,jane)", listeBal.teteQueue());
		assertEquals(3, "(jane,serge,kate,william,eve,adam)", listeBal.queueTete());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test6 : liste testee : adam eve william kate serge jane : ajouterCouple anne marie");
	
		listeBal = new ListeBalPromo(tableTestee);
		
		assertEquals(0, false, listeBal.ajouterCouple(new Lyceen("anne",'F',18),new Lyceen("marie", 'F', 18)));
		assertEquals(1, 6, listeBal.taille());
		assertEquals(2, "(adam,eve,william,kate,serge,jane)", listeBal.teteQueue());
		assertEquals(3, "(jane,serge,kate,william,eve,adam)", listeBal.queueTete());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test7 : liste testee : liste vide : ajouterCouple philippe mathilde");
		
		listeBal = new ListeBalPromo();
		
		assertEquals(0, true, listeBal.ajouterCouple(new Lyceen("philippe",'G',18),new Lyceen("mathilde", 'F', 18)));
		assertEquals(1, 2, listeBal.taille());
		assertEquals(2, "(philippe,mathilde)", listeBal.teteQueue());
		assertEquals(3, "(mathilde,philippe)", listeBal.queueTete());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test8 : liste testee : liste vide : ajouterCouple mathilde philippe");
		
		listeBal = new ListeBalPromo();
		
		assertEquals(0, true, listeBal.ajouterCouple(new Lyceen("mathilde", 'F', 18),new Lyceen("philippe",'G',18)));
		assertEquals(1, 2, listeBal.taille());
		assertEquals(2, "(philippe,mathilde)", listeBal.teteQueue());
		assertEquals(3, "(mathilde,philippe)", listeBal.queueTete());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();
		
	}

}
