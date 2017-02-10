import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Turian Ovidiu.
 * This is a Main class.
 * Is just a quick overview of what the application do.
 */

public class Main {

    List<Athlete> athletes = new ArrayList<>();

    public static void main(String[] args) {

        File fileRead = new File("C:" + File.separator + "Users" + File.separator + "Ovi" + File.separator + "Desktop" + File.separator + "Curs" + File.separator + "IOFiles" + File.separator + "Athletes.csv");
        File fileWrite = new File("C:" + File.separator + "Users" + File.separator + "Ovi" + File.separator + "Desktop" + File.separator + "Curs" + File.separator + "IOFiles" + File.separator + "AthletesRanking.csv");
        Main main = new Main();
        AthleteEvaluation athleteEvaluation = new AthleteEvaluation();
        ReadFile reader = new ReadFile();
        WriteFile writer = new WriteFile();

        reader.readFile(fileRead);

        main.athletes = reader.getAthletes();
        main.athletes = athleteEvaluation.rankingAthletes(reader.getAthletes());

        writer.writeFile(main.athletes, fileWrite);

        for (Athlete ath : main.athletes) {
            System.out.println(ath.getAthleteNumber());
            System.out.println(ath.getName());
            System.out.println(ath.getMinuteSeconds());
        }

    }
}

