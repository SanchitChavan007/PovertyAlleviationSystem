/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterpise;

import java.util.ArrayList;

/**
 *
 * @author Rahul Zore
 */
public class EnterpriseDirectory {

    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type, String networkName) {
        Enterprise enterprise = null;

        if (type == Enterprise.EnterpriseType.Curator) {
            enterprise = new CuratorEnterprise(name, networkName);
            enterpriseList.add(enterprise);            
        }
        else if (type == Enterprise.EnterpriseType.JobProvider){
            enterprise = new JobProviderEnterprise(name, networkName);
            enterpriseList.add(enterprise);
        }
        else if (type == Enterprise.EnterpriseType.JobProcessManager){
            enterprise = new JobProcessManagerEnterprise(name, networkName);
            enterpriseList.add(enterprise);
        }
		 else if (type == Enterprise.EnterpriseType.Restaurant){
            enterprise = new RestaurantEnterprise(name, networkName);
            enterpriseList.add(enterprise);
        }
        else if (type == Enterprise.EnterpriseType.NGO){
            enterprise = new NGOEnterprise(name, networkName);
            enterpriseList.add(enterprise);
        }
         else if (type == Enterprise.EnterpriseType.TrainingProcessManager){
            enterprise = new TrainingProcessManagerEnterprise(name, networkName);
            enterpriseList.add(enterprise);
        }
         else if (type == Enterprise.EnterpriseType.TrainingProvider){
            enterprise = new TrainingProviderEnterprise(name, networkName);
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }
}