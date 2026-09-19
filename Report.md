# Clean Code Principles Report

This report outlines the five Clean Code principles applied in this project, complete with before (violating) and after (Clean Code) snippets.

## 1. Meaningful, intention-revealing names
**Location:** `Logistics.java`

**Before:**
```java
// What does 'make()' return or do? It's ambiguous.
public abstract Transport make();
```

**After:**
```java
// Clean Code: method name clearly states intent — no need for extra documentation
public abstract Transport createTransport();
```
*Reasoning:* A well-named method prevents the need for extensive comments explaining what the method returns or does.

---

## 2. No conditional/type-checking logic in client code
**Location:** `LogisticsDemo.java`

**Before:**
```java
if (type.equals("Road")) {
    Truck truck = new Truck(20);
    truck.deliver();
} else if (type.equals("Sea")) {
    Ship ship = new Ship("Atlantic");
    ship.deliver();
}
```

**After:**
```java
// Clean Code: client depends only on abstract Logistics/Transport — polymorphism replaces if/switch on type
logistics.planDelivery();
```
*Reasoning:* Using polymorphism (the Open/Closed Principle) means the client code doesn't need to change if we add a new logistics type (like `AirLogistics`).

---

## 3. Small, single-purpose factory methods
**Location:** `RoadLogistics.java` and `SeaLogistics.java`

**Before:**
```java
public Transport createTransport() {
    System.out.println("Preparing transport...");
    // logging, complex setup logic...
    return new Truck(20.0);
}
```

**After:**
```java
// Clean Code: factory method does exactly one thing — instantiate the correct Transport
public Transport createTransport() {
    return new Truck(20.0);
}
```
*Reasoning:* A method should do one thing and do it well (Single Responsibility Principle). The factory method should only instantiate the product.

---

## 4. No duplicated logic between concrete creators
**Location:** `Logistics.java`

**Before:**
*(Duplicated in both RoadLogistics and SeaLogistics)*
```java
public void planDelivery() {
    Transport t = createTransport();
    System.out.println("Logistics: Planning delivery strategy...");
    t.deliver();
    System.out.println("Logistics: Delivery completed.");
}
```

**After:**
```java
// Clean Code: shared delivery workflow lives once in the base class (Template Method), avoiding duplication in RoadLogistics/SeaLogistics
public void planDelivery() {
    Transport transport = createTransport();
    System.out.println("Logistics: Planning delivery strategy...");
    transport.deliver();
    System.out.println("Logistics: Delivery completed by " + transport.getType() + ".");
}
```
*Reasoning:* Applying the DRY (Don't Repeat Yourself) principle using the Template Method pattern keeps common logic centralized.

---

## 5. Validated/consistent object construction
**Location:** `Truck.java` and `Ship.java`

**Before:**
```java
public Truck(double capacityTons) {
    this.capacityTons = capacityTons; // Could be negative or zero!
}
```

**After:**
```java
public Truck(double capacityTons) {
    // Clean Code: constructor rejects invalid state immediately rather than allowing a half-built object
    if (capacityTons <= 0) {
        throw new IllegalArgumentException("Truck capacity must be strictly positive");
    }
    this.capacityTons = capacityTons;
}
```
*Reasoning:* Fail-fast validation prevents bugs down the line by ensuring objects are always created in a valid state.
