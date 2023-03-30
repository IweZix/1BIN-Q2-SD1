import java.lang.reflect.Field;

public class TestPileDeCaracteresImpl {
	
	static Class classe = PileDeCaracteresImpl.class;
	static Field t ;
	
	public static void main(String[] args) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		
		System.out.println("**************************************************");
		System.out.println("Programme Test pour la classe PileDeCaracteresImpl");
		System.out.println("**************************************************");
		
		System.out.println("\nLes tests correspondent aux tests de l'exercice A1");
		System.out.println("La numerotation a ete respectee!");
		System.out.println();
		t = classe.getDeclaredField("table");
		t.setAccessible(true);
		char c;
		char[] table;
		PileDeCaracteresImpl pile = new PileDeCaracteresImpl();

		// test 1
		try {
			c = pile.pop();
			System.out.println("test 1 KO : Il fallait une PileVideException");
			return;	
		} catch (PileVideException e) {
			
		}

		catch (Exception e) {
			System.out.println("test 1 KO : Il fallait une PileVideException");
			e.printStackTrace();
			return;
		}
		
		// test 2
		try {
			c = pile.sommet();
			System.out.println("test 2 KO : Il fallait une PileVideException");
			return;
			
		} catch (PileVideException e) {
			
		}
		catch (Exception e) {
			System.out.println("test 2 KO : Il fallait une PileVideException");
			e.printStackTrace();
			return;
		}
		// test 3
		
		try{
		pile.push('a');
		if(pile.taille()!=1){
			System.out.println("test 3 KO : taille KO");
			return;
		}
		table = (char[]) t.get(pile);
		if (table.length != 4){ 
			System.out.println("Vous avez change la taille physique de depart de la table! Remettez-la a 4");
			return;
		} 
		if(table[0]!='a'){
			System.out.println("test 3 KO : contenu KO");
			return;
		}
		}
		catch (Exception e) {
			System.out.println("test 3 KO : Il y a eu une exception inattendue : ");
			e.printStackTrace();
			return;
		}

		// test 4
		try{
			pile.push('b');
			if(pile.taille()!=2){
				System.out.println("test 4 KO taille KO");
				return;
			}
			table = (char[]) t.get(pile);

			if(table[0]!='a'){
				System.out.println("test 4 KO");
				return;
			}	

			if(table[1]!='b'){
				System.out.println("test 4 KO : contenu KO");
				return;
			}
		}
		catch (Exception e) {
			System.out.println("test 4 KO : Il y a eu une exception inattendue : ");
			e.printStackTrace();
			return;
		}

		// test 5
		try {
			c = pile.sommet();
			if(c != 'b') {
				System.out.println("test 5 KO : sommet KO");
				return;
			}
			if(pile.taille()!=2){
				System.out.println("test 5 KO : taille KO");
				return;
			}
			table = (char[]) t.get(pile);
			if(table[0]!='a'){
				System.out.println("test 5 KO : contenu KO");
				return;
			}
			if(table[1]!='b'){
				System.out.println("test 5 KO : contenu KO");
				return;
			}




		} catch (PileVideException e) {
			System.out.println("test 5 KO : Il ne fallait pas de PileVideException");
			return;
		}

		catch (Exception e) {
			System.out.println("test 5 KO : Il y a eu une exception inattendue : ");
			e.printStackTrace();
			return;
		}

		// test 6

		try {
			c = pile.pop();
			if(c != 'b') {
				System.out.println("test 6 KO sommet KO");
				return;
			}
			if(pile.taille()!=1){
				System.out.println("test 6 KO taille KO");
				return;
			}
			table = (char[]) t.get(pile);
			if(table[0]!='a'){
				System.out.println("test 6 KO contenu KO");
				return;
			}
			if(table[1]!='b'){
				System.out.println("test 6 AVERTISSEMENT : Les caracteres supprimes peuvent rester dans la table!");
			}




		} catch (PileVideException e) {
			System.out.println("test 6 KO : Il ne fallait pas de PileVideException");
			return;
		}
		catch (Exception e) {
			System.out.println("test 6 KO : Il y a eu une exception inattendue : ");
			e.printStackTrace();
			return;
		}

		// test 7

		try {
			c = pile.pop();
			if(c != 'a') {
				System.out.println("test 7 : KO sommet KO");
				return;
			}
			if(pile.taille()!=0){
				System.out.println("test 7 KO : taille KO");
				return;
			}
			table = (char[]) t.get(pile);
			if(table[0]!='a'){
				System.out.println("test 7 AVERTISSEMENT : Les caracteres supprimes peuvent rester dans la table!");
			}
			if(table[1]!='b'){
				System.out.println("test 7 AVERTISSEMENT : Les caracteres supprimes peuvent rester dans la table!");
			}




		} catch (PileVideException e) {
			System.out.println("test 7 KO : Il ne fallait pas de PileVideException");
			return;
		}

		catch (Exception e) {
			System.out.println("test 7 KO : Il y a eu une exception inattendue : ");
			e.printStackTrace();
			return;
		}

		// test 8
		try {
			c = pile.pop();

			System.out.println("test 8 KO");
			if(pile.taille()!=0){
				System.out.println("test 8 KO : taille KO");
				return;
			}
			table = (char[]) t.get(pile);
			if(table[0]!='a'){
				System.out.println("test 8 AVERTISSEMENT : Les caracteres supprimes peuvent rester dans la table!");
			}





		} catch (PileVideException e) {
			if(pile.taille()!=0){
				System.out.println("test 8 KO : taille KO");
				return;
			}
		}

		catch (Exception e) {
			System.out.println("test 8 KO : Il y a eu une exception inattendue : ");
			e.printStackTrace();
			return;
		}
		System.out.println("tests 1 a 8 ont reussi");

		// test 9
		System.out.println("test 9 : verification agrandissement de la table :");
		boolean ok = true;
		for(char caractere = 'a'; caractere <= 'z'; caractere++)
			pile.push(caractere);
		if(pile.taille()!=26){
			System.out.println("la taille logique de la table actuelle devrait etre 26!");
			ok = false;
		}
		table = (char[]) t.get(pile);
		if (table.length != 32){ 
			System.out.println("la taille physique de la table actuelle devrait etre 32!");
			ok = false;
		} 
		c = 'a';
		for(int i = 0; i < 26 && ok; i++){
			if (table[i]!=c){
				System.out.println("le contenu de la table est KO");
				ok = false;
			}
			c++;
		}
		if (ok) System.out.println("test 9 reussi");
	}
}












