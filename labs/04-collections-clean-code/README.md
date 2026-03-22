# Lab 04 — Collections and Clean Code

## Overview

This lab focuses on working with Java **collections** and applying **clean code principles**.

The task involves processing and organizing data using appropriate collection types while writing readable, maintainable, and well-structured code.

The goal is to improve code quality by using meaningful abstractions, proper naming, and clear logic.

---

## Concepts Practiced

- Java Collections Framework
- Lists, Sets, and Maps
- Iteration and data processing
- Clean code principles
- Writing readable and maintainable code
- Proper method decomposition

---

## Project Structure

```
src
└── bg
    └── sofia
        └── uni
            └── fmi
                └── mjt
                    └── fittrack
                        ├── exception
                        │      ├── InvalidWorkoutException.java 
                        │      └── OptimalPlanImpossibleException.java 
                        ├── workout
                        │      ├── filter   
                        │      │      ├── CaloriesWorkoutFilter.java
                        │      │      ├── DurationWorkoutFilter.java
                        │      │      ├── NameWorkoutFilter.java
                        │      │      ├── TypeWorkoutFilter.java
                        │      │      └── WorkoutFilter.java
                        │      ├── BaseWorkout.java
                        │      ├── CardioWorkout.java
                        │      ├── StrengthWorkout.java  
                        │      ├── Workout.java  
                        │      ├── WorkoutType.java  
                        │      └── YogaSession.java          
                        ├── FitPlanner.java
                        ├── FitPlannerAPI.java
                        └── (...)
```

All classes are located under the package hierarchy starting from `bg.sofia.uni.fmi.mjt`.

---

## Notes

This directory contains my personal solution for **Lab 04** from the *Modern Java Technologies* course at the Faculty of Mathematics and Informatics, Sofia University.

The focus of this implementation is on using **appropriate data structures** and writing **clean, maintainable Java code**.