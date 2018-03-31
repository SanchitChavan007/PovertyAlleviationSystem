/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.EnterpriseAdminRole;

import Business.Employee.Employee;
import Business.Enterpise.CuratorEnterprise;
import Business.Enterpise.Enterprise;
import Business.Enterpise.Enterprise.EnterpriseType;
import Business.Enterpise.JobProviderEnterprise;

import Business.Enterpise.NGOEnterprise;
import Business.Enterpise.TrainingProviderEnterprise;

import Business.Organization.Organization;
import Business.Organization.Organization.JobProviderType;
import Business.Organization.Organization.Type;

import Business.Organization.OrganizationDirectory;
import Business.UserAccount.UserAccount;
import Business.Validator;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kinnari
 */
public class ManageOrganizationJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageOrganizationJPanel
     */
    private OrganizationDirectory directory;
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;

    public ManageOrganizationJPanel(JPanel userProcessContainer, Enterprise enterprise, OrganizationDirectory directory, UserAccount userAccount) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.directory = directory;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        loggedinLabel.setText(userAccount.getEmployee().getName());
        roleLbl.setText(userAccount.getRole().toString());
        orgLbl.setText(enterprise.getName());
        if(enterprise instanceof TrainingProviderEnterprise 
            || enterprise instanceof JobProviderEnterprise )
        {
            lblSize.setVisible(true);
            txtSize.setVisible(true);
        }
        else
        {
            lblSize.setVisible(false);
            txtSize.setVisible(false);
        }
        populateCombo();
        populateTable();
    }

    private void populateCombo() {

        organizationJComboBox.removeAllItems();

        if ((enterprise.getEnterpriseType().getValue().equals(EnterpriseType.Curator.getValue()))) {
//                organizationJComboBox.addItem(Organization.Type.DataCollector);
            CuratorEnterprise.CuratorType type[] = CuratorEnterprise.CuratorType.values();
            for (CuratorEnterprise.CuratorType cType : type) {
                organizationJComboBox.addItem(cType);
            }
        }
        else if(enterprise.getEnterpriseType().getValue().equals(EnterpriseType.NGO.getValue())){
            NGOEnterprise.NGOType type[]= NGOEnterprise.NGOType.values();
            for(NGOEnterprise.NGOType nType : type){
                organizationJComboBox.addItem(nType);
            }
        }
        else if(enterprise.getEnterpriseType().getValue().equals(EnterpriseType.TrainingProvider.getValue())){
           TrainingProviderEnterprise.TrainingProviderType type[]= TrainingProviderEnterprise.TrainingProviderType.values();
            for(TrainingProviderEnterprise.TrainingProviderType nType : type){
                organizationJComboBox.addItem(nType);
            }
        }
        else if(enterprise.getEnterpriseType().getValue().equals(EnterpriseType.JobProvider.getValue())){
            JobProviderEnterprise.JobProviderType type[]= JobProviderEnterprise.JobProviderType.values();
            for(JobProviderEnterprise.JobProviderType nType : type){
                organizationJComboBox.addItem(nType);
            }
        }
        else if (enterprise.getEnterpriseType().getValue().equals(EnterpriseType.Restaurant.getValue())){
            organizationJComboBox.addItem(Organization.Type.Restaurant);
        }
		else if (enterprise.getEnterpriseType().getValue().equals(EnterpriseType.TrainingProcessManager.getValue())){
            organizationJComboBox.addItem(Organization.Type.TrainingProcessManager);
        }
        else if (enterprise.getEnterpriseType().getValue().equals(EnterpriseType.TrainingProvider.getValue())){
            organizationJComboBox.addItem(Organization.Type.TrainingProvider);
        }

    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();

        model.setRowCount(0);

        for (Organization organization : directory.getOrganizationList()) {
            Object[] row = new Object[2];
            row[0] = organization.getOrganizationID();
            row[1] = organization.getName();

            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        organizationJTable = new javax.swing.JTable();
        addJButton = new javax.swing.JButton();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtOrganization = new javax.swing.JTextField();
        txtSize = new javax.swing.JTextField();
        lblSize = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        loggedinLabel = new javax.swing.JLabel();
        roleLbl = new javax.swing.JLabel();
        orgLbl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        backJBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        organizationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(organizationJTable);

        addJButton.setText("Add Organization");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });

        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Organization Type ");

        jLabel2.setText("Organization Name: ");

        lblSize.setText("Size:");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("User Details"));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Log In as :");

        loggedinLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        loggedinLabel.setText("jLabel2");

        roleLbl.setText("jLabel2");

        orgLbl.setText("jLabel3");

        jLabel8.setText("Enterprise");

        jLabel9.setText("Role :");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Enterprise Admin Work Area");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(roleLbl)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(orgLbl)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(loggedinLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16)))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(loggedinLabel)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(orgLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(roleLbl))
                .addContainerGap())
        );

        backJBtn.setBackground(new java.awt.Color(0, 102, 255));
        backJBtn.setText("<< Back");
        backJBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backJBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 189, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(addJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSize)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(organizationJComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backJBtn)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSize))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addJButton)
                .addGap(99, 99, 99))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        //Type obj = (Type) organizationJComboBox.getSelectedItem();
        String type = organizationJComboBox.getSelectedItem().toString();
        String sname = txtOrganization.getText().trim();
        if (sname.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Please enter name of organization", "Warning", JOptionPane.WARNING_MESSAGE);
            return;

        }
        if(lblSize.isVisible())
        {
            if(!Validator.isNumeric(txtSize.getText()).equalsIgnoreCase("")){
           JOptionPane.showMessageDialog(null, Validator.isNumeric(txtSize.getText()), "Error", JOptionPane.ERROR_MESSAGE);
           return;
       }
        }
        if(enterprise instanceof JobProviderEnterprise)
        {
            for (JobProviderType jt : Organization.JobProviderType.values()){
                if(jt.toString().equals(type)){
                directory.createOrganization(null,jt, sname,Integer.parseInt(txtSize.getText().trim()));
                txtOrganization.setText("");
            }
            }
        }
        else
        {
        for(Type t : Organization.Type.values()){
            if(t.toString().equals(type)){
                if(enterprise instanceof TrainingProviderEnterprise){
                    directory.createOrganization(t,null, sname,Integer.parseInt(txtSize.getText().trim()));
                    txtOrganization.setText("");
                }else
                {
                directory.createOrganization(t,null, sname);
                txtOrganization.setText("");
                }
            }
        }
        }
//        Object obj = (Object) organizationJComboBox.getSelectedItem();
//        if(obj instanceof Organization.Type)
//        {
//            Organization.CDCType cd =(CDCType) organizationJComboBox.getSelectedItem();
//            directory.createOrganization(cd,null,null,null);
//        }
        //directory.createOrganization(obj, sname);
        
        JOptionPane.showMessageDialog(null, "Organization added successfully!!!", "Information", JOptionPane.INFORMATION_MESSAGE);
       txtSize.setText("");
        populateTable();

    }//GEN-LAST:event_addJButtonActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    private void backJBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JButton backJBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSize;
    private javax.swing.JLabel loggedinLabel;
    private javax.swing.JLabel orgLbl;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTable organizationJTable;
    private javax.swing.JLabel roleLbl;
    private javax.swing.JTextField txtOrganization;
    private javax.swing.JTextField txtSize;
    // End of variables declaration//GEN-END:variables
}
