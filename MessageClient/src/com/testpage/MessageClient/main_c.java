package com.testpage.MessageClient;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created by minmi on 2016-11-09.
 */
public class main_c {

    public static void main(String args[]) throws Exception
    {
        String serverIP = "127.0.0.1";
        int port = 6974;
        System.out.println("Connect to " + serverIP + ":" + String.valueOf(port));
        Socket server = new Socket(serverIP, port);

        InputStream is = server.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        System.out.println("not problem");


        String data = null;
        do
        {
            data = dis.readUTF();
            System.out.println("Server : " + data);
        }while(!data.equals("exit"));
        System.out.println("Disconnect with server.");
        dis.close();
        server.close();
    }
}