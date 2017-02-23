import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Turian Ovidiu.
 * This is a Testing class.
 */
public class Testing {

    @Test
    public void testOneStatistic() {
        FestivalGate gate = new Festival().getFestivalGate();
        gate.validateAttendeeTicket(TicketType.FULLVIP);
        gate.calculateStatistics();
        Assert.assertEquals(1, gate.getFullVip());

    }

    @Test
    public void testMultipleStatistics() {
        FestivalGate gate = new Festival().getFestivalGate();
        gate.validateAttendeeTicket(TicketType.FULLVIP);
        gate.validateAttendeeTicket(TicketType.FREEPASS);
        gate.validateAttendeeTicket(TicketType.FREEPASS);
        gate.validateAttendeeTicket(TicketType.ONEDAY);
        gate.calculateStatistics();
        Assert.assertEquals(1, gate.getFullVip());
        Assert.assertEquals(2, gate.getFreePasses());
        Assert.assertEquals(1, gate.getOneDayPasses());
        Assert.assertEquals(0, gate.getFullTickets());
        Assert.assertEquals(0, gate.getOneDayVip());
    }


}
