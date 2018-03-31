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
public class JobProviderEnterprise extends Enterprise{

    JobProviderEnterprise(String name, String networkName) {
        super(name,EnterpriseType.JobProvider, networkName);
    }
    public enum JobProviderType{
        Carpentry("Carpentry"),
        Security("Security"),
        Construction("Construction"),
        General("General"),
        IT("IT");
        
        private String value;
        
        private JobProviderType(String value){
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
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
