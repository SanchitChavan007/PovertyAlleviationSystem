/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterpise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.CuratorOrganization.DataCollectorRole.DataCollectorWorkAreaJPanel;
import UserInterface.CuratorOrganization.JobManagerRole.JobRequestManagerWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Rahul Zore
 */
public class JobRequestManagerRole extends Role{

    @Override
    public JPanel createWorkPanel(JPanel userProcessContainer, UserAccount userAccount, Organization organization, Enterprise enterprise, EcoSystem ecoSystem) {
        return new JobRequestManagerWorkAreaJPanel(userProcessContainer,userAccount,organization,enterprise,ecoSystem);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
