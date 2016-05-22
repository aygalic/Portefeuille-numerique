import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// on cré un socket serveur
		int port = 60000;
		ServerSocket ss = new ServerSocket(port);
		ss.setSoTimeout(60000);//10 sec
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
				dataOut.writeUTF("La String envoyé est : "+etreeClient); 
				//sService.close();
			}
		}
		

	}

}
