package genericitePackage;

public class Developpeur extends Personne {
	private String specialite;
	public double calculerSalaire(){
		return this.salaire*1.1;
	}
	public String affiche(){
		return "D�veloppeur"+id+nom+prenom+calculerSalaire();
	}
}
