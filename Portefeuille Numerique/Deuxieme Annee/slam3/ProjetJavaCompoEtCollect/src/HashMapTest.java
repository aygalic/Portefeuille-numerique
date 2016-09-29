import java.util.HashMap;

public class HashMapTest {
	public static void Main(String[] args){
		HashMap<Integer, Voiture> monHashMap = new HashMap<Integer, Voiture>();

		monHashMap.put(new Integer(1), new Voiture(""));
		monHashMap.put(new Integer(2), new Voiture(""));
		monHashMap.put(new Integer(3), new Voiture(""));
		monHashMap.put(new Integer(4), new Voiture(""));
		
		for (Integer mapKey : monHashMap.keySet()) {          monHashMap.get(mapKey) ; } 
	}
}
