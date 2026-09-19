package com.kokenov.factorymethod;

/**
 * Concrete Creator representing Sea Logistics.
 */
public class SeaLogistics extends Logistics {

    @Override
    // Clean Code: factory method does exactly one thing — instantiate the correct Transport
    public Transport createTransport() {
        // Assume default route is Atlantic
        return new Ship("Atlantic Ocean");
    }
}
