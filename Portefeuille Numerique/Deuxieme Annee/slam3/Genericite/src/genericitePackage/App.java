package genericitePackage;

import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triplet<Integer, Integer ,Integer> t=new Triplet(1, 2, 3);
		System.out.println(t.getPremier()+t.getSecond()+t.getTroiseme());
		t.affiche();
		TripletH<String, Integer, Float> th=new TripletH("hue", 3, 1.5);
		System.out.println(th.getPremier());
		System.out.println(th.getSecond());
		System.out.println(th.getTroiseme());
		th.affiche();
		Developpeur d = new Developpeur();
		d.setId(1);
		d.setNom("Ive");
		d.setPrenom("jean");
		d.setSalaire(234234);
		Manager m = new Manager();
		m.setId(2);
		m.setNom("luc");
		m.setPrenom("jean");
		m.setSalaire(234234);
		ArrayList<Personne> a = new ArrayList();
		a.add(d);
		a.add(m);
		System.out.println(m.afficheListe(a)+"fait");

	}

}
