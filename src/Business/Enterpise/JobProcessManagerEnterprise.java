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
 * @author Nishad
 */
public class JobProcessManagerEnterprise extends Enterprise {
   
    public JobProcessManagerEnterprise(String name,String NetworkName) {
        super(name, EnterpriseType.JobProcessManager,NetworkName);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
} 

