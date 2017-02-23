import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * Created by Turian Ovidiu.
 * This is a Main class.
 * Is just a quick overview of what the application do.
 */

public class Main {

    public static void main(String[] args) throws IOException {

        List<Athlete> athletes;

        File fileRead = new File("C:" + File.separator + "Users" + File.separator + "Ovi" + File.separator + "Desktop" + File.separator + "Curs" + File.separator + "IOFiles" + File.separator + "Athletes.csv");
        File fileWrite = new File("C:" + File.separator + "Users" + File.separator + "Ovi" + File.separator + "Desktop" + File.separator + "Curs" + File.separator + "IOFiles" + File.separator + "AthletesRanking.csv");

        AthleteEvaluation athleteEvaluation = new AthleteEvaluation();
        ReadFile reader = new ReadFile();
        WriteFile writer = new WriteFile();

        athletes = reader.readFile(fileRead);
        athletes = athleteEvaluation.getAthletesRanking(reader.getAthletes());


        for (Athlete ath : athletes) {
            System.out.println(ath.getAthleteNumber());
            System.out.println(ath.getName());
            System.out.println(ath.getMinuteSeconds());
            System.out.println(ath.getCountryCode());
        }

        writer.writeFile(athletes, fileWrite);

    }

}

