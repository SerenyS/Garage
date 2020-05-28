package Unit3;

import Unit2.ticket;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Garage {

    private TicketFactory ticketFactory;

    private static ArrayList<Ticket> List = new ArrayList<>();

    private static Scanner keyboard = new Scanner(System.in);

    private static int totalAmount = 0;

    public Garage(TicketFactory ticketFactory) {
        this.ticketFactory = ticketFactory;
    }

    public void menu() {
        CheckIn();
        CheckOut();
        menu();
    }

    public void CheckIn() {

        System.out.println("1. Check In");
        System.out.println("2. Special Event");
        System.out.println("3. Close Garage");

        String checkInResponse = keyboard.nextLine();

        if (checkInResponse.equals("1")) {
            Ticket rTicket = ticketFactory.make("Regular");
            List.add(rTicket);
            System.out.println("Regular Ticket");

        } else if (checkInResponse.equals("2")) {
            Ticket sTicket = ticketFactory.make("Special");
            List.add(sTicket);
            System.out.println("Special Ticket");

        } else if (checkInResponse.equals("3")) {

            if (List.isEmpty()) {
                System.out.println("No Check Ins Records");
                menu();
            }

            for (Ticket tickets : List) {
                int thisTicketTotal = tickets.cost();
                int thisTicketTime = tickets.totalTime();

                totalAmount += thisTicketTotal;

                System.out.println(thisTicketTime + " hours");
                System.out.println("$" + thisTicketTotal);
                System.out.println("- - - - - - - ");

            }
            System.out.println("Total Amount Collected  $" + totalAmount);
            System.out.println();
        }
    }

    public void CheckOut() {
        System.out.println("1. Check Out");
        System.out.println("2. Lost Ticket");

        String checkOutResponse = keyboard.nextLine();

        if (checkOutResponse.equals("1")) {
            Ticket latestTicket = List.get(List.size() - 1);
            System.out.println(latestTicket.totalTime() + " hours");
            System.out.println("$" + latestTicket.cost());

        } else if (checkOutResponse.equals("2")) {
            Ticket lTicket = ticketFactory.make("Lost");
            List.add(lTicket);
            System.out.println("Lost Ticket");
            System.out.println(lTicket.totalTime() + " hours");
            System.out.println("$" + lTicket.cost());


        }

    }

}
