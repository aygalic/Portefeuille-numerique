/**
 * 
 */
package bts.tpemployes;

import java.util.Date;

/**
 * Technicien à risque
 * Classe Technicien avec l'implementation de l'interface ARisque. Ce qui rajoute une prime de risque
 * @author Aygalic
 *
 */
public class TechARisque extends Technicien implements ARisque {
	/**
	 * Constructeur
	 * @param nom
	 * @param prenom
	 * @param age
	 * @param date
	 * @param nbUnites
	 */
	public TechARisque(String nom, String prenom, int age, Date date, int nbUnites){
		super(nom, prenom, age, date, nbUnites);
	}
	/**
	 * @return la prime de risque
	 */
	public double getPrimeRisque(){
		return 10.0;
	}
	/**
	 * @return le salaire du Technicien a Risque
	 */
	public double calculerSalaire(){
		return super.calculerSalaire()+getPrimeRisque();
	}
}
