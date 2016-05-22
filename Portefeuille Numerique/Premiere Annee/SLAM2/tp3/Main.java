package tp3;
import java.util.*;


public class Main {
	public static void main(String[] args){
	System.out.println("veuillez choisir le nombre de ligne : ");
	Scanner sc = new Scanner(System.in);
	int a = sc.nextInt();
	System.out.println(a);
	String tableau[] = new String[a];
	for(int i=0;i>a;i++){
		//sc.nextLine();
		System.out.println("veuillez saisir le nom numéro "+i+" sur "+a);
		tableau[i]=sc.nextLine();
	}
	

	
	}
}
