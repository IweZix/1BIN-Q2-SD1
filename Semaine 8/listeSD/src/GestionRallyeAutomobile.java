import java.util.Scanner;

public class GestionRallyeAutomobile {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println();
        System.out.println("""
                ********************************************
                * Programme de gestion de rally automobile *
                ********************************************""");
        System.out.println();
        System.out.print("Entrez le nombres de pilotes : ");
        int nbrPilotes=  scanner.nextInt();
        String[] tableauPilotes = new String[nbrPilotes];
        for (int i = 0; i < nbrPilotes; i++) {
            int val = i+1;
            System.out.println("Entrez le nom du pilote n°" + val + " : ");
            String pilote = scanner.next();
            tableauPilotes[i] = pilote;
        }
        RallyeAutomobile rally = new RallyeAutomobile(tableauPilotes);
        System.out.println();
        System.out.println();

        int choix;
        do {
            System.out.println("********************************************************");
            System.out.println();
            System.out.println("1 -> Afficher toute la course");
            System.out.println("2 -> Afficher le pilote en tête");
            System.out.println("3 -> Enregistrer un dépassement");
            System.out.println("4 -> Disqualifier un pilote");
            System.out.println("5 -> Donner la position d’un pilote");
            System.out.println("6 -> Faire franchir la ligne d’arrivée au pilote de tête");
            System.out.println("7 -> Remettre un pilote dans la course (après un autre pilote)");
            System.out.println("8 -> Afficher les pilotes hors course");
            System.out.println("9 -> Afficher le classement");
            System.out.println("0 -> Quitter");
            System.out.println();
            System.out.println("********************************************************");
            choix = scanner.nextInt();
            switch (choix) {
                case 1 -> afficherCourse(rally);
                case 2 -> piloteEnTete(rally);
                case 3 -> {
                    System.out.print("Entrez le pilote qui depasse : ");
                    depassement(scanner.next(), rally);
                }
                case 4 -> {
                    System.out.print("Entrez le pilote à disqualifier :");
                    piloteHorsCourse(scanner.next(), rally);
                }
                case 5 -> {
                    System.out.print("Entrez le pilote dont vous voulez connaitre la poisition : ");
                    position(scanner.next(), rally);
                }
                case 6 -> ligneArrivee(rally);
                case 7 -> {
                    System.out.print("Entrez le pilote que vous voulez remettre en course : ");
                    String piloteARemttre = scanner.next();
                    System.out.print("Entrez le pilote derrière lequel il sera remit en course : ");
                    String derriere = scanner.next();
                    remettreEnCourse(piloteARemttre, derriere, rally);
                }
                case 8 -> afficherPiloteHorsCourse(rally);
                case 9 -> afficherClassement(rally);
                default -> {
                }
            }
            if (rally.isFinished()){
                System.out.println("La course est terminée");
                System.out.println("Voici le résultat finale :");
                afficherClassement(rally);
                choix = 0;
            }
        } while (choix >= 1 && choix <= 9);
    }


    private static void afficherCourse(RallyeAutomobile rallye){
        String string = rallye.afficherCourse();
        if (string.equals("")) {
            System.out.println("Il n'y a plus aucune pilote dans la course");
            return;
        }
        System.out.println(string);
    }

    private static void piloteEnTete(RallyeAutomobile rallye){
        String string = rallye.piloteEnTete();
        if (string == null) {
            System.out.println("Il n'y a plus aucune pilote dans la course");
            return;
        }
        System.out.println(string);
    }

    private static void depassement(String pilote, RallyeAutomobile rallye){
        boolean bool = rallye.depassement(pilote);
        if (bool){
            System.out.println("Le pilote à effectuer son dépassement");
        } else {
            System.out.println("Le pilote n'as pas pu effectuer son dépassement");
        }
    }

    private static void piloteHorsCourse(String pilote, RallyeAutomobile rallye){
        int result = rallye.piloteHorsJeu(pilote);
        if (result == 1){
            System.out.println("Ce pilote n'est pas en course");
            return;
        }
        System.out.println("Le pilote " + pilote + " a subis une exclusion");
    }

    private static void position(String pilote, RallyeAutomobile rally) {
        int result = rally.position(pilote);
        if (result == -1){
            System.out.println("Ce pilote n'est pas en course");
            return;
        }
        System.out.println("Le pilote est en " + result + " ème position");
    }

    private static void ligneArrivee(RallyeAutomobile rally){
        String string = rally.ligneArrivee();
        if (string == null) {
            System.out.println("Aucun pilote n'as passer la ligne d'arrivée car il n'y a plus personne en course");
            return;
        }
        System.out.println("Le pilote en tête a passer la ligne d'arrivée");
        System.out.println(string);
    }

    private static void remettreEnCourse(String piloteARemettre, String derriere, RallyeAutomobile rally){
        int result = rally.remettreEnCourse(piloteARemettre, derriere);
        if (result == -1) {
            System.out.println("Ce pilote n'est pas hors course");
            return;
        }
        if (result == -2) {
            System.out.println("Le pilote derrière lequel on veut rajouter le le pilote n'est pas en course");
            return;
        }
        System.out.println("Le pilote a été remis en course");
    }

    private static void afficherPiloteHorsCourse(RallyeAutomobile rallye){
        String string = rallye.afficherPiloteHorsCourse();
        if (string == null){
            System.out.println("Aucun pilote n'est hors course");
            return;
        }
        System.out.println("Voici les pilotes hors course : ");
        System.out.println(string);
    }

    private static void afficherClassement(RallyeAutomobile rallye){
        String string = rallye.afficherClassement();
        if (string == null){
            System.out.println("Aucun pilote n'as encore franchis la ligne d'arrivée");
            return;
        }
        System.out.println("Voici les pilotes ayant franchis la ligne d'arrivée");
        System.out.println(string);
    }
}
