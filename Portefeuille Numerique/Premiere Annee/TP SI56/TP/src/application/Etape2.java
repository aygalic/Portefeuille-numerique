package application;

import java.util.Scanner;

import application.Etape1;

public class Etape2 {
	
	public static void main(String[] args) {
		String saisie ;
		int a = 0;
		int b = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir deux entiers séparés par un éspace :\nSaisir 'FIN' pour quiter.\n");
		saisie = sc.nextLine();
		while(!saisie.equals("FIN")){
		String[] entiers = saisie.split(" ");
		a = Integer.parseInt(entiers[0]);
		b = Integer.parseInt(entiers[1]);
		System.out.println("Somme de "+a+" + "+b+" = "+Etape1.somme(a, b));
		System.out.println("Difference de "+a+" - "+b+" = "+Etape1.difference(a, b));
		System.out.println("Produit de "+a+" x "+b+" = "+Etape1.produit(a, b));
		System.out.println("Quotient de "+a+" / "+b+" = "+Etape1.quotient(a, b));
		saisie = sc.nextLine();
		
		}
		System.out.println("Fin du programme");
		
	}
}
