
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Scanner;

public class TestFileImplViaTable{
	private static Scanner scanner = new Scanner(System.in);
	static Class classe = FileImplViaTable.class;
	static Field t ;
	static Field indiceTete;
	static Field taille;
	
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
				
				System.out.println("     "+messageErreur+". Attendu="+attendu+" recu="+recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {
			
			System.out.println("    "+messageErreur+". Attendu="+attendu+" recu="+recu);
			System.exit(0);			
		}
	}
	
	/**
	 * Cette methode verifie qu'un resultat obtenu est bien un des 2 resultats attendus.
	 * 
	 * @param messageErreur message a afficher en cas de probleme
	 * @param attendu1 une valeur qu'on s'attendait a recevoir
	 * @param attendu2 une autre valeur qu'on s'attendait a recevoir
	 * @param recu la valeur qu'on a reçu en realite
	 */
	private static void assertEquals(String messageErreur, Object attendu1, Object attendu2, Object recu) {
		if (attendu1==null || attendu2==null) {
			if (recu!=null) {

				System.out.println("     "+messageErreur+". Attendu="+attendu1+ " ou "+attendu2+" recu="+recu);
				System.exit(0);
			}
		} else if (!attendu1.equals(recu)&&!attendu2.equals(recu)) {

			System.out.println("     "+messageErreur+". Attendu="+attendu1+ " ou "+attendu2+" recu="+recu);
			System.exit(0);			
		}
	}


	public static void main(String[] args) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {	
		System.out.println("**********************************************");
		System.out.println("Programme Test pour la classe FileImplViaTable");
		System.out.println("**********************************************");
		int choix = 0;
		t = classe.getDeclaredField("table");
		t.setAccessible(true);
		indiceTete = classe.getDeclaredField("indiceTete");
		indiceTete.setAccessible(true);
		taille = classe.getDeclaredField("taille");
		taille.setAccessible(true);
		do {
			System.out.println();
			System.out.println("1 -> Tester la methode enfile()");
			System.out.println("2 -> Tester la methode defile()");
			System.out.println("3 -> Tester l'ex A1");
			System.out.println();
			System.out.print("Votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
			case 1:
				testEnfile();
				break;
			case 2:
				testDefile();
				break;
			case 3:
				testA1();
				break;
			}

		} while (choix >= 1 && choix <= 2);
	}


	private static void testEnfile() throws IllegalArgumentException, IllegalAccessException {
		testEx1();
		testEx2();
		testEx3();
		testEx5();
		testEx6();
		testEx7();
		testEx8();
		System.out.println("Tous les tests ont reussi!");		
	}
	



	private static void testDefile() throws IllegalArgumentException, IllegalAccessException {
		testEx4();
		testEx9();
		testEx10();
		System.out.println("Tous les tests ont reussi!");		
	}
	
