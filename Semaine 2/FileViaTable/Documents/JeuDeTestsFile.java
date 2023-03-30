
public class JeuDeTestsFile {
	
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
						
		}
	}
	
	public static void main(String[] args) {
		
		FileImplChainee<Character> file = new FileImplChainee<Character>();
		
		
		// test 1
		file.enfile('a');
		assertEquals("test 1 ko", 1, file.taille());
		assertEquals("test 1 ko", " a", file.toString());
		
		//test 2
		file.enfile('b');
		assertEquals("test 2 ko", 2, file.taille());
		assertEquals("test 2 ko", " a b", file.toString());
		
		//test 3
		char p = file.premier();
		assertEquals("test 3 ko", 'a', p);
		assertEquals("test 3 ko", 2, file.taille());
		assertEquals("test 3 ko", " a b", file.toString());
		
		//test 4
		p=file.defile();
		assertEquals("test 4 ko", 'a', p);
		assertEquals("test 4 ko", 1, file.taille());
		assertEquals("test 4 ko", " b", file.toString());
		
		//test 5
		p=file.defile();
		assertEquals("test 5 ko", 'b', p);
		assertEquals("test 5 ko", 0, file.taille());
		assertEquals("test 5 ko", "", file.toString());
		
		//test 6
		try{
			file.defile();
			System.out.println("test 6 ko");
			return;
		}catch (FileVideException ex){
		}
		
		//test 7
		try{
			file.premier();
			System.out.println("test 7 ko");
			System.exit(0);
		}catch (FileVideException ex){
		}
		
		//test 8
		file.enfile('c');
		assertEquals("test 8 ko", 1, file.taille());
		assertEquals("test 8 ko", " c", file.toString());	
		
		System.out.println("tous les tests ont reussi!");
	}

}
