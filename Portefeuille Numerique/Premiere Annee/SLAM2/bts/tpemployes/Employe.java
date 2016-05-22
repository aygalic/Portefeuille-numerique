package bts.tpemployes;

import java.util.Date;
/**
 * Classe mère abstraite de la majeur partie des classes de ce programme. (toute les classes sauf l'interface et Personnel)
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
	 * Cette methode ne sera pas redéfinie
	 * @return la date d'embauche de l'employé
	 */
	public Date getDateEmbauche(){
		return this.dateEmbauche;
	}
	/**
	 * Methode a redefinir
	 * @return le salaire d'un employé
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
	 * @return le nom de la classe, le nom de l'employé suivi de son prénom sous forme de String
	 */
	public String getNom(){
		return this.getTitre()+" "+this.prenom+" "+this.nom;
	}
	/**
	 * classe absente de l'uml
	 * @return l'age de l'employé
	 */
	public int getAge(){
		return this.age;
	}
}
