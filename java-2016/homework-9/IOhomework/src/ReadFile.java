import java.io.BufferedReader;
import java.io.File;
import java.io.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;

import org.apache.log4j.Logger;


/**
 * Created by Turian Ovidiu.
 * This class is responsible with reading a file and parse the data into an List of Athletes.
 */
public class ReadFile {

    private final static Logger LOGGER = Logger.getLogger(ReadFile.class);

    private List<Athlete> athletes = new ArrayList<>();

    public List<Athlete> getAthletes() {
        return athletes;
    }


    /**
     * This method will read the given file and store the data.
     *
     * @param file the file we want to read.
     * @return a list of Athletes from the file.
     */
    public List<Athlete> readFile(File file) throws IOException {
        LOGGER.debug("Inside read file method.");

        String line;
        boolean column = true;


        if (!file.exists()) {
            try {
                throw new FileNotFoundException("File does not exist.");
            } catch (FileNotFoundException e) {
                LOGGER.error("File does not exist.", e);
                throw e;
            }
        }


        if (file.length() == 0) {
            try {
                throw new IOException("The file is empty.");
            } catch (IOException e) {
                LOGGER.error("The file is empty.", e);
            }
        }

        LOGGER.debug("Start reading file.");
        try (BufferedReader getInfo = new BufferedReader(new java.io.FileReader(file))) {

            while ((line = getInfo.readLine()) != null) {
                if (!column) {
                    athletes.add(getAthlete(line));
                } else {
                    column = false;
                }
            }
        } catch (IOException ex) {
            LOGGER.error("Exception reading file!", ex);
            throw ex;
        }

        LOGGER.debug("Exit read file method.");
        return athletes;
    }


    /**
     * This method will split the csv file and it will store a data into an Athlete object.
     *
     * @param line represent each line from the file.
     * @return an Athlete object.
     */
    private Athlete getAthlete(String line) {
        Athlete athlete = new Athlete();
        String[] stringArray = line.split(",");


        if (stringArray.length != 7) {
            throw new InvalidAthleteException("Missing data from Athlete.");
        } else {

            if (stringArray[0].equals("")) {
                throw new InvalidAthleteException("The Athlete does not have a number.");
            } else {
                athlete.setAthleteNumber(Integer.parseInt(stringArray[0]));
            }

            if (stringArray[1].equals("")) {
                throw new InvalidAthleteException("The Athlete does not have a name.");
            } else {
                athlete.setName(stringArray[1]);
            }

            if (stringArray[2].equals("")) {
                throw new InvalidAthleteException("The Athlete does not have country code.");
            } else {

                athlete.setCountryCode(stringArray[2]);
            }

            if (stringArray[3].equals("")) {
                throw new InvalidAthleteException("The Athlete does not have ski time result.");
            } else {
                try {
                    athlete.setSkiTimeResult(new SimpleDateFormat("mm:ss").parse(stringArray[3]));
                } catch (ParseException e) {
                    LOGGER.error("Error parsing ski time result.", e);
                    e.printStackTrace();
                }
            }

            if (stringArray[4].equals("")) {
                throw new InvalidAthleteException("The Athlete does not have first shooting range.");
            } else {
                athlete.setFirstShootingRange(stringArray[4]);
            }

            if (stringArray[5].equals("")) {
                throw new InvalidAthleteException("The Athlete does not have second shooting range.");
            } else {
                athlete.setSecondShootingRange(stringArray[5]);
            }

            if (stringArray[6].equals("")) {
                throw new InvalidAthleteException("The Athlete does not have third shooting range.");
            } else {
                athlete.setThirdShootingRange(stringArray[6]);
            }
        }

        return athlete;
    }


}
