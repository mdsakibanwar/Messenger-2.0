package client;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputInfo{
    JPanel panel;
    JLabel ipLabel,portLabel,userIdLabel;
    JTextField ipTextField,portTextField,userIdTextField;
    
    public InputInfo(){
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        
        ipLabel = new JLabel("IP:");
        portLabel = new JLabel("Port:");
        userIdLabel = new JLabel("User id:");

        ipTextField = new JTextField(15);
        portTextField = new JTextField(15);
        userIdTextField = new JTextField(15);
        
        panel.add(ipLabel);
        panel.add(ipTextField);
        panel.add(portLabel);
        panel.add(portTextField);
        panel.add(userIdLabel);
        panel.add(userIdTextField);
    }
    
    JPanel getPanel(){
        return panel;
    }
    
}
