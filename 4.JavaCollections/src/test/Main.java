package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by TSV on 18.09.2017.
 */
public class Main {
    public static void main(String[] args) {
        Integer[] values1 = { 1, 3, 7 };
        List<Integer> listWrite = new ArrayList<Integer>(Arrays.asList(values1));
        System.out.println(listWrite.get(0).getClass());
        listWrite.add(1);

        Integer[] values2 = { 1, 3, 7 };
        List<Integer> list = Arrays.asList(values2);
        System.out.println(list.size());
        // Cannot
        // list.add(1);
        //System.out.println(list.get(0).getClass());
        List<Integer> listForEdit = new ArrayList<>(list);
        // But can do in this case
        listForEdit.add(1);



    }
}
