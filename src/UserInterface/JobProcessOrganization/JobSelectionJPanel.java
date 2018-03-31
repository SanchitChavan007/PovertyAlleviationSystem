/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.JobProcessOrganization;

import Business.Constant;
import Business.EcoSystem;
import Business.Enterpise.Enterprise;
import Business.Enterpise.JobProviderEnterprise;
import Business.Enterpise.TrainingProviderEnterprise;
import Business.Network.Network;
import Business.Organization.JobProcessOrganization;
import Business.Organization.JobProvider.CarpentryJobOrganization;
import Business.Organization.JobProvider.ConstructionJobOrganization;
import Business.Organization.JobProvider.GeneralJobOrganization;
import Business.Organization.JobProvider.ITJobOrganization;
import Business.Organization.JobProvider.SecurityJobOrganization;
import Business.Organization.JobProviderOrganization;
import Business.Organization.Organization;
import Business.Questionnaire.Questionnaire;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.JobWorkRequest;
import UserInterface.JobProviderOrganization.ProvideJobRequestJPanel;
import java.awt.CardLayout;
import java.awt.Component;
//import Business.WorkQueue.TrainingRequest;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sanch
 */
public class JobSelectionJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private JobProcessOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    EcoSystem business;
    JobWorkRequest request;
    boolean isRequested = false;

    //private JobProviderOrganization selecteddropdownOrg;
    /**
     * Creates new form TrainingSelectionJPanel
     */
    public JobSelectionJPanel(JPanel userProcessContainer, UserAccount userAccount, Organization organization, Enterprise enterprise, EcoSystem business, JobWorkRequest request) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = (JobProcessOrganization) organization;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        this.business = business;
        this.request = request;
          loggedinLabel.setText(userAccount.getEmployee().getName());
        orgLbl.setText(organization.getName());
        roleLbl.setText(userAccount.getRole().toString());
        populateDetails();
        populateTrainingCombo();
        jobsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (jobsTable.getSelectedRow() > -1) {
                    // print first column value from selected row

                    Organization org = (Organization) jobsTable.getValueAt(jobsTable.getSelectedRow(), 0);
                    if (org instanceof CarpentryJobOrganization) {
                        txtSize.setText(String.valueOf(((CarpentryJobOrganization) org).getSeats()));
                    } else if (org instanceof ConstructionJobOrganization) {
                        txtSize.setText(String.valueOf(((ConstructionJobOrganization) org).getSeats()));
                    } else if (org instanceof SecurityJobOrganization) {
                        txtSize.setText(String.valueOf(((SecurityJobOrganization) org).getSeats()));
                    } else if (org instanceof ITJobOrganization) {
                        txtSize.setText(String.valueOf(((ITJobOrganization) org).getSeats()));
                    } else {
                        txtSize.setText(String.valueOf(((GeneralJobOrganization) org).getSeats()));
                    }
                }
            }
        });
//          EvaluateSpecific();
    }
