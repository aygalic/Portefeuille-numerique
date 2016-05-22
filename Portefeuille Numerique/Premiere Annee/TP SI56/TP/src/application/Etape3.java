package application;

import java.util.Scanner;
import application.Etape1;

public class Etape3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a,b;
		String saisie;
		System.out.println("Veuillez choisir une opération : \n");
		System.out.println("1. Somme");
		System.out.println("2. Difference");
		System.out.println("3. Produit");
		System.out.println("4. Quotient");
		System.out.println("Veuillez saisir la fonction puis deux entiers séparés par des éspaces :\n");
		System.out.println("Utilisez la forme Fonction : entier1 entier2 ");
		saisie = sc.nextLine();
		saisie.trim();
		while(!saisie.equals("FIN")){
		String[] entiers = saisie.split(" ");
		if(entiers[1].equals(":")){
			a = Integer.parseInt(entiers[2]);
			b = Integer.parseInt(entiers[3]);
			switch(entiers[0])
			{
			case ("Somme"):
				System.out.println("Somme de "+a+" + "+b+" = "+Etape1.somme(a, b));
		    	break;
			case ("Difference"):
				System.out.println("Difference de "+a+" - "+b+" = "+Etape1.difference(a, b));
				break;
			case ("Produit"):
				System.out.println("Produit de "+a+" x "+b+" = "+Etape1.produit(a, b));    
				break;
			case ("Quotient"):
				System.out.println("Quotient de "+a+" / "+b+" = "+Etape1.quotient(a, b));    
				break;
			default:
				System.out.println("Arretez de marquer des conneries");
		}
			
		}
		else
		System.out.println("utilisez les ':'");
		saisie = sc.nextLine();
		}
		System.out.println("Fin du programme");
		

	}

}
