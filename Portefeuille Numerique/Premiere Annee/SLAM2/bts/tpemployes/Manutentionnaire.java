package bts.tpemployes;

import java.util.Date;
/**
 * Le manutentionnaire est un employé.Cette classe permet de creer des manutentionnaires
 * @author Aygalic
 *
 */
public class Manutentionnaire extends Employe {
	/**
	 * constantes propres a la classe Manutentionnaire
	 */
	public final double SALAIRE_HORAIRE=100;
	private int nbHeure;
	/**
	 * Constructeur
	 * @param nom
	 * @param prenom
	 * @param age
	 * @param date
	 * @param nbHeure
	 */
	public Manutentionnaire(String nom,String prenom,int age,Date date, int nbHeure){
		super(nom, prenom, age, date);
		this.nbHeure=nbHeure;
	}
	/**
	 * @return le salaire du manutentionnaire
	 */
	public double calculerSalaire(){
		return this.nbHeure*SALAIRE_HORAIRE;
	}
	/**
	 * 
	 * @return le nombre d'heure du Manutentionnaire
	 */
	public int getNbHeure(){
		return this.nbHeure;
	}
}
