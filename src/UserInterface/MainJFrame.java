/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterpise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 *
 * @author Rahul Zore
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    private EcoSystem system;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    
    public MainJFrame() {
        initComponents();
        system = dB4OUtil.retrieveSystem();
        //logoutJButton.setEnabled(false);
          
        //createMenuBar();
        createEcosystemMenu();
        setTitle("Simple menu");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            setBounds(0,0,screenSize.width-50, screenSize.height-50);
         //ma.setIconImage(img.getImage());
    }
    
//    private void createMenuBar() {
//
//        
//        
//        ImageIcon icon1 = new ImageIcon("src\\Resource\\login.png");
//        Image image1 = icon1.getImage(); // transform it 
//        Image newimg1 = image1.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
//        icon1 = new ImageIcon(newimg1);
//        
//        JMenuItem eMenuItem1 = new JMenuItem("Login", icon1);
//        eMenuItem1.setMnemonic(KeyEvent.VK_L);
//        eMenuItem1.setToolTipText("Login application");
//        eMenuItem1.addActionListener((ActionEvent event) -> {
//            LoginPageJPanel panel = new LoginPageJPanel(userProcessContainer, system,"");
//        
//        userProcessContainer.add("LoginPageJPanel",panel);
//        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
//        layout.next(userProcessContainer);
//        loginBtn.setEnabled(false);
//        btnLogout.setEnabled(true);
//        });
//        JMenu file = new JMenu("File");
//        file.setMnemonic(KeyEvent.VK_F);
//        
//        file.add(eMenuItem1);
//
//        menubar.add(file);
//        ImageIcon icon2 = new ImageIcon("src\\Resource\\exit.jpg");
//        Image image = icon2.getImage(); // transform it 
//        Image newimg = image.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
//        icon2 = new ImageIcon(newimg);
//        
//        JMenuItem eMenuItem2 = new JMenuItem("Exit", icon2);
//        eMenuItem2.setMnemonic(KeyEvent.VK_E);
//        eMenuItem2.setToolTipText("Exit application");
//        eMenuItem2.addActionListener((ActionEvent event) -> {
//            System.exit(0);
//        });
//        file.add(eMenuItem2);
//        menubar.add(file);
//        setJMenuBar(menubar);
//    }
//    
    private void createEcosystemMenu(){
        JMenuBar menubar = null;
        menubar = new JMenuBar();
        JMenu menu=new JMenu("Ecosytem");
        JMenu submenu=null;
        menu.setMnemonic(KeyEvent.VK_E);
        //UserAccount userAccount = system.getUserAccountList().authenticateUser(userName, password);
        int UserCount =0;
        Enterprise inEnterprise = null;
        Organization inOrganization = null;
        for (Network network : system.getNetworkList()) {
                //Step 2-a: Check against each enterprise
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    UserCount = enterprise.getUserAccountList().getUserAccountList().size();
                    
                    if (UserCount > 0) {
                        ImageIcon icon1 = new ImageIcon("src\\Resource\\login.png");
                        Image image1 = icon1.getImage(); // transform it 
                        Image newimg1 = image1.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                        icon1 = new ImageIcon(newimg1);
                           
                        JMenu eMenuIt = new JMenu(enterprise.getName());
                        
                        eMenuIt.setMnemonic(KeyEvent.VK_L);
                        eMenuIt.setToolTipText(enterprise.getName());
                        eMenuIt.addMenuListener(new SampleMenuListener(userProcessContainer,system,enterprise));
//                        eMenuIt.addActionListener(new ActionListener() 
//                        {
//                            @Override
//                            public void actionPerformed(ActionEvent e)
//                            {
//                                //Execute when JMenu is pressed
//                                LoginPageJPanel panel = new LoginPageJPanel(userProcessContainer, system,enterprise.getName());
//                                System.out.println("Hi");
//                                userProcessContainer.add("LoginPageJPanel",panel);
//                                CardLayout layout=(CardLayout)userProcessContainer.getLayout();
//                                layout.next(userProcessContainer);
//                                loginBtn.setEnabled(false);
//                                btnLogout.setEnabled(true);
//                            }
//                        });
                        menu.add(eMenuIt);
                        menubar.add(menu);
                        //Step3: Check against each organization inside that enterprise
                        for (Organization organization : enterprise.getOrganizationList().getOrganizationList()) {
                            UserCount = organization.getUserAccountList().getUserAccountList().size();
                            if (UserCount > 0) {
                                
                                submenu = new JMenu("A submenu");
                                JMenuItem eMenuItem2 = new JMenuItem(organization.getName(), icon1);
                                menu.add(eMenuItem2);
                                eMenuIt.add(eMenuItem2);
                                 eMenuItem2.setMnemonic(KeyEvent.VK_L);
                                eMenuItem2.setToolTipText(organization.getName());
                                eMenuItem2.addActionListener((ActionEvent event) -> {
                                LoginPageJPanel panel = new LoginPageJPanel(userProcessContainer, system,organization.getUserAccountList().getUserAccountList().get(0).getUserID());

                                userProcessContainer.add("LoginPageJPanel",panel);
                                CardLayout layout=(CardLayout)userProcessContainer.getLayout();
                                layout.next(userProcessContainer);
                                loginBtn.setEnabled(false);
                                btnLogout.setEnabled(true);

                                });
                                //menu.add(eMenuItem2);
                                menubar.add(menu);
                                        //submenu.setMnemonic(KeyEvent.VK_S);
                                        inEnterprise = enterprise;
                                        inOrganization = organization;
                                        //break;
                                    }
                                }
                    } else {
                        inEnterprise = enterprise;
                        if ( Enterprise.EnterpriseType.JobProcessManager.equals(enterprise.getEnterpriseType())){
                            for (Organization organization : enterprise.getOrganizationList().getOrganizationList()) {
                                if(Organization.Type.JobProcessManager.getValue().equalsIgnoreCase(organization.getName())){
                                    inOrganization = organization;
                                    //break;
                                }

                            }
                        }
                        else if ( Enterprise.EnterpriseType.TrainingProcessManager.equals(enterprise.getEnterpriseType())){
                            for (Organization organization : enterprise.getOrganizationList().getOrganizationList()) {
                                if(Organization.Type.TrainingProcessManager.getValue().equalsIgnoreCase(organization.getName())){
                                    inOrganization = organization;
                                    //break;
                                }

                            }
                        }
                        //break;
                    }
                   
                }
               
            }
        menubar.add(menu);
        //menu.addSeparator();
        //menubar.add(menu);
        setJMenuBar(menubar);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SplitPane = new javax.swing.JSplitPane();
        loginPanel = new javax.swing.JPanel();
        loginBtn = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        userProcessContainer = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Poverty Alleviation System");

        loginPanel.setBackground(new java.awt.Color(255, 255, 255));

        loginBtn.setBackground(new java.awt.Color(51, 255, 51));
        loginBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        btnLogout.setBackground(new java.awt.Color(255, 0, 0));
        btnLogout.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.setEnabled(false);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                .addContainerGap())
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(loginBtn)
                .addGap(18, 18, 18)
                .addComponent(btnLogout)
                .addContainerGap(461, Short.MAX_VALUE))
        );

        SplitPane.setLeftComponent(loginPanel);

        userProcessContainer.setLayout(new java.awt.CardLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Poverty Alleviation System");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(173, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(152, 152, 152))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addContainerGap(231, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        userProcessContainer.add(jPanel1, "card2");

        SplitPane.setRightComponent(userProcessContainer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SplitPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SplitPane, javax.swing.GroupLayout.PREFERRED_SIZE, 755, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        // TODO add your handling code here:
        LoginPageJPanel panel = new LoginPageJPanel(userProcessContainer, system,"");
        
        userProcessContainer.add("LoginPageJPanel",panel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        loginBtn.setEnabled(false);
        btnLogout.setEnabled(true);
    }//GEN-LAST:event_loginBtnActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
//        Component[] components = userProcessContainer.getComponents();
//        int a=userProcessContainer.countComponents();
//        for(int i = 0; i < components.length; i++) {
//            if(a> 0){
//                userProcessContainer.remove(0);
//                --a;
//            }
//            //        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
//            //        layout.removeLayoutComponent(components[i]);
//
//        }
        userProcessContainer.removeAll();
        WelcomePanel panel = new WelcomePanel();
        userProcessContainer.add(panel);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        loginBtn.setEnabled(true);
        btnLogout.setEnabled(false);
        //createMenuBar();
        createEcosystemMenu();
        dB4OUtil.storeSystem(system);
        //toggleLogin(false);
    }//GEN-LAST:event_btnLogoutActionPerformed

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
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSplitPane SplitPane;
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPanel userProcessContainer;
    // End of variables declaration//GEN-END:variables
}

class SampleMenuListener implements MenuListener {
    JPanel userProcessContainer;
UserAccount userAccount;
Organization organization;
Enterprise enterprise;
    EcoSystem system;
    SampleMenuListener(JPanel userProcessContainer, EcoSystem system, Enterprise enterprise)
    {
         this.userProcessContainer = userProcessContainer;
        this.system = system; 
        this.enterprise = enterprise;
    }
    @Override
    public void menuSelected(MenuEvent e) {
        LoginPageJPanel panel = new LoginPageJPanel(userProcessContainer, system,enterprise.getName());

                                userProcessContainer.add("LoginPageJPanel",panel);
                                CardLayout layout=(CardLayout)userProcessContainer.getLayout();
                                layout.next(userProcessContainer);
                                //loginBtn.setEnabled(false);
                                //btnLogout.setEnabled(true)
        //System.out.println("menuSelected");
    }

    @Override
    public void menuDeselected(MenuEvent e) {
        //System.out.println("menuDeselected");
    }

    @Override
    public void menuCanceled(MenuEvent e) {
        //System.out.println("menuCanceled");
    }

}
