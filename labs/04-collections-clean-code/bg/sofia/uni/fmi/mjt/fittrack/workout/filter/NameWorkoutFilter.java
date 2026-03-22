package bg.sofia.uni.fmi.mjt.fittrack.workout.filter;

import bg.sofia.uni.fmi.mjt.fittrack.workout.Workout;

public class NameWorkoutFilter implements WorkoutFilter {

    private final String keyword;
    private final boolean caseSensitive;

    public NameWorkoutFilter(String keyword, boolean caseSensitive) {
        if (keyword == null || keyword.isEmpty()) {
            throw new IllegalArgumentException("Keyword can not be null or empty!");
        }

        this.keyword = keyword;
        this.caseSensitive = caseSensitive;
    }

    @Override
    public boolean matches(Workout workout) {
        if (caseSensitive == false) {
            return workout.getName().toLowerCase().contains(keyword.toLowerCase());
        }

        return workout.getName().contains(keyword);
    }
}
