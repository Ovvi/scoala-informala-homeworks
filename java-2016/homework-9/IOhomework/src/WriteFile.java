import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Created by Turian Ovidiu.
 * This class is responsible to write a file with an list of Athletes sorted by the ski time result.
 */
public class WriteFile {


     private static final Logger LOGGER = Logger.getLogger(WriteFile.class);


    /**
     * This method will write an given file with an given list of Athletes.
     * @param athletes the list we want to write in a file.
     * @param file we want to write.
     */
    public void writeFile(List<Athlete> athletes , File file) {

        LOGGER.debug("Inside write file method.");

        if (athletes == null){
            throw new InvalidAthleteException("No athletes to write.");
        }

        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(file.getAbsolutePath()))) {

            String columns = new Athlete().toString();
            writer.write(columns);
            writer.write("\n");

            for (Athlete athlete : athletes) {

                writer.write(athlete.getAthleteNumber()+","+athlete.getName()+","+athlete.getCountryCode()+","+athlete.getMinuteSeconds()
                       +","+athlete.getFirstShootingRange()+","+athlete.getSecondShootingRange()+","+athlete.getThirdShootingRange());
                writer.write("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        LOGGER.debug("Exit write file method.");
    }
}
