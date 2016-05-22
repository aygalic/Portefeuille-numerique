package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientSimple {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int argument = args.length;
		if (argument<2){
		System.out.println("Veuillez transmettre les parametres à la methode main.\nAppuyez sur entrée pour continuer");
		String echec = sc.nextLine();
		return;
		}
		String a="swag";
		// création de l'adresse ip de la machine acceuillant le serveur
		//InetAddress hote = InetAddress.getLocalHost();
		//InetAddress localhost = InetAddress.getLoopbackAddress();
		String hote=args[0];
		int port = Integer.parseInt(args[1]);
		System.out.println("hote : "+hote.toString());
		//System.out.println("loopback return : "+localhost.toString());
		//creer une socket de communication sur ce serveur sur un port donné
		Socket sClient = new Socket(hote, port);
		System.out.println("socket connécté ? :"+ sClient.isConnected());
		InputStream inStream = sClient.getInputStream();
		OutputStream outStream = sClient.getOutputStream();
		DataInputStream dataIn = new DataInputStream(inStream);
		DataOutputStream dataOut = new DataOutputStream(outStream);
		while(a!="n"){
			System.out.println("Veuillez choisir une opération : \n");
			System.out.println("(Somme/Difference/Produit/Quotient)");
			System.out.println("Veuillez saisir la fonction puis deux entiers séparés par des éspaces :\n");
			System.out.println("Utilisez la forme Fonction : entier1 entier2 ");
			System.out.println("'stop' pour arreter ");
			a = sc.nextLine();
			a.trim();
			String[] test = a.split(" ");
			test[0].toLowerCase();//pour les clients envoyants des majuscules
			while(!(test[0].contains("somme")||test[0].contains("produit")||test[0].contains("quotient")||test[0].contains("difference"))&& test[1].equals(":")){
				System.out.println("Arretez de marquer des conneries, merde.");
				a=sc.nextLine();
			}
			dataOut.writeUTF(a);				
			String retourServeur = dataIn.readUTF();
			System.out.println(retourServeur);
			System.out.println("Continuer ? (y/n)");
			a = sc.nextLine();
			
		}
	}

}
