import java.util.ArrayList;

public class Logement {
	private double sufrace, prix;
	private String adresse;
	
	private ArrayList<Piece> lesPieces = new ArrayList();
	
	public void addPiece(Piece p){
		this.lesPieces.add(p);
	}

	public double getSufrace() {
		return sufrace;
	}

	public void setSufrace(double sufrace) {
		this.sufrace = sufrace;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
}
