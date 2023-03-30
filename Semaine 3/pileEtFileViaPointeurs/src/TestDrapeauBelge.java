
public class TestDrapeauBelge {
	
	public static void main(String[] args) {
		System.out.println("Classe test de la classe DrapeauBelge : ");
		System.out.println("Les tests consistent a ajouter differentes couleurs et a afficher au fur et a mesure le drapeau obtenu.");
		System.out.println();
		DrapeauBelge drapeau = new DrapeauBelge();
		if(!drapeau.toString().equals("njr")){
			System.out.println("Revoyez votre constructeur. Il n a pas construit le drapeau njr");
			return;
		}	
		System.out.println("             "+drapeau);
		System.out.print("ajout('x')   ");
		try{
			drapeau.ajouter('x');
			System.out.println("'x' n est pas une couleur acceptee. Il fallait lancer une IllegalArgumentException");
			return;
		}catch (IllegalArgumentException e){
			System.out.println(drapeau);
		}catch (Exception e){
			System.out.println("Exception non prevue");
			System.out.println("'x' n est pas une couleur acceptee. Il fallait lancer une IllegalArgumentException");
			e.printStackTrace();
			return;
		}
		System.out.print("ajout('n')   ");
		try{
			drapeau.ajouter('n');
			if(!drapeau.toString().equals("nnjr")){
				System.out.println("Revoyez votre methode ajouter()");
				System.out.println("Votre drapeau est "+drapeau);
				return;
			}	
		}catch (Exception e){
			System.out.println("Il ne fallait pas d exception");
			System.out.println("'n' est une couleur acceptee");
			e.printStackTrace();
			return;
		}
		System.out.println(drapeau);
		
		
	
		System.out.print("ajout('n')   ");
		try{
			drapeau.ajouter('n');
			if(!drapeau.toString().equals("nnnjr")){
				System.out.println("Revoyez votre methode ajouter()");
				System.out.println("Votre drapeau est "+drapeau);
				return;
			}	
		}catch (Exception e){
			System.out.println("Il ne fallait pas d exception");
			System.out.println("'n' est une couleur acceptee");
			e.printStackTrace();
			return;
		}
		System.out.println(drapeau);
		
		System.out.print("ajout('r')   ");
		try{
			drapeau.ajouter('r');
			if(!drapeau.toString().equals("nnnjrr")){
				System.out.println("Revoyez votre methode ajouter()");
				System.out.println("Votre drapeau est "+drapeau);
				return;
			}	
		}catch (Exception e){
			System.out.println("Il ne fallait pas d exception");
			System.out.println("'r' est une couleur acceptee");
			e.printStackTrace();
			return;
		}
		System.out.println(drapeau);
		
		System.out.print("ajout('j')   ");
		try{
			drapeau.ajouter('j');
			if(!drapeau.toString().equals("nnnjjrr")){
				System.out.println("Revoyez votre methode ajouter()");
				System.out.println("Votre drapeau est "+drapeau);
				return;
			}	
		}catch (Exception e){
			System.out.println("Il ne fallait pas d exception");
			System.out.println("'j' est une couleur acceptee");
			e.printStackTrace();
			return;
		}
		System.out.println(drapeau);
		
		System.out.print("ajout('n')   ");
		try{
			drapeau.ajouter('n');
			if(!drapeau.toString().equals("nnnnjjrr")){
				System.out.println("Revoyez votre methode ajouter()");
				System.out.println("Votre drapeau est "+drapeau);
				return;
			}	
		}catch (Exception e){
			System.out.println("Il ne fallait pas d exception");
			System.out.println("'n' est une couleur acceptee");
			e.printStackTrace();
			return;
		}
		System.out.println(drapeau);
		
		System.out.print("ajout('j')   ");
		try{
			drapeau.ajouter('j');
			if(!drapeau.toString().equals("nnnnjjjrr")){
				System.out.println("Revoyez votre methode ajouter()");
				System.out.println("Votre drapeau est "+drapeau);
				return;
			}	
		}catch (Exception e){
			System.out.println("Il ne fallait pas d exception");
			System.out.println("'j' est une couleur acceptee");
			e.printStackTrace();
			return;
		}
		System.out.println(drapeau);
		
		System.out.print("ajout('j')   ");
		try{
			drapeau.ajouter('j');
			if(!drapeau.toString().equals("nnnnjjjjrr")){
				System.out.println("Revoyez votre methode ajouter()");
				System.out.println("Votre drapeau est "+drapeau);
				return;
			}	
		}catch (Exception e){
			System.out.println("Il ne fallait pas d exception");
			System.out.println("'j' est une couleur acceptee");
			e.printStackTrace();
			return;
		}
		System.out.println(drapeau);
		
		System.out.print("ajout('r')   ");
		try{
			drapeau.ajouter('r');
			if(!drapeau.toString().equals("nnnnjjjjrrr")){
				System.out.println("Revoyez votre methode ajouter()");
				System.out.println("Votre drapeau est "+drapeau);
				return;
			}	
		}catch (Exception e){
			System.out.println("Il ne fallait pas d exception");
			System.out.println("'e' est une couleur acceptee");
			e.printStackTrace();
			return;
		}
		System.out.println(drapeau);
		System.out.println();
		System.out.println("Tous les tests ont reussi!");
	}
}
