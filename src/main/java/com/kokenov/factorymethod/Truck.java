package com.kokenov.factorymethod;

/**
 * Concrete Product representing a Truck.
 */
public class Truck implements Transport {
    private final double capacityTons;

    public Truck(double capacityTons) {
        // Clean Code: constructor rejects invalid state immediately rather than allowing a half-built object
        if (capacityTons <= 0) {
            throw new IllegalArgumentException("Truck capacity must be strictly positive");
        }
        this.capacityTons = capacityTons;
    }

    @Override
    public void deliver() {
        System.out.println("Delivering cargo by land using a Truck with capacity: " + capacityTons + " tons.");
    }

    @Override
    public String getType() {
        return "Truck";
    }
}
