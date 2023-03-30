
public class Proprietaire {
	
	private String nom;

	public Proprietaire(String nom) {
		super();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {
		return "Proprietaire [nom=" + nom + "]";
	}
	
	
}
