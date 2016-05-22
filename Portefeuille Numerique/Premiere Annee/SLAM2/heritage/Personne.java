package heritage;

public class Personne {
	protected String nom;
	protected String prenom;
	protected int aNais;
	protected int age = 2016-this.aNais;
	
	public Personne()
	{
		this.nom="inconnu";
		this.prenom="inconnu";
		this.aNais=0000;
	}
	
	public Personne (String pNom, String pPrenom)
	{
		this.nom=pNom;
		this.prenom=pPrenom;
		this.aNais=0000;
	}
	
	public String getNom()
	{
		return this.nom;
	}
	
	public void setNom(String sNom)
	{
		this.nom=sNom;
	}
	
	public String getPrenom()
	{
		return this.prenom;
	}
	
	public void setPrenom(String sPrenom)
	{
		this.prenom=sPrenom;
	}
	
	public int getaNais()
	{
		return this.aNais;
	}
	
	public void setaNais(int saNais)
	{
		this.aNais=saNais;
	}
	
	public void declinerIdentiter()
	{
		System.out.println("je m'appelle "+this.nom+" "+this.prenom+" et j'ai "+this.age);
	}
	public String toString(){
		String retour = "nom : "+this.getNom()+" Prenom : "+this.getPrenom()+" Age : "+this.age;
		return retour;
	}
}
