import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ticketReader {

    private BufferedReader in = null;
    private File fileName;
    private int count;
    private static int previousTotal;



    public ticketReader(File fileName) {
        this.fileName = fileName;
        try {
            in = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File Open Error: " + fileName + " " + e);
        }
    }

    public void fileRead() {
        String line;
        try {
            while ((line = in.readLine()) != null) {
                int readTicketTotal = Integer.parseInt(line);
                count++;
                previousTotal+= readTicketTotal;

            }
        } catch (Exception e) {
            System.out.println("File Write Error: " + fileName + " " + e);
        }
    }

    public String fileReadLine() {
        try {
            String line = in.readLine();
            return line;
        } catch (Exception e) {
            System.out.println("File Write Error: " + fileName + " " + e);
            return null;
        }
    }

    public void fileClose() {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}


