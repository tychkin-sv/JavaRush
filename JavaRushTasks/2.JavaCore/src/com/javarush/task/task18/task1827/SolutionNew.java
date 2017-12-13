package com.javarush.task.task18.task1827;
/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле
В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины
Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/
import java.io.*;
public class SolutionNew {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(reader.readLine());
        reader.close();
        if (args[0].equals("-c"))
            add(file, args);
    }
    public static void add(File fileName, String[] arg) throws IOException
    {
        int id = getId(fileName);
        int lineLenght = 50;
        StringBuilder line = new StringBuilder();
        line.setLength(lineLenght);
        line.insert(0, id);
        if (arg[1].length()>30)
            line.insert(8, arg[1].substring(0,30));
        else
            line.insert(8, arg[1]);
        line.insert(38, arg[2].substring(0,8));
        line.insert(46, arg[3].substring(0,4));
        FileWriter file = new FileWriter(fileName,true);
        file.write(System.getProperty("line.separator"));
        file.write(line.substring(0,lineLenght).toString());
        file.close();
    }
    public static int getId(File fileName) throws IOException
    {
        int howParseChar = 8;
        BufferedReader file = new BufferedReader(new FileReader(fileName));
        String s = file.readLine();
        String getId;
        int maxId=0;
        int nowId=0;
        while (s!=null)
        {
            try{
                getId = s.substring(0, howParseChar).trim();
                nowId = Integer.parseInt(getId);
                maxId = maxId > nowId ? maxId : nowId;
            }catch (NumberFormatException e){}
            catch(StringIndexOutOfBoundsException e){}
            s=file.readLine();
        }
        file.close();
        return ++maxId;
    }
}