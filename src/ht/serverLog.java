package ht;

import java.net.*;
import java.io.*;

public class serverLog {
    public static void main(String args[]) {
	
		int port = 1234;
		ServerSocket ss;
	
		try {
			
		    ss = new ServerSocket(port);
		    System.out.println("Szerver elindult, várakozik a kliensre az " + port + "-as porton");
		    
		    while(true) {
		    	new Thread(new runnableLog(ss.accept())).start();		
		    }
		    
		}
		catch (IOException e) {
		    System.out.println(e);
		}
    }
	
}
