package tubesPBO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginUI extends JFrame {
    private JLabel usernameLabel;
    private JTextField usernameField; 
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton, cancelButton;

    static String username; 

    public LoginUI(final Connection con) {
        // Set the title of the window
        setTitle("Login");

        // Set the layout manager
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 10, 5, 10);
        
        // Create the components
        usernameLabel = new JLabel("Email:"); // changed from Username 
        usernameField = new JTextField(20);
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        cancelButton = new JButton("Cancel");

        // Add an action listener to the login button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the username and password
                username = usernameField.getText();
                String password = passwordField.getText();
                

                // Perform the login
                if (login(con, username, password)) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password.");
                }
            }
        });

        // Add an action listener to the cancel button
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == cancelButton) {
                    Main.frame.setVisible(true); 
                    // Main.setFrameVisibility(true);
                    setVisible(false); 
	    		} 
            }
        });

        // Add the components to the frame
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        
        add(usernameLabel, constraints);

        constraints.gridx = 1;
        add(usernameField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.WEST;
        add(passwordLabel, constraints);

        constraints.gridx = 1;
        add(passwordField, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 4;
        constraints.anchor = GridBagConstraints.CENTER;
        add(loginButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 4;
        constraints.anchor = GridBagConstraints.EAST;
        add(cancelButton, constraints);

        // Set the size of the window and make it visible
        pack();
        setVisible(true);
    }

    // This method would typically perform a check against a database
    // to see if the provided username and password are valid
    private boolean login(Connection con, String username, String password) {
        // Dummy implementation
        String storedPass;
        boolean sellerUI, buyerUI;
        sellerUI = buyerUI = false;

        try {
                Statement stmt = con.createStatement();
                String sql = "SELECT * FROM buyer WHERE email = " + username;  // fetching buyer by email
                ResultSet rs = stmt.executeQuery(sql); 

                if (!rs.next()) { 
                    
                    sql = "SELECT * FROM seller WHERE email = " + username; // fetching seller by email
                    rs = stmt.executeQuery(sql); 

                    if (!rs.next()) { 
                        JOptionPane.showMessageDialog(null, "Email is Not Found!");
                        return false;
                    } else { 
                        sellerUI = true;
                    } 

                } else { 
                    buyerUI = true;
                }

                storedPass = rs.getString("password");
                
                // validating password
                if (storedPass.equals(password)) { 
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    
                    if (sellerUI) { 
                        SellItemUI sellItemUI = new SellItemUI(con); // redirect to seller UI 
                    } else if (buyerUI) { 
                        JOptionPane.showMessageDialog(null, "Buyer UI!"); // redirect to buyer UI 
                    }
                    return true;

                } else { 
                    JOptionPane.showMessageDialog(null, "Invalid Password!");
                    return false;
                }

        } catch (Exception e) { 
            e.printStackTrace();
            return false;
        }

    }

    /*
    private boolean login(String username, char[] password) {
        // Dummy implementation
        String sql = "SELECT * FROM buyer WHERE email= ? and password= ?";
        rs = stmt.executeQuery(sql); 
        if rs.next() {
            return true;
        } else {
            return false;
        }
    }
    */

	public JButton getSwitchButton() {
		// TODO Auto-generated method stub
		return null;
	}

}