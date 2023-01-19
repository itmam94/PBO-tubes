package tubesPBO;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.util.*;

public class BuyerUI extends JFrame {
    private JButton CheckoutBtn;
    private JScrollBar jScrollBar1;
    private JScrollPane jScrollPane2;
    private JTable jTable1;

    static Connection con = null;

    public BuyerUI(final Connection con){

	    jScrollBar1 = new JScrollBar();
        jScrollPane2 = new JScrollPane();
        jTable1 = new JTable();
        CheckoutBtn = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        /* String query = "SELECT * FROM buyer";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
            {
              String name = rs.getString("name");
              String email = rs.getString("email");
              String password = rs.getString("password");
              int phoneNumber = rs.getInt("phoneNumber");
              String street = rs.getString("street");
              String city = rs.getString("city");
              String province = rs.getString("province");
              String country = rs.getString("country");
              String postalCode= rs.getString("postalCode");
              
              //name String, email String, password String, phoneNumber INT, street String, 
              //city String, province String, country String, postalCode String
            }
            stmt.close();          
        } catch (SQLException e) {
            e.printStackTrace();
        } */
        

        jTable1.setModel(new DefaultTableModel(
            new Object [][] {
                //insert SQL
                
                {"Iphone",  new Integer(12000), 2}
            },
            new String [] {
                // Field Name
                "Item", "Price", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                Object.class, Integer.class, Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });

        jTable1.setColumnSelectionAllowed(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        CheckoutBtn.setText("Checkout");
        CheckoutBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CheckoutBtnActionPerformed(evt);
            }
        });

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                Main.frame.setVisible(true); 
                setVisible(false); 
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CheckoutBtn)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelBtn, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollBar1, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollBar1, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn)
                    .addComponent(CheckoutBtn))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        pack();
        setVisible(true);
    }


    private void CheckoutBtnActionPerformed(ActionEvent evt) {   
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        try{
            int selectedItem = jTable1.getSelectedRow();
            model.removeRow(selectedItem);

        }catch (ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(null, "Cart empty. All items are in the checkout section waiting for payment.");
        }
    }       
    
    


    /* private void showItemRecord(){
        int itemCount;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tubes","root", "");
            PreparedStatement show = con.prepareStatement("SELECT * FROM listing");
            ResultSet rs = show.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            itemCount = rsmd.getColumnCount();
            
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            model.setRowCount(0);
            
            while(rs.next())
            {
                var v = new Vector();
                
                for(int i = 1; i <= itemCount; i++){
                    v.add(rs.getObject("productName"));
                    v.add(rs.getInt("price"));
                    v.add(rs.getInt("quantity"));
                }
            }
        } catch(Exception e) {
            System.out.print("Error:"+e);
        }
    } */
}
