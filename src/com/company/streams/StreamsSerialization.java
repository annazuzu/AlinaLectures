package com.company.streams;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class StreamsSerialization {
    public static void main(String[] args) throws Exception {

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Object objSave = 1;

        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(objSave);

        //Чтобы увидеть, во что превратился объект objSave, можно просмотреть содержимое массива:

        byte[] bArray = os.toByteArray();
        System.out.println(Arrays.toString(os.toByteArray()));

        //А чтобы восстановить объект, его нужно десериализовать из этого массива:

        ByteArrayInputStream is = new ByteArrayInputStream(bArray);
        ObjectInputStream ois = new ObjectInputStream(is);
        Object objRead = ois.readObject();

        //Теперь можно убедиться, что восстановленный объект идентичен исходному:

        System.out.println("readed object is: " + objRead.toString());

        System.out.println("Object equality is: " + (objSave.equals(objRead)));

        System.out.println("Reference equality is: " + (objSave==objRead));
    }
}
