
public class TestDefiEnsembleTableHashing {

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
				System.out.println(messageErreur+". Attendu="+attendu+" reçu="+recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {
			System.out.println(messageErreur+". Attendu="+attendu+" reçu="+recu);
			System.exit(0);
		}
	}

	public static void main(String[] args) {	
		System.out.println("***************************");
		System.out.println("Programme Test pour le defi");
		System.out.println("***************************");
		Ensemble<Entier> e;
		e = new EnsembleTableHashing<Entier>(4,0.75);

		System.out.println("ajout 5");
		e.ajouter(new Entier(5));
		assertEquals("ko","\ntable0\n" +
				"table1 5\n" +
				"table2\n" +
				"table3",e.toString());
		assertEquals("contient 5 ko",true,e.contient(new Entier(5)));
		assertEquals("contient 7 ko",false,e.contient(new Entier(7)));
		System.out.println(e.toString());

		System.out.println();
		System.out.println();
		System.out.println("ajout 7");
		e.ajouter(new Entier(7));
		assertEquals("contenu ko","\ntable0\n" +
				"table1 5\n" +
				"table2\n" +
				"table3 7",e.toString());
		assertEquals("contient 5 ko",true,e.contient(new Entier(5)));
		assertEquals("contient 7 ko",true,e.contient(new Entier(7)));
		System.out.println(e.toString());

		System.out.println();
		System.out.println();
		System.out.println("ajout 9");
		e.ajouter(new Entier(9));
		assertEquals("ko","\ntable0\n" +
				"table1 9 5\n" +
				"table2\n" +
				"table3 7",e.toString());
		assertEquals("contient 5 ko",true,e.contient(new Entier(5)));
		assertEquals("contient 7 ko",true,e.contient(new Entier(7)));
		assertEquals("contient 9 ko",true,e.contient(new Entier(9)));
		System.out.println(e.toString());

		System.out.println();
		System.out.println();
		System.out.println("ajout 1");
		e.ajouter(new Entier(1));
		assertEquals("ko","\ntable0\n" +
				"table1 1 9\n" +
				"table2\n" +
				"table3\n" +
				"table4\n" +
				"table5 5\n" +
				"table6\n" +
				"table7 7",e.toString());
		assertEquals("contient 5 ko",true,e.contient(new Entier(5)));
		assertEquals("contient 7 ko",true,e.contient(new Entier(7)));
		assertEquals("contient 1 ko",true,e.contient(new Entier(1)));
		assertEquals("contient 9 ko",true,e.contient(new Entier(9)));
		System.out.println(e.toString());

		System.out.println();
		System.out.println("Les tests ont reussi");
	}
}
