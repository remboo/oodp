package com.johnremboo.devices.states;

import com.johnremboo.devices.State;
import static com.johnremboo.devices.Constants.*;

/**
 * Emergency state of device
 */
public class Emergency implements State {

    @Override
    public void connect() {
        System.out.println(NOT_CHANGED + OLD + EMERGENCY);
    }

    @Override
    public void disconnect() {
        System.out.println(CHANGED + OLD + EMERGENCY + NEW + OFF);
        System.out.println(DISCONNECTED);
    }

    @Override
    public void poll() {
        System.out.println(NOT_CHANGED + OLD + EMERGENCY);
    }

    @Override
    public void reset() {
        System.out.println(CHANGED + OLD + EMERGENCY + NEW + IDLE);
        System.out.println(IDLE);
    }

    @Override
    public String getName() {
        return EMERGENCY;
    }
}
