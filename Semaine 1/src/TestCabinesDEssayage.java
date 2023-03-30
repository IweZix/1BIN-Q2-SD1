
public class TestCabinesDEssayage {
	
	/**
	 * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
	 * @param messageErreur message a afficher en cas de probleme
	 * @param attendu la valeur qu'on s'attendait a recevoir
	 * @param recu la valeur qu'on a reçu en realite
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
		System.out.println("Les tests suivent un scenario.");
		System.out.println("En cas de probleme, le numero du test realise et une breve explication seront affiches.");
		System.out.println("Le magasin compte 3 cabines d'essayage. Elles sont toutes libres au depart");
		System.out.println("Pour plus d'informations, allez voir les commentaires du test dans les sources!");
		System.out.println();
		CabinesDEssayage c = new CabinesDEssayage(3);
		int numero1 = -1, numero2 = -1, numero3 = -1, numero4 = -1;
		
		//test 1 : toutes les cabines sont libres
		try{
		assertEquals("test1 ko : c.nombreCabinesLibres() : nombre cabines libres ko", 3, c.nombreCabinesLibres());
		} catch (Exception e){
			System.out.println("test1 ko : c.nombreCabinesLibres() : il ne fallait pas d'exception");
			e.printStackTrace();
			System.exit(0);
		}
		
		// test 2 : premiere attribution
		// le numero de cabine attribue doit etre 1, 2 ou 3
		// Apres attribution, il doit rester 2 cabines de libre
		try{
		numero1 = c.attribuerCabineLibre();
		boolean test2 = numero1 >= 1 && numero1 <= 3;
		assertEquals("test2 ko : c.attribuerCabineLibre() : numero cabine : 1, 2 ou 3", true, test2);
		assertEquals("test2 ko : apres 1 attribution : nombre cabines libres ko", 2, c.nombreCabinesLibres());
		} catch (Exception e){
			System.out.println("test2 ko : c.attribuerCabineLibre() : il ne fallait pas d'exception");
			e.printStackTrace();
			System.exit(0);
		}
		
		// test 3 : deuxieme attribution
		// le numero de cabine attribue doit etre 1, 2 ou 3, mais pas le numero de cabine attribue a l'etape precedente
		// Apres attribution, il doit rester 1 cabine de libre
		try{
		numero2 = c.attribuerCabineLibre();
		boolean test3 =  numero2 >= 1 && numero2 <= 3 && numero2 != numero1 ;
		assertEquals("test3 ko : c.attribuerCabineLibre() : numero cabine : 1, 2 ou 3 est libre", true, test3);
		assertEquals("test3 ko : apres 2 attributions : nombre cabines libres ko", 1, c.nombreCabinesLibres());
		} catch (Exception e){
			System.out.println("test3 ko : c.attribuerCabineLibre() : il ne fallait pas d'exception");
			e.printStackTrace();
			System.exit(0);
		}
		
		// test 4 : troisieme attribution
		// le numero de cabine attribue doit etre 1, 2 ou 3, mais pas le numero d'une cabine deja attribuee
		// Apres attribution, il n'y a plus de cabine de libre
		try{
			numero3 = c.attribuerCabineLibre();
			boolean test4 =  numero3 >= 1 && numero3 <= 3 && numero3 != numero1 && numero3 != numero2;
			assertEquals("test4 ko : : c.attribuerCabineLibre() : numero cabine : 1, 2 ou 3 est libre", true, test4);
			assertEquals("test4 ko : apres 3 attributions : nombre cabines libres ko", 0, c.nombreCabinesLibres());
		} catch (Exception e){
			System.out.println("test4 ko :  c.attribuerCabineLibre() : il ne fallait pas d'exception");
			e.printStackTrace();
			System.exit(0);
		}
		
		// test 5 : 3 cabines sont occupees, 4eme attribution : impossible!!!
		try{
			
			assertEquals("test5 ko : plus de cabine libre", -1, c.attribuerCabineLibre());
			assertEquals("test5 ko : nombre cabines libres ko", 0, c.nombreCabinesLibres());
		} catch (Exception e){
			System.out.println("test5 ko :  c.attribuerCabineLibre() : il ne fallait pas d'exception");
			e.printStackTrace();
			System.exit(0);
		}
		
		// test 6 : Avant cette etape, toutes les cabines sont occupees, on libere la cabine 1
		// Le numero de cabine existe, la liberation doit reussir.
		// Le nombre de cabine libre doit etre 1
		try{
			c.libererCabine(1);
			assertEquals("test6 ko : la cabine 1 a ete liberee : nombre cabines libres ko", 1, c.nombreCabinesLibres());
		} catch (Exception e){
			System.out.println("test6 ko : c.libererCabine(1) : il ne fallait pas d'exception");
			e.printStackTrace();
			System.exit(0);
		}
		
		// test 7 : A l'etape predente, on a libere la cabine 1
		// on ne peut pas liberer une cabine qui n'est pas occupee --> illegalStateException!
		// Le nombre de cabine libre doit etre 1
		try{
			c.libererCabine(1);
			System.out.println("test7 ko : c.libererCabine(1) : il fallait une exception de type IllegalStateException");
			System.exit(0);
		} catch (IllegalStateException e){
			assertEquals("test6 ko : nombre cabines libres ko", 1, c.nombreCabinesLibres());
		}catch (Exception e){
			System.out.println("test7 ko : c.libererCabine(1) : il fallait une exception de type IllegalStateException");
			e.printStackTrace();
			System.exit(0);
		}
		
		// test 8 : La cabine est la seule cabine libre
		// Cette cabine peut etre reattribuee si elle a bien ete liberee
		// apres liberation, le nombre de cabines libres est de nouveau 0
		try{
			assertEquals("test8 ko : la cabine 1 est la seule cabine de libre", 1, c.attribuerCabineLibre());
			assertEquals("test8 ko : nombre cabines libres ko", 0, c.nombreCabinesLibres());
		} catch (Exception e){
			System.out.println("test7 ko : c.attribuerCabineLibre() : il ne fallait pas d'exception");
			e.printStackTrace();
			System.exit(0);
		}
			
			
		// test 9 : mauvais numero de cabine (-1) --> IllegalArgumentException
		try{
			c.libererCabine(-1);
			System.out.println("test9 ko : c.libererCabine(-1) : pas de cabine -1 : il fallait une exception");
			System.exit(0);
		} catch (IllegalArgumentException e){		
		}
		catch (Exception e){	
			System.out.println("test9 ko : c.libererCabine(-1) : pas de cabine -1 : il fallait une exception");
			e.printStackTrace();
			System.exit(0);
		}

		
		// test 10 : mauvais numero de cabine (4) --> IllegalArgumentException
		try{
			c.libererCabine(4);
			System.out.println("test10 ko : c.libererCabine(-1) : pas de cabine 4 : il fallait une exception");
			System.exit(0);
		} catch (IllegalArgumentException e){		
		}
		catch (Exception e){	
			System.out.println("test10 ko : c.libererCabine(-1) : pas de cabine 4 : il fallait une exception");
			e.printStackTrace();
			System.exit(0);
		}
	
		// test 11 : mauvais numero de cabine (0) --> IllegalArgumentException
		try{
			c.libererCabine(0);
			System.out.println("test11 ko : c.libererCabine(0) : pas de cabine 0 : il fallait une exception");
			System.exit(0);
		} catch (IllegalArgumentException e){		
		}
		catch (Exception e){	
			System.out.println("test11 ko : c.libererCabine(0) : pas de cabine 0 : il fallait une exception");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("Tous les tests ont reussi!");
	
	}
	
}
