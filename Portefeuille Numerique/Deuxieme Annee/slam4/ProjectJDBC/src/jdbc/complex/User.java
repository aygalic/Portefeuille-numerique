package jdbc.complex;


public class User {
	private String login, nom, password;
	public User(String login, String nom, String password){
		this.login=login;
		this.nom=nom;
		this.password=password;
		
	}
	public void setNom(String nom){
		this.nom=nom;
	}
	public void setLogin(String login){
		this.login=login;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getLogin(){
		return this.login;
	}
	public String getNom(){
		return this.nom;
	}
	public String getPassword(){
		return this.password;
	}
}
