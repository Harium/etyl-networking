package com.harium.blakfisk.listener;

import com.harium.blakfisk.BlakFiskClient;
import com.harium.blakfisk.example.client.SimpleClientProtocol;
import com.harium.blakfisk.example.server.HandShakeServer;
import com.harium.blakfisk.example.server.SimpleServerProtocol;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ListenerTest extends TestCase {

    private static final String LOCAL_IP = "127.0.0.1";

    private String LISTENER_PREFIX = "/s";

    private HandShakeServer server;

    private static final int PORT = 10221;

    @Before
    public void setUp() {
        server = new HandShakeServer(PORT);

        SimpleServerProtocol listener = new SimpleServerProtocol(LISTENER_PREFIX, server);
        server.addProtocol(listener.getPrefix(), listener);
    }

    @Test
    public void testListener() throws Exception {
        server.start();

        SimpleServerProtocol simpleListener = (SimpleServerProtocol) server.getProtocol(LISTENER_PREFIX);

        BlakFiskClient client = new BlakFiskClient(LOCAL_IP, PORT);
        client.connect();

        SimpleClientProtocol clientProtocol = new SimpleClientProtocol(client);
        client.addProtocol(clientProtocol);
        clientProtocol.sendHandShake();

        Thread.sleep(500);
        Assert.assertEquals(1, server.getConnections().length);
        Assert.assertTrue(simpleListener.receivedTcp());

        client.close();
        server.close();
    }
}
