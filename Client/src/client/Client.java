package client;

import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

public class Client {
    public static void main(String[] args){
        String ip = new String();
        String port = new String();
        String name = new String();
        String error;
        ErrorGui errorGui = null;
        int op = 0;
            
        while(true){
        InputInfo info = new InputInfo();
        int result = JOptionPane.showConfirmDialog(null,info.getPanel(),"Please Enter Informations", JOptionPane.OK_CANCEL_OPTION);
        if(result==JOptionPane.OK_OPTION){
            ip = info.ipTextField.getText();
            port = info.portTextField.getText();
            name = info.userIdTextField.getText();
        }
        else System.exit(0);
        if(!"".equals(ip) && !"".equals(port) && !"".equals(name)) break;
        }
        
        try{
        Socket socket = new Socket(ip,Integer.parseInt(port));
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in  = new DataInputStream(socket.getInputStream());
        OptionGui option = new OptionGui();
        int result = JOptionPane.showConfirmDialog(null,option.getPanel(),"Please Choose Theme", JOptionPane.OK_CANCEL_OPTION);
        if(result==JOptionPane.OK_OPTION){
            op = option.getOption();
        }
        else System.exit(0);
        
        GuiClient gui = new GuiClient(out,in,name,socket,op);
        }catch(IOException e){
            error = e.toString();
            if(error.charAt(9)=='U') {
               errorGui =  new ErrorGui("Invalid Host!!!!");
            }
            else{
               errorGui =   new ErrorGui("Wrong Port!!!!");
            }
        }catch(NumberFormatException e){
            errorGui =  new ErrorGui("Invalid Port!!!");
        }
    }

}
