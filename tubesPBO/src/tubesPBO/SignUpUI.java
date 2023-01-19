package tubesPBO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUpUI extends JFrame {

  private JLabel nameLabel, emailLabel, phoneLabel, streetLabel, cityLabel, provinceLabel, countryLabel, postcodeLabel, passwordLabel, accountTypeLabel, namaTokoLabel;
  private JTextField nameField, emailField, phoneField, streetField, cityField, provinceField, countryField, postcodeField, namaTokoField;
  private JPasswordField passwordField;
  //private AccountList accountList;

  private JToggleButton buyerSellerToggle;
  
  private JButton signupButton;
  private JButton switchBackButton;
  
  public SignUpUI(final Connection con) {
      //this.accountList = new AccountList();
      setTitle("Sign Up");
      //JOptionPane.showMessageDialog(null, "sign up ui");
	  setLayout(new GridBagLayout());
      GridBagConstraints constraints = new GridBagConstraints();
      constraints.insets = new Insets(5, 5, 5, 5);
      constraints.anchor = GridBagConstraints.WEST;

      // insert acc type
      accountTypeLabel = new JLabel("Account Type:");
      constraints.gridx = 0;
      constraints.gridy = 0;
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
      constraints.gridy = 0;
      //constraints.fill = GridBagConstraints.HORIZONTAL;
      add(buyerSellerToggle, constraints);
    //
      nameLabel = new JLabel("Name:");
      constraints.gridx = 0;
      constraints.gridy = 1;
      add(nameLabel, constraints);

      nameField = new JTextField(20);
      constraints.gridx = 1;
      constraints.gridy = 1;
      add(nameField, constraints);

      emailLabel = new JLabel("Email:");
      constraints.gridx = 0;
      constraints.gridy = 2;
      add(emailLabel, constraints);

      emailField = new JTextField(20);
      constraints.gridx = 1;
      constraints.gridy = 2;
      add(emailField, constraints);

      //insert password

      passwordLabel = new JLabel("Password:");
      constraints.gridx = 0;
      constraints.gridy = 3;
      add(passwordLabel, constraints);

      passwordField = new JPasswordField(20);
      constraints.gridx = 1;
      constraints.gridy = 3;
      add(passwordField, constraints);

      phoneLabel = new JLabel("Phone Number:");
      constraints.gridx = 0;
      constraints.gridy = 4;
      add(phoneLabel, constraints);

      phoneField = new JTextField(20);
      constraints.gridx = 1;
      constraints.gridy = 4;
      add(phoneField, constraints);

      streetLabel = new JLabel("Street:");
      constraints.gridx = 0;
      constraints.gridy = 5;
      add(streetLabel, constraints);

      streetField = new JTextField(20);
      constraints.gridx = 1;
      constraints.gridy = 5;
      add(streetField, constraints);

      // insert postal code

      postcodeLabel = new JLabel("Postal Code:");
      constraints.gridx = 0;
      constraints.gridy = 6;
      add(postcodeLabel, constraints);
      
      postcodeField = new JTextField(20);
      constraints.gridx = 1;
      constraints.gridy = 6;
      add(postcodeField, constraints);

      cityLabel = new JLabel("City:");
      constraints.gridx = 0;
      constraints.gridy = 7;
      add(cityLabel, constraints);

      cityField = new JTextField(20);
      constraints.gridx = 1;
      constraints.gridy = 7;
      add(cityField, constraints);

      provinceLabel = new JLabel("Province:");
      constraints.gridx = 0;
      constraints.gridy = 8;
      add(provinceLabel, constraints);

      provinceField = new JTextField(20);
      constraints.gridx = 1;
      constraints.gridy = 8;
      add(provinceField, constraints);

      countryLabel = new JLabel("Country:");
      constraints.gridx = 0;
      constraints.gridy = 9;
      add(countryLabel, constraints);

      countryField = new JTextField(20);
      constraints.gridx = 1;
      constraints.gridy = 9;
      add(countryField, constraints);

      signupButton = new JButton("Sign Up");
      constraints.gridx = 1;
      constraints.gridy = 11;
      constraints.gridwidth = 4;
      constraints.anchor = GridBagConstraints.CENTER;
      add(signupButton, constraints);
      
    //insert nama toko

    // CULPRIT #1
    buyerSellerToggle.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                namaTokoLabel = new JLabel("Nama Toko:");
            }
        }
    });
    // constraints.gridx = 0; <-- commenting this out
    // constraints.gridy = 10; <-- commenting this out
    // add(namaTokoLabel, constraints);


    /** 
    CULPRIT #2
    buyerSellerToggle.addItemListener(new ItemListener() {
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            namaTokoField = new JTextField(20);
        }
    }
    });
    constraints.gridx = 1;
    constraints.gridy = 10;
    add(namaTokoField, constraints);
     */

      signupButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            boolean valid = false; 
              // Perform validation and signup actions here
              if (buyerSellerToggle.getText() == "Buyer") {
                  // Buyer buyer = new Buyer(name, email, password, street, city, province, country, postcode);
                  //accountList.addAccount(buyer);

                  String name = nameField.getText();
                  String email = emailField.getText();
                  String password = passwordField.getText();
                  String phoneNumber = phoneField.getText();
                  String street = streetField.getText();
                  String city = cityField.getText();
                  String province = provinceField.getText();
                  String country = countryField.getText();
                  String postcode = postcodeField.getText();
                  valid = validBuyer(name, email, password, phoneNumber, street, city, province, country, postcode);
            	  
                  if (valid) { 
                    try {
                        PreparedStatement stmt = con.prepareStatement("INSERT INTO buyer (name, email, password, phoneNumber, street, city, province, country, postCode) VALUES (?,?,?,?,?,?,?,?,?)");
                        stmt.setString(1, name);
                        stmt.setString(2, email);
                        stmt.setString(3, password);
                        stmt.setString(4, phoneNumber);
                        stmt.setString(5, street);
                        stmt.setString(6, city);
                        stmt.setString(7, province);
                        stmt.setString(8, country);
                        stmt.setString(9, postcode);
                        // Execute the statement
                        stmt.executeUpdate();
                        // added message
                        JOptionPane.showMessageDialog(null, "Data successfully added!");
                        // Close the statement and connection
                        stmt.close();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                        // added message
                        JOptionPane.showMessageDialog(null, "Data entry unsuccessful");
                    }
                  }
              } else {
            	  // Seller seller = new Seller(name, email, password, namaToko, street, city, province, country, postcode);
                  // accountList.addAccount(seller);
            	  
            	  String name = nameField.getText();
                  String email = emailField.getText();
                  String password = passwordField.getText();
                  String namaToko = namaTokoField.getText();
                  String street = streetField.getText();
                  String city = cityField.getText();
                  String province = provinceField.getText();
                  String country = countryField.getText();
                  String postcode = postcodeField.getText();
                  valid = validSeller(name, email, password, namaToko, street, city, province, country, postcode);
                  
                  if (valid) { 
                    try {
                        // Prepare the INSERT statement
                        PreparedStatement stmt = con.prepareStatement("INSERT INTO seller (name, email, password, namaToko, street, city, province, country, postalCode) VALUES (?,?,?,?,?,?,?,?,?)");
                        // Set the form field values in the prepared statement
                        stmt.setString(1, name);
                        stmt.setString(2, email);
                        stmt.setString(3, password);
                        stmt.setString(4, namaToko);
                        stmt.setString(5, street);
                        stmt.setString(6, city);
                        stmt.setString(7, province);
                        stmt.setString(8, country);
                        stmt.setString(9, postcode);
                        // Execute the statement
                        stmt.executeUpdate();
                        // Close the statement and connection
                        stmt.close();
                        // added message
                        JOptionPane.showMessageDialog(null, "Data successfully added!");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                        // added message
                        JOptionPane.showMessageDialog(null, "Data entry unsuccessful");
                    }
                  }
              }

              // Clear the fields after signup
              if (valid) { 
                nameField.setText("");
                emailField.setText("");
                phoneField.setText("");
                streetField.setText("");
                cityField.setText("");
                provinceField.setText("");
                countryField.setText("");
                postcodeField.setText("");
                passwordField.setText("");
                namaTokoField.setText("");
              }
          }
      });

      
    //   setSize(300, 400);
    //   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //   setLocationRelativeTo(null);
    
    switchBackButton = new JButton("Back");
    // Add the button to the UI, in this case it is added to the `container` JPanel
    switchBackButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
            Main.frame.setVisible(true); 
            setVisible(false); 
		}
	});

    constraints.gridx = 1;
    constraints.gridy = 11;
    constraints.gridwidth = 4;
    constraints.anchor = GridBagConstraints.EAST;
    add(switchBackButton, constraints);

    // Set the size and location of the frame
    setSize(500, 500);
    setLocationRelativeTo(null);
    
    // Show the frame
    setVisible(true);
  }

  public boolean validBuyer(String name, String email, String password, String phoneNumber, String street, String city, String province, String country, String postcode) { 
    String warnMessage = "";
    boolean check = true; 
    if (name.equals("")) { 
        warnMessage += "name, ";
        // JOptionPane.showMessageDialog(null, "name can not be empty!");
        check = false; 
    } 
    if (email.equals("")){  
        warnMessage += "email, ";
        // JOptionPane.showMessageDialog(null, "email can not be empty!");
        check = false; 
    } 
    if (password.equals("")){  
        warnMessage += "password, ";
        // JOptionPane.showMessageDialog(null, "password can not be empty!");
        check = false; 
    }  
    if (phoneNumber.equals("")){  
        warnMessage += "phoneNumber, ";
        // JOptionPane.showMessageDialog(null, "password can not be empty!");
        check = false; 
    }  
    if (street.equals("")){  
        warnMessage += "street, ";
        // JOptionPane.showMessageDialog(null, "street can not be empty!");
        check = false; 
    }
    if (province.equals("")){  
        warnMessage += "province, ";
        // JOptionPane.showMessageDialog(null, "province can not be empty!");
        check = false; 
    } 
    if (country.equals("")){  
        warnMessage += "country, ";
        // JOptionPane.showMessageDialog(null, "country can not be empty!");
        check = false; 
    } 
    if (postcode.equals("")){  
        warnMessage += "postcode";
        // JOptionPane.showMessageDialog(null, "postcode can not be empty!");
        check = false; 
    }

    if (!check) { 
        JOptionPane.showMessageDialog(null, warnMessage + " can not be empty!");
        return false; 
    } 

    return true;
  }

  public boolean validSeller(String name, String email, String password, String namaToko, String street, String city, String province, String country, String postcode) { 
    String warnMessage = "";
    boolean check = true; 
    if (name.equals("")) { 
        warnMessage += "name,";
        // JOptionPane.showMessageDialog(null, "name can not be empty!");
        check = false; 
    } 
    if (email.equals("")){  
        warnMessage += "email,";
        // JOptionPane.showMessageDialog(null, "email can not be empty!");
        check = false; 
    } 
    if (password.equals("")){  
        warnMessage += "password,";
        // JOptionPane.showMessageDialog(null, "password can not be empty!");
        check = false; 
    }  
    if (namaToko.equals("")){  
        warnMessage += "phoneNumber,";
        // JOptionPane.showMessageDialog(null, "password can not be empty!");
        check = false; 
    }  
    if (street.equals("")){  
        warnMessage += "street,";
        // JOptionPane.showMessageDialog(null, "street can not be empty!");
        check = false; 
    }
    if (province.equals("")){  
        warnMessage += "province,";
        // JOptionPane.showMessageDialog(null, "province can not be empty!");
        check = false; 
    } 
    if (country.equals("")){  
        warnMessage += "country,";
        // JOptionPane.showMessageDialog(null, "country can not be empty!");
        check = false; 
    } 
    if (postcode.equals("")){  
        warnMessage += "postcode";
        // JOptionPane.showMessageDialog(null, "postcode can not be empty!");
        check = false; 
    }

    if (!check) { 
        JOptionPane.showMessageDialog(null, warnMessage + " can not be empty!");
        return false; 
    } 

    return true;
  }
}