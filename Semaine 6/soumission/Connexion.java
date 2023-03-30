/**
 * @author NICOLAS Luca
 */

public class Connexion {
   
	Ensemble<Login> ensembleDesConnectes;
 	// N'AJOUTEZ PAS D'AUTRES ATTRIBUTS!!!
	// N'OUBLIEZ PAS DE COMPLETER LA METHODE HASHCODE() DE LA CLASSE LOGIN
	
	public Connexion(){
		ensembleDesConnectes = new EnsembleTableBooleens<>(999);
	}

	public int nombreDeConnectes(){
		return ensembleDesConnectes.taille();
	}
	
	// ajoute le login s'il n'est pas encore connecte
	public boolean connecter(Login login){
		return ensembleDesConnectes.ajouter(login);
	}
	
	// retire le login s'il est connecte
	public boolean deconnecter(Login login){
		return ensembleDesConnectes.enlever(login);
	}

	public boolean estConnecte(Login login){
		return ensembleDesConnectes.contient(login);
	}
}