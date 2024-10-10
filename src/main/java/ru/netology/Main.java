package ru.netology;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Из файла config.properties получаем PORT
        // "src/main/java/ru/netology/resources/config.properties"
        int PORT = new Config().getPORT();
        Server server = new Server(PORT);
        server.listen(PORT);
    }
}