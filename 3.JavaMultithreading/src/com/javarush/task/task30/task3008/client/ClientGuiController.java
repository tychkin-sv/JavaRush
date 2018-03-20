package com.javarush.task.task30.task3008.client;

/**
 * Created by TSV on 12.12.2017.
 */

/*
Чат (21)
У меня есть отличнейшая новость для тебя. Компонент представление (View) уже готов.
Я добавил класс ClientGuiView. Он использует библиотеку javax.swing.
Ты должен как следует разобраться в каждой строчке этого класса.
Если тебе все понятно – это замечательно, если нет – обязательно найди ответы на свои вопросы с помощью дебага,
документации или поиска в Интернет.
*/

// Осталось написать компонент контроллер (Controller):
// 21.1. Создай класс ClientGuiController унаследованный от Client!!.
public class ClientGuiController extends Client {

    // 21.2. Создай и инициализируй поле, отвечающее за модель ClientGuiModel model.
    private ClientGuiModel model = new ClientGuiModel();

    // 21.3. Создай и инициализируй поле, отвечающее за представление ClientGuiView view.
    // Подумай, что нужно передать в конструктор при инициализации объекта.
    private ClientGuiView view = new ClientGuiView(this);


    // 21.5. Переопредели методы в классе ClientGuiController:
    // 21.5.а) SocketThread getSocketThread() – должен создавать и возвращать объект типа GuiSocketThread.
    protected SocketThread getSocketThread(){
        return new GuiSocketThread();
    }

    // 21.5.б) void run() – должен получать объект SocketThread через метод getSocketThread() и вызывать
    // у него метод run(). Разберись, почему нет необходимости вызывать метод run в отдельном потоке,
    // как мы это делали для консольного клиента.
    public void run(){
        SocketThread socketThread = getSocketThread();
        socketThread.run();
    }

    // 21.5.в) getServerAddress(), getServerPort(), getUserName().
    // Они должны вызывать одноименные методы из представления (view).
    protected String getServerAddress(){
        return view.getServerAddress();
    }

    protected int getServerPort(){
        return view.getServerPort();
    }

    protected String getUserName(){
        return view.getUserName();
    }

    // 21.6. Реализуй метод ClientGuiModel getModel(), который должен возвращать модель.
    public ClientGuiModel getModel(){
        return model;
    }

    // 21.7. Реализуй метод main(), который должен создавать новый объект ClientGuiController и вызывать у него метод run().
    // Запусти клиента с графическим окном, нескольких консольных клиентов и убедись, что
    // все работает корректно.
    public static void main(String[] args) {
        new ClientGuiController().run();
    }


    // 21.4. Добавь внутренний класс GuiSocketThread унаследованный от SocketThread.
    // Класс GuiSocketThread должен быть публичным. В нем переопредели следующие методы:
    public class GuiSocketThread extends SocketThread {
        // 21.4.а. void processIncomingMessage(String message) – должен устанавливать новое сообщение
        // у модели и вызывать обновление вывода сообщений у представления.
        @Override
        protected void processIncomingMessage(String message){
            model.setNewMessage(message);
            view.refreshMessages();
        }

        // 21.4.б. void informAboutAddingNewUser(String userName) – должен добавлять нового пользователя
        // в модель и вызывать обновление вывода пользователей у отображения.
        protected void informAboutAddingNewUser(String userName){
            model.addUser(userName);
            view.refreshUsers();
        }

        // 21.4.в. void informAboutDeletingNewUser(String userName) – должен удалять пользователя из модели
        // и вызывать обновление вывода пользователей у отображения.
        protected void informAboutDeletingNewUser(String userName){
            model.deleteUser(userName);
            view.refreshUsers();
        }
        // 21.4.г. void notifyConnectionStatusChanged(boolean clientConnected) – должен вызывать аналогичный
        // метод у представления.
        protected void notifyConnectionStatusChanged(boolean clientConnected){
            view.notifyConnectionStatusChanged(clientConnected);
        }


    }

}
