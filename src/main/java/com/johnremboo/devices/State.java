package com.johnremboo.devices;

/**
 * Class represents the base state interface. Realizes State Pattern
 */
public interface State {

    /**
     * Closes connection of device
     *
     */
    void connect();

    /**
     * Closes connection of device
     *
     */
    void disconnect();

    /**
     * Polls device and handles poll response
     *
     */
    void poll();

    /**
     * Resets device
     *
     */
    void reset();

    /**
     *  Fetches the name of the state
     *
     * @return - name
     */
    String getName();
}
