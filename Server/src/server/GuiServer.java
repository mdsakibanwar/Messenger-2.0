package server;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import javax.swing.*;

public class GuiServer {
    JLabel l,l1,l2; 
    JFrame frame;
    JPanel panel;
    GuiServer(String a,int b){
        frame = new JFrame();
        frame.setSize(200,200);
        frame.setTitle("Server");
        frame.setName("Server");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel(new GridLayout(3,1));
        
        l = new JLabel("Server Started");
        l1 = new JLabel("IP Address: "+a);
        l2 = new JLabel("Port: "+b);
        
        panel.add(l);
        panel.add(l1);
        panel.add(l2);
        frame.add(panel);
        
        frame.setVisible(true);
    }
}
