package heritage;
public class Etudiant extends Personne {
	private String INE;
	
	public Etudiant()
	{super();
		this.INE="Etudiant inconnu";
	}
	
	public Etudiant(String eNom, String ePrenom, String eINE)
	{super(eNom, ePrenom);
		this.INE=eINE;
	}
	
	public String getINE()
	{
		return this.INE;
	}
	
	public void setINE(String sINE)
	{
		this.INE=sINE;
	}
	public String toString(){
		String retour = "nom : "+this.getNom()+" Prenom : "+this.getPrenom()+" Age : "+this.age+" IME : "+this.INE;
		return retour;
	}
	
	
	

}
