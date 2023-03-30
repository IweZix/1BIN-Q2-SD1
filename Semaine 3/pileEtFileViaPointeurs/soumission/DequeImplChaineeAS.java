/**
 * @author NICOLAS Luca
 */

public class DequeImplChaineeAS<E> implements Deque<E>{


    private Noeud tete ;
    private Noeud queue ;
    private int taille ;

    public DequeImplChaineeAS(){
        tete=new Noeud(null);
        queue=new Noeud(null);
        tete.suivant=queue;
        queue.precedent=tete;
        taille=0;
    }

    /**
     * renvoie le nombre d'elements qui se trouvent dans le deque
     * @return nombre d'elements
     */
    public int taille() {
        return this.taille ;
    }

    /**
     * verifie si le deque est vide
     * @return true si le deque est vide, false sinon
     */
    public boolean estVide() {
        return (taille==0) ;
    }

    /**
     * ajoute un element au debut du deque (tete)
     * @param element l'element a ajouter
     */
    public void ajouterEnPremier(E element) {
        Noeud n = new Noeud(element);

        n.suivant=tete.suivant;
        tete.suivant.precedent=n;
        tete.suivant=n;
        n.precedent=tete;
        taille++;
    }

    /**
     * renvoie l'element qui se trouve en tete du deque et l'enleve du deque
     * @return l'element en tete
     * @throws DequeVideException si le deque est vide
     */
    public E retirerPremier() {
        if (estVide()) throw new  DequeVideException();
        Noeud n = tete.suivant;
        tete.suivant=n.suivant;
        n.suivant.precedent=tete;
        taille--;
        return n.element;
    }

    /**
     * ajoute un element en fin du deque (queue)
     * @param element l'element a ajouter
     */
    public void ajouterEnDernier(E element) {
        Noeud n = new Noeud(element);
        n.precedent=queue.precedent;
        queue.precedent.suivant=n;
        queue.precedent=n;
        n.suivant=queue;
        taille++;
    }

    /**
     * renvoie l'element qui se trouve en queue du deque et l'enleve du deque
     * @return l'element en queue
     * @throws DequeVideException si le deque est vide
     */
    public E retirerDernier() throws DequeVideException {
        if (estVide()) throw new  DequeVideException();
        Noeud n = queue.precedent;
        queue.precedent=n.precedent;
        n.precedent.suivant=queue;
        taille--;
        return n.element;
    }

    /**
     * renvoie l'element qui se trouve en tete du deque sans l'enlever du deque
     * @return l'element en tete
     * @throws DequeVideException si le deque est vide
     */
    public E premier()throws DequeVideException {
        if (estVide()) throw new  DequeVideException();
        return tete.suivant.element;
    }

    /**
     * renvoie l'element qui se trouve en queue du deque sans l'enlever du deque
     * @return l'element en queue
     * @throws DequeVideException si le deque est vide
     */
    public E dernier()throws DequeVideException {
        if (estVide()) throw new  DequeVideException();
        return queue.precedent.element;
    }


    // A NE PAS MODIFIER --> POUR LES TESTS!!!
    // tete 'a' 'b' 'c' queue : ['a','b','c']
    public DequeImplChaineeAS(Object[] table) {
        if(table == null)
            throw new IllegalArgumentException();
        taille = 0 ;
        tete = new Noeud(null) ;
        queue = new Noeud(null) ;
        tete.suivant=queue;
        queue.precedent=tete;
        if(table.length==0)
            return;
        for (int i = table.length-1; i>=0;i--) {
            this.ajouterTest((E) table[i]) ;
        }
    }

    // A NE PAS MODIFIER --> POUR LES TESTS!!!
    public String toString(){
        String aRenvoyer="";
        Noeud baladeur=tete.suivant;
        int cpt = 0;
        while(baladeur!=queue) {
            cpt++;
            if(cpt>taille){
                aRenvoyer = "boucle infinie dans toString(), chainage a verifier";
            }
            aRenvoyer+=baladeur.element;
            if (baladeur.suivant != queue)
                aRenvoyer += " " ;
            baladeur=baladeur.suivant;
        }
        return aRenvoyer;
    }

    // A NE PAS MODIFIER --> POUR LES TESTS!!!
    public String parcoursInverse(){
        String aRenvoyer="";
        Noeud baladeur=queue.precedent;
        int cpt = 0;
        while(baladeur!=tete) {
            cpt++;
            if(cpt>taille){
                aRenvoyer = "boucle infinie dans toString(), chainage a verifier";
            }
            aRenvoyer+=baladeur.element;

            if (baladeur.precedent != tete)
                aRenvoyer += " " ;
            baladeur=baladeur.precedent;
        }
        return aRenvoyer;
    }

    // A NE PAS MODIFIER --> POUR LES TESTS!!!
    public void ajouterTest(E element) {
        Noeud nouveauNoeud = new Noeud(element) ;
        nouveauNoeud.suivant = tete.suivant;
        nouveauNoeud.precedent = tete;
        tete.suivant.precedent = nouveauNoeud;
        tete.suivant = nouveauNoeud;
        taille++;
    }


    // classe interne
    private class Noeud{
        private E element;
        private Noeud precedent;
        private Noeud suivant;

        private Noeud(E element){
            this.element = element;
            this.precedent = null ;
            this.suivant = null;
        }

        private Noeud(E element, Noeud precedent, Noeud suivant){
            this.element = element;
            this.precedent = precedent ;
            this.suivant = suivant;
        }
    }
}
