package com.company.streams;

import java.io.FileInputStream;
        import java.io.FileOutputStream;
        import java.io.IOException;

public class StreamsFile {
    public static void main(String[] args) throws Exception {
        fileOutputStream();
        fileInputStream();
    }

    public static void fileOutputStream() throws IOException {
        byte[] m = new byte[] {1, 2, 3};

        FileOutputStream wr = new FileOutputStream("C:/Folder/file.txt", false);
        wr.write(m);
        System.out.print(wr.toString());
        wr.close();
    }

    public static void fileInputStream() throws IOException {
        FileInputStream rd = new FileInputStream("C:/Folder/file.txt");
        int aviableBytes = rd.available();
        System.out.println(aviableBytes);

        int n;
        for(int i = 0; i < aviableBytes; i++)
        {
            n = rd.read();
            System.out.println(n);
        }
        rd.close();
    }
}
