import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.zip.CheckedOutputStream;

public class Garage {

    private static Scanner keyboard = new Scanner(System.in);

    private static ArrayList<ticket> TicketList = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        Main();
    }

    public static void Main() throws IOException {
        checkIn();
        checkOut();
        Main();
    }

    public static void checkIn() throws IOException {
        System.out.println("1 - Check In");
        System.out.println("2 - Close Garage");

        String checkInResponse = keyboard.nextLine();

        if (checkInResponse.equals("1")) {
            ticket a = new ticket();
            System.out.println("New Ticket has been created!");
            System.out.println();
            TicketList.add(a);

        } else if (checkInResponse.equals("2")) {


        }
    }

    public static void checkOut() {
        System.out.println("1 - Check Out");
        System.out.println("2 - Lost Ticket");

        String checkOutResponse = keyboard.nextLine();

        if (checkOutResponse.equals("1")) {
            System.out.println("Enter your ticket number ");
            String ticketNumber = keyboard.nextLine();
            int parseTicketNumber = Integer.parseInt(ticketNumber);


            for (int i = 0; i < TicketList.size(); i++) {

                if (parseTicketNumber == TicketList.get(i).getId()) {

                    System.out.println(TicketList.get(i).toStringId());
                    System.out.println(TicketList.get(i).toStringTotal());
                    System.out.println(TicketList.get(i).toStringTimePeriod());
                    System.out.println(TicketList.get(i).toStringPeriod());
                }
            }
        } else if (checkOutResponse.equals("2")) {
            System.out.println("Enter your ticket number ");
            String ticketNumber = keyboard.nextLine();
            int parseTicketNumber = Integer.parseInt(ticketNumber);


            for (int i = 0; i < TicketList.size(); i++) {

                if (parseTicketNumber == TicketList.get(i).getId()) {

                    int LostTicketAmount = TicketList.get(i).setTotal(TicketList.get(i).getTotal());

                    System.out.println("Your total for ticket number " + TicketList.get(i).getId());
                    System.out.println("is = $" + LostTicketAmount + ".00");


                }
            }
        }
    }
}