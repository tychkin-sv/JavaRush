package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/*
Чат (6)
Приступим к самому важному – написанию класса Server. Сервер должен поддерживать
множество соединений с разными клиентами одновременно. Это можно реализовать с
помощью следующего алгоритма:
- Сервер создает серверное сокетное соединение.
- В цикле ожидает, когда какой-то клиент подключится к сокету.
- Создает новый поток обработчик Handler, в котором будет происходить обмен
сообщениями с клиентом.
- Ожидает следующее соединение.

Чат (7)
Т.к. сервер может одновременно работать с несколькими клиентами, нам понадобится
метод для отправки сообщения сразу всем.

Чат (8)
Класс Handler должен реализовывать протокол общения с клиентом.
Выделим из протокола отдельные этапы и реализуем их с помощью отдельных методов:
Этап первый – это этап рукопожатия (знакомства сервера с клиентом). Реализуем его с
помощью приватного метода String serverHandshake(Connection connection) throws IOException,
ClassNotFoundException. Метод в качестве параметра принимает соединение connection, а возвращает имя нового клиента.

Чат (9)
Этап второй, но не менее важный – отправка клиенту (новому участнику) информации об
остальных клиентах (участниках) чата.

Чат (10)
Этап третий – главный цикл обработки сообщений сервером.
Добавь приватный метод void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException, где значение параметров такое же, как и у метода
sendListOfUsers.

Чат (11)
Пришло время написать главный метод класса Handler, который будет вызывать все
вспомогательные методы, написанные ранее. Реализуем метод void run() в классе Handler.
*/


