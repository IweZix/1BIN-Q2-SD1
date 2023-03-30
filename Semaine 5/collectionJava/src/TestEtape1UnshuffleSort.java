import java.util.Arrays;

public class TestEtape1UnshuffleSort {
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
                System.out.println("     "+messageErreur+". Attendu="+attendu+" reçu="+recu);
                System.exit(0);
            }
        } else if (!attendu.equals(recu)) {
            System.out.println("    "+messageErreur+". Attendu="+attendu+" reçu="+recu);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        System.out.println("*************************************************************");
        System.out.println("Tests de la methode placerEntier() de la classe UnshuffleSort");
        System.out.println("*************************************************************");
        UnshuffleSort unshuffleSort = new UnshuffleSort();
        int[] t4 = {3,12,2,4,18,17,6,1,15,14};

        System.out.println("Scenario 1 : la table a trier est celle de l'enonce");
        System.out.println(Arrays.toString(t4));
        System.out.println("placerEntier(3)");
        try {
            unshuffleSort.placerEntier(3);
            assertEquals("ko", "[[3]]", unshuffleSort.toString());
            System.out.println(unshuffleSort.toString());
        }catch (Exception e){
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("placerEntier(12)");
        try {
            unshuffleSort.placerEntier(12);
            assertEquals("ko","[[3, 12]]",unshuffleSort.toString());
            System.out.println(unshuffleSort.toString());
        }catch (Exception e){
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("placerEntier(2)");
        try {
            unshuffleSort.placerEntier(2);
            assertEquals("ko","[[2, 3, 12]]",unshuffleSort.toString());
            System.out.println(unshuffleSort.toString());
        }catch (Exception e){
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("placerEntier(4)");
        try {
            unshuffleSort.placerEntier(4);
            assertEquals("ko","[[2, 3, 12], [4]]",unshuffleSort.toString());
            System.out.println(unshuffleSort.toString());
        }catch (Exception e){
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("placerEntier(18)");
        try {
            unshuffleSort.placerEntier(18);
            assertEquals("ko","[[2, 3, 12, 18], [4]]",unshuffleSort.toString());
            System.out.println(unshuffleSort.toString());
        }catch (Exception e){
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("placerEntier(17)");
        try {
            unshuffleSort.placerEntier(17);
            assertEquals("ko","[[2, 3, 12, 18], [4, 17]]",unshuffleSort.toString());
            System.out.println(unshuffleSort.toString());
        }catch (Exception e){
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("placerEntier(6)");
        try{
            unshuffleSort.placerEntier(6);
            assertEquals("ko","[[2, 3, 12, 18], [4, 17], [6]]",unshuffleSort.toString());
            System.out.println(unshuffleSort.toString());
        }catch (Exception e){
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("placerEntier(1)");
        try{
            unshuffleSort.placerEntier(1);
            assertEquals("ko","[[1, 2, 3, 12, 18], [4, 17], [6]]",unshuffleSort.toString());
            System.out.println(unshuffleSort.toString());
        }catch (Exception e){
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("placerEntier(15)");
        try {
            unshuffleSort.placerEntier(15);
            assertEquals("ko","[[1, 2, 3, 12, 18], [4, 17], [6, 15]]",unshuffleSort.toString());
            System.out.println(unshuffleSort.toString());
        }catch (Exception e){
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("placerEntier(14)");
        try {
            unshuffleSort.placerEntier(14);
            assertEquals("ko","[[1, 2, 3, 12, 18], [4, 17], [6, 15], [14]]",unshuffleSort.toString());
            System.out.println(unshuffleSort.toString());
        }catch (Exception e){
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("Le scenario 1 s'est bien deroule");


        unshuffleSort = new UnshuffleSort();
        int[] t = {3,3,3,1,3,1,2};

        System.out.println("Scenario 2 : la table a trier contient des ex-aequos");
        System.out.println(Arrays.toString(t));

        System.out.println("placerEntier(3)");
        try {
            unshuffleSort.placerEntier(3);
            assertEquals("ko", "[[3]]", unshuffleSort.toString());
            System.out.println(unshuffleSort.toString());
        }catch (Exception e){
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("placerEntier(3)");
        try {
            unshuffleSort.placerEntier(3);
            assertEquals("ko", "[[3, 3]]", unshuffleSort.toString());
            System.out.println(unshuffleSort.toString());
        }catch (Exception e){
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("placerEntier(3)");
        try {
            unshuffleSort.placerEntier(3);
            assertEquals("ko", "[[3, 3, 3]]", unshuffleSort.toString());
            System.out.println(unshuffleSort.toString());
        }catch (Exception e){
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("placerEntier(1)");
        try {
            unshuffleSort.placerEntier(1);
            assertEquals("ko", "[[1, 3, 3, 3]]", unshuffleSort.toString());
            System.out.println(unshuffleSort.toString());
        }catch (Exception e){
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("placerEntier(3)");
        try {
            unshuffleSort.placerEntier(3);
            assertEquals("ko", "[[1, 3, 3, 3, 3]]", unshuffleSort.toString());
            System.out.println(unshuffleSort.toString());
        }catch (Exception e){
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("placerEntier(1)");
        try {
            unshuffleSort.placerEntier(1);
            assertEquals("ko", "[[1, 1, 3, 3, 3, 3]]", unshuffleSort.toString());
            System.out.println(unshuffleSort.toString());
        }catch (Exception e){
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("placerEntier(2)");
        try {
            unshuffleSort.placerEntier(2);
            assertEquals("ko", "[[1, 1, 3, 3, 3, 3], [2]]", unshuffleSort.toString());
            System.out.println(unshuffleSort.toString());
        }catch (Exception e){
            System.out.println("Il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("Le scenario 2 s'est bien deroule");
    }
}
