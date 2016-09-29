
public class VoitureBis {
	private String plaqueImmatriculation, libele;
	
	public VoitureBis(String p, String l){
		this.plaqueImmatriculation=p;
		this.libele=l;
	}
	public String getPlaqueImmatriculation() {
		return plaqueImmatriculation;
	}

	public void setPlaqueImmatriculation(String plaqueImmatriculation) {
		this.plaqueImmatriculation = plaqueImmatriculation;
	}

	public String getLibele() {
		return libele;
	}

	public void setLibele(String libele) {
		this.libele = libele;
	}
}
