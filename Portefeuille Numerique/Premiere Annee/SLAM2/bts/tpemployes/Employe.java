package bts.tpemployes;

import java.util.Date;
/**
 * Classe m�re abstraite de la majeur partie des classes de ce programme. (toute les classes sauf l'interface et Personnel)
 * 
 * @author Aygalic
 *
 */
public abstract class Employe{
	protected String nom, prenom;
	protected Date dateEmbauche;
	protected int age;
	/**
	 * Constructeur
	 * @param nom
	 * @param prenom
	 * @param age
	 * @param dateEmbauche
	 */
	public Employe(String nom, String prenom, int age, Date dateEmbauche){
		this.nom=nom;
		this.prenom=prenom;
		this.dateEmbauche=dateEmbauche;
		this.age=age;
	}
	/**
	 * Cette methode ne sera pas red�finie
	 * @return la date d'embauche de l'employ�
	 */
	public Date getDateEmbauche(){
		return this.dateEmbauche;
	}
	/**
	 * Methode a redefinir
	 * @return le salaire d'un employ�
	 */
	public abstract double calculerSalaire();
	/**
	 * n'est pas a redefinir
	 * @return le nom de la classe
	 */
	public String getTitre(){
		return this.getClass().getSimpleName();
	}
	/**
	 * n'est pas a redefinir
	 * @return le nom de la classe, le nom de l'employ� suivi de son pr�nom sous forme de String
	 */
	public String getNom(){
		return this.getTitre()+" "+this.prenom+" "+this.nom;
	}
	/**
	 * classe absente de l'uml
	 * @return l'age de l'employ�
	 */
	public int getAge(){
		return this.age;
	}
}