	private static void testEx1() throws IllegalArgumentException, IllegalAccessException{
		System.out.print("Exemple 1 (FileViaTable.pptx)");
		Character[] tableTestee = {null,null,null,null};
		FileImplViaTable<Character> file = new FileImplViaTable<Character>();
		indiceTete.setInt(file, 0);
		taille.setInt(file, 0);
		t.set(file, tableTestee);
		try{
		file.enfile('a');
		assertEquals(" : ko  taille (logique) ko :", 1, taille.getInt(file));
		assertEquals(" : ko  taille (physique) ko :", 4, ((Object[])t.get(file)).length);
		assertEquals(" : ko  indiceTete ko", 0, indiceTete.getInt(file)); 
		assertEquals(" : ko  contenu table ko", "[a, null, null, null]",Arrays.toString((Object[])t.get(file))); 
		}catch (Exception e){
			System.out.println(" : ko");
			System.out.println("Il y a eu une exception non attendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println(" : ok");
		
	}
	
	private static void testEx2() throws IllegalArgumentException, IllegalAccessException {
		System.out.print("Exemple 2 (FileViaTable.pptx)");
		Character[] tableTestee = {'a',null,null,null};
		FileImplViaTable<Character> file = new FileImplViaTable<Character>();
		indiceTete.setInt(file, 0);
		taille.setInt(file, 1);
		t.set(file, tableTestee);
		try{
		file.enfile('b');
		assertEquals(" : ko  taille (logique) ko :", 2, taille.getInt(file));
		assertEquals(" : ko  taille (physique) ko :", 4, ((Object[])t.get(file)).length);
		assertEquals(" : ko  indiceTete ko", 0, indiceTete.getInt(file)); 
		assertEquals(" : ko  contenu table ko", "[a, b, null, null]",Arrays.toString((Object[])t.get(file))); 
		}catch (Exception e){
			System.out.println(" : ko");
			System.out.println("Il y a eu une exception non attendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println(" : ok");
	
	}
	
	private static void testEx3() throws IllegalArgumentException, IllegalAccessException {
		System.out.print("Exemple 3 (FileViaTable.pptx)");
		Character[] tableTestee = {'a','b',null,null};
		FileImplViaTable<Character> file = new FileImplViaTable<Character>();
		indiceTete.setInt(file, 0);
		taille.setInt(file, 2);
		t.set(file, tableTestee);
		try{
		file.enfile('c');
		assertEquals(" : ko  taille (logique) ko :", 3, taille.getInt(file));
		assertEquals(" : ko  taille (physique) ko :", 4, ((Object[])t.get(file)).length);
		assertEquals(" : ko  indiceTete ko", 0, indiceTete.getInt(file)); 
		assertEquals(" : ko  contenu table ko", "[a, b, c, null]",Arrays.toString((Object[])t.get(file))); 
		}catch (Exception e){
			System.out.println(" : ko");
			System.out.println("Il y a eu une exception non attendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println(" : ok");
		
	}
	
	private static void testEx4() throws IllegalArgumentException, IllegalAccessException {
		System.out.print("Exemple 4 (FileViaTable.pptx)");
		Character[] tableTestee = {'a','b','c',null};
		FileImplViaTable<Character> file = new FileImplViaTable<Character>();
		indiceTete.setInt(file, 0);
		taille.setInt(file, 3);
		t.set(file, tableTestee);
		try{
		Character car =  file.defile();
		assertEquals(" : ko  caractere renvoye ko :", 'a', car);
		assertEquals(" : ko  taille (logique) ko :", 2, taille.getInt(file));
		assertEquals(" : ko  taille (physique) ko :", 4, ((Object[])t.get(file)).length);
		assertEquals(" : ko  indiceTete ko", 1, indiceTete.getInt(file)); 
		assertEquals(" : ko  contenu table ko", "[null, b, c, null]","[a, b, c, null]",Arrays.toString((Object[])t.get(file))); 
		}catch (Exception e){
			System.out.println(" : ko");
			System.out.println("Il y a eu une exception non attendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println(" : ok");
	}
	
	private static void testEx5() throws IllegalArgumentException, IllegalAccessException {
		System.out.print("Exemple 5 (FileViaTable.pptx)");
		Character[] tableTestee = {null,null,'a','b'};
		FileImplViaTable<Character> file = new FileImplViaTable<Character>();
		indiceTete.setInt(file, 2);
		taille.setInt(file, 2);
		t.set(file, tableTestee);
		try{
		file.enfile('c');
		assertEquals(" : ko  taille (logique) ko :", 3, taille.getInt(file));
		assertEquals(" : ko  taille (physique) ko :", 4, ((Object[])t.get(file)).length);
		assertEquals(" : ko  indiceTete ko", 2, indiceTete.getInt(file)); 
		assertEquals(" : ko  contenu table ko", "[c, null, a, b]",Arrays.toString((Object[])t.get(file))); 
		}catch (Exception e){
			System.out.println(" : ko");
			System.out.println("Il y a eu une exception non attendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println(" : ok");
		
	}
	
	private static void testEx6() throws IllegalArgumentException, IllegalAccessException {
		System.out.print("Exemple 6 (FileViaTable.pptx)");
		Character[] tableTestee = {'c',null,'a','b'};
		FileImplViaTable<Character> file = new FileImplViaTable<Character>();
		indiceTete.setInt(file, 2);
		taille.setInt(file, 3);
		t.set(file, tableTestee);
		try{
		file.enfile('d');
		assertEquals(" : ko  taille (logique) ko :", 4, taille.getInt(file));
		assertEquals(" : ko  taille (physique) ko :", 4, ((Object[])t.get(file)).length);
		assertEquals(" : ko  indiceTete ko", 2, indiceTete.getInt(file)); 
		assertEquals(" : ko  contenu table ko", "[c, d, a, b]",Arrays.toString((Object[])t.get(file))); 
		}catch (Exception e){
			System.out.println(" : ko");
			System.out.println("Il y a eu une exception non attendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println(" : ok");
		
		
	}
	
	private static void testEx7() throws IllegalArgumentException, IllegalAccessException {
		System.out.print("Exemple 7 (FileViaTable.pptx)");
		Character[] tableTestee = {'c','d','a','b'};
		FileImplViaTable<Character> file = new FileImplViaTable<Character>();
		indiceTete.setInt(file, 2);
		taille.setInt(file, 4);
		t.set(file, tableTestee);
		try{
		file.enfile('e');
		assertEquals(" : ko  taille (logique) ko :", 5, taille.getInt(file));
		assertEquals(" : ko  taille (physique) ko :", 8, ((Object[])t.get(file)).length);
		assertEquals(" : ko  indiceTete ko", 0, indiceTete.getInt(file)); 
		assertEquals(" : ko  contenu table ko", "[a, b, c, d, e, null, null, null]",Arrays.toString((Object[])t.get(file))); 
		}catch (Exception e){
			System.out.println(" : ko");
			System.out.println("Il y a eu une exception non attendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println(" : ok");
		
	}
	
	private static void testEx8() throws IllegalArgumentException, IllegalAccessException {
		System.out.print("Exemple 8 (FileViaTable.pptx)");
		Character[] tableTestee = {'b','c','d','a'};
		FileImplViaTable<Character> file = new FileImplViaTable<Character>();
		indiceTete.setInt(file, 3);
		taille.setInt(file, 4);
		t.set(file, tableTestee);
		try{
		file.enfile('e');
		assertEquals(" : ko  taille (logique) ko :", 5, taille.getInt(file));
		assertEquals(" : ko  taille (physique) ko :", 8, ((Object[])t.get(file)).length);
		assertEquals(" : ko  indiceTete ko", 0, indiceTete.getInt(file)); 
		assertEquals(" : ko  contenu table ko", "[a, b, c, d, e, null, null, null]",Arrays.toString((Object[])t.get(file))); 
		}catch (Exception e){
			System.out.println(" : ko");
			System.out.println("Il y a eu une exception non attendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println(" : ok");
		
	}
	
	private static void testEx9() throws IllegalArgumentException, IllegalAccessException {
		System.out.print("Exemple 9 (FileViaTable.pptx)");
		Character[] tableTestee = {'c',null,'a','b'};
		FileImplViaTable<Character> file = new FileImplViaTable<Character>();
		indiceTete.setInt(file, 2);
		taille.setInt(file, 3);
		t.set(file, tableTestee);
		try{
		Character car =  file.defile();
		assertEquals(" : ko  caractere renvoye ko :", 'a', car);
		assertEquals(" : ko  taille (logique) ko :", 2, taille.getInt(file));
		assertEquals(" : ko  taille (physique) ko :", 4, ((Object[])t.get(file)).length);
		assertEquals(" : ko  indiceTete ko", 3, indiceTete.getInt(file)); 
		assertEquals(" : ko  contenu table ko", "[c, null, null, b]","[c, null, a, b]",Arrays.toString((Object[])t.get(file))); 
		}catch (Exception e){
			System.out.println(" : ko");
			System.out.println("Il y a eu une exception non attendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println(" : ok");
	}
	
	private static void testEx10() throws IllegalArgumentException, IllegalAccessException {
		System.out.print("Exemple 10 (FileViaTable.pptx)");
		Character[] tableTestee = {'c',null,null,'b'};
		FileImplViaTable<Character> file = new FileImplViaTable<Character>();
		indiceTete.setInt(file, 3);
		taille.setInt(file, 2);
		t.set(file, tableTestee);
		try{
		Character car =  file.defile();
		assertEquals(" : ko  caractere renvoye ko :", 'b', car);
		assertEquals(" : ko  taille (logique) ko :", 1, taille.getInt(file));
		assertEquals(" : ko  taille (physique) ko :", 4, ((Object[])t.get(file)).length);
		assertEquals(" : ko  indiceTete ko", 0, indiceTete.getInt(file)); 
		assertEquals(" : ko  contenu table ko", "[c, null, null, null]","[c, null, null, b]",Arrays.toString((Object[])t.get(file))); 
		}catch (Exception e){
			System.out.println(" : ko");
			System.out.println("Il y a eu une exception non attendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println(" : ok");
	}

	

	private static void testA1() {
		Character c;
		Character[] table;
		FileImplViaTable<Character> file = new FileImplViaTable<Character>();

		// test 1
		try {
			c =  file.defile();
			System.out.println("test 1 (exA1) KO : Il fallait une exception");
			return;
			
		} catch (FileVideException e) {

		}catch (Exception e) {
			System.out.println("test 1 (exA1) KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 1 OK");

		// test 2
		try {
			c = file.premier();
			System.out.println("test 2 (exA1) KO : Il fallait une exception");
			return;
			
		} catch (FileVideException e) {

		}catch (Exception e) {
			System.out.println("test 2 (exA1) KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 2 OK");

		// test 3
		try{
		file.enfile('a');
		if(file.taille()!=1){
			System.out.println("test 3 (exA1) KO : taille KO");
			return;
		}
		table=objectsToCharacters((Object[])t.get(file));
		if (table.length != 4){ 
			System.out.println("test 3 (exA1) KO : Vous avez change la taille physique de depart de la table! Remettez-la a 4");
			return;
		} 
		if(table[0]==null){
			System.out.println("test 3 (exA1) KO : contenu KO (null)");
			return;
		}
		if(table[0]!='a'){
			System.out.println("test 3 (exA1) KO : contenu KO");
			return;
		}
		}catch (Exception e) {
			System.out.println("test 3 (exA1) KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 3 OK");


		// test 4
		try{
		file.enfile('b');
		if(file.taille()!=2){
				System.out.println("test 4 (exA1) KO taille KO");
				return;
		}
		table=objectsToCharacters((Object[])t.get(file));
		
		if(table[0]== null){
			System.out.println("test 4 (exA1) KO : contenu KO (null)");
			return;
		}
		
		if(table[0]!='a'){
			System.out.println("test 4 (exA1) KO : contenu KO");
			return;
		}	
		
		if(table[1]==null){
			System.out.println("test 4 (exA1) KO : contenu KO");
			return;
		}
		
		if(table[1]!='b'){
			System.out.println("test 4 (exA1) KO : contenu KO");
			return;
		}
		}catch (Exception e) {
			System.out.println("test 4 (exA1) KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 4 OK");


		// test 5
		try {
			Object o = file.premier();
			if(o==null){
				System.out.println("test 5 (exA1) KO : tete == null");
				return;
			}
			c = (Character)o;
			if(c != 'a') {
				System.out.println("test 5 (exA1) KO : tete KO");
				return;
			}
			if(file.taille()!=2){
				System.out.println("test 5 (exA1) KO : taille KO");
				return;
			}
			table=objectsToCharacters((Object[])t.get(file));
			if(table[0]!='a'){
				System.out.println("test 5 (exA1) KO : contenu KO");
				return;
			}
			if(table[1]!='b'){
				System.out.println("test 5 (exA1) KO : contenu KO");
				return;
			}
			
		} catch (FileVideException e) {
			System.out.println("test 5 (exA1) KO : Il ne fallait pas d'exception");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test 5 (exA1) KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 5 OK");


		// test 6

		try {
			Object o = file.defile();
			if(o==null){
				System.out.println("test 6 (exA1) KO : tete == null");
				return;
			}
			c = (Character)o;
			if(c != 'a') {
				System.out.println("test 6 (exA1) KO tete KO");
				return;
			}
			if(file.taille()!=1){
				System.out.println("test 6 (exA1) KO taille KO");
				return;
			}
			table=objectsToCharacters((Object[])t.get(file));
			if(table[1]!='b'){
				System.out.println("test 6 (exA1) KO : contenu KO");
				return;
			}
							
		} catch (FileVideException e) {
			System.out.println("test 6 (exA1) KO : Il ne fallait pas d'exception");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
		System.out.println("test 6 (exA1) KO : il y a eu une exception non prevue");
		e.printStackTrace();
		System.exit(0);
	}
		System.out.println("test 6 OK");

		// test 7
		try {
			Object o = file.defile();
			if(o==null){
				System.out.println("test 7 (exA1) KO : tete == null");
				return;
			}
			c = (Character)o;
			if(c != 'b') {
				System.out.println("test 7 (exA1) KO : tete KO");
				return;
			}
			if(file.taille()!=0){
				System.out.println("test 7 (exA1) KO : taille KO");
				return;
			}
						
		} catch (FileVideException e) {
			System.out.println("test 7 (exA1) KO : Il ne fallait pas d'exception");
			e.printStackTrace();
			System.exit(0);
		}catch (Exception e) {
			System.out.println("test 7 (exA1) KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 7 OK");

			
		// test 8
		try {
			Object o = file.defile();
			if(o==null){
				System.out.println("test 8 (exA1) KO : tete == null");
				return;
			}
			c = (Character)o;
			
			System.out.println("test 8 (exA1) KO : il fallait une exception");
				return;
			
			
		} catch (FileVideException e) {
			if(file.taille()!=0){
				System.out.println("test 8 (exA1) KO : taille KO");
				return;
			}
		}catch (Exception e) {
			System.out.println("test 8 (exA1) KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		
		System.out.println("test 8 OK");

		// test 9
		try{
		file.enfile('c');
		file.enfile('d');
		file.enfile('e');
		file.enfile('f');

		if(file.taille()!=4){
			System.out.println("test 9 (exA1) KO : taille KO");
			return;
		}
		table=objectsToCharacters((Object[])t.get(file));
		if (table[0] == null || table[0]!='e'|| table[1] == null || table[1]!='f'|| table[2] == null || table[2]!='c'|| table[3] ==null ||table[3]!='d'){
			System.out.println("test 9 (exA1) KO : le contenu de la table est KO");
			return;
		}
		}catch (Exception e) {
			System.out.println("test 9 (exA1) KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 9 OK");

		// test 10
		try {
			Object o = file.defile();
			if(o==null){
				System.out.println("test 10 (exA1) KO : tete == null");
				return;
			}
			c = (Character)o;
			if(c != 'c') {
				System.out.println("test 10 (exA1) : KO tete KO");
				return;
			}
			o = file.defile();
			if(o==null){
				System.out.println("test 10 (exA1) KO : tete == null");
				return;
			}
			c = (Character)o;	
			if(c != 'd') {
				System.out.println("test 10 (exA1) KO : tete KO");
				return;
			}
			o = file.defile();
			if(o==null){
				System.out.println("test 10 (exA1) KO : tete == null");
				return;
			}
			c = (Character)o;				
			if(c != 'e') {
				System.out.println("test 10 (exA1) KO : tete KO");
				return;
			}
			if(file.taille()!=1){
				System.out.println("test 10 (exA1) KO : taille KO");
				return;
			}
			
		} catch (FileVideException e) {
			System.out.println("test 10 (exA1) KO : Il ne fallait pas d'exception");
			e.printStackTrace();
			System.exit(0);
		}catch (Exception e) {
			System.out.println("test 10 (exA1) KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 10 OK");
		


		// test 11
		try{
		file.enfile('g');
		file.enfile('h');
		file.enfile('i');
		file.enfile('j');

		if(file.taille()!=5){
			System.out.println("test 11 (exA1) KO : taille KO");
			return;
		}
		table=objectsToCharacters((Object[])t.get(file));
		
		if (table[0]==null||table[0]!='f'||table[1]==null||table[1]!='g'||table[2]==null||table[2]!='h'||table[3]==null||table[3]!='i'||table[4]==null||table[4]!='j'){
			System.out.println("test 11 (exA1) KO : le contenu de la table est KO");
			System.out.println("Votre table contient : ");
			System.out.println(" "+table[0]+" "+table[1]+" "+table[2]+" "+table[3]+" "+table[4]);
			System.out.println("Elle devrait contenir : f g h i j");
			return;
		
		}
		}catch (Exception e) {
			System.out.println("test 11 (exA1) KO : il y a eu une exception non prevue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 11 OK");
		System.out.println("tous les tests ont reussi!");
		
	}
	
	private static Character[] objectsToCharacters(Object[] oTable) {
		Character[] table=new Character[oTable.length];
		for(int i=0; i<oTable.length; i++) {
			if (oTable[i]!=null)
				table[i]=(Character)oTable[i];
		}
		return table;
	}
	
	
}








