
public class TestEnsembleVoituresAutorisees {

	public static void main(String[] args) {	
		System.out.println("*******************************************************");
		System.out.println("Programme Test pour la classe EnsembleVoituresAutorisees");
		System.out.println("");
		System.out.println("*******************************************************");
		EnsembleVoituresAutorisees e = new EnsembleVoituresAutorisees();

		System.out.println("Test1 : ajout de 3 voitures differentes");

		System.out.println("e.ajouterVoiture(1AAA000, proprioA) "+ e.ajouterVoiture("1AAA000", new Proprietaire("proprioA")));
		System.out.println("e.toString "+e);
		System.out.println();

		System.out.println("e.ajouterVoiture(1BBB000, proprioB) "+ e.ajouterVoiture("1BBB000", new Proprietaire("proprioB")));
		System.out.println("e.toString "+e);
		System.out.println();

		System.out.println("e.ajouterVoiture(1CCC000, proprioC) "+ e.ajouterVoiture("1CCC000", new Proprietaire("proprioC")));
		System.out.println("e.toString "+e);
		System.out.println();


		System.out.println("Test2 : ajout d'1 voiture existante");
		System.out.println("e.ajouterVoiture(1BBB000, proprioX) "+ e.ajouterVoiture("1BBB000", new Proprietaire("proprioX")));
		System.out.println("e.toString "+e);
		System.out.println();

		System.out.println("Test3 : test voiture autorisee");
		System.out.println("e.voitureAutorisee(1BBB000) "+ e.voitureAutorisee("1BBB000"));
		System.out.println();

		System.out.println("Test4 : test voiture non autorisee");
		System.out.println("e.voitureAutorisee(1XXX000) "+ e.voitureAutorisee("1XXX000"));
		System.out.println();


		System.out.println("Test5 : suppression d'1 voiture existante");
		System.out.println("e.retirerVoiture(1BBB000) "+ e.retirerVoiture("1BBB000"));
		System.out.println("e.toString "+e);
		System.out.println();

		System.out.println("Test6 : suppression d'1 voiture non existante");
		System.out.println("e.retirerVoiture(1XXX000) "+ e.retirerVoiture("1XXX000"));
		System.out.println("e.toString "+e);
		System.out.println();

		System.out.println("Test7 : proprietaire d'1 voiture existante");
		System.out.println("e.donnerProprietaire(1AAA000)"+e.donnerProprietaire(new String("1AAA000")));
		System.out.println();

		System.out.println("Test8 : proprietaire d'1 voiture non existante");
		System.out.println("e.donnerProprietaire(1XXX000)"+e.donnerProprietaire("1XXX000"));

	}


}
