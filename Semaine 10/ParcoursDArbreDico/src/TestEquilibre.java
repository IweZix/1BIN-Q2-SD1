
public class TestEquilibre {
	
	public static ABRDEntiers aVide(){
		return new ABRDEntiers();
	}
	
	public static ABRDEntiers a7NonEquilibre(){
		ABRDEntiers a = new ABRDEntiers(9);
		ABRDEntiers aVide = new ABRDEntiers();
		a = new ABRDEntiers(aVide, 8, a);
		a = new ABRDEntiers(aVide, 7, a);
		a = new ABRDEntiers(aVide, 6, a);
		a = new ABRDEntiers(aVide, 3, a);
		a = new ABRDEntiers(aVide, 2, a);
		a = new ABRDEntiers(aVide, 1, a);
		return a;
	}
	
	public static ABRDEntiers a7Equilibre(){
		ABRDEntiers g = new ABRDEntiers(1);
		ABRDEntiers d = new ABRDEntiers(3);
		g = new ABRDEntiers(g, 2, d);
		ABRDEntiers g1 = new ABRDEntiers(7);
		ABRDEntiers d1 = new ABRDEntiers(9);
		d = new ABRDEntiers(g1,8,d1);
		return  new ABRDEntiers(g, 6, d);	
	}
	
	public static ABRDEntiers a6NonEquilibre(){
		ABRDEntiers a = new ABRDEntiers(9);
		ABRDEntiers aVide = new ABRDEntiers();
		a = new ABRDEntiers(aVide, 8, a);
		a = new ABRDEntiers(aVide, 7, a);
		a = new ABRDEntiers(aVide, 6, a);
		a = new ABRDEntiers(aVide, 3, a);
		a = new ABRDEntiers(aVide, 2, a);
		return a;
	}
	
	public static ABRDEntiers a6Equilibre1(){
		ABRDEntiers g = new ABRDEntiers(2);
		ABRDEntiers d = new ABRDEntiers(6);
		g = new ABRDEntiers(g, 3, d);
		ABRDEntiers g1 = new ABRDEntiers(8);
		d = new ABRDEntiers(g1,9,aVide());
		return  new ABRDEntiers(g, 7, d);	
	}
	
	public static ABRDEntiers a6Equilibre2(){
		ABRDEntiers g = new ABRDEntiers(2);
		ABRDEntiers d = new ABRDEntiers(6);
		g = new ABRDEntiers(g, 3, d);
		ABRDEntiers d1 = new ABRDEntiers(9);
		d = new ABRDEntiers(aVide(),8,d1);
		return  new ABRDEntiers(g, 7, d);	
	}
	
	public static ABRDEntiers a6Equilibre3(){
		ABRDEntiers g = new ABRDEntiers(2);
		g = new ABRDEntiers(g, 3, aVide());
		ABRDEntiers g1 = new ABRDEntiers(7);
		ABRDEntiers d = new ABRDEntiers(9);
		d = new ABRDEntiers(g1,8,d);
		return  new ABRDEntiers(g, 6, d);	
	}
	
	public static ABRDEntiers a6Equilibre4(){
		ABRDEntiers d1 = new ABRDEntiers(3);
		ABRDEntiers g = new ABRDEntiers(aVide(), 2, d1);
		ABRDEntiers g1 = new ABRDEntiers(7);
		ABRDEntiers d = new ABRDEntiers(9);
		d = new ABRDEntiers(g1,8,d);
		return  new ABRDEntiers(g, 6, d);
	}
	
	
		
	
	public static void main(String[] args) {
			
		System.out.println("\n\ntest 1 : l'arbre contient 7 entiers : 1 2 3 6 7 8 9");
		
		System.out.println("------------------");
		ABRDEntiers a7NonEquilibre = a7NonEquilibre();
		ABRDEntiers a7EquilibreEspere = a7Equilibre();
		ABRDEntiers a7EquilibreObtenu = a7NonEquilibre().equilibre();
		if(!a7EquilibreEspere.equals(a7EquilibreObtenu)){
			System.out.println("ATTENTION : test ko");
			System.out.println("l'arbre obtenu apres appel de la methode equilibre():");
			System.out.println(a7EquilibreObtenu.toStringLoic());		
			System.exit(0);
		}
		
		System.out.println("Le 2 test 1 a reussi!");
		
		System.out.println("\n\ntest 2 : l'arbre contient 6 entiers (2 3 6 7 8 9");
		
		System.out.println("------------------");
		ABRDEntiers a6NonEquilibre = a6NonEquilibre();
		ABRDEntiers a6EquilibreEspere1 = a6Equilibre1();
		ABRDEntiers a6EquilibreEspere2 = a6Equilibre2();
		ABRDEntiers a6EquilibreEspere3 = a6Equilibre3();
		ABRDEntiers a6EquilibreEspere4 = a6Equilibre4();
		ABRDEntiers a6EquilibreObtenu = a6NonEquilibre().equilibre();
		if(!a6EquilibreEspere1.equals(a6EquilibreObtenu)
				&&!a6EquilibreEspere2.equals(a6EquilibreObtenu)
				&&!a6EquilibreEspere3.equals(a6EquilibreObtenu)
				&&!a6EquilibreEspere4.equals(a6EquilibreObtenu )){
			System.out.println("ATTENTION : test ko");
			System.out.println("l'arbre obtenu apres appel de la methode equilibre():");
			System.out.println(a6EquilibreObtenu.toStringLoic());
			System.exit(0);
		}
		
		System.out.println("Les 2 tests ont reussi!");
	}
}
