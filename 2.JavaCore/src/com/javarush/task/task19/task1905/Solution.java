package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();

    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static void main(String[] args) {

       // String[] s = "Ivanov, Ivan".split(",");
       //System.out.println(s[0].trim());
       // System.out.println(s[1].trim());
        Contact contact = new Contact() {
            @Override
            public String getName() {
                return "Ivanov, Ivan";
            }

            @Override
            public String getPhoneNumber() {
                return "+38(050)123-45-67";
            }
        };

        Customer customer =  new Customer() {
            @Override
            public String getCompanyName() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getCountryName() {
                return "Ukraine";
            }
        };
        //String getCountryCode();        //example UA
        //String getCompany();            //example JavaRush Ltd.
        //String getContactFirstName();   //example Ivan
        //String getContactLastName();    //example Ivanov
        //String getDialString();         //example callto://+380501234567
        DataAdapter adapter = new DataAdapter(customer, contact);
        System.out.println(adapter.getCountryCode());
        System.out.println(adapter.getCompany());
        System.out.println(adapter.getContactFirstName());
        System.out.println(adapter.getContactLastName());
        System.out.println(adapter.getDialString());


    }

    public static class DataAdapter implements RowItem{
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        //example UA
        public String getCountryCode() {
            String countryCode="";
            for (Map.Entry<String, String> pair: countries.entrySet()){
                if (pair.getValue().equals(customer.getCountryName())) {
                    countryCode = pair.getKey();
                    break;
                }
            }
            return countryCode;
        }

        @Override
        //example JavaRush Ltd.
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        //example Ivan
        public String getContactFirstName() {
            return contact.getName().split(",")[1].trim();
        }

        @Override
        //example Ivanov
        public String getContactLastName() {
            return contact.getName().split(",")[0].trim();
        }

        @Override
        //example callto://+380501234567
        public String getDialString() {
            String source = contact.getPhoneNumber();
            StringBuilder sb= new StringBuilder();
            sb.append("callto://+");
            for (int i= 0; i<source.length(); i++){
                if (Character.isDigit(source.charAt(i))) sb.append(source.charAt(i));
            }
            return sb.toString();
        }
    }


    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
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