public class TestConsigneLIFO{

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

		ConsigneLIFO consigne = new ConsigneLIFO(3);
		
		System.out.println("Les tests se font avec une ConsigneLIFO comportant 3 casiers");
		System.out.println();
		
		try{
		System.out.println("test1 : au depart les 3 casiers sont libres");
		assertEquals("resteUnCasierLibre() KO test1 ko", true, consigne.resteUnCasierLibre()); 
		}catch (Exception e){
			System.out.println("test1 resteUnCasierLibre() KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test1 ok");
		System.out.println();
		
		
		// test2 - test3 - test4
		// attribution de 3 casiers avec mdp "mdp"
		// les numeros attribues sont 0, 1 et 2 dans n'importe quel ordre
		// L'ordre des numeros depend du constructeur
	
		boolean[] occupations = new boolean[3]; 
		int numero = -1;
		System.out.println("test2 : attribution d'un premier casier - mdp");
		try{
			numero = consigne.attribuerCasierLibre("mdp");
		}catch (Exception e){
			System.out.println("test2 attribuerCasierLibre() KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}		
		// Le constructeur a-t-il bien rempli la pile?		
		if(numero != 0 && numero != 1 && numero != 2 ){
			System.out.println("test 2 ko");
			System.out.println("Attention, les numeros des casiers sont 0, 1 et 2!");
			System.out.println("Au depart, tous ces casiers sont libres.");
			System.out.println("La methode attribuerCasierLibre() a renvoye le numero "+numero);
			System.out.println("Le constructeur a-t-il bien rempli la pile?");
			System.exit(0);
		}
		try{
		assertEquals("apres 1 attribution, il reste 2 casiers libres - resteUnCasierLibre() KO test2 ko", true, consigne.resteUnCasierLibre());
		}catch (Exception e){
			System.out.println("test2 resteUnCasierLibre() KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		occupations[numero]=true;
		System.out.println("test2 ok : attribution casier - mdp --> "+numero);
		System.out.println();
		
		
		System.out.println("test3 : attribution d'un deuxieme casier - mdp");
		try{
			numero = consigne.attribuerCasierLibre("mdp");
		}catch (Exception e){
			System.out.println("test3 attribuerCasierLibre() KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}		
		// Le constructeur a-t-il bien rempli la pile?		
		if(numero != 0 && numero != 1 && numero != 2 ){
			System.out.println("test 3 ko");
			System.out.println("Attention, les numeros des casiers sont 0, 1 et 2!");
			System.out.println("La methode attribuerCasierLibre() a renvoye le numero "+numero);
			System.out.println("Le constructeur a-t-il bien rempli la pile?");
			System.exit(0);
		}
		if(occupations[numero]){
			System.out.println("test 3 ko");
			System.out.println("La methode attribuerCasierLibre() a renvoye le numero "+numero);
			System.out.println("Attention, ce numero correspond a un casier occupe");
			System.exit(0);
		}
		try{
			assertEquals("apres 2 attributions, il reste 1 casier libre - resteUnCasierLibre() KO test2 ko", true, consigne.resteUnCasierLibre());
		}catch (Exception e){
			System.out.println("test3 resteUnCasierLibre() KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		occupations[numero]=true;
		System.out.println("test3 ok : attribution casier - mdp --> "+numero);
		System.out.println();
		
		
		System.out.println("test4 : attribution d'un troisieme casier - mdp");
		try{
			numero = consigne.attribuerCasierLibre("mdp");
		}catch (Exception e){
			System.out.println("test4 attribuerCasierLibre() KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}		
		// Le constructeur a-t-il bien rempli la pile?		
		if(numero != 0 && numero != 1 && numero != 2 ){
			System.out.println("test 4 ko");
			System.out.println("Attention, les numeros des casiers sont 0, 1 et 2!");
			System.out.println("La methode attribuerCasierLibre() a renvoye le numero "+numero);
			System.out.println("Le constructeur a-t-il bien rempli la pile?");
			System.exit(0);
		}
		if(occupations[numero]){
			System.out.println("test 4 ko");
			System.out.println("La methode attribuerCasierLibre() a renvoye le numero "+numero);
			System.out.println("Attention, ce numero correspond a un casier occupe");
			System.exit(0);
		}
		try{
			assertEquals("apres 3 attributions, tous les casiers sont occupes - resteUnCasierLibre() KO test4 ko", false, consigne.resteUnCasierLibre());
		}catch (Exception e){
			System.out.println("test4 resteUnCasierLibre() KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test4 ok : attribution casier - mdp --> "+numero);
		System.out.println();
		
		
		System.out.println("test5 : attribution casier alors que tous les casiers sont occupes - mdp");	
		try{
			assertEquals("Il n'y a plus de casier de libre. numero casier test5 ko", -1, consigne.attribuerCasierLibre("mdp"));
		}catch (Exception e){
			System.out.println("test5 attribuerCasierLibre() KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test5 ok");
		System.out.println();
		
	
		
		// test6 - test7 - test8 
		// liberation des 3 casiers occupes avec bon mot de passe
		// D'abord le 2, puis le 0, puis le 1
		// la pile : base 2 0 1 sommet
		
		System.out.println("test6 : liberation casier 2 - mdp");
		try{
			assertEquals("test6 ko", true,consigne.libererCasier(2, "mdp"));
		}catch (Exception e){
			System.out.println("test6 libererCasier() KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		try{
		assertEquals("Apres liberation, un casier s'est libere! resteUnCasierLibre() KO test6 ko", true, consigne.resteUnCasierLibre());
		}catch (Exception e){
			System.out.println("test6 resteUnCasierLibre() KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}		
		System.out.println("test6 ok");
		System.out.println();
		
		
		System.out.println("test7 : liberation casier 0 - mdp");
		try{
			assertEquals("test7 ko", true,consigne.libererCasier(0, "mdp"));
		}catch (Exception e){
			System.out.println("test7 libererCasier() KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test7 ok");
		System.out.println();
		
	
		
		System.out.println("test8 : liberation casier 1 - mdp");
		try{
			assertEquals("test8 ko", true,consigne.libererCasier(1, "mdp"));
		}catch (Exception e){
			System.out.println("test8 libererCasier() KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test8 ok");
		System.out.println();
	
		
		System.out.println("Tous les casiers sont a nouveau libre");
		System.out.println();
		System.out.println("test9 : liberation du casier 2 - mdp");
		try{
			assertEquals("on ne peut liberer un casier qui est libre : test9 ko", false,consigne.libererCasier(2, "mdp"));
		}catch (Exception e){
			System.out.println("test9 libererCasier() KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test9 ok");
		System.out.println();


		// tous les casiers sont libres
		// la pile : base 2 0 1 sommet
		// test10 - test11 - test12 
		// attribution de 3 casiers
		// on verifie si les attributions des 3 casiers suivent l'ordre 1 puis 0 puis 2

		System.out.println("test10 : attribution casier - mdp1");
		try{
			numero = consigne.attribuerCasierLibre("mdp1");
			if(numero==1){
			System.out.println("test10 : attribution casier - mdp1 --> 1");
			}else{
				System.out.println("test 10 attribuerCasierLibre() ko");
				System.out.println("Avez-vous toujours bien rempli la pile et uniquement dans le cas ou la liberation est effective?");
				System.exit(0);
			}
		}catch (Exception e){
			System.out.println("test10 attribuerCasierLibre() KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		try{
			assertEquals("Suite a cette attribution, il reste 2 casiers libres! resteUnCasierLibre() KO test 10 ko", true, consigne.resteUnCasierLibre()); 
		}catch (Exception e){
			System.out.println("test10 resteUnCasierLibre() KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test10 ok");
		System.out.println();


		System.out.println("test11 : attribution casier - mdp0");
		try{
			assertEquals("mauvaise utilisation d'une pile pour attribution : test11 ko", 0, consigne.attribuerCasierLibre("mdp0"));
			System.out.println("test11 : attribution casier - mdp0 --> 0");
		}catch (Exception e){
			System.out.println("test11 attribuerCasierLibre() KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		try{
			assertEquals("Suite a cette attribution, il reste 1 casier libre! resteUnCasierLibre() KO test 11 ko", true, consigne.resteUnCasierLibre()); 
		}catch (Exception e){
			System.out.println("test11 resteUnCasierLibre() KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test11 ok");
		System.out.println();


		System.out.println("test12 : attribution casier - mdp2");
		try{
			assertEquals("mauvaise utilisation d'une pile pour attribution : test12 ko", 2, consigne.attribuerCasierLibre("mdp2"));
			System.out.println("test12 : attribution casier - mdp2 --> 2");
		}catch (Exception e){
			System.out.println("test12 attribuerCasierLibre() KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		try{
			assertEquals("Suite a cette attribution, il ne reste plus de casier de libre! resteUnCasierLibre() KO test 12 ko", false, consigne.resteUnCasierLibre()); 
		}catch (Exception e){
			System.out.println("test12 resteUnCasierLibre() KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test12 ok");
		System.out.println();


		System.out.println("test13 : attribution casier alors que tous les casiers sont occupes - mdp");	
		try{
			assertEquals("Il n'y a plus de casier de libre. numero casier test13 ko", -1, consigne.attribuerCasierLibre("mdp"));
		}catch (Exception e){
			System.out.println("test13 attribuerCasierLibre() KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test13 ok");
		System.out.println();
		
		
		System.out.println("test14 : liberation casier 1 - mdp1");
		try{
			assertEquals("test14 ko", true,consigne.libererCasier(1, "mdp1"));
		}catch (Exception e){
			System.out.println("test14 libererCasier() KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test14 ok");
		System.out.println();
		System.out.println();

		System.out.println("A ce stade, les casiers 0 (mdp0) et 2 (mdp2) sont occupes");
		System.out.println();
		
		// Tests cas particuliers

		// mot de passe incorrect mdpX ne peut liberer le casier 0
		System.out.println("test15 : liberation casier 0 - mdpX");
		try{
			assertEquals("test15 ko mauvais mot de passe", false,consigne.libererCasier(0, "mdpX"));
		}catch (Exception e){
			System.out.println("test15 libererCasier() KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test15 ok");
		System.out.println();
	
		


		// Il n'existe pas de casier -1
		System.out.println("test16 : liberation casier -1 - mdp");
		try{
			assertEquals("test16 ko le casier -1 n'existe pas", false,consigne.libererCasier(-1, "mdp"));
		}catch (Exception e){
			System.out.println("test16 libererCasier() KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test16 ok");
		System.out.println();


		// Il n'existe pas de casier 3
		System.out.println("test17 : liberation casier 3 - mdp");
		try{
			assertEquals("test17 ko le casier 3 n'existe pas", false,consigne.libererCasier(3, "mdp"));
		}catch (Exception e){
			System.out.println("test17 libererCasier() KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test17 ok");
		System.out.println();

		// Le mot de passe ne peut etre null
		System.out.println("test18 : liberation casier 0 - mot de passe = null");
		try{
			consigne.libererCasier(0, null);
			System.out.println("test18 libererCasier() KO : il fallait lancer une exception de type IllegalArgumentException");
			System.exit(0);

		}catch (IllegalArgumentException e){
			System.out.println("test18 ok");
		}	
		catch (Exception e){
			System.out.println("test18 libererCasier() KO : il fallait lancer une exception de type IllegalArgumentException");
			e.printStackTrace();
			System.exit(0);
		}

		System.out.println();


		// Le mot de passe ne peut etre une chaine vide
		System.out.println("test19 : liberation casier 0 - mot de passe = chaine vide");
		try{
			consigne.libererCasier(0, "");
			System.out.println("test19 libererCasier() KO : il fallait lancer une exception de type IllegalArgumentException");
			System.exit(0);

		}catch (IllegalArgumentException e){
			System.out.println("test19 ok");
		}	
		catch (Exception e){
			System.out.println("test19 libererCasier() KO : il fallait lancer une exception de type IllegalArgumentException");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println();
		
		
		// Le mot de passe ne peut etre une chaine vide
		System.out.println("test20 : liberation casier 2 - mot de passe = chaine vide");
		try{
			consigne.libererCasier(2, "");
			System.out.println("test20 libererCasier() KO : il fallait lancer une exception de type IllegalArgumentException");
			System.exit(0);

		}catch (IllegalArgumentException e){
			System.out.println("test20 ok");
		}	
		catch (Exception e){
			System.out.println("test20 libererCasier() KO : il fallait lancer une exception de type IllegalArgumentException");
			e.printStackTrace();
			System.exit(0);
		}

		System.out.println();

		// Le mot de passe ne peut etre null
		System.out.println("test21 : attribution casier - mot de passe = null");
		try{
			consigne.attribuerCasierLibre(null);
			System.out.println("test21 attribuerCasierLibre() KO : il fallait lancer une exception de type IllegalArgumentException");
			System.exit(0);

		}catch (IllegalArgumentException e){
			System.out.println("test21 ok");
		}	
		catch (Exception e){
			System.out.println("test21 attribuerCasierLibre() KO : il fallait lancer une exception de type IllegalArgumentException");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println();

		// Le mot de passe ne peut etre une chaine vide
		System.out.println("test22 : attribution casier - mot de passe = chaine vide");
		try{
			consigne.attribuerCasierLibre("");
			System.out.println("test22 attribuerCasierLibre() KO : il fallait lancer une exception de type IllegalArgumentException");
			System.exit(0);

		}catch (IllegalArgumentException e){
			System.out.println("test22 ok");
		}	
		catch (Exception e){
			System.out.println("test22 attribuerCasierLibre() KO : il fallait lancer une exception de type IllegalArgumentException");
			e.printStackTrace();
			System.exit(0);
		}

		System.out.println();

		// Le nombre de casiers doit etre > 0
		System.out.println("test22 : ConsigneLIFO de gare avec 0 casier");
		try{
			consigne = new ConsigneLIFO(0);
			System.out.println("test22 constructeur 0 ConsigneLIFO KO : il fallait lancer une exception de type IllegalArgumentException");
			System.exit(0);

		}catch (IllegalArgumentException e){
			System.out.println("test22 ok");
		}	
		catch (Exception e){
			System.out.println("test22 constructeur 0 ConsigneLIFO KO : il fallait lancer une exception de type IllegalArgumentException");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println();
		
		// Le nombre de casiers doit etre > 0
		System.out.println("test23 : ConsigneLIFO de gare avec -1 casiers");
		try{
			consigne = new ConsigneLIFO(-1);
			System.out.println("test23 constructeur -1 ConsigneLIFO KO : il fallait lancer une exception de type IllegalArgumentException");
			System.exit(0);

		}catch (IllegalArgumentException e){
			System.out.println("test23 ok");
		}	
		catch (Exception e){
			System.out.println("test23 constructeur -1 ConsigneLIFO KO : il fallait lancer une exception de type IllegalArgumentException");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println();
		
		// Le nombre de casiers doit etre > 0
		System.out.println("test24 : ConsigneLIFO de gare avec 0 casier");
		try{
			consigne = new ConsigneLIFO(0);
			System.out.println("test24 constructeur 0 ConsigneLIFO KO : il fallait lancer une exception de type IllegalArgumentException");
			System.exit(0);

		}catch (IllegalArgumentException e){
			System.out.println("test24 ok");
		}	
		catch (Exception e){
			System.out.println("test24 constructeur 0 ConsigneLIFO KO : il fallait lancer une exception de type IllegalArgumentException");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println();

		System.out.println("Tous les tests ont reussi");

	}
	
}

