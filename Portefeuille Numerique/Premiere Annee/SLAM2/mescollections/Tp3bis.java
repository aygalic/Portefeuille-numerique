package mescollections;
import java.util.ArrayList;
import java.util.Scanner;
public class Tp3bis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> liste = new ArrayList<Integer>();
		liste.add(0);
		liste.add(1);
		liste.add(2);
		liste.add(3);
		liste.add(4);
		liste.add(5);
		liste.add(6);
		liste.add(7);
		liste.add(8);
		liste.add(9);
		System.out.println(liste);
		for(int i=0; i<liste.size(); i++){
			liste.set(i,liste.get(i)*2);
		}
		System.out.println(liste);
		
		ArrayList<Integer> liste2 = new ArrayList<Integer>();
		System.out.println("Veuillez saisir 10 entiers");
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<10;i++){
			liste2.add(sc.nextInt());
		}
		for(int i : liste2){
			System.out.println(i);
		}
		System.out.println("le minimum est: "+getMinimum(liste2));
	}
	
	public static int getMinimum(ArrayList<Integer> a){
		int min = a.get(0);
		for(int i : a){
			if(i<min)
				min=i;
		}
		return min;
	}

}
