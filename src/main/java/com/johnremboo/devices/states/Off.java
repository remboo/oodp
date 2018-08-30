package com.johnremboo.devices.states;

import com.johnremboo.devices.State;

import static com.johnremboo.devices.Constants.*;

/**
 * Off state of device
 */
public class Off implements State {

    @Override
    public void connect() {
        System.out.println(CHANGED + OLD + OFF + NEW + IDLE);
        System.out.println(CONNECTED);
    }

    @Override
    public void disconnect() {
        System.out.println(NOT_CHANGED + OLD + OFF);
    }

    @Override
    public void poll() {
        System.out.println(NOT_CHANGED + OLD + OFF);
    }

    @Override
    public void reset() {
        System.out.println(NOT_CHANGED + OLD + OFF);
    }

    @Override
    public String getName() {
        return OFF;
    }
}
