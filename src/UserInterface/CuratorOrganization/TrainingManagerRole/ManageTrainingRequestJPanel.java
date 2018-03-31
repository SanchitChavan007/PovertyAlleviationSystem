/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CuratorOrganization.TrainingManagerRole;

import Business.EcoSystem;
import Business.Enterpise.Enterprise;
import Business.Organization.JobRequestManagerOrganization;
import Business.Organization.Organization;
import Business.Organization.TrainingRequestManagerOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.JobWorkRequest;
import Business.WorkQueue.TrainingRequest;
import Business.WorkQueue.WorkRequest;
import UserInterface.CuratorOrganization.JobManagerRole.AddJobRequestDetailsJPanel;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sanch
 */
public class ManageTrainingRequestJPanel extends javax.swing.JPanel {
private JPanel userProcessContainer;
    private TrainingRequestManagerOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    EcoSystem business;
    /**
     * Creates new form ManageTraining
     */
    public ManageTrainingRequestJPanel (JPanel userProcessContainer, UserAccount userAccount, Organization organization, Enterprise enterprise, EcoSystem business) {
         initComponents();
         this.userProcessContainer = userProcessContainer;
        this.organization =(TrainingRequestManagerOrganization) organization;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        this.business = business;
//        valueLabel.setText(enterprise.getName());
        populateRequestTable();
        loggedinLabel4.setText(userAccount.getEmployee().getName());
        roleLbl4.setText(userAccount.getRole().toString());
        orgLbl4.setText(organization.getName());
    }
private void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel) requestTable.getModel();
        
        model.setRowCount(0);
         //WorkRequest request =organization.getWorkQueue().getWorkRequestList()
                 for(WorkRequest request :organization.getWorkQueue().getWorkRequestList()){
                     Object[] row = new Object[4];
                     row[0] =request;
                     row[1] = ((TrainingRequest)request).getQuestionaire().getPersonalQuestionnaire().getName();
                     row[2] = ((TrainingRequest)request).getQuestionaire().getPersonalQuestionnaire().getRequestType();
                     row[3] = ((TrainingRequest)request).getStatus();
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
        requestTable = new javax.swing.JTable();
        viewRecordButton = new javax.swing.JButton();
        backJBtn = new javax.swing.JButton();
        enterpriseLabel1 = new javax.swing.JLabel();
        valueLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        loggedinLabel4 = new javax.swing.JLabel();
        roleLbl4 = new javax.swing.JLabel();
        orgLbl4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        requestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request ID", "Individual Name", "Request Type", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        requestTable.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(requestTable);

        viewRecordButton.setBackground(new java.awt.Color(51, 255, 51));
        viewRecordButton.setText("Add Training Details");
        viewRecordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewRecordButtonActionPerformed(evt);
            }
        });

        backJBtn.setBackground(new java.awt.Color(255, 51, 51));
        backJBtn.setText("<< Back");
        backJBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJBtnActionPerformed(evt);
            }
        });

        enterpriseLabel1.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        enterpriseLabel1.setForeground(new java.awt.Color(153, 0, 51));
        enterpriseLabel1.setText("EnterPrise :");

        valueLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        valueLabel1.setForeground(new java.awt.Color(153, 0, 51));
        valueLabel1.setText("<value>");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("User Details"));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Log In as :");

        loggedinLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        loggedinLabel4.setText("jLabel2");

        roleLbl4.setText("jLabel2");

        orgLbl4.setText("jLabel3");

        jLabel14.setText("Organization :");

        jLabel15.setText("Role :");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Training Manager Work Area");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(roleLbl4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(orgLbl4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(loggedinLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16)))
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(loggedinLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(orgLbl4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(roleLbl4))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backJBtn)
                        .addGap(0, 707, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(328, 328, 328)
                .addComponent(viewRecordButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(viewRecordButton)
                .addGap(119, 119, 119)
                .addComponent(backJBtn)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewRecordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewRecordButtonActionPerformed
        int selectedRow = requestTable.getSelectedRow();
        TrainingRequest request = null;
        if(selectedRow<0)
        {
            JOptionPane.showMessageDialog(null, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);
            return;

        }
        if(selectedRow>=0)
        {
            request = (TrainingRequest) requestTable.getValueAt(selectedRow, 0);
            if(request.getReceiver() != null){
                JOptionPane.showMessageDialog(null, "Request Already forwarded.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
            }
            AddTrainingRequestDetailsJPanel AddTrainingRequestDetailsJPanel = new AddTrainingRequestDetailsJPanel(userProcessContainer,userAccount,organization, enterprise,business,request);
            userProcessContainer.add("AddTrainingRequestDetailsJPanel", AddTrainingRequestDetailsJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }

    }//GEN-LAST:event_viewRecordButtonActionPerformed

    private void backJBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJBtn;
    private javax.swing.JLabel enterpriseLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel loggedinLabel4;
    private javax.swing.JLabel orgLbl4;
    private javax.swing.JTable requestTable;
    private javax.swing.JLabel roleLbl4;
    private javax.swing.JLabel valueLabel1;
    private javax.swing.JButton viewRecordButton;
    // End of variables declaration//GEN-END:variables
}