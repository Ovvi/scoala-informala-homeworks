import java.util.Random;
/**
 * Created by Turian Ovidiu.
 * This is a Main class.
 */
public class Main {


    public static void main(String[] args) {

        Random random = new Random();
        FestivalGate untoldGate = new Festival().getFestivalGate();

        FestivalStatisticsThread statisticsThread = new FestivalStatisticsThread(untoldGate);

        statisticsThread.setDaemon(true);


        for (int i = 0; i < random.nextInt((1000 - 100) + 1) + 100; i++) {
            FestivalAttendeeThread thread = new FestivalAttendeeThread(new Attendee().getTicket(), untoldGate);
            thread.start();
        }
        statisticsThread.start();

        System.out.println("Active threads : " + Thread.activeCount());

    }

}
