package tubesPBO;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
	 public static void main(String[] args) {
		 
		 final AccountList accountList = new AccountList();
		
	     final JFrame frame = new JFrame("Login or Sign Up");
	     frame.setSize(300, 150);
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     frame.setLayout(new FlowLayout());
	     
	     final JButton loginButton = new JButton("Login");
	     final JButton signupButton = new JButton("Sign Up");
	     
	     frame.add(signupButton);
	     frame.add(loginButton);
	     ActionListener actionListener = new ActionListener() {
	    	 @Override
	    	 public void actionPerformed(ActionEvent e) {
	    		 if(e.getSource() == loginButton) {
	    			 LoginUI loginUI = new LoginUI();
	    			 //frame.setVisible(false);
	    		} else if(e.getSource() == signupButton) {
	    			SignUpUI signupUI = new SignUpUI(accountList);
	    			//frame.setVisible(false);
	    		}
	    	}
	    };
	    
	    loginButton.addActionListener(actionListener);
	    signupButton.addActionListener(actionListener);
	    frame.setVisible(true);
	}
}
