package robin.IMS.IMS_App;

//import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import robin.IMS.DAO.UserDAO;
import robin.IMS.DAO.ComputersDAO;
import robin.IMS.ui.users.UserLoginDialog;
import robin.IMS.items.AddItem;
import robin.IMS.items.DeleteItem;
import robin.IMS.items.UpdateItem;



public class IMS_APP extends javax.swing.JFrame {

    /**
     * Creates new form IMS_APP
     */
    public IMS_APP() {
        initComponents();
    }
    public IMS_APP (boolean update){
    }

   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("robin?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        computersQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM Computers c");
        computersList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : computersQuery.getResultList();
        computersQuery1 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM Computers c");
        computersList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(computersQuery1.getResultList());
        cafetariaQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM Cafetaria c");
        cafetariaList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : cafetariaQuery.getResultList();
        miscellaneousQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT m FROM Miscellaneous m");
        miscellaneousList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : miscellaneousQuery.getResultList();
        stationeryQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT s FROM Stationery s");
        stationeryList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : stationeryQuery.getResultList();
        TabComputer = new javax.swing.JTabbedPane();
        compPanel = new javax.swing.JPanel();
        LabelSearch = new javax.swing.JLabel();
        compTextField = new javax.swing.JTextField();
        compSearchButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        CompScroll = new javax.swing.JScrollPane();
        compTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        CafeScroll = new javax.swing.JScrollPane();
        Cafetaria = new javax.swing.JTable();
        LabelSearch1 = new javax.swing.JLabel();
        cafeTextField = new javax.swing.JTextField();
        cafeButtonSearch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        LabelSearch2 = new javax.swing.JLabel();
        statTextField = new javax.swing.JTextField();
        statButtonSearch = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        StatScroll = new javax.swing.JScrollPane();
        Stationery = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        MiscScroll = new javax.swing.JScrollPane();
        Miscellaneous = new javax.swing.JTable();
        LabelSearch3 = new javax.swing.JLabel();
        miscTextField = new javax.swing.JTextField();
        miscButtonSearch = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        deleteComp = new javax.swing.JButton();
        addComp = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        updateItemButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventory Management System");

        TabComputer.setVerifyInputWhenFocusTarget(false);

        LabelSearch.setText("Search for item");

