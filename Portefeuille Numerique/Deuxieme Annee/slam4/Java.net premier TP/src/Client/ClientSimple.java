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

	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		String a="swag";
		// création de l'adresse ip de la machine acceuillant le serveur
		InetAddress hote = InetAddress.getLocalHost();
		InetAddress localhost = InetAddress.getLoopbackAddress();
		int port = 60000;
		
		System.out.println("hote : "+hote.toString());
		System.out.println("loopback return : "+localhost.toString());
		//creer une socket de communication sur ce serveur sur un port donné
		Socket sClient = new Socket(hote, port);
		System.out.println("socket connécté ? :"+ sClient.isConnected());
		InputStream inStream = sClient.getInputStream();
		OutputStream outStream = sClient.getOutputStream();
		DataInputStream dataIn = new DataInputStream(inStream);
		DataOutputStream dataOut = new DataOutputStream(outStream);
		while(a!="stop"){
			System.out.println("Veuillez sasir une phrase, stop pour quitter");
			a = sc.nextLine();
			dataOut.writeUTF(a);
			String retourServeur = dataIn.readUTF();
			System.out.println(retourServeur);
			
		}
	}

}
