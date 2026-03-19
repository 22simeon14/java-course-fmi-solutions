package bg.sofia.uni.fmi.mjt.burnout.subject;

 /**
  * @param name the name of the subject
  * @param credits number of credit hours for this subject
  * @param rating difficulty rating of the subject (1-5)
  * @param category the academic category the subject belongs to
  * @param neededStudyTime estimated study time in days required for this subject
  * 
  * @throws IllegalArgumentException if the name of the subject is null or blank 
  * @throws IllegalArgumentExceptionIf if the credits are not positive
  * @throws IllegalArgumentException if the rating is not in its bounds 
  * @throws IllegalArgumentException if the Category is null
  * @throws IllegalArgumentException if the neededStudyTime is not positive
  */

public record UniversitySubject (String name, int credits, int rating, Category category, int neededStudyTime){
    public UniversitySubject{
        if(name.equals("") || name == null){
            throw new IllegalArgumentException("Subject name can not be blank or null!");
        }
        if(credits < 0){
            throw new IllegalArgumentException("Credtis of a subject can not be negative!");
        }
        if(rating < 1 || rating > 5){
            throw new IllegalArgumentException("Rating must be in the range 1-5!");
        }
        if(category == null){
             throw new IllegalArgumentException("Category of the subject can not be null!");
        }
        if(neededStudyTime < 0){
            throw new IllegalArgumentException("NeddedStudyTime must be positive!");
        }
    }
}
