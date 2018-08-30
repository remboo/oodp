package com.johnremboo.devices;

public class Main {
    public static void main(String[] args) throws Exception {
        Server server = new Server();
        Terminal terminal1 = new Terminal(111);
        Terminal terminal2 = new Terminal(222);

        server.addObserver(terminal1);
        server.addObserver(terminal2);

        terminal1.initialize();
        terminal2.initialize();

        terminal1.connectCoinAcceptor();
        terminal1.connectCoinDispenser();
        terminal1.connectNoteAcceptor();
        terminal1.connectNoteDispenser();

        terminal1.pollCoinAcceptor(10);
        terminal1.pollCoinDispenser(20);
        terminal1.pollNoteAcceptor(30);
        terminal1.pollNoteDispenser(40);

        terminal2.connectCoinAcceptor();
        terminal2.connectCoinDispenser();
        terminal2.connectNoteAcceptor();
        terminal2.connectNoteDispenser();

        terminal2.pollCoinAcceptor(50);
        terminal2.pollCoinDispenser(60);
        terminal2.pollNoteAcceptor(70);
        terminal2.pollNoteDispenser(80);

        server.resetTerminals();

        terminal1.disconnectCoinAcceptor();
        terminal1.disconnectCoinDispenser();
        terminal1.disconnectNoteAcceptor();
        terminal1.disconnectNoteDispenser();

        terminal2.disconnectCoinAcceptor();
        terminal2.disconnectCoinDispenser();
        terminal2.disconnectNoteAcceptor();
        terminal2.disconnectNoteDispenser();
    }
}
