/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.JobProcessOrganization;

import Business.Constant;
import UserInterface.CuratorOrganization.JobManagerRole.*;
import Business.EcoSystem;
import Business.Enterpise.Enterprise;
import Business.Organization.DataCollectorOrganization;
import Business.Organization.JobProcessOrganization;
import Business.Organization.JobRequestManagerOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.JobWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author sanch
 */
public class ProcessJobRequestJPanel extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private JobProcessOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    EcoSystem business;
    /**
     * Creates new form ManageJobRequestJPanel
     */
    public ProcessJobRequestJPanel() {
        initComponents();
    }

    ProcessJobRequestJPanel(JPanel userProcessContainer, UserAccount userAccount, JobProcessOrganization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
         this.userProcessContainer = userProcessContainer;
        this.organization =(JobProcessOrganization) organization;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        this.business = business;
          loggedinLabel.setText(userAccount.getEmployee().getName());
        orgLbl.setText(organization.getName());
        roleLbl.setText(userAccount.getRole().toString());
        populateRequestTable();
       
    }

    public void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel) requestTable.getModel();
        
        model.setRowCount(0);
         //WorkRequest request =organization.getWorkQueue().getWorkRequestList()
                 for(WorkRequest request :organization.getWorkQueue().getWorkRequestList()){
                     Object[] row = new Object[5];
                     row[0] =request;
                     row[1] = ((JobWorkRequest)request).getQuestionaire().getPersonalQuestionnaire().getName();
                     row[2] = ((JobWorkRequest)request).getQuestionaire().getPersonalQuestionnaire().getRequestType();
                     row[3] = ((JobWorkRequest)request).getStatus();
                     row[4] =((JobWorkRequest)request).getReceiver() != null ? ((JobWorkRequest)request).getReceiver().getUserID() : "";
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
        btnAssignJob = new javax.swing.JButton();
        backJBtn = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        loggedinLabel = new javax.swing.JLabel();
        roleLbl = new javax.swing.JLabel();
        orgLbl = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        requestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RequestID", "Individual Name", "Request Type", "Status", "Assigned To"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(requestTable);
        if (requestTable.getColumnModel().getColumnCount() > 0) {
            requestTable.getColumnModel().getColumn(0).setResizable(false);
            requestTable.getColumnModel().getColumn(1).setResizable(false);
            requestTable.getColumnModel().getColumn(2).setResizable(false);
            requestTable.getColumnModel().getColumn(3).setResizable(false);
            requestTable.getColumnModel().getColumn(4).setResizable(false);
        }

        btnAssignJob.setBackground(new java.awt.Color(51, 255, 51));
        btnAssignJob.setText("Assign Job");
        btnAssignJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignJobActionPerformed(evt);
            }
        });

        backJBtn.setBackground(new java.awt.Color(0, 102, 255));
        backJBtn.setText("<< Back");
        backJBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJBtnActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("User Details"));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("Log In as :");

        loggedinLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        loggedinLabel.setText("jLabel2");

        roleLbl.setText("jLabel2");

        orgLbl.setText("jLabel3");

        jLabel20.setText("Enterprise");

        jLabel21.setText("Role :");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("Process Job Request Work Area");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(18, 18, 18)
                        .addComponent(roleLbl)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(orgLbl)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addComponent(loggedinLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel22)))
                        .addContainerGap())))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(loggedinLabel)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(orgLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(roleLbl))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(531, Short.MAX_VALUE)
                .addComponent(btnAssignJob)
                .addGap(186, 186, 186))
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(backJBtn)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(backJBtn)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(btnAssignJob)
                .addContainerGap(78, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignJobActionPerformed
        int selectedRow = requestTable.getSelectedRow();
        JobWorkRequest request= null;
        
        if(selectedRow<0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (selectedRow >= 0) {
            request = (JobWorkRequest) requestTable.getValueAt(selectedRow, 0);
            if(request.getStatus().equalsIgnoreCase(Constant.TR_REQUESTSTATUS_ASSIGNED)
              || request.getStatus().equalsIgnoreCase(Constant.TR_REQUESTSTATUS_PROCESSED) )
            {
                JOptionPane.showMessageDialog(null, "Request already proceeded from "+ organization.getName() + ".!!!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            //            if(request.getStatus().equalsIgnoreCase("Assigned"))
            //            {
                //                JOptionPane.showMessageDialog(null, "Job already assigned", "Warning", JOptionPane.WARNING_MESSAGE);
                //            return;
                //            }
//            TemporaryPJpanel panel = new TemporaryPJpanel(userProcessContainer, userAccount, organization, enterprise, business, request);
            JobSelectionJPanel panel = new JobSelectionJPanel(userProcessContainer, userAccount, organization, enterprise, business, request);
            userProcessContainer.add("JobSelectionJPanel",panel);
//              userProcessContainer.add("TemporaryPJpanel", panel);
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_btnAssignJobActionPerformed

    private void backJBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJBtn;
    private javax.swing.JButton btnAssignJob;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel loggedinLabel;
    private javax.swing.JLabel orgLbl;
    private javax.swing.JTable requestTable;
    private javax.swing.JLabel roleLbl;
    // End of variables declaration//GEN-END:variables
}
