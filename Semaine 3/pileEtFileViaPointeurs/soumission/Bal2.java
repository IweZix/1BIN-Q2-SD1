import java.util.ArrayDeque;

public class Bal2 implements Bal{

    /**
     * Cette classe retient les etudiants inscrits au bal
     * Une liste contient les hommes, une autre liste contient les femmes
     * Dans chacune des listes, l'ordre suit l'ordre des inscriptions
     *
     * @author NICOLAS Luca
     *
     */

    ArrayDeque<Etudiant> dequeH;
    ArrayDeque<Etudiant> dequeF;

    /**
     * construit un bal "vide", les 2 listes sont vides
     */
    public Bal2(){
        dequeH = new ArrayDeque<Etudiant>();
        dequeF = new ArrayDeque<Etudiant>();
    }

    /**
     * ajoute l etudiant dans la liste en tenant compte de l'ordre prevu
     * @param etudiant l etudiant a ajouter
     * @throws IllegalArgumentException si l etudiant est null
     */
    public void ajouterEtudiant(Etudiant etudiant){
        if(etudiant==null)
            throw new IllegalArgumentException("etudiant null");
        if (etudiant.getSexe() == 'M') {
            dequeH.addLast(etudiant);
        } else {
            dequeF.addLast(etudiant);
        }
    }

    //A NE PAS MODIFIER
    //VA SERVIR POUR LES TESTS
    public String toString(){
        String listeH = dequeH.toString();
        listeH = listeH.substring(0,listeH.length()-1);
        String listeF = dequeF.toString();
        listeF = listeF.substring(1,listeF.length());
        if(listeH.length()>1 && listeF.length()>1)
            listeF = ", "+listeF;
        return listeH + listeF;
    }

}


