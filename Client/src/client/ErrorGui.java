package client;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ErrorGui {
    JFrame frame;
    JPanel panel;
    JLabel label;
    
    public ErrorGui(String s){
        frame = new JFrame();
        frame.setSize(200,100);
        frame.setTitle("Error!!!!!!!");
        frame.setName("Error!!!!!!!");
        panel = new JPanel();
        label = new JLabel(s);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.add(label);
        frame.add(panel);
        
        frame.setVisible(true);
    }
}
