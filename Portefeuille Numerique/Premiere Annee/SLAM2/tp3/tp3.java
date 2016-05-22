package tp3;

import java.util.Scanner;

public class tp3 {
	
		public static void main(String[] args){
		System.out.println("veuillez choisir le nombre de ligne : ");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		//System.out.println(a);
		String tableau[] = new String[a];
		sc.nextLine();
		for(int i=0;i<a;i++){
			//sc.nextLine();
			System.out.println("veuillez saisir le nom numéro "+(i+1)+" sur "+a);
			tableau[i]=sc.nextLine();
		}
		for(int i=0;i<a;i++){
			System.out.println(tableau[i]);
		}
		System.out.println("Vu qu'on est tres swaggé, on va tout mettre en forme huehuehue");
		for(int i=0;i<a;i++){
			tableau[i]=miseEnForme(tableau[i]);
		}
		for(int i=0;i<a;i++){
			System.out.println(tableau[i]);
		}
		}
		static int getPosistionDansTab(String nom, String[] tab){
			int a=tab.length;
			int pos=0;
			for(int i=0;i<a;i++){
				if(tab[i]==nom){
					pos=i;
				}
				return pos;
				
			}
		}
		static String miseEnForme(String chaine){
			String debut=chaine.substring(0,1).toUpperCase();
			String fin=chaine.substring(1).toLowerCase();
			return (debut+fin);
		}
}
