// implementation de la pile en utilisant un tableau de taille variable redimensionnable

public class PileImpl<E> implements Pile<E> {

	private E[] table;
	private int taille; //taille logique


	public PileImpl(int capacite){
		 if (capacite <= 0)
	            throw new IllegalArgumentException("la taille physique ne peut etre negative ou nulle");
		table = (E[]) new Object[capacite];
		taille = 0;
	}

	public PileImpl(){
		this(4);
	}


	public int taille(){
		return taille;
	}

	public boolean estVide(){
		return taille == 0;
	}

	private void agrandirTable() {
		E[] temp = (E[]) new Object[table.length * 2];
		for (int i = 0; i < taille; i++) {
			temp[i] = table[i];
		}
		table = temp;
	}
	
	public void push(E element){
		if (taille == table.length) {
			agrandirTable();
		}
		table[taille]=element;
		taille++;
	}

	public E pop() throws PileVideException{
		if (estVide()) throw new PileVideException();
		taille--;
		return table[taille];
	}

	
	public E sommet()throws PileVideException{
		if (estVide()) throw new PileVideException();
		return table[taille-1];
	}




}
