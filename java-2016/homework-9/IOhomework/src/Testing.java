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
    public void readNumbersFromValidFile1(){
        File file = new File("C:" + File.separator + "Users" + File.separator + "Ovi" + File.separator + "Desktop" + File.separator + "Curs" + File.separator + "IOFiles" + File.separator + "Athletes.csv");
        ReadFile read = new ReadFile();
        read.readFile(file);
        List<Athlete> expected = read.getAthletes();

        Assert.assertEquals(1,expected.get(1).getAthleteNumber());
    }

    @Test
    public void readNumbersFromValidFile2(){
        File file = new File("C:" + File.separator + "Users" + File.separator + "Ovi" + File.separator + "Desktop" + File.separator + "Curs" + File.separator + "IOFiles" + File.separator + "Athletes.csv");
        ReadFile read = new ReadFile();
        read.readFile(file);
        List<Athlete> expected = read.getAthletes();

        Assert.assertEquals(11,expected.get(0).getAthleteNumber());
    }

    @Test
    public void readNameFromValidFile1(){
        File file = new File("C:" + File.separator + "Users" + File.separator + "Ovi" + File.separator + "Desktop" + File.separator + "Curs" + File.separator + "IOFiles" + File.separator + "Athletes.csv");
        ReadFile read = new ReadFile();
        read.readFile(file);
        List<Athlete> expected = read.getAthletes();

        Assert.assertEquals("Umar Jorgson",expected.get(0).getName());
    }

    @Test
    public void readNameFromValidFile2(){
        File file = new File("C:" + File.separator + "Users" + File.separator + "Ovi" + File.separator + "Desktop" + File.separator + "Curs" + File.separator + "IOFiles" + File.separator + "Athletes.csv");
        ReadFile read = new ReadFile();
        read.readFile(file);
        List<Athlete> expected = read.getAthletes();

        Assert.assertEquals("Piotr Smitzer",expected.get(2).getName());
    }

    @Test
    public void readCountryCodeFromValidFile1(){
        File file = new File("C:" + File.separator + "Users" + File.separator + "Ovi" + File.separator + "Desktop" + File.separator + "Curs" + File.separator + "IOFiles" + File.separator + "Athletes.csv");
        ReadFile read = new ReadFile();
        read.readFile(file);
        List<Athlete> expected = read.getAthletes();

        Assert.assertEquals("UK",expected.get(1).getCountryCode());
    }

    @Test
    public void readCountryCodeFromValidFile2(){
        File file = new File("C:" + File.separator + "Users" + File.separator + "Ovi" + File.separator + "Desktop" + File.separator + "Curs" + File.separator + "IOFiles" + File.separator + "Athletes.csv");
        ReadFile read = new ReadFile();
        read.readFile(file);
        List<Athlete> expected = read.getAthletes();

        Assert.assertEquals("CZ",expected.get(2).getCountryCode());
    }

    @Test
    public void readSkiTimeFromValidFile1(){
        File file = new File("C:" + File.separator + "Users" + File.separator + "Ovi" + File.separator + "Desktop" + File.separator + "Curs" + File.separator + "IOFiles" + File.separator + "Athletes.csv");
        ReadFile read = new ReadFile();
        read.readFile(file);
        List<Athlete> expected = read.getAthletes();

        Assert.assertEquals("30:10",expected.get(2).getMinuteSeconds());
    }

    @Test
    public void readSkiTimeFromValidFile2(){
        File file = new File("C:" + File.separator + "Users" + File.separator + "Ovi" + File.separator + "Desktop" + File.separator + "Curs" + File.separator + "IOFiles" + File.separator + "Athletes.csv");
        ReadFile read = new ReadFile();
        read.readFile(file);
        List<Athlete> expected = read.getAthletes();

        Assert.assertEquals("30:27",expected.get(0).getMinuteSeconds());
    }

    @Test
    public void readShootingRangeFromValidFile1(){
        File file = new File("C:" + File.separator + "Users" + File.separator + "Ovi" + File.separator + "Desktop" + File.separator + "Curs" + File.separator + "IOFiles" + File.separator + "Athletes.csv");
        ReadFile read = new ReadFile();
        read.readFile(file);
        List<Athlete> expected = read.getAthletes();

        Assert.assertEquals("xxxox",expected.get(0).getFirstShootingRange());
    }

    @Test
    public void readShootingRangeFromValidFile2(){
        File file = new File("C:" + File.separator + "Users" + File.separator + "Ovi" + File.separator + "Desktop" + File.separator + "Curs" + File.separator + "IOFiles" + File.separator + "Athletes.csv");
        ReadFile read = new ReadFile();
        read.readFile(file);
        List<Athlete> expected = read.getAthletes();

        Assert.assertEquals("xxxxx",expected.get(2).getSecondShootingRange());
    }

    @Test
    public void readShootingRangeFromValidFile3(){
        File file = new File("C:" + File.separator + "Users" + File.separator + "Ovi" + File.separator + "Desktop" + File.separator + "Curs" + File.separator + "IOFiles" + File.separator + "Athletes.csv");
        ReadFile read = new ReadFile();
        read.readFile(file);
        List<Athlete> expected = read.getAthletes();

        Assert.assertEquals("xxxxo",expected.get(1).getThirdShootingRange());
    }

    @Test()
    public void readInvalidFile(){
        File file = new File("C:" + File.separator + "Users" + File.separator + "Ovi" + File.separator + "Desktop" + File.separator + "Curs" + File.separator + "IOFiles" + File.separator + "Athletes!!!.csv");
        Assert.assertFalse(file.exists());
    }


    @Test(expected = IllegalArgumentException.class)
    public void invalidFile(){
        File file = new File("C:" + File.separator + "Users" + File.separator + "Ovi" + File.separator + "Desktop" + File.separator + "Curs" + File.separator + "IOFiles" + File.separator + "Athletesss.csv");
        ReadFile read = new ReadFile();
        read.readFile(file);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidFile2(){
        File file = new File("");
        ReadFile read = new ReadFile();
        read.readFile(file);
    }
}


