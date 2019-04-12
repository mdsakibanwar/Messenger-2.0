package server;

import java.io.*;
import java.net.*;

public class Server {
public static void main(String[] args) throws IOException {
        ServerSocket myServer = new ServerSocket(0);
        ClientForm newClient;
        Clients clients = new Clients();
        String ip = Inet4Address.getLocalHost().getHostAddress();
        int port = myServer.getLocalPort();
        
        System.out.println(ip+"  "+port);
        
        GuiServer gui = new GuiServer(ip,port);
        
        while(true){
            newClient = new ClientForm(myServer.accept());
            clients.addClient(newClient);
        }
    }
}
