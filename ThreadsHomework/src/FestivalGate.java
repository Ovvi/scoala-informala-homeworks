import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Turian Ovidiu.
 * This class represent an Festival Gate.
 * This class implements Statistics.
 */
public class FestivalGate implements Statistics {

    private int fullTickets;
    private int freePasses;
    private int fullVip;
    private int oneDayPasses;
    private int oneDayVip;
    private int peopleEntered;

    private Queue<TicketType> queue = new LinkedList<>();

    public Queue<TicketType> getQueue() {
        return queue;
    }


    /**
     * This method validate the Attendee ticket and added to the queue.
     *
     * @param ticket represent the random ticket from the Attendee.
     */
    public void validateAttendeeTicket(TicketType ticket) {
        queue.add(ticket);
    }

    public int getPeopleEntered() {
        peopleEntered = queue.size();
        return peopleEntered;
    }

    public int getFullTickets() {
        return fullTickets;
    }

    public int getFreePasses() {
        return freePasses;
    }

    public int getFullVip() {
        return fullVip;
    }

    public int getOneDayPasses() {
        return oneDayPasses;
    }

    public int getOneDayVip() {
        return oneDayVip;
    }

    /**
     * This method reset the tickets Statistics.
     */
    private void resetStatistics() {
        fullTickets = 0;
        freePasses = 0;
        fullVip = 0;
        oneDayPasses = 0;
        oneDayVip = 0;
    }

    /**
     * This method is the implementation of calculateStatistics from Statistics interface.
     */
    @Override
    public void calculateStatistics() {
        resetStatistics();
        for (TicketType ticket : queue) {
            if (ticket.getType().equals("full")) {
                fullTickets += 1;
            }
            if (ticket.getType().equals("free-pass")) {
                freePasses += 1;
            }
            if (ticket.getType().equals("full-vip")) {
                fullVip += 1;
            }
            if (ticket.getType().equals("one-day")) {
                oneDayPasses += 1;
            }
            if (ticket.getType().equals("one-day-vip")) {
                oneDayVip += 1;
            }

        }
    }

    /**
     * This method displays Statistics.
     */
    public void displayStatistics() {
        calculateStatistics();
        System.out.println(getPeopleEntered() + " people entered");
        System.out.println(getFullTickets() + " people have full tickets");
        System.out.println(getFreePasses() + " have free passes");
        System.out.println(getFullVip() + " full VIP passes");
        System.out.println(getOneDayPasses() + " have one day passes");
        System.out.println(getOneDayVip() + " have one-day VIP passes");
        System.out.println("-----------------------------");
    }

}