public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    // 6.1. В класс Server приватный статический вложенный класс Handler, унаследованный от Thread.
    private static class Handler extends Thread{
        // 6.2. В класс Handler поле socket типа Socket.
        private Socket socket;
        // 6.3. В класс Handler конструктор, принимающий в качестве параметра Socket
        // и инициализирующий им соответствующее поле класса.
        public Handler(Socket socket){
            this.socket = socket;
        }


        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            //String result = "";
            do {
                // 1) Сформировать и отправить команду запроса имени пользователя
                Message message = new Message(MessageType.NAME_REQUEST);
                connection.send(message);

                // 2) Получить ответ клиента
                Message receiveMessage = connection.receive();

                // 3) Проверить, что получена команда с именем пользователя
                MessageType type = receiveMessage.getType();
                if (type == MessageType.USER_NAME) {

                    // 4) Достать из ответа имя, проверить, что оно не пустое и пользователь
                    // с таким именем еще не подключен (используй connectionMap)
                    String data = receiveMessage.getData();
                    if (!data.isEmpty() && !connectionMap.containsKey(data)) {
                        // 5) Добавить нового пользователя и соединение с ним в connectionMap
                        connectionMap.put(data, connection);

                        // 6) Отправить клиенту команду информирующую, что его имя принято
                        message = new Message(MessageType.NAME_ACCEPTED);
                        connection.send(message);
                        // 8) Вернуть принятое имя в качестве возвращаемого значения
                        return data;
                    }

                }
                // 7) Если какая-то проверка не прошла, заново запросить имя клиента
            } while (true); // бесконечный цикл
        }

        // 1) Добавь приватный метод void sendListOfUsers(Connection connection, String userName)
        //   throws IOException
        // , где connection – соединение с участником, которому будем слать информацию,
        // а userName – его имя. Метод должен:
        private void sendListOfUsers(Connection connection, String userName) throws IOException{

            // 2) Пройтись по connectionMap.
            for (Map.Entry<String, Connection> pair : connectionMap.entrySet()) {


                // 3) У каждого элемента из п.2 получить имя клиента,
                // сформировать команду с типом USER_ADDED и полученным именем.
                // 4) Отправить сформированную команду через connection.
                String user = pair.getKey();

                // 5) Команду с типом USER_ADDED и именем равным userName отправлять не нужно,
                // пользователь и так имеет информацию о себе.
                if (!user.equals(userName)) connection.send(new Message(MessageType.USER_ADDED, user));
            }

        }

        // 10. Добавь приватный метод void serverMainLoop(Connection connection, String userName)
        // throws IOException, ClassNotFoundException
        private void serverMainLoop(Connection connection, String userName)
                throws IOException, ClassNotFoundException {

            while (true) {
                // 10.1. Принимать сообщение клиента
                Message message = connection.receive();

                // 10.2. Если принятое сообщение – это текст (тип TEXT),
                // то формировать новое текстовое сообщение путем конкатенации:
                // имени клиента, двоеточия, пробела и текста сообщения.
                // Например, если мы получили сообщение с текстом «привет чат»
                // от пользователя «Боб«, то нужно сформировать сообщение «Боб: привет чат«.
                if (message.getType() == MessageType.TEXT) {
                    String reply = userName + ": " + message.getData();

                    // 10.3. Отправлять сформированное сообщение всем клиентам с помощью метода sendBroadcastMessage
                    Server.sendBroadcastMessage(new Message(MessageType.TEXT, reply));
                } else {
                    // 10.4. Если принятое сообщение не является текстом, вывести сообщение об ошибке
                    ConsoleHelper.writeMessage("error");
                }
            }
        }

        @Override
        public void run() {
           // 11.1. Метод run должен выводить на экран сообщение о том, что было установлено соединение
           // с удаленным адресом (используя метод getRemoteSocketAddress).
           ConsoleHelper.writeMessage("Установлено соединение с " + socket.getRemoteSocketAddress());
            String userName = null;

            //  11.2. Метод run должен создавать новое соединение (connection) используя в качестве параметра поле socket.
            try {
                Connection connection = new Connection(socket);

                // 11.3. Метод run должен вызывать метод serverHandshake используя в качестве параметра
                // только что созданное соединение; результатом будет имя пользователя (userName).
                userName=serverHandshake(connection);

                // 11.4. Метод run должен вызывать метод sendBroadcastMessage используя в качестве параметра
                // новое сообщение (MessageType.USER_ADDED, userName).
                Server.sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));

                // 11.5. Метод run должен вызывать метод sendListOfUsers используя в качестве параметров connection и userName.
                sendListOfUsers(connection, userName);

                // 11.6. Метод run должен вызывать метод serverMainLoop используя в качестве параметров connection и userName.
                serverMainLoop(connection,userName);


            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            finally {
                // 11.7. Прежде чем завершиться, метод run должен удалять из connectionMap запись
                // соответствующую userName, и отправлять всем участникам чата сообщение о том,
                // что текущий пользователь был удален.
                if (userName!=null) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
            }

        }
    }

    // 7.3. Статический метод void sendBroadcastMessage(Message message), который должен
    // отправлять сообщение message всем соединениям из connectionMap. Если при
    // отправке сообщение произойдет исключение IOException, нужно отловить его и
    // сообщить пользователю, что не смогли отправить сообщение.
    public static void sendBroadcastMessage(Message message){
        for (Map.Entry<String, Connection> pair: connectionMap.entrySet()){
            try {
                pair.getValue().send(message);
            } catch (IOException e) {
                e.printStackTrace();
                ConsoleHelper.writeMessage("Cannot send message to user " + pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
        // 6.4.а. Запрашивать порт сервера, используя ConsoleHelper.
        int port = ConsoleHelper.readInt();

        // 6.4.б. Создавать серверный сокет java.net.ServerSocket, используя порт из предыдущего пункта.
        // 6.4.ж. Предусмотреть закрытие серверного сокета в случае возникновения исключения.
        // !!TS: ServerSocket implements Closable
        try (ServerSocket serverSocket = new ServerSocket(port);){

            // 6.4.в. Выводить сообщение, что сервер запущен.
            System.out.println("Server is running");

            // 6.4.г. В бесконечном цикле слушать и принимать входящие сокетные соединения только что созданного
            // серверного сокета.
            while (true){
                Socket socket = serverSocket.accept();
                // 6.4.д. Создавать и запускать новый поток Handler, передавая в конструктор сокет из предыдущего пункта.
                Handler handler = new Handler(socket);
                handler.start();
                // 6.4.е. После создания потока обработчика Handler переходить на новый шаг цикла.
            }
        }
        // 6.4.з. Если исключение Exception все же произошло, поймать его и вывести сообщение об ошибке.
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
