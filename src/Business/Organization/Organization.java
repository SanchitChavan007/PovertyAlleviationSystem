/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author Rahul Zore
 */
public abstract class Organization {
    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeList;
    private UserAccountDirectory userAccountList;
    private int organizationID;
    private static int counter;
    private String networkName;
    private Type type;
    private JobProviderType jobProviderType;
    
    public Organization(String name, String networkName){
        counter++;
        organizationID = counter;
        workQueue = new WorkQueue();
        employeeList = new EmployeeDirectory();
        userAccountList = new UserAccountDirectory();
        this.name = name;
        this.networkName = networkName;
    }

    public String getNetworkName() {
        return networkName;
    }

       
    public enum Type{
        Admin("Admin Organiztion"),
        DataCollector("Data Collector Organization"),
        JobProcessManager("Job Process Manager Organization"),
        JobManager("Job Manager Organization"),
        TrainingManager("Training Manager Organization"),
        TrainingProvider("Training Provider Organization"),
        TrainingProcessManager("Training Process Manager Organization"),
        JobProvider("Job Provider Organization"),
        Restaurant("Restaurant Organization"),
        OldAge("Old Age NGO"),
        RaceBased("Race Based NGO"),
        Childern("Children NGO"),
        Homeless("Homeless NGO"),
        Carpentry("Carpentry"),
        Security("Security"),
        Construction("Construction"),
        General("General");
        
        private String value;
        
        private Type(String value){
            this.value = value;
        }
        
        public String getValue(){
            return value;
        }
        
        @Override
        public String toString(){
            return value;
        }
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
        
        public String getValue(){
            return value;
        }
        
        @Override
        public String toString(){
            return value;
        }
    }
    public abstract ArrayList<Role> getSupportedRole();

    public String getName() {
        return name;
    }

    public JobProviderType getJobProviderType() {
        return jobProviderType;
    }
    
    public Type getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public EmployeeDirectory getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(EmployeeDirectory employeeList) {
        this.employeeList = employeeList;
    }

    public UserAccountDirectory getUserAccountList() {
        return userAccountList;
    }

    public void setUserAccountList(UserAccountDirectory userAccountList) {
        this.userAccountList = userAccountList;
    }

    public int getOrganizationID() {
        return organizationID;
    }
    
    @Override
    public String toString(){
        return name;
    }
    
    
}
