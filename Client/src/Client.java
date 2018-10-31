/*
 * Copyright (c) 2018.
 * Developed by vanessalatefapampilo
 */

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static Socket socket;
    public static String userName;
    public static boolean isConnected = true;


    public Client (Socket socket){
        this.socket = socket;
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        Client client = new Client (socket = new Socket ("localhost", 3001));
        client.startClient ();

    }

    public void startClient () throws InterruptedException {
        System.out.println ("You are connected to the chat group");
        System.out.println ("-------------------------------------------------------");
      isConnected = true;

        ReceivingThread receive =  new ReceivingThread ();
        WritingThread write = new WritingThread ();

        userName = getUserNameFromClient ();

        write.start ();

        System.out.println("You will appear on the chat list as: " + userName);

        receive.start ();
        Thread.sleep (500);

        System.out.println("Start chatting now!");

            while (isConnected){
                Thread.sleep (100);
            }

            write.interrupt ();
            receive.interrupt ();

    }

    public static String getUserNameFromClient(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("type in your username to get it started:");
        String userName = scanner.nextLine();

        return userName;
    }


}







