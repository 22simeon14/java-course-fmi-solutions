package bg.sofia.uni.fmi.mjt.fittrack.workout;

public final class YogaSession extends BaseWorkout implements Workout {

    private final static WorkoutType WORKOUT_TYPE = WorkoutType.YOGA;

    public YogaSession(String name, int duration, int caloriesBurned, int difficulty) {
        super(name, duration, caloriesBurned, difficulty);
    }

    public WorkoutType getType() {
        return WORKOUT_TYPE;
    }
}
