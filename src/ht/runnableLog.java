package ht;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class runnableLog implements Runnable {

    private Socket s;

    public runnableLog(Socket s){
        this.s=s;
    }

    private void logger(String input) {
    	
	    	Date date = new Date();
	        SimpleDateFormat timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			System.out.println("[" + timeStamp.format(date) +  "] " + input + "\n");
			
		    String filename= "log.txt";
		    FileWriter fw;
		    
			try {
				
				fw = new FileWriter(filename,true);
				fw.write("[" + timeStamp.format(date) + "] " + input + "\n");
			    fw.flush();
			    fw.close();
			    
			} catch (IOException e) {
				e.printStackTrace();
			} 
    }


    @Override
    public void run(){
    	
    	System.out.println("Kapcsolat a szerverrel sikeres volt.");
    	while(true) {
    		BufferedReader bf = null;
            try {
            	
                bf=new BufferedReader(new InputStreamReader(s.getInputStream()));
                String input = bf.readLine();
                
                if(input == null) break;
                
                logger(input);
                
            } catch (IOException e) {
                e.printStackTrace();
            }
    	}
    	
        
        
        try {
        	
        	System.out.println("Kapcsolat a szerverrel lezárult.");
			s.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
