package tubesPBO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpUI extends JFrame {

  private JLabel nameLabel, emailLabel, streetLabel, cityLabel, provinceLabel, countryLabel, postcodeLabel, passwordLabel, accountTypeLabel;
  private JTextField nameField, emailField, streetField, cityField, provinceField, countryField, postcodeField;
  private JPasswordField passwordField;
  
  private JToggleButton buyerSellerToggle;
  
  private JButton signupButton;
  private JButton switchBackButton;
  
  public SignUpUI() {
	  setLayout(new GridBagLayout());
      GridBagConstraints constraints = new GridBagConstraints();
      constraints.insets = new Insets(5, 5, 5, 5);

      nameLabel = new JLabel("Name:");
      constraints.gridx = 0;
      constraints.gridy = 0;
      add(nameLabel, constraints);

      nameField = new JTextField(20);
      constraints.gridx = 1;
      constraints.gridy = 0;
      add(nameField, constraints);

      emailLabel = new JLabel("Email:");
      constraints.gridx = 0;
      constraints.gridy = 1;
      add(emailLabel, constraints);

      emailField = new JTextField(20);
      constraints.gridx = 1;
      constraints.gridy = 1;
      add(emailField, constraints);

      streetLabel = new JLabel("Street:");
      constraints.gridx = 0;
      constraints.gridy = 2;
      add(streetLabel, constraints);

      streetField = new JTextField(20);
      constraints.gridx = 1;
      constraints.gridy = 2;
      add(streetField, constraints);

      cityLabel = new JLabel("City:");
      constraints.gridx = 0;
      constraints.gridy = 3;
      add(cityLabel, constraints);

      cityField = new JTextField(20);
      constraints.gridx = 1;
      constraints.gridy = 3;
      add(cityField, constraints);

      provinceLabel = new JLabel("Province:");
      constraints.gridx = 0;
      constraints.gridy = 4;
      add(provinceLabel, constraints);

      provinceField = new JTextField(20);
      constraints.gridx = 1;
      constraints.gridy = 4;
      add(provinceField, constraints);

      countryLabel = new JLabel("Country:");
      constraints.gridx = 0;
      constraints.gridy = 5;
      add(countryLabel, constraints);

      countryField = new JTextField(20);
      constraints.gridx = 1;
      constraints.gridy = 5;
      add(countryField, constraints);

      postcodeLabel = new JLabel("Postal Code");
      constraints.gridx = 0;
      constraints.gridy = 6;
      add(postcodeLabel, constraints);
      
      postcodeField = new JTextField(20);
      constraints.gridx = 1;
      constraints.gridy = 6;
      add(postcodeField, constraints);

      passwordLabel = new JLabel("Password:");
      constraints.gridx = 0;
      constraints.gridy = 7;
      add(passwordLabel, constraints);

      passwordField = new JPasswordField(20);
      constraints.gridx = 1;
      constraints.gridy = 7;
      add(passwordField, constraints);

      signupButton = new JButton("Sign Up");
      constraints.gridx = 0;
      constraints.gridy = 8;
      constraints.gridwidth = 2;
      constraints.anchor = GridBagConstraints.CENTER;
      add(signupButton, constraints);
      
      accountTypeLabel = new JLabel("Account Type:");
      constraints.gridx = 0;
      constraints.gridy = 9;
      add(accountTypeLabel, constraints);

      buyerSellerToggle = new JToggleButton("Buyer", true);
      buyerSellerToggle.addItemListener(new ItemListener() {
          @Override
          public void itemStateChanged(ItemEvent e) {
              if (e.getStateChange() == ItemEvent.SELECTED) {
                  buyerSellerToggle.setText("Seller");
              } else {
                  buyerSellerToggle.setText("Buyer");
              }
          }
      });
      constraints.gridx = 1;
      constraints.gridy = 9;
      add(buyerSellerToggle, constraints);


      signupButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              String name = nameField.getText();
              String email = emailField.getText();
              String street = streetField.getText();
              String city = cityField.getText();
              String province = provinceField.getText();
              String country = countryField.getText();
              String postcode = postcodeField.getText();
              @SuppressWarnings("deprecation")
			String password = passwordField.getText();
              // Perform validation and signup actions here
              if (buyerSellerToggle.getText() == "Buyer") {
                  Buyer buyer = new Buyer(name, email, password, street, city, province, country, postcode);
              } else {
            	  Seller seller = new Seller(name, email, password, street, city, province, country, postcode);
              }

              // Clear the fields after signup
              nameField.setText("");
              emailField.setText("");
              streetField.setText("");
              cityField.setText("");
              provinceField.setText("");
              countryField.setText("");
              postcodeField.setText("");
              passwordField.setText("");
          }
      });

      setTitle("Sign Up");
      setSize(300, 400);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
    
    switchBackButton = new JButton("Back");
    // Add the button to the UI, in this case it is added to the `container` JPanel
    switchBackButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Main main = new Main();
        	setVisible(false);
		}
	});
    add(switchBackButton);
    
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == switchBackButton) {
            	Main main = new Main();
            	setVisible(false);
            }
        }
    };
    
    // Set the size and location of the frame
    setSize(500, 400);
    setLocationRelativeTo(null);
    
    // Show the frame
    setVisible(true);
  }
  
  private void createAccount(String name, String email, String password) {
    // TODO: Connect to a database and insert the new account information
  }

      
}