/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.NGO;

import Business.Organization.Organization;
import Business.Role.NGORole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Rahul Zore
 */
public class ChildrenNGOOrganization extends Organization{

    public ChildrenNGOOrganization(String name) {
        super(name, "");
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roles = new ArrayList<>();
       roles.add(new NGORole());
       return roles;
    }
    
}
