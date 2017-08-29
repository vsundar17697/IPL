package Bean;

public class user{
	String username, password;
	public void setn(String u){
		username = u;
	}
	public void setp(String u){
		password = u;
	}
	public String getn(){
		return username;
	}
	public String getp(){
		return password;
	}
}