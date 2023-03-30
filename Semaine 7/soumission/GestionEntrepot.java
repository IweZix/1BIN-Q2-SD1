public class GestionEntrepot {
    //private static Scanner scanner = new Scanner(System.in);
    private static MonScanner scanner = new MonScanner("commandes.txt");
    private static Entrepot entrepot;

    public static void main(String[] args) {
        System.out.println("*********************");
        System.out.println("Gestion d'un entrepot");
        System.out.println("*********************");
        System.out.println();
        System.out.print("Entrez le nombre d'hangars : ");
        int nombreHangars = scanner.nextInt();
        entrepot = new Entrepot(nombreHangars);
        int choix = 0;
        do {
            System.out.println();
            System.out.println("1 -> attribuer un hangar");
            System.out.println("2 -> lister les hangars d'une societe");
            System.out.println("3 -> libérer un hangar");
            System.out.println("4 -> ajouter un véhicule");
            System.out.println("5 -> vérifier une plaque");
            System.out.println("6 -> quitter");
            System.out.println();
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    attribuerUnHangar();
                    break;
                case 2:
                    listerLesHangars();
                    break;
                case 3:
                    libererHangar();
                    break;
                case 4:
                    ajoutVehicule();
                    break;
                case 5:
                    verifierPlaque();
                    break;
                case 6:
                    break;
            }

        } while (choix!=7);

        System.out.println("Fin");
    }

    private static void attribuerUnHangar() {
        if (entrepot.nombreHangarsLibres()==0) {
            System.out.println("Désolé, tous les hangars sont occupes !");
        } else {
            System.out.print("Entrez le numéro de la societe : ");
            int numeroSociete = scanner.nextInt();
            Societe societe = entrepot.getSociete(numeroSociete);
            String nomSociete;
            if(societe==null){
                System.out.print("Entrez le nom de la societe : ");
                nomSociete = scanner.next();
            }else{
                nomSociete = societe.getNom();
            }
            System.out.println();
            int numeroHangar = entrepot.attribuerHangar(numeroSociete,nomSociete);
            System.out.println("Le numero du hangar attribue : " + numeroHangar);
        }
    }

    private static void listerLesHangars() {
        System.out.print("Entrez le numéro de la société : ");
        int numeroSociete = scanner.nextInt();
        Societe s = entrepot.getSociete(numeroSociete);
        if (s == null) {
            System.out.println("Cette société n'existe pas");
            return;
        }
        System.out.println("Société " + s.getNom() + " n°" + s.getNumeroSociete() + ", possède les hangars : " + s.lesHangars());
    }

    private static void libererHangar() {
        System.out.print("Entrez le numéro du hangar que vous voulez libérer : ");
        int hangar = scanner.nextInt();
        entrepot.libererHangar(hangar);
    }

    private static void ajoutVehicule() {
        System.out.print("Entrez le numéro de la société à laquelle vous voulez ajouter une plaque : ");
        int numSociete = scanner.nextInt();
        System.out.print("Entrez la plaque d'immatriculation que vous voulez ajouter à la société : ");
        String plaque = scanner.next();
        if (entrepot.ajouterPlaque(numSociete, plaque))
            System.out.println("La plaque à été ajoutée à  la société n°" + numSociete);
        else
            System.out.println("La plaque n'as pas été ajoutée");
    }

    private static void verifierPlaque() {
        System.out.print("Entrez la plaque d'immatriculation que vous voulez vérifier : ");
        String plaque = scanner.next();
        if (entrepot.estAutorisee(plaque))
            System.out.println("La plaque est autorisé");
        else
            System.out.println("La plaque à été refusée");

    }
}
