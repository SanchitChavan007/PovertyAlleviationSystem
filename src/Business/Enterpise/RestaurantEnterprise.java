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
 * @author Rahul Zore
 */
public class RestaurantEnterprise extends Enterprise {

    public RestaurantEnterprise(String name, String networkName) {
        super(name, EnterpriseType.Restaurant, networkName);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
