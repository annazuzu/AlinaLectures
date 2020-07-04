package com.company.arrays;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExample {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        String st = " ";

        list.add("Первая");
        list.add("Вторая");
        list.add("Третья");

        for (String s: list) {
            st += s + " ";
            System.out.println(st);
        }
    }
}
