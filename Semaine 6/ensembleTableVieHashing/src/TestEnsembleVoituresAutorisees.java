public class TestEnsembleVoituresAutorisees{

	public static void main(String[] args) {	
		System.out.println("********************************************************");
		System.out.println("Programme Test pour la classe EnsembleVoituresAutorisees");
		System.out.println("");
		System.out.println("********************************************************");
		EnsembleVoituresAutorisees e = new EnsembleVoituresAutorisees();
		Voiture p1AAA000 = new Voiture("1AAA000","p1");
		Voiture p1BBB000 = new Voiture("1BBB000","p2");
		Voiture p1CCC000 = new Voiture("1CCC000","p3");
		Voiture p1AAA999 = new Voiture("1AAA999","p4");
		
		System.out.println("Cas 1 : ajout des voitures 1AAA000, 1BBB000, 1AAA999, 1CCC000");
		if(!e.ajouterVoiture(p1AAA000)){
			System.out.println("Attention votre methode annonce ne pas avoir ajoute la voiture 1AAA000");
			System.out.println("Or, l'ensemble est vide !!!");
			return;
		}
		if(!e.ajouterVoiture(p1BBB000)){
			System.out.println("Attention ajout de la voiture 1BBB000 a echoue!");
			return;
		}
		if(!e.ajouterVoiture(p1AAA999)){
			System.out.println("Attention ajout de la voiture 1AAA999 a echoue!");
			return;
		}
		if(!e.ajouterVoiture(p1CCC000)){
			System.out.println("Attention ajout de la voiture 1CCC000 a echoue!");
			return;
		}
	
		
		System.out.println("Cas 2 : verification de la presence des voitures 1AAA000, 1BBB000, 1AAA999, 1CCC000");
		if(! e.voitureAutorisee(new Voiture("1AAA000",""))){
			System.out.println("Attention, votre methode annonce que la voiture 1AAA000 est non autorisee !");
			return;
		}

		if(! e.voitureAutorisee(new Voiture("1BBB000",""))){
			System.out.println("Attention, votre methode annonce que la voiture 1BBB000 est non autorisee !");
			return;
		}

		if(! e.voitureAutorisee(new Voiture("1CCC000",""))){
			System.out.println("Attention, votre methode annonce que la voiture 1CCC000 est non autorisee !");
			return;
		}

		if(! e.voitureAutorisee(new Voiture("1AAA999",""))){
			System.out.println("Attention, votre methode annonce que la voiture 1AAA999 est non autorisee !");
			return;
		}

		System.out.println("Cas 3 : verification de la non presence de la voiture 1DDD000");
		if(e.voitureAutorisee(new Voiture("1DDD000",""))){
			System.out.println("Attention, voiture 1DDD000 est non autorisee !");
			return;
		}

		System.out.println("Cas 4 : suppression de la voiture 1BBB000");
		if(!e.retirerVoiture(new Voiture("1BBB000",""))){
			System.out.println("la voiture est presente dans l'ensemble, mais votre methode annonce ne pas l'avoir retiree");
			return;
		}
		if(e.voitureAutorisee(new Voiture("1BBB000",""))){
			System.out.println("Attention, apres suppression, la voiture 1BBB000 est toujours autorisee !");
		}
			

		

		System.out.println("Cas 5 : nouvelle suppression de la voiture 1BBB000 qui vient d'etre supprimee au cas 4");
		if (e.retirerVoiture(new Voiture("1BBB000",""))){
			System.out.println("La voiture n'est pas présente mais votre méthode annonce l'avoir retirée");
			return;
		}
		if (e.voitureAutorisee(new Voiture("1BBB000", ""))){
			System.out.printf("Attention, après la 2nd suppression, la voiture 1BBB000 est toujours autorisée");
			return;
		}
		
		
		System.out.println("Cas 6 : nouvelle verification de la presence des voitures 1AAA000 et 1CCC000");
		if (!e.retirerVoiture(new Voiture("1AAA000", ""))){
			System.out.println("La voiture n'est pas présente mais votre méthode annonce l'avoir retirée");
			return;
		}
		if (e.voitureAutorisee(new Voiture("1AAA000", ""))){
			System.out.printf("Attention, après la 2nd suppression, la voiture 1AAA000 est toujours autorisée");
			return;
		}
		if (!e.retirerVoiture(new Voiture("1CCC000", ""))){
			System.out.println("La voiture n'est pas présente mais votre méthode annonce l'avoir retirée");
			return;
		}
		if (e.voitureAutorisee(new Voiture("1CCC000", ""))){
			System.out.printf("Attention, après la 2nd suppression, la voiture 1CCC000 est toujours autorisée");
			return;
		}

		
		System.out.println("Cas 7 : ajout de la voiture 1AAA000 (qui y est deja!)");
		if (e.ajouterVoiture(new Voiture("1AAA000", ""))){
			System.out.println("Attention, la voiture 1AAA000 est déjà présente, votre méthode annonce l'avoir ajoutée");
			return;
		}
		if (!e.voitureAutorisee(new Voiture("1AAA000", ""))){
			System.out.println("Attention, votre méthode annonce que la voiture 1AAA000 n'est pas autorisée");
			return;
		}
		
	}

}