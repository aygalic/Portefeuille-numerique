package bts.tpemployes;

import java.util.Date;
/**
 * Classe Technicien, permet de créer des objets du meme type
 */
public class Technicien extends Employe{
	/**
	 * constantes propres au technicien
	 */
	public double FACTEUR_UNITE=10;
	private int nbUnites;
	/**
	 * constructeur
	 * @param nom
	 * @param prenom
	 * @param age
	 * @param date
	 * @param nbUnites
	 */
	public Technicien(String nom, String prenom, int age, Date date, int nbUnites){
		super(nom, prenom, age, date);
		this.nbUnites=nbUnites;
	}
	/**
	 * @return le salaire du technicien
	 */
	public double calculerSalaire(){
		return FACTEUR_UNITE*nbUnites;
	}
	/**
	 * Methode absente de l'UML
	 * @return l'attribu nbUnite
	 */
	public int getNbUnites(){
		return this.nbUnites;
	}
}
