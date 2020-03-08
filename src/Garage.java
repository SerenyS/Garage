
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;


public class Garage {

    private static Scanner keyboard = new Scanner(System.in);

    private static ArrayList<ticket> TicketList = new ArrayList<>();

    private static ArrayList<ticket> LostList = new ArrayList<>();

    public static int totalAmount;


    ticketReader existingTickets = new ticketReader("Tickets.csv");
    ticketWriter writingData = new ticketWriter("Tickets.csv");


    public static void main(String[] args) {
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

            int totalAmount =0;

            for (int i = 0; i < TicketList.size(); i++) {
                int thisTicketTotal = TicketList.get(i).getTotal();
                totalAmount += thisTicketTotal;
            }
            System.out.println("Total for tickets up to today: $"+ totalAmount);


        }
    }

    public static void checkOut() {
        System.out.println("1 - Check Out");
        System.out.println("2 - Lost Ticket");

        String checkOutResponse = keyboard.nextLine();

        if (checkOutResponse.equals("1")) {
            ticket mostRecent = TicketList.get(TicketList.size() - 1);
            System.out.println(mostRecent.toStringTotal());
            System.out.println(mostRecent.toStringPeriod());
            System.out.println(mostRecent.toStringTimePeriod());


        } else if (checkOutResponse.equals("2")) {
            ticket mostRecent = TicketList.get(TicketList.size() - 1);
            mostRecent.setTimeInGarage(0);
            System.out.println(mostRecent.toStringTotal());
            LostList.add(mostRecent);

        }
    }

    public static void readingData() {

    }

    public static void writingData(ticketReader existingTickets) {

    }


}
