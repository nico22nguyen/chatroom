package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadThread extends Thread{
   ChatClient client;
   Socket socket;
   BufferedReader reader;

   public ReadThread(Socket socket, ChatClient client){
      this.client = client;
      this.socket = socket;

      try{
         this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      } catch(IOException e){
         System.out.println("Error setting up reader");
      }
   }

   public void run() {
      while(true) {
         try {
            String inMessage = reader.readLine();
            if(inMessage == null) break;

            System.out.println("\n" + inMessage);

            if (client.getUsername() != null) 
               System.out.print("[" + client.getUsername() + "]: ");
         } catch(IOException e) {
            break;
         }
      }
   }
}
