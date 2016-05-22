package bts.tpmatch;

public class Equipe {
	//Compeur magic
	private int nbJoueur = 0;
	//Attribus
	private String nom, coach, ville;
	private Joueur[] joueurs= new Joueur[5];
	private int cumul;
	//Constructeurs
	public Equipe(String nom, String ville){
		this.nom=nom;
		this.ville=ville;
	}
	public Equipe(String nom, String ville, String coatch){
		this.nom=nom;
		this.ville=ville;
		this.coach=coatch;
	}
	//getter
	public String getNom(){
		return nom;
	}
	public String getCoach(){
		return coach;
	}
	public String getVille(){
		return ville;
	}
	public Joueur[] getJoueur(){
		return joueurs;
	}
	public int getCumul(){
		return cumul;
	}
	//setter
	public void setNom(String nom){
		this.nom=nom;
	}
	public void setCoach(String coach){
		this.coach=coach;
	}
	public void setVille(String ville){
		this.ville=ville;
	}
	//methodes liée à l'UML
	public void addJoueur(Joueur joueur){
		
		this.joueurs[nbJoueur]=joueur;
		nbJoueur++;
	}
	public void addPoint(int nbPoint){
		this.cumul=this.cumul+nbPoint;
	}
	public void removeJoueur(int num){
		   
		this.joueurs[getJoueurWithNumero(num)]=null;
	}
	public void removePoint(int nbPoint){
		this.cumul=this.cumul-nbPoint;
	}
	//la methode chiante
	private int getJoueurWithNumero(int numero){
		for(int i=0; i<5; i++){
			if(joueurs[i].getNumero()==numero)
				return i;	
		}
		return -1;
	}
}
