import java.util.Random;

/**
 * Created by Turian Ovidiu.
 * This class is a Thread that represent an Festival Attendee.
 */
public class FestivalAttendeeThread extends Thread {

    private TicketType ticketType;
    private FestivalGate gate;
    private volatile boolean done = false;
    private Random random = new Random();

    /**
     * This is the constructor and needs a Ticket and a Gate.
     *
     * @param ticketType represent the Ticket.
     * @param gate       represent the Gate.
     */
    public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
        this.ticketType = ticketType;
        this.gate = gate;
    }

    public void shutdown() {
        done = true;
    }


    @Override
    public void run() {
        while (!done) {
            synchronized (gate) {
                ticketType = new Attendee().getTicket();
                gate.validateAttendeeTicket(ticketType);

                try {
                    Thread.sleep(random.nextInt((2000 - 10) + 1) + 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            shutdown();
        }
    }
}
