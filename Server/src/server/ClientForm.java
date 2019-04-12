package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientForm extends Thread{
    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    String s = new String();
    Clients c;
    int index;
    String name;
    
    ClientForm(Socket b){
    socket = b;
    this.start();
    }
    
    @Override
    public void run(){
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            name = in.readUTF();
            shout(name+" has entered the chatroom.");
            while(true){
                s = in.readUTF();
                System.out.println(s);
                if("Quit".equals(s)) {
                    c.removeClient(index);
                    socket.close();
                    break;
                }
                else shout(s);
            }
            shout(name+" has left the chatroom.");
        } catch (IOException ex) {
            Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     public void shout(String a) throws IOException{
        for(int i=0;i<c.count;i++){
            c.clients[i].out.writeUTF(a);
        }
    }
    
}
