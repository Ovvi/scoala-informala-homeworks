import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.List;

/**
 * Created Turian Ovidiu.
 * This is a junit testing class.
 */
public class Testing {


    @Test
    public void readNumbersFromValidFile() {
        File file = new File("C:" + File.separator + "Users" + File.separator + "Ovi" + File.separator + "Desktop" + File.separator + "Curs" + File.separator + "IOFiles" + File.separator + "Athletes.csv");
        ReadFile read = new ReadFile();
        List<Athlete> expected = null;
        try {
            expected = read.readFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(1, expected.get(1).getAthleteNumber());
    }

    @Test
    public void readNameFromValidFile() {
        File file = new File("C:" + File.separator + "Users" + File.separator + "Ovi" + File.separator + "Desktop" + File.separator + "Curs" + File.separator + "IOFiles" + File.separator + "Athletes.csv");
        ReadFile read = new ReadFile();
        List<Athlete> expected = null;
        try {
            expected = read.readFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals("Umar Jorgson", expected.get(0).getName());
    }

    @Test
    public void readSkiTimeFromValidFile() {
        File file = new File("C:" + File.separator + "Users" + File.separator + "Ovi" + File.separator + "Desktop" + File.separator + "Curs" + File.separator + "IOFiles" + File.separator + "Athletes.csv");
        ReadFile read = new ReadFile();
        List<Athlete> expected = null;
        try {
            expected = read.readFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals("30:10", expected.get(2).getMinuteSeconds());
    }

    @Test(expected = FileNotFoundException.class)
    public void invalidFile() throws IOException {
        File file = new File("C:" + File.separator + "Users" + File.separator + "Ovi" + File.separator + "Desktop" + File.separator + "Curs" + File.separator + "IOFiles" + File.separator + "Athletesss.csv");
        ReadFile read = new ReadFile();
        read.readFile(file);
    }

}


