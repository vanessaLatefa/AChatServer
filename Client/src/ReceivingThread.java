/*
 * Copyright (c) 2018.
 * Developed by vanessalatefapampilo
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReceivingThread extends  Thread{

    Client client;


    @Override
    public void run() {
        try {
            BufferedReader receive = new BufferedReader (new InputStreamReader (this.client.socket.getInputStream ()));

            while (client.isConnected) {
                String messageIn = receive.readLine ();
                 if (messageIn != null && !messageIn.equals ((client.userName + ": "))){
                     System.out.println (messageIn);
                 }
            }
                } catch(IOException e){
            e.printStackTrace ();
            }
    }

}

