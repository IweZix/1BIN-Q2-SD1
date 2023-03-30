import java.util.NoSuchElementException;

public class TestServeurImpressions {

	public static void main(String[] args) {
		try {
			ServeurImpressions serveur = new ServeurImpressions();
			if (!serveur.toString().equals("[[], [], [], [], [], [], [], [], [], []]")) {
				System.out.println("Attention,les files n'ont pas ete instanciees");
				System.out.println("Revoyez le constructeur");
				return;
			}
		} catch(NullPointerException e){
			System.out.println("Attention,la table de files n'a pas ete instanciee");
			System.out.println("Revoyez le constructeur");
			e.printStackTrace();
			return;
		}
		ServeurImpressions serveur = new ServeurImpressions();
		DemandeImpression demande;
		if (!serveur.serveurVide()) {
			System.out.println("Au depart le serveur d'impression est vide : ");
			System.out.println("Attention, la methode serveurVide() annonce false");
			System.out.println("Revoyez cette methode");
			return;
		}

		System.out.println("Ajout dans un serveur d'impression vide des documents suivants (dans cet ordre!)");
		System.out.println("doc1 (9)");
		serveur.ajouter(new DemandeImpression("doc1", 9));
		if (serveur.toString().equals("[[], [], [], [], [], [], [], [], [], []]")) {
			System.out.println("Attention,le document n'a pas pris place dans une des files");
			System.out.println("Revoyez la methode ajouter()");
			return;
		}
		if (!serveur.toString().equals("[[], [], [], [], [], [], [], [], [], [doc1 (9)]]")) {
			System.out.println("Attention,le document n'a pas pris place dans la bonne file");
			System.out.println("Revoyez la methode ajouter()");
			return;
		}
		if (serveur.serveurVide()) {
			System.out.println("Attention, le document a bien ete ajoute");
			System.out.println("Mais la methode serveurVide() annonce true");
			System.out.println("Revoyez cette methode");
			return;
		}
		System.out.println("doc2 (4)");
		serveur.ajouter(new DemandeImpression("doc2", 4));
		if (!serveur.toString().equals("[[], [], [], [], [doc2 (4)], [], [], [], [], [doc1 (9)]]")) {
			System.out.println("Attention,le document n'a pas pris place dans la bonne file.");
			System.out.println("Revoyez la methode ajouter() !");
			return;
		}
		if (serveur.serveurVide()) {
			System.out.println("Attention, 2 documents ont ete ajoutes.");
			System.out.println("Mais la methode serveurVide() annonce true.");
			System.out.println("Revoyez cette methode !");
			return;
		}

		System.out.println("doc3 (0)");
		serveur.ajouter(new DemandeImpression("doc3", 0));
		if (!serveur.toString().equals("[[doc3 (0)], [], [], [], [doc2 (4)], [], [], [], [], [doc1 (9)]]")) {
			System.out.println("Attention,le document n'a pas pris place dans la bonne file.");
			System.out.println("Revoyez la methode ajouter() !");
			return;
		}

		System.out.println("doc4 (9)");
		serveur.ajouter(new DemandeImpression("doc4", 9));
		if (!serveur.toString().equals("[[doc3 (0)], [], [], [], [doc2 (4)], [], [], [], [], [doc1 (9), doc4 (9)]]")) {
			System.out.println("Attention,le document n'a pas pris place dans la bonne file.");
			System.out.println("Revoyez la methode ajouter() !");
			return;
		}

		System.out.println("doc5 (4)");
		serveur.ajouter(new DemandeImpression("doc5", 4));
		if (!serveur.toString().equals("[[doc3 (0)], [], [], [], [doc2 (4), doc5 (4)], [], [], [], [], [doc1 (9), doc4 (9)]]")) {
			System.out.println("Attention,le document n'a pas pris place dans la bonne file.");
			System.out.println("Revoyez la methode ajouter() !");
			return;
		}

		System.out.println("doc6 (4)");
		serveur.ajouter(new DemandeImpression("doc6", 4));
		if (!serveur.toString().equals("[[doc3 (0)], [], [], [], [doc2 (4), doc5 (4), doc6 (4)], [], [], [], [], [doc1 (9), doc4 (9)]]")) {
			System.out.println("Attention,le document n'a pas pris place dans la bonne file.");
			System.out.println("Revoyez la methode ajouter() !");
			return;
		}

		System.out.println("Les documents devraient etre imprimes dans cet ordre : doc1 doc4 doc2 doc5 doc6 doc3.");

		if (serveur.serveurVide()) {
			System.out.println("Attention, le serveur n'est pas encore vide");
			System.out.println("Mais la methode serveurVide() annonce true");
			System.out.println("Revoyez cette methode");
			return;
		}

		try {
			demande = serveur.retirer();
			if (!demande.getNomDocument().equals("doc1")){
				System.out.println("Attention, l'ordre n'est pas respecte!");
				System.out.println("Attendu : doc1 (9)");
				System.out.println("Recu : "+demande);
				System.out.println("Revoyez la methode retirer() !");
				return;
			}else {
				System.out.println(demande);
			}
		}catch (NoSuchElementException e){
			System.out.println("Le serveur n'est pas vide");
			System.out.println("Revoyez la methode retirer() !");
			e.printStackTrace();
			return;
		}

		if (serveur.serveurVide()) {
			System.out.println("Attention, le serveur n'est pas encore vide");
			System.out.println("Mais la methode serveurVide() annonce true");
			System.out.println("Revoyez cette methode");
			return;
		}

		try {
			demande = serveur.retirer();
			if (!demande.getNomDocument().equals("doc4")){
				System.out.println("Attention, l'ordre n'est pas respecte!");
				System.out.println("Attendu : doc4 (9)");
				System.out.println("Recu : "+demande);
				System.out.println("Revoyez la methode retirer() !");
				return;
			}else {
				System.out.println(demande);
			}
		}catch (NoSuchElementException e){
			System.out.println("Le serveur n'est pas vide");
			System.out.println("Revoyez la methode retirer() !");
			e.printStackTrace();
			return;
		}

		if (serveur.serveurVide()) {
			System.out.println("Attention, le serveur n'est pas encore vide");
			System.out.println("Mais la methode serveurVide() annonce true");
			System.out.println("Revoyez cette methode");
			return;
		}

		try {
			demande = serveur.retirer();
			if (!demande.getNomDocument().equals("doc2")){
				System.out.println("Attention, l'ordre n'est pas respecte!");
				System.out.println("Attendu : doc2 (4)");
				System.out.println("Recu : "+demande);
				System.out.println("Revoyez la methode retirer() !");
				return;
			}else {
				System.out.println(demande);
			}
		}catch (NoSuchElementException e){
			System.out.println("Le serveur n'est pas vide");
			System.out.println("Revoyez la methode retirer() !");
			e.printStackTrace();
			return;
		}

		if (serveur.serveurVide()) {
			System.out.println("Attention, le serveur n'est pas encore vide");
			System.out.println("Mais la methode serveurVide() annonce true");
			System.out.println("Revoyez cette methode");
			return;
		}

		try {
			demande = serveur.retirer();
			if (!demande.getNomDocument().equals("doc5")){
				System.out.println("Attention, l'ordre n'est pas respecte!");
				System.out.println("Attendu : doc5 (4)");
				System.out.println("Recu : "+demande);
				System.out.println("Revoyez la methode retirer() !");
				return;
			}else {
				System.out.println(demande);
			}
		}catch (NoSuchElementException e){
			System.out.println("Le serveur n'est pas vide");
			System.out.println("Revoyez la methode retirer() !");
			e.printStackTrace();
			return;
		}

		if (serveur.serveurVide()) {
			System.out.println("Attention, le serveur n'est pas encore vide");
			System.out.println("Mais la methode serveurVide() annonce true");
			System.out.println("Revoyez cette methode");
			return;
		}

		try {
			demande = serveur.retirer();
			if (!demande.getNomDocument().equals("doc6")){
				System.out.println("Attention, l'ordre n'est pas respecte!");
				System.out.println("Attendu : doc6 (4)");
				System.out.println("Recu : "+demande);
				System.out.println("Revoyez la methode retirer() !");
				return;
			}else {
				System.out.println(demande);
			}
		}catch (NoSuchElementException e){
			System.out.println("Le serveur n'est pas vide");
			System.out.println("Revoyez la methode retirer() !");
			e.printStackTrace();
			return;
		}

		if (serveur.serveurVide()) {
			System.out.println("Attention, le serveur n'est pas encore vide");
			System.out.println("Mais la methode serveurVide() annonce true");
			System.out.println("Revoyez cette methode");
			return;
		}

		try {
			demande = serveur.retirer();
			if (!demande.getNomDocument().equals("doc3")){
				System.out.println("Attention, l'ordre n'est pas respecte!");
				System.out.println("Attendu : doc3 (0)");
				System.out.println("Recu : "+demande);
				System.out.println("Revoyez la methode retirer() !");
				return;
			}else {
				System.out.println(demande);
			}
		}catch (NoSuchElementException e){
			System.out.println("Le serveur n'est pas vide");
			System.out.println("Revoyez la methode retirer() !");
			e.printStackTrace();
			return;
		}

		if (!serveur.serveurVide()) {
			System.out.println("Attention, le serveur est vide");
			System.out.println("Mais la methode serveurVide() annonce false");
			System.out.println("Revoyez cette methode");
			return;
		}

		try {
			demande = serveur.retirer();
			System.out.println("Le serveur est vide.");
			System.out.println("Mais il n'y a pas eu de NoSuchElementException.");
			System.out.println("Revoyez la methode retirer() !");
			return;

		}catch (NoSuchElementException e){

		}

		System.out.println("Le scenario propose s'est bien passe !");
	}
}


