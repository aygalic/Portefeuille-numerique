package bts.tpemployes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import bts.tpemployes.*;
/**
 * Cette classe permet faire communique notre application avec un base de donnée mySQL
 * Elle interprette les différents objets instanciés par les classes du package bts.tpemployes
 * Elle peut socker, et récuperer les employé sur une base de donnée
 * @author Aygalic
 *
 */
public class EmployeDAO {
	/**
	 * Ce main sert a tester des différentes methodes
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		//creer un format de date compatible avec la basede donnée
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf.parse("2012-05-12");
		//creer les différents employés
		Employe t = new Technicien("tech", "nicien", 21, d, 1000);
		Employe ta = new TechARisque("tech", "ARisque", 21, d, 1000);
		Employe m = new Manutentionnaire("manu", "tentionnaire", 43, d, 150);
		Employe ma = new ManutARisque("manu", "TArisque", 43, d, 150);
		Employe v = new Vendeur("VENDS", "DHEURE", 43, d, 1235.0);
		Employe r = new Representant("RPZ", "SENTANT", 43, d, 1500.0);
		//ajouter un employer de chaque type a la base de donnés
		ajouterEmploye(m);
		ajouterEmploye(ma);
		ajouterEmploye(t);
		ajouterEmploye(ta);
		ajouterEmploye(r);
		ajouterEmploye(v);
		//recuperer les employé stockés
		ArrayList<Employe> tampon = getAllEmployes();
		for(Employe e : tampon){
			//afficher les employés récuperer
			System.out.println(e.getNom()+" ");
			System.out.print(e.getAge()+" ");
			System.out.print(sdf.format(e.getDateEmbauche()));
		}
		System.out.println("done");
		//netoyer la base de donnée
		executeUpdateRequest("truncate representant;");
		executeUpdateRequest("truncate vendeur;");
		executeUpdateRequest("truncate technicien;");
		executeUpdateRequest("truncate techarisque;");
		executeUpdateRequest("truncate manutentionnaire;");
		executeUpdateRequest("truncate manutarisque;");
		
	}
	/**
	 * Cette methode permet de stocker un employé dans la base de donné
	 * @param e Employé a stocker
	 */
	public static void ajouterEmploye(Employe e){
		//information d'acces a la base de donnée
		String url = "jdbc:mysql://localhost/tpemploye";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		//information relative à l'employé a enregistrer
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String d = sdf.format(e.getDateEmbauche());
		String titre = e.getNom().split(" ")[0].toLowerCase();
		String prenom = e.getNom().split(" ")[1];
		String nom = e.getNom().split(" ")[2];
		String sql = null;

		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);
			// Etape 3 : Création d'un statement
			st = cn.createStatement();
			System.out.println(e.getClass().getSimpleName());
			//choix de la requette en fonction du type d'employé
			switch (e.getClass().getSimpleName()) {
			case "Technicien":
				Technicien t = (Technicien) e;
				sql = "INSERT INTO "+titre+" (nom, prenom, age, dateEmbauche, nbUnite) VALUES ('"+nom+"','"+prenom+"','"+t.getAge()+"','"+d+"','"+t.getNbUnites()+"')";					
				System.out.println(sql);
				break;
			case "TechARisque":
				TechARisque ta = (TechARisque) e;
				sql = "INSERT INTO "+titre+" (nom, prenom, age, dateEmbauche, nbUnite) VALUES ('"+nom+"','"+prenom+"','"+ta.getAge()+"','"+d+"','"+ta.getNbUnites()+"')";					
				System.out.println(sql);
				break;
			case "Manutentionnaire":
				Manutentionnaire m = (Manutentionnaire) e;
				sql = "INSERT INTO "+titre+" (nom, prenom, age, dateEmbauche, nbheure) VALUES ('"+nom+"','"+prenom+"','"+m.getAge()+"','"+d+"','"+m.getNbHeure()+"')";					
				System.out.println(sql);
				break;
			case "ManutARisque":
				Manutentionnaire ma = (Manutentionnaire) e;
				sql = "INSERT INTO "+titre+" (nom, prenom, age, dateEmbauche, nbheure) VALUES ('"+nom+"','"+prenom+"','"+ma.getAge()+"','"+d+"','"+ma.getNbHeure()+"')";					
				System.out.println(sql);
				break;
			case "Vendeur":
				Vendeur v = (Vendeur) e;
				sql = "INSERT INTO "+titre+" (nom, prenom, age, dateEmbauche, chiffreaffaire) VALUES ('"+nom+"','"+prenom+"','"+v.getAge()+"','"+d+"','"+v.getChiffreAffaire()+"')";					
				System.out.println(sql);
				break;
			case "Representant":
				Representant r = (Representant) e;
				sql = "INSERT INTO "+titre+" (nom, prenom, age, dateEmbauche, chiffreaffaire) VALUES ('"+nom+"','"+prenom+"','"+r.getAge()+"','"+d+"','"+r.getChiffreAffaire()+"')";					
				System.out.println(sql);
				break;
			default:
				break;
			}
			// Etape 4 : exécution requête
			st.executeUpdate(sql);
			// Si récup données alors étapes 5 (parcours Resultset)
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			// TODO: handle exception
			ex.printStackTrace();
		} finally {
			try {
			// Etape 6 : libérer ressources de la mémoire.
				cn.close();
				st.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	/**
	 * Retour tout les employés stockés dans la base de donnés
	 * @return ArrayList<Employe> avec tout les employés
	 * @throws ParseException
	 */
	public static ArrayList<Employe> getAllEmployes() throws ParseException{
		
				//liste de stockage des employes
				ArrayList<Employe> listeEmploye = new ArrayList<Employe>();
				

					String sql = "SELECT * FROM technicien";
					System.out.println("TECHNICIENS :");
					listeEmploye.addAll(executeSelectRequest(sql));
					sql = "SELECT * FROM techarisque";
					System.out.println("TECHARISQUE :");
					listeEmploye.addAll(executeSelectRequest(sql));
					
					sql = "SELECT * FROM manutentionnaire";
					System.out.println("MANUT :");
					listeEmploye.addAll(executeSelectRequest(sql));
					
					sql = "SELECT * FROM manutarisque";
					System.out.println("MANUTARISQUE :");
					listeEmploye.addAll(executeSelectRequest(sql));
					
					sql = "SELECT * FROM vendeur";
					System.out.println("VENDEUR :");
					listeEmploye.addAll(executeSelectRequest(sql));
					
					sql = "SELECT * FROM representant";
					System.out.println("REPRESENTANT :");
					listeEmploye.addAll(executeSelectRequest(sql));
					
					// Etape 4 : exécution requête

					// Si récup données alors étapes 5 (parcours Resultset)


				
		return listeEmploye;
	}
	/**
	 * Cette methode permet d'exectuter une requette SQL
	 * Elle ne renvois rien et se contente de faire ce qu'y est énoncé plus haut
	 * ainsi elle affiche le résultat et est beaucoup plus tolérante que la methode  executeSelectRequest définie plus bas.
	 * 
	 * @param req la requette SQL a effectuer
	 */
	public static void executeUpdateRequest(String req){
		// Information d'accès à la base de données
				String url = "jdbc:mysql://localhost/tpemploye";
				String login = "root";
				String passwd = "";
				Connection cn =null;
				Statement st =null;
				System.out.println(req);

				try {

					// Etape 1 : Chargement du driver
					Class.forName("com.mysql.jdbc.Driver");

					// Etape 2 : récupération de la connexion
					cn = DriverManager.getConnection(url, login, passwd);

					// Etape 3 : Création d'un statement
					st = cn.createStatement();

					

					// Etape 4 : exécution requête
					st.executeUpdate(req);

					// Si récup données alors étapes 5 (parcours Resultset)

				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO: handle exception
					e.printStackTrace();
				} finally {
					try {
					// Etape 6 : libérer ressources de la mémoire.
						cn.close();
						st.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
	
	/**
	 * Execture une requette sql relative a la selection d'employés
	 * 
	 * @param sql La requette SQL a effectué
	 * @return le resultat de cette requette sous forme d'ARrayList<Employe>
	 * @throws ParseException
	 */
	public static ArrayList<Employe> executeSelectRequest(String sql) throws ParseException{

		// Information d'accès à la base de données
		DateFormat  format = new SimpleDateFormat("yyyy-MM-dd");

		ArrayList<Employe> retour = new ArrayList<Employe>();
		String url = "jdbc:mysql://localhost/tpemploye";
		String login = "root";
		String passwd = "";
		Connection cn =null;
		Statement st =null;
		ResultSet rs =null;
		String nom, prenom;
		int age, nbUnites, nbHeure;
		Date date;
		double chiffreAffaire;
		
		
		
		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = cn.createStatement();

			// Etape 4 : exécution requête
			rs = st.executeQuery(sql);

			// Si récup données alors étapes 5 (parcours Resultset)
			
			
			
			
			while (rs.next()) {
				switch (sql.split(" ")[3].trim().toLowerCase()) {
				case "technicien":
					System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
					nom = rs.getString(2);
					prenom = rs.getString(3);
					age = Integer.parseInt(rs.getString(4));
					date = format.parse((rs.getString(5)));
					nbUnites = Integer.parseInt(rs.getString(6));
					retour.add(new Technicien(nom, prenom, age, date, nbUnites));
					
					break;
				case "manutentionnaire":
					nom = rs.getString(2);
					prenom = rs.getString(3);
					age = Integer.parseInt(rs.getString(4));
					date = format.parse((rs.getString(5)));
					nbHeure = Integer.parseInt(rs.getString(6));
					System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
					retour.add(new Manutentionnaire(nom, prenom, age, date, nbHeure));

					break;
				case "manutarisque":
					nom = rs.getString(2);
					prenom = rs.getString(3);
					age = Integer.parseInt(rs.getString(4));
					date = format.parse((rs.getString(5)));
					nbHeure = Integer.parseInt(rs.getString(6));
					System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
					retour.add(new ManutARisque(nom, prenom, age, date, nbHeure));

					break;
				case "techarisque":
					nom = rs.getString(2);
					prenom = rs.getString(3);
					age = Integer.parseInt(rs.getString(4));
					date = format.parse((rs.getString(5)));
					nbUnites = Integer.parseInt(rs.getString(6));
					System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
					retour.add(new TechARisque(nom, prenom, age, date, nbUnites));

					break;
				case "vendeur":
					nom = rs.getString(2);
					prenom = rs.getString(3);
					age = Integer.parseInt(rs.getString(4));
					date = format.parse((rs.getString(5)));
					chiffreAffaire = Integer.parseInt(rs.getString(6));
					System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
					retour.add(new Representant(nom, prenom, age, date, chiffreAffaire));
					break;
				case "representant":
					nom = rs.getString(2);
					prenom = rs.getString(3);
					age = Integer.parseInt(rs.getString(4));
					date = format.parse((rs.getString(5)));
					chiffreAffaire = Integer.parseInt(rs.getString(6));
					System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
					retour.add(new Vendeur(nom, prenom, age, date, chiffreAffaire));
					break;
					
				default:
					break;
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
			// Etape 6 : libérer ressources de la mémoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return retour;
	}
	
}

