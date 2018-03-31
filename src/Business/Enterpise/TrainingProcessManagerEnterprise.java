/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterpise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author sanch
 */
public class TrainingProcessManagerEnterprise extends Enterprise{

    public TrainingProcessManagerEnterprise(String name, String networkName) {
        super(name, EnterpriseType.TrainingProcessManager,networkName);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
return null;
    }
    
}
