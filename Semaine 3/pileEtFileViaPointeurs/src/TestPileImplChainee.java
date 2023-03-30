import java.util.Scanner;
public class TestPileImplChainee{

	private final static Scanner scanner = new Scanner(System.in);
		
	public static void main(String[] args) {	

		System.out.println("*********************************************");
		System.out.println("Programme Test pour la classe PileImplChainee");
		System.out.println("*********************************************");

		int choix = 0;
		do {
			System.out.println();
			System.out.println("1 -> Tester la methode push()");
			System.out.println("2 -> Tester la methode pop()");
			System.out.println("3 -> Tester la methode sommet()");	
			System.out.println("4 -> Tester l'exA1");	
			System.out.println();
			System.out.print("Votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
			case 1:
				testPush();
				break;
			case 2:
				testPop();
				break;
			case 3:				
				testSommet();
				break;
			case 4:				
				testExA1();
				break;
			default:
				break;
			}

		} while (choix >= 1 && choix <= 5);
	}

	
	
	private static void testExA1() {
		PileImplChainee<Character> p = new PileImplChainee<Character>();
		System.out.print("Test1 ");
		try{
			p.pop();
			System.out.println(" KO, il n'y a pas eu PileVideException : ");
			return;
					
		}catch (PileVideException ex){
		}
		catch (Exception ex){
			System.out.println(" KO, il n'y a pas eu PileVideException : ");
			ex.printStackTrace();
			return;
		}
		System.out.println("ok");
		
		System.out.print("Test2 ");
		try{
			p.sommet();
			System.out.println(" KO, il n'y a pas eu PileVideException : ");
			return;
					
		}catch (PileVideException ex){
		}
		catch (Exception ex){
			System.out.println(" KO, il n'y a pas eu PileVideException : ");
			ex.printStackTrace();
			return;
		}
		System.out.println("ok");
		
		System.out.print("Test3 ");
		try{
			p.push('a');
			if(p.taille()!=1){
				System.out.println();
				System.out.println(" KO : taille obtenue : " + p.taille());
				return;
			}
			if(!p.toString().equals(" a")){
				System.out.println(" KO : contenu obtenu : "+ p);
				return;
			}
					
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println("ok");
		
		System.out.print("Test4 ");
		try{
			p.push('b');
			if(p.taille()!=2){
				System.out.println();
				System.out.println(" KO : taille obtenue : " + p.taille());
				return;
			}
			if(!p.toString().equals(" a b")){
				System.out.println(" KO : contenu obtenu : "+ p);
				return;
			}
					
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println("ok");
		
		System.out.print("Test5 ");
		try{
			Character c = p.sommet();
			if(c!='b'){
				System.out.println(" KO : caractere renvoye : " + c);
				return;
			}
			if(p.taille()!=2){
				System.out.println();
				System.out.println(" KO : taille modifiee : " + p.taille());
				return;
			}
			if(!p.toString().equals(" a b")){
				System.out.println(" KO : contenu modifie : "+ p);
				return;
			}
					
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println("ok");
		
		System.out.print("Test6 ");
		try{
			Character c = p.pop();
			if(c!='b'){
				System.out.println(" KO : caractere renvoye : " + c);
				return;
			}
			if(p.taille()!=1){
				System.out.println();
				System.out.println(" KO : taille : " + p.taille());
				return;
			}
			if(!p.toString().equals(" a")){
				System.out.println(" KO : contenu : "+ p);
				return;
			}
					
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println("ok");
		
		System.out.print("Test7 ");
		try{
			Character c = p.pop();
			if(c!='a'){
				System.out.println(" KO : caractere renvoye : " + c);
				return;
			}
			if(p.taille()!=0){
				System.out.println();
				System.out.println(" KO : taille : " + p.taille());
				return;
			}
			if(!p.toString().equals("")){
				System.out.println(" KO : contenu : "+ p);
				return;
			}
					
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println("ok");
		
		System.out.print("Test8 ");
		try{
			p.pop();
			System.out.println(" KO, il n'y a pas eu PileVideException : ");
			return;
					
		}catch (PileVideException ex){
		}
		catch (Exception ex){
			System.out.println(" KO, il n'y a pas eu PileVideException : ");
			ex.printStackTrace();
			return;
		}
		System.out.println("ok");
		System.out.print("Test9 (encore un push) ");
		try{
			p.push('a');
			if(p.taille()!=1){
				System.out.println();
				System.out.println(" KO : taille obtenue : " + p.taille());
				return;
			}
			if(!p.toString().equals(" a")){
				System.out.println(" KO : contenu obtenu : "+ p);
				return;
			}
					
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println("ok");
		
		System.out.println("Tous les tests ont reussi!");
		
	}



	private static void testPush() {
		System.out.println();
		System.out.println("Tests methode push()");
		System.out.println("--------------------");
		System.out.print("Test 1 : pileVide : push(a)");
		PileImplChainee<String> pVide = new PileImplChainee<String>();
		try{
			pVide.push("a");
			if(pVide.taille()!=1){
				System.out.println();
				System.out.println(" KO : taille obtenue : " + pVide.taille());
				return;
			}
			if(!pVide.toString().equals(" a")){
				System.out.println(" KO : contenu obtenu : "+ pVide);
				return;
			}
					
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" : ok");
		
		System.out.print("Test 2 : pile a b c : push(d)");
		String[] tabc = {"a","b","c"};
		PileImplChainee<String> pabc = new PileImplChainee<String>(tabc);
		try{
			pabc.push("d");
			if(pabc.taille()!=4){
				System.out.println();
				System.out.println(" KO : taille obtenue : " + pabc.taille());
				return;
			}
			if(!pabc.toString().equals(" a b c d")){
				System.out.println(" KO : contenu obtenu : "+ pabc);
				return;
			}
					
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" : ok");
		System.out.println("Tous les tests de la methode push ont reussi!");
		System.out.println();
		
	}

	private static void testPop() {
		System.out.println();
		System.out.println("Tests methode pop()");
		System.out.println("-------------------");
		System.out.print("Test 1 : pileVide ");
		PileImplChainee<String> pVide = new PileImplChainee<String>();
		try{
			pVide.pop();
			System.out.println(" KO, il n'y a pas eu PileVideException : ");
			return;
					
		}catch (PileVideException ex){
		}
		catch (Exception ex){
			System.out.println(" KO, il n'y a pas eu PileVideException : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" : ok");
		
		System.out.print("Test 2 : pile a b c ");
		String[] tabc = {"a","b","c"};
		PileImplChainee<String> pabc = new PileImplChainee<String>(tabc);
		try{
			String s = pabc.pop();
			if(!s.equals("c")){
				System.out.println(" KO : string renvoyee : " + s);
				return;
			}
			if(pabc.taille()!=2){
				System.out.println();
				System.out.println(" KO : taille obtenue : " + pabc.taille());
				return;
			}
			if(!pabc.toString().equals(" a b")){
				System.out.println(" KO : contenu obtenu : "+ pabc);
				return;
			}
					
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" : ok");
		System.out.println("Tous les tests de la methode pop ont reussi!");
		System.out.println();
		
	}

	private static void testSommet() {
		System.out.println();
		System.out.println("Tests methode sommet()");
		System.out.println("----------------------");
		System.out.print("Test 1 : pileVide ");
		PileImplChainee<String> pVide = new PileImplChainee<String>();
		try{
			pVide.sommet();
			System.out.println(" KO, il n'y a pas eu PileVideException : ");
			return;
					
		}catch (PileVideException ex){
		}
		catch (Exception ex){
			System.out.println(" KO, il n'y a pas eu PileVideException : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" : ok");
		
		System.out.print("Test 2 : pile a b c ");
		String[] tabc = {"a","b","c"};
		PileImplChainee<String> pabc = new PileImplChainee<String>(tabc);
		try{
			String s = pabc.sommet();
			if(!s.equals("c")){
				System.out.println(" KO : string renvoyee : " + s);
				return;
			}
			if(pabc.taille()!=3){
				System.out.println();
				System.out.println(" KO : taille modifiee : " + pabc.taille());
				return;
			}
			if(!pabc.toString().equals(" a b c")){
				System.out.println(" KO : contenu modifie : "+ pabc);
				return;
			}
					
		}catch (Exception ex){
			System.out.println(" KO, il y a eu Exception : ");
			ex.printStackTrace();
			return;
		}
		System.out.println(" : ok");
		System.out.println("Tous les tests de la methode sommet ont reussi!");
		System.out.println();
		
	}


}