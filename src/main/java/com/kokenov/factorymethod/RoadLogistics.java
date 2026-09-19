package com.kokenov.factorymethod;

/**
 * Concrete Creator representing Road Logistics.
 */
public class RoadLogistics extends Logistics {

    @Override
    // Clean Code: factory method does exactly one thing — instantiate the correct Transport
    public Transport createTransport() {
        // Assume default capacity is 20 tons
        return new Truck(20.0);
    }
}
