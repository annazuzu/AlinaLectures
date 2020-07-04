package com.company.streams;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamsArrays {
    public static void main(String[] args) throws Exception {
        byteArrayInputStream();
        byteArrayOutputStream();
    }

    public static void byteArrayInputStream(){
        byte[] m = new byte[] {-1, 0, 1};
        ByteArrayInputStream rd = new ByteArrayInputStream(m);
        int bytee = rd.read();
        System.out.println(bytee);
        bytee = rd.read();
        System.out.println(bytee);
        bytee = rd.read();
        System.out.println(bytee);
    }

    public static void byteArrayOutputStream() throws IOException {
        byte[] m = new byte[] {-20, 15};
        ByteArrayOutputStream wr = new ByteArrayOutputStream();
        wr.write(m);
        System.out.print(Arrays.toString(wr.toByteArray()));
        wr.close();
    }
}
