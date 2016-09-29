package superpackage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main {
	public static void main(String[] args){
		//1, 2 
		int j = 20, i = 0; 
		try{
			System.out.println(j/i);
			
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			System.out.println("coucou toi !"); 
		}
		
		
		
		
		//3
		try{		
			Personne p = new Personne("salam", "alaykoum", 24 );			
			
		}
		catch(DateNaissException e){
			System.out.println(e);
		}

		//4
		try{	
			Personne p2 = new Personne("salam", "alaykoum", 24 );			
			
		}
		catch(DateNaissException e){
			System.out.println(e);
		}

		try{
		
			Personne p3= new Personne("salam", "alaykoum", 21 );			
			
		}
		catch(DateNaissException e){
			System.out.println(e);
		}
		//7
		ClasseQuiSertARien c = new ClasseQuiSertARien();
		ArrayList<Personne> alp1=new ArrayList(), alp2=new ArrayList();
		Personne p4;
		try {
			p4 = new Personne("salam", "alaykoum", 21 );
			alp1.add(p4);
	
		} catch (DateNaissException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}			

		try {
			c.nbPersonne(alp1);
		} catch (TropPetitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			c.nbPersonne(alp2);
		} catch (TropPetitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
	
}
