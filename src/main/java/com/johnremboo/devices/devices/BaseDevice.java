package com.johnremboo.devices.devices;

import com.johnremboo.devices.Device;
import com.johnremboo.devices.State;
import com.johnremboo.devices.states.*;

import java.util.HashMap;
import java.util.Map;

import static com.johnremboo.devices.Constants.*;

/**
 * Base device class describes general logic of devices.
 */
public abstract class BaseDevice implements Device {
    private State currentState;
    private Map<String, State> states;
    private String name;

    protected void initStates() {
        states = new HashMap<>();
        states.put("OFF", new Off());
        states.put("IDLE", new Idle());
        states.put("EMERGENCY", new Emergency());
        setState(states.get(OFF));
    }

    public State getState() {
        return currentState;
    }

    public void setState(State currentState) {
        this.currentState = currentState;
    }

    @Override
    public void connect() throws InterruptedException {
        currentState.connect();
        Thread.sleep(COMMAND_TIME);

        if (currentState.getName().equals(OFF)) {
            setState(states.get(IDLE));
        }
        currentState.getName();
    }

    @Override
    public void disconnect() throws InterruptedException {
        currentState.disconnect();
        Thread.sleep(COMMAND_TIME);

        switch (currentState.getName()) {
            case IDLE:
            case EMERGENCY:
                setState(states.get(DISCONNECTED));
                break;
        }
    }

    @Override
    public void poll(int value) throws InterruptedException {
        currentState.poll();
        Thread.sleep(COMMAND_TIME);
    }

    @Override
    public void reset() throws InterruptedException {
        currentState.reset();
        setState(getStates().get(IDLE));
        Thread.sleep(COMMAND_TIME);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<String, State> getStates() {
        return states;
    }
}
