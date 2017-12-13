/*1. Класс Client должен быть создан в пакете client.*/
package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

/*
Чат (12)
Приступим к написанию клиента.
Клиент, в начале своей работы, должен запросить у пользователя адрес и порт сервера,
подсоединиться к указанному адресу, получить запрос имени от сервера, спросить имя у пользователя,
отправить имя пользователя серверу, дождаться принятия имени сервером.
После этого клиент может обмениваться текстовыми сообщениями с сервером.
Обмен сообщениями будет происходить в двух параллельно работающих потоках.
Один будет заниматься чтением из консоли и отправкой прочитанного серверу,
а второй поток будет получать данные от сервера и выводить их в консоль.
Начнем реализацию клиента:

Чат (13)
Продолжаем реализацию вспомогательных методов класса Client.

Чат (14)
Приступим к написанию главного функционала класса Client.

Чат (15)
Напишем реализацию класса SocketThread. Начнем с простых вспомогательных методов.
Добавь методы, которые будут доступны классам потомкам и не доступны остальным классам вне пакета:

Чат (16)
Теперь все готово, чтобы дописать необходимые методы класса SocketThread.

Чат (17)
Последний, но самый главный метод класса SocketThread – это метод void run(). Добавь его.
Его реализация с учетом уже созданных методов выглядит очень просто.
*/

public class Client {
    // 12.3. В классе Client должно быть создано protected поле connection типа Connection.
    protected Connection connection;
    // 12.4. В классе Client должно быть создано private volatile поле clientConnected типа boolean.
    private volatile boolean clientConnected = false;

    // 13.1. String getServerAddress() – должен запросить ввод адреса сервера у пользователя и вернуть введенное значение.
    // Адрес может быть строкой, содержащей ip, если клиент и сервер запущен на разных машинах или ‘localhost’,
    // если клиент и сервер работают на одной машине.
    protected String getServerAddress(){
        ConsoleHelper.writeMessage("Введите адрес сервера :");
        return ConsoleHelper.readString();
    }

    // 13.2. int getServerPort() – должен запрашивать ввод порта сервера и возвращать его.
    protected int getServerPort(){
        ConsoleHelper.writeMessage("Введите порт :");
        return ConsoleHelper.readInt();
    }

    // 13.3. String getUserName() – должен запрашивать и возвращать имя пользователя.
    protected String getUserName(){
        ConsoleHelper.writeMessage("Введите свое имя :");
        return ConsoleHelper.readString();
    }

    // 13.4. boolean shouldSendTextFromConsole() – в данной реализации клиента всегда должен возвращать true
    // мы всегда отправляем текст введенный в консоль). Этот метод может быть переопределен,
    // если мы будем писать какой-нибудь другой клиент, унаследованный от нашего, который не должен отправлять
    // введенный в консоль текст.

    protected boolean shouldSendTextFromConsole(){
        return true;
    }

    // 13.5. SocketThread getSocketThread() – должен создавать и возвращать новый объект класса SocketThread.
    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    // 13.6. void sendTextMessage(String text) – создает новое текстовое сообщение,
    // используя переданный текст и отправляет его серверу через соединение connection.
    // Если во время отправки произошло исключение IOException, то необходимо вывести
    // информацию об этом пользователю и присвоить false полю clientConnected.
    protected void sendTextMessage(String text){

        try {
            Message message = new Message(MessageType.TEXT, text);
            connection.send(message);
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Что-то не так!");
            clientConnected = false;
        }
    }

    public void run(){
        // 14.2. Метод run должен создавать запускать новый поток, полученный с помощью метода getSocketThread.
        SocketThread socketThread = getSocketThread();
        // 14.3. Поток созданный с помощью метода getSocketThread должен быть отмечен как демон (setDaemon(true)).
        socketThread.setDaemon(true);
        socketThread.start();

        // 14.4. После запуска нового socketThread метод run должен ожидать до тех пор, пока не будет пробужден.
        try {
            // !!!!!!
            synchronized (this) {
                this.wait();
            }
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Client.run error");
        }

        if (clientConnected){
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        }
        else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }

