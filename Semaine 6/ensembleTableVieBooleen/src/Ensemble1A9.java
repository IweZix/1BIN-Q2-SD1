
public class Ensemble1A9{
	
	private boolean[] table; 
	private int taille;

	public Ensemble1A9(){
		table = new boolean[9];	
		taille = 0;		
	}
	
	
	public boolean estVide(){
		return taille==0;
	}

	
	public boolean contient(int i){
		if(i<1||i>9)
			throw new IllegalArgumentException("entier n'appartient pas a l'univers");
		return table[i-1];
	}

	
	public boolean ajouter(int i){
		if(i<1||i>9)
			throw new IllegalArgumentException("entier n'appartient pas a l'univers");
		if(!table[i-1]){
			table[i-1]=true;
			taille++;
			return true;
		}
		return false;
	}

	
	public boolean enlever(int i){
		if(i<1||i>9)
			throw new IllegalArgumentException("entier n'appartient pas a l'univers");
		if(table[i-1]){
			table[i-1]=false;
			taille--;
			return true;
		}
		return false;
	}

	
	public int taille(){
		return taille;
	}
}
