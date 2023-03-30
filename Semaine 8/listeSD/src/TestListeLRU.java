import java.util.Scanner;


public class TestListeLRU {
	
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
		assertEquals(message[numeroMessage],attendu,recu);
	}
	
	public static void main(String[] args) {
		System.out.println("**************************************");
		System.out.println("Programme Test pour la classe ListeLRU");
		System.out.println("**************************************");
		int choix = 0;
		do {
			System.out.println("1 -> Tester la methode contient()");
			System.out.println("2 -> Tester la methode insererEnTete()");
			System.out.println("3 -> Tester la methode supprimer()");
			System.out.println("4 -> Tester la methode supprimerDernier()");
			System.out.println();
			System.out.print("Entrez votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
			case 1:
				testContient();
				break;
			case 2:
				testInsererEnTete();
				break;
			case 3:
				testSupprimer();
				break;	
			case 4:
				testSupprimerDernier();
				break;	
			default:
				break;
			}
		} while (choix >= 1 && choix <= 4 );
		
		
		
	}

	private static void testSupprimerDernier() {
		ListeLRU<String> l ;
		System.out.println();

		System.out.println();
		System.out.println("Test1 : liste testee : marie pierre hugo sam lea : supprimer dernier");
		String[] tableTestee1 = {"marie","pierre","hugo","sam","lea"};
		l = new ListeLRU<String>(tableTestee1);
		String dernier = l.supprimerDernier();
		assertEquals(0,"lea",dernier);
		assertEquals(1, 4, l.taille());
		assertEquals(2, "(marie,pierre,hugo,sam)", l.teteQueue());
		assertEquals(3, "(sam,hugo,pierre,marie)", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test2 : liste testee : marie : supprimer dernier");
		String[] tableTestee2 = {"marie"};
		l = new ListeLRU<String>(tableTestee2);
		dernier = l.supprimerDernier();
		assertEquals(0,"marie",dernier);
		assertEquals(1, 0, l.taille());
		assertEquals(2, "()", l.teteQueue());
		assertEquals(3, "()", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test3 : liste vide : supprimer dernier");
		String[] tableTestee3 = {};
		l = new ListeLRU<String>(tableTestee3);
		dernier = l.supprimerDernier();
		assertEquals(0,null,dernier);
		assertEquals(1, 0, l.taille());
		assertEquals(2, "()", l.teteQueue());
		assertEquals(3, "()", l.queueTete());
		System.out.println("Test ok");


		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();

	}


	private static void testSupprimer() {
		ListeLRU<String> l ;
		System.out.println();
		
		System.out.println();
		System.out.println("Test1 : liste testee : marie pierre hugo sam lea : supprimer pierre");
		String[] tableTestee1 = {"marie","pierre","hugo","sam","lea"};
		l = new ListeLRU<String>(tableTestee1);
		assertEquals(0, true, l.supprimer("pierre"));
		assertEquals(1, 4, l.taille());
		assertEquals(2, "(marie,hugo,sam,lea)", l.teteQueue());
		assertEquals(3, "(lea,sam,hugo,marie)", l.queueTete());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test2 : liste testee : marie pierre hugo sam lea : supprimer lea");
		String[] tableTestee2 = {"marie","pierre","hugo","sam","lea"};
		l = new ListeLRU<String>(tableTestee2);
		assertEquals(0, true, l.supprimer("lea"));
		assertEquals(1, 4, l.taille());
		assertEquals(2, "(marie,pierre,hugo,sam)", l.teteQueue());
		assertEquals(3, "(sam,hugo,pierre,marie)", l.queueTete());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test3 : liste testee : marie pierre hugo sam lea : supprimer marie");
		String[] tableTestee3 = {"marie","pierre","hugo","sam","lea"};
		l = new ListeLRU<String>(tableTestee3);
		assertEquals(0, true, l.supprimer("marie"));
		assertEquals(1, 4, l.taille());
		assertEquals(2, "(pierre,hugo,sam,lea)", l.teteQueue());
		assertEquals(3, "(lea,sam,hugo,pierre)", l.queueTete());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test4 : liste testee : marie pierre hugo sam lea : supprimer tom");
		String[] tableTestee4 = {"marie","pierre","hugo","sam","lea"};
		l = new ListeLRU<String>(tableTestee4);
		assertEquals(0, false, l.supprimer("tom"));
		assertEquals(1, 5, l.taille());
		assertEquals(2, "(marie,pierre,hugo,sam,lea)", l.teteQueue());
		assertEquals(3, "(lea,sam,hugo,pierre,marie)", l.queueTete());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test5 : liste testee : marie : supprimer marie");
		String[] tableTestee5 = {"marie"};
		l = new ListeLRU<String>(tableTestee5);
		assertEquals(0, true, l.supprimer("marie"));
		assertEquals(1, 0, l.taille());
		assertEquals(2, "()", l.teteQueue());
		assertEquals(3, "()", l.queueTete());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test6 : liste vide : supprimer marie");
		String[] tableTestee6 = {};
		l = new ListeLRU<String>(tableTestee6);
		assertEquals(0, false, l.supprimer("marie"));
		assertEquals(1, 0, l.taille());
		assertEquals(2, "()", l.teteQueue());
		assertEquals(3, "()", l.queueTete());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();
		
		
	}

	private static void testInsererEnTete() {
		ListeLRU<String> l ;
		System.out.println();
		
		System.out.println();
		System.out.println("Test1 : liste testee : marie pierre hugo : insererEnTete tom ?");
		String[] tableTestee1 = {"marie","pierre","hugo"};
		l = new ListeLRU<String>(tableTestee1);
		assertEquals(0, true, l.insererEnTete("tom"));
		assertEquals(1, 4, l.taille());
		assertEquals(2, "(tom,marie,pierre,hugo)", l.teteQueue());
		assertEquals(3, "(hugo,pierre,marie,tom)", l.queueTete());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test1 : liste testee : marie pierre hugo : insererEnTete pierre ?");
		String[] tableTestee2 = {"marie","pierre","hugo"};
		l = new ListeLRU<String>(tableTestee2);
		assertEquals(0, false, l.insererEnTete("pierre"));
		assertEquals(1, 3, l.taille());
		assertEquals(2, "(marie,pierre,hugo)", l.teteQueue());
		assertEquals(3, "(hugo,pierre,marie)", l.queueTete());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test3 : liste testee : liste vide : insererEnTete tom ?");
		String[] tableTestee3 = {};
		l = new ListeLRU<String>(tableTestee3);
		assertEquals(0, true, l.insererEnTete("tom"));
		assertEquals(1, 1, l.taille());
		assertEquals(2, "(tom)", l.teteQueue());
		assertEquals(3, "(tom)", l.queueTete());
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();
		
	}

	private static void testContient() {
		ListeLRU<String> l ;
		System.out.println();
		
		System.out.println();
		System.out.println("Test1 : liste vide : contient pierre ?");
		String[] tableTestee1 = {};
		l = new ListeLRU<String>(tableTestee1);
		assertEquals(0, false, l.contient("pierre"));
		System.out.println("Test ok");
		
		
		System.out.println();
		System.out.println("Test2 : liste testee : marie pierre hugo : contient pierre ?");
		String[] tableTestee2 = {"marie","pierre","hugo"};
		l = new ListeLRU<String>(tableTestee2);
		assertEquals(0, true, l.contient("pierre"));
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Test3 : liste testee : marie pierre hugo : contient sam ?");
		String[] tableTestee3 = {"marie","pierre","hugo"};
		l = new ListeLRU<String>(tableTestee3);
		assertEquals(0, false, l.contient("sam"));
		System.out.println("Test ok");
		
		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();
		
	}
	
}
