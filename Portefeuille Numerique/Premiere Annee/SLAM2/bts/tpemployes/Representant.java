package bts.tpemployes;

import java.util.Date;
/**
 * Classe représentant permettant de creer des objets du meme type
 * @author Aygalic
 *
 */
public class Representant extends Commercial{
	/**
	 * Constantes propre au Representant
	 */
	public final double POURCENT_REPRESENTANT=0.10;
	public final int BONUS_REPRESENTAN=1000; 
	
	/**
	 * Constructeur
	 * @param nom
	 * @param prenom
	 * @param age
	 * @param date
	 * @param chiffreAffaire
	 */
	public Representant(String nom, String prenom, int age, Date date, double chiffreAffaire){
		super(nom, prenom, age, date, chiffreAffaire);
		
	}
	/**
	 * @return le salaire du Representant
	 */
	public double calculerSalaire(){
		return (this.chiffreAffaire*POURCENT_REPRESENTANT)+BONUS_REPRESENTAN;
	}
}
