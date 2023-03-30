/**
 * @author 
 *
 */

public class Parenthesage{
   
	/**
	 * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
	 * 
	 * @param messageErreur message a afficher en cas de probleme
	 * @param attendu la valeur qu'on s'attendait a recevoir
	 * @param recu la valeur qu'on a reçu en realite
	 */
	private static void assertEquals(String messageErreur, Object attendu, Object recu) {
		if (attendu==null) {
			if (recu!=null) {
				System.out.println(messageErreur+". Attendu="+attendu+" reçu="+recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {
			System.out.println(messageErreur+". Attendu="+attendu+" reçu="+recu);
			System.exit(0);			
		}
	}
	
	public static void main(String[] args) {

		assertEquals("test ko : (a+b)", true, verificationParenthesage("(a+b)")); 
		assertEquals("test ko : (a+b]", false, verificationParenthesage("(a+b]")); 
		assertEquals("test ko : (a+b", false, verificationParenthesage("(a+b"));
		assertEquals("test ko :  a+b)", false, verificationParenthesage("a+b)"));
		assertEquals("test ko : if(a==b||a==c){return (tab[i]-1)*2}", true, verificationParenthesage("if(a==b||a==c){return (tab[i]-1)*2}"));
		assertEquals("test ko : if(a==b||a==c{return (tab[i]-1)*2}", false,verificationParenthesage("if(a==b||a==c{return tab[i]-1}")); 
		assertEquals("test ko : if a==b||a==c){return (tab[i]-1)*2}", false, verificationParenthesage("if a==b||a==c){return tab[i]-1}"));
		assertEquals("test ko : if((a==b||a==c){return (tab[i]-1)*2}", false,verificationParenthesage("if((a==b||a==c){return tab[i]-1}"));
		assertEquals("test ko : if(a==b||a==c){return (tab[i)-1)*2}", false,verificationParenthesage("if(a==b||a==c){return tab[i)-1}"));
		assertEquals("test ko : if(a==b||a==c)[return (tab[i]-1)*2}", false,verificationParenthesage("if(a==b||a==c)[return tab[i]-1}"));
		assertEquals("test ko : if(a==b||a==c){return (tab[i]-1)*2}}", false,verificationParenthesage("if(a==b||a==c){return tab[i]-1}}"));	
		assertEquals("test ko : if((a==b||a==c){return (tab[i]-1)*2}", false,verificationParenthesage("if((a==b||a==c){return tab[i]-1}"));
		System.out.println("Tous les tests ont reussi!");
	}
	
	
	
	public static boolean verificationParenthesage(String texte){
		// TODO
		// Cette methode necessite une pile!
		// Reflechissez bien a son contenu!
		return false;
	}	 
} 
