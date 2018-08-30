package com.johnremboo.devices.decorators;

import com.johnremboo.devices.Device;

/**
 * Class-decorator. Adds acceptCoin() method to poll
 */
public class AcceptCoinsDevice extends DeviceDecorator {

    public AcceptCoinsDevice(Device device) {
        super(device);
    }

    public void poll(int value) throws Exception {
        device.poll(value);
        acceptCoin(value);
    }

    private void acceptCoin(int coin) {
        System.out.println("COIN ACCEPTED. NOMINAL: " + coin);
    }
}
