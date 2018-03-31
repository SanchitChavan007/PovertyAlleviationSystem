/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CuratorOrganization.DataCollectorRole;

import Business.EcoSystem;
import Business.Enterpise.Enterprise;
import Business.Organization.DataCollectorOrganization;
import Business.Organization.JobRequestManagerOrganization;
import Business.Organization.Organization;
import Business.Organization.TrainingRequestManagerOrganization;
import Business.Questionnaire.PersonalQuestionnaire;
import Business.Questionnaire.Questionnaire;
import Business.UserAccount.UserAccount;
import Business.Validator;
import Business.WorkQueue.JobWorkRequest;
import Business.WorkQueue.TrainingRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author sanch
 */
public class ManageIndividualDetailsJPanel extends javax.swing.JPanel {
 private JPanel userProcessContainer;
    private DataCollectorOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    EcoSystem business;
    /**
     * Creates new form ManageIndividualDetailsJPanel
     */
    public ManageIndividualDetailsJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,EcoSystem business) {
        initComponents();
         this.userProcessContainer = userProcessContainer;
        this.organization =(DataCollectorOrganization) organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.business = business;
         loggedinLabel1.setText(userAccount.getEmployee().getName());
        orgLbl1.setText(organization.getName());
        roleLbl1.setText(userAccount.getRole().toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reqBtnGroup = new javax.swing.ButtonGroup();
        jLabel3 = new javax.swing.JLabel();
        educationCombo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        addRecordButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        backJBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        eduRadioButton = new javax.swing.JRadioButton();
        jobRadioButton = new javax.swing.JRadioButton();
        txtName = new javax.swing.JTextField();
        ageCombo = new javax.swing.JComboBox<>();
        genderCombo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtIncome = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ssnTxt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        ImageLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtemailAddress = new javax.swing.JTextField();
        txtContact = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        loggedinLabel1 = new javax.swing.JLabel();
        roleLbl1 = new javax.swing.JLabel();
        orgLbl1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Age:");

        educationCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Primary School", "Secondary School", "Undergraduate", "Graduate" }));

        jLabel4.setText("Gender:");

        addRecordButton.setBackground(new java.awt.Color(102, 255, 102));
        addRecordButton.setText("Add Record");
        addRecordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRecordButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Family Income:");

        backJBtn.setBackground(new java.awt.Color(0, 102, 255));
        backJBtn.setText("<< Back");
        backJBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJBtnActionPerformed(evt);
            }
        });

        jLabel6.setText("Highest Education:");

        jLabel7.setText("Request type:");

        reqBtnGroup.add(eduRadioButton);
        eduRadioButton.setText("Education");

        reqBtnGroup.add(jobRadioButton);
        jobRadioButton.setSelected(true);
        jobRadioButton.setText("Job");

        ageCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100" }));
        ageCombo.setMinimumSize(new java.awt.Dimension(59, 20));
        ageCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageComboActionPerformed(evt);
            }
        });

        genderCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        jLabel2.setText("Name:");

        jLabel8.setText("Enter SSN:");

        jButton1.setText("Upload Valid ID Proof");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ImageLabel.setBackground(new java.awt.Color(153, 255, 204));
        ImageLabel.setForeground(new java.awt.Color(255, 255, 255));
        ImageLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setText("Email Address:");

        jLabel10.setText("Phone number:");

        jLabel11.setText("Address:");

        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("User Details"));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Log In as :");

        loggedinLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        loggedinLabel1.setText("jLabel2");

        roleLbl1.setText("jLabel2");

        orgLbl1.setText("jLabel3");

        jLabel13.setText("Enterprise");

        jLabel14.setText("Role :");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Individual Details Area");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(roleLbl1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(orgLbl1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(loggedinLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 421, Short.MAX_VALUE)
                                .addComponent(jLabel17)))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(loggedinLabel1)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(orgLbl1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(roleLbl1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(educationCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(jLabel4)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(genderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel3)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(ageCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(jLabel2)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel8)
                                                    .addComponent(jLabel9))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(ssnTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtemailAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(eduRadioButton)
                                                .addGap(10, 10, 10)
                                                .addComponent(jobRadioButton))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(32, 32, 32)
                                                .addComponent(jLabel11)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(67, 67, 67)
                                                .addComponent(ImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(43, 43, 43)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(233, 233, 233)
                                        .addComponent(addRecordButton))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(backJBtn)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backJBtn)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(ImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)
                                .addComponent(ssnTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(21, 21, 21)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ageCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel9)
                                .addComponent(txtemailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(25, 25, 25)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(genderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)
                                .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(22, 22, 22)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(txtIncome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(educationCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(21, 21, 21)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(eduRadioButton)
                                .addComponent(jobRadioButton)))))
                .addGap(47, 47, 47)
                .addComponent(addRecordButton)
                .addGap(173, 173, 173))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addRecordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRecordButtonActionPerformed
        // TODO add your handling code here:
        int age1 = Integer.parseInt(ageCombo.getSelectedItem().toString());
           if(Validator.StringEmpty(txtName.getText()) 
         || Validator.StringEmpty(txtAddress.getText())
         || Validator.StringEmpty(txtContact.getText())
         || Validator.StringEmpty(txtIncome.getText())
         || Validator.StringEmpty(txtemailAddress.getText())
         || Validator.StringEmpty(ageCombo.getSelectedItem().toString())
         || Validator.StringEmpty(genderCombo.getSelectedItem().toString())
         ||ImageLabel.getIcon()==null
          ||((!eduRadioButton.isSelected())&&(!jobRadioButton.isSelected())))
           {
            JOptionPane.showMessageDialog(null, "All fields are mandatory");
            return;
           }
           else if(age1<=18){
               JOptionPane.showMessageDialog(null, "Individuals below 18 years of age are not permitted to work!!", "Warning", JOptionPane.WARNING_MESSAGE);
           }
           else
           {
        String name = txtName.getText();
        int age = Integer.parseInt( ageCombo.getSelectedItem().toString());
        String gender = genderCombo.getSelectedItem().toString();
        int income = Integer.parseInt(txtIncome.getText());
        if(income>24000)
        {
             JOptionPane.showMessageDialog(null, "Ineligible Individual");
             return;
        }
        String requestType=jobRadioButton.isSelected() ? "job":"edu";
         String ssn = ssnTxt.getText();
          if(Validator.isSSNValid(ssnTxt.getText())==false)
          {
              JOptionPane.showMessageDialog(null, "Invalid SSN format.");
              return;
          }
         String address = txtAddress.getText();
        
         String contact = txtContact.getText();
          if(Validator.isPhoneNumberValid(txtContact.getText())==false)
                  {
                      JOptionPane.showMessageDialog(null, "Invalid phone number format.");
                    return;
                  }
         String emailAddress = txtemailAddress.getText();
        if(Validator.isEmailValid(txtemailAddress.getText())==false)
                {
                    JOptionPane.showMessageDialog(null, "Invalid email address format.");
                    return;
                }
        Questionnaire qt = business.getQuestionnaireList().addQuestionnaire();
        PersonalQuestionnaire questionnaire = qt.getPersonalQuestionnaire();
        questionnaire.setName(name);
        questionnaire.setAge(age);
        questionnaire.setEducation(requestType);
        questionnaire.setGender(gender);
        questionnaire.setIncome(income);
        questionnaire.setRequestType(requestType);
        questionnaire.setSsn(ssn);
        questionnaire.setAddress(address);
        questionnaire.setContact(contact);
        questionnaire.setEmailAddress(emailAddress);
        questionnaire.setIdProof((ImageIcon) ImageLabel.getIcon());
        qt.setPersonalQuestionnaire(questionnaire);
        Organization org = null;

        for (Organization og : enterprise.getOrganizationList().getOrganizationList()){
            if(requestType.equalsIgnoreCase("job")){
                if (og instanceof JobRequestManagerOrganization){
                    org = og;
                    break;
                }
            }
            else{
                if (og instanceof TrainingRequestManagerOrganization){
                    org = og;
                    break;
                }
            }
        }
        if (org!=null){
            if(requestType.equalsIgnoreCase("job")){
                JobWorkRequest request = new JobWorkRequest();
                request.setSender(userAccount);
                request.setStatus("Sent");
                request.setQuestionaire(qt);
                org.getWorkQueue().getWorkRequestList().add(request);
                userAccount.getWorkQueue().getWorkRequestList().add(request);
            }
            else if(requestType.equalsIgnoreCase("edu")){
                TrainingRequest request = new TrainingRequest();
                request.setSender(userAccount);
                request.setStatus("Sent");
                request.setQuestionaire(qt);
                org.getWorkQueue().getWorkRequestList().add(request);
                userAccount.getWorkQueue().getWorkRequestList().add(request);
            }

        }
        JOptionPane.showMessageDialog(null, "Individual request created successfully", "Warning", JOptionPane.INFORMATION_MESSAGE);
         ImageLabel.setIcon(null);
         txtemailAddress.setText("");
         txtIncome.setText("");
         txtContact.setText("");
         txtAddress.setText("");
         txtName.setText("");
         ssnTxt.setText("");
                                        
    }//GEN-LAST:event_addRecordButtonActionPerformed
    }
    private void backJBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJBtnActionPerformed

    private void ageComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageComboActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
 JFileChooser choose= new JFileChooser();
        choose.showOpenDialog(null);
        File file=choose.getSelectedFile();
        String picture=file.getAbsolutePath();
        
          ImageIcon icon=new ImageIcon(picture);
           ImageLabel.setIcon(new ImageIcon(new ImageIcon(picture).getImage().getScaledInstance(99, 99, Image.SCALE_DEFAULT)));
        
           
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImageLabel;
    private javax.swing.JButton addRecordButton;
    private javax.swing.JComboBox<String> ageCombo;
    private javax.swing.JButton backJBtn;
    private javax.swing.JRadioButton eduRadioButton;
    private javax.swing.JComboBox<String> educationCombo;
    private javax.swing.JComboBox<String> genderCombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jobRadioButton;
    private javax.swing.JLabel loggedinLabel1;
    private javax.swing.JLabel orgLbl1;
    private javax.swing.ButtonGroup reqBtnGroup;
    private javax.swing.JLabel roleLbl1;
    private javax.swing.JTextField ssnTxt;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtIncome;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtemailAddress;
    // End of variables declaration//GEN-END:variables
}