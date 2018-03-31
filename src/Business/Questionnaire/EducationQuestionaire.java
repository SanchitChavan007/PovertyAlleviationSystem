/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Questionnaire;

/**
 *
 * @author Nishad
 */
public class EducationQuestionaire {
     private boolean isRead;
    private boolean isWrite;
    private boolean isNecessaryTraining;

    public boolean isIsNecessaryTraining() {
        return isNecessaryTraining;
    }

    public void setIsNecessaryTraining(boolean isNecessaryTraining) {
        this.isNecessaryTraining = isNecessaryTraining;
    }
    private String basicEducation;

    public boolean isIsRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

    public boolean isIsWrite() {
        return isWrite;
    }

    public void setIsWrite(boolean isWrite) {
        this.isWrite = isWrite;
    }

    public String getBasicEducation() {
        return basicEducation;
    }

    public void setBasicEducation(String basicEducation) {
        this.basicEducation = basicEducation;
    }
    
}
