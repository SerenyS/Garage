package Unit3;

public class LostTicket implements Ticket {


    @Override
    public int cost() {
        return 25;
    }

    @Override
    public int checkIn() {
        return (int) ( 7 + (Math.random() * (12 - 7)));
    }

    @Override
    public int checkOut() {return (int) (1 + (Math.random() * (11 - 1)));}

    @Override
    public int totalTime() {
        int time = (checkOut() + 12) - checkIn();
        return time;
    }


}
