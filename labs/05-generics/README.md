# Lab 05 — Generics

## Overview

This lab focuses on using **generics in Java** to create flexible, reusable, and type-safe components.

The task involves designing and implementing generic classes and methods, allowing operations to work with different data types while maintaining compile-time type safety.

The goal is to improve code reusability and eliminate the need for type casting.

---

## Concepts Practiced

- Generics in Java
- Generic classes and methods
- Type parameters
- Type safety and compile-time checks
- Reusable and flexible design

---

## Project Structure
```
src
└── bg
    └── sofia
        └── uni
            └── fmi
                └── mjt
                    └── eventbus
                        ├── data
                        │   ├── Message.java 
                        │   └── User.java 
                        ├── events
                        │      ├── BaseEvent.java 
                        │      ├── Event.java
                        │      ├── LoginPayload.java 
                        │      ├── LogoutPayload.java 
                        │      ├── MessageSentEvent.java 
                        │      ├── MessageSentPayload.java 
                        │      ├── Payload.java 
                        │      ├── UserLoginEvent.java 
                        │      └── UserLogoutEvent.java
                        ├── exception
                        │      └── MissingSubscriptionException.java
                        ├── subscribers
                        │      ├── DeferredEventSubscriber.java
                        │      ├── MessageSentSubscriber.java
                        │      ├── Subscriber.java
                        │      ├── UserLoginSubscriber.java
                        │      └── UserLogoutSubscriber.java
                        ├── EventBus.java
                        ├── EventBusImpl.java
                        └── (...)
```

All classes are located under the package hierarchy starting from `bg.sofia.uni.fmi.mjt`.

---

## Notes

This directory contains my personal solution for **Lab 05** from the *Modern Java Technologies* course at the Faculty of Mathematics and Informatics, Sofia University.

The focus of this implementation is on building **type-safe and reusable abstractions using generics**.