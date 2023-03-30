public class ConnexionInfo {
   
 	Ensemble<LoginInfo> ensembleDesConnectes;
 	// N'AJOUTEZ PAS D'AUTRES ATTRIBUTS!!!
 	// N'OUBLIEZ PAS DE COMPLETER LA METHODE HASHCODE() DE LA CLASSE LOGININFO
 	
 	public ConnexionInfo(){
		 ensembleDesConnectes = new EnsembleTableBooleens<LoginInfo>(999);
	}
 	
 	public	int nombreDeConnectes(){
 		return ensembleDesConnectes.taille();
	}

 	// ajoute le loginInfo s'il n'est pas encore connecte
	public boolean connecter(LoginInfo loginInfo){
		return ensembleDesConnectes.ajouter(loginInfo);
	}

	// retire le loginInfo s'il est connecte
	public boolean deconnecter(LoginInfo loginInfo){
		return ensembleDesConnectes.enlever(loginInfo);
	}

	public boolean estConnecte(LoginInfo loginInfo){
		return ensembleDesConnectes.contient(loginInfo);
	}
}