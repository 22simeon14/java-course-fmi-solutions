package bg.sofia.uni.fmi.mjt.fittrack.workout.filter;

import bg.sofia.uni.fmi.mjt.fittrack.workout.Workout;

public class CaloriesWorkoutFilter implements WorkoutFilter {

    private final int min;
    private final int max;

    public CaloriesWorkoutFilter(int min, int max) {
        if (min > max || min < 0 || max < 0) {
            throw new IllegalArgumentException("Illegal [min, max] interval!");
        }

        this.min = min;
        this.max = max;
    }

    @Override
    public boolean matches(Workout workout) {
        return this.min <= workout.getCaloriesBurned() && workout.getCaloriesBurned() <= max;
    }
}
