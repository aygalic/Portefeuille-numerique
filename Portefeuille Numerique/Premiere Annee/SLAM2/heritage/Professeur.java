package heritage;
public class Professeur extends Personne {
	private double salaire;
	
	public Professeur()
	{super();
		this.salaire=0.00;
	}
	
	public Professeur(String pNom, String pPrenom, double pSalaire)
	{super(pNom, pPrenom);
		this.salaire=pSalaire;
	}
	
	public double getSalaire()
	{
		return this.salaire;
	}
	
	public void setSalaire(double sSalaire)
	{
		this.salaire=sSalaire;
	}
	
	public void declinerIdentiter()
	{
		super.declinerIdentiter();
		System.out.println("je gagne "+this.salaire+" euros / mois");
	}
	public String toString(){
		String retour = "nom : "+this.getNom()+" Prenom : "+this.getPrenom()+" Age : "+this.age+" salaire :"+this.salaire;
		return retour;
	}
}
