
public class Lyceen {

	private String nom;
	private  char sexe; // 'G' --> garcon, 'F' --> fille
	private int age;
	
	public Lyceen(String nom, char sexe, int age) {
		super();
		if(nom==null||nom.length()==0)
			throw new IllegalArgumentException();
		if(sexe!='G'&&sexe!='F')
			throw new IllegalArgumentException();
		if(age<0)
			throw new IllegalArgumentException();
		this.nom = nom;
		this.sexe = sexe;
		this.age = age;
	}

	public String getNom() {
		return nom;
	}

	public char getSexe() {
		return sexe;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Lyceen [nom=" + nom + ", sexe=" + sexe + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
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
		Lyceen other = (Lyceen) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	
	
	
	
}
