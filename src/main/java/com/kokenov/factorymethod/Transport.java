package com.kokenov.factorymethod;

/**
 * The Product interface declares the operations that all concrete products must implement.
 */
public interface Transport {
    /**
     * Executes the delivery process.
     */
    void deliver();

    /**
     * Gets the type of transport.
     * @return the transport type as a String
     */
    String getType();
}
