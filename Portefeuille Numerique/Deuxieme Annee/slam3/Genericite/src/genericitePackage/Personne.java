package genericitePackage;

import java.util.ArrayList;

public abstract class Personne {

	protected int id;
	protected String prenom, nom;
	protected double salaire;
	

	public abstract double calculerSalaire();
	public abstract String affiche();
	public String afficheListe(ArrayList<Personne> a){
		String retour="";
		for(Personne p : a){
			retour = retour + "Personne : "+p.affiche();
		}
		return retour;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
}
