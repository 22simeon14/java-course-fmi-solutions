# Lab 02 — Object-Oriented Programming I

## Overview

This lab focuses on the fundamentals of **object-oriented programming in Java**.

The task involves implementing a simplified simulation of a reality show by designing multiple interacting classes that represent contestants, elimination rules, and events occurring during the show.

The goal is to practice proper **class design**, **encapsulation**, and **code organization using packages**.

---

## Concepts Practiced

- Object-oriented programming fundamentals
- Designing classes and objects
- Encapsulation
- Interfaces and implementations
- Package organization

---

## Project Structure

```
src
└── bg
    └── sofia
        └── uni
            └── fmi
                └── mjt
                    └── show
                        ├── ShowAPI.java
                        ├── ShowAPIImpl.java
                        ├── ergenka
                        │    ├── AbstractErgenka.java
                        │    ├── Ergenka.java
                        │    ├── HumorousErgenka.java
                        │    └── RomanticErgenka.java
                        ├── elimination
                        │    ├── EliminationRule.java
                        │    ├── LowAttributesSumEliminationRule.java
                        │    ├── LowestRatingEliminationRule.java
                        │    └── PublicVoteEliminationRule.java
                        │── date
                        │   └── DateEvent.java
                        └── utils
                            └── Utils.java
                        
```

All classes are located under the package hierarchy starting from `bg.sofia.uni.fmi.mjt.show`.

---

## Notes

This directory contains my personal solution for **Lab 02** from the *Modern Java Technologies* course at the Faculty of Mathematics and Informatics, Sofia University.

The focus of this implementation is on writing **clean and well-structured object-oriented Java code**.