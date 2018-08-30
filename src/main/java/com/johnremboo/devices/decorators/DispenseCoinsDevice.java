package com.johnremboo.devices.decorators;

import com.johnremboo.devices.Device;

/**
 * Class-decorator. Adds dispenseCoin() method to poll
 */
public class DispenseCoinsDevice extends DeviceDecorator {
    public DispenseCoinsDevice(Device device) {
        super(device);
    }

    public void poll(int value) throws Exception {
        device.poll(value);
        dispenseCoin(value);
    }

    private void dispenseCoin(int coin) {
        System.out.println("COIN DISPENSED. NOMINAL: " + coin);
    }
}
