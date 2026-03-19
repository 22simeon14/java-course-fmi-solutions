package bg.sofia.uni.fmi.mjt.burnout.semester;

import bg.sofia.uni.fmi.mjt.burnout.plan.SemesterPlan;
import bg.sofia.uni.fmi.mjt.burnout.subject.UniversitySubject;
import java.util.Arrays;

public final class ComputerScienceSemesterPlanner extends AbstractSemesterPlanner {
    @Override
    public UniversitySubject[] selectSubjects(SemesterPlan semesterPlan){
        UniversitySubject[] subjects = Arrays.copyOf(semesterPlan.subjects(),semesterPlan.subjects().length);
        Arrays.sort(subjects, (a,b) -> Integer.compare(b.rating(), a.rating()));
        
        int totalSubjectsCount = 0;
        int length = subjects.length;
        int goal = semesterPlan.minimalAmoutOfCredits();
        int sumOfCredits = 0;
        int index = 0;
        while(length > 0){
            if(sumOfCredits >= goal){
                break;
            }   
            sumOfCredits += subjects[index++].credits();
            length--;
            totalSubjectsCount++;
        }
        if(sumOfCredits < goal) return null;
        UniversitySubject[] res = new UniversitySubject[totalSubjectsCount];
        for(int i = 0; i < totalSubjectsCount; i++){
            res[i] = subjects[i];
        }
        return res;
    }
}
