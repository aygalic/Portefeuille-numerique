package jdbc.complex;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment {
	private String content, login;
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	private Date date;
	
	public Comment(String l,String c, Date d){
		this.login=l;
		this.content=c;
		this.date=d;
	}
	/**
	 * Constructeur avec ID permettant la suppression d'un commentaire
	 * @param i
	 * @param l
	 * @param c
	 * @param d
	 */
	public Comment(int i,String l,String c, Date d){
		this.id=i;
		this.login=l;
		this.content=c;
		this.date=d;
	}

	public void setContent(String c){
		this.content=c;
	}
	public void setDate(Date d){
		this.date=d;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getContent(){
		return this.content;
	}
	public String getDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(this.date);
	}
	@Override
	public String toString(){
		return this.login+this.login+this.content;
	}
}
