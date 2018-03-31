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
public class Questionnaire {
    private boolean isDetailsSet;
    private PersonalQuestionnaire personalQuestionnaire;
    private CriminalRelatedQuestionaire criminalRelatedQuestionaire;
    private DrugAbuseQuestionaire drugAbuseQuestionaire;
    private EducationQuestionaire educationQuestionaire;
    private FamilyBackgroundQuestionaire familyBackgroundQuestionaire;
    private JobQuestionaire jobQuestionaire;
    private TrainingQuestionaire trainingQuestionaire;
    private PhysicalQuestionaire physicalQuestionaire;
    private PreviousExperienceQuestionaire guardQuestionaire;
    
    public Questionnaire(){
        personalQuestionnaire = new PersonalQuestionnaire();
        criminalRelatedQuestionaire = new CriminalRelatedQuestionaire();
        drugAbuseQuestionaire = new DrugAbuseQuestionaire();
        educationQuestionaire = new EducationQuestionaire();
        familyBackgroundQuestionaire = new FamilyBackgroundQuestionaire();
        jobQuestionaire = new JobQuestionaire();
        trainingQuestionaire = new TrainingQuestionaire();
        physicalQuestionaire = new PhysicalQuestionaire();
        guardQuestionaire = new PreviousExperienceQuestionaire();
        isDetailsSet = false;
    }

    public PhysicalQuestionaire getPhysicalQuestionaire() {
        return physicalQuestionaire;
    }

    public void setPhysicalQuestionaire(PhysicalQuestionaire physicalQuestionaire) {
        this.physicalQuestionaire = physicalQuestionaire;
    }

    public PreviousExperienceQuestionaire getGuardQuestionaire() {
        return guardQuestionaire;
    }

    public void setGuardQuestionaire(PreviousExperienceQuestionaire guardQuestionaire) {
        this.guardQuestionaire = guardQuestionaire;
    }
    
    
    public TrainingQuestionaire getTrainingQuestionaire() {
        return trainingQuestionaire;
    }

    public void setTrainingQuestionaire(TrainingQuestionaire trainingQuestionaire) {
        this.trainingQuestionaire = trainingQuestionaire;
    }
    
//    public String name;
//    public int age;
//    public String gender;
//    public int income;
//    public String education;
//    public String requestType;
//    
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public int getIncome() {
//        return income;
//    }
//
//    public void setIncome(int income) {
//        this.income = income;
//    }
//
//    public String getEducation() {
//        return education;
//    }
//
//    public void setEducation(String education) {
//        this.education = education;
//    }
//
//    public String getRequestType() {
//        return requestType;
//    }
//
//    public void setRequestType(String requestType) {
//        this.requestType = requestType;
//    }

    public PersonalQuestionnaire getPersonalQuestionnaire() {
        return personalQuestionnaire;
    }

    public void setPersonalQuestionnaire(PersonalQuestionnaire personalQuestionnaire) {
        this.personalQuestionnaire = personalQuestionnaire;
    }

    public CriminalRelatedQuestionaire getCriminalRelatedQuestionaire() {
        return criminalRelatedQuestionaire;
    }

    public void setCriminalRelatedQuestionaire(CriminalRelatedQuestionaire criminalRelatedQuestionaire) {
        this.criminalRelatedQuestionaire = criminalRelatedQuestionaire;
    }

    public DrugAbuseQuestionaire getDrugAbuseQuestionaire() {
        return drugAbuseQuestionaire;
    }

    public void setDrugAbuseQuestionaire(DrugAbuseQuestionaire drugAbuseQuestionaire) {
        this.drugAbuseQuestionaire = drugAbuseQuestionaire;
    }

    public EducationQuestionaire getEducationQuestionaire() {
        return educationQuestionaire;
    }

    public void setEducationQuestionaire(EducationQuestionaire educationQuestionaire) {
        this.educationQuestionaire = educationQuestionaire;
    }

    public FamilyBackgroundQuestionaire getFamilyBackgroundQuestionaire() {
        return familyBackgroundQuestionaire;
    }

    public void setFamilyBackgroundQuestionaire(FamilyBackgroundQuestionaire familyBackgroundQuestionaire) {
        this.familyBackgroundQuestionaire = familyBackgroundQuestionaire;
    }

    public JobQuestionaire getJobQuestionaire() {
        return jobQuestionaire;
    }

    public void setJobQuestionaire(JobQuestionaire jobQuestionaire) {
        this.jobQuestionaire = jobQuestionaire;
    }

    public boolean isIsDetailsSet() {
        return isDetailsSet;
    }

    public void setIsDetailsSet(boolean isDetailsSet) {
        this.isDetailsSet = isDetailsSet;
    }
    
}
