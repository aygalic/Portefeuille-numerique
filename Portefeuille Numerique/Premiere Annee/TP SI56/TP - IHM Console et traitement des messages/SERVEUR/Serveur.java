package Serveur;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Serveur {

	public static void main(String[] args) throws IOException {
		
		//on vérifie les arguments
		Scanner sc = new Scanner(System.in);
		int argument = args.length;
		if (argument<1){
		System.out.println("Veuillez transmettre les parametres à la methode main.\nAppuyez sur entrée pour continuer");
		String echec = sc.nextLine();
		return;
		}
		// on cré un socket serveur
		int port = Integer.parseInt(args[0]);
		int a,b, resultat=0;
		ServerSocket ss = new ServerSocket(port);
		//ss.setSoTimeout(60000);//10 sec
		System.out.println("Serveur Socket demaré");
		while(true){//permet la connexion de plusieur clients 
			Socket sService = ss.accept();//socket coté serveur
			System.out.println("sService démarey");
			InputStream inStream = sService.getInputStream();
			OutputStream outStream = sService.getOutputStream();
			DataInputStream dataIn = new DataInputStream(inStream);
			DataOutputStream dataOut = new DataOutputStream(outStream);
			while(true){//permet plus d'un allez retour
				String etreeClient = DataInputStream.readUTF(dataIn);
				System.out.println("message Client : "+etreeClient);
				String saisie = etreeClient;
				String[] entiers = saisie.split(" ");
				a = Integer.parseInt(entiers[2]);
				b = Integer.parseInt(entiers[3]);
				entiers[0].toLowerCase();
				switch(entiers[0])
				{
				case ("somme"):
					resultat = somme(a, b);
				   	break;
				case ("difference"):
					resultat = difference(a, b);
					break;
				case ("produit"):
					resultat = produit(a, b);    
					break;
				case ("quotient"):
					resultat = quotient(a, b);    
					break;
				}
				dataOut.writeUTF("le resultat est "+resultat); 
				//sService.close();
			}
		}
		

	}
	public static int somme(int a, int b){
		int resultat = a+b;
		return resultat;
	}
	public static int difference(int a, int b){
		int resultat = a-b;
		return resultat;
	}
	public static int produit(int a, int b){
		int resultat = a*b;
		return resultat;
	}
	public static int quotient(int a, int b){
		int resultat = a/b;
		return resultat;
	}

}
