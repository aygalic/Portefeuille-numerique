package bts.tpemployes;

import java.util.Date;
/**
 * Classe mère abstraite de Vendeur et Commercial
 * @author Aygalic
 *
 */
public abstract class Commercial extends Employe{
	/**
	 * Atribus prorpre a tout les comerciaux
	 */
	protected double chiffreAffaire;
	/**
	 * Constructeur
	 * @param nom
	 * @param prenom
	 * @param age
	 * @param date
	 * @param chiffreAffaire
	 */
	public Commercial(String nom, String prenom, int age, Date date, Double chiffreAffaire){
		super(nom, prenom, age, date);
		this.chiffreAffaire = chiffreAffaire;
		
	}
	/**
	 * n'est pas a redéfinir
	 * @return le chiffre d'affaire d'un commercial
	 */
	public Double getChiffreAffaire(){
		return this.chiffreAffaire;
	}
}
