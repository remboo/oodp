package com.johnremboo.devices;

import java.util.ArrayList;
import java.util.List;

/**
 * Server can reset terminals. Realizes Observer pattern
 */
public class Server {
    private List<Terminal> observers = new ArrayList<>();

    public void addObserver(Terminal terminal) {
        observers.add(terminal);
    }

    public void resetTerminals() throws Exception {
        notifyObservers();
        System.out.println("TERMINALS HAS BEEN RESET");
    }

    public void notifyObservers() throws Exception {
        for (Terminal terminal : observers) {
            terminal.reset();
        }
    }
}
