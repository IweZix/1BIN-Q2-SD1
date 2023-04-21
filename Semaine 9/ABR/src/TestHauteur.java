import java.util.Scanner;

public class TestHauteur {

    private static Scanner scanner = new Scanner(System.in);
    /**
     * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
     *
     * @param messageErreur message a afficher en cas de probleme
     * @param attendu la valeur qu'on s'attendait a recevoir
     * @param recu la valeur qu'on a recu en realite
     */

    private static void assertEquals(String messageErreur, Object attendu, Object recu) {
        if (attendu==null) {
            if (recu!=null) {
                System.out.println(messageErreur+"\nAttendu="+attendu+"\nRecu="+recu);
                System.exit(0);
            }
        } else if (!attendu.equals(recu)) {
            System.out.println(messageErreur+"\nAttendu="+attendu+"\nRecu="+recu);
            System.exit(0);

        }
    }

    public static void main(String[] args) {
        System.out.println("*****************************************************************");
        System.out.println("Programme Test : methode hauteur() de la classe ArbreDEntiersPlus");
        System.out.println("*****************************************************************");
        System.out.println("Les arbres testes sont les arbres du powerpoint ABR");
        ArbreDEntiersPlus a1 = arbre1();
        System.out.println(a1);
        assertEquals("hauteur ko",2,a1.hauteur());
        System.out.println("la hauteur est bien : "+a1.hauteur());
        ArbreDEntiersPlus a2 = arbre2();
        System.out.println(a2);
        assertEquals("hauteur ko",4,a2.hauteur());
        System.out.println("la hauteur est bien : "+a2.hauteur());
        ArbreDEntiersPlus a3 = arbre3();
        System.out.println(a3);
        assertEquals("hauteur ko",6,a3.hauteur());
        System.out.println("la hauteur est bien : "+a3.hauteur());
        System.out.println("Tous les tests ont reussi");


    }

    private static ArbreDEntiersPlus arbre1(){
        ArbreDEntiersPlus g = new ArbreDEntiersPlus(1);
        ArbreDEntiersPlus d = new ArbreDEntiersPlus(3);
        g =  new ArbreDEntiersPlus(g, 2, d);
        ArbreDEntiersPlus g1 = new ArbreDEntiersPlus(7);
        ArbreDEntiersPlus d1 = new ArbreDEntiersPlus(9);
        d = new ArbreDEntiersPlus(g1,8,d1);
        return  new ArbreDEntiersPlus(g, 6, d);

    }

    private static ArbreDEntiersPlus arbre2() {
        ArbreDEntiersPlus g = new ArbreDEntiersPlus(1);
        ArbreDEntiersPlus d = new ArbreDEntiersPlus(7);
        d = new ArbreDEntiersPlus(new ArbreDEntiersPlus(), 6, d);
        d = new ArbreDEntiersPlus(new ArbreDEntiersPlus(), 3, d);
        g = new ArbreDEntiersPlus(g, 2, d);
        d = new ArbreDEntiersPlus(9);
        return new ArbreDEntiersPlus(g, 8, d);
    }

    private static ArbreDEntiersPlus arbre3(){
        ArbreDEntiersPlus d = new ArbreDEntiersPlus(9);
        d = new ArbreDEntiersPlus(new ArbreDEntiersPlus(),8,d);
        d = new ArbreDEntiersPlus(new ArbreDEntiersPlus(),7,d);
        d = new ArbreDEntiersPlus(new ArbreDEntiersPlus(),6,d);
        d = new ArbreDEntiersPlus(new ArbreDEntiersPlus(),3,d);
        d = new ArbreDEntiersPlus(new ArbreDEntiersPlus(),2,d);
        d = new ArbreDEntiersPlus(new ArbreDEntiersPlus(),1,d);
        return d;

    }

}
