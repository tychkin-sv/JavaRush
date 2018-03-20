package com.javarush.task.task30.task3008.client;


/*
Чат (18)
Иногда бывают моменты, что не находится достойного собеседника.
Не общаться же с самим собой :). Давай напишем бота, который будет представлять собой клиента,
который автоматически будет отвечать на некоторые команды.
Проще всего реализовать бота, который сможет отправлять текущее время или дату,
когда его кто-то об этом попросит.

Чат (19)
Сейчас будем реализовывать класс BotSocketThread, вернее переопределять некоторые его методы,
весь основной функционал он уже унаследовал от SocketThread.
*/


import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

// 18.1. Создай новый класс BotClient в пакете client. Он должен быть унаследован от Client.
public class BotClient extends Client{

    // 18.2. 2) В классе BotClient создай внутренний класс BotSocketThread унаследованный от SocketThread.
    // Класс BotSocketThread должен быть публичным.
    public class BotSocketThread extends Client.SocketThread{
        // 19.1. Переопредели метод clientMainLoop():
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            // 19.1.а. С помощью метода sendTextMessage() отправь сообщение с текстом
            // "Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды."
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            // 19.1.б. Вызови реализацию clientMainLoop() родительского класса.
            super.clientMainLoop();
        }
        // 19.2. Переопредели метод processIncomingMessage(String message).
        // Он должен следующим образом обрабатывать входящие сообщения:
        @Override
        protected void processIncomingMessage(String message) {
            // 19.2.а. Вывести в консоль текст полученного сообщения message.
            ConsoleHelper.writeMessage(message);
            // 19.2.б. Получить из message имя отправителя и текст сообщения. Они разделены ": ".
            if (message.contains(": ")){
            String[] data = message.split(": ");

            if (data.length == 2 && data[1] != null) {
            String userName = data[0];
            String text = data[1];

            SimpleDateFormat sdf = null;
            // 19.2.в. Отправить ответ в зависимости от текста принятого сообщения.

            switch (text) {
                case "дата":
                    sdf = new SimpleDateFormat("d.MM.YYYY");
                    break;
                case "день":
                    sdf = new SimpleDateFormat("d");
                    break;
                case "месяц":
                    sdf = new SimpleDateFormat("MMMM");
                    break;
                case "год":
                    sdf = new SimpleDateFormat("YYYY");
                    break;
                case "время":
                    sdf = new SimpleDateFormat("H:mm:ss");
                    break;
                case "час":
                    sdf = new SimpleDateFormat("H");
                    break;
                case "минуты":
                    sdf = new SimpleDateFormat("m");
                    break;
                case "секунды":
                    sdf = new SimpleDateFormat("s");
                    break;
            }
            if (sdf != null) {
                sendTextMessage(String.format("Информация для %s: %s", userName, sdf.format(Calendar.getInstance().getTime())));
            }
            }
            }

        }
    }

    // 18.3. Переопредели методы:
    // 18.3.а. getSocketThread(). Он должен создавать и возвращать объект класса BotSocketThread.
    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    // 18.3.б. shouldSendTextFromConsole(). Он должен всегда возвращать false.
    // Мы не хотим, чтобы бот отправлял текст введенный в консоль.
    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    // 18.3.в. getUserName(), метод должен генерировать новое имя бота, например: date_bot_X,
    // где X – любое число от 0 до 99. Для генерации X используй метод Math.random().
    @Override
    protected String getUserName() {
        return "date_bot_"+ ((int) (100*Math.random()));
    }

    // 18.4. Добавь метод main. Он должен создавать новый объект BotClient и вызывать у него метод run().
    public static void main(String[] args) {
        Client botClient = new BotClient();
        botClient.run();
    }

}