        // 14.5. До тех пор, пока флаг clientConnected равен true,с консоли должны считываться сообщения
        // с помощью метода ConsoleHelper.readString.
     while (clientConnected){
            ConsoleHelper.writeMessage("Введите сообщение :");
            String messageText = ConsoleHelper.readString();

            // 14.6. Если была введена команда "exit" цикл считывания сообщений должен быть прерван.
            if (messageText.equals("exit")) break;

            // 14.7. Если метод shouldSentTextFromConsole возвращает true,
            // должен быть вызван метод sendTextMessage со считанным текстом в качестве параметра.
            if (shouldSendTextFromConsole()) {
                sendTextMessage(messageText);
            }

        }
    }

    // 14.1. Добавь метод main(). Он должен создавать новый объект типа Client и вызывать у него метод run().
    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }



    // 12.2. В классе Client должен быть создан публичный класс SocketThread унаследованный от Thread.
    public class SocketThread extends Thread{

        // 15.1. void processIncomingMessage(String message) – должен выводить текст message в консоль.
        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }

        // 15.2. void informAboutAddingNewUser(String userName) – должен выводить в консоль информацию о том,
        // что участник с именем userName присоединился к чату.
        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage("Участник " + userName + " присоединился к чату.");
        }

        // 15.3. void informAboutDeletingNewUser(String userName) – должен выводить в консоль,
        // что участник с именем userName покинул чат.
        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage("Участник " + userName + " покинул чат.");
        }

        // 15.4. void notifyConnectionStatusChanged(boolean clientConnected) – этот метод должен:
        // а) Устанавливать значение поля clientConnected внешнего объекта Client в соответствии с переданным параметром.
        // б) Оповещать (пробуждать ожидающий) основной поток класса Client.
        // Подсказка: используй синхронизацию на уровне текущего объекта внешнего класса и метод notify. Для класса SocketThread внешним классом является класс Client.
        protected void notifyConnectionStatusChanged(boolean clientConnected){
            synchronized (Client.this) {
                Client.this.clientConnected = clientConnected;
                Client.this.notify();
            }
        }

        // 16.1. Добавь protected метод clientHandshake() throws IOException, ClassNotFoundException.
        // Этот метод будет представлять клиента серверу.
        protected void clientHandshake() throws IOException, ClassNotFoundException{
            // 16.1.а. В цикле получать сообщения, используя соединение connection.
            while (true){

                Message receiveMessage = connection.receive();
                MessageType messageType = receiveMessage.getType();


                // 16.1.б) Если тип полученного сообщения NAME_REQUEST (сервер запросил имя),
                // запросить ввод имени пользователя с помощью метода getUserName(),
                // создать новое сообщение с типом MessageType.USER_NAME и введенным именем,
                // отправить сообщение серверу.
                if (messageType==MessageType.NAME_REQUEST) {
                    Message responce = new Message(MessageType.USER_NAME, getUserName());
                    connection.send(responce);
                } else
                    // 16.1.в. Если тип полученного сообщения MessageType.NAME_ACCEPTED (сервер принял имя),
                    // значит сервер принял имя клиента, нужно об этом сообщить главному потоку, он этого очень ждет.
                    // Сделай это с помощью метода notifyConnectionStatusChanged(), передав в него true.
                    // После этого выйди из метода.
                if (messageType==MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    break;
                } else
                    // 16.1.г. Если пришло сообщение с каким-либо другим типом,
                    // кинь исключение IOException("Unexpected MessageType").
                throw new IOException("Unexpected MessageType");

                }
            }
        // 16.2.2. Добавь protected метод void clientMainLoop() throws IOException, ClassNotFoundException.
        // Этот метод будет реализовывать главный цикл обработки сообщений сервера.
        // Внутри метода:
        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            while (true) {
                // 16.2.а. Получи сообщение от сервера, используя соединение connection.
                Message receiveMessage = connection.receive();
                MessageType messageType = receiveMessage.getType();
                // 16.2.б. Если это текстовое сообщение (тип MessageType.TEXT), обработай его с помощью метода processIncomingMessage().
                if (messageType == MessageType.TEXT) {
                    processIncomingMessage(receiveMessage.getData());

                } else
                    // 16.2.в. Если это сообщение с типом MessageType.USER_ADDED,
                    // обработай его с помощью метода informAboutAddingNewUser().
                    if (messageType == MessageType.USER_ADDED) {
                        informAboutAddingNewUser(receiveMessage.getData());
                    } else
                        // 16.2.г) Если это сообщение с типом MessageType.USER_REMOVED,
                        // обработай его с помощью метода informAboutDeletingNewUser().
                        if (messageType == MessageType.USER_REMOVED) {
                            informAboutDeletingNewUser(receiveMessage.getData());
                        } else {
                            throw new IOException("Unexpected MessageType");
                        }
            }


        }

        public void run(){
            // 17.1. Запроси адрес и порт сервера с помощью методов getServerAddress() и getServerPort().
            String serverAddress = getServerAddress();
            int serverPort = getServerPort();
             try {
                // 17.2. Создай новый объект класса java.net.Socket, используя данные, полученные в предыдущем пункте.

                Socket socket = new Socket(serverAddress, serverPort);
                // 17.3. Создай объект класса Connection, используя сокет из п.17.2.
                connection = new Connection(socket);
                // 17.4. Вызови метод, реализующий "рукопожатие" клиента с сервером (clientHandshake()).
                clientHandshake();
                // 17.5. Вызови метод, реализующий основной цикл обработки сообщений сервера.
                clientMainLoop();

                } catch (ClassNotFoundException | IOException e) {
                    // 17.6. При возникновении исключений IOException или ClassNotFoundException
                    // сообщи главному потоку о проблеме, используя notifyConnectionStatusChanged
                    // и false в качестве параметра.
                    this.notifyConnectionStatusChanged(false);
                }
        }
        }


    }