        compSearchButton.setText("Search");
        compSearchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                compSearchButtonMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        jLabel1.setText("A blank Seach will refresh the rows of the table");

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, computersList1, compTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${itemName}"));
        columnBinding.setColumnName("Item Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${manufacturer}"));
        columnBinding.setColumnName("Manufacturer");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantity}"));
        columnBinding.setColumnName("Quantity");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dateAdded}"));
        columnBinding.setColumnName("Date Added");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        CompScroll.setViewportView(compTable);

        javax.swing.GroupLayout compPanelLayout = new javax.swing.GroupLayout(compPanel);
        compPanel.setLayout(compPanelLayout);
        compPanelLayout.setHorizontalGroup(
            compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(compPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CompScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(compPanelLayout.createSequentialGroup()
                        .addComponent(LabelSearch)
                        .addGap(18, 18, 18)
                        .addComponent(compTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(compSearchButton)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        compPanelLayout.setVerticalGroup(
            compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, compPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(compPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelSearch)
                    .addComponent(compTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(compSearchButton)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CompScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        TabComputer.addTab("Computers", compPanel);

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cafetariaList, Cafetaria);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${itemName}"));
        columnBinding.setColumnName("Item Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${manufacturer}"));
        columnBinding.setColumnName("Manufacturer");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantity}"));
        columnBinding.setColumnName("Quantity");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dateAdded}"));
        columnBinding.setColumnName("Date Added");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);

        CafeScroll.setViewportView(Cafetaria);

        LabelSearch1.setText("Search for item");

        cafeButtonSearch.setText("Search");
        cafeButtonSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cafeButtonSearchMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        jLabel2.setText("A blank Seach will refresh the table");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CafeScroll)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LabelSearch1)
                        .addGap(18, 18, 18)
                        .addComponent(cafeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cafeButtonSearch)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(0, 172, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelSearch1)
                    .addComponent(cafeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cafeButtonSearch)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CafeScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        TabComputer.addTab("Cafetaria", jPanel1);

        LabelSearch2.setText("Search for item");

        statButtonSearch.setText("Search");
        statButtonSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                statButtonSearchMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        jLabel3.setText("A blank Seach will refresh the table");

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, stationeryList, Stationery);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${itemName}"));
        columnBinding.setColumnName("Item Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${manufacturer}"));
        columnBinding.setColumnName("Manufacturer");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantity}"));
        columnBinding.setColumnName("Quantity");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dateAdded}"));
        columnBinding.setColumnName("Date Added");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);

        StatScroll.setViewportView(Stationery);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LabelSearch2)
                        .addGap(18, 18, 18)
                        .addComponent(statTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(statButtonSearch)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(53, 182, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(StatScroll)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelSearch2)
                    .addComponent(statTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statButtonSearch)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(StatScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );

        TabComputer.addTab("Stationery", jPanel2);

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, miscellaneousList, Miscellaneous);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${itemName}"));
        columnBinding.setColumnName("Item Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${manufacturer}"));
        columnBinding.setColumnName("Manufacturer");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantity}"));
        columnBinding.setColumnName("Quantity");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dateAdded}"));
        columnBinding.setColumnName("Date Added");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);

        MiscScroll.setViewportView(Miscellaneous);

        LabelSearch3.setText("Search for item");

        miscButtonSearch.setText("Search");
        miscButtonSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miscButtonSearchMouseClicked(evt);
            }
        });
        miscButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miscButtonSearchActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 2, 10)); // NOI18N
        jLabel4.setText("A blank Seach will refresh the table");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(LabelSearch3)
                        .addGap(18, 18, 18)
                        .addComponent(miscTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(miscButtonSearch)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addComponent(MiscScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelSearch3)
                    .addComponent(miscTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(miscButtonSearch)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(MiscScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        TabComputer.addTab("Miscellaneous", jPanel3);

        deleteComp.setText("Delete item");
        deleteComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCompActionPerformed(evt);
            }
        });

        addComp.setText("Add item");
        addComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCompActionPerformed(evt);
            }
        });

        updateItemButton.setText("Update item");
        updateItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateItemButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(updateItemButton)
                .addGap(18, 18, 18)
                .addComponent(addComp)
                .addGap(18, 18, 18)
                .addComponent(deleteComp)
                .addGap(79, 79, 79))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TabComputer)
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabComputer, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addComp)
                    .addComponent(deleteComp)
                    .addComponent(updateItemButton))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCompActionPerformed
        // TODO add your handling code here:
        DeleteItem i = new DeleteItem();
    }//GEN-LAST:event_deleteCompActionPerformed

    private void addCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCompActionPerformed
        // TODO add your handling code here:
        AddItem a = new AddItem();
    }//GEN-LAST:event_addCompActionPerformed

    private void compSearchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_compSearchButtonMouseClicked
        // TODO add your handling code here:
        String keyword = compTextField.getText();
        searchComp("Computers", keyword);
    }//GEN-LAST:event_compSearchButtonMouseClicked

    private void cafeButtonSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cafeButtonSearchMouseClicked
        // TODO add your handling code here:
        String keyword = cafeTextField.getText();
        searchCafe("Cafetaria", keyword);
    }//GEN-LAST:event_cafeButtonSearchMouseClicked

    private void statButtonSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_statButtonSearchMouseClicked
        // TODO add your handling code here:
        String keyword = statTextField.getText();
        searchStat("Stationary", keyword);
    }//GEN-LAST:event_statButtonSearchMouseClicked

    private void miscButtonSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miscButtonSearchMouseClicked
        // TODO add your handling code here:
        String keyword = miscTextField.getText();
        searchMisc("Miscellaneous", keyword);
    }//GEN-LAST:event_miscButtonSearchMouseClicked

    private void miscButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miscButtonSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miscButtonSearchActionPerformed

    private void updateItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateItemButtonActionPerformed
        // TODO add your handling code here:
        UpdateItem u = new UpdateItem();
    }//GEN-LAST:event_updateItemButtonActionPerformed
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IMS_APP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IMS_APP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IMS_APP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IMS_APP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                    UserDAO userDAO = null;
                    ComputersDAO cDAO = null;
                try {
                    userDAO = new UserDAO();
                    cDAO = new ComputersDAO();
                    // Show login dialog, see UserLoginDialog.java
                    UserLoginDialog dialog = new UserLoginDialog();
                    ResultSet tableRes = cDAO.getAllComputerss();
                } catch (Exception ex) {
                    Logger.getLogger(IMS_APP.class.getName()).log(Level.SEVERE, null, ex);
                }  
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane CafeScroll;
    private javax.swing.JTable Cafetaria;
    private javax.swing.JScrollPane CompScroll;
    private javax.swing.JLabel LabelSearch;
    private javax.swing.JLabel LabelSearch1;
    private javax.swing.JLabel LabelSearch2;
    private javax.swing.JLabel LabelSearch3;
    private javax.swing.JScrollPane MiscScroll;
    private javax.swing.JTable Miscellaneous;
    private javax.swing.JScrollPane StatScroll;
    private javax.swing.JTable Stationery;
    private javax.swing.JTabbedPane TabComputer;
    private javax.swing.JButton addComp;
    private javax.swing.JButton cafeButtonSearch;
    private javax.swing.JTextField cafeTextField;
    private java.util.List<robin.IMS.IMS_App.Cafetaria> cafetariaList;
    private javax.persistence.Query cafetariaQuery;
    private javax.swing.JPanel compPanel;
    private javax.swing.JButton compSearchButton;
    private javax.swing.JTable compTable;
    private javax.swing.JTextField compTextField;
    private java.util.List<robin.IMS.IMS_App.Computers> computersList;
    private java.util.List<robin.IMS.IMS_App.Computers> computersList1;
    private javax.persistence.Query computersQuery;
    private javax.persistence.Query computersQuery1;
    private javax.swing.JButton deleteComp;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton miscButtonSearch;
    private javax.swing.JTextField miscTextField;
    private java.util.List<robin.IMS.IMS_App.Miscellaneous> miscellaneousList;
    private javax.persistence.Query miscellaneousQuery;
    private javax.swing.JButton statButtonSearch;
    private javax.swing.JTextField statTextField;
    private java.util.List<robin.IMS.IMS_App.Stationery> stationeryList;
    private javax.persistence.Query stationeryQuery;
    private javax.swing.JButton updateItemButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

     public final void searchComp(String tableName, String idKeyword) {
        /*System.out.println(tableName+" search called");
        computersQuery1 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery
        ("SELECT c FROM "+tableName+" c WHERE c.itemName LIKE '%"+ idKeyword + "%'");
        computersList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : computersQuery1.getResultList();
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, computersList1, compTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${itemName}"));
        columnBinding.setColumnName("Item Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${manufacturer}"));
        columnBinding.setColumnName("Manufacturer");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantity}"));
        columnBinding.setColumnName("Quantity");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dateAdded}"));
        columnBinding.setColumnName("Date Added");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        CompScroll.setViewportView(compTable);*/
        computersQuery1 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery
       ("SELECT c FROM "+tableName+" c WHERE c.itemName LIKE '%"+ idKeyword + "%'");
        computersList1.clear();
        computersList1.addAll( computersQuery1.getResultList());
    }

    private void searchCafe(String tableName, String idKeyword) {
        System.out.println(tableName+" search called");
        cafetariaQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery
                ("SELECT c FROM "+tableName+" c WHERE c.itemName LIKE '%"+ idKeyword + "%'");
        cafetariaList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : cafetariaQuery.getResultList();
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cafetariaList, Cafetaria);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${itemName}"));
        columnBinding.setColumnName("Item Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${manufacturer}"));
        columnBinding.setColumnName("Manufacturer");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantity}"));
        columnBinding.setColumnName("Quantity");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dateAdded}"));
        columnBinding.setColumnName("Date Added");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        CafeScroll.setViewportView(Cafetaria);
    }

    private void searchStat(String tableName, String idKeyword) {
        System.out.println(tableName+" search called");
        stationeryQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery
                ("SELECT c FROM "+tableName+" c WHERE c.itemName LIKE '%"+ idKeyword + "%'");
        stationeryList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : stationeryQuery.getResultList();
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, stationeryList, Stationery);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${itemName}"));
        columnBinding.setColumnName("Item Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${manufacturer}"));
        columnBinding.setColumnName("Manufacturer");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantity}"));
        columnBinding.setColumnName("Quantity");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dateAdded}"));
        columnBinding.setColumnName("Date Added");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        StatScroll.setViewportView(Stationery);
    }

    private void searchMisc(String tableName, String idKeyword) {
        System.out.println(tableName+" search called");
        miscellaneousQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery
                ("SELECT c FROM "+tableName+" c WHERE c.itemName LIKE '%"+ idKeyword + "%'");
        miscellaneousList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : miscellaneousQuery.getResultList();
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, miscellaneousList, Miscellaneous);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${itemName}"));
        columnBinding.setColumnName("Item Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${manufacturer}"));
        columnBinding.setColumnName("Manufacturer");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantity}"));
        columnBinding.setColumnName("Quantity");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dateAdded}"));
        columnBinding.setColumnName("Date Added");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        MiscScroll.setViewportView(Miscellaneous);
    }

}
