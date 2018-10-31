

/*
 * Copyright (c) 2018.
 * Developed by vanessalatefapampilo
 */


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private static ArrayList<Client>clients;
    private int port;

    public Server (int port){
        this.port = port;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
            Server server = new Server (3001);
            server.startServer ();

    }

    public void startServer () throws IOException {
        ServerSocket serverSocket = new ServerSocket (3001);

        System.out.println ("---------------------------------------------");
        System.out.println ("Server is up and running");
        System.out.println ("WE ARE WAITING FOR CLIENTS TO CONNECT");
        System.out.println ("---------------------------------------------");

        clients = new ArrayList <> ();
        int i = 0;

        while(true){
            i = i +1;
            Socket socket = serverSocket.accept ();
            ListeningThread listen = new ListeningThread (this, socket,i);
            listen.start ();
        }



    }

    public Client getClientByName (String username){
        for (int i = 0; i<this.clients.size (); i++){

            if(this.clients.get (i).getClientName ().equals (username)){
                return this.clients.get (i);
            }

        }
        return null;
    }

    public ArrayList <Client> getClients() {
        return clients;
    }
}

