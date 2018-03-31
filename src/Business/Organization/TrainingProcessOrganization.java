/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.JobProcessManagerRole;
import Business.Role.Role;
import Business.Role.TrainingProcessManagerRole;

import java.util.ArrayList;

/**
 *
 * @author sanch
 */
public class TrainingProcessOrganization extends Organization {

    public TrainingProcessOrganization(String name) {
        super(name,"");
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
      ArrayList<Role> roles = new ArrayList<Role>();
      roles.add(new TrainingProcessManagerRole());
      return roles;
     
    }
    
}
