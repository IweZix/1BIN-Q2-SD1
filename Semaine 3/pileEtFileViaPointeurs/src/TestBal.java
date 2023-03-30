import java.util.Scanner;

public class TestBal {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println();


        System.out.println("****************************************");
        System.out.println("Scenario de tests pour l'application Bal");
        System.out.println("****************************************");

        Etudiant nico = new Etudiant("nico", 'M');
        Etudiant sam = new Etudiant("sam", 'M');
        Etudiant marie = new Etudiant("marie", 'F');
        Etudiant jeanne = new Etudiant("jeanne", 'F');
        Etudiant hugo = new Etudiant("hugo", 'M');
        Etudiant tim = new Etudiant("tim", 'M');
        Etudiant lea = new Etudiant("lea", 'F');
        Etudiant mia = new Etudiant("mia", 'F');

        System.out.println("Choisissez l'implementation a tester :");
        System.out.println("1 --> Bal1");
        System.out.println("2 --> Bal2");
        int choix = scanner.nextInt();
        while(choix != 1 && choix !=2){
            System.out.print("Tapez 1 ou 2 : ");
            choix = scanner.nextInt();
        }
        Bal bal;
        if(choix==1)
            bal = new Bal1();
        else
            bal = new Bal2();

        System.out.println("Au depart il n'y a aucun inscrit : ");
        try {
            System.out.println(bal);
            if(!bal.toString().equals("[]")) {
                System.out.println("Le bal ne s'affiche pas");
                System.out.println("Revoyez le constructeur !");
                return;
            }
        }catch (Exception e){
            System.out.println("Exception inattendue");
            System.out.println("Revoyez le constructeur !");
            e.printStackTrace();
            return;
        }




        System.out.println();

        System.out.println("Test1: ordre des ajouts : nico sam marie jeanne hugo tom lea mia");

