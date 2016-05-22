/**
 * 
 */
package bts.tpemployes;

import java.util.Date;

/**
 * Manutentionnaire a risque
 * 
 * @author Aygalic
 *
 */
public class ManutARisque extends Manutentionnaire implements ARisque{
	/**
	 * Constructeur
	 * @param nom
	 * @param prenom
	 * @param age
	 * @param date
	 * @param nbHeure
	 */
	public ManutARisque(String nom, String prenom, int age, Date date, int nbHeure){
		super(nom, prenom, age, date, nbHeure);
	}
	/**
	 * @return la prime de risque
	 */
	public double getPrimeRisque(){
		return 10.0;
	}
	/**
	 * @return le salaire
	 */
	public double calculerSalaire(){
		return super.calculerSalaire()+getPrimeRisque();
	}
}
