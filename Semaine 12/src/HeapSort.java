
public class HeapSort {
	private int [] arbre ; 
	private int taille; // longueur de la partie TAS 

	public HeapSort(int[] table) { 
		arbre = table; 
		taille = table.length; 
	} 

	public boolean estVide() { 
		return taille() == 0; 
	}

	public int taille() { 
		return taille; 
	} 

	public String toString() { 
		String resultat = ""; 
		for (int i = 0; i < arbre.length; i++) 
			resultat += arbre[i] + " "; 
		return resultat; 
	} 

	public void heapsort() { 
		buildHeap(); 
		while (taille() > 0) 
			supprimeMax();
	} 



	public void buildHeap() { 
		for (int i = taille()/2 - 1; i >= 0; i--) {
			pushDown(i);
			System.out.println(this);
		}
	}

	private void pushDown(int i) { 
		int indFG = this.indiceGauche(i) ;
		if (indFG>=taille)
			return ;
		int indicePermutation = i ;
		if (arbre[indFG]>arbre[i])
			indicePermutation = indFG ;
		int indFD = this.indiceDroit(i) ;
		if (indFD<taille&&arbre[indFD]>arbre[indicePermutation]) {
			indicePermutation = indFD ;
		} 
		if (indicePermutation==i) 
			return ;
		int temp = arbre[i] ;
		arbre[i] = arbre[indicePermutation] ;
		arbre[indicePermutation] = temp ;
		pushDown(indicePermutation) ; 
	} 
	
	private void supprimeMax() { 
		int resultat = arbre[0]; 
		arbre[0] = arbre[taille() - 1]; 
		taille--; 
		arbre[taille()] = resultat; 
		if (taille() > 0) {
			pushDown(0);
			System.out.println(this);
		}
	} 
	
	private int indiceParent(int i) { 
		return ((i-1)/2); 
	} 
	
	private int indiceGauche(int i) { 
		return (2*i+1); 
	} 
	
	
	private int indiceDroit(int i) { 
		return (2*i + 2); 
	} 
	
	public static void main(String[] args) { 
		int table[] = {57, 85, 44, 21, 23, 52, 17, 7, 95, 64, 87 }; 
		HeapSort hs = new HeapSort(table); 
		System.out.println(hs); 
		hs.heapsort(); 
	}
}
