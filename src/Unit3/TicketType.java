package Unit3;

public class TicketType implements TicketFactory {

    @Override
    public Ticket make(String TicketType) {
        switch (TicketType) {
            case "Regular":
                return new RegularTicket();
            case "Special":
                return new SpecialTicket();
            case "Lost":
                return new LostTicket();
        }

        return null;
    }
}

