/*
 * Copyright (c) 2018.
 * Developed by vanessalatefapampilo
 */

import java.io.IOException;
import java.net.Socket;

public class ListeningThread extends Thread {

    Server server;
    Socket socket;
    int connections;

    public ListeningThread (Server server, Socket socket, int connections){
        this.server = server;
        this.socket = socket;
        this.connections = connections;
    }

    public void run (){

        System.out.println ("Someone connected to this server");
        System.out.println ("---------------------------------");

        ClientSocket cs = new ClientSocket (socket);
        String clientName = null;

        try {
            clientName = cs.request ();
        } catch (IOException e) {
            e.printStackTrace ();
        }

        Client client = new Client (cs,clientName);
        server.getClients ().add (client);

        System.out.println ("Client" + connections + "saved as: " + clientName);

        for ( int i = 0; i < server.getClients ().size (); i++){
            if (server.getClients ().get (i) != client){
                try {
                    server.getClients ().get (i).getClientSocket ().writeResponse( "New user connected : " + clientName);
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
        }

        ClientHandlingThread handlingThread = new ClientHandlingThread (client, server);
        Thread clientThread = new Thread (handlingThread);
        clientThread.start ();


    }




}
