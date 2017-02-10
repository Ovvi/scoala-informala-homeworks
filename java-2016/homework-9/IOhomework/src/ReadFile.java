import java.io.BufferedReader;
import java.io.File;
import java.io.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Logger;


/**
 * Created by Turian Ovidiu.
 * This class is responsible with reading a file and parse the data into an List of Athletes.
 */
public class ReadFile {

    private static Logger LOGGER = Logger.getLogger("ReadFile");

    private List<Athlete> athletes = new ArrayList<>();

    public List<Athlete> getAthletes() {
        return athletes;
    }

    public ReadFile() {
    }

    /**
     * This method will read the given file and store the data.
     * @param file the file we want to read.
     */
    public void readFile(File file) {
        LOGGER.info("Inside read file method.");

        String line;
        boolean column = true;

        if (!file.exists()) {
            throw new IllegalArgumentException("The file do not exist");
        }

        if (file.length() == 0){
            throw new IllegalArgumentException("The file do not exist");
        }

        LOGGER.info("Start reading file.");
        try (BufferedReader getInfo = new BufferedReader(new java.io.FileReader(file))) {

            while ((line = getInfo.readLine()) != null) {
                if (!column) {
                    athletes.add(storeData(line));
                } else {
                    column = false;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found!" + e);
        } catch (IOException e) {
            System.err.println("Exception reading file!" + e);
        }
        LOGGER.info("Exit read file method.");
    }


    /**
     * This method will split the csv file and it will store a data into an Athlete object.
     * @param line represent each line from the file.
     * @return an Athlete object.
     */
    private Athlete storeData(String line) {
        Athlete athlete = new Athlete();
        String[] stringArray;

        if (line == null) {
            throw new IllegalArgumentException("Line can`t be null");
        } else {
            stringArray = line.split(",");
            athlete.setAthleteNumber(Integer.parseInt(stringArray[0]));
            athlete.setName(stringArray[1]);
            athlete.setCountryCode(stringArray[2]);
            try {
                athlete.setSkiTimeResult(new SimpleDateFormat("mm:ss").parse(stringArray[3]));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            athlete.setFirstShootingRange(stringArray[4]);
            athlete.setSecondShootingRange(stringArray[5]);
            athlete.setThirdShootingRange(stringArray[6]);
        }

        return athlete;
    }


}
