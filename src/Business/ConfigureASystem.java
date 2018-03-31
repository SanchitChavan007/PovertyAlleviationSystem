/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Employee.Employee;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author Rahul Zore
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        EcoSystem system = EcoSystem.getInstance();
        
        Employee employee = system.getEmployeeList().createEmployee("Fanqi");
        UserAccount ua = system.getUserAccountList().createUserAccount("a1", "a1", employee, new SystemAdminRole());
        return system;
    }
}
