package kz.tallgram.ClientServerTcp;

import java.net.*;
import java.io.*;

/**
 * Created by Alen on 08.05.2020.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", 8008);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        writer.write("Hello Server");
        writer.newLine();
        writer.flush();

        String response = reader.readLine();
        System.out.println(response);

        writer.close();
        reader.close();
        clientSocket.close();
    }
}
