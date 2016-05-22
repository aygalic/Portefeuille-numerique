package bts.tpemployes;

import java.util.ArrayList;
/**
 * Cette classe permet de stocker différent type d'employés et d'acceder a cette liste via un getter.
 * 
 * @author Aygalic
 *
 */
public class Personnel {
	/**
	 * nb Emplyes et MAXEMPLOYE permettre de ne pas exeder le nombre d'employés stockable dans le personnel
	 */
	public int nbEmployes;
	public final int MAXEMPLOYE= 100;
	private ArrayList<Employe> employes;
	/**
	 * Constructeur
	 */
	public Personnel(){
		employes=new ArrayList<Employe>();
	}
	/**
	 * Permet d'ajouter un employé a la liste des employés
	 * @param e
	 */
	public void ajouterEmploye(Employe e){
		if(nbEmployes<=MAXEMPLOYE){
			employes.add(e);
			nbEmployes++;
		}
		else{
			System.out.println("ERREUR, NOMBRE D'EMPLOYE MAXIMUM ATTEIN");
		}
	}
	/**
	 * @return le salaire moyen de tout les employés
	 */
	public double salaireMoyen(){
		double somme=0;
		for(Employe e : employes){
			somme=somme+e.calculerSalaire();
		}
		return somme/employes.size();
	}
	/**
	 * Affiche le salaire de tout les employés
	 */
	public void afficherSalaire(){
		for(Employe e : employes){
			System.out.println(e.getNom()+e.calculerSalaire());
		}
		
	}
	/**
	 * 
	 * @return la liste des employés
	 */
	public ArrayList<Employe> getPersonnel(){
		return this.employes;
	}
	
}
