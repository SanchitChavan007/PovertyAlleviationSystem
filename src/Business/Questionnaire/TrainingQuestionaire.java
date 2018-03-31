/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Questionnaire;

/**
 *
 * @author sanch
 */
public class TrainingQuestionaire {
    
    private boolean Trained;
    private boolean Disabled;
    private boolean specificInterest;
    private String trainingField;
    private String disability;
    private String interest;
    private String trainingDuration;


    public boolean isTrained() {
        return Trained;
    }

    public void setTrained(boolean Trained) {
        this.Trained = Trained;
    }

    public boolean isDisabled() {
        return Disabled;
    }

    public void setDisabled(boolean Disabled) {
        this.Disabled = Disabled;
    }

    public boolean isSpecificInterest() {
        return specificInterest;
    }

    public void setSpecificInterest(boolean specificInterest) {
        this.specificInterest = specificInterest;
    }

    public String getTrainingField() {
        return trainingField;
    }

    public void setTrainingField(String trainingField) {
        this.trainingField = trainingField;
    }

    public String getDisability() {
        return disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getTrainingDuration() {
        return trainingDuration;
    }

    public void setTrainingDuration(String trainingDuration) {
        this.trainingDuration = trainingDuration;
    }

  

    
}
