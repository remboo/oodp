package com.johnremboo.devices.decorators;

import com.johnremboo.devices.Device;

/**
 * Class-decorator. Adds acceptNote() method to poll
 */
public class AcceptNotesDevice extends DeviceDecorator {
    public AcceptNotesDevice(Device device) {
        super(device);
    }

    public void poll(int value) throws Exception {
        device.poll(value);
        acceptNote(value);
    }

    private void acceptNote(int note) {
        System.out.println("NOTE ACCEPTED. NOMINAL: " + note);
    }
}
