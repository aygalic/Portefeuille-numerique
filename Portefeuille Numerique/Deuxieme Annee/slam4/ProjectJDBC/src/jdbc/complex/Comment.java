package jdbc.complex;

import java.util.Date;

public class Comment {
	private String id, content;
	private Date date;
	
	public Comment(String i, String c, Date d){
		this.id=i;
		this.content=c;
		this.date=d;
	}
	public void setId(String i){
		this.id=i;
	}
	public void setContent(String c){
		this.content=c;
	}
	public void setDate(Date d){
		this.date=d;
	}
	public String getId(){
		return this.id;
	}
	public String getContent(){
		return this.content;
	}
	public Date getDate(){
		return this.date;
	}
}
