package ht;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class clientLog {

	public static void main(String[] args) {
		
			int port = 1234;
			String server = "localhost";
			Socket s = null;
			String input;
			BufferedReader bf;
			PrintWriter output;
		
			try {
				
			    s = new Socket(server, port);
			    System.out.println("Sikeres kapcsolódás a szerverhez.");
			    
		    }
			catch (UnknownHostException e) {
			    System.out.println(e);
			}
			catch (IOException e) {
			    System.out.println(e);
			}
			
			try {
				
			    bf = new BufferedReader(new InputStreamReader(System.in)); 
			    output = new PrintWriter(s.getOutputStream(),true);
			    System.out.println("Írja be a tárolni kívánt szöveget (az \"exit()\" paranccsal tudja leállítani a rögzítést):");
			   
			    while(true) {
			    	
					input = bf.readLine();
	
					if(input.equals("exit()")) break; 
					
					output.println(input);
					
			    }
			    
			}
			catch (IOException e) {
			    System.out.println(e);
			}
			
			try {
				
			    s.close();
			    System.out.println("Kapcsolat a szerverrel lezárult.");
			}
			catch (IOException e) {
			    System.out.println(e);
		    }
	}

}

