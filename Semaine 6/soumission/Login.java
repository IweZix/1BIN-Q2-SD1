/**
 * @author NICOLAS Luca
 */

public class Login {
   
 	private String login;
	
 	public Login(String login)throws IllegalArgumentException{
		if(login==null || login.length() != 7 || (!login.substring(0,4).equals("info")&&
				!login.substring(0,4).equals("mark")&&!login.substring(0,4).equals("admi")))
			throw new IllegalArgumentException("login incorrect");
		this.login = login;
	}

	public String toString(){
		return "/n"+login +"   "+login;
	}

	public int hashCode(){
		 if (login.substring(0,4).equals("info"))
			 return Integer.parseInt(login.substring(4,7)) - 1;
		 if (login.substring(0,4).equals("mark"))
			 return Integer.parseInt(login.substring(4,7)) + 136;
		 if (login.substring(0,4).equals("admi"))
			 return Integer.parseInt(login.substring(4,7)) + 209;
		 return -1;
	}
}