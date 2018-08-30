package com.johnremboo.devices;

import com.johnremboo.devices.decorators.*;

import java.util.HashMap;
import java.util.Map;

import static com.johnremboo.devices.Constants.*;

/**
 * Class represents the Self Payment Terminal with 4 devices (Note Acceptor, Note Dispenser, Coin Acceptor, Coin Dispenser)
 * on board. Terminal can initialize, connect, disconnect, poll and reset devices separately
 * Realizes Facade Pattern
 */
public class Terminal {
    private Device noteAcceptor;
    private Device noteDispenser;
    private Device coinAcceptor;
    private Device coinDispenser;
    private boolean isInitialized = false;
    private int serialNumber;
    private Map<String, Device> devices = new HashMap<>();

    public Terminal(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean initialize() {
        if (!isInitialized) {
            isInitialized = true;
            noteAcceptor = new AcceptNotesDevice(DeviceFactory.create(NOTE_ACCEPTOR));
            noteDispenser = new DispenseNotesDevice(DeviceFactory.create(NOTE_DISPENSER));
            coinAcceptor = new AcceptCoinsDevice(DeviceFactory.create(COIN_ACCEPTOR));
            coinDispenser = new DispenseCoinsDevice(DeviceFactory.create(COIN_DISPENSER));
            addToList();
            System.out.println(TERMINAL + serialNumber + INITIALIZED);

            return true;
        }
        return false;
    }

    private void addToList() {
        devices.put(NOTE_ACCEPTOR, noteAcceptor);
        devices.put(NOTE_DISPENSER, noteDispenser);
        devices.put(COIN_ACCEPTOR, coinAcceptor);
        devices.put(COIN_DISPENSER, coinDispenser);
    }

    public void connectNoteAcceptor() throws Exception {
        noteAcceptor.connect();
    }

    public void connectNoteDispenser() throws Exception {
        noteDispenser.connect();
    }

    public void connectCoinAcceptor() throws Exception {
        coinAcceptor.connect();
    }

    public void connectCoinDispenser() throws Exception {
        coinDispenser.connect();
    }

    public void disconnectNoteAcceptor() throws Exception {
        noteAcceptor.disconnect();
    }

    public void disconnectNoteDispenser() throws Exception {
        noteDispenser.disconnect();
    }

    public void disconnectCoinAcceptor() throws Exception {
        coinAcceptor.disconnect();
    }

    public void disconnectCoinDispenser() throws Exception {
        coinDispenser.disconnect();
    }

    public void pollNoteAcceptor(int value) throws Exception {
        noteAcceptor.poll(value);
    }

    public void pollNoteDispenser(int value) throws Exception {
        noteDispenser.poll(value);
    }

    public void pollCoinAcceptor(int value) throws Exception {
        coinAcceptor.poll(value);
    }

    public void pollCoinDispenser(int value) throws Exception {
        coinDispenser.poll(value);
    }

    public void reset() throws Exception {
        devices.forEach((item, value) -> {
            try {
                value.reset();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println(TERMINAL + serialNumber + RESET);
        System.out.println(LINE);
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }
}
