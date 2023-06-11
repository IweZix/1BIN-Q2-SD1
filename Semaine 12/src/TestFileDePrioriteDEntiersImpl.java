


public class TestFileDePrioriteDEntiersImpl {
	
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
		
		System.out.println("********************************************************");
		System.out.println("Programme Test pour la classe FileDePrioriteDEntiersImpl");
		System.out.println("********************************************************");
		System.out.println("Le scenario de cette premiere phase de tests correspond a l'ex A1");
	//	System.out.println("La capacite initiale de la table est de 10");
		
		System.out.println("D'abord les insertions!");
		FileDePrioriteDEntiersImpl f = new FileDePrioriteDEntiersImpl(10);
		f.insere(5);
		assertEquals("insere 5 ko", " 5", f.toString());
		
		f.insere(9);
		assertEquals("insere 9 ko", " 9 5", f.toString());
	
		f.insere(3);
		assertEquals("insere 3 ko", " 9 5 3", f.toString());
		
		f.insere(12);
		assertEquals("insere 12 ko", " 12 9 3 5", f.toString());
	 
		f.insere(11);
		assertEquals("insere 11 ko", " 12 11 3 5 9", f.toString());
		
		f.insere(15);
		assertEquals("insere 15 ko", " 15 11 12 5 9 3", f.toString());
	
		f.insere(10);
		assertEquals("insere 10 ko", " 15 11 12 5 9 3 10", f.toString());
		
		f.insere(4);
		assertEquals("insere 4 ko", " 15 11 12 5 9 3 10 4", f.toString());
		
		System.out.println("Toutes les insertions de l'ex A1 ont reussi.");
		
		System.out.println();
		System.out.println("Ensuite les suppressions!");
		assertEquals("supprimeMax ko : max :",15, f.supprimeMax());
		assertEquals("supprimeMax ko: contenu :", " 12 11 10 5 9 3 4", f.toString());
		assertEquals("supprimeMax ko : max :",12, f.supprimeMax());
		assertEquals("supprimeMax ko: contenu :", " 11 9 10 5 4 3", f.toString());
		
		System.out.println("Toutes les suppressions de l'ex A1 ont reussi.");
		
		/*
		System.out.println();
		System.out.println();
		
		System.out.println("Le scenario de cette deuxieme phase de tests correspond a l'ex A1");
		System.out.println("La capacite initiale de la table est de 2");
		
		System.out.println("D'abord les insertions!");
		f = new FileDePrioriteDEntiersImpl(2);
		f.insere(5);
		assertEquals("insere 5 ko", " 5", f.toString());
		
		f.insere(9);
		assertEquals("insere 9 ko", " 9 5", f.toString());
	
		f.insere(3);
		assertEquals("insere 3 ko", " 9 5 3", f.toString());
		
		f.insere(12);
		assertEquals("insere 12 ko", " 12 9 3 5", f.toString());
	 
		f.insere(11);
		assertEquals("insere 11 ko", " 12 11 3 5 9", f.toString());
		
		f.insere(15);
		assertEquals("insere 15 ko", " 15 11 12 5 9 3", f.toString());
	
		f.insere(10);
		assertEquals("insere 10 ko", " 15 11 12 5 9 3 10", f.toString());
		
		f.insere(4);
		assertEquals("insere 4 ko", " 15 11 12 5 9 3 10 4", f.toString());
		
		System.out.println("Toutes les insertions de l'ex A1 ont reussi.");
		
		System.out.println();
		System.out.println("Ensuite les suppressions!");
		assertEquals("supprimeMax ko : max :",15, f.supprimeMax());
		assertEquals("supprimeMax ko: contenu :", " 12 11 10 5 9 3 4", f.toString());
		assertEquals("supprimeMax ko : max :",12, f.supprimeMax());
		assertEquals("supprimeMax ko: contenu :", " 11 9 10 5 4 3", f.toString());
		
		System.out.println("Toutes les suppressions de l'ex A1 ont reussi.");
		*/
	}	
}
