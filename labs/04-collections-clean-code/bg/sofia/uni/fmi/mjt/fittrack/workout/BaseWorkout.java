package bg.sofia.uni.fmi.mjt.fittrack.workout;

import bg.sofia.uni.fmi.mjt.fittrack.exception.InvalidWorkoutException;

public sealed abstract class BaseWorkout permits CardioWorkout, StrengthWorkout, YogaSession {

    private final String name;
    private final int duration;
    private final int caloriesBurned;
    private final int difficulty;

    public BaseWorkout(String name, int duration, int caloriesBurned, int difficulty) {

        if (name == null || name.isEmpty()) {
            throw new InvalidWorkoutException("Invalid workout name!");
        }
        if (duration <= 0) {
            throw new InvalidWorkoutException("Duration must be a positive integer!");
        }
        if (caloriesBurned <= 0) {
            throw new InvalidWorkoutException("Calories Burned must be a positive integer!");
        }
        if (difficulty < 1 || difficulty > 5) {
            throw new InvalidWorkoutException("Difficulty must be between 1 and 5 (including)!");
        }

        this.name = name;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
        this.difficulty = difficulty;
    }

    public String getName() {
        return this.name;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getCaloriesBurned() {
        return this.caloriesBurned;
    }

    public int getDifficulty() {
        return this.difficulty;
    }

}
