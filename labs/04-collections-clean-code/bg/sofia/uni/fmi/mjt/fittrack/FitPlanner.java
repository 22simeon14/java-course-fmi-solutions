package bg.sofia.uni.fmi.mjt.fittrack;

import bg.sofia.uni.fmi.mjt.fittrack.workout.Workout;
import bg.sofia.uni.fmi.mjt.fittrack.workout.WorkoutType;
import bg.sofia.uni.fmi.mjt.fittrack.workout.filter.WorkoutFilter;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class FitPlanner implements FitPlannerAPI {

    private List<Workout> availableWorkouts;

    public FitPlanner(Collection<Workout> availableWorkouts) {
        if (availableWorkouts == null) {
            throw new IllegalArgumentException("Available workouts list can not be null!");
        }

        this.availableWorkouts = new ArrayList<>(availableWorkouts);
    }

    @Override
    public List<Workout> findWorkoutsByFilters(List<WorkoutFilter> filters) {
        if (filters == null) {
            throw new IllegalArgumentException("Filters list can not be null!");
        }

        List<Workout> resultAfterFilters = new ArrayList<>();

        if (this.availableWorkouts.size() == 0) {
            return resultAfterFilters;
        }

        for (Workout workout : availableWorkouts) {

            boolean flag = true;
            for (WorkoutFilter filter : filters) {
                if (!filter.matches(workout)) {
                    flag = false;
                }
            }

            if (flag) {
                resultAfterFilters.add(workout);
            }
        }

        return resultAfterFilters;
    }

    @Override
    public List<Workout> generateOptimalWeeklyPlan(int totalMinutes) {
        if (totalMinutes < 0) {
            throw new IllegalArgumentException("Total minutes must be a non-negative integer!");
        }

        if (this.availableWorkouts.size() == 0 || totalMinutes == 0) {
            return new ArrayList<>();
        }

    }

    @Override
    public Map<WorkoutType, List<Workout>> getWorkoutsGroupedByType() {
        if (this.availableWorkouts.size() == 0) {
            return Collections.unmodifiableMap(new HashMap<>());
        }

        Map<WorkoutType, List<Workout>> resultAfterGroupingByType = new HashMap<>();
        resultAfterGroupingByType.put(WorkoutType.CARDIO, new ArrayList<Workout>());
        resultAfterGroupingByType.put(WorkoutType.STRENGTH, new ArrayList<Workout>());
        resultAfterGroupingByType.put(WorkoutType.YOGA, new ArrayList<Workout>());

        for (Workout workout : availableWorkouts) {
            resultAfterGroupingByType.get(workout.getType()).add(workout);
        }

        resultAfterGroupingByType.put(
            WorkoutType.CARDIO, 
            Collections.unmodifiableList(resultAfterGroupingByType.get(WorkoutType.CARDIO))
        );
        resultAfterGroupingByType.put(
            WorkoutType.STRENGTH,
            Collections.unmodifiableList(resultAfterGroupingByType.get(WorkoutType.STRENGTH))
        );
        resultAfterGroupingByType.put(
            WorkoutType.YOGA,
            Collections.unmodifiableList(resultAfterGroupingByType.get(WorkoutType.YOGA))
        );
        
        return Collections.unmodifiableMap(resultAfterGroupingByType);
    }

    @Override
    public List<Workout> getWorkoutsSortedByCalories() {
        if (this.availableWorkouts == null) {
            return Collections.unmodifiableList(new ArrayList<>());
        }

        List<Workout> resultAfterSorting = new ArrayList<>(this.availableWorkouts);
        Collections.sort(resultAfterSorting, Comparator.comparingInt(Workout::getCaloriesBurned).reversed());

        return Collections.unmodifiableList(resultAfterSorting);
    }

    @Override
    public List<Workout> getWorkoutsSortedByDifficulty() {
        if (this.availableWorkouts.size() == 0) {
            return Collections.unmodifiableList(new ArrayList<>());
        }

        List<Workout> resultAfterSorting = new ArrayList<>(this.availableWorkouts);
        Collections.sort(resultAfterSorting, Comparator.comparingInt(Workout::getDifficulty));

        return Collections.unmodifiableList(resultAfterSorting);
    }

    @Override
    public Set<Workout> getUnmodifiableWorkoutSet() {
        if (this.availableWorkouts.size() == 0) {
            return Collections.unmodifiableSet(new HashSet<>());
        }

        Set<Workout> availableWorkoutsAsSet = new HashSet<>(availableWorkouts);

        return Collections.unmodifiableSet(availableWorkoutsAsSet);
    }
}
