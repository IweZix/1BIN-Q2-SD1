import java.util.Scanner;

public class TestDequeImplChaineeSS {
	
	private final static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {	

		System.out.println("************************************************");
		System.out.println("Programme Test pour la classe DequeImplChaineeSS");
		System.out.println("************************************************");

		int choix = 0;
		do {
			System.out.println();
			System.out.println("1 -> Tester la methode ajouterEnPremier()");
			System.out.println("2 -> Tester la methode retirerPremier()");
			System.out.println("3 -> Tester la methode ajouterEnDernier()");	
			System.out.println("4 -> Tester la methode retirerDernier()");
			System.out.println("5 -> Tester la methode premier()");	
			System.out.println("6 -> Tester la methode dernier()");
			System.out.println();
			System.out.print("Votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
			case 1:
				testAjouterEnPremier();
				break;
			case 2:
				testRetirerPremier();
				break;
			case 3:				
				testAjouterEnDernier();
				break;
			case 4:				
				testRetirerDernier();
				break;
			case 5:				
				testPremier();
				break;
			case 6:				
				testDernier();
				break;	
			default:
				break;
			}

		} while (choix >= 1 && choix <= 6);
	}
	
	private static void testAjouterEnPremier() {
		System.out.println();
		System.out.println("Tests methode ajouterEnPremier()");
		System.out.println("--------------------------------");
		System.out.print("Test 1 : Deque Vide : ajouterEnPremier(a)");
		DequeImplChaineeSS<String> dVide = new DequeImplChaineeSS<String>();
		try{
			dVide.ajouterEnPremier("a");
			if(dVide.taille()!=1){
				System.out.println();
				System.out.println(" KO : taille obtenue : " + dVide.taille());
				return;
			}
			if(!dVide.toString().equals("a")){
				System.out.println(" KO : contenu (tete --> queue) obtenu : "+ dVide);
				return;
			}
			if(!dVide.parcoursInverse().equals("a")){
				System.out.println(" KO : contenu (queue --> tete) obtenu : "+ dVide.parcoursInverse());
				return;
			}
					
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" : ok");
		
		System.out.print("Test 2 : Deque b c d : ajouterEnPremier(a)");
		String[] tbcd = {"b","c","d"};
		DequeImplChaineeSS<String> dbcd = new DequeImplChaineeSS<String>(tbcd);
		try{
			dbcd.ajouterEnPremier("a");
			if(dbcd.taille()!=4){
				System.out.println();
				System.out.println(" KO : taille obtenue : " + dbcd.taille());
				return;
			}
			if(!dbcd.toString().equals("a b c d")){
				System.out.println(" KO : contenu (tete --> queue) obtenu : "+ dbcd);
				return;
			}
			if(!dbcd.parcoursInverse().equals("d c b a")){
				System.out.println(" KO : contenu (queue --> tete) obtenu : "+ dbcd.parcoursInverse());
				return;
			}
					
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" : ok");
		
		
		System.out.print("Test 3 : Deque c d  : ajouterEnPremier(b) ajouterEnPremier(a)");
		String[] tcd = {"c","d"};
		DequeImplChaineeSS<String> dcd = new DequeImplChaineeSS<String>(tcd);
		try{
			dcd.ajouterEnPremier("b");
			dcd.ajouterEnPremier("a");
			if(dcd.taille()!=4){
				System.out.println();
				System.out.println(" KO : taille obtenue : " + dcd.taille());
				return;
			}
			if(!dcd.toString().equals("a b c d")){
				System.out.println(" KO : contenu (tete --> queue) obtenu : "+ dcd);
				return;
			}
			if(!dcd.parcoursInverse().equals("d c b a")){
				System.out.println(" KO : contenu (queue --> tete) obtenu : "+ dcd.parcoursInverse());
				return;
			}
					
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" : ok");
		
		System.out.println("Tous les tests de la methode ajouterEnPremier() ont reussi!");
		System.out.println();
		
	}

