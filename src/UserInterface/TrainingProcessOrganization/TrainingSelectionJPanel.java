/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.TrainingProcessOrganization;

import Business.Constant;
import Business.EcoSystem;
import Business.Enterpise.Enterprise;
import Business.Enterpise.TrainingProviderEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.TrainingProcessOrganization;
import Business.Organization.TrainingProvider.CarpentryTrainingOrganization;
import Business.Organization.TrainingProvider.ConstructionTrainingOrganization;
//import Business.Organization.TrainingProvider.CossssnstructionTrainingOrganization;
import Business.Organization.TrainingProvider.GeneralTrainingOrganization;
import Business.Organization.TrainingProvider.SecurityTrainingOrganization;
import Business.Organization.TrainingProviderOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.TrainingRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author sanch
 */
public class TrainingSelectionJPanel extends javax.swing.JPanel {
private JPanel userProcessContainer;
    private TrainingProcessOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    EcoSystem business;
    TrainingRequest request;
    private TrainingProviderOrganization selecteddropdownOrg;
    /** Creates new form TrainingSelectionJPanel */
    public TrainingSelectionJPanel(JPanel userProcessContainer, UserAccount userAccount, Organization organization, Enterprise enterprise, EcoSystem business, TrainingRequest request) {
        initComponents();
         this.userProcessContainer = userProcessContainer;
        this.organization =(TrainingProcessOrganization) organization;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        this.business = business;
        this.request = request;
        loggedinLabel.setText(userAccount.getEmployee().getName());
        orgLbl.setText(organization.getName());
        roleLbl.setText(userAccount.getRole().toString());
//          valueLabel.setText(enterprise.getName());
          populateDetails();
          populateTrainingCombo();
    }
    private void populateTrainingCombo(){
        availabeInstCombo.removeAllItems();
        Enterprise tm =null;
        for (Network network : business.getNetworkList()) {
                for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
                    if(ent instanceof TrainingProviderEnterprise){
                        tm = ent;
                        break;
                    }
                }
        }
        if(request.getQuestionaire().getTrainingQuestionaire().getInterest() != null ){
            if(request.getQuestionaire().getTrainingQuestionaire().getInterest().equalsIgnoreCase("Carpentry"))
            {
                for (Organization org : tm.getOrganizationList().getOrganizationList()) {
                 if(org instanceof CarpentryTrainingOrganization )
                        availabeInstCombo.addItem(org);
                    }
            }
            else if(request.getQuestionaire().getTrainingQuestionaire().getInterest().equalsIgnoreCase("Security"))
            {
                for (Organization org : tm.getOrganizationList().getOrganizationList()) {
                 if(org instanceof SecurityTrainingOrganization )
                        availabeInstCombo.addItem(org);
                    }
            }
            else if(request.getQuestionaire().getTrainingQuestionaire().getInterest().equalsIgnoreCase("Construction"))
            {
                for (Organization org : tm.getOrganizationList().getOrganizationList()) {
                 if(org instanceof ConstructionTrainingOrganization )
                        availabeInstCombo.addItem(org);
                    }
            }
            else if(request.getQuestionaire().getTrainingQuestionaire().getInterest().equalsIgnoreCase("General"))
            {
                for (Organization org : tm.getOrganizationList().getOrganizationList()) {
                 if(org instanceof GeneralTrainingOrganization )
                        availabeInstCombo.addItem(org);
                    }
            }
            else
        {
            
                    for (Organization org : tm.getOrganizationList().getOrganizationList()) {
                        availabeInstCombo.addItem(org);
                    }
                
        }
        }
        else
        {
            
                    for (Organization org : tm.getOrganizationList().getOrganizationList()) {
                        availabeInstCombo.addItem(org);
                    }
                
        }
        
//        if(request.getQuestionaire().getTrainingQuestionaire().getInterest().equalsIgnoreCase("Carpentry"))
//        {
//            for(Organization org : enterprise.getOrganizationList().getOrganizationList()){
//                if(org.getType().getValue().equalsIgnoreCase("Carpentry")){
//                    availabeInstCombo.addItem(org);
//                }
//            }
//        }
//        else if (tinteresttxt.getText().equalsIgnoreCase("Security"))
//        {
//            for(Organization org : enterprise.getOrganizationList().getOrganizationList()){
//                if(org.getType().getValue().equalsIgnoreCase("Security")){
//                    availabeInstCombo.addItem(org);
//                }
//            }
//    }
//        else if (tinteresttxt.getText().equalsIgnoreCase("Construction"))
//        {
//            for(Organization org : enterprise.getOrganizationList().getOrganizationList()){
//                if(org.getType().getValue().equalsIgnoreCase("Construction")){
//                    availabeInstCombo.addItem(org);
//                }
//            }
//    }
//        else if (tinteresttxt.getText().equalsIgnoreCase("General"))
//        {
//            for(Organization org : enterprise.getOrganizationList().getOrganizationList()){
//                if(org.getType().getValue().equalsIgnoreCase("General")){
//                    availabeInstCombo.addItem(org);
//                }
//            }
//    }
    }
    private void populateDetails(){
        nametxt.setText(request.getQuestionaire().getPersonalQuestionnaire().getName());
       treceivedtxt.setText(request.getQuestionaire().getTrainingQuestionaire().getTrainingField());
       tinteresttxt.setText(request.getQuestionaire().getTrainingQuestionaire().getInterest());
       tDurationtxt.setText(request.getQuestionaire().getTrainingQuestionaire().getTrainingDuration());
        //seatstxt.setText(String.valueOf(selecteddropdownOrg.getSeats()));
        
    }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nametxt = new javax.swing.JTextField();
        tinteresttxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        treceivedtxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tDurationtxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        availabeInstCombo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        assignTrainerBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtSeats = new javax.swing.JTextField();
        backJBtn1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        loggedinLabel = new javax.swing.JLabel();
        roleLbl = new javax.swing.JLabel();
        orgLbl = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        nametxt.setEnabled(false);

        tinteresttxt.setEnabled(false);

        jLabel2.setText("Training Interest:");

        treceivedtxt.setEnabled(false);

        jLabel1.setText("Training Received:");

        tDurationtxt.setEnabled(false);

        jLabel7.setText("Training Duration:");

        availabeInstCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        availabeInstCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availabeInstComboActionPerformed(evt);
            }
        });

        jLabel4.setText("Available training institues:");

        jLabel8.setText("Individual Name:");

        assignTrainerBtn.setBackground(new java.awt.Color(102, 255, 102));
        assignTrainerBtn.setText("Assign Training");
        assignTrainerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignTrainerBtnActionPerformed(evt);
            }
        });

        jLabel9.setText("Seats:");

        txtSeats.setEnabled(false);

        backJBtn1.setBackground(new java.awt.Color(0, 102, 255));
        backJBtn1.setText("<< Back");
        backJBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJBtn1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("User Details"));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Log In as :");

        loggedinLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        loggedinLabel.setText("jLabel2");

        roleLbl.setText("jLabel2");

        orgLbl.setText("jLabel3");

        jLabel11.setText("Enterprise");

        jLabel12.setText("Role :");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Assign Training Insitute Area");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(roleLbl)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(orgLbl)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
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
                    .addComponent(jLabel10)
                    .addComponent(loggedinLabel)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(orgLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(roleLbl))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(nametxt))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(treceivedtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(135, 135, 135))
                            .addComponent(availabeInstCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tDurationtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tinteresttxt, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(assignTrainerBtn)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backJBtn1)))
                .addContainerGap(349, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backJBtn1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(treceivedtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(availabeInstCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tDurationtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tinteresttxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(13, 13, 13)
                .addComponent(assignTrainerBtn)
                .addGap(177, 177, 177))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void availabeInstComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_availabeInstComboActionPerformed
        // TODO add your handling code here:
        if(availabeInstCombo.getSelectedItem() != null){
            if(availabeInstCombo.getSelectedItem() instanceof CarpentryTrainingOrganization){
        CarpentryTrainingOrganization tp = (CarpentryTrainingOrganization) availabeInstCombo.getSelectedItem();
        txtSeats.setText(String.valueOf( tp.getSeats()));
            }
            else  if(availabeInstCombo.getSelectedItem() instanceof ConstructionTrainingOrganization){
        ConstructionTrainingOrganization tp = (ConstructionTrainingOrganization) availabeInstCombo.getSelectedItem();
        txtSeats.setText(String.valueOf( tp.getSeats()));
            }
            else  if(availabeInstCombo.getSelectedItem() instanceof SecurityTrainingOrganization){
        SecurityTrainingOrganization tp = (SecurityTrainingOrganization) availabeInstCombo.getSelectedItem();
        txtSeats.setText(String.valueOf( tp.getSeats()));
            }
            else{
                GeneralTrainingOrganization tp = (GeneralTrainingOrganization) availabeInstCombo.getSelectedItem();
        txtSeats.setText(String.valueOf( tp.getSeats()));
            
            }
        }
        //        if(selecteddropdownOrg != null)
        //        {
            //            seatstxt.setText(String.valueOf( selecteddropdownOrg.getSeats()));
            //        }
    }//GEN-LAST:event_availabeInstComboActionPerformed

    private void assignTrainerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignTrainerBtnActionPerformed
        // TODO add your handling code here:
        Organization org = ( Organization) availabeInstCombo.getSelectedItem();
        if(org != null){
            org.getWorkQueue().getWorkRequestList().add(request);
        }
        if(org instanceof CarpentryTrainingOrganization){
        CarpentryTrainingOrganization tp = (CarpentryTrainingOrganization) org;
        tp.setSeats(tp.getSeats() - 1 );
        txtSeats.setText(String.valueOf( tp.getSeats()));
            }
            else  if(org instanceof ConstructionTrainingOrganization){
        ConstructionTrainingOrganization tp = (ConstructionTrainingOrganization) org;
        tp.setSeats(tp.getSeats() - 1 );
        txtSeats.setText(String.valueOf( tp.getSeats()));
            }
            else  if(org instanceof SecurityTrainingOrganization){
        SecurityTrainingOrganization tp = (SecurityTrainingOrganization) org;
        tp.setSeats(tp.getSeats() - 1 );
        txtSeats.setText(String.valueOf( tp.getSeats()));
            }
            else{
                GeneralTrainingOrganization tp = (GeneralTrainingOrganization) org;
                tp.setSeats(tp.getSeats() - 1 );
        txtSeats.setText(String.valueOf( tp.getSeats()));
            
            }
        //        if(org instanceof CarpentryTrainingOrganization){
            //
            //        }
        //request.setMessage(message);
        UserAccount res = org.getUserAccountList().getUserAccountList().get(0);
        request.setReceiver(res);
        request.setStatus(Constant.TR_REQUESTSTATUS_ASSIGNED);
        UserAccount sd= request.getSender();
        JOptionPane.showMessageDialog(null, "Training instituation assigned successfully", "Warning", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_assignTrainerBtnActionPerformed

    private void backJBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJBtn1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ProcessTrainingRequestJPanel sysAdminwjp = (ProcessTrainingRequestJPanel) component;
        sysAdminwjp.populateTrainingRequestTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJBtn1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignTrainerBtn;
    private javax.swing.JComboBox availabeInstCombo;
    private javax.swing.JButton backJBtn1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel loggedinLabel;
    private javax.swing.JTextField nametxt;
    private javax.swing.JLabel orgLbl;
    private javax.swing.JLabel roleLbl;
    private javax.swing.JTextField tDurationtxt;
    private javax.swing.JTextField tinteresttxt;
    private javax.swing.JTextField treceivedtxt;
    private javax.swing.JTextField txtSeats;
    // End of variables declaration//GEN-END:variables

}
