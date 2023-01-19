package tubesPBO;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Main {
	 
	 static Connection con = null;
	 static final JFrame frame = new JFrame("Main Menu");
	 
	 public static void main(String[] args) {
		
		if (con == null) { 
		 	try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
				// ganti password 
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tubes","root", "root");
	            System.out.print("Database is connected !");
	        } catch(Exception e) {
	            System.out.print("Error:"+e);
	        }
		}
		
		 //frame.setVisible(true); 
		 frame.setSize(350, 75);
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setLayout(new FlowLayout());

		 final JButton loginButton = new JButton("Login");
		 // not working
	     final JButton signupButton = new JButton("Sign Up");
		 // should be after log in successful
		 // to be removed 
		 final JButton loggedSellerBtn = new JButton("Seller");
		 final JButton loggedBuyerBtn = new JButton("Buyer");


	     frame.add(loginButton);
		 frame.add(signupButton);
		 // to b moved
		 frame.add(loggedSellerBtn);
		 frame.add(loggedBuyerBtn);
	     
	     ActionListener actionListener = new ActionListener() {
	    	 @Override
	    	 public void actionPerformed(ActionEvent e) {
	    		 if(e.getSource() == loginButton) {
					LoginUI loginUI = new LoginUI(con);					
					frame.dispose();
	    		} else if(e.getSource() == signupButton) {
	    			SignUpUI signupUI = new SignUpUI(con);
					frame.dispose();
	    		} else if(e.getSource() == loggedSellerBtn) {
	    			LoggedSellerUI loggedSeller = new LoggedSellerUI(con);
					frame.dispose();
	    		} else if(e.getSource() == loggedBuyerBtn) {
	    			BuyerUI loggedBuyer = new BuyerUI(con);
					frame.dispose();
	    		}
	    	}
	    };
	    
	    loginButton.addActionListener(actionListener);
	    signupButton.addActionListener(actionListener);
		loggedSellerBtn.addActionListener(actionListener);
		loggedBuyerBtn.addActionListener(actionListener);
		frame.setVisible(true);
	}

	private static void DatabaseConnection() {
		// TODO Auto-generated method stub
	}
}
