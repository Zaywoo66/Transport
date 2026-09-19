# Factory Method Pattern: Logistics Domain

## Overview
This project demonstrates the **Factory Method** design pattern in Java 17, applied to a Logistics domain. The core idea of the Factory Method is to define an interface for creating an object, but let subclasses alter the type of objects that will be created. In this scenario, we have an abstract `Logistics` creator that delegates the creation of `Transport` objects (like `Truck` and `Ship`) to its concrete subclasses (`RoadLogistics` and `SeaLogistics`). This allows the logistics system to plan deliveries polymorphically without being coupled to concrete transport classes.

## Project Structure
```text
src/main/java/com/transport/factorymethod/
├── Transport.java         // Product interface
├── Truck.java             // Concrete Product
├── Ship.java              // Concrete Product
├── Logistics.java         // Creator (abstract)
├── RoadLogistics.java     // Concrete Creator
├── SeaLogistics.java      // Concrete Creator
└── LogisticsDemo.java     // Client code demonstrating the pattern
```

## How to Compile and Run
This is a standard Maven project. You can compile and run it from the command line.

### Prerequisites
- Java 17 or higher
- Maven 3.6+

### Compilation
Navigate to the root directory containing `pom.xml` and run:
```bash
mvn clean compile
```

### Execution
You can execute the main demo class using the `exec-maven-plugin`:
```bash
mvn exec:java -Dexec.mainClass="com.transport.factorymethod.LogisticsDemo"
```

Alternatively, to run using plain `javac` and `java`:
```bash
cd src/main/java
javac com/transport/factorymethod/*.java
java com.transport.factorymethod.LogisticsDemo
```
