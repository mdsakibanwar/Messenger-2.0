package client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

public class GuiClient {
    JFrame frame;
    JPanel panel;
    JTextField sendText;
    JTextArea displayMessage;
    JScrollPane areaScrollPane;
    JButton button;
    Socket socket;
    int option;
    
    DefaultCaret caret;
    Font font;
    
    DataInputStream in;
    DataOutputStream out;
    
    String s;
    String name;
    
    GuiClient(DataOutputStream a,DataInputStream b,String c,Socket d,int e) throws IOException{
        out = a;
        in = b;
        name = c;
        socket = d;
        option = e;
        frame = new JFrame();
        panel = new JPanel();
        displayMessage = new JTextArea("",26,23);
        areaScrollPane = new JScrollPane(displayMessage);
        sendText = new JTextField(18);
        button = new JButton("Send");
        font = new Font("Arial", Font.BOLD, 12);
        
        out.writeUTF(name);
        
        frame.setSize(300,500);
        frame.setTitle(name);
        frame.setName(name);
        
        displayMessage.setLineWrap(true);
        displayMessage.setEditable(false);
        displayMessage.setWrapStyleWord(true);
        
        
        
        caret = (DefaultCaret)displayMessage.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        
        displayMessage.setFont(font);
        
        if(option==2){
            displayMessage.setBackground(Color.BLACK);
            displayMessage.setForeground(Color.WHITE);
        }
        else if(option==1){
            displayMessage.setBackground(Color.WHITE);
            displayMessage.setForeground(Color.BLACK);
        }
        else{
            displayMessage.setBackground(Color.DARK_GRAY);
            displayMessage.setForeground(Color.CYAN);
        }
        button.setSize(100,50);
        
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
         @Override
        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
             try {
                 out.writeUTF("Quit");
                 socket.close();
                 System.exit(0);
             } catch (IOException ex) {
                 Logger.getLogger(GuiClient.class.getName()).log(Level.SEVERE, null, ex);
             }
            }
        });
        
        button.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               try {
                   s = sendText.getText();
                   if(!s.equals("")) out.writeUTF(name+": "+s);
                   sendText.setText("");
               } catch (IOException ex) {
                   Logger.getLogger(GuiClient.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           
        });
        
        sendText.addKeyListener(new KeyListener(){
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==10){
                    try {
                        s = sendText.getText();
                        if(!"".equals(s)) out.writeUTF(name+": "+s);
                        sendText.setText("");
                    } catch (IOException ex) {
                        Logger.getLogger(GuiClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {    
            }

            @Override
            public void keyReleased(KeyEvent e) {
                }

        });
        
        Thread t1 = new Thread(){
          @Override
          public void run(){
              while(!"Quit".equals(s)){
                  try {
                      displayMessage.append(in.readUTF()+"\n");
                  } catch (IOException ex) {
                      Logger.getLogger(GuiClient.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }
          }  
        };
        t1.start();
        
        
        panel.add(areaScrollPane);
        panel.add(sendText);
        panel.add(button);
        frame.add(panel);
        
        frame.setVisible(true);
    }
}
