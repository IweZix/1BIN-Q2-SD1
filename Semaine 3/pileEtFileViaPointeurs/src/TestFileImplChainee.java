import java.util.Scanner;

public class TestFileImplChainee{
	private final static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {	

		System.out.println("*********************************************");
		System.out.println("Programme Test pour la classe FileImplChainee");
		System.out.println("*********************************************");

		int choix = 0;
		do {
			System.out.println();
			System.out.println("1 -> Tester la methode enfile()");
			System.out.println("2 -> Tester la methode defile()");
			System.out.println("3 -> Tester la methode premier()");		
			System.out.println("4 -> Tester l'exB1");	
			System.out.println();
			System.out.print("Votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
			case 1:
				testEnfile();
				break;
			case 2:
				testDefile();
				break;
			case 3:				
				testPremier();
				break;
			case 4:				
				testExB1();
				break;
			default:
				break;
			}

		} while (choix >= 1 && choix <= 4);
	}

	
	
	private static void testExB1() {
		FileImplChainee<Character> f = new FileImplChainee<Character>();
		System.out.print("Test1 ");
		try{
			f.defile();
			System.out.println(" KO, il n'y a pas eu FileVideException : ");
			return;
					
		}catch (FileVideException ex){
		}
		catch (Exception ex){
			System.out.println(" KO, il n'y a pas eu FileVideException : ");
			ex.printStackTrace();
			return;
		}
		System.out.println("ok");
		
		System.out.print("Test2 ");
		try{
			f.premier();
			System.out.println(" KO, il n'y a pas eu FileVideException : ");
			return;
					
		}catch (FileVideException ex){
		}
		catch (Exception ex){
			System.out.println(" KO, il n'y a pas eu FileVideException : ");
			ex.printStackTrace();
			return;
		}
		System.out.println("ok");
		
		System.out.print("Test3 ");
		try{
			f.enfile('a');
			if(f.taille()!=1){
				System.out.println();
				System.out.println(" KO : taille obtenue : " + f.taille());
				return;
			}
			if(!f.toString().equals(" a")){
				System.out.println(" KO : contenu liste obtenu : "+ f);
				return;
			}
					
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println("ok");
		
		System.out.print("Test4 ");
		try{
			f.enfile('b');
			if(f.taille()!=2){
				System.out.println();
				System.out.println(" KO : taille obtenue : " + f.taille());
				return;
			}
			if(!f.toString().equals(" a b")){
				System.out.println(" KO : contenu liste obtenu : "+ f);
				return;
			}
					
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println("ok");
		
		System.out.print("Test5 ");
		try{
			char c = f.premier();
			if(c!='a'){
				System.out.println(" KO : caractere renvoye : " + c);
				return;
			}
			if(f.taille()!=2){
				System.out.println();
				System.out.println(" KO : taille modifiee : " + f.taille());
				return;
			}
			if(!f.toString().equals(" a b")){
				System.out.println(" KO : contenu modifie : "+ f);
				return;
			}
					
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println("ok");
		
		System.out.print("Test6 ");
		try{
			char c = f.defile();
			if(c!='a'){
				System.out.println(" KO : caractere renvoye : " + c);
				return;
			}
			if(f.taille()!=1){
				System.out.println();
				System.out.println(" KO : taille obtenue : " + f.taille());
				return;
			}
			if(!f.toString().equals(" b")){
				System.out.println(" KO : contenu obtenu : "+ f);
				return;
			}
					
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println("ok");
		
		System.out.print("Test7 ");
		try{
			char c = f.defile();
			if(c!='b'){
				System.out.println(" KO : caractere renvoye : " + c);
				return;
			}
			if(f.taille()!=0){
				System.out.println();
				System.out.println(" KO : taille obtenue : " + f.taille());
				return;
			}
			if(!f.toString().equals("")){
				System.out.println(" KO : contenu obtenu : "+ f);
				return;
			}
					
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println("ok");
		
		System.out.print("Test8 ");
		try{
			f.defile();
			System.out.println(" KO, il n'y a pas eu FileVideException : ");
			return;
					
		}catch (FileVideException ex){
		}
		catch (Exception ex){
			System.out.println(" KO, il n'y a pas eu FileVideException : ");
			ex.printStackTrace();
			return;
		}
		System.out.println("ok");
		try{
			f.enfile('c');
			f.enfile('d');
			f.enfile('e');
			if(f.taille()!=3){
				System.out.println();
				System.out.println(" KO : taille obtenue : " + f.taille());
				return;
			}
			if(!f.toString().equals(" c d e")){
				System.out.println(" KO : contenu liste obtenu : "+ f);
				return;
			}
					
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.print("Test9 ");
		
		System.out.println("ok");
		System.out.println("Tous les tests ont reussi!");
	}



	private static void testEnfile() {
		System.out.println();
		System.out.println("Tests methode enfile()");
		System.out.println("----------------------");
		System.out.print("Test 1 : FileVide : enfile(a)");
		FileImplChainee<String> fVide = new FileImplChainee<String>();
		try{
			fVide.enfile("a");
			if(fVide.taille()!=1){
				System.out.println();
				System.out.println(" KO : taille obtenue : " + fVide.taille());
				return;
			}
			if(!fVide.toString().equals(" a")){
				System.out.println(" KO : contenu liste obtenu : "+ fVide);
				return;
			}
					
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" : ok");
		
		System.out.print("Test 2 : File a b c : enfile(d)");
		String[] tabc = {"a","b","c"};
		FileImplChainee<String> fabc = new FileImplChainee<String>(tabc);
		try{
			fabc.enfile("d");
			if(fabc.taille()!=4){
				System.out.println();
				System.out.println(" KO : taille obtenue : " + fabc.taille());
				return;
			}
			if(!fabc.toString().equals(" a b c d")){
				System.out.println(" KO : contenu liste obtenu : "+ fabc);
				return;
			}
					
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" : ok");
		
		
		System.out.print("Test 3 : File a b  : enfile(c) enfile(d)");
		String[] tab = {"a","b"};
		FileImplChainee<String> fab = new FileImplChainee<String>(tab);
		try{
			fab.enfile("c");
			fab.enfile("d");
			if(fab.taille()!=4){
				System.out.println();
				System.out.println(" KO : taille obtenue : " + fab.taille());
				return;
			}
			if(!fab.toString().equals(" a b c d")){
				System.out.println(" KO : contenu liste obtenu : "+ fab);
				return;
			}
					
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" : ok");
		
		System.out.println("Tous les tests de la methode enfile ont reussi!");
		System.out.println();
		
	}

	private static void testDefile() {
		System.out.println();
		System.out.println("Tests methode defile()");
		System.out.println("----------------------");
		System.out.print("Test 1 : FileVide ");
		FileImplChainee<String> fVide = new FileImplChainee<String>();
		try{
			fVide.defile();
			System.out.println(" KO, il n'y a pas eu FileVideException : ");
			return;
					
		}catch (FileVideException ex){
		}
		catch (Exception ex){
			System.out.println(" KO, il n'y a pas eu FileVideException : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" : ok");
		
		System.out.print("Test 2 : File a b c ");
		String[] tabc = {"a","b","c"};
		FileImplChainee<String> fabc = new FileImplChainee<String>(tabc);
		try{
			String s = fabc.defile();
			if(!s.equals("a")){
				System.out.println(" KO : string renvoyee : " + s);
				return;
			}
			if(fabc.taille()!=2){
				System.out.println();
				System.out.println(" KO : taille obtenue : " + fabc.taille());
				return;
			}
			if(!fabc.toString().equals(" b c")){
				System.out.println(" KO : contenu obtenu : "+ fabc);
				return;
			}
					
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" : ok");
		System.out.println("Tous les tests de la methode defile ont reussi!");
		System.out.println();
		
	}

	private static void testPremier() {
		System.out.println();
		System.out.println("Tests methode premier()");
		System.out.println("-----------------------");
		System.out.print("Test 1 : FileVide ");
		FileImplChainee<String> fVide = new FileImplChainee<String>();
		try{
			fVide.premier();
			System.out.println(" KO, il n'y a pas eu FileVideException : ");
			return;
					
		}catch (FileVideException ex){
		}
		catch (Exception ex){
			System.out.println(" KO, il n'y a pas eu FileVideException : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" : ok");
		
		System.out.print("Test 2 : File a b c ");
		String[] tabc = {"a","b","c"};
		FileImplChainee<String> fabc = new FileImplChainee<String>(tabc);
		try{
			String s = fabc.premier();
			if(!s.equals("a")){
				System.out.println(" KO : string renvoyee : " + s);
				return;
			}
			if(fabc.taille()!=3){
				System.out.println();
				System.out.println(" KO : taille modifiee : " + fabc.taille());
				return;
			}
			if(!fabc.toString().equals(" a b c")){
				System.out.println(" KO : contenu modifie : "+ fabc);
				return;
			}
					
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" : ok");
		System.out.println("Tous les tests de la methode premier ont reussi!");
		System.out.println();
		
	}



}