//    private void EvaluateSpecific(){
//        Questionnaire qus = request.getQuestionaire();
//        if(qus.getJobQuestionaire().isIsComputer() && request.getQuestionaire().getEducationQuestionaire().isIsRead()
//            && request.getQuestionaire().getEducationQuestionaire().isIsWrite() && !request.getQuestionaire().getCriminalRelatedQuestionaire().isIsConvCrime()
//             && !request.getQuestionaire().getDrugAbuseQuestionaire().isIsConsumeDrug() && !request.getQuestionaire().getDrugAbuseQuestionaire().isIsComDrug()      )
//        {
//            txtBestSuited.setText("IT related Jobs");
//        }
//        else if(qus.getJobQuestionaire().isIsComputer() && request.getQuestionaire().getEducationQuestionaire().isIsRead()
//            && request.getQuestionaire().getEducationQuestionaire().isIsWrite() && !request.getQuestionaire().getCriminalRelatedQuestionaire().isIsConvCrime()
//             && !request.getQuestionaire().getDrugAbuseQuestionaire().isIsConsumeDrug() && request.getQuestionaire().getDrugAbuseQuestionaire().isIsComDrug() )
//        {
//            txtBestSuited.setText("Carpentry related Jobs");
//        }
//        else if(!qus.getJobQuestionaire().isIsComputer() && request.getQuestionaire().getEducationQuestionaire().isIsRead()
//            && request.getQuestionaire().getEducationQuestionaire().isIsWrite() && !request.getQuestionaire().getCriminalRelatedQuestionaire().isIsConvCrime()
//             && request.getQuestionaire().getDrugAbuseQuestionaire().isIsConsumeDrug() && request.getQuestionaire().getDrugAbuseQuestionaire().isIsComDrug() )
//        {
//            txtBestSuited.setText("Carpentry related Jobs");
//        }
//        else if(!qus.getJobQuestionaire().isIsComputer() && !request.getQuestionaire().getEducationQuestionaire().isIsRead()
//            && !request.getQuestionaire().getEducationQuestionaire().isIsWrite() && !request.getQuestionaire().getCriminalRelatedQuestionaire().isIsConvCrime()
//             && request.getQuestionaire().getDrugAbuseQuestionaire().isIsConsumeDrug() && request.getQuestionaire().getDrugAbuseQuestionaire().isIsComDrug() )
//        {
//            txtBestSuited.setText("Construction related Jobs");
//        }
//        else if(!qus.getJobQuestionaire().isIsComputer() && !request.getQuestionaire().getEducationQuestionaire().isIsRead()
//            && !request.getQuestionaire().getEducationQuestionaire().isIsWrite() && !request.getQuestionaire().getCriminalRelatedQuestionaire().isIsConvCrime()
//             && request.getQuestionaire().getDrugAbuseQuestionaire().isIsConsumeDrug() && request.getQuestionaire().getDrugAbuseQuestionaire().isIsComDrug() )
//        {
//            txtBestSuited.setText("General Jobs");
//        }
//    }

    private void populateDetails() {
        nametxt.setText(request.getQuestionaire().getPersonalQuestionnaire().getName());
        lblResultComputers.setText(request.getQuestionaire().getJobQuestionaire().isIsComputer() ? Constant.TR_YES : Constant.TR_NO);
        lblResultConstruction.setText(request.getQuestionaire().getJobQuestionaire().isIsConstruction() ? Constant.TR_YES : Constant.TR_NO);
        lblResultOvernight.setText(request.getQuestionaire().getJobQuestionaire().isIsOvernight() ? Constant.TR_YES : Constant.TR_NO);

        lblResultRead.setText(request.getQuestionaire().getEducationQuestionaire().isIsRead() ? Constant.TR_YES : Constant.TR_NO);
        lblResultWrite.setText(request.getQuestionaire().getEducationQuestionaire().isIsWrite() ? Constant.TR_YES : Constant.TR_NO);
        lblResultNesTraining.setText(request.getQuestionaire().getEducationQuestionaire().isIsNecessaryTraining() ? Constant.TR_YES : Constant.TR_NO);

        lblResultCrime.setText(request.getQuestionaire().getCriminalRelatedQuestionaire().isIsConvCrime() ? Constant.TR_YES : Constant.TR_NO);
        lblResultDrugs.setText(request.getQuestionaire().getDrugAbuseQuestionaire().isIsConsumeDrug() ? Constant.TR_YES : Constant.TR_NO);
        lblResultConDrugs.setText(request.getQuestionaire().getDrugAbuseQuestionaire().isIsComDrug() ? Constant.TR_YES : Constant.TR_NO);

        lblResultPhysical.setText(request.getQuestionaire().getPhysicalQuestionaire().isIsPhysicallyActive() ? Constant.TR_YES : Constant.TR_NO);
        lblResultMedicalCondition.setText(request.getQuestionaire().getPhysicalQuestionaire().isIsMedicalCondition() ? Constant.TR_YES : Constant.TR_NO);

        lblResultCarpen.setText(request.getQuestionaire().getGuardQuestionaire().isPreviousCarpentryExperience() ? Constant.TR_YES : Constant.TR_NO);
        lblResultContruct.setText(request.getQuestionaire().getGuardQuestionaire().isPreviousConstructionExperience() ? Constant.TR_YES : Constant.TR_NO);
        lblResultGuard.setText(request.getQuestionaire().getGuardQuestionaire().isPreviousGuardExperience() ? Constant.TR_YES : Constant.TR_NO);
        lblResultTech.setText(request.getQuestionaire().getGuardQuestionaire().isPreviousTechExperience() ? Constant.TR_YES : Constant.TR_NO);
        //lblResultPhysical.setText(request.getQuestionaire().getPhysicalQuestionaire().isIsPhysicallyActive()?"Yes":"No");
        //lblResultGuard.setText(request.getQuestionaire().getGuardQuestionaire().isPreviousGuardExperience()?"Yes":"No");
    }

    private void populateTrainingCombo() {
//        availabeInstCombo.removeAllItems();
        Enterprise tm = null;
        for (Network network : business.getNetworkList()) {
            for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
                if (ent instanceof JobProviderEnterprise) {
                    tm = ent;
                    break;
                }
            }
        }
