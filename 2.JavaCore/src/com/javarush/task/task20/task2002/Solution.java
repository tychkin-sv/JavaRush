package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = new File("2002.txt");//File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            //System.out.println("Создание пользователя");
            User user = new User();
            user.setFirstName("Сергей");
            user.setLastName("Тычкин");
            //System.out.println("Перед датой");
            Date date = new Date();

            user.setBirthDate(date);
            //System.out.println("После датой");
            user.setMale(true);
            user.setCountry(User.Country.UKRAINE);
            //System.out.println("добавление в массив");
            javaRush.users.add(user);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println("Users equals : " + javaRush.equals(loadedObject));
            for (User us: loadedObject.users){
                System.out.println(us.getFirstName());
                System.out.println(us.getLastName());
                System.out.println(us.getBirthDate());
                System.out.println(us.isMale());
                System.out.println(us.getCountry());
            }

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            // количество пользователей
            //System.out.println(users.size());
            printWriter.println(users.size());
            // записываем самих пользователей
            for (User user: users) {
                printWriter.println(user.getFirstName());
                printWriter.println(user.getLastName());

                Date date = user.getBirthDate();
                //SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                //String sDate = sdf.format(date);
                printWriter.println(date.getTime());
                printWriter.println(user.isMale());
                printWriter.println(user.getCountry().toString());
            }
            printWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int count = Integer.parseInt(reader.readLine());
            //System.out.println("load");
            for (int i = 0; i<count; i++) {
               User user = new User();
               user.setFirstName(reader.readLine());
               user.setLastName(reader.readLine());

               //SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
               //Date date = sdf.parse(reader.readLine());
               long uTime = Long.parseLong(reader.readLine());
               Date date = new Date(uTime);
               user.setBirthDate(date);
               user.setMale(Boolean.parseBoolean(reader.readLine()));
               user.setCountry(User.Country.valueOf(reader.readLine()));
               //System.out.println(user);
                users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
