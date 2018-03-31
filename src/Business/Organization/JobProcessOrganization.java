/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.JobProcessManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Nishad
 */
public class JobProcessOrganization extends Organization {

    public JobProcessOrganization(String name) {
        super(Organization.Type.JobProcessManager.getValue(),"");
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roles = new ArrayList<>();
       roles.add(new JobProcessManagerRole());
       return roles;
    }
    
}
