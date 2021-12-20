package server;

import config.Config;

import java.net.*;
import java.io.*;

import requests.RequestHandler;

public class Server extends Thread {
    protected Socket clientSocket;

    public Server(String host, int ip) {
        Socket socket = null;
        try {
            socket = new Socket(host, ip);
        }catch(Exception e){System.out.println(e);}
        clientSocket = socket;
        start();
    }

    public static void init() {
        ServerSocket serverSocket = null;
        Config config = new Config();

        try {
            serverSocket = new ServerSocket(config.getPort());
            System.out.println("Connection Socket Created");
            try {
                while (true) {
                    System.out.println("Waiting for Connection");
                    new Thread(new RequestHandler(serverSocket.accept())).start();
                }
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port: 10008.");
            System.exit(1);
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                System.err.println("Could not close port: 10008.");
                System.exit(1);
            }
        }
    }

    public void run() {
        System.out.println("New Communication Thread Started");

        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),
                    true);
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    clientSocket.getInputStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                System.out.println("Server: " + inputLine);
                out.println(inputLine);

                if (inputLine.trim().equals(""))
                    break;
            }

            out.close();
            in.close();
            clientSocket.close();
        } catch (IOException e) {
            System.err.println("Problem with Communication Server");
            System.exit(1);
        }
    }
}