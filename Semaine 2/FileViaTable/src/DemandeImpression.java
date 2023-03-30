
public class DemandeImpression {

	private String nomDocument;
	private String cheminAcces;
	private String nomUtilisateur;
	private int priorite;

	public DemandeImpression(String cheminAcces, String nomDocument,
			String nomUtilisateur,int priorite) {
		if(cheminAcces==null)throw new IllegalArgumentException();
		if(nomDocument==null || nomDocument.equals(""))throw new IllegalArgumentException();
		if(nomUtilisateur==null)throw new IllegalArgumentException();
		if(priorite<0||priorite>9)throw new IllegalArgumentException();
		this.cheminAcces = cheminAcces;
		this.nomDocument = nomDocument;
		this.nomUtilisateur = nomUtilisateur;
		this.priorite = priorite;
	}
	
	public DemandeImpression(String nomDocument,int priorite){
		this("", nomDocument, "",priorite);
	}

	// A NE PAS MODIFIER
	// VA SERVIR POUR LES TESTS
	public String toString() {
		return nomDocument+" ("+priorite+")";
	}
	
	public String getNomDocument() {
		return nomDocument;
	}

	public String getCheminAcces() {
		return cheminAcces;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public int getPriorite(){
		return priorite;
	}

	public void setPriorite(int priorite){
		if(priorite<0||priorite>9)throw new IllegalArgumentException();
		this.priorite = priorite;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nomDocument == null) ? 0 : nomDocument.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DemandeImpression other = (DemandeImpression) obj;
		if (nomDocument == null) {
			if (other.nomDocument != null)
				return false;
		} else if (!nomDocument.equals(other.nomDocument))
			return false;
		return true;
	}
	

}
