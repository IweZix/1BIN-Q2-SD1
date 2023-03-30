
public class TestUnshuffleSort {

	public static void main(String[] args) {
		System.out.println("********************************");
		System.out.println("Tests de la classe UnshuffleSort");
		System.out.println("********************************");
		UnshuffleSort unshuffleSort = new UnshuffleSort();
		
		//test 1
		System.out.println("Test 1 : table a trier vide");
		int[] t1 = new int[0];
		int[] t1Triee = unshuffleSort.trier(t1);
		int[] t1Sol = new int[0];
		if(t1Triee.length!=0){
			System.out.println("test 1 ko : taille incorrecte : " + t1Triee.length);
			System.exit(0);
		}
		if(!sontIdentiques(t1Triee, t1Sol)){
			System.out.println("test 1 ko ");
			System.out.println("table avant tri : ");
			afficher(t1);
			System.out.println("table obtenue apres appel de votre methode de tri : ");
			afficher(t1Triee);
			System.exit(0);
		}
		System.out.println("Test 1 ok");
		System.out.println();
		
		
		System.out.println("Test 2 : table a trier avec 1 element");
		unshuffleSort = new UnshuffleSort();
		int[] t2 = {1};
		int[] t2Triee = unshuffleSort.trier(t2);
		if(t2Triee.length!=1){
			System.out.println("test 2 ko : taille incorrecte : "+ t2Triee.length);
			System.exit(0);
		}
		if(t2Triee[0]!=1){
			System.out.println("test 2 ko : contenu incorrect");
			System.out.println("table avant tri : ");
			afficher(t2);
			System.out.println("table apres tri : ");
			afficher(t2Triee);
			System.exit(0);
		}
		System.out.println("Test 2 ok");
		System.out.println();
		
		
		System.out.println("Test 3 : table a trier de 6 entiers - 1 seul deque");
		unshuffleSort = new UnshuffleSort();
		int[] t3 = {4,3,5,2,1,6};
		int[] t3Sol = {1,2,3,4,5,6};
		int[] t3Triee = unshuffleSort.trier(t3);
		if(t3Triee.length!=t3.length){
			System.out.println("test 3 ko : taille incorrecte : "+ t3Triee.length);
			System.exit(0);
		}
		if(!sontIdentiques(t3Triee, t3Sol)){
			System.out.println("test 3 ko ");
			System.out.println("table avant tri : ");
			afficher(t3);
			System.out.println("table obtenue apres appel de votre methode de tri : ");
			afficher(t3Triee);
			System.exit(0);
		}
		System.out.println("Test 3 ok");
		System.out.println();
		
		System.out.println("Test 4 : la table a trier est celle de l'enonce");

		unshuffleSort = new UnshuffleSort();
		int[] t4 = {3,12,2,4,18,17,6,1,15,14};
		int[] t4Sol = {1,2,3,4,6,12,14,15,17,18};
		int[] t4Triee = unshuffleSort.trier(t4);
		if(t4Triee.length!=t4.length){
			System.out.println("test 4 ko : taille incorrecte : "+ t4Triee.length);
			System.exit(0);
		}
		if(!sontIdentiques(t4Triee, t4Sol)){
			System.out.println("test 4 ko ");
			System.out.println("table avant tri : ");
			afficher(t4);
			System.out.println("table obtenue apres appel de votre methode de tri : ");
			afficher(t4Triee);
			System.exit(0);
		}
		System.out.println("Test 4 ok");
		System.out.println();
		
	
		System.out.println("Test 5 : la table a trier contient des ex-aequos : 4 4 7 2 4");

		unshuffleSort = new UnshuffleSort();
		int[] t5 = {4,4,7,2,4};
		int[] t5Sol = {2,4,4,4,7};
		int[] t5Triee = unshuffleSort.trier(t5);
		if(t5Triee.length!=t5.length){
			System.out.println("test 5 ko : taille incorrecte : "+ t5Triee.length);
			System.exit(0);
		}
		if(!sontIdentiques(t5Triee, t5Sol)){
			System.out.println("test 5 ko ");
			System.out.println("table avant tri : ");
			afficher(t5);
			System.out.println("table obtenue apres appel de votre methode de tri : ");
			afficher(t5Triee);
			System.exit(0);
		}
		System.out.println("Test 5 ok");
		System.out.println();
		System.out.println("\nTous les tests ont reussi!");

	}
	
	private static boolean estTriee(int[] table) {
		for (int i = 0; i < table.length - 1; i++) {
			if (table[i] > table[i + 1])
				return false;
		}
		return true;
	}
	
	private static boolean sontIdentiques(int[] t1, int[] t2){
		if(t1.length!=t2.length)
			return false;
		for (int i = 0; i < t2.length; i++) {
			if(t1[i]!=t2[i])
				return false;
			
		}
		return true;
	}
	
	public static void afficher(int[] table) {
		String resultat = "";
		for (int i = 0; i < table.length; i++) {
			resultat += " "+table[i];
		}
		System.out.println(resultat);
	}
	
	
}