	private static void testRetirerPremier() {
		System.out.println();
		System.out.println("Tests methode retirerPremier()");
		System.out.println("------------------------------");
		System.out.print("Test 1 : DeQueVide ");
		DequeImplChaineeSS<String> dVide = new DequeImplChaineeSS<String>();
		try{
			dVide.retirerPremier();
			System.out.println(" KO, il n'y a pas eu DequeVideException : ");
			return;
					
		}catch (DequeVideException ex){
		}
		catch (Exception ex){
			System.out.println(" KO, il n'y a pas eu DequeVideException : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" : ok");
		
		System.out.print("Test 2 : Deque a b c ");
		String[] tabc = {"a","b","c"};
		DequeImplChaineeSS<String> dabc = new DequeImplChaineeSS<String>(tabc);
		try{
			String s = dabc.retirerPremier();
			if(!s.equals("a")){
				System.out.println(" KO : element renvoye : " + s);
				return;
			}
			if(dabc.taille()!=2){
				System.out.println();
				System.out.println(" KO : taille obtenue : " + dabc.taille());
				return;
			}
			if(!dabc.toString().equals("b c")){
				System.out.println(" KO : contenu (tete --> queue) obtenu : "+ dabc);
				return;
			}
			if(!dabc.parcoursInverse().equals("c b")){
				System.out.println(" KO : contenu (queue --> tete) obtenu : "+ dabc.parcoursInverse());
				return;
			}
					
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" : ok");
		System.out.print("Test 3 : Deque a ");
		String[] ta = {"a"};
		DequeImplChaineeSS<String> da = new DequeImplChaineeSS<String>(ta);
		try{
			String s = da.retirerPremier();
			if(!s.equals("a")){
				System.out.println(" KO : element renvoye : " + s);
				return;
			}
			if(da.taille()!=0){
				System.out.println();
				System.out.println(" KO : taille obtenue : " + dabc.taille());
				return;
			}
			if(!da.toString().equals("")){
				System.out.println(" KO : contenu (tete --> queue) obtenu : "+ da);
				return;
			}
			if(!da.parcoursInverse().equals("")){
				System.out.println(" KO : contenu (queue --> tete) obtenu : "+ da.parcoursInverse());
				return;
			}

		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" : ok");
		System.out.println("Tous les tests de la methode retirerPremier() ont reussi!");
		System.out.println();
		
	}

	private static void testAjouterEnDernier() {
		System.out.println();
		System.out.println("Tests methode ajouterEnDernier()");
		System.out.println("--------------------------------");
		System.out.print("Test 1 : Deque Vide : ajouterEnDernier(a)");
		DequeImplChaineeSS<String> dVide = new DequeImplChaineeSS<String>();
		try{
			dVide.ajouterEnDernier("a");
			if(dVide.taille()!=1){
				System.out.println();
				System.out.println(" KO : taille obtenue : " + dVide.taille());
				return;
			}
			if(!dVide.toString().equals("a")){
				System.out.println(" KO : contenu (tete --> queue) obtenu : "+ dVide);
				return;
			}
			if(!dVide.parcoursInverse().equals("a")){
				System.out.println(" KO : contenu (queue --> tete) obtenu : "+ dVide.parcoursInverse());
				return;
			}
					
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" : ok");
		
		System.out.print("Test 2 : Deque a b c : ajouterEnDernier(d)");
		String[] tabc = {"a","b","c"};
		DequeImplChaineeSS<String> dabc = new DequeImplChaineeSS<String>(tabc);
		try{
			dabc.ajouterEnDernier("d");
			if(dabc.taille()!=4){
				System.out.println();
				System.out.println(" KO : taille obtenue : " + dabc.taille());
				return;
			}
			if(!dabc.toString().equals("a b c d")){
				System.out.println(" KO : contenu (tete --> queue) obtenu : "+ dabc);
				return;
			}
			if(!dabc.parcoursInverse().equals("d c b a")){
				System.out.println(" KO : contenu (queue --> tete) obtenu : "+ dabc.parcoursInverse());
				return;
			}
					
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" : ok");
		
		
		System.out.print("Test 3 : Deque a b  : ajouterEnDernier(c) ajouterEnDernier(d)");
		String[] tab = {"a","b"};
		DequeImplChaineeSS<String> dab = new DequeImplChaineeSS<String>(tab);
		try{
			dab.ajouterEnDernier("c");
			dab.ajouterEnDernier("d");
			if(dab.taille()!=4){
				System.out.println();
				System.out.println(" KO : taille obtenue : " + dab.taille());
				return;
			}
			if(!dab.toString().equals("a b c d")){
				System.out.println(" KO : contenu (tete --> queue) obtenu : "+ dab);
				return;
			}
			if(!dab.parcoursInverse().equals("d c b a")){
				System.out.println(" KO : contenu (queue --> tete) obtenu : "+ dab.parcoursInverse());
				return;
			}
					
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" : ok");
		
		System.out.println("Tous les tests de la methode ajouterEnDernier() ont reussi!");
		System.out.println();
		
	}

	private static void testRetirerDernier() {
		System.out.println();
		System.out.println("Tests methode retirerDernier()");
		System.out.println("------------------------------");
		System.out.print("Test 1 : DeQueVide ");
		DequeImplChaineeSS<String> dVide = new DequeImplChaineeSS<String>();
		try{
			dVide.retirerDernier();
			System.out.println(" KO, il n'y a pas eu DequeVideException : ");
			return;
					
		}catch (DequeVideException ex){
		}
		catch (Exception ex){
			System.out.println(" KO, il n'y a pas eu DequeVideException : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" : ok");
		
		System.out.print("Test 2 : Deque a b c ");
		String[] tabc = {"a","b","c"};
		DequeImplChaineeSS<String> dabc = new DequeImplChaineeSS<String>(tabc);
		try{
			String s = dabc.retirerDernier();
			if(!s.equals("c")){
				System.out.println(" KO : element renvoye : " + s);
				return;
			}
			if(dabc.taille()!=2){
				System.out.println();
				System.out.println(" KO : taille obtenue : " + dabc.taille());
				return;
			}
			if(!dabc.toString().equals("a b")){
				System.out.println(" KO : contenu (tete --> queue) : "+ dabc);
				return;
			}
			if(!dabc.parcoursInverse().equals("b a")){
				System.out.println(" KO : contenu (queue --> tete) obtenu : "+ dabc.parcoursInverse());
				return;
			}
					
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" : ok");

		System.out.print("Test 3 : Deque a ");
		String[] ta = {"a"};
		DequeImplChaineeSS<String> da = new DequeImplChaineeSS<String>(ta);
		try{
			String s = da.retirerDernier();
			if(!s.equals("a")){
				System.out.println(" KO : element renvoye : " + s);
				return;
			}
			if(da.taille()!=0){
				System.out.println();
				System.out.println(" KO : taille obtenue : " + da.taille());
				return;
			}
			if(!da.toString().equals("")){
				System.out.println(" KO : contenu (tete --> queue) : "+ da);
				return;
			}
			if(!da.parcoursInverse().equals("")){
				System.out.println(" KO : contenu (queue --> tete) obtenu : "+ da.parcoursInverse());
				return;
			}

		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" : ok");



		System.out.println("Tous les tests de la methode retirerDernier() ont reussi!");
		System.out.println();
		
	}
	
	private static void testPremier() {
		System.out.println();
		System.out.println("Tests methode premier()");
		System.out.println("-----------------------");
		System.out.print("Test 1 : DequeVide ");
		DequeImplChaineeSS<String> dVide = new DequeImplChaineeSS<String>();
		try{
			dVide.premier();
			System.out.println(" KO, il n'y a pas eu DequeVideException : ");
			return;
					
		}catch (DequeVideException ex){
		}
		catch (Exception ex){
			System.out.println(" KO, il n'y a pas eu DequeVideException : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" : ok");
		
		System.out.print("Test 2 : Deque a b c ");
		String[] tabc = {"a","b","c"};
		DequeImplChaineeSS<String> dabc = new DequeImplChaineeSS<String>(tabc);
		try{
			String s = dabc.premier();
			if(!s.equals("a")){
				System.out.println(" KO : element renvoye : " + s);
				return;
			}
			if(dabc.taille()!=3){
				System.out.println();
				System.out.println(" KO : taille modifiee : " + dabc.taille());
				return;
			}
			if(!dabc.toString().equals("a b c")){
				System.out.println(" KO : contenu (tete --> queue) modifie : "+ dabc);
				return;
			}
			if(!dabc.parcoursInverse().equals("c b a")){
				System.out.println(" KO : contenu (queue --> tete) modifie : "+ dabc.parcoursInverse());
				return;
			}
					
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" : ok");
		System.out.println("Tous les tests de la methode premier() ont reussi!");
		System.out.println();
		
	}

	private static void testDernier() {
		System.out.println();
		System.out.println("Tests methode dernier()");
		System.out.println("-----------------------");
		System.out.print("Test 1 : DequeVide ");
		DequeImplChaineeSS<String> dVide = new DequeImplChaineeSS<String>();
		try{
			dVide.premier();
			System.out.println(" KO, il n'y a pas eu DequeVideException : ");
			return;
					
		}catch (DequeVideException ex){
		}
		catch (Exception ex){
			System.out.println(" KO, il n'y a pas eu DequeVideException : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" : ok");
		
		System.out.print("Test 2 : Deque a b c ");
		String[] tabc = {"a","b","c"};
		DequeImplChaineeSS<String> dabc = new DequeImplChaineeSS<String>(tabc);
		try{
			String s = dabc.dernier();
			if(!s.equals("c")){
				System.out.println(" KO : element renvoye : " + s);
				return;
			}
			if(dabc.taille()!=3){
				System.out.println();
				System.out.println(" KO : taille modifiee : " + dabc.taille());
				return;
			}
			if(!dabc.toString().equals("a b c")){
				System.out.println(" KO : contenu (tete --> queue) modifie : "+ dabc);
				return;
			}
			if(!dabc.parcoursInverse().equals("c b a")){
				System.out.println(" KO : contenu (queue --> tete) modifie : "+ dabc.parcoursInverse());
				return;
			}
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" : ok");
		System.out.println("Tous les tests de la methode dernier() ont reussi!");
		System.out.println();
		
	}
	
}
