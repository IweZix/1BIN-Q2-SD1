import java.util.Arrays;
import java.util.Objects;

/**
 * @author NICOLAS Luca
 *
 */

public class Consigne{
	private Pile<Casier> casiersLibres;
	private Casier[] tousLesCasiers;

	/**
	 * construit une consigne de gare avec tous les casiers libres au depart
	 * @param nombreCasiers le nombre de casier de la consigne
	 * @throws IllegalArgumentException si le nombre de casiers est negatif ou null
	 */
	public Consigne(int nombreCasiers){
		if (nombreCasiers <= 0 || nombreCasiers == ' ')
			throw new IllegalArgumentException("KO car nbCasier <= 0 || nbCasier == null");
		tousLesCasiers = new Casier[nombreCasiers];
		casiersLibres = new PileImpl<>();
		for (int i = 0; i < nombreCasiers; i++) {
			Casier c = new Casier(i);
			casiersLibres.push(c);
			tousLesCasiers[i] = c;
		}
	}


	/**
	 * verifie la presence d'un casier libre
	 * @return true s'il reste au moins un casier de libre, false sinon
	 */
	public boolean resteUnCasierLibre() {
		return casiersLibres.taille() > 0;
	}


	/**
	 * attribue un casier libre
	 * @param motDePasse le mot de passe qui permettra de liberer le casier
	 * @return le numero du casier attribue ou -1 s'il n'y en a plus de libre
	 * @throws IllegalArgumentException si le mot de passe est vide ou null
	 */
	public int attribuerCasierLibre(String motDePasse) {
		if (motDePasse == null || motDePasse.equals(""))
			throw new IllegalArgumentException("KO car mdp vide ou null");
		if (!resteUnCasierLibre()) return -1;
		Casier casier = casiersLibres.pop();
		tousLesCasiers[casier.getNumero()].setMotDePasse(motDePasse);
		return casier.getNumero();
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
			throw new IllegalArgumentException("KO car mdp vide ou null");
		if (numeroCasier < 0 || numeroCasier > tousLesCasiers.length - 1) return false;

		Casier casier = new Casier(numeroCasier);
		if (tousLesCasiers[numeroCasier].getMotDePasse().equals(motDePasse)) {
			tousLesCasiers[numeroCasier].setMotDePasse("");
			casiersLibres.push(casier);
			return true;
		}
		return false;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Consigne consigne = (Consigne) o;
		return Objects.equals(casiersLibres, consigne.casiersLibres) && Arrays.equals(tousLesCasiers, consigne.tousLesCasiers);
	}

	@Override
	public int hashCode() {
		int result = Objects.hash(casiersLibres);
		result = 31 * result + Arrays.hashCode(tousLesCasiers);
		return result;
	}
}
