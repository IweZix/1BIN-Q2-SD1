import java.util.Arrays;

/**
 * @author NICOLAS Luca
 */

public class ClasseEtudiants{
	
	private SerieEtudiants[] tableSeries;
	// N'AJOUTEZ PAS D'AUTRES ATTRIBUTS
	
	/**
	 * construit les series et repartit de facon uniforme les etudiants parmi ces series
	 * la numerotation des series commence a 1
	 * precondition : la table noms contient des chaines de caracteres non vides et toutes differentes
	 * ! Il ne faut pas verifier une precondition !
	 * @param nombreSeries
	 * @param noms table contenant les noms des etudiants a repartir parmi les differentes series
	 * @throws IllegalArgumentException si le nombre de series est <= 0 ou si la table noms est null 
	 */
	public ClasseEtudiants(int nombreSeries,String[] noms){
		if (nombreSeries <= 0) throw new IllegalArgumentException("nombreSeries <= 0");
		if (noms == null) throw new IllegalArgumentException("noms == null");
		tableSeries = new SerieEtudiants[nombreSeries];
		for (int i = 0; i < nombreSeries; i++) {
			tableSeries[i] = new SerieEtudiants(i+1);
		}
		for (int i = 0; i < noms.length; i++) {
			tableSeries[i%nombreSeries].ajouterEtudiant(noms[i]);
		}
	}
	
	
	/**
	 * cette methode renvoie la serie d'etudiants dont le numero est passe en parametre
	 * @param numeroSerie (la numerotation des series commence a 1)
	 * @return la serie d'etudiants
	 * @throws IllegalArgumentException si le numero de serie n'existe pas
	 */
	public SerieEtudiants getSerieEtudiants(int numeroSerie)throws IllegalArgumentException{
		if (tableSeries[numeroSerie-1] == null) throw new IllegalArgumentException("série existe pas");
		return tableSeries[numeroSerie-1];
	}
	
	
	/**
	 * renvoie le nombre de series de la classe
	 * @return le nombre de series
	 */
	public int nombreSeries(){
		return tableSeries.length;
	}
		
	/**
	 * cette methode renvoie le numero de serie de l'etudiant dont le nom est passe en parametre
	 * @param nom
	 * @return le numero de la serie ou -1 si l'etudiant n'appartient a aucune des series
	 * @throws IllegalArgumentException si le nom est null ou vide
	 */
	public int numeroSerie(String nom){
		if (nom == null || nom.equals("")) throw new IllegalArgumentException("nom == null || nom.equals('')");
		for (int i = 0; i < tableSeries.length; i++) {
			if (tableSeries[i].contientEtudiant(nom)) return i;
		}
		return -1;
	}
	
	
	/**
	 * cette methode deplace l'etudiant de sa serie vers une autre serie 
	 * cette methode reussit si l'etudiant existe et qu'il n'etait pas deja dans cette serie
	 * @param nom 
	 * @param nouveauNumeroSerie 
	 * @return true si un changement a ete effectue, false sinon
	 * @throws IllegalArgumentException si le nom est null ou vide ou si le nouveauNumeroSerie n'existe pas
	 */
	public boolean changerSerie(String nom, int nouveauNumeroSerie){
		if (nom == null || nom.equals("")) throw new IllegalArgumentException("nom == null || nom.equals('')");
		if (tableSeries[nouveauNumeroSerie] == null) throw new IllegalArgumentException("série existe pas");
		if (tableSeries[numeroSerie(nom)].contientEtudiant(nom) && numeroSerie(nom) != nouveauNumeroSerie){
			tableSeries[numeroSerie(nom)].supprimerEtudiant(nom);
			tableSeries[nouveauNumeroSerie].ajouterEtudiant(nom);
			return true;
		}
		return false;
	}

	public String tailleSerie(){
		String s = "";
		for (int i = 0; i < tableSeries.length; i++) {
			s += "Série " + (i+1) + " : " + tableSeries[i].nombreEtudiants() + " etudiants" + ",\n";
		}
		return s;
	}

	public int[] tailleSerie2(){
		int[] tab = new int[tableSeries.length];
		for (int i = 0; i < tableSeries.length; i++) {
			tab[i] = tableSeries[i].nombreEtudiants();
		}
		return tab;
	}
	
		
	public String toString(){
		return Arrays.toString(tableSeries);
	}

}
