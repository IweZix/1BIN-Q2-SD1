import java.util.HashMap;
import java.util.HashSet;

/**
 * @author NICOLAS Luca
 */

public class Entrepot {

	private Hangar[] tableHangar;
	private HashMap<Integer, Societe> map;
	private HashSet<String> ensembleToutesPlaque;
	private int nombreHangarsLibres;
	private int nombreHangarPourSociete;

	/**
	 * construit un entrepot contenant nombreHangars
	 * @param nombreHangars le nombre d'hangars
	 * @throws IllegalArgumentException si le nombre d'hangars est negatif ou nul
	 */
	public Entrepot(int nombreHangars) {
		if(nombreHangars<=0)
			throw new IllegalArgumentException();
		map = new HashMap<>();
		tableHangar=new Hangar[nombreHangars];
		for (int i = 0; i < tableHangar.length; i++) {
			Hangar hangar =new Hangar(i);
			tableHangar[i]=hangar;
		}
		nombreHangarsLibres = nombreHangars;
		ensembleToutesPlaque = new HashSet<>();
		nombreHangarPourSociete = 0;
	}

	/**
	 * renvoie le nombre d'hangars libres
	 * @return le nombre d'hangars libres
	 */
	public int nombreHangarsLibres(){
		return nombreHangarsLibres;
	}

	/**
	 * renvoie le nombre de societes presentes
	 * @return le nombre de societes presentes
	 */
	public int nombreSocietesPresentes(){
		return tableHangar.length - nombreHangarsLibres;
	}

	/**
	 * renvoie la societe dont le numero est passe en parametre
	 * @param numeroSociete le numero de la societe
	 * @return la societe recherchee ou null si aucune societe presente ne possede ce numero
	 */
	public Societe getSociete(int numeroSociete){
		if (map.containsKey(numeroSociete))
			return map.get(numeroSociete);
		return null;
	}

	/**
	 * attribue un hangar a la societe passee en parametre
	 * Si l'attribution a pu se faire :
	 * la societe est enregistree comme presente (si pas encore presente)
	 * le hangar lui est ajoute
	 * @param numeroSociete le numero de la societe
	 * @param nomSociete le nom de la societe
	 * @return le numero du hangar attribue ou -1 s'il n'y en a plus de libre
	 */
	public int attribuerHangar(int numeroSociete, String nomSociete) {

		if (nombreHangarsLibres == 0) {
			return -1;
		}

		int i = numeroSociete % tableHangar.length;
		while (tableHangar[i].getSociete() != null) {
			i = (i + 1) % tableHangar.length;
		}

		if (!map.containsKey(numeroSociete)){
			map.put(numeroSociete, new Societe(numeroSociete, nomSociete));
			map.get(numeroSociete).ajouterHangar(i);
			nombreHangarsLibres--;
			tableHangar[i].setSociete(map.get(numeroSociete));
			nombreHangarPourSociete++;
			return i;
		} else {
			map.get(numeroSociete).ajouterHangar(i);
			nombreHangarsLibres--;
			tableHangar[i].setSociete(map.get(numeroSociete));
			nombreHangarPourSociete++;
			return i;
		}
	}

	/**
	 * libére un hangar passé en paramètre
	 * vérifie si le numéro du hangar éxiste
	 * vérifie si une société possède ce hangar
	 * @param numeroHangar le numéro du hangar à libérer
	 * @return true si le hangar à été libérer
	 */
	public boolean libererHangar(int numeroHangar) {
		if (numeroHangar > tableHangar.length || numeroHangar < 0){
			System.out.println("Numéro de hangar inexistant");
			return false;
		}
		Societe s = tableHangar[numeroHangar].getSociete();
		if (s == null) {
			System.out.println("Ce hangar est déjà libre");
			return false;
		}
		tableHangar[numeroHangar].setSociete(null);
		s.retirerHangar(numeroHangar);
		nombreHangarsLibres++;
		nombreHangarPourSociete--;
		System.out.println("Hangar n°" + numeroHangar + " à été retirer de la société " + s.getNom());

		/*if (nombreHangarPourSociete == 1){
			for (String s1 : ensembleToutesPlaque) {
				ensembleToutesPlaque.remove(s1);
				s.retirerVoiture(s1);
			}
			System.out.println("Toutes les plaques autorisées pour le hangar n°" + numeroHangar + " ont été radiées");
		}*/

		return true;
	}

	/**
	 * ajoute une plaque pour une société
	 * @param numeroSociete la société à laquelle il faut ajouter la plaque
	 * @param plaque la plaque qu'il faut ajouter à la société
	 * @return true si la plaque a été ajouter, false sinon
	 */
	public boolean ajouterPlaque(int numeroSociete, String plaque){
		Societe s = map.get(numeroSociete);
		if (s == null){
			System.out.println("Cette société n'existe pas");
			return false;
		}
		s.ajouterVoiture(plaque);
		ensembleToutesPlaque.add(plaque);
		return true;
	}

	/**
	 * vérifie si une plaque est autorisée
	 * @param numPlaque la plaque a vérifié
	 * @return true si la plaque est autorisée
	 */
	public boolean estAutorisee(String numPlaque){
		return ensembleToutesPlaque.contains(numPlaque);
	}
}