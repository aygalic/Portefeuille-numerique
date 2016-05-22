package bts.tpmatch;
import java.util.Calendar;
import java.util.Date;

public class Match {
	//atribus
	private String stade;
	private Date date=Calendar.getInstance( ).getTime( );
	private int scoreEquipe1 = 0, scoreEquipe2 = 0;
	private Equipe equipe1, equipe2;
	//constructeur
	public Match(Equipe equipe1, Equipe equipe2, String stade){
		this.equipe1=equipe1;
		this.equipe2=equipe2;
		this.stade=stade;
	}
	public Match(Equipe equipe1, Equipe equipe2, String stade, Date date){
		this.equipe1=equipe1;
		this.equipe2=equipe2;
		this.stade=stade;
		this.date=date;
	}
	//methode add UML
	public void setScoreEquipe1(int score){
		if(scoreEquipe1!=0){
			equipe1.removePoint(scoreEquipe1);
			this.scoreEquipe1=score;
			equipe1.addPoint(score);
		}
		else{
			equipe1.addPoint(score);
		}
		
	}
	public void setScoreEquipe2(int score){
		if(scoreEquipe2!=0){
			equipe2.removePoint(scoreEquipe2);
			this.scoreEquipe2=score;
			equipe2.addPoint(score);
		}
		else{
			equipe2.addPoint(score);
		}
		
	}
	//geters
	public Equipe getGagnant(){
		if(scoreEquipe1>scoreEquipe2)
			return equipe1;
		else if(scoreEquipe1<scoreEquipe2)
			return equipe2;
		return null;
	}
	public Equipe getPerdant(){
		if(scoreEquipe1<scoreEquipe2)
			return equipe1;
		else if(scoreEquipe1>scoreEquipe2) 
			return equipe2;
		return null;
	}
	public int getScoreEquipe1(){
		return scoreEquipe1;
	}
	public int getScoreEquipe2(){
		return scoreEquipe2;
	}
	public String getStade(){
		return stade;
	}
	public Date getDate(){
		return date;
	}
}
