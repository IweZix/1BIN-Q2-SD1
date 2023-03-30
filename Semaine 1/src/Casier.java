
public class Casier {
	
	private int numero;        // la numerotation des casiers commence a 0
	private String motDePasse; // si le casier est libre, le mot de passe est vide
	
	
	public Casier(int numero) {
		this.numero = numero;
		this.motDePasse="";
	}

	
	public int getNumero() {
		return numero;
	}

	@Override
	public String toString() {
		return "Casier [numero=" + numero + ", motDePasse=" + motDePasse + "]";
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	
}
