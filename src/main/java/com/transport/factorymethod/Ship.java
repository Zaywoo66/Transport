package com.transport.factorymethod;

/**
 * Concrete Product representing a Ship.
 */
public class Ship implements Transport {
    private final String route;

    public Ship(String route) {
        // Clean Code: constructor rejects invalid state immediately rather than allowing a half-built object
        if (route == null || route.trim().isEmpty()) {
            throw new IllegalArgumentException("Ship route cannot be null or empty");
        }
        this.route = route;
    }

    @Override
    public void deliver() {
        System.out.println("Delivering cargo by sea using a Ship on route: " + route + ".");
    }

    @Override
    public String getType() {
        return "Ship";
    }
}
