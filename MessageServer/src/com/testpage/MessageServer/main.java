package com.testpage.MessageServer;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by minmi on 2016-11-09.
 */
public class main {
    public static void main(String args[])throws Exception
    {
        int port = 6974;
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server is ready on " + port + "port.");

        Scanner scan = new Scanner(System.in);
        String data = new String();

        System.out.println("Waiting connection...");
        Socket client = server.accept();
        System.out.println("Connected with " + client.getInetAddress() + ":" + client.getLocalPort());

        OutputStream os = client.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);

        while((data = scan.nextLine()) != null )
        {
            if(data.equals("exit")) {
                dos.writeUTF("exit");
                break;
            }

            dos.writeUTF(data);
            System.out.println("Send a message to client");
        }
        dos.close();
        client.close();

    }
}
