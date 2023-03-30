import java.util.ArrayList;


public class ConsigneFIFO {
	
	private ArrayList<Casier> casiersLibres;
	private Casier[] tousLesCasiers;
	
	/**
	 * construit une consigne de gare avec tous les casiers libres au depart
	 * @param nombreCasiers le nombre de casier de la consigne
	 * @throws IllegalArgumentException si le nombre de casiers est negatif ou nul
	 */
	public ConsigneFIFO(int nombreCasiers){
		if (nombreCasiers <= 0) throw new IllegalArgumentException("KO -> nbrCasiers <= 0");

		casiersLibres = new ArrayList<Casier>();
		tousLesCasiers = new Casier[nombreCasiers];

		for (int i = 0; i < tousLesCasiers.length; i++) {
			Casier c = new Casier(i);
			casiersLibres.add(c);
			tousLesCasiers[i] = c;
		}
	}

	/**
	 * verifie la presence d'un casier libre
	 * @return true s'il reste au moins un casier de libre, false sinon
	 */
	public boolean resteUnCasierLibre() {
		return casiersLibres.size() > 0;
	}

	
	/**
	 * attribue un casier libre selon le principe FIFO
	 * @param motDePasse le mot de passe qui permettra de liberer le casier
	 * @return le numero du casier attribue ou -1 s'il n'y en a plus de libre
	 * @throws IllegalArgumentException si le mot de passe est vide ou null
	 */
	public int attribuerCasierLibre(String motDePasse) {
		if (motDePasse == null || motDePasse.equals(""))
			throw new IllegalArgumentException("KO -> mot de passe vide ou null");
		if (!resteUnCasierLibre()) return -1;
		Casier c = casiersLibres.remove(0);
		tousLesCasiers[c.getNumero()].setMotDePasse(motDePasse);
		return c.getNumero();
	}

	
	/**
	 * libere un casier
	 * @param numeroCasier le numero de casier qui doit etre libere
	 * @param motDePasse le mot de passe a comparer avec le mot de passe du casier
	 * @return true si le numero de casier existe et le mot de passe est le bon, false sinon
	 * @throws IllegalArgumentException si le mot de passe est vide ou null
	 */
	public boolean libererCasier(int numeroCasier, String motDePasse) {
		if (motDePasse == null || motDePasse.equals("")) throw new IllegalArgumentException("KO -> mot de passe vide ou null");
		if (numeroCasier < 0 || numeroCasier > tousLesCasiers.length - 1) return false;
		Casier c = tousLesCasiers[numeroCasier];
		if (c.getMotDePasse().equals(motDePasse)){
			c.setMotDePasse("");
			casiersLibres.add(c);
			return true;
		}
		return false;
	}
}
