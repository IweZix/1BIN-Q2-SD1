import java.util.Iterator;
import java.util.Scanner;


public class TestListeSDImpl {

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
		System.out.println("*****************************************");
		System.out.println("Programme Test pour la classe ListeSDImpl");
		System.out.println("*****************************************");
		int choix = 0;
		do {
			System.out.println("1 -> Tester le constructeur");
			System.out.println("2 -> Tester la methode estVide()");
			System.out.println("3 -> Tester la methode contient()");
			System.out.println("4 -> Tester la methode premier()");
			System.out.println("5 -> Tester la methode dernier()");
			System.out.println("6 -> Tester la methode donnerPrecedent()");
			System.out.println("7 -> Tester la methode donnerSuivant()");
			System.out.println("8 -> Tester la methode insererEnTete()");
			System.out.println("9 -> Tester la methode insererEnQueue()");
			System.out.println("10 -> Tester la methode insererApres()");
			System.out.println("11 -> Tester la methode insererAvant()");
			System.out.println("12 -> Tester la methode supprimer()");
			System.out.println("13 -> Tester la methode permuter()");
			System.out.println("14 -> Tester la methode iterator()");
			System.out.println();
			System.out.print("Entrez votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
				case 1:
					testConstructeur();
					break;
				case 2:
					testEstVide();
					break;
				case 3:
					testContient();
					break;
				case 4:
					testPremier();
					break;
				case 5:
					testDernier();
					break;
				case 6:
					testDonnerPrecedent();
					break;
				case 7:
					testDonnerSuivant();
					break;
				case 8:
					testInsererEnTete();
					break;
				case 9:
					testInsererEnQueue();
					break;
				case 10:
					testInsererApres();
					break;
				case 11:
					testInsererAvant();
					break;
				case 12:
					testSupprimer();
					break;
				case 13:
					testPermuter();
					break;
				case 14:
					testIterateur();
					break;
				default:
					break;
			}
		} while (choix >= 1 && choix <= 14 );



	}

	private static void testIterateur() {
		ListeSDImpl<String> l ;
		System.out.println();
		System.out.println("Test : liste testee : marie pierre hugo sam lea");
		String[] tableTestee1 = {"marie","pierre","hugo","sam","lea"};
		l = new ListeSDImpl<String>(tableTestee1);
		Iterator<String> it = l.iterator();
		if(it==null){
			System.out.println("test ko : avez-vous complete la methode iterator() ?");
			System.exit(0);
		}
		if(!it.hasNext()){
			System.out.println("test ko : 1er appel de la methode hasNext()");
			System.out.println("test ko : attendu : true - recu : false");
			System.out.println("test ko : revoyez le constructeur de la classe interne Iterateur");
			System.out.println("test ko : revoyez la methode hasNext() de la classe interne Iterateur");
			System.exit(0);
		}
		if(it.next()==null){
			System.out.println("test ko : 1er appel de la methode next()");
			System.out.println("test ko : recu : null");
			System.out.println("test ko : revoyez le constructeur de la classe interne Iterateur");
			System.out.println("test ko : revoyez la methode next() de la classe interne Iterateur");
			System.exit(0);
		}
		int i = 0;
		for (String s : l
			 ) {
			if(i==tableTestee1.length){
				System.out.println("test ko : le foreach ne s'est pas arrete");
				System.exit(0);
			}
			if(!tableTestee1[i].equals(s)){
				System.out.println("test ko : attendu : "+tableTestee1[i]+ " - recu : "+ s);
				System.exit(0);
			}
			i++;
			System.out.println(s);

		}
		System.out.println("Test ok");


	}


	private static void testPermuter() {
		ListeSDImpl<String> l ;
		System.out.println();

		System.out.println();
		System.out.println("Test1 : liste testee : marie pierre hugo sam lea : permuter pierre lea");
		String[] tableTestee1 = {"marie","pierre","hugo","sam","lea"};
		l = new ListeSDImpl<String>(tableTestee1);
		assertEquals(0, true, l.permuter("pierre","lea"));
		assertEquals(1, 5, l.taille());
		assertEquals(2, "(marie,lea,hugo,sam,pierre)", l.teteQueue());
		assertEquals(3, "(pierre,sam,hugo,lea,marie)", l.queueTete());
		System.out.println("Test ok");

		System.out.println("Test2 : liste testee : marie pierre hugo sam lea : permuter lea pierre");
		String[] tableTestee2 = {"marie","pierre","hugo","sam","lea"};
		l = new ListeSDImpl<String>(tableTestee2);
		assertEquals(0, true, l.permuter("lea","pierre"));
		assertEquals(1, 5, l.taille());
		assertEquals(2, "(marie,lea,hugo,sam,pierre)", l.teteQueue());
		assertEquals(3, "(pierre,sam,hugo,lea,marie)", l.queueTete());
		System.out.println("Test ok");

		System.out.println("Test3 : liste testee : marie pierre hugo sam lea : permuter lea tom");
		String[] tableTestee3 = {"marie","pierre","hugo","sam","lea"};
		l = new ListeSDImpl<String>(tableTestee3);
		assertEquals(0,false, l.permuter("lea","tom"));
		assertEquals(1, 5, l.taille());
		assertEquals(2, "(marie,pierre,hugo,sam,lea)", l.teteQueue());
		assertEquals(3, "(lea,sam,hugo,pierre,marie)", l.queueTete());
		System.out.println("Test ok");

		System.out.println("Test4 : liste testee : marie pierre hugo sam lea : permuter tom lea");
		String[] tableTestee4 = {"marie","pierre","hugo","sam","lea"};
		l = new ListeSDImpl<String>(tableTestee4);
		assertEquals(0,false, l.permuter("tom","lea"));
		assertEquals(1, 5, l.taille());
		assertEquals(2, "(marie,pierre,hugo,sam,lea)", l.teteQueue());
		assertEquals(3, "(lea,sam,hugo,pierre,marie)", l.queueTete());
		System.out.println("Test ok");

		System.out.println("Test5 : liste testee : marie pierre hugo sam lea : permuter hugo hugo");
		String[] tableTestee5 = {"marie","pierre","hugo","sam","lea"};
		l = new ListeSDImpl<String>(tableTestee5);
		assertEquals(0,true, l.permuter("hugo","hugo"));
		assertEquals(1, 5, l.taille());
		assertEquals(2, "(marie,pierre,hugo,sam,lea)", l.teteQueue());
		assertEquals(3, "(lea,sam,hugo,pierre,marie)", l.queueTete());
		System.out.println("Test ok");

		System.out.println("Test6 : liste testee : marie pierre hugo sam lea : permuter marie pierre et ensuite pierre et lea");
		String[] tableTestee6 = {"marie","pierre","hugo","sam","lea"};
		l = new ListeSDImpl<String>(tableTestee5);
		assertEquals(0,true, l.permuter("marie","pierre"));
		assertEquals(0,true, l.permuter("pierre","lea"));
		assertEquals(1, 5, l.taille());
		assertEquals(2, "(lea,marie,hugo,sam,pierre)", l.teteQueue());
		assertEquals(3, "(pierre,sam,hugo,marie,lea)", l.queueTete());
		System.out.println("Test ok");


		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();

	}

	private static void testSupprimer() {
		ListeSDImpl<String> l ;
		System.out.println();

		System.out.println();
		System.out.println("Test1 : liste testee : marie pierre hugo sam lea : supprimer pierre");
		String[] tableTestee1 = {"marie","pierre","hugo","sam","lea"};
		l = new ListeSDImpl<String>(tableTestee1);
		assertEquals(0, true, l.supprimer("pierre"));
		assertEquals(1, 4, l.taille());
		assertEquals(2, "(marie,hugo,sam,lea)", l.teteQueue());
		assertEquals(3, "(lea,sam,hugo,marie)", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test2 : liste testee : marie pierre hugo sam lea : supprimer lea");
		String[] tableTestee2 = {"marie","pierre","hugo","sam","lea"};
		l = new ListeSDImpl<String>(tableTestee2);
		assertEquals(0, true, l.supprimer("lea"));
		assertEquals(1, 4, l.taille());
		assertEquals(2, "(marie,pierre,hugo,sam)", l.teteQueue());
		assertEquals(3, "(sam,hugo,pierre,marie)", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test3 : liste testee : marie pierre hugo sam lea : supprimer marie");
		String[] tableTestee3 = {"marie","pierre","hugo","sam","lea"};
		l = new ListeSDImpl<String>(tableTestee3);
		assertEquals(0, true, l.supprimer("marie"));
		assertEquals(1, 4, l.taille());
		assertEquals(2, "(pierre,hugo,sam,lea)", l.teteQueue());
		assertEquals(3, "(lea,sam,hugo,pierre)", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test4 : liste testee : marie pierre hugo sam lea : supprimer tom");
		String[] tableTestee4 = {"marie","pierre","hugo","sam","lea"};
		l = new ListeSDImpl<String>(tableTestee4);
		assertEquals(0, false, l.supprimer("tom"));
		assertEquals(1, 5, l.taille());
		assertEquals(2, "(marie,pierre,hugo,sam,lea)", l.teteQueue());
		assertEquals(3, "(lea,sam,hugo,pierre,marie)", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test5 : liste testee : marie : supprimer marie");
		String[] tableTestee5 = {"marie"};
		l = new ListeSDImpl<String>(tableTestee5);
		assertEquals(0, true, l.supprimer("marie"));
		assertEquals(1, 0, l.taille());
		assertEquals(2, "()", l.teteQueue());
		assertEquals(3, "()", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test6 : liste vide : supprimer marie");
		String[] tableTestee6 = {};
		l = new ListeSDImpl<String>(tableTestee6);
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

	private static void testInsererAvant() {
		ListeSDImpl<String> l ;
		System.out.println();

		System.out.println();
		System.out.println("Test1 : liste testee : marie pierre hugo : inserer tom avant hugo");
		String[] tableTestee1 = {"marie","pierre","hugo"};
		l = new ListeSDImpl<String>(tableTestee1);
		assertEquals(0, true, l.insererAvant("hugo", "tom"));
		assertEquals(1, 4, l.taille());
		assertEquals(2, "(marie,pierre,tom,hugo)", l.teteQueue());
		assertEquals(3, "(hugo,tom,pierre,marie)", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test2 : liste testee : marie pierre hugo : inserer tom avant marie");
		String[] tableTestee2 = {"marie","pierre","hugo"};
		l = new ListeSDImpl<String>(tableTestee2);
		assertEquals(0, true, l.insererAvant("marie", "tom"));
		assertEquals(1, 4, l.taille());
		assertEquals(2, "(tom,marie,pierre,hugo)", l.teteQueue());
		assertEquals(3, "(hugo,pierre,marie,tom)", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test3 : liste testee : marie pierre hugo : inserer pierre avant hugo");
		String[] tableTestee3 = {"marie","pierre","hugo"};
		l = new ListeSDImpl<String>(tableTestee3);
		assertEquals(0, false, l.insererAvant("hugo", "pierre"));
		assertEquals(1, 3, l.taille());
		assertEquals(2, "(marie,pierre,hugo)", l.teteQueue());
		assertEquals(3, "(hugo,pierre,marie)", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test4 : liste testee : marie pierre hugo : inserer tom avant sam");
		String[] tableTestee4 = {"marie","pierre","hugo"};
		l = new ListeSDImpl<String>(tableTestee4);
		assertEquals(0, false, l.insererAvant("sam", "tom"));
		assertEquals(1, 3, l.taille());
		assertEquals(2, "(marie,pierre,hugo)", l.teteQueue());
		assertEquals(3, "(hugo,pierre,marie)", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();

	}

	private static void testInsererApres() {
		ListeSDImpl<String> l ;
		System.out.println();

		System.out.println();
		System.out.println("Test1 : liste testee : marie pierre hugo : inserer tom apres pierre");
		String[] tableTestee1 = {"marie","pierre","hugo"};
		l = new ListeSDImpl<String>(tableTestee1);
		assertEquals(0, true, l.insererApres("pierre", "tom"));
		assertEquals(1, 4, l.taille());
		assertEquals(2, "(marie,pierre,tom,hugo)", l.teteQueue());
		assertEquals(3, "(hugo,tom,pierre,marie)", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test2 : liste testee : marie pierre hugo : inserer tom apres hugo");
		String[] tableTestee2 = {"marie","pierre","hugo"};
		l = new ListeSDImpl<String>(tableTestee2);
		assertEquals(0, true, l.insererApres("hugo", "tom"));
		assertEquals(1, 4, l.taille());
		assertEquals(2, "(marie,pierre,hugo,tom)", l.teteQueue());
		assertEquals(3, "(tom,hugo,pierre,marie)", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test3 : liste testee : marie pierre hugo : inserer pierre apres hugo");
		String[] tableTestee3 = {"marie","pierre","hugo"};
		l = new ListeSDImpl<String>(tableTestee3);
		assertEquals(0, false, l.insererApres("hugo", "pierre"));
		assertEquals(1, 3, l.taille());
		assertEquals(2, "(marie,pierre,hugo)", l.teteQueue());
		assertEquals(3, "(hugo,pierre,marie)", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test4 : liste testee : marie pierre hugo : inserer tom apres sam");
		String[] tableTestee4 = {"marie","pierre","hugo"};
		l = new ListeSDImpl<String>(tableTestee4);
		assertEquals(0, false, l.insererApres("sam", "tom"));
		assertEquals(1, 3, l.taille());
		assertEquals(2, "(marie,pierre,hugo)", l.teteQueue());
		assertEquals(3, "(hugo,pierre,marie)", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();


	}

	private static void testDonnerSuivant() {
		ListeSDImpl<String> l ;
		System.out.println();

		System.out.println();
		System.out.println("Test 1 : liste testee : marie pierre hugo : donnerSuivant pierre ?");
		String[] tableTestee1 = {"marie","pierre","hugo"};
		l = new ListeSDImpl<String>(tableTestee1);
		assertEquals(0, "hugo", l.donnerSuivant("pierre"));
		System.out.println("Test ok");


		System.out.println();
		System.out.println("Test 2 : liste testee : marie pierre hugo : donnerSuivant hugo");
		String[] tableTestee2 = {"marie","pierre","hugo"};
		l = new ListeSDImpl<String>(tableTestee2);
		assertEquals(0, null, l.donnerSuivant("hugo"));
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test 3 : liste testee : marie pierre hugo : donnerSuivant tom");
		String[] tableTestee3 = {"marie","pierre","hugo"};
		l = new ListeSDImpl<String>(tableTestee3);
		assertEquals(0, null, l.donnerSuivant("tom"));
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test4 : liste vide : donnerSuivant marie ?");
		String[] tableTestee4 = {};
		l = new ListeSDImpl<String>(tableTestee4);
		assertEquals(0, null, l.donnerSuivant("marie"));
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();

	}

	private static void testDonnerPrecedent() {
		ListeSDImpl<String> l ;
		System.out.println();

		System.out.println();
		System.out.println("Test 1 : liste testee : marie pierre hugo : donnerPrecedent hugo ?");
		String[] tableTestee1 = {"marie","pierre","hugo"};
		l = new ListeSDImpl<String>(tableTestee1);
		assertEquals(0, "pierre", l.donnerPrecedent("hugo"));
		System.out.println("Test ok");


		System.out.println();
		System.out.println("Test 2 : liste testee : marie pierre hugo : donnerPrecedent marie");
		String[] tableTestee2 = {"marie","pierre","hugo"};
		l = new ListeSDImpl<String>(tableTestee2);
		assertEquals(0, null, l.donnerPrecedent("marie"));
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test 3 : liste testee : marie pierre hugo : donnerPrecedent tom");
		String[] tableTestee3 = {"marie","pierre","hugo"};
		l = new ListeSDImpl<String>(tableTestee3);
		assertEquals(0, null, l.donnerPrecedent("tom"));
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test4 : liste vide : donnerPrecedent marie ?");
		String[] tableTestee4 = {};
		l = new ListeSDImpl<String>(tableTestee4);
		assertEquals(0, null, l.donnerPrecedent("marie"));
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();


	}

	private static void testInsererEnTete() {
		ListeSDImpl<String> l ;
		System.out.println();

		System.out.println();
		System.out.println("Test1 : liste testee : marie pierre hugo : insererEnTete tom ?");
		String[] tableTestee1 = {"marie","pierre","hugo"};
		l = new ListeSDImpl<String>(tableTestee1);
		assertEquals(0, true, l.insererEnTete("tom"));
		assertEquals(1, 4, l.taille());
		assertEquals(2, "(tom,marie,pierre,hugo)", l.teteQueue());
		assertEquals(3, "(hugo,pierre,marie,tom)", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test1 : liste testee : marie pierre hugo : insererEnTete pierre ?");
		String[] tableTestee2 = {"marie","pierre","hugo"};
		l = new ListeSDImpl<String>(tableTestee2);
		assertEquals(0, false, l.insererEnTete("pierre"));
		assertEquals(1, 3, l.taille());
		assertEquals(2, "(marie,pierre,hugo)", l.teteQueue());
		assertEquals(3, "(hugo,pierre,marie)", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test3 : liste testee : liste vide : insererEnTete tom ?");
		String[] tableTestee3 = {};
		l = new ListeSDImpl<String>(tableTestee3);
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

	private static void testInsererEnQueue() {
		ListeSDImpl<String> l ;
		System.out.println();

		System.out.println();
		System.out.println("Test1 : liste testee : marie pierre hugo : insererEnQueue tom ?");
		String[] tableTestee1 = {"marie","pierre","hugo"};
		l = new ListeSDImpl<String>(tableTestee1);
		assertEquals(0, true, l.insererEnQueue("tom"));
		assertEquals(1, 4, l.taille());
		assertEquals(2, "(marie,pierre,hugo,tom)", l.teteQueue());
		assertEquals(3, "(tom,hugo,pierre,marie)", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test1 : liste testee : marie pierre hugo : insererEnQueue pierre ?");
		String[] tableTestee2 = {"marie","pierre","hugo"};
		l = new ListeSDImpl<String>(tableTestee2);
		assertEquals(0, false, l.insererEnQueue("pierre"));
		assertEquals(1, 3, l.taille());
		assertEquals(2, "(marie,pierre,hugo)", l.teteQueue());
		assertEquals(3, "(hugo,pierre,marie)", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test3 : liste testee : liste vide : insererEnQueue tom ?");
		String[] tableTestee3 = {};
		l = new ListeSDImpl<String>(tableTestee3);
		assertEquals(0, true, l.insererEnQueue("tom"));
		assertEquals(1, 1, l.taille());
		assertEquals(2, "(tom)", l.teteQueue());
		assertEquals(3, "(tom)", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();

	}



	private static void testDernier() {
		ListeSDImpl<String> l ;
		System.out.println();

		System.out.println();
		System.out.println("Test1 : liste vide : dernier ?");
		String[] tableTestee1 = {};
		l = new ListeSDImpl<String>(tableTestee1);
		assertEquals(0, null, l.dernier());
		System.out.println("Test ok");


		System.out.println();
		System.out.println("Test 2 : liste testee : marie pierre hugo : dernier ?");
		String[] tableTestee2 = {"marie","pierre","hugo"};
		l = new ListeSDImpl<String>(tableTestee2);
		assertEquals(0, "hugo", l.dernier());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();

	}

	private static void testPremier() {
		ListeSDImpl<String> l ;
		System.out.println();

		System.out.println();
		System.out.println("Test1 : liste vide : premier ?");
		String[] tableTestee1 = {};
		l = new ListeSDImpl<String>(tableTestee1);
		assertEquals(0, null, l.premier());
		System.out.println("Test ok");


		System.out.println();
		System.out.println("Test 2 : liste testee : marie pierre hugo : premier ?");
		String[] tableTestee2 = {"marie","pierre","hugo"};
		l = new ListeSDImpl<String>(tableTestee2);
		assertEquals(0, "marie", l.premier());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();

	}

	private static void testConstructeur() {
		ListeSDImpl<String> l ;
		System.out.println();
		System.out.println();
		System.out.println("Test constructeur");
		l = new ListeSDImpl<String>();
		try{
			assertEquals(1, 0, l.taille());
		}catch(NullPointerException e){
			System.out.println("Test ko \nN'avez-vous pas oublier de creer le map ?");
			System.exit(0);
		}
		assertEquals(2, "()", l.teteQueue());
		assertEquals(3, "()", l.queueTete());


		System.out.println("Le test a reussi");
		System.out.println();
		System.out.println();
	}

	private static void testEstVide() {

		ListeSDImpl<String> l ;
		System.out.println();

		System.out.println();
		System.out.println("Test1 : liste vide : estVide ?");
		String[] tableTestee1 = {};
		l = new ListeSDImpl<String>(tableTestee1);
		assertEquals(0, true, l.estVide());
		System.out.println("Test ok");


		System.out.println();
		System.out.println("Test 2 : liste testee : marie pierre hugo : estVide ?");
		String[] tableTestee2 = {"marie","pierre","hugo"};
		l = new ListeSDImpl<String>(tableTestee2);
		assertEquals(0, false, l.estVide());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();
	}

	private static void testContient() {
		ListeSDImpl<String> l ;
		System.out.println();

		System.out.println();
		System.out.println("Test1 : liste vide : contient pierre ?");
		String[] tableTestee1 = {};
		l = new ListeSDImpl<String>(tableTestee1);
		assertEquals(0, false, l.contient("pierre"));
		System.out.println("Test ok");


		System.out.println();
		System.out.println("Test2 : liste testee : marie pierre hugo : contient pierre ?");
		String[] tableTestee2 = {"marie","pierre","hugo"};
		l = new ListeSDImpl<String>(tableTestee2);
		assertEquals(0, true, l.contient("pierre"));
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test3 : liste testee : marie pierre hugo : contient sam ?");
		String[] tableTestee3 = {"marie","pierre","hugo"};
		l = new ListeSDImpl<String>(tableTestee3);
		assertEquals(0, false, l.contient("sam"));
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();

	}




}
