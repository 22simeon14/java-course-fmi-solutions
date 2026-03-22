package bg.sofia.uni.fmi.mjt.fittrack.workout;

public final class StrengthWorkout extends BaseWorkout implements Workout {

    private final static WorkoutType WORKOUT_TYPE = WorkoutType.STRENGTH;

    public StrengthWorkout(String name, int duration, int caloriesBurned, int difficulty) {
        super(name, duration, caloriesBurned, difficulty);
    }

    public WorkoutType getType() {
        return WORKOUT_TYPE;
    }
    
}