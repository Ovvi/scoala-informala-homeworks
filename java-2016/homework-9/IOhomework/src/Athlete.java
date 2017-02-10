
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Turian Ovidiu.
 * This class represent an Athlete.
 * Each Athlete has a number, name, country code, ski time and 3 different shooting ranges.
 */
public class Athlete {

    private int athleteNumber;
    private String name;
    private String countryCode;
    private Date skiTimeResult;
    private String firstShootingRange;
    private String secondShootingRange;
    private String thirdShootingRange;


    public int getAthleteNumber() {
        return athleteNumber;
    }

    public void setAthleteNumber(int athleteNumber) {
        this.athleteNumber = athleteNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Date getSkiTimeResult() {
        return skiTimeResult;
    }

    public void setSkiTimeResult(Date skiTimeResult) {
        this.skiTimeResult = skiTimeResult;
    }

    public String getFirstShootingRange() {
        return firstShootingRange;
    }

    public void setFirstShootingRange(String firstShootingRange) {
        this.firstShootingRange = firstShootingRange;
    }

    public String getSecondShootingRange() {
        return secondShootingRange;
    }

    public void setSecondShootingRange(String secondShootingRange) {
        this.secondShootingRange = secondShootingRange;
    }

    public String getThirdShootingRange() {
        return thirdShootingRange;
    }

    public void setThirdShootingRange(String thirdShootingRange) {
        this.thirdShootingRange = thirdShootingRange;
    }


    /**
     * This method return just the minutes and seconds of the ski time result.
     * @return String minutes and seconds of the ski time result.
     */
    public String getMinuteSeconds() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(skiTimeResult);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);
        String time = minutes + ":" + seconds;
        return time;
    }
}
