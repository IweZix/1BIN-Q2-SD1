
public class TestAttributionHangar {
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
				System.out.println(messageErreur+" Attendu="+attendu+" recu="+recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {
			System.out.println(messageErreur+" Attendu="+attendu+" recu="+recu);
			System.exit(0);
		}
	}

	public static void main(String [] args){

		System.out.println("Creation d'un entrepot avec 5 hangars");
		System.out.println("Au depart, tous les hangars sont libres");
		Entrepot entrepot = new Entrepot(5);
		try{
			int nombreHangarsLibres = entrepot.nombreHangarsLibres();
			if(nombreHangarsLibres!=5){
				System.out.println("Avez-vous bien complete la methode nombreHangarsLibres() et le constructeur de la classe Entrepot ?");
				System.out.println("Au depart tous les 5 hangars sont libres !");
				System.out.println("Votre methode en annonce "+nombreHangarsLibres);
				System.exit(0);
			}
		}catch(Exception e){
			System.out.println("Exception inattendue lors de l'appel de la methode nombreHangarOccupes()");
			System.out.println("Avez-vous bien complete cette methode et le constructeur de la classe Entrepot ?");
			System.exit(0);
		}


		try{
			entrepot.nombreSocietesPresentes();
		}catch(Exception e){
			System.out.println("Exception inattendue lors de l'appel de la methode nombreSocietesPresentes()");
			System.out.println("Avez-vous bien complete cette methode est le constructeur de la classe Entrepot ?");
			System.exit(0);
		}

		Societe societeX = new Societe(9,"socX");
		try{
			societeX.ajouterHangar(1);
		}catch(Exception e) {
			System.out.println("Exception inattendue lors de l'appel de la methode ajouterHangar()");
			System.out.println("Avez-vous bien complete cette methode et le constructeur de la classe Societe ?");
			System.exit(0);
		}

		System.out.println("test1 : la societe 3 doit se voir attribuer le hangar numero 3");
		int numero = entrepot.attribuerHangar(3,"numSoc3");
		if(numero!=3){
			System.out.println("test 1 ko : mauvais numero "+ numero);
			System.out.println("Le numero aurait du etre 3");
			System.out.println("Avez-vous bien complete la methode attribuerHangar() en suivant la methode de repartition imposee ?");
			System.exit(0);
		}
		System.out.println("La societe 3 a bien recu le hangar numero 3");
		Societe societe = entrepot.getSociete(3);
		if(societe == null){
			System.out.println("test 1 ko : societe 3 inconnue");
			System.out.println("Avez-vous bien complete la methode getSociete() ?");
			System.exit(0);
		}

		String lesHangars = societe.lesHangars();
		if(lesHangars==null){
			System.out.println("test 1 ko : societe 3 inconnue");
			System.out.println("Avez-vous bien complete la methode lesHangars() ?");
			System.exit(0);
		}

		assertEquals("test 1 ko : pas les bons hangars", "[3]",entrepot.getSociete(3).lesHangars());
		assertEquals("test 1 ko : pas le bon nombre d'hangars libres",4,entrepot.nombreHangarsLibres());
		assertEquals("test 1 ko : pas le bon nombre de societes presentes",1,entrepot.nombreSocietesPresentes());
		System.out.println("test1 ok");
		System.out.println();


		System.out.println("test2 : la societe 5 se voit attribuer le hangar numero 0");
		assertEquals("test 2 ko : mauvais numero", 0, entrepot.attribuerHangar(5,"soc5"));
		assertEquals("test 2 ko : pas les bons hangars", "[0]",entrepot.getSociete(5).lesHangars());
		assertEquals("test 2 ko : pas le bon nombre d'hangars libres",3,entrepot.nombreHangarsLibres());
		assertEquals("test 2 ko : pas le bon nombre de societes presentes",2,entrepot.nombreSocietesPresentes());
		System.out.println("test2 ok");
		System.out.println();

		System.out.println("test3 : la societe 3 se voit attribuer le hangar numero 4");
		assertEquals("test 3 ko : mauvais numero", 4, entrepot.attribuerHangar(3,"soc3"));
		assertEquals("test 3 ko : pas les bons hangars", "[3, 4]",entrepot.getSociete(3).lesHangars());
		assertEquals("test 3 ko : pas le bon nombre d'hangars libres",2,entrepot.nombreHangarsLibres());
		assertEquals("test 3 ko : pas le bon nombre de societes presentes",2,entrepot.nombreSocietesPresentes());
		System.out.println("test3 ok");
		System.out.println();

		System.out.println("test4 : la societe 3 se voit attribuer le hangar numero 1");
		assertEquals("test 4 ko : mauvais numero", 1, entrepot.attribuerHangar(3,"soc3"));
		assertEquals("test 4 ko : pas les bons hangars", "[1, 3, 4]",entrepot.getSociete(3).lesHangars());
		assertEquals("test 4 ko : pas le bon nombre d'hangars libres",1,entrepot.nombreHangarsLibres());
		assertEquals("test 4 ko : pas le bon nombre de societes presentes",2,entrepot.nombreSocietesPresentes());
		System.out.println("test4 ok");
		System.out.println();

		System.out.println("test5 : la societe 5 se voit attribuer le hangar numero 2");
		assertEquals("test 5 ko : mauvais numero", 2, entrepot.attribuerHangar(5,"soc5"));
		assertEquals("test 5 ko : pas les bons hangars", "[0, 2]",entrepot.getSociete(5).lesHangars());
		System.out.println("test5 ok");
		System.out.println();

		System.out.println("test6 : il n'y a plus d'hangar de libre , la societe 3 ne recoit pas d'hangar");
		assertEquals("test 6 ko : mauvais numero", -1, entrepot.attribuerHangar(3,"soc3"));
		assertEquals("test 6 ko : pas les bons hangars", "[1, 3, 4]",entrepot.getSociete(3).lesHangars());
		System.out.println("test6 ok");
		System.out.println();

		System.out.println("test7 : il n'y a plus d'hangar de libre , la societe 99 ne recoit pas d'hangar");
		System.out.println("      : elle ne peut pas etre repertoriee parmi les societes presentes");
		assertEquals("test 7 ko : mauvais numero ", -1, entrepot.attribuerHangar(99,"soc99"));
		assertEquals("test 7 ko : societe n'existe pas", null, entrepot.getSociete(99));
		System.out.println("test7 ok");
		System.out.println();

		System.out.println("Le scenario de tests propose s'est bien deroule");

	}
}
