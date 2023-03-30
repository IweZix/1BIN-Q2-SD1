
public class TestEnsembleTableHashing {
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
		System.out.println("**************************************************");
		System.out.println("Programme Test pour la classe EnsembleTableHashing");
		System.out.println("**************************************************");
		Ensemble<Entier> ensemble;
		ensemble = new EnsembleTableHashing<Entier>(3);
		//Pour le debug, si necessaire, pensez a afficher l'ensemble!
		//System.out.println(e.toString());
		assertEquals("estVide() ensemble vide", true, ensemble.estVide());
		assertEquals("cardinal ensemble vide ko", 0, ensemble.taille());
		assertEquals("ajout de 1 dans l'ensemble vide booleen ko", true, ensemble.ajouter(new Entier(1)));
		assertEquals("apres ajout 1 dans ensemble vide cardinal ko", 1, ensemble.taille());
		assertEquals("ajout de 2 dans l'ensemble {1) booleen ko", true, ensemble.ajouter(new Entier(2)));
		assertEquals("apres ajout 2 dans ensemble {1) cardinal ko", 2, ensemble.taille());
		assertEquals("ajout de 5 dans l'ensemble {1,2) booleen ko", true, ensemble.ajouter(new Entier(5)));
		assertEquals("apres ajout 5 dans ensemble {1,2) cardinal ko", 3, ensemble.taille());
		assertEquals("ajout de 2 dans l'ensemble {1,2,5) booleen ko", false, ensemble.ajouter(new Entier(2)));
		assertEquals("apres ajout 2 dans ensemble {1,2,5) cardinal ko", 3, ensemble.taille());
		assertEquals("estVide() ensemble {1,2,5)", false, ensemble.estVide());
		assertEquals("ajout de 11 dans l'ensemble {1,2,5) booleen ko", true, ensemble.ajouter(new Entier(11)));
		assertEquals("apres ajout 11 dans ensemble {1,2,5) cardinal ko", 4, ensemble.taille());
		assertEquals("ajout de 14 dans l'ensemble {1,2,5,11) booleen ko", true, ensemble.ajouter(new Entier(14)));
		assertEquals("apres ajout 14 dans ensemble {1,2,5,11) cardinal ko", 5, ensemble.taille());
		assertEquals("1 appartient a l'ensemble {1,2,5,11,14} ? ", true, ensemble.contient(new Entier(1)));
		assertEquals("2 appartient a l'ensemble {1,2,5,11,14} ? ", true, ensemble.contient(new Entier(2)));
		assertEquals("5 appartient a l'ensemble {1,2,5,11,14} ? ", true, ensemble.contient(new Entier(5)));
		assertEquals("11 appartient a l'ensemble {1,2,5,11,14} ? ", true, ensemble.contient(new Entier(11)));
		assertEquals("14 appartient a l'ensemble {1,2,5,11,14} ? ", true, ensemble.contient(new Entier(14)));
		assertEquals("4 appartient a l'ensemble {1,2,5,11,14} ? ", false, ensemble.contient(new Entier(4)));
		assertEquals("suppression de 1 dans l'ensemble {1,2,5) booleen ko", true, ensemble.enlever(new Entier(1)));
		assertEquals("apres suppression 1 dans ensemble {1,2,5,11,14) cardinal ko", 4, ensemble.taille());
		assertEquals("apres suppression 1 dans ensemble {1,2,5,11,14) contient 1 ko", false, ensemble.contient(new Entier(1)));
		assertEquals("suppression de 4 dans l'ensemble {2,5,11,14) booleen ko", false, ensemble.enlever(new Entier(4)));
		assertEquals("apres suppression 4 dans ensemble {2,5,11,14) cardinal ko", 4, ensemble.taille());
		assertEquals("suppression de 11 dans l'ensemble {2,5,11,14) booleen ko", true, ensemble.enlever(new Entier(11)));
		assertEquals("apres suppression 11 dans ensemble {2,5,11,14) cardinal ko", 3, ensemble.taille());
		assertEquals("suppression de 14 dans l'ensemble {1,2,5) booleen ko", true, ensemble.enlever(new Entier(14)));
		assertEquals("apres suppression 14 dans ensemble {2,5,14) cardinal ko", 2, ensemble.taille());
		assertEquals("suppression de 5 dans l'ensemble {2,5) booleen ko", true, ensemble.enlever(new Entier(5)));
		assertEquals("apres suppression 5 dans ensemble {2,5) cardinal ko", 1, ensemble.taille());
		assertEquals("suppression de 2 dans l'ensemble {2,5) booleen ko", true, ensemble.enlever(new Entier(2)));
		assertEquals("apres suppression 2 dans ensemble {2) cardinal ko", 0, ensemble.taille());
		System.out.println("Tous les tests ont reussi!");
	}
}
