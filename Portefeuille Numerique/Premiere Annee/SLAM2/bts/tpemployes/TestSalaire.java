package bts.tpemployes;

import java.util.Date;
/**
 * Cette classe permet de vérifier le bon foctionnement des autres classes du package
 * @author Aygalic
 *
 */
public class TestSalaire {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//technicien manu representant vendeur
		Personnel p = new Personnel();
		p.ajouterEmploye(new Technicien("swag", "yolo", 24, new Date(), 100));
		p.ajouterEmploye(new Manutentionnaire("swag", "yolo", 24, new Date(), 100));
		p.ajouterEmploye(new Representant("swag", "yolo", 24, new Date(), 1000.0));
		p.ajouterEmploye(new Vendeur("swag", "yolo", 24, new Date(), 1000.0));
		System.out.println("ETAPE 1 et 2: ");
		System.out.println(p.salaireMoyen());
		for(Employe e : p.getPersonnel()){
			System.out.print(e.getNom()+" ");
			System.out.println(e.calculerSalaire());
		}
		System.out.println("ETAPE 3 et 4:");
		p.ajouterEmploye(new TechARisque("swag", "yolo", 24, new Date(), 100));
		p.ajouterEmploye(new ManutARisque("swag", "yolo", 24, new Date(), 100));
		System.out.println(p.salaireMoyen());
		for(Employe e : p.getPersonnel()){
			System.out.print(e.getNom()+" ");
			System.out.println(e.calculerSalaire());
		}
	}

}
