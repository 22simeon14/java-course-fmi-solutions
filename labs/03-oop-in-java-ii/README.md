# Lab 03 — Object-Oriented Programming II

## Overview

This lab builds upon the concepts introduced in the previous lab and focuses on more advanced object-oriented programming techniques in Java.

The task extends an existing system by introducing **inheritance**, **abstraction**, and **polymorphism**, enabling more flexible and reusable class design.

The goal is to improve code structure and model more complex relationships between objects.

---

## Concepts Practiced

- Inheritance
- Abstraction
- Polymorphism
- Method overriding
- Extending existing class hierarchies
- Code reuse and modular design

---

## Project Structure

```
src
└── bg
    └── sofia
        └── uni
            └── fmi
                └── mjt
                    └── burnout
                        ├─ exception/
                        │  ├─ CryToStudentsDepartmentException.java
                        │  ├─ DisappointmentException.java
                        │  └─ InvalidSubjectRequirementsException.java
                        ├─ plan/
                        │  └─ SemesterPlan.java
                        ├─ semester/
                        │  ├─ AbstractSemesterPlanner.java
                        │  ├─ ComputerScienceSemesterPlanner.java
                        │  ├─ SemesterPlannerAPI.java
                        │  └─ SoftwareEngineeringSemesterPlanner.java
                        └─ subject/
                            ├─ Category.java
                            ├─ SubjectRequirement.java
                            └─ UniversitySubject.java  
```

All classes are located under the package hierarchy starting from `bg.sofia.uni.fmi.mjt.show`.

---

## Notes

This directory contains my personal solution for **Lab 03** from the *Modern Java Technologies* course at the Faculty of Mathematics and Informatics, Sofia University.
