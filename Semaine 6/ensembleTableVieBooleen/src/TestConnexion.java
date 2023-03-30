public class TestConnexion{

	public static void main(String[] args) throws IllegalArgumentException{

		System.out.println("***************************************");
		System.out.println("Programme Test pour la classe Connexion");
		System.out.println("***************************************");
		Connexion c = new Connexion();
		System.out.println("Test 1 : connexion de info001");
		if(!c.connecter(new Login("info001"))){
			System.out.println("Echec test 1, votre classe annonce ne pas avoir connecte info001");
			return;
		}
		if(c.nombreDeConnectes()!=1){
			System.out.println("Echec test 1, apres connexion de info001, votre classe annonce : "+ c.nombreDeConnectes()+" logins connectes!");
			return;
		}

		System.out.println("Test 2 : verifie connexion de info001");
		if(!c.estConnecte(new Login("info001"))){
			System.out.println("Echec test 2, votre classe ne trouve pas de connexion pour info001");
			return;
		}

		System.out.println("Test 3 : connexion de info001");
		if(c.connecter(new Login("info001"))){
			System.out.println("Echec test 3, votre classe annonce avoir connecte info001 alors qu'il l'est deja");
			return;
		}	
		if(c.nombreDeConnectes()!=1){
			System.out.println("Echec test 3, apres connexion du même login, votre classe annonce 1 connecte de plus : "+ c.nombreDeConnectes()+" logins connectes!");
			return;
		}

		System.out.println("Test 4 : connexion de admi001");
		c.connecter(new Login("admi001"));
		if(c.nombreDeConnectes()!=2){
			System.out.println("Echec test 4, apres connexion d'un deuxieme login, votre classe annonce : "+ c.nombreDeConnectes()+" logins connectes!");
			return;
		}
		System.out.println("Test 5 : verifie connexion de admi001");
		if(!c.estConnecte(new Login("admi001"))){
			System.out.println("Echec test 5, votre classe ne trouve pas de connexion pour admi001");
			return;
		}
		System.out.println("Test 6 : deconnexion de admi001");
		if(!c.deconnecter(new Login("admi001"))){
			System.out.println("Echec test 6, votre classe annonce ne pas avoir pu deconnecter un login existant : ");;
			return;
		}
		if(c.nombreDeConnectes()!=1){
			System.out.println("Echec test 6, apres deconnexion d'un des deux logins, votre classe annonce : "+ c.nombreDeConnectes()+" logins connectes!");;
			return;
		}
		System.out.println("Test 7 : verifie non connexion de admi001");
		if(c.estConnecte(new Login("admi001"))){
			System.out.println("Echec test 7, votre classe trouve une connexion pour admi001");
			return;
		}
		System.out.println("Test 8 : deconnexion de admi001");
		if(c.deconnecter(new Login("admi001"))){
			System.out.println("Echec test 8, votre classe annonce deconnecter un login non connecte");
			return;
		}
		if(c.nombreDeConnectes()!=1){
			System.out.println("Echec test 8, apres deconnexion d'un login non connecte, votre classe annonce : "+ c.nombreDeConnectes()+" logins connectes! Ce nombre devrait être egal a 1!");
			return;
		}
		System.out.println("Test 9 : Connexion de tous les employes");
		c = new Connexion();
		for (int i = 1; i <=9; i++) {
			String login = "info00"+i;
			if(!c.connecter(new Login(login))){
				System.out.println("Echec test 9, votre classe ne permet pas la connexion du login "+login+ "apres avoir connecte tous les logins precedents");
   			return;
			}
		}
		for (int i = 10; i <= 99; i++) {
			String login = "info0"+i;
			if(!c.connecter(new Login(login))){
				System.out.println("Echec test 9, votre classe ne permet pas la connexion du login "+login+ "apres avoir connecte tous les logins precedents");
   			return;
			}
		}
		for (int i = 100; i <= 137; i++) {
			String login = "info"+i;
			if(!c.connecter(new Login(login))){
				System.out.println("Echec test 9, votre classe ne permet pas la connexion du login "+login+ "apres avoir connecte tous les logins precedents");
   			return;
			}
		}
		for (int i = 1; i <= 9; i++) {
			String login = "mark00"+i;
			if(!c.connecter(new Login(login))){
				System.out.println("Echec test 9, votre classe ne permet pas la connexion du login "+login+ "apres avoir connecte tous les logins precedents");
   			return;
			}
		}
		for (int i = 10; i <= 73; i++) {
			String login = "mark0"+i;
			if(!c.connecter(new Login(login))){
				System.out.println("Echec test 9, votre classe ne permet pas la connexion du login "+login+ "apres avoir connecte tous les logins precedents");
   			return;
			}
		}
		for (int i = 1; i <= 9; i++) {
			String login = "admi00"+i;
			if(!c.connecter(new Login(login))){
				System.out.println("Echec test 9, votre classe ne permet pas la connexion du login "+login+ "apres avoir connecte tous les logins precedents");
   			return;
			}
		}
		for (int i = 10; i <= 46; i++) {
			String login = "admi0"+i;
			if(!c.connecter(new Login(login))){
				System.out.println("Echec test 9, votre classe ne permet pas la connexion du login "+login+ "apres avoir connecte tous les logins precedents");
   			return;
			}
		}
		System.out.println("Bravo! Tous les tests proposes ont reussi!");
		
	}
		
}

	