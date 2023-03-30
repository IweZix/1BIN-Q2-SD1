import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * Algorithme de tri : UnshuffleSort 

 * Cet algorithme de tri necessite l?utilisation d?une liste de deques.
 * Cet algorithme de tri comporte deux etapes. La premiere consiste a repartir
 * les entiers a trier dans un nombre variable de deques. Lorsque tous
 * les entiers auront ete repartis, la deuxieme etape se chargera de remplir la
 * table a renvoyer.
 *
 * Les 2 etapes sont basees sur le principe suivant : La liste des deques devra
 * toujours etre triee en utilisant le premier entier de chaque deque comme clef de tri.
 * Les deques aussi sont tries.
 *
 *
 */
public class UnshuffleSort {

	private LinkedList<ArrayDeque<Integer>>  listeDeDeques;

	public UnshuffleSort() {
		this.listeDeDeques = new LinkedList<ArrayDeque<Integer>>();
	}

	/**
	 * tri de la table d'entiers re?ue en parametre
	 *
	 * @param tableATrier la table a trier
	 * @return table contenant les entiers tries
	 */
	public int[] trier(int[] tableATrier) {
		remplirDeques(tableATrier);
		return viderDeques(tableATrier.length);
	}

	/**
	 * 1ere etape du tri : repartition des entiers dans des deques
	 * @param tableATrier la table a trier
	 */
	private void remplirDeques(int[]tableATrier) {
		System.out.println("etape1");
		for (int i : tableATrier) {
			placerEntier(i);
		}
		System.out.println(listeDeDeques);
	}

	public void placerEntier(int entier) {
		if (listeDeDeques.size() == 0) {
			listeDeDeques.add(new ArrayDeque<>());
			listeDeDeques.getLast().add(entier);
			return;
		}
		for (ArrayDeque<Integer> deque : listeDeDeques)
			if (deque.getFirst() >= entier) {
				deque.addFirst(entier);
				return;
			} else if (deque.getLast() <= entier) {
				deque.addLast(entier);
				return;
			}
		listeDeDeques.add(new ArrayDeque<>());
		listeDeDeques.getLast().add(entier);
	}


	/**
	 * 2eme etape du tri : on vide les deques
	 *
	 * @param taille nombre d'entiers de la table a trier
	 * @return table contenant les entiers tries
	 */
	private int[] viderDeques(int taille) {

		System.out.println("etape2");
		int[] tabletrier = new int[taille];
		for (int i = 0; i < taille; i++) {
			tabletrier[i] = supprimerPlusPetitEntier();
			this.reorganiserListe();
		}
		return tabletrier;


	}

	private int supprimerPlusPetitEntier(){

		return listeDeDeques.getFirst().removeFirst();
	}

	private void reorganiserListe(){

		if(listeDeDeques.getFirst().isEmpty())
			listeDeDeques.removeFirst();
		else
			deplacerPremierDeque();
		System.out.println(listeDeDeques);


	}

	private void deplacerPremierDeque() {
		int i = listeDeDeques.getFirst().getFirst();
		int c = 0;
		for (ArrayDeque<Integer> j : listeDeDeques) {
			if (j.getFirst() >= i && !j.equals(listeDeDeques.getFirst())) {
				if (c > 1)
					listeDeDeques.add(c - 1, listeDeDeques.removeFirst());
				return;
			}
			c++;
		}
		listeDeDeques.addLast(listeDeDeques.removeFirst());
	}

	public String toString(){
		return listeDeDeques.toString();
	}

}
