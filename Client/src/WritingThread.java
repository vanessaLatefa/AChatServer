/*
 * Copyright (c) 2018.
 * Developed by vanessalatefapampilo
 */

import java.io.PrintWriter;
import java.util.Scanner;

public class WritingThread extends Thread {

         Client client;
        private PrintWriter print = null;
        Scanner in = new Scanner(System.in);



        @Override
        public void run() {
            try {
                print = new PrintWriter (client.socket.getOutputStream (), true);
                this.print.println (client.userName + "\n");
                this.print.flush ();

                while (client.isConnected) {
                    String msg = in.nextLine () + "\n";
                   this.print.println (client.userName + ":" + msg);
                    this.print.flush ();
                    sleep (100);
                    if (msg.equals ("EXIT")) {
                        System.out.println ("-----------------------------------------");
                        System.out.println ("DISCONNECTING");
                        this.client.isConnected = false;
                        break;
                    }
            }
            }catch(Exception e){
                System.out.println (e.getMessage ());
            }
        }
        //end run method

    }

