package genericitePackage;

public class Manager extends Personne{
	
	private String service;
	public double calculerSalaire(){
		return this.salaire*1.3;
	}
	public String affiche(){
		return "Manager"+id+nom+prenom+calculerSalaire();
	}
}
