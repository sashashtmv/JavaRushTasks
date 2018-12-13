package com.javarush.task.task30.task3008;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();


    public static void sendBroadcastMessage(Message message){
        for(Map.Entry<String, Connection> con : connectionMap.entrySet()){
            try {
                con.getValue().send(message);
            } catch (IOException e) {
                System.out.println("Connection Error");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(ConsoleHelper.readInt());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Server started..");

            try {
        while(true) {
                Socket socket = serverSocket.accept();

                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (IOException e) {
                System.out.println(e + " произошла ошибка.");
                serverSocket.close();
            }
        
    }

    private static class Handler extends Thread{
        private Socket socket;
        public Handler(Socket socket){
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            while (true){
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message answer = connection.receive();
                if (answer.getType() == MessageType.USER_NAME){
                    if (!answer.getData().isEmpty()){
                        if (!connectionMap.containsKey(answer.getData())){
                            connectionMap.put(answer.getData(), connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return answer.getData();
                        }
                    }
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException{
            for(String name : connectionMap.keySet()){
                try {
                    if(!name.equals(userName))
                    connection.send(new Message(MessageType.USER_ADDED, name));
                } catch (IOException e) {

                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true){
                Message message = connection.receive();
                if(message.getType() == MessageType.TEXT){
                    Server.sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
                } else {
                    ConsoleHelper.writeMessage("Error!");
                }
            }
        }

        public void run(){
            String name = null;
            //Connection con = null;
            System.out.println("Установлено соединение с удаленным адресом " + socket.getRemoteSocketAddress());
            try(Connection con = new Connection(socket)) {

                name = serverHandshake(con);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, name));
                sendListOfUsers(con, name);
                serverMainLoop(con, name);
                connectionMap.remove(name);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, name));

            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Error!");

                e.printStackTrace();

            }
        }
    }
}
