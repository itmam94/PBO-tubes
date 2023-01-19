package tubesPBO;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;

public class SellItemUI extends JFrame {

    private JLabel productNameLabel, descriptionLabel, weightLabel, dimensionLabel, quantityLabel, priceLabel, categoryLabel;
    private JTextField productNameField, weightField, dimensionField1, dimensionField2, dimensionField3, quantityField, priceField,categoryField;
    private JTextArea descriptionArea;
    private JScrollPane descriptionScroll;
    private JButton sellButton;


    public SellItemUI(final Connection con) {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        productNameLabel = new JLabel("Product Name:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        add(productNameLabel, constraints);

        productNameField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        add(productNameField, constraints);

        descriptionLabel = new JLabel("Description:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.WEST;
        add(descriptionLabel, constraints);

        descriptionArea = new JTextArea(5, 20);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionScroll = new JScrollPane(descriptionArea);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 4;
        add(descriptionScroll, constraints);

        weightLabel = new JLabel("Weight (kg):");
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.WEST;
        add(weightLabel, constraints);

        weightField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 3;
        add(weightField, constraints);

        dimensionLabel = new JLabel("Dimensions (cm):");
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.anchor = GridBagConstraints.WEST;
        add(dimensionLabel, constraints);

        JLabel length = new JLabel("Length (cm):");
        constraints.gridx = 0;
        constraints.gridy = 6;
        add(length, constraints);

        dimensionField1 = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 6;
        add(dimensionField1, constraints);

        JLabel width = new JLabel("Width (cm):");
        constraints.gridx = 0;
        constraints.gridy = 7;
        add(width, constraints);

        dimensionField2 = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 7;
        add(dimensionField2, constraints);

        JLabel height = new JLabel("Height (cm):");
        constraints.gridx = 0;
        constraints.gridy = 8;
        add(height, constraints);

        dimensionField3 = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 8;
        add(dimensionField3, constraints);

        quantityLabel = new JLabel("Quantity:");
        constraints.gridx = 0;
        constraints.gridy = 9;
        constraints.anchor = GridBagConstraints.WEST;
        add(quantityLabel, constraints);

        quantityField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 9;
        add(quantityField, constraints);

        priceLabel = new JLabel("Price:");
        constraints.gridx = 0;
        constraints.gridy = 10;
        constraints.anchor = GridBagConstraints.WEST;
        add(priceLabel, constraints);

        priceField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 10;
        add(priceField, constraints);

        categoryLabel = new JLabel("Category:");
        constraints.gridx = 0;
        constraints.gridy = 11;
        constraints.anchor = GridBagConstraints.WEST;
        add(categoryLabel, constraints);

        categoryField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 11;
        add(categoryField, constraints);

        sellButton = new JButton("Sell");
        constraints.gridx = 1;
        constraints.gridy = 12;
        constraints.gridwidth = 4;
        constraints.anchor = GridBagConstraints.CENTER;
        add(sellButton, constraints);

        sellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String productName = productNameField.getText();
                String description = descriptionArea.getText();
                double weight = Double.parseDouble(weightField.getText());
                double[] dimension = new double[3];
                dimension[0] = Double.parseDouble(dimensionField1.getText());
                dimension[1] = Double.parseDouble(dimensionField2.getText());
                dimension[2] = Double.parseDouble(dimensionField3.getText());
                int quantity = Integer.parseInt(quantityField.getText());
                int price = Integer.parseInt(priceField.getText());
                String category = categoryField.getText();

             // Create the SQL insert statement
                String sqlProduct = "INSERT INTO product (productName, description, weight, length, width, height) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement statement;
				try {
					statement = con.prepareStatement(sqlProduct);
	                statement.setString(1, productName);
	                statement.setString(2, description);
	                statement.setDouble(3, weight);
	                statement.setDouble(4, dimension[0]);
	                statement.setDouble(5, dimension[1]);
	                statement.setDouble(6, dimension[2]);

	                // Execute the statement
	                statement.executeUpdate();
                    // Closing statement & connection
                    statement.close();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

                /* 
                //QTY, PRICE, CATEGORY
                // Create the SQL insert statement
                String sqlListing = "INSERT INTO listing (quantity, price, category) VALUES (?, ?, ?)";
                seller.addListing(productName, description,weight, dimension, quantity, price, category)
                PreparedStatement stmt;
				try {
					stmt = con.prepareStatement(sqlListing);
	                stmt.setString(1, quantity);
	                stmt.setString(2, price);
	                stmt.setDouble(3, category);

	                // Execute the statement
	                statement.executeUpdate();
                    // Closing statement & connection
                    statement.close();
	                
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
                */

                //moved out of try block
                productNameField.setText("                          ");
	            descriptionArea.setText("                          ");
	            weightField.setText("                          ");
	            dimensionField1.setText("                          ");
	            dimensionField2.setText("                          ");
	            dimensionField3.setText("                          ");
	            quantityField.setText("                          ");
	            priceField.setText("                          ");
	            categoryField.setText("                          ");
                productNameField.requestFocus();
            }
        });

        JButton switchBackButton = new JButton("Back");
        // Add the button to the UI, in this case it is added to the `container` JPanel
        switchBackButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
			    // TODO Auto-generated method stub
                LoggedSellerUI.frame.setVisible(true); 
                setVisible(false); 
		    }
	    });

        constraints.gridx = 1;
        constraints.gridy = 12;
        constraints.gridwidth = 4;
        constraints.anchor = GridBagConstraints.EAST;
        add(switchBackButton, constraints);

        setTitle("Add Item");
        setSize(400, 550);
        setLocationRelativeTo(null);
        setVisible(true);
        }
}
