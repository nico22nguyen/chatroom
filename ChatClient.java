package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
   private String hostname;
   private int port;
   private String username;

   public ChatClient(String hostname, int port) {
      this.hostname = hostname;
      this.port = port;
   }

   public void execute() {
      try{
         Socket socket = new Socket(hostname, port);
         System.out.println("\n\nConnected to server...");

         new ReadThread(socket, this).start();
         new WriteThread(socket, this).start();

      } catch (UnknownHostException ex) {
         System.out.println("Server not found: " + ex.getMessage());
      } catch (IOException ex) {
         System.out.println("I/O Error: " + ex.getMessage());
      }
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }
}
