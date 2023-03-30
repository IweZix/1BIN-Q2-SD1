
public class Grille9X9 {

	private int[][] table;

	public Grille9X9(int[][] tableARecopier)throws IllegalArgumentException{
		if(tableARecopier==null)
			throw new IllegalArgumentException();
		if(tableARecopier.length!=9)
			throw new IllegalArgumentException();
		for(int i = 0;i<9;i++){
			if(tableARecopier[i]==null||tableARecopier[i].length!=9)throw new IllegalArgumentException();
		}
		table = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(tableARecopier [i][j]<1||tableARecopier[i][j]>9)throw new IllegalArgumentException();
				table[i][j]=tableARecopier[i][j];
			}
		}
	}

	private boolean ligneCorrecte(int ligne){
		Ensemble1A9 ens = new Ensemble1A9();
		for (int i = 1; i < 9; i++) {
			ens.ajouter(table[ligne][i]);
		}
		return ens.taille() == 9;
	}

	private boolean colonneCorrecte(int colonne){
		Ensemble1A9 ens = new Ensemble1A9();
		for (int i = 1; i < 9; i++) {
			ens.ajouter(table[i][colonne]);
		}
		return ens.taille() == 9;
	}

	private boolean blocCorrect(int ligne, int colonne){
		Ensemble1A9 ens = new Ensemble1A9();
		for (int i = ligne; i < ligne+2; i++) {
			for (int j = colonne; j < colonne+2; j++) {
				ens.ajouter(table[i][j]);
			}
		}
		return ens.taille() == 9;
	}

	public boolean estUnSudoku(){
		for(int i = 0; i < 9; i++){
			if(!ligneCorrecte(i)){
				return false;
			}
			if(!colonneCorrecte(i)){
				return false;
			}
		}
		for(int i = 0; i < 9;){
			for(int j = 0; j < 9;){
				if(!blocCorrect(i, j)){
					return false;
				}
				j+=3;
			}
			i+=3;
		}
		return true;
	}

	public boolean estUnSudokuDiagonal(){
		// TODO
		// cette methode est proposee en ex supplementaire
		return false;

	}

	public boolean estUnHyperSudoku(){
		// TODO
		// cette methode est proposee en ex supplementaire
		return false;

	}
}
