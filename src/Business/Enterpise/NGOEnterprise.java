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
public class NGOEnterprise extends Enterprise{



    /**
     *
     * @param name
     * @param networkName
     */

    public NGOEnterprise(String name, String networkName) {
        super(name, EnterpriseType.NGO, networkName);
    }
    
    public enum NGOType{
        OldAge("Old Age NGO"),
        RaceBased("Race Based NGO"),
        Childern("Children NGO"),
        Homeless("Homeless NGO");
        
        private String value;
        
        private NGOType(String value){
            this.value = value;
        }
        
        @Override
        public String toString(){
            return this.value;
        }

        public String getValue() {
            return value;
        }
        
        
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
