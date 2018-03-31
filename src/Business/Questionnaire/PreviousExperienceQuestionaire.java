/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Questionnaire;

/**
 *
 * @author Rahul Zore
 */
public class PreviousExperienceQuestionaire {
    private boolean previousGuardExperience;
    private boolean previousConstructionExperience;
    private boolean previousTechExperience;
    private boolean previousCarpentryExperience;

    public boolean isPreviousConstructionExperience() {
        return previousConstructionExperience;
    }

    public void setPreviousConstructionExperience(boolean previousConstructionExperience) {
        this.previousConstructionExperience = previousConstructionExperience;
    }

    public boolean isPreviousTechExperience() {
        return previousTechExperience;
    }

    public void setPreviousTechExperience(boolean previousTechExperience) {
        this.previousTechExperience = previousTechExperience;
    }

    public boolean isPreviousCarpentryExperience() {
        return previousCarpentryExperience;
    }

    public void setPreviousCarpentryExperience(boolean previousCarpentryExperience) {
        this.previousCarpentryExperience = previousCarpentryExperience;
    }
    
    
    

    public boolean isPreviousGuardExperience() {
        return previousGuardExperience;
    }

    public void setPreviousGuardExperience(boolean previousGuardExperience) {
        this.previousGuardExperience = previousGuardExperience;
    }
    
    
}
