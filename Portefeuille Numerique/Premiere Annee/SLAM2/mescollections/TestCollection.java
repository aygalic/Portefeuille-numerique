package mescollections;

import java.util.ArrayList;

public class TestCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//reference de tableau dynamique de chaines de carractères
		ArrayList<String> prenoms; 
		//création de ma liste pour qu'elle puisse recevoir des éléments (:
		prenoms = new ArrayList<String>();
		String s0 = "s0";
		String s1 = new String();
		System.out.println("taille tab: "+prenoms.size());//0
		//boucle for sans indice, fonctionne avec toutes les collections (pas les map)
		for(String p : prenoms){
			System.out.println(p);
		}
		//boucle for avec indice, fonctionne avec tout les types de list
		for(int i=0; i>prenoms.size();i++){
			System.out.println(prenoms.get(i));
		}
		prenoms.add(s0);
		prenoms.add(s1);
		for(String p : prenoms){
			System.out.println(p);
		}
		for(int i=0; i<prenoms.size();i++){
			System.out.println(prenoms.get(i));
		}
		System.out.println(prenoms);
	}

}
