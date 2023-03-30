import java.util.Arrays;

// implementation de l'interface File via une table circulaire

/**
 * @author NICOLAS Luca
 *
 */

public class FileImplViaTable<E> implements File<E>{

	private Object[] table;  // ne modifiez pas cet identifiant, la classe test l'utilise					
	private int indiceTete;  // ne modifiez pas cet identifiant, la classe test l'utilise			
	private int taille;		// ne modifiez pas cet identifiant, la classe test l'utilise	
	// N'ajoutez pas d'autres attributs, la classe test risquerait de ne pas fonctionner

	public FileImplViaTable(){
		table = new Object[4];
		taille = 0;
		indiceTete = 0;
	}

	public boolean estVide(){
		return taille == 0;
	}


	public int taille(){
		return taille;
	}

	/**
	 * renvoie l'element qui se trouve en tete de file sans l'enlever de la file
	 * @return l'element en tete
	 * @throws FileVideException si la file est vide
	 */
	public E premier()throws FileVideException{
		if (estVide()) throw new FileVideException();
		return (E) table[0];
	}

	/**
	 * renvoie l'element qui se trouve en tete de file et l'enleve de la file
	 * @return l'element en tete
	 * @throws FileVideException si la file est vide
	 */
	public E defile() throws FileVideException{
		if (estVide()) throw new FileVideException();
		E tete = (E) table[indiceTete];

		if (indiceTete == table.length-1){
			indiceTete = 0;
			taille--;
			return tete;
		}

		indiceTete = indiceTete+1;
		taille--;

		return tete;
	}

	/**
	 * ajoute un element en fin de file (queue)
	 * @param element l'element a ajouter
	 */
	public void enfile(E element){
		if (taille==table.length){
			Object[] table2= new Object[table.length*2];
			for (int i = 0; i < taille; i++) {
				table2[i]=table[indiceTete];
				if (indiceTete+1==table.length){
					indiceTete=0;
				}else {
					indiceTete++;
				}
			}
			indiceTete=0;
			table=table2;
		}
		if ((indiceTete+taille)>=table.length){
			table[(indiceTete+taille)-table.length]=element;
		}else{
			table[indiceTete+taille]=element;
		}
		taille++;
	}

} 
