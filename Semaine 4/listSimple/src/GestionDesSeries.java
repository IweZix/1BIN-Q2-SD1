import java.util.Scanner;
import java.util.HashSet;

public class GestionDesSeries {
	
	private static Scanner scanner = new Scanner(System.in);
	private static ClasseEtudiants classe;

	public static void main(String[] args) {	
		
			System.out.print("Combien y a-t-il de series ? ");
			int nombreSeries = scanner.nextInt();
			if(nombreSeries<1){
				System.out.println();
				System.out.println("L'application a rencontre un probleme");
				System.out.println("Le nombre de series doit etre positif.");
				System.out.println("Veuillez relancer l'application!");
				System.exit(0);
			}
			System.out.print("Combien y a-t-il d'etudiants ? ");
			int nombreEtudiants = scanner.nextInt();
			scanner.nextLine();
			if(nombreEtudiants<0){
				System.out.println();
				System.out.println("L'application a rencontre un probleme");
				System.out.println("Le nombre d'etudiants doit etre positif.");
				System.out.println("Veuillez relancer l'application!");
				System.exit(0);
			}
			String[] noms = new String[nombreEtudiants];
			for (int i = 0; i < noms.length; i++) {
				System.out.print("Entrez le nom de l'etudiant n°"+ (i+1)+" ");
				noms[i]=scanner.nextLine();
				if(noms[i].length()==0){
					System.out.println("L'application a rencontre un probleme");
					System.out.println("les noms des etudiants doivent comporter au moins 1 caractere.");
					System.out.println("Veuillez relancer l'application!");
					System.exit(0);
				}
			}
			if(contientExAequos(noms)){
				System.out.println("L'application a rencontre un probleme");
				System.out.println("les noms des etudiants doivent tous etre differents");
				System.out.println("Veuillez relancer l'application!");
				System.exit(0);
			}
			classe = new ClasseEtudiants(nombreSeries, noms);
				
	
		System.out.println();
		System.out.println();
		System.out.println("******************");
		System.out.println("gestion des series");
		System.out.println("******************");
	
		int choix = 0;
		do {
			System.out.println();
			System.out.println("1 -> rechercher la serie d'un etudiant");	
			System.out.println("2 -> proceder a un changement de serie");	
			System.out.println("3 -> afficher le nombre d'etudiants de chaque serie");
			System.out.println("4 -> afficher les differentes series");
			System.out.println();
			System.out.print("Votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
			case 1:
				rechercherSerie();
				break;
			case 2:
				faireUnChangementDeSeries();
				break;
			case 3:
				afficherTailleSeries();
				break;
			case 4:
				afficherTout();
				break;
			default:
				break;
			}

		} while (choix >= 1 && choix <= 4);
	}



	private static void rechercherSerie() {
		System.out.print("Entrez l'etudiant : ");
		scanner.nextLine();
		String nom = scanner.nextLine();
		int numeroSerie = classe.numeroSerie(nom) +1;
		if(numeroSerie==-1){
			System.out.println("cet etudiant n'existe pas!");
		}else{
			System.out.println("l'etudiant "+nom+" fait partie de la serie "+numeroSerie);
		}
	}
	
	private static void faireUnChangementDeSeries() {
		scanner.nextLine() ;
		System.out.print("Entrez l'etudiant : ");	
		String nom = scanner.nextLine();
		System.out.print("Entrez son nouveau numero de serie : ");
		int nouveauNumeroSerie = scanner.nextInt();
	    try{
	    	if(classe.changerSerie(nom, nouveauNumeroSerie)){
	    		System.out.println("le changement a bien ete effectue!");
	    	}else{
	    		if(classe.numeroSerie(nom)==-1){
	    			System.out.println("cet etudiant n'existe pas!");
	    		}else{
	    			System.out.println("l'etudiant faisait deja partie de cette serie!");
	    		}
	    	}
	    }catch (IllegalArgumentException e){
	    	System.out.println("le numero de serie n'existe pas ou le nom de l'etudiant est vide");
	    }
		
	}
	
	/*private static void afficherTailleSeries() {
		System.out.println(classe.tailleSerie());
	}*/

	private static void afficherTailleSeries() {
		int[] tab = classe.tailleSerie2();
		for (int i = 0; i < tab.length; i++) {
			System.out.println("Serie n" + (i+1) + " : " + tab[i] + " etudiants");
		}
	}

	private static void afficherTout() {
		System.out.println(classe);
		System.out.println();
		System.out.println("Vous pouvez changer les methodes toString() pour un plus bel affichage!");
		
	}
	
	private static boolean contientExAequos(String[] noms) {
		HashSet<String> ensemble = new HashSet<String>();
		for (int i = 0; i < noms.length; i++) {
			if(!ensemble.add(noms[i]))
				return true;
		}
		return false;
	}
}
