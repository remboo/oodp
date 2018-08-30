package com.johnremboo.devices;

import com.johnremboo.devices.devices.CoinAcceptor;
import com.johnremboo.devices.devices.CoinDispenser;
import com.johnremboo.devices.devices.NoteAcceptor;
import com.johnremboo.devices.devices.NoteDispenser;

import static com.johnremboo.devices.Constants.*;

/**
 * Class realizes Abstract Factory Design Pattern.
 */
public class DeviceFactory {
    public static Device create(String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }

        switch (name) {
            case NOTE_ACCEPTOR:
                return new NoteAcceptor();
            case NOTE_DISPENSER:
                return new NoteDispenser();
            case COIN_ACCEPTOR:
                return new CoinAcceptor();
            case COIN_DISPENSER:
                return new CoinDispenser();
        }

        return null;
    }
}
