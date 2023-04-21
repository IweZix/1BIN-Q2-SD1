import java.util.Scanner;

public class TestArbreComplet {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main (String[] args) {

		System.out.println("**********************************");
		System.out.println("Programme Test : Arbres equilibres");
		System.out.println("**********************************");
		System.out.println("Les arbres testes sont les arbres de l'exercice B2!");
		int choix = 0;
		do{
			System.out.println();
			System.out.println("1 -> Tester la methode 'hauteur'");
			System.out.println("2 -> Tester la methode 'estCompletementRempli'");
			System.out.println("3 -> Tester la methode 'estComplet'");
			System.out.println();
			System.out.print("Entrez votre choix : ");
			
		choix = scanner.nextInt();
			switch (choix) {
			
			case 1:
				testHauteur();
				break;	
				
			case 2:
				testEstCompletementRempli();
				break;	
				
			case 3:
				testEstComplet();
				break;	
				
			default:
				break;
			}
		} while ((choix>0)&&(choix<4));
	}

	

	private static ArbreDEntiersPlus arbre1(){
		return new ArbreDEntiersPlus();
	}
	
	private static ArbreDEntiersPlus arbre2(){
		return  new ArbreDEntiersPlus(12);
	
	}
	
	private static ArbreDEntiersPlus arbre3(){
		ArbreDEntiersPlus g = new ArbreDEntiersPlus(8);
		ArbreDEntiersPlus d = new ArbreDEntiersPlus();
		return  new ArbreDEntiersPlus(g, 12, d);

	}
	
	private static ArbreDEntiersPlus arbre4(){
		ArbreDEntiersPlus g = new ArbreDEntiersPlus();
		ArbreDEntiersPlus d = new ArbreDEntiersPlus(17);
		return  new ArbreDEntiersPlus(g, 12, d);

	}
	
	private static ArbreDEntiersPlus arbre5(){
		ArbreDEntiersPlus g = new ArbreDEntiersPlus(8);
		ArbreDEntiersPlus d = new ArbreDEntiersPlus(17);
		return  new ArbreDEntiersPlus(g, 12, d);

	}
	
	private static ArbreDEntiersPlus arbre6(){
		ArbreDEntiersPlus g = new ArbreDEntiersPlus(4);
		ArbreDEntiersPlus d = new ArbreDEntiersPlus();
		g =  new ArbreDEntiersPlus(g, 8, d);
		d = new ArbreDEntiersPlus(17);
		return  new ArbreDEntiersPlus(g, 12, d);

	}
	
	private static ArbreDEntiersPlus arbre7(){
		ArbreDEntiersPlus g = new ArbreDEntiersPlus(15);
		ArbreDEntiersPlus d = new ArbreDEntiersPlus();
		d =  new ArbreDEntiersPlus(g, 17, d);
		g = new ArbreDEntiersPlus(8);
		return  new ArbreDEntiersPlus(g, 12, d);

	}
	
	private static ArbreDEntiersPlus arbre8(){
		ArbreDEntiersPlus g = new ArbreDEntiersPlus(4);
		ArbreDEntiersPlus d = new ArbreDEntiersPlus(10);
		g =  new ArbreDEntiersPlus(g, 8, d);
		d = new ArbreDEntiersPlus(17);
		return  new ArbreDEntiersPlus(g, 12, d);

	}
	
	private static ArbreDEntiersPlus arbre9(){
		ArbreDEntiersPlus g = new ArbreDEntiersPlus(4);
		ArbreDEntiersPlus d = new ArbreDEntiersPlus(10);
		g =  new ArbreDEntiersPlus(g, 8, d);
		ArbreDEntiersPlus g1 = new ArbreDEntiersPlus(15);
		ArbreDEntiersPlus d1 = new ArbreDEntiersPlus();
		d = new ArbreDEntiersPlus(g1,17,d1);
		return  new ArbreDEntiersPlus(g, 12, d);

	}
	
	private static ArbreDEntiersPlus arbre10(){
		ArbreDEntiersPlus g = new ArbreDEntiersPlus(4);
		ArbreDEntiersPlus d = new ArbreDEntiersPlus(10);
		g =  new ArbreDEntiersPlus(g, 8, d);
		ArbreDEntiersPlus g1 = new ArbreDEntiersPlus(15);
		ArbreDEntiersPlus d1 = new ArbreDEntiersPlus(20);
		d = new ArbreDEntiersPlus(g1,17,d1);
		return  new ArbreDEntiersPlus(g, 12, d);

	}
	
	private static ArbreDEntiersPlus arbre11(){
		ArbreDEntiersPlus g = new ArbreDEntiersPlus(8);
		ArbreDEntiersPlus g1 = new ArbreDEntiersPlus(15);
		ArbreDEntiersPlus d1 = new ArbreDEntiersPlus(20);
		ArbreDEntiersPlus d = new ArbreDEntiersPlus(g1,17,d1);
		return  new ArbreDEntiersPlus(g, 12, d);

	}
	
	private static ArbreDEntiersPlus arbre12(){
		ArbreDEntiersPlus g = new ArbreDEntiersPlus(4);
		ArbreDEntiersPlus d = new ArbreDEntiersPlus(10);
		g =  new ArbreDEntiersPlus(g, 8, d);
		d = new ArbreDEntiersPlus();
		return  new ArbreDEntiersPlus(g, 12, d);

	}
	
