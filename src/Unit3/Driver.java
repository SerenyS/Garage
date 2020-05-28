package Unit3;

public class Driver {
    public static void main(String[] args) {

        TicketFactory factory = new TicketType();
        Garage garage = new Garage(factory);
        garage.menu();
    }

}
