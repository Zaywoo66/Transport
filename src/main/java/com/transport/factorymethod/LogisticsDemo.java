package com.transport.factorymethod;

/**
 * The Client class demonstrating the Factory Method pattern.
 */
public class LogisticsDemo {

    public static void main(String[] args) {
        System.out.println("--- Factory Method Demo: Logistics ---");

        // We can choose the logistics type based on configuration, arguments, or environment.
        // Once chosen, the client code works with it polymorphically.
        Logistics roadLogistics = new RoadLogistics();
        runDelivery(roadLogistics);

        System.out.println();

        Logistics seaLogistics = new SeaLogistics();
        runDelivery(seaLogistics);
    }

    /**
     * Executes the delivery workflow using the provided Logistics creator.
     * 
     * @param logistics the concrete logistics creator (e.g., RoadLogistics or SeaLogistics)
     */
    private static void runDelivery(Logistics logistics) {
        // Clean Code: client depends only on abstract Logistics/Transport — polymorphism replaces if/switch on type
        logistics.planDelivery();
    }
}
