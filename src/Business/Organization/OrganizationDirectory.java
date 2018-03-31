/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.JobProvider.CarpentryJobOrganization;
import Business.Organization.JobProvider.ConstructionJobOrganization;
import Business.Organization.JobProvider.GeneralJobOrganization;
import Business.Organization.JobProvider.ITJobOrganization;
import Business.Organization.JobProvider.SecurityJobOrganization;
import Business.Organization.NGO.ChildrenNGOOrganization;
import Business.Organization.NGO.HomelessNGOOrganization;
import Business.Organization.NGO.OldAgeNGOOrganization;
import Business.Organization.NGO.RaceNGOOrganization;
import Business.Organization.TrainingProvider.CarpentryTrainingOrganization;
import Business.Organization.TrainingProvider.ConstructionTrainingOrganization;
//import Business.Organization.TrainingProvider.CossssnstructionTrainingOrganization;
import Business.Organization.TrainingProvider.GeneralTrainingOrganization;
import Business.Organization.TrainingProvider.SecurityTrainingOrganization;
import com.db4o.collections.ActivatableArrayList;
import java.util.ArrayList;

/**
 *
 * @author Rahul Zore
 */
public class OrganizationDirectory {
    private ArrayList<Organization> organizationList;
    
    public OrganizationDirectory(){
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(ArrayList<Organization> organizationList) {
        this.organizationList = organizationList;
    }
    
     public Organization createOrganization(Organization.Type type,Organization.JobProviderType ty,String name){
        Organization organization = null;
        if(type != null){
        if (type.getValue().equals(Organization.Type.DataCollector.getValue())){
            organization = new DataCollectorOrganization(name);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.JobProvider.getValue())){
            organization = new JobProviderOrganization(name);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.JobManager.getValue())){
            organization = new JobRequestManagerOrganization(name);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.JobProcessManager.getValue())){
            organization = new JobProcessOrganization(name);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.TrainingManager.getValue())){
            organization = new TrainingRequestManagerOrganization(name);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Restaurant.getValue())){
            organization = new RestaurantOrganization(name);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.OldAge.getValue())){
            organization = new OldAgeNGOOrganization(name);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.RaceBased.getValue())){
            organization = new RaceNGOOrganization(name);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Childern.getValue())){
            organization = new ChildrenNGOOrganization(name);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Homeless.getValue())){
            organization = new HomelessNGOOrganization(name);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.TrainingProcessManager.getValue())){
            organization = new TrainingProcessOrganization(Organization.Type.TrainingProcessManager.getValue());
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.TrainingProvider.getValue())){
            organization = new TrainingProviderOrganization(name);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Carpentry.getValue())){
            organization = new CarpentryTrainingOrganization(name);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Construction.getValue())){
            organization = new ConstructionTrainingOrganization(name);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Security.getValue())){
            organization = new SecurityTrainingOrganization(name);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.General.getValue())){
            organization = new GeneralTrainingOrganization(name);
            organizationList.add(organization);
        }
        }
        else
        {
            if (ty.getValue().equals(Organization.JobProviderType.Carpentry.getValue())){
            organization = new CarpentryJobOrganization(name);
            organizationList.add(organization);
        }
        else if (ty.getValue().equals(Organization.JobProviderType.Construction.getValue())){
            organization = new ConstructionJobOrganization(name);
            organizationList.add(organization);
        }
        else if (ty.getValue().equals(Organization.JobProviderType.Security.getValue())){
            organization = new SecurityJobOrganization(name);
            organizationList.add(organization);
        }
        else if (ty.getValue().equals(Organization.JobProviderType.General.getValue())){
            organization = new GeneralJobOrganization(name);
            organizationList.add(organization);
        }
            else if (ty.getValue().equals(Organization.JobProviderType.IT.getValue())){
            organization = new ITJobOrganization(name);
            organizationList.add(organization);
        }
        }
        
        return organization;
    }
     public Organization createOrganization(Organization.Type type,Organization.JobProviderType ty,String name,int Size){
         Organization organization = null;
         if(type != null){
            if (type.getValue().equals(Organization.Type.Carpentry.getValue())){
            organization = new CarpentryTrainingOrganization(name);
            ((CarpentryTrainingOrganization)organization).setSeats(Size);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Construction.getValue())){
            organization = new ConstructionTrainingOrganization(name);
            ((ConstructionTrainingOrganization)organization).setSeats(Size);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Security.getValue())){
            organization = new SecurityTrainingOrganization(name);
            ((SecurityTrainingOrganization)organization).setSeats(Size);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.General.getValue())){
            organization = new GeneralTrainingOrganization(name);
            ((GeneralTrainingOrganization)organization).setSeats(Size);
            organizationList.add(organization);
        }
         }
         else
         {
              if (ty.getValue().equals(Organization.JobProviderType.Carpentry.getValue())){
            organization = new CarpentryJobOrganization(name);
            ((CarpentryJobOrganization)organization).setSeats(Size);
            organizationList.add(organization);
        }
        else if (ty.getValue().equals(Organization.JobProviderType.Construction.getValue())){
            organization = new ConstructionJobOrganization(name);
            ((ConstructionJobOrganization)organization).setSeats(Size);
            organizationList.add(organization);
        }
        else if (ty.getValue().equals(Organization.JobProviderType.Security.getValue())){
            organization = new SecurityJobOrganization(name);
            ((SecurityJobOrganization)organization).setSeats(Size);
            organizationList.add(organization);
        }
        else if (ty.getValue().equals(Organization.JobProviderType.General.getValue())){
            organization = new GeneralJobOrganization(name);
            ((GeneralJobOrganization)organization).setSeats(Size);
            organizationList.add(organization);
        }
            else if (ty.getValue().equals(Organization.JobProviderType.IT.getValue())){
            organization = new ITJobOrganization(name);
            ((ITJobOrganization)organization).setSeats(Size);
            organizationList.add(organization);
         }
         
     }
         return organization;
     }
}
