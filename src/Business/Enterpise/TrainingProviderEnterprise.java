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
public class TrainingProviderEnterprise extends Enterprise{

    public TrainingProviderEnterprise(String name, String networkName) {
        super(name, EnterpriseType.TrainingProvider,networkName);
    }

    public enum TrainingProviderType{
        Carpentry("Carpentry"),
        Security("Security"),
        Construction("Construction"),
        General("General");
        
        private String value;
        
        private TrainingProviderType(String value){
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
    }
    
}
