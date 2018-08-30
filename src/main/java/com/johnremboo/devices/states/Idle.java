package com.johnremboo.devices.states;

import com.johnremboo.devices.State;
import static com.johnremboo.devices.Constants.*;

/**
 * Idle state of device
 */
public class Idle implements State {

    @Override
    public void connect() {
        System.out.println(NOT_CHANGED + OLD + IDLE);
    }

    @Override
    public void disconnect() {
        System.out.println(CHANGED + OLD + IDLE + NEW + OFF);
        System.out.println(DISCONNECTED);
    }

    @Override
    public void poll() {
        System.out.println(POLLED);
    }

    @Override
    public void reset() {
        System.out.println(RESET);
    }

    @Override
    public String getName() {
        return IDLE;
    }
}
