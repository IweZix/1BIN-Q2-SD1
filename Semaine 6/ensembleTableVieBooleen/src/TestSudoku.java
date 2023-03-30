
public class TestSudoku {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("***************************************");
		System.out.println("Programme Test pour la classe Grille9X9");
		System.out.println("***************************************");
		int choix = 0;
		do {
			System.out.println("1 -> Tester le sudoku classique");
		
			System.out.println("2 -> Tester le sudoku diagonal (ex supplementaire)");
			System.out.println("3 -> Tester l'hyper sudoku (ex supplementaire)");
			
			System.out.println();
			System.out.print("Entrez votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
			case 1:
				testSudokuClassique();		
				break;
			case 2:
				testSudokuDiagonal();
				break;
			case 3:
				testHyperSudoku();
				break;
	
			default:
				break;
			}
		} while (choix >= 1 && choix <= 3 );

	}	


	public static void testSudokuClassique(){
		// test 1 : grille correspondant au 1er exemple de l'enonce
		System.out.print("test 1");

		int[][]table1 = new int[9][9];

		int[] ligne0 = {4,2,1,5,6,3,7,8,9};
		table1[0]=ligne0;

		int[] ligne1 = {6,3,8,7,9,4,1,2,5};
		table1[1]=ligne1;

		int[] ligne2 = {5,9,7,8,2,1,4,6,3};
		table1[2]=ligne2;

		int[] ligne3 = {7,1,6,4,3,2,5,9,8};
		table1[3]=ligne3;

		int[] ligne4 = {9,8,2,1,7,5,3,4,6};
		table1[4]=ligne4;

		int[] ligne5 = {3,5,4,6,8,9,2,1,7};
		table1[5]=ligne5;

		int[] ligne6 = {2,6,5,3,4,8,9,7,1};
		table1[6]=ligne6;

		int[] ligne7 = {8,4,3,9,1,7,6,5,2};
		table1[7]=ligne7;

		int[] ligne8 = {1,7,9,2,5,6,8,3,4};
		table1[8]=ligne8;

		Grille9X9 grille1= new Grille9X9(table1);
		if(grille1.estUnSudoku())
			System.out.println(" OK");
		else {
			System.out.println(" KO");
			return;
		}



		// test 2 : pbm ligne
		//grille correspondant au 1er exemple MAIS permutation 7 et 9 sur la 3eme colonne
		System.out.print("test 2");

		int[][]table2 = new int[9][9];

		int[] ligne2_0 = {4,2,1,5,6,3,7,8,9};
		table2[0]=ligne2_0;

		int[] ligne2_1 = {6,3,8,7,9,4,1,2,5};
		table2[1]=ligne2_1;

		int[] ligne2_2 = {5,9,9,8,2,1,4,6,3}; //ligne modifiee 7 est devenu 9
		table2[2]=ligne2_2;

		int[] ligne2_3 = {7,1,6,4,3,2,5,9,8};
		table2[3]=ligne2_3;

		int[] ligne2_4 = {9,8,2,1,7,5,3,4,6};
		table2[4]=ligne2_4;

		int[] ligne2_5 = {3,5,4,6,8,9,2,1,7};
		table2[5]=ligne2_5;

		int[] ligne2_6 = {2,6,5,3,4,8,9,7,1};
		table2[6]=ligne2_6;

		int[] ligne2_7 = {8,4,3,9,1,7,6,5,2};
		table2[7]=ligne2_7;

		int[] ligne2_8 = {1,7,7,2,5,6,8,3,4}; //ligne modifiee 9 est devenu 7
		table2[8]=ligne2_8;

		Grille9X9 grille2= new Grille9X9(table2);
		if(!grille2.estUnSudoku())
			System.out.println(" OK");
		else {
			System.out.println(" KO!!!!");
			return;
		}




		// test 3 : pbm colonne
		// grille correspondant au 1er exemple de l'enonce MAIS permutation 2 et 8 sur la 5eme ligne
		System.out.print("test 3");

		int[][]table3 = new int[9][9];

		int[] ligne3_0 = {4,2,1,5,6,3,7,8,9};
		table3[0]=ligne3_0;

		int[] ligne3_1 = {6,3,8,7,9,4,1,2,5};
		table3[1]=ligne3_1;

		int[] ligne3_2 = {5,9,7,8,2,1,4,6,3};
		table3[2]=ligne3_2;

		int[] ligne3_3 = {7,1,6,4,3,2,5,9,8};
		table3[3]=ligne3_3;

		int[] ligne3_4 = {9,2,8,1,7,5,3,4,6}; //ligne modifiee 2 et 8 permutes
		table3[4]=ligne3_4;

		int[] ligne3_5 = {3,5,4,6,8,9,2,1,7}; 
		table3[5]=ligne3_5;

		int[] ligne3_6 = {2,6,5,3,4,8,9,7,1};
		table3[6]=ligne3_6;

		int[] ligne3_7 = {8,4,3,9,1,7,6,5,2};
		table3[7]=ligne3_7;

		int[] ligne3_8 = {1,7,9,2,5,6,8,3,4}; 
		table3[8]=ligne3_8;

		Grille9X9 grille3= new Grille9X9(table3);
		if(!grille3.estUnSudoku())
			System.out.println(" OK");
		else {
			System.out.println(" KO!!!!");
			return;
		}


		// test 4 : pbm bloc
		// grille correspondant au 1er exemple de MAIS permutation de la 3eme ligne avec la 4eme
		System.out.print("test 4");

		int[][]table4 = new int[9][9];

		int[] ligne4_0 = {4,2,1,5,6,3,7,8,9};
		table4[0]=ligne4_0;

		int[] ligne4_1 = {6,3,8,7,9,4,1,2,5};
		table4[1]=ligne4_1;

		int[] ligne4_2 = {7,1,6,4,3,2,5,9,8}; // ligne permutee
		table4[2]=ligne4_2;

		int[] ligne4_3 = {5,9,7,8,2,1,4,6,3}; //ligne permutee
		table4[3]=ligne4_3;

		int[] ligne4_4 = {9,8,2,1,7,5,3,4,6};
		table4[4]=ligne4_4;

		int[] ligne4_5 = {3,5,4,6,8,9,2,1,7}; 
		table4[5]=ligne4_5;

		int[] ligne4_6 = {2,6,5,3,4,8,9,7,1};
		table4[6]=ligne4_6;

		int[] ligne4_7 = {8,4,3,9,1,7,6,5,2};
		table4[7]=ligne4_7;

		int[] ligne4_8 = {1,7,9,2,5,6,8,3,4}; 
		table4[8]=ligne4_8;

		Grille9X9 grille4= new Grille9X9(table4);
		if(!grille4.estUnSudoku())
			System.out.println(" OK");
		else {
			System.out.println(" KO!!!!");
			return;
		}

		System.out.println("Tous les tests ont reussi!");
		System.out.println();
	}


	private static void testSudokuDiagonal() {

		// test 1 : grille correspondant au 1er exemple de l'enonce qui n'est pas un sudoku diagonal
		System.out.print("test 1");

		int[][]table1 = new int[9][9];

		int[] ligne0 = {4,2,1,5,6,3,7,8,9};
		table1[0]=ligne0;

		int[] ligne1 = {6,3,8,7,9,4,1,2,5};
		table1[1]=ligne1;

		int[] ligne2 = {5,9,7,8,2,1,4,6,3};
		table1[2]=ligne2;

		int[] ligne3 = {7,1,6,4,3,2,5,9,8};
		table1[3]=ligne3;

		int[] ligne4 = {9,8,2,1,7,5,3,4,6};
		table1[4]=ligne4;

		int[] ligne5 = {3,5,4,6,8,9,2,1,7};
		table1[5]=ligne5;

		int[] ligne6 = {2,6,5,3,4,8,9,7,1};
		table1[6]=ligne6;

		int[] ligne7 = {8,4,3,9,1,7,6,5,2};
		table1[7]=ligne7;

		int[] ligne8 = {1,7,9,2,5,6,8,3,4};
		table1[8]=ligne8;

		Grille9X9 grille1= new Grille9X9(table1);
		if(grille1.estUnSudokuDiagonal()){
			System.out.println(" KO!!!!");
			return;
		}
		else {
			System.out.println(" OK");

		}
		
		// test 2 : grille correspondant au sudoku diagonal de l enonce
		System.out.print("test 2");

		int[][]table2 = new int[9][9];
		
		int[] ligne2_0 = {6,3,2,1,5,8,7,9,4};
		table2[0]=ligne2_0;

		int[] ligne2_1 = {4,7,8,3,2,9,5,1,6};
		table2[1]=ligne2_1;

		int[] ligne2_2 = {5,9,1,7,6,4,3,8,2}; 
		table2[2]=ligne2_2;

		int[] ligne2_3 = {1,8,7,5,9,2,6,4,3};
		table2[3]=ligne2_3;

		int[] ligne2_4 = {3,2,6,4,8,7,9,5,1};
		table2[4]=ligne2_4;

		int[] ligne2_5 = {9,4,5,6,1,3,2,7,8};
		table2[5]=ligne2_5;

		int[] ligne2_6 = {2,6,9,8,7,1,4,3,5};
		table2[6]=ligne2_6;

		int[] ligne2_7 = {8,5,4,9,3,6,1,2,7};
		table2[7]=ligne2_7;

		int[] ligne2_8 = {7,1,3,2,4,5,8,6,9};
		table2[8]=ligne2_8;

	
		
		Grille9X9 grille2= new Grille9X9(table2);
		if(grille2.estUnSudokuDiagonal())
			System.out.println(" OK");
		else {
			System.out.println(" KO!!!!!!");
			return;
		}
		
		System.out.println("Tous les tests ont reussi!");
		System.out.println();


	}


	private static void testHyperSudoku() {
		
		// test 1 : grille correspondant au 1er exemple de l'enonce qui n'est pas un sudoku diagonal
		System.out.print("test 1");

		int[][]table1 = new int[9][9];
		
		

		int[] ligne0 = {4,2,1,5,6,3,7,8,9};
		table1[0]=ligne0;

		int[] ligne1 = {6,3,8,7,9,4,1,2,5};
		table1[1]=ligne1;

		int[] ligne2 = {5,9,7,8,2,1,4,6,3};
		table1[2]=ligne2;

		int[] ligne3 = {7,1,6,4,3,2,5,9,8};
		table1[3]=ligne3;

		int[] ligne4 = {9,8,2,1,7,5,3,4,6};
		table1[4]=ligne4;

		int[] ligne5 = {3,5,4,6,8,9,2,1,7};
		table1[5]=ligne5;

		int[] ligne6 = {2,6,5,3,4,8,9,7,1};
		table1[6]=ligne6;

		int[] ligne7 = {8,4,3,9,1,7,6,5,2};
		table1[7]=ligne7;

		int[] ligne8 = {1,7,9,2,5,6,8,3,4};
		table1[8]=ligne8;

		Grille9X9 grille1= new Grille9X9(table1);
		if(grille1.estUnHyperSudoku()){
			System.out.println(" KO!!!!!!!!!");
			return;
		}
		else {
			System.out.println(" OK");
		}

		
		// test 2 : grille correspondant au l hyper sudoku de l enonce
		System.out.print("test 2");

		int[][]table2 = new int[9][9];
		
		int[] ligne2_0 = {8,9,1,6,5,7,4,2,3};
		table2[0]=ligne2_0;

		int[] ligne2_1 = {5,6,2,4,1,3,7,9,8};
		table2[1]=ligne2_1;

		int[] ligne2_2 = {4,7,3,8,9,2,5,1,6}; 
		table2[2]=ligne2_2;

		int[] ligne2_3 = {3,1,5,9,7,6,8,4,2};
		table2[3]=ligne2_3;

		int[] ligne2_4 = {6,8,7,2,4,5,1,3,9};
		table2[4]=ligne2_4;

		int[] ligne2_5 = {2,4,9,3,8,1,6,7,5};
		table2[5]=ligne2_5;

		int[] ligne2_6 = {9,2,8,1,6,4,3,5,7};
		table2[6]=ligne2_6;

		int[] ligne2_7 = {1,5,6,7,3,9,2,8,4};
		table2[7]=ligne2_7;

		int[] ligne2_8 = {7,3,4,5,2,8,9,6,1};
		table2[8]=ligne2_8;

		Grille9X9 grille2= new Grille9X9(table2);
		if(grille2.estUnHyperSudoku())
			System.out.println(" OK");
		else {
			System.out.println(" KO!!!!!!!!");
			return;
		}
		System.out.println("Tous les tests ont reussi!");
		System.out.println();

	}

}
