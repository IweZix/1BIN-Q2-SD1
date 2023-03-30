public class TestPatrouille {
	
	public static void main(String args[]){	
		System.out.println("appel du constructeur avec sam comme CP");
		Patrouille patrouille = new Patrouille("castors", "sam");
		System.out.println("Apres appel du constructeur, le nombre de scouts est " + patrouille.getNombreScouts());
		System.out.print("Voici la patrouille obtenue : ");
		System.out.println(patrouille.toString());
		System.out.println();
		System.out.println("ajout de tom");
		patrouille.ajouterScout("tom");
		System.out.println("Apres ajout, le nombre de scouts est " + patrouille.getNombreScouts());
		System.out.print("Voici la patrouille obtenue : ");
		System.out.println(patrouille.toString());
		System.out.println();
		System.out.println("ajout de max");
		patrouille.ajouterScout("max");
		System.out.println("Apres ajout, le nombre de scouts est " + patrouille.getNombreScouts());
		System.out.print("Voici la patrouille obtenue : ");
		System.out.println(patrouille.toString());
		System.out.println();
		System.out.println("ajout de bob");
		patrouille.ajouterScout("bob");
		System.out.println("Apres ajout, le nombre de scouts est " + patrouille.getNombreScouts());
		System.out.print("Voici la patrouille obtenue : ");
		System.out.println(patrouille.toString());
		System.out.println();
		System.out.println("Verifiez les affichages avec ceux attendus (cfr enonce)");
	}
}
