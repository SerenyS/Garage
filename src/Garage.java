
import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;


public class Garage {

    private static Scanner keyboard = new Scanner(System.in);

    private static ArrayList<ticket> TicketList = new ArrayList<>();

    private static File file = new File("tickets.txt");

    public static ticketReader reader = new ticketReader(file);
    public static ticketWriter writer = new ticketWriter(file);

    private static int lostTicketCount;
    private static int checkInCount;
    private static int totalAmount;
    private static int lostTicketAmount;
    private static int checkInAmount;


    public static void main(String[] args) {
        reader.fileRead();
        reader.fileClose();
        Main();
    }

    public static void Main() {

        checkIn();
        checkOut();
        Main();
    }

    public static void checkIn() {
        System.out.println("1 - Check In");
        System.out.println("2 - Close Garage");

        String checkInResponse = keyboard.nextLine();

        if (checkInResponse.equals("1")) {
            ticket a = new ticket();
            System.out.println("New Ticket has been created!");
            System.out.println();
            TicketList.add(a);

        } else if (checkInResponse.equals("2")) {

            if (TicketList.isEmpty()) {
                System.out.println("No Check Ins Records");
                Main();
            }

            for (ticket ticket : TicketList) {
                int thisTicketTotal = ticket.getTotal();
                totalAmount += thisTicketTotal;
            }
            System.out.println("$" + checkInAmount + " was collected from " + checkInCount + " Check Ins");
            System.out.println("$" + lostTicketAmount + "  was collected from " + lostTicketCount + " Lost Tickets");
            System.out.println("Amount that was collected overall $" + totalAmount);

            for (ticket ticket : TicketList) {
                int thisTicketTotal = ticket.getTotal();
                writer.fileWrite(thisTicketTotal);
            }

            writer.fileClose();
            System.exit(0);

        }
    }

    public static void checkOut() {
        System.out.println("1 - Check Out");
        System.out.println("2 - Lost Ticket");

        String checkOutResponse = keyboard.nextLine();

        if (checkOutResponse.equals("1")) {
            ticket mostRecent = TicketList.get(TicketList.size() - 1);

            checkInCount++;
            checkInAmount += mostRecent.getTotal();

            System.out.println(mostRecent.toStringID());
            System.out.println(mostRecent.toStringTotal());
            System.out.println(mostRecent.toStringPeriod());
            System.out.println(mostRecent.toStringTimePeriod());


        } else if (checkOutResponse.equals("2")) {
            ticket mostRecent = TicketList.get(TicketList.size() - 1);

            mostRecent.setLostTicket(true);

            lostTicketAmount += mostRecent.getTotal();
            lostTicketCount++;


            System.out.println(mostRecent.toStringID());
            System.out.println(mostRecent.toStringTotal());


        }
    }


}
