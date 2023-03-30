import java.util.Objects;

public class Voiture{
	
	public String numPlaque; // de type 1-AAA-999
	public String nomDuProprietaire;



	public Voiture(String numPlaque, String nomDuProprietaire){
		if(numPlaque==null)
			throw new IllegalArgumentException();
		if(nomDuProprietaire==null)
			throw new IllegalArgumentException();
		if(numPlaque.length()!=7)
			throw new IllegalArgumentException("plaque pas du type 1AAA999");
		this.numPlaque = numPlaque.toUpperCase();
		if(numPlaque.charAt(0)!='1')
			throw new IllegalArgumentException("plaque pas du type 1AAA999");
		for(int i=1; i<4; i++){
			if(this.numPlaque.charAt(i)<'A'||this.numPlaque.charAt(i)>'Z')
				throw new IllegalArgumentException("plaque pas du type 1AAA999");
		}
		for(int i=4; i<7; i++){
			if(this.numPlaque.charAt(i)<'0'||this.numPlaque.charAt(i)>'9')
				throw new IllegalArgumentException("plaque pas du type 1AAA999");
		}
		this.nomDuProprietaire = nomDuProprietaire; 
	}


	public String getNumPlaque() {
		return numPlaque;
	}


	public String getNomDuProprietaire() {
		return nomDuProprietaire;
	}

	@Override
	public String toString() {
		return "Voiture [numPlaque=" + numPlaque + ", nomDuProprietaire="
				+ nomDuProprietaire + "]";
	}


	/*@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Voiture voiture = (Voiture) o;
		return numPlaque.equals(voiture.numPlaque);
	}*/


	// ex a

	/*public int hashCode(){
		return numPlaque.hashCode();
	}*/



	// ex b

	/*public int hashCode(){
		
		int resultat = 0;
		for(int i = 0 ; i < 7 ; i++){
			resultat +=(int) this.numPlaque.charAt(i);
		}
		return resultat;		
	}*/




	//ex c

	/*@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Voiture voiture = (Voiture) o;
		return Objects.equals(numPlaque, voiture.numPlaque) && Objects.equals(nomDuProprietaire, voiture.nomDuProprietaire);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numPlaque, nomDuProprietaire);
	}*/


	//ex d
	public int hashCode() {
		return Integer.parseInt(numPlaque.substring(4,7)) / 2;
	}

}

