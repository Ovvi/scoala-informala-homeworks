/**
 * Created by Turian Ovidiu.
 * This class represent an Festival.
 * Every Festival has a FestivalGate.
 */
public class Festival {

    private FestivalGate festivalGate;

    public Festival() {
        this.festivalGate = new FestivalGate();
    }

    public FestivalGate getFestivalGate() {
        return festivalGate;
    }
}
