/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterpise;

import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;

/**
 *
 * @author Rahul Zore
 */
public abstract class Enterprise extends Organization {

    private OrganizationDirectory organizationList;
    private EnterpriseType enterpriseType;

    public Enterprise(String name, EnterpriseType type,String networkName) {
        super(name,networkName);
        this.enterpriseType = type;
        organizationList = new OrganizationDirectory();
    }

    public enum EnterpriseType {

        Curator("Curator"),
        JobProvider("Job Provider"),
        JobProcessManager("Job Process Manager"),
        TrainingProcessManager("Training Process Manager"),
        TrainingProvider("Training Provider"),
	Restaurant("Restaurant"),
        NGO("NGO");

        private String value;

        private EnterpriseType(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }

    public OrganizationDirectory getOrganizationList() {
        return organizationList;
    }
    
   
    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    @Override
    public String toString(){
       return this.getName();
    }
}