//        if(request.getQuestionaire().getTrainingQuestionaire().getInterest() != null ){
//            if(request.getQuestionaire().getTrainingQuestionaire().getInterest().equalsIgnoreCase("Carpentry"))
//            {
//                for (Organization org : tm.getOrganizationList().getOrganizationList()) {
//                 if(org instanceof CarpentryTrainingOrganization )
//                        availabeInstCombo.addItem(org);
//                    }
//            }
//            else if(request.getQuestionaire().getTrainingQuestionaire().getInterest().equalsIgnoreCase("Security"))
//            {
//                for (Organization org : tm.getOrganizationList().getOrganizationList()) {
//                 if(org instanceof SecurityTrainingOrganization )
//                        availabeInstCombo.addItem(org);
//                    }
//            }
//            else if(request.getQuestionaire().getTrainingQuestionaire().getInterest().equalsIgnoreCase("Construction"))
//            {
//                for (Organization org : tm.getOrganizationList().getOrganizationList()) {
//                 if(org instanceof ConstructionTrainingOrganization )
//                        availabeInstCombo.addItem(org);
//                    }
//            }
//            else if(request.getQuestionaire().getTrainingQuestionaire().getInterest().equalsIgnoreCase("General"))
//            {
//                for (Organization org : tm.getOrganizationList().getOrganizationList()) {
//                 if(org instanceof GeneralTrainingOrganization )
//                        availabeInstCombo.addItem(org);
//                    }
//            }
//        }
//        else
//        {

        for (Organization org : tm.getOrganizationList().getOrganizationList()) {
//                        availabeInstCombo.addItem(org);
        }

