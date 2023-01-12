package tubesPBO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginUI extends JFrame {
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginUI() {
        // Set the title of the window
        setTitle("Login");

        // Set the layout manager
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // Create the components
        usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");

        // Add an action listener to the login button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the username and password
                char[] password = passwordField.getPassword();
                String username = usernameField.getText();

                // Perform the login
                if (login(username, password)) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password.");
                }
            }
        });

        // Add the components to the frame
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 5, 5, 5);
        add(usernameLabel, constraints);

        constraints.gridx = 1;
        add(usernameField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(passwordLabel, constraints);

        constraints.gridx = 1;
        add(passwordField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        add(loginButton, constraints);

        // Set the size of the window and make it visible
        pack();
        setVisible(true);
    }

    // This method would typically perform a check against a database
    // to see if the provided username and password are valid
    private boolean login(String username, char[] password) {
        // Dummy implementation
        if (username.equals("username") && new String(password).equals("password")) {
            return true;
        } else {
            return false;
        }
    }

	public JButton getSwitchButton() {
		// TODO Auto-generated method stub
		return null;
	}
}