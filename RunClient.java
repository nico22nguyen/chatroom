package client;

public class RunClient {
   public static void main(String [] args){
      if(args.length != 2)
         System.out.println("Bad Syntax\nUse: RunServer <hostname> <PORT #>");
      
      final String hostname = args[0];
      final int port = Integer.parseInt(args[1]);
      ChatClient client = new ChatClient(hostname, port);
      
      client.execute();
   }
}
