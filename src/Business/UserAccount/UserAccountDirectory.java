/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import com.db4o.collections.ActivatableArrayList;
import java.util.ArrayList;

/**
 *
 * @author Rahul Zore
 */
public class UserAccountDirectory {


    private ArrayList<UserAccount> userAccountList;
    
    public UserAccountDirectory(){
        userAccountList = new ArrayList<>();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }

    public void setUserAccountList(ArrayList<UserAccount> userAccountList) {
        this.userAccountList = userAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password){
        for(UserAccount ua : userAccountList){
            if(ua.getUserID().equals(username) && ua.getUserPWD().equals(password)){
                return ua;
            }
        }
        return null;
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        for (UserAccount ua : userAccountList){
            if (ua.getUserID().equals(username))
                return false;
        }
        return true;
    }
    
     public UserAccount createUserAccount(String username, String password, Employee employee, Role role) {
         UserAccount userAccount=null;
         if(checkIfUsernameIsUnique(username)){
             
         userAccount= new UserAccount();
        userAccount.setUserID(username);
        userAccount.setUserPWD(password);
        userAccount.setEmployee(employee);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
         }
        return userAccount;
    }
}
