/*
 * Copyright (c) 2018.
 * Developed by vanessalatefapampilo
 */

import java.io.IOException;

public class ClientHandlingThread implements Runnable {

    Client client;
    Server server;

    public ClientHandlingThread(Client client, Server server) {
        this.client = client;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            String messageIn = this.client.getClientSocket ().request ();
            System.out.println (messageIn);

            for (Client client : server.getClients ()){
                if( client != this.client){
                    client.getClientSocket ().writeResponse (messageIn);
                }

            }


        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}
