/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Network.Network;
import Business.Organization.Organization;
import Business.Questionnaire.QuestionnaireDirectory;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.nio.channels.NetworkChannel;
import java.util.ArrayList;

/**
 *
 * @author Rahul Zore
 */
public class EcoSystem extends Organization{

    private static EcoSystem business;
    private ArrayList<Network> networkList;
    private QuestionnaireDirectory questionnaireList;
    
    public static EcoSystem getInstance() {
        
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }
    
    private EcoSystem(){
        super(null,"");
        networkList = new ArrayList<>();
        questionnaireList = new QuestionnaireDirectory();
            
    }

    public QuestionnaireDirectory getQuestionnaireList() {
        return questionnaireList;
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public Network createAndAddNetwork() {
        Network network = new Network();
        networkList.add(network);
        return network;
    }
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
}
