import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;



public class TestIterateurs {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("*****************************");
		System.out.println("Programme Test des iterateurs");
		System.out.println("*****************************");
		int choix = 0;
		do{
			System.out.println();
			System.out.println("1 -> Tester l'iterateur en pre-ordre");
			System.out.println("2 -> Tester l'iterateur en post-ordre");
			System.out.println("3 -> Tester l'iterateur en in-ordre");
			System.out.println("4 -> Tester l'iterateur par niveau");
			System.out.println();
			System.out.print("Entrez votre choix : ");

			choix = scanner.nextInt();
			System.out.println();
			switch (choix) {
			case 1:
				testIterateurPreOrdre();
				break;	
			case 2:
				testIterateurPostOrdre();
				break;	
			case 3:
				testIterateurInOrdre();
				break;	
			case 4:
				testIterateurParNiveau();
				break;	
			default:
				break;
			}
		} while ((choix > 0) && (choix<5));
	}

	private static ArbreDEntiers arbre(){
		ArbreDEntiers g = new ArbreDEntiers(6);
		ArbreDEntiers d = new ArbreDEntiers();
		d =  new ArbreDEntiers(g,7,d);
		g = new ArbreDEntiers(3);
		ArbreDEntiers g1 = new ArbreDEntiers(g,5,d);
		g = new ArbreDEntiers(2);
		d = new ArbreDEntiers();
		d = new ArbreDEntiers(g,4,d);
		g = new ArbreDEntiers();
		d = new ArbreDEntiers(g,9,d);
		return  new ArbreDEntiers(g1, 8, d);
	}
	
	private static ArbreDEntiers arbreVide(){
		return new ArbreDEntiers();
	}
	

	public static void testIterateurPreOrdre(){
		System.out.println("Test avec l'arbre de l'exercice A");
		ArbreDEntiers a = arbre();
		try {
			Iterator<Integer> it = a.preIterateur();
			if (it == null) {
				System.out.println("Attention, vous avez oublie d'ecrire la methode preIterateur()");
				return;
			}
		}catch (Exception e){
			System.out.println("Il y a eu une exception inattendue lors de l'appel du constructeur");
			System.out.println("Revoyez le constructeur.");
			e.printStackTrace();
			return;
		}
		Iterator<Integer> it = a.preIterateur();
		int[] solution = {8,5,3,7,6,9,4,2};
		int i = 0;
		if(!it.hasNext()){
			System.out.println("Le test avec l'arbre de l'exercice A a echoue!");
			System.out.println("La methode hasNext() a renvoye false.");
			System.out.println("Revoyez l'iterateur");
			return;
		}
		while(it.hasNext()){
			int suivant = (Integer)it.next();
			if(suivant!=solution[i]) {
				System.out.println("Le suivant attendu est "+solution[i]);
				System.out.println("Le suivant recu est "+suivant);
				System.out.println("Revoyez l'iterateur");
				return;
			}
			i++;
			System.out.print(suivant + " ");
		}
		System.out.println();
		try{
			System.out.println(it.next());
			System.out.println("JavaDoc non respectee!");
			System.out.println("Attention, il fallait une exception de type NoSuchElementException");
			System.out.println("Revoyez la methode next()");
			return;
		}catch (NoSuchElementException e){
			System.out.println("Le test avec l'arbre de l'exercice A a reussi!");
		}catch (Exception e){
			System.out.println("Il y a eu une exception inattendue apres le parcours complet de l'arbre");
			System.out.println("Il fallait une exception de type NoSuchElementException");
			System.out.println("Revoyez la methode next()");
			e.printStackTrace();
			return;
		}
		System.out.println();


		System.out.println("Test avec un arbre vide");
		a = arbreVide();
		try {
			it = a.preIterateur();
		}catch (Exception e){
			System.out.println("Il y a eu une exception inattendue lors de l'appel du constructeur avec un arbre vide");
			System.out.println("Revoyez le constructeur.");
			e.printStackTrace();
			return;
		}
		it = a.preIterateur();
		if(it.hasNext()){
			System.out.println("Attention, le test avec l'arbre vide a echoue!");
			System.out.println("La methode hasNext() a renvoye true.");

		}else{
			System.out.println("Le test avec l'arbre vide a reussi!");
		}

	}

	private static void testIterateurParNiveau() {

		System.out.println("Test avec l'arbre de l'exercice A");
		ArbreDEntiers a = arbre();
		try {
			Iterator<Integer> it = a.iterateurParNiveau();
			if (it == null) {
				System.out.println("Attention, vous avez oublie d'ecrire la methode iterateurParNiveau()");
				return;
			}
		}catch (Exception e){
			System.out.println("Il y a eu une exception inattendue lors de l'appel du constructeur");
			System.out.println("Revoyez le constructeur.");
			e.printStackTrace();
			return;
		}
		Iterator<Integer> it = a.iterateurParNiveau();
		int[] solution = {8,5,9,3,7,4,6,2};
		int i = 0;
		if(!it.hasNext()){
			System.out.println("Le test avec l'arbre de l'exercice A a echoue!");
			System.out.println("La methode hasNext() a renvoye false.");
			System.out.println("Revoyez l'iterateur");
			return;
		}
		while(it.hasNext()){
			int suivant = (Integer)it.next();
			if(suivant!=solution[i]) {
				System.out.println("Le suivant attendu est "+solution[i]);
				System.out.println("Le suivant recu est "+suivant);
				System.out.println("Revoyez l'iterateur");
				return;
			}
			i++;
			System.out.print(suivant + " ");
		}
		System.out.println();
		try{
			System.out.println(it.next());
			System.out.println("JavaDoc non respectee!");
			System.out.println("Attention, il fallait une exception de type NoSuchElementException");
			System.out.println("Revoyez la methode next()");
			return;
		}catch (NoSuchElementException e){
			System.out.println("Le test avec l'arbre de l'exercice A a reussi!");
		}catch (Exception e){
			System.out.println("Il y a eu une exception inattendue apres le parcours complet de l'arbre");
			System.out.println("Il fallait une exception de type NoSuchElementException");
			System.out.println("Revoyez la methode next()");
			e.printStackTrace();
			return;
		}
		System.out.println();


		System.out.println("Test avec un arbre vide");
		a = arbreVide();
		try {
			it = a.iterateurParNiveau();
		}catch (Exception e){
			System.out.println("Il y a eu une exception inattendue lors de l'appel du constructeur avec un arbre vide");
			System.out.println("Revoyez le constructeur.");
			e.printStackTrace();
			return;
		}
		it = a.iterateurParNiveau();
		if(it.hasNext()){
			System.out.println("Attention, le test avec l'arbre vide a echoue!");
			System.out.println("La methode hasNext() a renvoye true.");

		}else{
			System.out.println("Le test avec l'arbre vide a reussi!");
		}
	}

	private static void testIterateurInOrdre() {

		System.out.println("Test avec l'arbre de l'exercice A");
		ArbreDEntiers a = arbre();
		try {
			Iterator<Integer> it = a.iterator();
			if (it == null) {
				System.out.println("Attention, vous avez oublie d'ecrire la methode iterator()");
				return;
			}
		}catch (Exception e){
			System.out.println("Il y a eu une exception inattendue lors de l'appel du constructeur");
			System.out.println("Revoyez le constructeur.");
			e.printStackTrace();
			return;
		}
		Iterator<Integer> it = a.iterator();
		int[] solution = {3,5,6,7,8,9,2,4};;
		int i = 0;
		if(!it.hasNext()){
			System.out.println("Le test avec l'arbre de l'exercice A a echoue!");
			System.out.println("La methode hasNext() a renvoye false.");
			System.out.println("Revoyez l'iterateur");
			return;
		}
		while(it.hasNext()){
			int suivant = (Integer)it.next();
			if(suivant!=solution[i]) {
				System.out.println("Le suivant attendu est "+solution[i]);
				System.out.println("Le suivant recu est "+suivant);
				System.out.println("Revoyez l'iterateur");
				return;
			}
			i++;
			System.out.print(suivant + " ");
		}
		System.out.println();
		try{
			System.out.println(it.next());
			System.out.println("JavaDoc non respectee!");
			System.out.println("Attention, il fallait une exception de type NoSuchElementException");
			System.out.println("Revoyez la methode next()");
			return;
		}catch (NoSuchElementException e){
			System.out.println("Le test avec l'arbre de l'exercice A a reussi!");
		}catch (Exception e){
			System.out.println("Il y a eu une exception inattendue apres le parcours complet de l'arbre");
			System.out.println("Il fallait une exception de type NoSuchElementException");
			System.out.println("Revoyez la methode next()");
			e.printStackTrace();
			return;
		}
		System.out.println();

		System.out.println("Test via foreach");
		i = 0;
		for (int entier : a) {
			if(entier!=solution[i]){
				System.out.println("le parcours via un foreach a echoue");
			}
			i++;
		}
		System.out.println("le parcours via un foreach a reussi)");
		System.out.println();
		System.out.println("Test avec un arbre vide");
		a = arbreVide();
		try {
			it = a.iterator();
		}catch (Exception e){
			System.out.println("Il y a eu une exception inattendue lors de l'appel du constructeur avec un arbre vide");
			System.out.println("Revoyez le constructeur.");
			e.printStackTrace();
			return;
		}
		it = a.iterator();
		if(it.hasNext()){
			System.out.println("Attention, le test avec l'arbre vide a echoue!");
			System.out.println("La methode hasNext() a renvoye true.");

		}else{
			System.out.println("Le test avec l'arbre vide a reussi!");
		}

	}

	private static void testIterateurPostOrdre() {

		System.out.println("Test avec l'arbre de l'exercice A");
		ArbreDEntiers a = arbre();
		try {
			Iterator<Integer> it = a.postIterateur();
			if (it == null) {
				System.out.println("Attention, vous avez oublie d'ecrire la methode postIterateur()");
				return;
			}
		}catch (Exception e){
			System.out.println("Il y a eu une exception inattendue lors de l'appel du constructeur");
			System.out.println("Revoyez le constructeur.");
			e.printStackTrace();
			return;
		}
		Iterator<Integer> it = a.postIterateur();
		int[] solution = {3,6,7,5,2,4,9,8};
		int i = 0;
		if(!it.hasNext()){
			System.out.println("Le test avec l'arbre de l'exercice A a echoue!");
			System.out.println("La methode hasNext() a renvoye false.");
			System.out.println("Revoyez l'iterateur");
			return;
		}
		while(it.hasNext()){
			int suivant = (Integer)it.next();
			if(suivant!=solution[i]) {
				System.out.println("Le suivant attendu est "+solution[i]);
				System.out.println("Le suivant recu est "+suivant);
				System.out.println("Revoyez l'iterateur");
				return;
			}
			i++;
			System.out.print(suivant + " ");
		}
		System.out.println();
		try{
			System.out.println(it.next());
			System.out.println("JavaDoc non respectee!");
			System.out.println("Attention, il fallait une exception de type NoSuchElementException");
			System.out.println("Revoyez la methode next()");
			return;
		}catch (NoSuchElementException e){
			System.out.println("Le test avec l'arbre de l'exercice A a reussi!");
		}catch (Exception e){
			System.out.println("Il y a eu une exception inattendue apres le parcours complet de l'arbre");
			System.out.println("Il fallait une exception de type NoSuchElementException");
			System.out.println("Revoyez la methode next()");
			e.printStackTrace();
			return;
		}
		System.out.println();

		System.out.println("Test avec un arbre vide");
		a = arbreVide();
		try {
			it = a.postIterateur();
		}catch (Exception e){
			System.out.println("Il y a eu une exception inattendue lors de l'appel du constructeur avec un arbre vide");
			System.out.println("Revoyez le constructeur.");
			e.printStackTrace();
			return;
		}
		it = a.postIterateur();
		if(it.hasNext()){
			System.out.println("Attention, le test avec l'arbre vide a echoue!");
			System.out.println("La methode hasNext() a renvoye true.");

		}else{
			System.out.println("Le test avec l'arbre vide a reussi!");
		}


	}

}