//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        assignTrainerBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        nametxt = new javax.swing.JTextField();
        tabbedComputers = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblResultComputers = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblResultConstruction = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblResultOvernight = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblResultRead = new javax.swing.JLabel();
        lblResultWrite = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblResultNesTraining = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblResultCrime = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblResultDrugs = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblResultConDrugs = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lblResultPhysical = new javax.swing.JLabel();
        lblResultMedicalCondition = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lblResultGuard = new javax.swing.JLabel();
        lblResultCarpen = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblResultTech = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblResultContruct = new javax.swing.JLabel();
        backJBtn1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        searchJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jobsTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtSize = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        loggedinLabel = new javax.swing.JLabel();
        roleLbl = new javax.swing.JLabel();
        orgLbl = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(153, 0, 51));

        assignTrainerBtn.setBackground(new java.awt.Color(51, 255, 51));
        assignTrainerBtn.setText("Assign Job");
        assignTrainerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignTrainerBtnActionPerformed(evt);
            }
        });

        jLabel8.setText("Individual Name:");

        nametxt.setEnabled(false);

        tabbedComputers.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Computers:");

        lblResultComputers.setText("jLabel5");

        jLabel10.setText("Constuction Sites:");

        lblResultConstruction.setText("jLabel5");

        jLabel12.setText("Overnight Work:");

        lblResultOvernight.setText("jLabel5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblResultComputers))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblResultConstruction)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(lblResultOvernight)))
                .addContainerGap(481, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblResultComputers))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblResultConstruction))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblResultOvernight))
                .addContainerGap())
        );

        tabbedComputers.addTab("Computers", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("Read");

        lblResultRead.setText("jLabel6");

        lblResultWrite.setText("jLabel6");

        jLabel6.setText("Write");

        lblResultNesTraining.setText("jLabel6");

        jLabel14.setText("Necessary Training:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblResultRead))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblResultWrite))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(lblResultNesTraining)))
                .addContainerGap(466, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblResultRead))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblResultWrite))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(lblResultNesTraining))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbedComputers.addTab("Education", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setText("Convited for Crime:");

        lblResultCrime.setText("jLabel9");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblResultCrime)
                .addContainerGap(475, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblResultCrime))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        tabbedComputers.addTab("Criminal", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Used Drugs:");

        lblResultDrugs.setText("jLabel9");

        jLabel9.setText("Know anyone who uses drugs:");

        lblResultConDrugs.setText("jLabel10");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblResultDrugs))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblResultConDrugs)))
                .addContainerGap(420, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblResultDrugs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblResultConDrugs))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        tabbedComputers.addTab("Drugs", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setText("Physically Active:");

        lblResultPhysical.setText("jLabel12");

        lblResultMedicalCondition.setText("jLabel12");

        jLabel15.setText("Medical Condition:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(lblResultPhysical))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblResultMedicalCondition)))
                .addContainerGap(472, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblResultPhysical))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lblResultMedicalCondition))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        tabbedComputers.addTab("Physical", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setText("Previous Guarding Experience:");

        lblResultGuard.setText("jLabel14");

        lblResultCarpen.setText("jLabel14");

        jLabel16.setText("Previous Carpentary Experience:");

        jLabel17.setText("Previous Technical Experience:");

        lblResultTech.setText("jLabel14");

        jLabel18.setText("Previous Contruction Experience:");

        lblResultContruct.setText("jLabel14");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(lblResultContruct))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblResultTech))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblResultGuard))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel16)
                            .addGap(18, 18, 18)
                            .addComponent(lblResultCarpen))))
                .addContainerGap(395, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lblResultGuard))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lblResultCarpen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lblResultTech))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(lblResultContruct))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tabbedComputers.addTab("Previous Experience", jPanel6);

        backJBtn1.setBackground(new java.awt.Color(0, 102, 255));
        backJBtn1.setText("<< Back");
        backJBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJBtn1ActionPerformed(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        searchJButton.setText("Initiate Search");
        searchJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchJButtonActionPerformed(evt);
            }
        });

        jobsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Organization Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jobsTable);

        jLabel4.setText("Vacancy:");

        txtSize.setEnabled(false);

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
        jLabel22.setText("Assign Job Work Area");

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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 424, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(assignTrainerBtn))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(searchJButton))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(tabbedComputers, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backJBtn1)))
                        .addGap(0, 0, 0)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backJBtn1)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(tabbedComputers, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addComponent(assignTrainerBtn)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void assignTrainerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignTrainerBtnActionPerformed
        // TODO add your handling code here:
//        Organization org = ( Organization) availabeInstCombo.getSelectedItem();
//        if(org != null){
//            org.getWorkQueue().getWorkRequestList().add(request);
//        }
//        if(org instanceof CarpentryTrainingOrganization){
//            
//        }
        //request.setMessage(message);
        if (!isRequested) {
            int selectedRow = jobsTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null, "Please select and organization to send the request to!!");
                return;
            }
            Organization org = (Organization) jobsTable.getValueAt(selectedRow, 0);
            //Organization org = (Organization) jobsTable.getValueAt(jobsTable.getSelectedRow(), 0);
            if (org instanceof CarpentryJobOrganization) {
                ((CarpentryJobOrganization) org).setSeats(((CarpentryJobOrganization) org).getSeats() - 1);
                txtSize.setText(String.valueOf(((CarpentryJobOrganization) org).getSeats()));
            } else if (org instanceof ConstructionJobOrganization) {
                ((ConstructionJobOrganization) org).setSeats(((ConstructionJobOrganization) org).getSeats() - 1);
                txtSize.setText(String.valueOf(((ConstructionJobOrganization) org).getSeats()));
            } else if (org instanceof SecurityJobOrganization) {
                ((SecurityJobOrganization) org).setSeats(((SecurityJobOrganization) org).getSeats() - 1);
                txtSize.setText(String.valueOf(((SecurityJobOrganization) org).getSeats()));
            } else if (org instanceof ITJobOrganization) {
                ((ITJobOrganization) org).setSeats(((ITJobOrganization) org).getSeats() - 1);
                txtSize.setText(String.valueOf(((ITJobOrganization) org).getSeats()));
            } else {
                ((GeneralJobOrganization) org).setSeats(((GeneralJobOrganization) org).getSeats() - 1);
                txtSize.setText(String.valueOf(((GeneralJobOrganization) org).getSeats()));
            }
            org.getWorkQueue().getWorkRequestList().add(request);
            UserAccount res = org.getUserAccountList().getUserAccountList().get(0);
            request.setReceiver(res);
            request.setStatus(Constant.TR_REQUESTSTATUS_ASSIGNED);
            request.setTestResult("");
            UserAccount sd = request.getSender();

            JOptionPane.showMessageDialog(null, "Job Organization assigned successfully.", "Warning", JOptionPane.INFORMATION_MESSAGE);
            isRequested = true;
        } else {
            JOptionPane.showMessageDialog(null, "Request already forwarded.", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_assignTrainerBtnActionPerformed

    private void backJBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJBtn1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ProcessJobRequestJPanel sysAdminwjp = (ProcessJobRequestJPanel) component;
        sysAdminwjp.populateRequestTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJBtn1ActionPerformed

    private void searchJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchJButtonActionPerformed
        assignTrainerBtn.setEnabled(false);
        assignTrainerBtn.setVisible(false);
        // TODO add your handling code here:
        new SwingWorker() {

            @Override
            protected Object doInBackground() throws Exception {

                Enterprise tm = null;
                for (Network network : business.getNetworkList()) {
                    if (network.getName().equalsIgnoreCase(enterprise.getNetworkName())) {
                        for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
                            if (ent instanceof JobProviderEnterprise) {
                                tm = ent;
                                break;
                            }
                        }
                    }
                }
                DefaultTableModel dtm = (DefaultTableModel) jobsTable.getModel();

                Questionnaire qus = request.getQuestionaire();
                textArea.append("Knows how to use Computer?\n");

                Thread.sleep(2000);

                if (qus.getJobQuestionaire().isIsComputer()) {
                    for (Organization org : tm.getOrganizationList().getOrganizationList()) {
                        if (org instanceof ITJobOrganization) {
                            Object row[] = new Object[1];
                            row[0] = org;
                            dtm.addRow(row);
                        }
                    }

                    textArea.append("Yes\n");

                } else {
                    textArea.append("No\n");

                }
                Thread.sleep(2000);
                textArea.append("Knows how to read and write?\n");
                Thread.sleep(2000);
                if (qus.getEducationQuestionaire().isIsRead() && qus.getEducationQuestionaire().isIsWrite()) {
                    for (Organization org : tm.getOrganizationList().getOrganizationList()) {
                        if (org instanceof GeneralJobOrganization) {
                            Object row[] = new Object[1];
                            row[0] = org;
                            dtm.addRow(row);
                        }
                    }

                    textArea.append("Yes\n");

                } else {
                    textArea.append("No\n");

                }

                Thread.sleep(2000);
                textArea.append("Is Physically strong and active?\n");
                Thread.sleep(2000);
                if (qus.getEducationQuestionaire().isIsRead() && qus.getEducationQuestionaire().isIsWrite()) {
                    for (Organization org : tm.getOrganizationList().getOrganizationList()) {
                        if (org instanceof ConstructionJobOrganization || org instanceof CarpentryJobOrganization) {
                            Object row[] = new Object[1];
                            row[0] = org;
                            dtm.addRow(row);
                        }
                    }

                    textArea.append("Yes\n");

                } else {
                    textArea.append("No\n");

                }

                Thread.sleep(2000);
                textArea.append("Previous experience as a Guard?\n");
                Thread.sleep(2000);
                if (qus.getEducationQuestionaire().isIsRead() && qus.getEducationQuestionaire().isIsWrite()) {
                    for (Organization org : tm.getOrganizationList().getOrganizationList()) {
                        if (org instanceof SecurityJobOrganization) {
                            Object row[] = new Object[1];
                            row[0] = org;
                            dtm.addRow(row);
                        }
                    }

                    textArea.append("Yes\n");

                } else {
                    textArea.append("No\n");

                }
                Thread.sleep(2000);
                textArea.append("Job Search Completed!!");
                assignTrainerBtn.setEnabled(true);
                assignTrainerBtn.setVisible(true);
                JOptionPane.showMessageDialog(null, "Job search has been completed. Please select the best job for the individual!!");
                return null;
            }
        }.execute();

    }//GEN-LAST:event_searchJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignTrainerBtn;
    private javax.swing.JButton backJBtn1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jobsTable;
    private javax.swing.JLabel lblResultCarpen;
    private javax.swing.JLabel lblResultComputers;
    private javax.swing.JLabel lblResultConDrugs;
    private javax.swing.JLabel lblResultConstruction;
    private javax.swing.JLabel lblResultContruct;
    private javax.swing.JLabel lblResultCrime;
    private javax.swing.JLabel lblResultDrugs;
    private javax.swing.JLabel lblResultGuard;
    private javax.swing.JLabel lblResultMedicalCondition;
    private javax.swing.JLabel lblResultNesTraining;
    private javax.swing.JLabel lblResultOvernight;
    private javax.swing.JLabel lblResultPhysical;
    private javax.swing.JLabel lblResultRead;
    private javax.swing.JLabel lblResultTech;
    private javax.swing.JLabel lblResultWrite;
    private javax.swing.JLabel loggedinLabel;
    private javax.swing.JTextField nametxt;
    private javax.swing.JLabel orgLbl;
    private javax.swing.JLabel roleLbl;
    private javax.swing.JButton searchJButton;
    private javax.swing.JTabbedPane tabbedComputers;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextField txtSize;
    // End of variables declaration//GEN-END:variables

}
