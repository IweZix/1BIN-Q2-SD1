public class JeuGuerrier {

	public static void main(String[] args) {
		EquipeGuerriers equipe = new EquipeGuerriers(3, 10);
		int pointsDeVieDuMal = 30;

		int nbrEnVie = equipe.nombreGuerriersEnVie();
		while (pointsDeVieDuMal > 0 && nbrEnVie > 0) {
			System.out.println("L'équipe compte " + nbrEnVie + " guerriers en vie");

			int pointsDeViePerduGuerrier = lancerDe();
			Guerrier guerrier = equipe.jouer(pointsDeViePerduGuerrier);
			System.out.println("Suite au combat entre la créature du mal et le guerrier n°" + guerrier.getNumero());
			System.out.println("Le guerrier vient de perdre " + pointsDeViePerduGuerrier + " points de vie");
			int pointsDeVieGuerrier = guerrier.getPointsDeVie();
			if (pointsDeVieGuerrier == 0) System.out.println("Le guerrier est mort");
			else System.out.println("Il lui reste " + pointsDeVieGuerrier + " points de vie");

			int pointsDeViePerduMal = lancerDe();
			pointsDeVieDuMal = Math.max(0, pointsDeVieDuMal - pointsDeViePerduMal);
			System.out.println("La créature du mal vient de perdre " + pointsDeViePerduMal + " points de vie");
			if (pointsDeVieDuMal == 0) System.out.println("La créature du mal est morte");
			else System.out.println("Il lui reste " + pointsDeVieDuMal + " points de vie");

			nbrEnVie = equipe.nombreGuerriersEnVie();

			System.out.println();
		}

		if (nbrEnVie == 0) System.out.println("Tous les guerriers sont morts");
	}

	public static int lancerDe (){
		double nombreReel;
		nombreReel = Math.random();
		return (int) (nombreReel * 6) + 1;
	}

}