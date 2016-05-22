package bts;

public class main {

	public static void main(String[] args) {
		Etudiant e = new Etudiant("test", "coucou", "oktamèr");
		//System.out.println(e.getNom()+" "+e.getPrenom()+" "+e.getINE());
		Professeur p = new Professeur("test", "coucou", 19.00);
		p.setaNais(1996);
		//System.out.println(p.getNom()+" "+p.getPrenom()+" "+p.getSalaire());
		p.declinerIdentiter();
	}
	
	
	
}