        try {
            System.out.println("ajout nico (M)");
            bal.ajouterEtudiant(nico);
            System.out.println(bal);
            if(!bal.toString().equals("[nico]")) {
                System.out.println("Test 1 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }
        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }
        try {
            System.out.println("ajout sam (M)");
            bal.ajouterEtudiant(sam);
            System.out.println(bal);
            if(!bal.toString().equals("[nico, sam]")) {
                System.out.println("Test 1 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }
        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }

        try {
            System.out.println("ajout marie (F)");
            bal.ajouterEtudiant(marie);
            System.out.println(bal);
            if(!bal.toString().equals("[nico, sam, marie]")) {
                System.out.println("Test 1 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }
        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }

        try {
            System.out.println("ajout jeanne (F)");
            bal.ajouterEtudiant(jeanne);
            System.out.println(bal);
            if(! bal.toString().equals("[nico, sam, marie, jeanne]")){
                System.out.println("Test 1 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }

        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }

        try {
            System.out.println("ajout hugo (M)");
            bal.ajouterEtudiant(hugo);
            System.out.println(bal);
            if(! bal.toString().equals("[nico, sam, hugo, marie, jeanne]")){
                System.out.println("Test 1 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }

        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }

        try {
            System.out.println("ajout tim (M)");
            bal.ajouterEtudiant(tim);
            System.out.println(bal);
            if(! bal.toString().equals("[nico, sam, hugo, tim, marie, jeanne]")){
                System.out.println("Test 1 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }

        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }

        try {
            System.out.println("ajout lea (F)");
            bal.ajouterEtudiant(lea);
            System.out.println(bal);
            if(! bal.toString().equals("[nico, sam, hugo, tim, marie, jeanne, lea]")){
                System.out.println("Test 1 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }
        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }

        try {
            System.out.println("ajout mia (F)");
            bal.ajouterEtudiant(mia);
            System.out.println(bal);
            if(! bal.toString().equals("[nico, sam, hugo, tim, marie, jeanne, lea, mia]")){
                System.out.println("Test 1 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }
        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }

        System.out.println("Test1 ok");
        System.out.println();


        System.out.println("Test2: ordre des ajouts : marie jeanne nico sam hugo tom lea mia");
        if(choix==1)
            bal = new Bal1();
        else
            bal = new Bal2();
        try {
            System.out.println("ajout marie (F)");
            bal.ajouterEtudiant(marie);
            System.out.println(bal);
            if(!bal.toString().equals("[marie]")) {
                System.out.println("Test 2 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }
        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }
        try {
            System.out.println("ajout jeanne (F)");
            bal.ajouterEtudiant(jeanne);
            System.out.println(bal);
            if(!bal.toString().equals("[marie, jeanne]")) {
                System.out.println("Test 2 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }
        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }

        try {
            System.out.println("ajout nico (M)");
            bal.ajouterEtudiant(nico);
            System.out.println(bal);
            if(!bal.toString().equals("[nico, marie, jeanne]")) {
                System.out.println("Test 2 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }
        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }

        try {
            System.out.println("ajout sam (M)");
            bal.ajouterEtudiant(sam);
            System.out.println(bal);
            if(! bal.toString().equals("[nico, sam, marie, jeanne]")){
                System.out.println("Test 2 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }
        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }

        try {
            System.out.println("ajout hugo (M)");
            bal.ajouterEtudiant(hugo);
            System.out.println(bal);
            if(! bal.toString().equals("[nico, sam, hugo, marie, jeanne]")){
                System.out.println("Test 2 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }

        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }

        try {
            System.out.println("ajout tim (M)");
            bal.ajouterEtudiant(tim);
            System.out.println(bal);
            if(! bal.toString().equals("[nico, sam, hugo, tim, marie, jeanne]")){
                System.out.println("Test 2 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }

        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }

        try {
            System.out.println("ajout lea (F)");
            bal.ajouterEtudiant(lea);
            System.out.println(bal);
            if(! bal.toString().equals("[nico, sam, hugo, tim, marie, jeanne, lea]")){
                System.out.println("Test 2 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }
        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }

        try {
            System.out.println("ajout mia (F)");
            bal.ajouterEtudiant(mia);
            System.out.println(bal);
            if(! bal.toString().equals("[nico, sam, hugo, tim, marie, jeanne, lea, mia]")){
                System.out.println("Test 2 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }
        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }

        System.out.println("Test 2 ok");
        System.out.println();



        System.out.println("Test 3 : ordre des ajouts : marie nico jeanne sam hugo tom lea mia");
        if(choix==1)
            bal = new Bal1();
        else
            bal = new Bal2();
        try {
            System.out.println("ajout marie (F)");
            bal.ajouterEtudiant(marie);
            System.out.println(bal);
            if(!bal.toString().equals("[marie]")) {
                System.out.println("Test 3 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }
        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }

        try {
            System.out.println("ajout nico (M)");
            bal.ajouterEtudiant(nico);
            System.out.println(bal);
            if(!bal.toString().equals("[nico, marie]")) {
                System.out.println("Test 3 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }
        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }

        try {
            System.out.println("ajout jeanne (F)");
            bal.ajouterEtudiant(jeanne);
            System.out.println(bal);
            if(!bal.toString().equals("[nico, marie, jeanne]")) {
                System.out.println("Test 3 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }
        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }

        try {
            System.out.println("ajout sam (M)");
            bal.ajouterEtudiant(sam);
            System.out.println(bal);
            if(!bal.toString().equals("[nico, sam, marie, jeanne]")){
                System.out.println("Test 3 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }
        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }

        try {
            System.out.println("ajout hugo (M)");
            bal.ajouterEtudiant(hugo);
            System.out.println(bal);
            if(! bal.toString().equals("[nico, sam, hugo, marie, jeanne]")){
                System.out.println("Test 3 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }

        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }

        try {
            System.out.println("ajout tim (M)");
            bal.ajouterEtudiant(tim);
            System.out.println(bal);
            if(! bal.toString().equals("[nico, sam, hugo, tim, marie, jeanne]")){
                System.out.println("Test 3 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }

        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }

        try {
            System.out.println("ajout lea (F)");
            bal.ajouterEtudiant(lea);
            System.out.println(bal);
            if(! bal.toString().equals("[nico, sam, hugo, tim, marie, jeanne, lea]")){
                System.out.println("Test 3 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }
        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }

        try {
            System.out.println("ajout mia (F)");
            bal.ajouterEtudiant(mia);
            System.out.println(bal);
            if(! bal.toString().equals("[nico, sam, hugo, tim, marie, jeanne, lea, mia]")){
                System.out.println("Test 3 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }
        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }

        System.out.println("Test 3 ok");
        System.out.println();


        System.out.println("Test 4 : ordre des ajouts : nico marie sam jeanne hugo tom lea mia");
        if(choix==1)
            bal = new Bal1();
        else
            bal = new Bal2();
        try {
            System.out.println("ajout nico (M)");
            bal.ajouterEtudiant(nico);
            System.out.println(bal);
            if(!bal.toString().equals("[nico]")) {
                System.out.println("Test 4 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }
        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }

        try {
            System.out.println("ajout marie (F)");
            bal.ajouterEtudiant(marie);
            System.out.println(bal);
            if(!bal.toString().equals("[nico, marie]")) {
                System.out.println("Test 4 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }
        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }

        try {
            System.out.println("ajout sam (M)");
            bal.ajouterEtudiant(sam);
            System.out.println(bal);
            if(!bal.toString().equals("[nico, sam, marie]")){
                System.out.println("Test 4 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }
        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }

        try {
            System.out.println("ajout jeanne (F)");
            bal.ajouterEtudiant(jeanne);
            System.out.println(bal);
            if(!bal.toString().equals("[nico, sam, marie, jeanne]")) {
                System.out.println("Test 4 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }
        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }

        try {
            System.out.println("ajout hugo (M)");
            bal.ajouterEtudiant(hugo);
            System.out.println(bal);
            if(! bal.toString().equals("[nico, sam, hugo, marie, jeanne]")){
                System.out.println("Test 4 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }

        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }

        try {
            System.out.println("ajout tim (M)");
            bal.ajouterEtudiant(tim);
            System.out.println(bal);
            if(! bal.toString().equals("[nico, sam, hugo, tim, marie, jeanne]")){
                System.out.println("Test 4 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }

        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }

        try {
            System.out.println("ajout lea (F)");
            bal.ajouterEtudiant(lea);
            System.out.println(bal);
            if(! bal.toString().equals("[nico, sam, hugo, tim, marie, jeanne, lea]")){
                System.out.println("Test 4 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }
        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }

        try {
            System.out.println("ajout mia (F)");
            bal.ajouterEtudiant(mia);
            System.out.println(bal);
            if(! bal.toString().equals("[nico, sam, hugo, tim, marie, jeanne, lea, mia]")){
                System.out.println("Test 4 ko");
                System.out.println("Revoyez votre methode!");
                return;
            }
        }catch (Exception e){
            System.out.println("Exception inattendue");
            e.printStackTrace();
            return;
        }
        System.out.println("Test 4 ok");
        System.out.println();


        System.out.println("Tous les scenarios se sont bien deroules");
    }
    
}
