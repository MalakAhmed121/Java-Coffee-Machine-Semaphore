# Java Coffee Machine - Semaphore

## Description
A simple Java project that simulates customers using a coffee machine
with the help of a counting semaphore.

## Concepts Used
- Java Threads
- Runnable
- Semaphore
- P() and V()
- Shared Resources
- Thread Synchronization

## How It Works
- Multiple customer threads try to use the coffee machine.
- The semaphore controls how many customers can use the machine at the same time.
- Customers call P() to acquire a permit before using the machine.
- After finishing, they call V() to release the permit.

## Technologies
- Java
- Git & GitHub
