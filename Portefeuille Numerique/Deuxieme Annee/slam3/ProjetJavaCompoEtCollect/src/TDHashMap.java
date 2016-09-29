import java.util.ArrayList;
import java.util.HashMap;

public class TDHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Voiture> monHashMap = new HashMap<String, Voiture>();

		monHashMap.put(new String("FG-356-DF"), new Voiture("C3"));
		monHashMap.put(new String("DF-464-GG"), new Voiture("506"));
		monHashMap.put(new String("GH-879-HG"), new Voiture("Diablo"));
		monHashMap.put(new String("HY-861-IJ"), new Voiture("Focus"));
		monHashMap.put(new String("RT-786-HT"), new Voiture("Punto"));
		monHashMap.put(new String("NB-589-GH"), new Voiture("Sabro"));
		int i=1;
		System.out.println("ex2:");
		for (String mapKey : monHashMap.keySet()) {
			if(i%2==0){
			System.out.println(monHashMap.get(mapKey).getNom()) ; 

			}
			i++;
		}
		System.out.println("ex3:");
		
		for (String mapKey : monHashMap.keySet()){
			if(mapKey.contains("G")){
				System.out.println(monHashMap.get(mapKey).getNom()); 
			}
		}
		//ex.5
		ArrayList<VoitureBis> voitures = new ArrayList();
		for (String mapKey : monHashMap.keySet()){
			voitures.add(new VoitureBis(mapKey ,monHashMap.get(mapKey).getNom()));
		}
		System.out.println("ex5");
		for(VoitureBis v : voitures){
			System.out.println(v.getPlaqueImmatriculation()+" "+v.getLibele());
		}
		

	}

}
