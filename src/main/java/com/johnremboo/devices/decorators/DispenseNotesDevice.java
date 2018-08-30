package com.johnremboo.devices.decorators;

import com.johnremboo.devices.Device;

/**
 * Class-decorator. Adds dispenseNote() method to poll
 */
public class DispenseNotesDevice extends DeviceDecorator {
    public DispenseNotesDevice(Device device) {
        super(device);
    }

    public void poll(int value) throws Exception {
        device.poll(value);
        dispenseNote(value);
    }

    private void dispenseNote(int note) {
        System.out.println("NOTE DISPENSED. NOMINAL: " + note);
    }
}
