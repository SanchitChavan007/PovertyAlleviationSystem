/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Questionnaire;

import java.util.ArrayList;

/**
 *
 * @author sanch
 */
public class QuestionnaireDirectory {
    private ArrayList<Questionnaire> questioannaireList;

    public ArrayList<Questionnaire> getQuestioannaireList() {
        return questioannaireList;
    }

    public void setQuestioannaireList(ArrayList<Questionnaire> questioannaireList) {
        this.questioannaireList = questioannaireList;
    }

    public QuestionnaireDirectory() {
        
        questioannaireList = new ArrayList<>();
    }
    
    public Questionnaire addQuestionnaire(){
        Questionnaire questionnaire = new Questionnaire();
        questioannaireList.add(questionnaire);
        return questionnaire;
    }
}
