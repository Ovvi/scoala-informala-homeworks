/**
 * Created by Turian Ovidiu.
 * This class is a Thread that represent Statistics of the Festival.
 */
public class FestivalStatisticsThread extends Thread {

    private FestivalGate gate;
    private volatile boolean done = false;

    /**
     * This is the constructor and need a Gate.
     *
     * @param gate represent the Gate.
     */
    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
    }

    public void shutdown() {
        done = true;
    }


    @Override
    public void run() {
        while (!done) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (!gate.getQueue().isEmpty()) {
                gate.displayStatistics();
            }
        }
        shutdown();
    }
}
