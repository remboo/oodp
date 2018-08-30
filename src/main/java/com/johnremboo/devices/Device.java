package com.johnremboo.devices;

public interface Device {
    void connect() throws Exception;
    void disconnect() throws Exception;
    void poll(int value) throws Exception;
    void reset() throws Exception;
}
