package bts.tpemployes;

import java.util.Date;
/**
 * Classe Vendeur. Permet de creer des objets Vendeurs
 * @author Aygalic
 *
 */
public class Vendeur extends Commercial{
	/**
	 * Constante propre au vendeur
	 */
	public final double POURCENT_VENDEUR=0.10;
	public final int BONUS_VENDEUR=100;
	/**
	 * Constructeur 
	 * 
	 * @param nom
	 * @param prenom
	 * @param age
	 * @param date
	 * @param chiffreAffaire
	 */
	public Vendeur(String nom, String prenom, int age, Date date, double chiffreAffaire){
		super(nom, prenom, age, date, chiffreAffaire);
	}
	/**
	 * @return le salaire du vendeur
	 */
	public double calculerSalaire(){
		return (chiffreAffaire*POURCENT_VENDEUR)+BONUS_VENDEUR;
	}
}
