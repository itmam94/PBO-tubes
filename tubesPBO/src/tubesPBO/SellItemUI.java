package tubesPBO;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

import javax.swing.*;

public class SellItemUI extends JFrame {

    private JLabel productNameLabel, descriptionLabel, weightLabel, dimensionLabel, quantityLabel, priceLabel, categoryLabel;
    private JTextField productNameField, weightField, dimensionField1, dimensionField2, dimensionField3, quantityField, priceField,categoryField;
    private JTextArea descriptionArea;
    private JScrollPane descriptionScroll;
    private JButton sellButton;

    public SellItemUI(Connection con) {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        productNameLabel = new JLabel("Product Name:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(productNameLabel, constraints);

        productNameField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        add(productNameField, constraints);

        descriptionLabel = new JLabel("Description:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(descriptionLabel, constraints);

        descriptionArea = new JTextArea(5, 20);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionScroll = new JScrollPane(descriptionArea);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        add(descriptionScroll, constraints);
        weightLabel = new JLabel("Weight (kg):");
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        add(weightLabel, constraints);

        weightField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 3;
        add(weightField, constraints);

        dimensionLabel = new JLabel("Dimensions (cm):");
        constraints.gridx = 0;
        constraints.gridy = 4;
        add(dimensionLabel, constraints);

        dimensionField1 = new JTextField(5);
        constraints.gridx = 1;
        constraints.gridy = 4;
        add(dimensionField1, constraints);

        dimensionField2 = new JTextField(5);
        constraints.gridx = 2;
        constraints.gridy = 4;
        add(dimensionField2, constraints);

        dimensionField3 = new JTextField(5);
        constraints.gridx = 3;
        constraints.gridy = 4;
        add(dimensionField3, constraints);

        quantityLabel = new JLabel("Quantity:");
        constraints.gridx = 0;
        constraints.gridy = 5;
        add(quantityLabel, constraints);

        quantityField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 5;
        add(quantityField, constraints);

        priceLabel = new JLabel("Price:");
        constraints.gridx = 0;
        constraints.gridy = 6;
        add(priceLabel, constraints);

        priceField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 6;
        add(priceField, constraints);

        categoryLabel = new JLabel("Category:");
        constraints.gridx = 0;
        constraints.gridy = 7;
        add(categoryLabel, constraints);

        categoryField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 7;
        add(categoryField, constraints);

        sellButton = new JButton("Sell");
        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.gridwidth = 2;
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
                // code to handle the input data and sell the item
                // can be added here
            }
        });

        setTitle("Sell Item");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        }
        
}
