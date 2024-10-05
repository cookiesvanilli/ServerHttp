package ru.netology;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    final int THREADCOUNT = 64;
    ExecutorService service = Executors.newFixedThreadPool(THREADCOUNT);

    public void listen(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                final var socket = serverSocket.accept();
                System.out.println(socket);
                Handler handler = new Handler(socket);
                service.submit(handler);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
