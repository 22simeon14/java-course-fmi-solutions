package bg.sofia.uni.fmi.mjt.burnout.semester;

import bg.sofia.uni.fmi.mjt.burnout.exception.CryToStudentsDepartmentException;
import bg.sofia.uni.fmi.mjt.burnout.exception.DisappointmentException;
import bg.sofia.uni.fmi.mjt.burnout.exception.InvalidSubjectRequirementsException;
import bg.sofia.uni.fmi.mjt.burnout.plan.SemesterPlan;
import bg.sofia.uni.fmi.mjt.burnout.subject.UniversitySubject;
import bg.sofia.uni.fmi.mjt.burnout.subject.Category;
import bg.sofia.uni.fmi.mjt.burnout.subject.SubjectRequirement;

public abstract sealed class AbstractSemesterPlanner 
        implements SemesterPlannerAPI
        permits ComputerScienceSemesterPlanner, SoftwareEngineeringSemesterPlanner {
    
    @Override
    public UniversitySubject[] calculateSubjectList(SemesterPlan semesterPlan) throws InvalidSubjectRequirementsException{
        if(semesterPlan == null){
            throw new IllegalArgumentException("Semester plan can not be null!");
        }
        
        int subjectRequirementsLength = semesterPlan.subjectRequirements().length;
        for(int i = 0; i < subjectRequirementsLength; i++){
            Category current = semesterPlan.subjectRequirements()[i].category();
            for(int j = i + 1; j < subjectRequirementsLength; j++){
                if(semesterPlan.subjectRequirements()[j].category() == current){
                    throw new InvalidSubjectRequirementsException("SubjectRequirements contains duplicate categories!");
                }
            }
        }

        for(SubjectRequirement req : semesterPlan.subjectRequirements()){
            Category cat = req.category();
            int currentCategoryMinimumSubjects = req.minAmountEnrolled();
            for(int i = 0; i < semesterPlan.subjects().length; i++){
                if(currentCategoryMinimumSubjects <= 0) break;
                if(semesterPlan.subjects()[i].category() == cat){
                    currentCategoryMinimumSubjects--;
                }
            }
            if(currentCategoryMinimumSubjects > 0) throw new CryToStudentsDepartmentException("Can not cover the needed amount of subjects for each category!");
        }

        UniversitySubject[] result = selectSubjects(semesterPlan);
        if(result == null) throw new CryToStudentsDepartmentException("Minimal credits can not be covered!");
        return result;
    }

    protected abstract UniversitySubject[] selectSubjects(SemesterPlan semesterPlan); 

    @Override
    public int calculateJarCount(UniversitySubject[] subjects, int maximumSlackTime, int semesterDuration){
        if (subjects == null || maximumSlackTime <= 0 || semesterDuration <= 0) {
        throw new IllegalArgumentException("Invalid arguments!");
        }

        int totalStudyDays = 0;
        for (UniversitySubject sub : subjects) {
            double coef = switch(sub.category()) {
                case MATH -> 0.2;
                case PROGRAMMING -> 0.1;
                case THEORY -> 0.15;
                case PRACTICAL -> 0.05;
            };
            totalStudyDays += sub.neededStudyTime() + Math.ceil(sub.neededStudyTime() * coef);
        }

        int jarCount;
        if (totalStudyDays > semesterDuration) {
            // Няма достатъчно дни → баба дава бонус
            jarCount = ((int) Math.ceil(totalStudyDays / 5.0)) * 2;
        } else if (totalStudyDays < maximumSlackTime) {
            // Прекалено много почивка → DisappointmentException
            throw new DisappointmentException("Too much slack time!");
        } else {
            jarCount = (int) Math.ceil(totalStudyDays / 5.0);
        }

        return jarCount;
    }
}
