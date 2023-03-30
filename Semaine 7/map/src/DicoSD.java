import java.util.HashMap;
import java.util.LinkedList;

public class DicoSD {

	HashMap<String, LinkedList<String>> map;


	// Au depart le dico est vide
	public DicoSD() {
		map = new HashMap<String, LinkedList<String>>();
	}

	/**
	 * ajout dans le dico une association sd-url si cette association n'est pas encore presente 
	 * @param sd une structure de donnees
	 * @param url une url vers un site internet
	 * @return true si cette association n'etait pas encore presente dans le dico, false sinon
	 */
	public boolean ajouter(String sd, String url){
		if (map.containsKey(sd) && map.get(sd).contains(url))
			return false;
		if (!map.containsKey(sd)){
			LinkedList list = new LinkedList<>();
			map.put(sd, list);
		}
		if (map.containsKey(sd))
			map.get(sd).add(url);
		return true;
	}
	
	/**
	 * verifie si la structure de donnees se trouve dans le dico
	 * cette structure de donnees doit posseder au moins une url!
	 * @param sd
	 * @return true si sd est present, false sinon
	 */
	public boolean contient(String sd){
		return map.containsKey(sd);
	}
	
	
	/**
	 * renvoie tous les urls associes a la structure de donnees passee en parametre
	 * @param sd
	 * @return une chaine de caracteres avec les urls selon le format : [urlPile1, urlPile2] ou [] si la structure de donnees n'existe pas
	 */
	public String lesURLs(String sd){
		if (!map.containsKey(sd))
			return "[]";
		return map.get(sd).toString();
	}
	
	/**
	 * supprime dans le dico l'association sd-url si celle-ci est presente 
	 * @param sd une structure de donnees
	 * @param url une url vers un site internet
	 * @return true si l'association etait presente dans le dico, false sinon
	 */
	public boolean supprimer(String sd, String url){
		if (!map.containsKey(sd))
			return false;
		map.get(sd).remove(url);
		// si on a retiré tous les elt de la map alors on la supprime
		if (map.get(sd).isEmpty())
			map.remove(sd);
		return true;
	}
		
}
