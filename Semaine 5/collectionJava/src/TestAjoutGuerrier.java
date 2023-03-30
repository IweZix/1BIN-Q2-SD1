import java.util.ArrayList;
import java.util.LinkedList;


public class TestAjoutGuerrier {
	
	public static void main(String[] args) {	
		
		Guerrier g1;
		Guerrier g2;
		Guerrier g3;
		Guerrier g4;
		Guerrier g5;
		
		// test 1 : exemple de l'enonce
			
		g1 = new Guerrier(1,5);
		g2 = new Guerrier(2,0);
		g3 = new Guerrier(3,2);
		g4 = new Guerrier(4,4);
		g5 = new Guerrier(5,6);
		ArrayList<Guerrier> a1 = new ArrayList<Guerrier>();
		a1.add(g1);
		a1.add(g2);
		a1.add(g3);
		a1.add(g4);
		LinkedList<Guerrier> l1 = new LinkedList<Guerrier>();
		l1.add(g4);
		l1.add(g1);
		l1.add(g3);
		EquipeGuerriers equipe1 = new EquipeGuerriers(a1, l1, 6);
		
		//System.out.println("L'equipe avant ajout :");
		//System.out.println(equipe1.toString());
		
		//System.out.println("L'equipe obtenue :");
		equipe1.ajouterNouveauGuerrier();
		//System.out.println(equipe1.toString());
		
		ArrayList<Guerrier> aAttendu1 = new ArrayList<Guerrier>();
		aAttendu1.add(g1);
		aAttendu1.add(g2);
		aAttendu1.add(g3);
		aAttendu1.add(g4);
		aAttendu1.add(g5);
		LinkedList<Guerrier> lAttendu1 = new LinkedList<Guerrier>();
		lAttendu1.add(g4);
		lAttendu1.add(g5);
		lAttendu1.add(g1);
		lAttendu1.add(g3);
		EquipeGuerriers equipeAttendue1 = new EquipeGuerriers(aAttendu1, lAttendu1, 6);
		
		//System.out.println("l'equipe attendue :");
		//System.out.println(equipeAttendue1.toString());
		
		if(!equipe1.toString().equals(equipeAttendue1.toString())){
			System.out.println("Test 1 : exemple de l'enonce");
			System.out.println("Attention, le test 1 a echoue.");
			System.out.println("Pour debugger, pensez a afficher l'equipe avant et apres ajout.");
			System.out.println("Ces affichages sont mis en // dans la classe de tests");
			return;
		}

		
		
		// test 2 : il n'y a plus qu'un guerrier en vie (g3) - le nouveau guerrier (g5) se place apres lui	
		
		g1 = new Guerrier(1,0);
		g2 = new Guerrier(2,0);
		g3 = new Guerrier(3,2);
		g4 = new Guerrier(4,0);
		g5 = new Guerrier(5,6);
		ArrayList<Guerrier> a2 = new ArrayList<Guerrier>();
		a2.add(g1);
		a2.add(g2);
		a2.add(g3);
		a2.add(g4);
		LinkedList<Guerrier> l2 = new LinkedList<Guerrier>();
		l2.add(g3);
		EquipeGuerriers equipe2 = new EquipeGuerriers(a2, l2, 6);
		
		//System.out.println("L'equipe avant ajout :");
		//System.out.println(equipe2.toString());
		
		//System.out.println("L'equipe obtenue :");
		equipe2.ajouterNouveauGuerrier();
		//System.out.println(equipe2.toString());
		
		ArrayList<Guerrier> aAttendu2 = new ArrayList<Guerrier>();
		aAttendu2.add(g1);
		aAttendu2.add(g2);
		aAttendu2.add(g3);
		aAttendu2.add(g4);
		aAttendu2.add(g5);
		LinkedList<Guerrier> lAttendu2 = new LinkedList<Guerrier>();
		lAttendu2.add(g3);
		lAttendu2.add(g5);
		EquipeGuerriers equipeAttendue2 = new EquipeGuerriers(aAttendu2, lAttendu2, 6);

		//System.out.println("l'equipe attendue :");
		//System.out.println(equipeAttendue2.toString());

		if(!equipe2.toString().equals(equipeAttendue2.toString())){
			System.out.println("Test 2 : g3 est le seul guerrier en vie");
			System.out.println("       : le nouveau guerrier g5 va se placer apres lui pour les combats");
			System.out.println("Attention, le test 2 a echoue.");
			System.out.println("Pour debugger, pensez a afficher l'equipe avant et apres ajout.");
			System.out.println("Ces affichages sont mis en // dans la classe de tests");
			return;
		}

		
		
		// test 3 : il n'y a plus de guerrier en vie
		
		g1 = new Guerrier(1,0);
		g2 = new Guerrier(2,0);
		g3 = new Guerrier(3,0);
		g4 = new Guerrier(4,0);
		g5 = new Guerrier(5,6);
		ArrayList<Guerrier> a3 = new ArrayList<Guerrier>();
		a3.add(g1);
		a3.add(g2);
		a3.add(g3);
		a3.add(g4);
		LinkedList<Guerrier> l3 = new LinkedList<Guerrier>();

		EquipeGuerriers equipe3 = new EquipeGuerriers(a3, l3, 6);

		//System.out.println("L'equipe avant ajout :");
		//System.out.println(equipe3.toString());

		//System.out.println("L'equipe obtenue :");
		equipe3.ajouterNouveauGuerrier();
		//System.out.println(equipe3.toString());

		ArrayList<Guerrier> aAttendu3 = new ArrayList<Guerrier>();
		aAttendu3.add(g1);
		aAttendu3.add(g2);
		aAttendu3.add(g3);
		aAttendu3.add(g4);
		aAttendu3.add(g5);
		LinkedList<Guerrier> lAttendu3 = new LinkedList<Guerrier>();
		lAttendu3.add(g5);
		EquipeGuerriers equipeAttendue3 = new EquipeGuerriers(aAttendu3, lAttendu3, 6);

		//System.out.println("l'equipe attendue :");
		//System.out.println(equipeAttendue3.toString());

		if(!equipe3.toString().equals(equipeAttendue3.toString())){
			System.out.println("Test 3 : aucun guerrier en vie");
			System.out.println("       : le nouveau guerrier guerrier est le seul guerrier pret au combat");
			System.out.println("Attention, le test 3 a echoue.");
			System.out.println("Pour debugger, pensez a afficher l'equipe avant et apres ajout.");
			System.out.println("Ces affichages sont mis en // dans la classe de tests");
			return;
		}
	
		
		// test 4 : 2 guerriers sont en vie : g1 et g3 - 2 guerriers sont morts
		// L'ordre des combats est g3 puis g1
		// Le nouveau guerrier g5 doit se placer entre g3 et g1 
		
		g1 = new Guerrier(1,2);
		g2 = new Guerrier(2,0);
		g3 = new Guerrier(3,2);
		g4 = new Guerrier(4,0);
		g5 = new Guerrier(5,6);
		ArrayList<Guerrier> a4 = new ArrayList<Guerrier>();
		a4.add(g1);
		a4.add(g2);
		a4.add(g3);
		a4.add(g4);
		LinkedList<Guerrier> l4 = new LinkedList<Guerrier>();
		l4.add(g3);
		l4.add(g1);
		EquipeGuerriers equipe4 = new EquipeGuerriers(a4, l4, 6);

		//System.out.println("L'equipe avant ajout :");
		//System.out.println(equipe4.toString());

		//System.out.println("L'equipe obtenue :");
		equipe4.ajouterNouveauGuerrier();
		//System.out.println(equipe4.toString());

		ArrayList<Guerrier> aAttendu4 = new ArrayList<Guerrier>();
		aAttendu4.add(g1);
		aAttendu4.add(g2);
		aAttendu4.add(g3);
		aAttendu4.add(g4);
		aAttendu4.add(g5);
		LinkedList<Guerrier> lAttendu4 = new LinkedList<Guerrier>();
		lAttendu4.add(g3);
		lAttendu4.add(g5);
		lAttendu4.add(g1);
		EquipeGuerriers equipeAttendue4 = new EquipeGuerriers(aAttendu4, lAttendu4, 6);

		//System.out.println("l'equipe attendue :");
		//System.out.println(equipeAttendue4.toString());

		if(!equipe4.toString().equals(equipeAttendue4.toString())){
			System.out.println("Test 4 :  2 guerriers sont en vie : g1 et g3 - 2 guerriers sont morts : g2 et g4");
			System.out.println("       : l'ordre des combats est g3 puis g1");
			System.out.println("       : le nouveau guerrier g5 doit se placer entre g3 et g1 ");
			System.out.println("Attention, le test 4 a echoue.");
			System.out.println("Pour debugger, pensez a afficher l'equipe avant et apres ajout.");
			System.out.println("Ces affichages sont mis en // dans la classe de tests");
			return;
		}
		
		// test 5 : 4 guerriers sont en vie
		// L'ordre des combats est g2 g3 g4 g1
		// Le nouveau guerrier g5 doit se placer entre g3 et g1 

		g1 = new Guerrier(1,2);
		g2 = new Guerrier(2,2);
		g3 = new Guerrier(3,2);
		g4 = new Guerrier(4,2);
		g5 = new Guerrier(5,6);
		ArrayList<Guerrier> a5 = new ArrayList<Guerrier>();
		a5.add(g1);
		a5.add(g2);
		a5.add(g3);
		a5.add(g4);
		LinkedList<Guerrier> l5 = new LinkedList<Guerrier>();
		l5.add(g2);
		l5.add(g3);
		l5.add(g4);
		l5.add(g1);
		EquipeGuerriers equipe5 = new EquipeGuerriers(a5, l5, 6);

		//System.out.println("L'equipe avant ajout :");
		//System.out.println(equipe5.toString());

		//System.out.println("L'equipe obtenue :");
		equipe5.ajouterNouveauGuerrier();
		//System.out.println(equipe5.toString());

		ArrayList<Guerrier> aAttendu5 = new ArrayList<Guerrier>();
		aAttendu5.add(g1);
		aAttendu5.add(g2);
		aAttendu5.add(g3);
		aAttendu5.add(g4);
		aAttendu5.add(g5);
		LinkedList<Guerrier> lAttendu5 = new LinkedList<Guerrier>();
		lAttendu5.add(g2);
		lAttendu5.add(g3);
		lAttendu5.add(g4);
		lAttendu5.add(g5);
		lAttendu5.add(g1);
		EquipeGuerriers equipeAttendue5 = new EquipeGuerriers(aAttendu5, lAttendu5, 6);

		//System.out.println("l'equipe attendue :");
		//System.out.println(equipeAttendue5.toString());

		if(!equipe5.toString().equals(equipeAttendue5.toString())){
			System.out.println("Test 5 :  4 guerriers sont en vie ");
			System.out.println("       : l'ordre des combats est g2 g3 g4 g1");
			System.out.println("       : le nouveau guerrier g5 doit se placer entre g4 et g1 ");
			System.out.println("Attention, le test 5 a echoue.");
			System.out.println("Pour debugger, pensez a afficher l'equipe avant et apres ajout.");
			System.out.println("Ces affichages sont mis en // dans la classe de tests");
			return;
		}
		
		// test 6 : 3 guerriers sont en vie g1, g2, g3
		// L'ordre des combats est g1 g2 g3
		// Le nouveau guerrier g5 doit se placer apres g3

		g1 = new Guerrier(1,2);
		g2 = new Guerrier(2,2);
		g3 = new Guerrier(3,2);
		g4 = new Guerrier(4,0);
		g5 = new Guerrier(5,6);
		ArrayList<Guerrier> a6 = new ArrayList<Guerrier>();
		a6.add(g1);
		a6.add(g2);
		a6.add(g3);
		a6.add(g4);
		LinkedList<Guerrier> l6 = new LinkedList<Guerrier>();
		l6.add(g1);
		l6.add(g2);
		l6.add(g3);
		EquipeGuerriers equipe6 = new EquipeGuerriers(a6, l6, 6);

		//System.out.println("L'equipe avant ajout :");
		//System.out.println(equipe6.toString());

		//System.out.println("L'equipe obtenue :");
		equipe6.ajouterNouveauGuerrier();
		//System.out.println(equipe6.toString());

		ArrayList<Guerrier> aAttendu6 = new ArrayList<Guerrier>();
		aAttendu6.add(g1);
		aAttendu6.add(g2);
		aAttendu6.add(g3);
		aAttendu6.add(g4);
		aAttendu6.add(g5);
		LinkedList<Guerrier> lAttendu6 = new LinkedList<Guerrier>();
		lAttendu6.add(g1);
		lAttendu6.add(g2);
		lAttendu6.add(g3);
		lAttendu6.add(g5);
		EquipeGuerriers equipeAttendue6 = new EquipeGuerriers(aAttendu6, lAttendu6, 6);

		//System.out.println("l'equipe attendue :");
		//System.out.println(equipeAttendue6.toString());

		if(!equipe6.toString().equals(equipeAttendue6.toString())){
			System.out.println("Test 6 :  3 guerriers sont en vie g1 g2 et g3");
			System.out.println("       : l'ordre des combats est g1 g2 g3");
			System.out.println("       : le nouveau guerrier g5 doit se placer apres g3 ");
			System.out.println("Attention, le test 6 a echoue.");
			System.out.println("Pour debugger, pensez a afficher l'equipe avant et apres ajout.");
			System.out.println("Ces affichages sont mis en // dans la classe de tests");
			return;
		}



		System.out.println("Tous les tests ont reussi!");

	}
	
}
