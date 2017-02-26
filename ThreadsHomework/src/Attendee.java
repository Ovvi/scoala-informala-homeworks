/**
 * Created by Turian Ovidiu.
 * This class represent an Attendee.
 * Every Attendee has a random Ticket.
 */
public class Attendee {

    private TicketType ticket;

    public Attendee() {
        this.ticket = TicketType.getRandomTicket();
    }

    public TicketType getTicket() {
        return ticket;
    }
}
