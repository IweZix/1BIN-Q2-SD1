
public class TestEnsembleTableBooleens {
	
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
		System.out.println("***************************************************");
		System.out.println("Programme Test pour la classe EnsembleTableBooleens");
		System.out.println("***************************************************");
		Ensemble<Entier> e;
		e = new EnsembleTableBooleens<Entier>(6);
		assertEquals("estVide() ensemble vide", true, e.estVide());
		assertEquals("cardinal ensemble vide ko", 0, e.taille());
		assertEquals("ajout de 1 dans l'ensemble vide booleen ko", true, e.ajouter(new Entier(1)));
		assertEquals("apres ajout 1 dans ensemble vide cardinal ko", 1, e.taille());
		assertEquals("ajout de 2 dans l'ensemble {1) booleen ko", true, e.ajouter(new Entier(2)));
		assertEquals("apres ajout 2 dans ensemble {1) cardinal ko", 2, e.taille());
		assertEquals("ajout de 5 dans l'ensemble {1,2) booleen ko", true, e.ajouter(new Entier(5)));
		assertEquals("apres ajout 5 dans ensemble {1,2) cardinal ko", 3, e.taille());
		assertEquals("ajout de 2 dans l'ensemble {1,2,5) booleen ko", false, e.ajouter(new Entier(2)));
		assertEquals("apres ajout 2 dans ensemble {1,2,5) cardinal ko", 3, e.taille());
		assertEquals("estVide() ensemble {1,2,5)", false, e.estVide());
		assertEquals("1 appartient a l'ensemble {1,2,5} ? ", true, e.contient(new Entier(1)));
		assertEquals("2 appartient a l'ensemble {1,2,5} ? ", true, e.contient(new Entier(2)));
		assertEquals("5 appartient a l'ensemble {1,2,5} ? ", true, e.contient(new Entier(5)));
		assertEquals("4 appartient a l'ensemble {1,2,5} ? ", false, e.contient(new Entier(4)));
		assertEquals("suppression de 1 dans l'ensemble {1,2,5) booleen ko", true, e.enlever(new Entier(1)));
		assertEquals("apres suppression 1 dans ensemble {1,2,5) cardinal ko", 2, e.taille());
		assertEquals("apres suppression 1 dans ensemble {1,2,5) contient 1 ko", false, e.contient(new Entier(1)));
		assertEquals("suppression de 4 dans l'ensemble {1,2,5) booleen ko", false, e.enlever(new Entier(4)));
		assertEquals("apres suppression 4 dans ensemble {2,5) cardinal ko", 2, e.taille());
		System.out.println("Tous les tests ont reussi!");
		
	}
}
