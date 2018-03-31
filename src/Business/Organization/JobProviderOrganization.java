/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.Role.JobProviderRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Rahul Zore
 */
public class JobProviderOrganization extends Organization{

    public JobProviderOrganization(String name) {
        super(name,"");
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
       roles.add(new JobProviderRole());
       return roles;
    }
    
}
