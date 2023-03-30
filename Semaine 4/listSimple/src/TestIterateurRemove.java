import java.util.Iterator;
import java.util.ConcurrentModificationException;

public class TestIterateurRemove {

    public static void main(String[] args) {
        System.out.println("***************************************************************************") ;
        System.out.println("* Bienvenue dans la classe qui va tester la méthode remove de l'itérateur *") ;
        System.out.println("***************************************************************************") ;
        System.out.println() ;
        int temps = 300 ;
        boolean testOK = true ;
        String[] tli = {"a","b","c","d","e"} ;
        ListeSimple<String> li = new ListeSimpleImpl<String>(tli);
        Iterator<String> it = li.iterator();
        System.out.print("Test 1 : remove quand l'élément suivant est la tête : ") ;
        try {
            it.remove() ;
            System.out.println("KO : Il fallait une exception car on ne peut pas faire un remove quand l'élément suivant est la tete");
            testOK = false ;
        } catch(IllegalStateException e) {
            String lis =" a b c d e" ;
            if (!li.toString().equals(lis)) {
                System.out.println("KO : Il ne fallait pas modifier la liste : ") ;
                System.out.println("Liste attendue : |"+lis+"|") ;
                System.out.println("Liste reçue    : |"+li+"|") ;
                testOK = false ;
            } else {
                System.out.println("OK");
            }
        } catch(Exception e) {
            System.out.println("KO : mauvais type d'exception : "+e.getClass()+" au lieu de IllegalStateException") ;
            testOK = false ;
        }
        System.out.println() ;
        System.out.print("Test 2 : remove de la tete : ");
        it.next() ;
        try {
            it.remove() ;
            String lis =" b c d e" ;
            if (!li.toString().equals(lis)) {
                System.out.println("KO : mauvais état de liste : liste de départ : "+"| a b c d e|") ;
                System.out.println("Liste attendue après remove : |"+lis+"|") ;
                System.out.println("Liste reçue après remove    : |"+li+"|") ;
                testOK = false ;
            } else {
                System.out.println("OK");
            }
        } catch(Exception e) {
            System.out.println("KO : il ne fallait pas d'exception :") ;
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            }
            catch(InterruptedException ex) {
            }
            testOK = false ;
        }
        System.out.println() ;
        System.out.print("Test 3 : deux remove en suivant sans next entre les deux : ") ;
        try {
            it.remove() ;
            System.out.println("KO = Il fallait une IllegalStateException");
            testOK = false ;
        } catch(IllegalStateException e) {
            String lis =" b c d e" ;
            if (!li.toString().equals(lis)) {
                System.out.println("KO : Il ne fallait pas modifier la liste | b c d e| : ") ;
                System.out.println("Etat attendu : |"+lis+"|") ;
                System.out.println("Etat reçu : |"+li+"|") ;
                testOK = false ;
            } else {
                System.out.println("OK");
            }
        } catch(Exception e) {
            System.out.println("KO : mauvais type d'exception : "+e.getClass()+" au lieu de IllegalStateException") ;
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            }
            catch(InterruptedException ex) {
            }
            testOK = false ;
        }
        System.out.println() ;
        System.out.print("Test 4 : remove au milieu de la liste : ");
        it.next() ;
        it.next() ;
        try {
            it.remove() ;
            String lis =" b d e" ;
            if (!li.toString().equals(lis)) {
                System.out.println("KO : mauvais état de liste : liste de départ : | b c d e|") ;
                System.out.println("Liste attendue après remove : |"+lis+"|") ;
                System.out.println("Liste reçue après remove    : |"+li+"|") ;
                testOK = false ;
            } else {
                System.out.println("OK");
            }
        } catch(Exception e) {
            System.out.println("KO : Il ne fallait pas d'exception : ");
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            }
            catch(InterruptedException ex) {
            }
            testOK = false ;
        }
        System.out.println() ;
        System.out.print("Test 5 : remove du dernier élément de la liste : ");
        it.next() ;
        it.next() ;
        try {
            it.remove() ;
            String lis =" b d" ;
            if (!li.toString().equals(lis)) {
                System.out.println("KO : mauvais état de liste : liste de départ : | b d e|") ;
                System.out.println("Liste attendue après remove : |"+lis+"|") ;
                System.out.println("Liste reçue après remove    : |"+li+"|") ;
                testOK = false ;
            } else {
                System.out.println("OK");
            }
        } catch(Exception e) {
            System.out.println("KO : Il ne fallait pas d'exception : ") ;
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            }
            catch(InterruptedException ex) {
            }
            testOK = false ;
        }
        System.out.println() ;
        System.out.print("Test 6 : remove après une modification de la liste externe à l'itérateur : ");
        String[] tli2 = {"a","b","c","d","e"} ;
        li = new ListeSimpleImpl<String>(tli2) ;
        it = li.iterator() ;
        it.next() ;
        it.next() ;
        try {
            li.insererApres("b","x");
            it.remove() ;
            System.out.println("KO : Il fallait une ConcurrentModificationException");
            testOK = false ;
        } catch(ConcurrentModificationException e) {
            String lis = " a b x c d e" ;
            if (!li.toString().equals(lis)) {
                System.out.println("KO : Il ne fallait pas modifier la liste : liste de départ : |"+lis+"|") ;
                System.out.println("Etat attendu : |"+lis+"|") ;
                System.out.println("Etat reçu : |"+li+"|") ;
                testOK = false ;
            } else {
                System.out.println("OK");
            }
        } catch(Exception e) {
            System.out.println("KO : mauvais type d'exception : "+e.getClass()+" au lieu de ConcurrentModificationException") ;
            e.printStackTrace();
            try {
                Thread.sleep(temps);
            }
            catch(InterruptedException ex) {
            }
            testOK = false ;
        }
        System.out.println() ;
        if (testOK) {
            System.out.println("Bravo ! Tous les tests ont réussi !");
        } else {
            System.out.println("Attention ! Au moins un test a échoué !");
        }
    }
}
