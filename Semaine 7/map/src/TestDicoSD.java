public class TestDicoSD {

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
	public static void main(String[] args) {
		DicoSD dico = new DicoSD();
		
		// test1 : dico vide
		assertEquals("Test1 ko : le dico est vide : pile present?",false, dico.contient("pile"));
		assertEquals("Test1 ko : le dico est vide : aucune url pour pile : ", "[]", dico.lesURLs("pile"));
		assertEquals("Test1 ko : le dico est vide : suppression pile - urlPile : ", false, dico.supprimer("pile","urlPile"));
		
		// test2 : ajout pile - urlPile1 dans un dico vide
		assertEquals("Test2 ko : le dico au depart est vide, on ajoute pile - urlPile1   ajout? ",true,dico.ajouter("pile", "urlPile1"));
		assertEquals("Test2 ko : le dico au depart est vide, on ajoute pile : urlPile1  contenu pile ? ", "[urlPile1]", dico.lesURLs("pile"));
		assertEquals("Test2 ko : le dico au depart est vide, on vient d'ajouter pile : pile present? ", true, dico.contient("pile"));
		assertEquals("Test2 ko : le dico au depart est vide, on vient d'ajouter pile : b-arbre present? ", false, dico.contient("b-arbre"));
		
		// test3 : ajout pile - urlPile2 dans le dico qui contient pile - urlPile1, 
		assertEquals("Test3 ko : le dico contient pile - urlPile1, on ajoute pile - urlPile2   ajout? ",true,dico.ajouter("pile", "urlPile2"));
		assertEquals("Test3 ko : le dico contient pile - urlPile1, on ajoute pile - urlPile2   contenu pile ? ", "[urlPile1, urlPile2]", dico.lesURLs("pile"));
		
		// test4 : ajout pile - urlPile2 dans le dico qui contient pile - urlPile1 et pile - urlPile2
		assertEquals("Test4 ko : le dico contient pile - urlPile1 et urlPile2, on ajoute pile - urlPile2  ajout?",false,dico.ajouter("pile", "urlPile2"));
		assertEquals("Test4 ko : le dico contient pile - urlPile1 et urlPile2, on ajoute pile - urlPile2  contenu pile ? ","[urlPile1, urlPile2]", dico.lesURLs("pile"));
		
		// test5 : ajout pile - urlPile1 dans le dico qui contient pile - urlPile1 et pile - urlPile2
		assertEquals("Test5 ko : le dico contient pile - urlPile1 et urlPile2, on ajoute pile - urlPile1  ajout? " ,false,dico.ajouter("pile", "urlPile1"));
		assertEquals("Test5 ko : le dico contient pile - urlPile1 et urlPile2, on ajoute pile - urlPile1  contenu pile? ","[urlPile1, urlPile2]", dico.lesURLs("pile"));
		
		// test6 : ajout ensemble - urlEnsemble1 dans le dico qui contient pile - urlPile1 et pile - urlPile2
		assertEquals("Test6 ko : le dico contient pile - urlPile1 et urlPile2, on ajoute ensemble - urlEnsemble1  ajout? ",true, dico.ajouter("ensemble","urlEnsemble1"));
		assertEquals("Test6 ko : le dico contient pile - urlPile1 et urlPile2, on ajoute ensemble - urlEnsemble1  contenu ensemble? ","[urlEnsemble1]", dico.lesURLs("ensemble"));
		
		// test7 : supprime pile- urlPile1 dans le dico qui contient pile - urlPile1, pile - urlPile2, ensemble - urlEnsemble1
		assertEquals("Test7 ko : le dico contient pile - urlPile1 et urlPile2 ainsi que ensemble - urlEnsemble1, on supprime pile - urlPile1  suppression? ",true, dico.supprimer("pile", "urlPile1"));
		assertEquals("Test7 ko : le dico contient pile - urlPile1 et urlPile2 ainsi que ensemble - urlEnsemble1, on supprime pile - urlPile1  contenu? ","[urlPile2]", dico.lesURLs("pile"));
		assertEquals("Test7 ko : le dico contient pile - urlPile1 et urlPile2 ainsi que ensemble - urlEnsemble1, on supprime pile - urlPile1  pile present? ",true, dico.contient("pile"));

		// test8 : supprime pile - urlPile2 dans le dico qui contient pile - urlPile2, ensemble - urlEnsemble1
		assertEquals("Test8 ko : le dico contient pile - urlPile2 ainsi que ensemble - urlEnsemble1, on supprime pile - urlPile2  suppression? ",true, dico.supprimer("pile", "urlPile2"));
		assertEquals("Test8 ko : le dico contient pile - urlPile2 ainsi que ensemble - urlEnsemble1, on supprime pile - urlPile2  contenu? ","[]", dico.lesURLs("pile"));
		assertEquals("Test8 ko : le dico contient pile - urlPile2 ainsi que ensemble - urlEnsemble1, on supprime pile - urlPile2  pile present? ",false, dico.contient("pile"));

		// test9 : ajout pile - urlQcq dans le dico qui contient ensemble - urlEnsemble1
		assertEquals("Test9 ko : le dico contient ensemble - urlEnsemble1, on ajoute pile - urlQcq  ajout? " ,true,dico.ajouter("pile", "urlQcq"));
		assertEquals("Test9 ko : le dico contient ensemble - urlEnsemble1, on ajoute pile - urlQcq contenu pile? ","[urlQcq]", dico.lesURLs("pile"));

		// test10 : ajout ensemble - urlQcq dans le dico qui contient pile - urlQcq, ensemble - urlEnsemble1
		assertEquals("Test10 ko : le dico contient ensemble - urlEnsemble1 ainsi que pile - urlQcq, on ajoute ensemble - urlQcq  ajout? " ,true,dico.ajouter("ensemble", "urlQcq"));
		assertEquals("Test10 ko : le dico contient ensemble - urlEnsemble1 ainsi que pile - urlQcq, on ajoute ensemble - urlQcq contenu pile? ","[urlQcq]", dico.lesURLs("pile"));
		assertEquals("Test10 ko : le dico contient ensemble - urlEnsemble1 ainsi que pile - urlQcq, on ajoute ensemble - urlQcq contenu ensemble? ","[urlEnsemble1, urlQcq]", dico.lesURLs("ensemble"));

		System.out.println("Le scenario de tests propose a reussi!");
	}

}
