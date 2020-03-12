import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ticketWriter {

    Writer out = null;
    private File fileName;

    public ticketWriter(File fileName) {
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
        } catch (FileNotFoundException e) {
            System.out.println("File Open Error: ticketWriter" + fileName + " " + e);
        }
    }

    public void fileWrite(int total) {
        try {
            out.write(total+"\n");
        } catch (Exception e) {
            System.out.println("File Write Error fileWrite: " + fileName + " " + e);
        }
    }

    public void fileClose() {
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

