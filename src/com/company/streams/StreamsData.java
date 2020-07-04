package com.company.streams;

import java.io.*;
import java.util.Arrays;

public class StreamsData {
    public static void main(String[] args) throws Exception {

        byte[] b = dataOutputStream();
        dataInputStream(b);

    }

    public static byte[] dataOutputStream() throws IOException {
        ByteArrayOutputStream wr = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(wr);

        int n = 128;

        // Как byte:
        dos.writeByte(n);
        // Как int:
        dos.writeInt(n);
        // Как long:
        dos.writeLong((long)n);
        // Как double:
        dos.writeDouble((double)n);

        byte[] bArray = wr.toByteArray();
        System.out.println(Arrays.toString(bArray));

        wr.close();

        return bArray;
    }

    public static void dataInputStream(byte[] b) throws IOException {
        ByteArrayInputStream rd = new ByteArrayInputStream(b);
        DataInputStream dis = new DataInputStream(rd);

        byte a = dis.readByte();
        System.out.println(a);
        int c = dis.readInt();
        System.out.println(c);
        long d = dis.readLong();
        System.out.println(d);
        double e = dis.readDouble();
        System.out.println(e);

        rd.close();
    }
}
