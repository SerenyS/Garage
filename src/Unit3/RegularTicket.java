package Unit3;

public class RegularTicket implements Ticket {


    @Override
    public int cost() {
        int ticketCost;

        if (totalTime() != 0 && totalTime() <= 3) {
            ticketCost = 5;
        } else if (totalTime() > 3 && totalTime() <= 12) {
            ticketCost = (5 + (totalTime()) - 3);
        } else {
            ticketCost = 15;
        }
        return ticketCost;

    }

    @Override
    public int checkIn() {
        return (int) (7 + (Math.random() * (12 - 7)));
    }

    @Override
    public int checkOut() {
        return (int) ( 1 + (Math.random() * (11 - 1)));
    }

    public int totalTime() {
        int time = (checkOut() + 12) - checkIn();
        return time;
    }


}
