package com.johnremboo.devices.decorators;

import com.johnremboo.devices.Device;

/**
 * Abstract decorator class implements Device Interface. Realizes Decorator Pattern
 */
public abstract class DeviceDecorator implements Device {
    protected Device device;

    public DeviceDecorator(Device device) {
        this.device = device;
    }

    public void connect() throws Exception {
        device.connect();
    }

    public void disconnect() throws Exception {
        device.disconnect();
    }

    public void poll(int value) throws Exception {
        device.poll(value);
    }

    public void reset() throws Exception {
        device.reset();
    }
}
