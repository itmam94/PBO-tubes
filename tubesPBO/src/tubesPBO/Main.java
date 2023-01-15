package tubesPBO;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Main {
	 
	 static Connection con = null;
	 
	 public static void main(String[] args) {
		 
		 try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/tubes","root", "root");
	            System.out.print("Database is connected !");
	        }
	        catch(Exception e) {
	            System.out.print("RAISOOO:"+e);
	        }
		 
		 final AccountList accountList = new AccountList();
		
	     final JFrame frame = new JFrame("Login or Sign Up");
	     frame.setSize(300, 150);
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     frame.setLayout(new FlowLayout());
	     
	     final JButton loginButton = new JButton("Login");
	     final JButton signupButton = new JButton("Sign Up");
	     final JButton sellerUIButton = new JButton("Seller UI");
	     
	     frame.add(signupButton);
	     frame.add(loginButton);
	     frame.add(sellerUIButton);
	     
	     ActionListener actionListener = new ActionListener() {
	    	 @Override
	    	 public void actionPerformed(ActionEvent e) {
	    		 if(e.getSource() == loginButton) {
	    			 LoginUI loginUI = new LoginUI();
	    			 //frame.setVisible(false);
	    		} else if(e.getSource() == signupButton) {
	    			SignUpUI signupUI = new SignUpUI(con);
	    			//frame.setVisible(false);
	    		} else if(e.getSource() == sellerUIButton) {
	    			SellItemUI sellUI = new SellItemUI(con);
	    		}
	    	}
	    };
	    
	    loginButton.addActionListener(actionListener);
	    signupButton.addActionListener(actionListener);
	    sellerUIButton.addActionListener(actionListener);
	    frame.setVisible(true);
	}

	private static void DatabaseConnection() {
		// TODO Auto-generated method stub
		
	}
}
