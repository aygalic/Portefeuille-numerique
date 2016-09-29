package superpackage;


public class Personne {
 String nom, prenom;
 int dateNaissance;
 
 public Personne (String nom, String prenom, int d) throws DateNaissException{
	 int today = 23;
	 this.nom=nom;
	 this.prenom=prenom;
	 if(d>today){
		 throw new DateNaissException();
	 } 
	 this.dateNaissance=d;
 }
}
