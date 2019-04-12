package client;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class OptionGui {
    JPanel panel;
    JRadioButton b1,b2,b3;
    ButtonGroup buttonGroup;
    
    public OptionGui(){
        panel = new JPanel();
        panel.setSize(300,100);
        buttonGroup = new ButtonGroup();
        
        b1 = new JRadioButton("Light",true);
        b2 = new JRadioButton("Dark");
        b3 = new JRadioButton("Gray");
        
        buttonGroup.add(b1);
        buttonGroup.add(b2);
        buttonGroup.add(b3);
        
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
    }
    
    public JPanel getPanel(){
        return panel;
    }
    
    public int getOption(){
        if(b1.isSelected()) return 1;
        else if(b2.isSelected()) return 2;
        else return 3;
    }
}
