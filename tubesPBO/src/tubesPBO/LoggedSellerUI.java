package tubesPBO;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.sql.*;

public class LoggedSellerUI extends JFrame{
	final static JFrame frame = new JFrame("Seller Menu");
    public LoggedSellerUI(Connection con){
	    frame.setSize(300, 150);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLayout(new FlowLayout());
	     
	    final JButton addButton = new JButton("Add Item");
	    final JButton removeButton = new JButton("Remove Item");
	     
	    frame.add(addButton);
		frame.add(removeButton);
	     
	    ActionListener actionListener = new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		if(e.getSource() == addButton) {
				    SellItemUI addItemUI = new SellItemUI(con);
	    			frame.dispose();
	    		} else if(e.getSource() == removeButton) {
	    			SellerRemoveUI removeUI = new SellerRemoveUI(con);
	    			frame.setVisible(false);
	    		} 
	    	}
	    };
	    
	    addButton.addActionListener(actionListener);
	    removeButton.addActionListener(actionListener);
	    frame.setVisible(true);
    }
    
    /* 
    private static void DatabaseConnection() {
		// TODO Auto-generated method stub
		
	}
    */
}
