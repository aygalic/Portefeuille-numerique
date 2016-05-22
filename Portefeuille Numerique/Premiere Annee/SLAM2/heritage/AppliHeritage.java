package heritage;

public class AppliHeritage {
	public static void main(String[] args){
		Etudiant e = new Etudiant("test", "coucou", "oktamèr");
		//System.out.println(e.getNom()+" "+e.getPrenom()+" "+e.getINE());
		Professeur p = new Professeur("test", "coucou", 19.00);
		p.setaNais(1996);
		//System.out.println(p.getNom()+" "+p.getPrenom()+" "+p.getSalaire());
		p.declinerIdentiter();
		Personne[] tabP = new Personne[5];
		for(int i=0;i<tabP.length;i++){
			tabP[i]=new Personne();
			System.out.println(tabP[i].toString());
		}
	}
}
