/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Questionnaire.Questionnaire;
import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author Rahul Zore
 */
public abstract class WorkRequest {
    
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    private Questionnaire questionaire;
    private static int counter=0;
    private int requestID;
    public WorkRequest(){
        requestDate = new Date();
         ++counter;
        requestID = counter;
    }

    public int getRequestID() {
        return requestID;
    }


    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public Questionnaire getQuestionaire() {
        return questionaire;
    }

    public void setQuestionaire(Questionnaire questionaire) {
        this.questionaire = questionaire;
    }
    
    @Override
    public String toString() {
        return String .valueOf(this.requestID);
    }
}
