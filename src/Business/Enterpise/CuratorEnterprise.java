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
public class CuratorEnterprise extends Enterprise {

    CuratorEnterprise(String name, String networkName) {
        super(name, EnterpriseType.Curator, networkName);
    }

    public enum CuratorType {
        DataCollector("Data Collector Organization"),
        JobManager("Job Manager Organization"),
        TrainingManager("Training Manager Organization");

        private String value;

        private CuratorType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
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