	private static void testHauteur() {
		// test 1
		boolean ok = true;
		ArbreDEntiersPlus a = arbre1();
		if(a.hauteur()!=-1) {
			System.out.println("Attention !!! Le test 1 a rate"); 
			ok = false;
		}
		// test 2
		a = arbre2();
		if(a.hauteur()!=0) {
			System.out.println("Attention !!! Le test 2 a rate"); 
			ok = false;
		}
		// test 6
		a = arbre6();
		if(a.hauteur()!=2) {
			System.out.println("Attention !!! Le test 6 a rate"); 
			ok = false;
		}
		//test7
		a = arbre7();
		if(a.hauteur()!=2) {
			System.out.println("Attention !!! Le test 7 a rate"); 
			ok = false;
		}
		if (ok) System.out.println("tous les tests ont reussi");	
		
	}
	
	private static void testEstCompletementRempli(){
		
		// test 1
		boolean ok = true;
		ArbreDEntiersPlus a = arbre1();
		if(!a.estCompletementRempli()) {
			System.out.println("Attention !!! Le test 1 a rate"); 
			ok = false;
		}
		
		// test 2
		a = arbre2();
		if(!a.estCompletementRempli()) {
			System.out.println("Attention !!! Le test 2 a rate"); 
			ok = false;
		}
		
		a = arbre3();
		if(a.estCompletementRempli()) {
			System.out.println("Attention !!! Le test 3 a rate"); 
			ok = false;
		}
		
		a = arbre4();
		if(a.estCompletementRempli()) {
			System.out.println("Attention !!! Le test 4 a rate"); 
			ok = false;
		}
		
		a = arbre5();
		if(!a.estCompletementRempli()) {
			System.out.println("Attention !!! Le test 5 a rate"); 
			ok = false;
		}
		
		a = arbre6();
		if(a.estCompletementRempli()) {
			System.out.println("Attention !!! Le test 6 a rate"); 
			ok = false;
		}
		
		a = arbre7();
		if(a.estCompletementRempli()) {
			System.out.println("Attention !!! Le test 7 a rate"); 
			ok = false;
		}
		
		a = arbre8();
		if(a.estCompletementRempli()) {
			System.out.println("Attention !!! Le test 8 a rate"); 
			ok = false;
		}
		
		a = arbre9();
		if(a.estCompletementRempli()) {
			System.out.println("Attention !!! Le test 9 a rate"); 
			ok = false;
		}
		
		a = arbre10();
		if(!a.estCompletementRempli()) {
			System.out.println("Attention !!! Le test 10 a rate"); 
			ok = false;
		}
		
		a = arbre11();
		if(a.estCompletementRempli()) {
			System.out.println("Attention !!! Le test 11 a rate"); 
			ok = false;
		}
		
		a = arbre12();
		if(a.estCompletementRempli()) {
			System.out.println("Attention !!! Le test 12 a rate"); 
			ok = false;
		}
		
		if (ok) System.out.println("tous les tests ont reussi");	 	
	}
	
	private static void testEstComplet(){
		// test 1
		boolean ok = true;
		ArbreDEntiersPlus a = arbre1();
		if(!a.estComplet()) {
			System.out.println("Attention !!! Le test 1 a rate"); 
			ok = false;
		}
		
		// test 2
		a = arbre2();
		if(!a.estComplet()) {
			System.out.println("Attention !!! Le test 2 a rate"); 
			ok = false;
		}
		
		a = arbre3();
		if(! a.estComplet()) {
			System.out.println("Attention !!! Le test 3 a rate"); 
			ok = false;
		}
		
		a = arbre4();
		if(a.estComplet()) {
			System.out.println("Attention !!! Le test 4 a rate"); 
			ok = false;
		}
		
		a = arbre5();
		if(!a.estComplet()) {
			System.out.println("Attention !!! Le test 5 a rate"); 
			ok = false;
		}
		
		a = arbre6();
		if(!a.estComplet()) {
			System.out.println("Attention !!! Le test 6 a rate"); 
			ok = false;
		}
		
		a = arbre7();
		if(a.estComplet()) {
			System.out.println("Attention !!! Le test 7 a rate"); 
			ok = false;
		}
		
		a = arbre8();
		if(!a.estComplet()) {
			System.out.println("Attention !!! Le test 8 a rate"); 
			ok = false;
		}
		
		a = arbre9();
		if(!a.estComplet()) {
			System.out.println("Attention !!! Le test 9 a rate"); 
			ok = false;
		}
		
		a = arbre10();
		if(!a.estComplet()) {
			System.out.println("Attention !!! Le test 10 a rate"); 
			ok = false;
		}
		
		a = arbre11();
		if(a.estComplet()) {
			System.out.println("Attention !!! Le test 11 a rate"); 
			ok = false;
		}
		
		a = arbre12();
		if(a.estComplet()) {
			System.out.println("Attention !!! Le test 12 a rate"); 
			ok = false;
		}
		
		if (ok) System.out.println("tous les tests ont reussi");	
 }
	
}
