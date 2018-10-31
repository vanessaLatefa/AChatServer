/*
 * Copyright (c) 2018.
 * Developed by vanessalatefapampilo
 */

import java.io.*;
import java.net.Socket;

/**
 * */
public class ClientSocket {

    private Socket clientSocket;

    public ClientSocket(Socket socket) {
        this.clientSocket = socket;
    }

    public String request() throws IOException {
        BufferedReader bufferedReader = new BufferedReader (new InputStreamReader (this.clientSocket.getInputStream ()));

        String messageIn = bufferedReader.readLine ();
            return messageIn;
    }

    public void writeResponse (String messageOut) throws IOException {

           PrintWriter pwPrintWriter = new PrintWriter (new OutputStreamWriter (this.clientSocket.getOutputStream ()));

                pwPrintWriter.println (messageOut + "\n");
                pwPrintWriter.flush ();

    }
        public Socket getClientSocket () {
            return clientSocket;
        }

    }
