package client;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class WriteThread extends Thread{
   ChatClient client;
   Socket socket;
   PrintWriter writer;

   public WriteThread(Socket socket, ChatClient client) {
      this.client = client;
      this.socket = socket;

      try {
         writer = new PrintWriter(socket.getOutputStream(), true);
      } catch(IOException e) {
         System.out.println("Error Setting up writer");
      }
   }

   public void run() {
      Console console = System.console();
      String username = console.readLine("Input Username: ");
      client.setUsername(username);
      writer.println(username);

      String text;
      do {
         text = console.readLine("[" + username + "]: ");
         writer.println(text);
      }
      while(!text.equals("bye"));

      try{
         socket.close();
      } catch(IOException e){
         System.out.println("Error closing socket");
      }
   }
}
