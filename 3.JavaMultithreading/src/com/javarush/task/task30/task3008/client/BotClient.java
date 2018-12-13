package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {
    @Override
    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() throws IOException {
        int x = (int)(Math.random()*100);
        return "date_bot_" + x;
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends SocketThread{
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
//            String[] data = message.split(": ");
//            SimpleDateFormat dateFormat = null;
//            if (data.length == 2) {
//                String userQuestion = data[1];
//                switch (userQuestion) {
//                    case "дата":
//                        dateFormat = new SimpleDateFormat("d.MM.YYYY");
//                        break;
//                    case "день":
//                        dateFormat = new SimpleDateFormat("d");
//                        break;
//                    case "месяц":
//                        dateFormat = new SimpleDateFormat("MMMM");
//                        break;
//                    case "год":
//                        dateFormat = new SimpleDateFormat("YYYY");
//                        break;
//                    case "время":
//                        dateFormat = new SimpleDateFormat("H:mm:ss");
//                        break;
//                    case "час":
//                        dateFormat = new SimpleDateFormat("H");
//                        break;
//                    case "минуты":
//                        dateFormat = new SimpleDateFormat("m");
//                        break;
//                    case "секунды":
//                        dateFormat = new SimpleDateFormat("s");
//                        break;
//                }
//            }
//            if (dateFormat != null) {
//                String dateString = dateFormat.format(Calendar.getInstance().getTime());
//                String botAnswer = String.format("Информация для %s: %s", data[0], dateString);
//                sendTextMessage(botAnswer);
//            }
            String[] mas = message.split(": ");
            String name = null;
            String messege = null;
            if(mas.length == 2) {
                name = mas[0];
                messege = mas[1];
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("d.MM.YYYY");
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("d");
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("MMMM");
            SimpleDateFormat dateFormat3 = new SimpleDateFormat("YYYY");
            SimpleDateFormat dateFormat4 = new SimpleDateFormat("H:mm:ss");
            SimpleDateFormat dateFormat5 = new SimpleDateFormat("H");
            SimpleDateFormat dateFormat6 = new SimpleDateFormat("m");
            SimpleDateFormat dateFormat7 = new SimpleDateFormat("s");
            Calendar calendar = Calendar.getInstance();
            if(name != null && messege != null) {
                if (messege.equals("дата"))
                    sendTextMessage("Информация для " + name + ": " + dateFormat.format(calendar.getTime()));
                else if (messege.equals("день"))
                    sendTextMessage("Информация для " + name + ": " + dateFormat1.format(calendar.getTime()));
                else if (messege.equals("месяц"))
                    sendTextMessage("Информация для " + name + ": " + dateFormat2.format(calendar.getTime()));
                else if (messege.equals("год"))
                    sendTextMessage("Информация для " + name + ": " + dateFormat3.format(calendar.getTime()));
                else if (messege.equals("время"))
                    sendTextMessage("Информация для " + name + ": " + dateFormat4.format(calendar.getTime()));
                else if (messege.equals("час"))
                    sendTextMessage("Информация для " + name + ": " + dateFormat5.format(calendar.getTime()));
                else if (messege.equals("минуты"))
                    sendTextMessage("Информация для " + name + ": " + dateFormat6.format(calendar.getTime()));
                else if (messege.equals("секунды"))
                    sendTextMessage("Информация для " + name + ": " + dateFormat7.format(calendar.getTime()));


            }
        }
    }
}
