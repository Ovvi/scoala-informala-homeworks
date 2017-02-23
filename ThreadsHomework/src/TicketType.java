import java.util.Random;

/**
 * Created by Turian Ovidiu.
 * This is an Enum Ticket Type class.
 * Ticket has 5 types.
 */
public enum TicketType {

    FULL("full"),
    FULLVIP("full-vip"),
    FREEPASS("free-pass") ,
    ONEDAY("one-day"),
    ONEDAYVIP("one-day-vip");

    private String type;

    TicketType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    /**
     * This method return a random Ticket.
     * @return random Ticket.
     */
    public static TicketType getRandomTicket(){
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
