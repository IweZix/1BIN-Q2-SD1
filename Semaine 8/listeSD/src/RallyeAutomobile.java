public class RallyeAutomobile {

    private ListeSDImpl<String> listePilote;
    private ListeSDImpl<String> arrivee;
    private ListeSDImpl<String> piloteHorsCourse;

    public RallyeAutomobile(String[] lesPilotes) {
        listePilote = new ListeSDImpl<>();
        arrivee  = new ListeSDImpl<>();
        piloteHorsCourse = new ListeSDImpl<>();
        for (int i = 0; i < lesPilotes.length; i++) {
            listePilote.insererEnQueue(lesPilotes[i]);
        }
    }

    /**
     * Affiche la course actuelle
     */
    public String afficherCourse(){
        return listePilote.toString();
    }

    /**
     * Affiche le pilote en tête de course
     */
    public String piloteEnTete(){
        return listePilote.premier();
    }

    /**
     * Permet à un pilote de faire un dépassement
     * @param pilote le pilote qui dépasse
     */
    public boolean depassement(String pilote){
        return listePilote.permuter(pilote, listePilote.donnerPrecedent(pilote));
    }

    /**
     * Permet de mettre un pilote hors course
     * @param pilote le pilote à mettre hors course
     * @return -1 s'il n'est pas en course sinon 0
     */
    public int piloteHorsJeu(String pilote){
        if (!listePilote.contient(pilote)){
            return - 1;
        }
        listePilote.supprimer(pilote);
        piloteHorsCourse.insererEnQueue(pilote);
        return 0;
    }

    /**
     * Permet de donner la position d'un pilote
     * @param pilote le pilot dont on veut connaitre la position
     * @return -1 si le pilote n'est pas en course sinon sa position
     */
    public int position(String pilote){
        if (!listePilote.contient(pilote)){
            return -1;
        }
        int position = 1;
        for (String p : listePilote) {
            if (pilote.equals(p)){
                break;
            }
            position++;
        }
        return position;
    }

    /**
     * Permet de faire passer la ligne d'arrivée au pilote en tête
     * @return null s'il n'y a plus personne dans la course sinon un String avec ceux qui ont passés la ligne d'arrivée
     */
    public String ligneArrivee(){
        if (listePilote.premier() == null){
            return null;
        }
        arrivee.insererEnQueue(listePilote.premier());
        listePilote.supprimer(listePilote.premier());
        return arrivee.toString();
    }

    /**
     * Permet de remettre un pilote en course après un autre
     * @param piloteARemettre le pilote qui retourne en course
     * @param piloteDevant le pilote derrière lequel on va rajouter un pilote
     * @return -1 si piloteARemettre n'est pas hors course, -2 si piloteDevant n'est pas en course sinon 0
     */
    public int remettreEnCourse(String piloteARemettre, String piloteDevant){
        if (!piloteHorsCourse.contient(piloteARemettre)){
            return -1;
        }
        if (!listePilote.contient(piloteDevant)){
            return -2;
        }
        piloteHorsCourse.supprimer(piloteARemettre);
        listePilote.insererApres(piloteDevant, piloteARemettre);
        return 0;
    }

    /**
     * Permet d'afficher les pilotes hors course
     * @return null si auncun pilote n'est hors course sinon un String avec les pilotes hors course
     */
    public String afficherPiloteHorsCourse(){
        if (piloteHorsCourse.estVide()){
            return null;
        }
        return piloteHorsCourse.toString();
    }

    /**
     * Permet d'afficher les pilotes ayant déjà passé la ligne d'arrivée
     * @return null si aucune pilote n'as passé la ligne d'arrivée sinon un String avec les pilotes ayant passé la ligne d'arrivée
     */
    public String afficherClassement(){
        if (arrivee.estVide()){
            return null;
        }
        return arrivee.toString();
    }

    public boolean isFinished(){
        return listePilote.estVide();
    }
}