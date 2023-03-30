import java.util.ArrayList;

/**
 * @author NICOLAS Luca
 *
 */

public class ConsigneLIFO {
	private ArrayList<Casier> casiersLibres;
	private Casier[] tousLesCasiers;

	/**
	 * construit une consigne de gare avec tous les casiers libres au depart
	 * @param nombreCasiers le nombre de casier de la consigne
	 * @throws IllegalArgumentException si le nombre de casiers est negatif ou nul
	 */
	public ConsigneLIFO(int nombreCasiers){
		if (nombreCasiers <= 0){
			throw new IllegalArgumentException();
		}

		casiersLibres = new ArrayList<Casier>();
		tousLesCasiers = new Casier[nombreCasiers];

		for (int i = 0; i < nombreCasiers; i++) {
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
	 * attribue un casier libre selon le principe LIFO
	 * @param motDePasse le mot de passe qui permettra de liberer le casier
	 * @return le numero du casier attribue ou -1 s'il n'y en a plus de libre
	 * @throws IllegalArgumentException si le mot de passe est vide ou null
	 */
	public int attribuerCasierLibre(String motDePasse) {
		if (motDePasse == null || motDePasse.equals(""))
			throw new IllegalArgumentException("KO -> password == void || password == null");
		if (!resteUnCasierLibre()) return -1;
		Casier c = casiersLibres.remove(casiersLibres.size()-1);
		c.setMotDePasse(motDePasse);
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
		if (motDePasse == null || motDePasse.equals(""))
			throw new IllegalArgumentException("KO -> password == void || password == null");
		if (numeroCasier < 0 || numeroCasier > tousLesCasiers.length - 1)
			return false;
		Casier c = tousLesCasiers[numeroCasier];
		if (tousLesCasiers[numeroCasier].getMotDePasse().equals(motDePasse)){
			tousLesCasiers[numeroCasier].setMotDePasse("");
			casiersLibres.add(c);
			return true;
		}
		return false;
	}
}
