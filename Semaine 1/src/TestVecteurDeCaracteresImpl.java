import java.util.Scanner;

public class TestVecteurDeCaracteresImpl {
	/**
	 * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
	 * 
	 * @param messageErreur message a afficher en cas de probleme
	 * @param attendu la valeur qu'on s'attendait a recevoir
	 * @param recu la valeur qu'on a reçu en realite
	 */
	private static void assertEquals(String messageErreur, Object attendu, Object recu) {
		if (attendu==null) {
			if (recu!=null) {
				System.out.println(messageErreur+". Attendu="+attendu+" recu="+recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {
			System.out.println(messageErreur+". Attendu="+attendu+" recu="+recu);
			System.exit(0);			
		}
	}
	
	private final static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {	
		
		System.out.println("*****************************************************");
		System.out.println("Programme Test pour la classe VecteurDeCaracteresImpl");
		System.out.println("*****************************************************");
	
		int choix = 0;
		do {
			System.out.println();
			System.out.println("1 -> Tester la methode estVide()");
			System.out.println("2 -> Tester la methode element()");
			System.out.println("3 -> Tester la methode insere()");			
			System.out.println("4 -> Tester la methode ajoute()'");
			System.out.println("5 -> Tester la methode remplace()");
			System.out.println("6 -> Tester la methode supprime()");
			System.out.println();
			System.out.print("Votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
			case 1:
				testEstVide();
				break;
			case 2:
				testElement();
				break;
			case 3:				
				testInsere();
				break;
			case 4:
				testAjoute();
				break;
			case 5:
				testRemplace();
				break;
			case 6:
				testSupprime();
				break;
		
			default:
				break;
			}

		} while (choix >= 1 && choix <= 6);
	}

	private static void testEstVide() {
		VecteurDeCaracteresImpl vVide=new VecteurDeCaracteresImpl();
		try{
			assertEquals("KO : vecteur vide", true, vVide.estVide());
		}catch (Exception e) {
			System.out.println("KO : vecteur vide : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		char[] tABC = {'a','b','c'};
		VecteurDeCaracteresImpl vABC5=new VecteurDeCaracteresImpl(5,tABC);
		try{
			assertEquals("KO : vecteur : a b c", false, vABC5.estVide());
		}catch (Exception e) {
			System.out.println("KO : vecteur : a b c : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("tous les tests ont reussi");
	}

	private static void testElement() {
		char[] tABC = {'a','b','c'};
		VecteurDeCaracteresImpl vABC5=new VecteurDeCaracteresImpl(5,tABC);
		
		
		try{
			assertEquals("KO : vecteur : a b c - element(0)",'a' , vABC5.element(0));
			assertEquals("KO : la methode element() ne modifie pas la taille de la table", 3, vABC5.taille());
			assertEquals("KO : la methode element() ne modifie pas le contenu de la table", "'a' 'b' 'c'", vABC5.toString());
		}catch (VecteurOutException e){
			System.out.println("KO : vecteur : a b c - element(0) : Il ne fallait pas de VecteurOutException");
			System.exit(0);
		}catch (Exception e) {
			System.out.println("KO : vecteur : a b c - element(0) : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		
		
		try{
			assertEquals("KO : vecteur : a b c - element(1)",'b' , vABC5.element(1));
		}catch (VecteurOutException e){
			System.out.println("KO : vecteur : a b c - element(1) : Il ne fallait pas de VecteurOutException");
			System.exit(0);
		}catch (Exception e) {
			System.out.println("KO : vecteur : a b c - element(1) : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		
		
		try{
			assertEquals("KO : vecteur : a b c - element(2)",'c' , vABC5.element(2));
		}catch (VecteurOutException e){
			System.out.println("KO : vecteur : a b c - element(2) : Il ne fallait pas de VecteurOutException");
			System.exit(0);
		}catch (Exception e) {
			System.out.println("KO : vecteur : a b c - element(2) : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		
		
		try{
			vABC5.element(3);
			System.out.println("KO : vecteur : a b c - element(3) : il fallait une VecteurOutException");
			System.exit(0);
		}catch (VecteurOutException e){
					
		}catch (Exception e) {
			System.out.println("KO : vecteur : a b c - element(3) : il fallait une VecteurOutException");
			e.printStackTrace();
			System.exit(0);
		}
		
		try{
			vABC5.element(-1);
			System.out.println("KO : vecteur : a b c - element(-1) : il fallait une VecteurOutException");
			System.exit(0);
		}catch (VecteurOutException e){
					
		}catch (Exception e) {
			System.out.println("KO : vecteur : a b c - element(-1) : il fallait une VecteurOutException");
			e.printStackTrace();
			System.exit(0);
		}
		
		VecteurDeCaracteresImpl vVide=new VecteurDeCaracteresImpl();
		try{
			vVide.element(0);
			System.out.println("KO : vecteur vide - element(0) : il fallait une VecteurOutException");
			System.exit(0);
		}catch (VecteurOutException e){
					
		}catch (Exception e) {
			System.out.println("KO : vecteur vide - element(0) : il fallait une VecteurOutException");
			e.printStackTrace();
			System.exit(0);
		}
		
		System.out.println("tous les tests ont reussi");
		
	}

	private static void testInsere() {
		char[] tABC = {'a','b','c'};
		VecteurDeCaracteresImpl vABC5;
		vABC5=new VecteurDeCaracteresImpl(5,tABC);
		

		try{
			vABC5.insere(1, 'x');
			assertEquals("KO : vecteur de capacite 5 : a b c - insere(1,'x') : contenu ko", "'a' 'x' 'b' 'c'", vABC5.toString());
			assertEquals("KO : vecteur de capacite 5 : a b c - insere(1,'x') : taille ko", 4, vABC5.taille());
			
		}catch (VecteurOutException e){
			System.out.println("KO : vecteur de capacite 5 : a b c - insere(1,'x') : Il ne fallait pas de VecteurOutException");
			System.exit(0);
		}catch (Exception e) {
			System.out.println("KO : vecteur de capacite 5 : a b c - insere(1,'x') : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		
		vABC5=new VecteurDeCaracteresImpl(5,tABC);
		try{
			vABC5.insere(2, 'x');
			assertEquals("KO : vecteur de capacite 5 : a b c - insere(2,'x') : contenu ko", "'a' 'b' 'x' 'c'", vABC5.toString());
			assertEquals("KO : vecteur de capacite 5 : a b c - insere(2,'x') : taille ko", 4, vABC5.taille());
			
		}catch (VecteurOutException e){
			System.out.println("KO : vecteur de capacite 5 : a b c - insere(2,'x') : Il ne fallait pas de VecteurOutException");
			System.exit(0);
		}catch (Exception e) {
			System.out.println("KO : vecteur de capacite 5: a b c - insere(2,'x') : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		
		// insertion au debut
		vABC5=new VecteurDeCaracteresImpl(5,tABC);
		try{
			vABC5.insere(0, 'x');
			assertEquals("KO : vecteur : a b c de capacite 5 - insere(0,'x') : contenu ko", "'x' 'a' 'b' 'c'", vABC5.toString());
			assertEquals("KO : vecteur : a b c de capacite 5 - insere(0,'x') : taille ko", 4, vABC5.taille());
			
		}catch (VecteurOutException e){
			System.out.println("KO : vecteur : a b c de capacite 5 - insere(0,'x') : Il ne fallait pas de VecteurOutException");
			System.exit(0);
		}catch (Exception e) {
			System.out.println("KO : vecteur : a b c de capacite 5 - insere(0,'x') : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		
		// insertion en toute fin
		vABC5=new VecteurDeCaracteresImpl(5,tABC);
		try{
			vABC5.insere(3, 'x');
			assertEquals("KO : vecteur : a b c de capacite 5 - insere(3,'x') : contenu ko", "'a' 'b' 'c' 'x'", vABC5.toString());
			assertEquals("KO : vecteur : a b c de capacite 5 - insere(3,'x') : taille ko", 4, vABC5.taille());
			
		}catch (VecteurOutException e){
			System.out.println("KO : vecteur : a b c de capacite 5 - insere(3,'x') : Il ne fallait pas de VecteurOutException");
			System.exit(0);
		}catch (Exception e) {
			System.out.println("KO : vecteur : a b c de capacite 5 - insere(3,'x') : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		
		// taille logique = 3, taille physique = 4, insertion possible!
		VecteurDeCaracteresImpl vABC4;
		vABC4=new VecteurDeCaracteresImpl(4,tABC);
		try{
			vABC4.insere(2, 'x');
			assertEquals("KO : vecteur de capacite 4 : a b c - insere(2,'x') : contenu ko", "'a' 'b' 'x' 'c'", vABC4.toString());
			assertEquals("KO : vecteur : a b c de capacite 4 - insere(2,'x') : taille ko", 4, vABC4.taille());
			
		}catch (VecteurOutException e){
			System.out.println("KO : vecteur : a b c de capacite 4 - insere(2,'x') : Il ne fallait pas de VecteurOutException");
			System.exit(0);
		}catch (Exception e) {
			System.out.println("KO : vecteur : a b c de capacite 4 - insere(2,'x') : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		
		
		
		VecteurDeCaracteresImpl vVide=new VecteurDeCaracteresImpl();
		try{
			vVide.insere(0, 'x');
			assertEquals("KO : vecteur vide - insere(0,'x') : contenu ko", "'x'", vVide.toString());
			assertEquals("KO : vecteur vide - insere(0,'x') : taille ko", 1, vVide.taille());
			
		}catch (VecteurOutException e){
			System.out.println("KO : vecteur vide - insere(0,'x') : Il ne fallait pas de VecteurOutException");
			System.exit(0);
		}catch (Exception e) {
			System.out.println("KO : vecteur vide - insere(0,'x') : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		
		
		// insertion en -1!
		vABC5=new VecteurDeCaracteresImpl(5,tABC);
		try{
			vABC5.insere(-1, 'x');
			System.out.println("KO : vecteur : a b c - insere(-1,'x') : il fallait une VecteurOutException");
			System.exit(0);
			
		}catch (VecteurOutException e){
			assertEquals("KO : vecteur : a b c - insere(-1,'x') : le contenu a ete modifie", "'a' 'b' 'c'", vABC5.toString());
			assertEquals("KO : vecteur : a b c - insere(-1,'x') : la taille a ete modifiee", 3, vABC5.taille());
		}catch (Exception e) {
			System.out.println("KO : vecteur : a b c - insere(-1,'x') : il fallait une VecteurOutException");
			e.printStackTrace();
			System.exit(0);
		}
		
		// insertion avec trou!
		vABC5=new VecteurDeCaracteresImpl(5,tABC);
		try{
			vABC5.insere(4, 'x');
			System.out.println("KO : vecteur : a b c - insere(4,'x') : il fallait une VecteurOutException");
			System.exit(0);

		}catch (VecteurOutException e){
			assertEquals("KO : vecteur : a b c - insere(4,'x') : le contenu a ete modifie", "'a' 'b' 'c'", vABC5.toString());
			assertEquals("KO : vecteur : a b c - insere(4,'x') : la taille a ete modifiee", 3, vABC5.taille());
		}catch (Exception e) {
			System.out.println("KO : vecteur : a b c - insere(4,'x') : il fallait une VecteurOutException");
			e.printStackTrace();
			System.exit(0);
		}
		
		// agrandissement de table
		VecteurDeCaracteresImpl vABC3=new VecteurDeCaracteresImpl(3,tABC);
		try{
			vABC3.insere(1, 'x');
			assertEquals("KO : vecteur de capacite 3 : a b c - insere(1,'x') la table doit etre agrandie : contenu ko", "'a' 'x' 'b' 'c'", vABC3.toString());
			assertEquals("KO : vecteur de capacite 3 : a b c - insere(1,'x') : taille ko", 4, vABC3.taille());
			
		}catch (VecteurOutException e){
			System.out.println("KO : vecteur de capacite 3 : a b c - insere(1,'x') : Il ne fallait pas de VecteurOutException");
			System.exit(0);
		}catch (Exception e) {
			System.out.println("KO : vecteur de capacite 3 : a b c - insere(1,'x') : il y a eu une exception non prevue");
			System.out.println("Avez-vous pense a agrandir la table?");
			e.printStackTrace();
			System.exit(0);
		}
		
		System.out.println("tous les tests ont reussi");

	}

	private static void testAjoute() {
		char[] tABC = {'a','b','c'};
		VecteurDeCaracteresImpl vABC5=new VecteurDeCaracteresImpl(5,tABC);
		try{
			vABC5.ajoute('x');
			assertEquals("KO : vecteur : a b c - ajoute('x') : contenu ko", "'a' 'b' 'c' 'x'", vABC5.toString());
			assertEquals("KO : vecteur : a b c - ajoute('x') : taille ko", 4, vABC5.taille());
			
		}catch (VecteurOutException e){
			System.out.println("KO : vecteur : a b c - ajoute('x') : Il ne fallait pas de VecteurOutException");
			System.exit(0);
		}catch (Exception e) {
			System.out.println("KO : vecteur : a b c - ajoute('x') : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		
		
		VecteurDeCaracteresImpl vVide=new VecteurDeCaracteresImpl();
		try{
			vVide.ajoute('x');
			assertEquals("KO : vecteur vide - ajoute('x') : contenu ko", "'x'", vVide.toString());
			assertEquals("KO : vecteur vide - ajoute('x') : taille ko", 1, vVide.taille());
			
		}catch (VecteurOutException e){
			System.out.println("KO : vecteur vide - ajoute('x') : Il ne fallait pas de VecteurOutException");
			System.exit(0);
		}catch (Exception e) {
			System.out.println("KO : vecteur vide - ajoute('x') : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		
		// agrandissement de table
		VecteurDeCaracteresImpl vABC3=new VecteurDeCaracteresImpl(3,tABC);
		try{
			vABC3.ajoute('x');
			assertEquals("KO : vecteur de capacite 3 : a b c - ajoute('x') la table doit etre agrandie : contenu ko", "'a' 'b' 'c' 'x'", vABC3.toString());
			assertEquals("KO : vecteur de capacite 3 : a b c - ajoute('x') : taille ko", 4, vABC3.taille());

		}catch (VecteurOutException e){
			System.out.println("KO : vecteur de capacite 3 : a b c - ajoute('x') : Il ne fallait pas de VecteurOutException");
			System.exit(0);
		}catch (Exception e) {
			System.out.println("KO : vecteur de capacite 3 : a b c - ajoute('x') : il y a eu une exception non prevue");
			System.out.println("Avez-vous pense a agrandir la table?");
			e.printStackTrace();
			System.exit(0);
		}

		System.out.println("tous les tests ont reussi");

		
	}

	private static void testRemplace() {
		char[] tABC = {'a','b','c'};
		VecteurDeCaracteresImpl vABC5;
		
		vABC5=new VecteurDeCaracteresImpl(5,tABC);
		try{
			assertEquals("KO : vecteur : a b c - remplace(1,'x') : caractere renvoye", 'b',vABC5.remplace(1, 'x'));
			assertEquals("KO : vecteur : a b c - remplace(1,'x') : contenu ko", "'a' 'x' 'c'", vABC5.toString());
			assertEquals("KO : vecteur : a b c - remplace(1,'x') : taille ko", 3, vABC5.taille());
			
		}catch (VecteurOutException e){
			System.out.println("KO : vecteur : a b c - remplace(1,'x') : Il ne fallait pas de VecteurOutException");
			System.exit(0);
		}catch (Exception e) {
			System.out.println("KO : vecteur : a b c - remplace(1,'x') : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		
		// le premier
		vABC5=new VecteurDeCaracteresImpl(5,tABC);
		try{
			assertEquals("KO : vecteur : a b c - remplace(0,'x') : caractere renvoye", 'a',vABC5.remplace(0, 'x'));
			assertEquals("KO : vecteur : a b c - remplace(0,'x') : contenu ko", "'x' 'b' 'c'", vABC5.toString());
			assertEquals("KO : vecteur : a b c - remplace(0,'x') : taille ko", 3, vABC5.taille());
			
		}catch (VecteurOutException e){
			System.out.println("KO : vecteur : a b c - remplace(0,'x') : Il ne fallait pas de VecteurOutException");
			System.exit(0);
		}catch (Exception e) {
			System.out.println("KO : vecteur : a b c - remplace(0,'x') : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		
		// le dernier
		vABC5=new VecteurDeCaracteresImpl(5,tABC);
		try{
			assertEquals("KO : vecteur : a b c - remplace(2,'x') : caractere renvoye", 'c',vABC5.remplace(2, 'x'));
			assertEquals("KO : vecteur : a b c - remplace(2,'x') : contenu ko", "'a' 'b' 'x'", vABC5.toString());
			assertEquals("KO : vecteur : a b c - remplace(2,'x') : taille ko", 3, vABC5.taille());
			
		}catch (VecteurOutException e){
			System.out.println("KO : vecteur : a b c - remplace(2,'x') : Il ne fallait pas de VecteurOutException");
			System.exit(0);
		}catch (Exception e) {
			System.out.println("KO : vecteur : a b c - remplace(2,'x') : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		
		// remplace en -1!
		vABC5=new VecteurDeCaracteresImpl(5,tABC);
		try{
			vABC5.remplace(-1, 'x');
			System.out.println("KO : vecteur : a b c - remplace(-1,'x') : il fallait une VecteurOutException");
			System.exit(0);

		}catch (VecteurOutException e){
			assertEquals("KO : vecteur : a b c - remplace(-1,'x') : le contenu a ete modifie", "'a' 'b' 'c'", vABC5.toString());
			assertEquals("KO : vecteur : a b c - remplace(-1,'x') : la taille a ete modifiee", 3, vABC5.taille());
		}catch (Exception e) {
			System.out.println("KO : vecteur : a b c - remplace(-1,'x') : il fallait une VecteurOutException");
			e.printStackTrace();
			System.exit(0);
		}
		// remplace hors vecteur!
		vABC5=new VecteurDeCaracteresImpl(5,tABC);
		try{
			vABC5.remplace(3, 'x');
			System.out.println("KO : vecteur : a b c - remplace(3,'x') : il fallait une VecteurOutException");
			System.exit(0);

		}catch (VecteurOutException e){
			assertEquals("KO : vecteur : a b c - remplace(3,'x') : le contenu a ete modifie", "'a' 'b' 'c'", vABC5.toString());
			assertEquals("KO : vecteur : a b c - remplace(3,'x') : la taille a ete modifiee", 3, vABC5.taille());
		}catch (Exception e) {
			System.out.println("KO : vecteur : a b c - remplace(3,'x') : il fallait une VecteurOutException");
			e.printStackTrace();
			System.exit(0);
		}
		
		System.out.println("tous les tests ont reussi");
	}

	private static void testSupprime() {
		char[] tABC = {'a','b','c'};
		VecteurDeCaracteresImpl vABC5;
		
		vABC5=new VecteurDeCaracteresImpl(5,tABC);
		try{
			assertEquals("KO : vecteur de capacite 5 : a b c - supprime(1) : caractere renvoye", 'b',vABC5.supprime(1));
			assertEquals("KO : vecteur de capacite 5 : a b c - supprime(1) : contenu ko", "'a' 'c'", vABC5.toString());
			assertEquals("KO : vecteur de capacite 5 : a b c - supprime(1) : taille ko", 2, vABC5.taille());
			
		}catch (VecteurOutException e){
			System.out.println("KO : vecteur de capacite 5 : a b c - supprime(1) : Il ne fallait pas de VecteurOutException");
			System.exit(0);
		}catch (Exception e) {
			System.out.println("KO : vecteur de capacite 5 : a b c - supprime(1) : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		
		// le premier
		vABC5=new VecteurDeCaracteresImpl(5,tABC);
		try{
			assertEquals("KO : vecteur de capacite 5 : a b c - supprime(0) : caractere renvoye", 'a',vABC5.supprime(0));
			assertEquals("KO : vecteur de capacite 5 : a b c - supprime(0) : contenu ko", "'b' 'c'", vABC5.toString());
			assertEquals("KO : vecteur de capacite 5 : a b c - supprime(0) : taille ko", 2, vABC5.taille());
			
		}catch (VecteurOutException e){
			System.out.println("KO : vecteur de capacite 5 : a b c - supprime(0) : Il ne fallait pas de VecteurOutException");
			System.exit(0);
		}catch (Exception e) {
			System.out.println("KO : vecteur de capacite 5 : a b c - supprime(0) : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		
		// le dernier
		vABC5=new VecteurDeCaracteresImpl(5,tABC);
		try{
			assertEquals("KO : vecteur : a b c de capacite 5 - supprime(2) : caractere renvoye", 'c',vABC5.supprime(2));
			assertEquals("KO : vecteur : a b c de capacite 5 - supprime(2) : contenu ko", "'a' 'b'", vABC5.toString());
			assertEquals("KO : vecteur : a b c de capacite 5 - supprime(2) : taille ko", 2, vABC5.taille());
			
		}catch (VecteurOutException e){
			System.out.println("KO : vecteur : a b c de capacite 5 - supprime(2) : Il ne fallait pas de VecteurOutException");
			System.exit(0);
		}catch (Exception e) {
			System.out.println("KO : vecteur : a b c de capacite 5 - supprime(2) : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		
		// taille logique = taille physique
		VecteurDeCaracteresImpl vABC3 = new VecteurDeCaracteresImpl(3,tABC);
		try{
			assertEquals("KO : vecteur : a b c de capacite 3 - supprime(1) : caractere renvoye", 'b',vABC3.supprime(1));
			assertEquals("KO : vecteur : a b c de capacite 3 - supprime(1) : contenu ko", "'a' 'c'", vABC3.toString());
			assertEquals("KO : vecteur : a b c de capacite 3 - supprime(1) : taille ko", 2, vABC3.taille());

		}catch (VecteurOutException e){
			System.out.println("KO : vecteur : a b c de capacite 3 - supprime(1) : Il ne fallait pas de VecteurOutException");
			System.exit(0);
		}catch (Exception e) {
			System.out.println("KO : vecteur : a b c de capacite 3 - supprime(1) : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		
		// supprime en -1!
		vABC5=new VecteurDeCaracteresImpl(5,tABC);
		try{
			vABC5.supprime(-1);
			System.out.println("KO : vecteur : a b c - supprime(-1) : il fallait une VecteurOutException");
			System.exit(0);

		}catch (VecteurOutException e){
			assertEquals("KO : vecteur : a b c - supprime(-1) : le contenu a ete modifie", "'a' 'b' 'c'", vABC5.toString());
			assertEquals("KO : vecteur : a b c - supprime(-1) : la taille a ete modifiee", 3, vABC5.taille());
		}catch (Exception e) {
			System.out.println("KO : vecteur : a b c - supprime(-1) : il fallait une VecteurOutException");
			e.printStackTrace();
			System.exit(0);
		}
		
		// supprime hors vecteur!
		vABC5=new VecteurDeCaracteresImpl(5,tABC);
		try{
			vABC5.supprime(3);
			System.out.println("KO : vecteur : a b c - supprime(3) : il fallait une VecteurOutException");
			System.exit(0);

		}catch (VecteurOutException e){
			assertEquals("KO : vecteur : a b c - supprime(3) : le contenu a ete modifie", "'a' 'b' 'c'", vABC5.toString());
			assertEquals("KO : vecteur : a b c - supprime(3) : la taille a ete modifiee", 3, vABC5.taille());
		}catch (Exception e) {
			System.out.println("KO : vecteur : a b c - supprime(3) : il fallait une VecteurOutException");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("tous les tests ont reussi");
		
	}
	
}


