package tubesPBO;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.util.*;

public class SellerRemoveUI extends JFrame {
    private JButton RemoveItemBtn;
    private JScrollBar jScrollBar1;
    private JScrollPane jScrollPane2;
    private JTable jTable1;

    static Connection con = null;

    public SellerRemoveUI(final Connection con){

	    jScrollBar1 = new JScrollBar();
        jScrollPane2 = new JScrollPane();
        jTable1 = new JTable();
        RemoveItemBtn = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new DefaultTableModel(
            new Object [][] {
                //insert SQL
                {"Iphone",  new Integer(12000), 2},
                {"Samsung",  new Integer(11000), 1}
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

        // jTable1.setColumnSelectionAllowed(true);
        jTable1.setRowSelectionAllowed(true);;

        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        JButton removeBtn = new JButton("Remove");
        removeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RemoveBtnActionPerformed(evt);
            }
        });

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                LoggedSellerUI.frame.setVisible(true); 
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
                        .addComponent(removeBtn)
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
                    .addComponent(removeBtn))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        pack();
        setVisible(true);
    }


    private void RemoveBtnActionPerformed(ActionEvent evt) {   
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        try{
            int selectedItem = jTable1.getSelectedRow();
            model.removeRow(selectedItem);

        }catch (ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(null, "No more item to be removed.");
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
