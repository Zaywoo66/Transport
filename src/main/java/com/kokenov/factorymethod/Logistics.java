package com.kokenov.factorymethod;

/**
 * The Creator class declares the factory method that is supposed to return an
 * object of a Product class. The Creator's subclasses usually provide the
 * implementation of this method.
 */
public abstract class Logistics {

    // Clean Code: shared delivery workflow lives once in the base class (Template Method), avoiding duplication in RoadLogistics/SeaLogistics
    public void planDelivery() {
        Transport transport = createTransport();
        System.out.println("Logistics: Planning delivery strategy...");
        transport.deliver();
        System.out.println("Logistics: Delivery completed by " + transport.getType() + ".");
    }

    // Clean Code: method name clearly states intent — no need for extra documentation
    public abstract Transport createTransport();
}
