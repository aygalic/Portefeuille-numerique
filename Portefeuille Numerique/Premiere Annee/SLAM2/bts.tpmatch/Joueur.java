package bts.tpmatch;

public class Joueur {
	//initialisation des attribus
	private String nom, prenom;
	private int poste, numero;
	public static final int DEFENSE=1, ATTAQUE=2, MILIEU=3;
	
	//constructeurs
	public Joueur(){
		
	}
	public Joueur(String nom, String prenom, int poste, int numero){
		this.nom=nom;
		this.prenom=prenom;
		this.poste=poste;
		this.numero=numero;
	}
	//methode get
	public String getNom(){
		return nom;
	}
	public String getPrenom(){
		return prenom;
	}
	public String getPoste(){
		String p= "-1";
		switch(this.poste){
		case (DEFENSE):
			p = "Defense";
			break;
		case (ATTAQUE):
			p = "Attaque";
			break;
		case (MILIEU):
			p = "Milieur";
			break;
		}
		return p;
		
	}
	public int getNumero(){
		return numero;
	}
	//methode set
	public void setNom(String nom){
		this.nom=nom;
	}
	public void setPrenom(String prenom){
		this.prenom=prenom;
	}
	public void setPoste(int poste){
		this.poste=poste;
	}
	public void setNumero(int numero){
		this.numero=numero;
	}
}
