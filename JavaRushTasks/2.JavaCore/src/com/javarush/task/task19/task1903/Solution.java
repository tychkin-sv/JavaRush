package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static void main(String[] args) {
IncomeData incomeData = new IncomeData() {
    @Override
    public String getCountryCode() {
        return "UA";
    }

    @Override
    public String getCompany() {
        return "JavaRush Ltd.";
    }

    @Override
    public String getContactFirstName() {
        return "Ivan";
    }

    @Override
    public String getContactLastName() {
        return "Ivanov";
    }

    @Override
    public int getCountryPhoneCode() {
        return 38;
    }

    @Override
    public int getPhoneNumber() {
        return 501234567;
    }
};

        IncomeDataAdapter adapter = new IncomeDataAdapter(incomeData);
        System.out.println(adapter.getCompanyName());
        System.out.println(adapter.getCountryName());
        System.out.println(adapter.getName());
        System.out.println(adapter.getPhoneNumber());
    }

    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        //example JavaRush Ltd.
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        //example Ukraine
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        //example Ivanov, Ivan
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        //example +38(050)123-45-67
        public String getPhoneNumber() {
            String zero = "0000000000";
            String sourcePhone = String.valueOf(data.getPhoneNumber());
            String sPhone = (zero+sourcePhone);
            System.out.println(sPhone);
            int len = sPhone.length();

            sPhone = sPhone.substring(len-10);
            System.out.println(sPhone);

            String s1 = sPhone.substring(0,3);
            String s2 = sPhone.substring(3,6);
            String s3 = sPhone.substring(6,8);
            String s4 = sPhone.substring(8,10);
            return "+" + data.getCountryPhoneCode()+"("+ s1+ ")"+s2+"-"+s3+"-"+s4;
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }


}