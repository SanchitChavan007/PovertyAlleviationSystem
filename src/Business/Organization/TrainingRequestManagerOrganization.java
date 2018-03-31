/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.TrainingRequestManagerRole;
import java.util.ArrayList;

/**
 *
 * @author Rahul Zore
 */
public class TrainingRequestManagerOrganization extends Organization {

    public TrainingRequestManagerOrganization(String name) {
        super(name,"");
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new TrainingRequestManagerRole());
        return roles;
    }

}
