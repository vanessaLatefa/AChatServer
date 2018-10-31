/*
 * Copyright (c) 2018.
 * Developed by vanessalatefapampilo
 */

/***
 * The server's package needs to have a client class to create a new client's connection that accesses a connection in our server*/
public class Client {


    private String clientName;
    private ClientSocket clientSocket;

    public Client (ClientSocket clientSocket, String clientName){
        this.clientSocket = clientSocket;
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }

    public ClientSocket getClientSocket() {
        return clientSocket;
    }
}
