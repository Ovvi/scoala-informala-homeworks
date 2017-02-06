import java.util.*;

/**
 * Created by sebi on 1/27/17.
 */
public class MetricUnit {

    private static String[] KNOWN_UNITS = new String[]{"mm", "cm", "dm", "m", "km", "inch", "foot", "miles"};
    private double value;
    private String unit;

    public MetricUnit() {
    }

    public MetricUnit(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }


    /**
     * @param string represent the value and unit expression.
     * @return an object of MetricUnit Class.
     * @throws IllegalArgumentException in case that the string can not be converted to a {@link MetricUnit}
     */
    public static MetricUnit fromString(String string) {

        double simpleValue;
        String simpleUnit;
        String[] stringArray;

        if (string == null) {
            throw new IllegalArgumentException();
        } else {

            stringArray = string.split(" ");

            if (stringArray.length == 2) {
                simpleValue = Double.parseDouble(stringArray[0]);
                simpleUnit = stringArray[1];

                for (String sunit : KNOWN_UNITS) {
                    if (sunit.equalsIgnoreCase(simpleUnit)) {
                        simpleUnit = sunit;
                    }
                }

                if (!Arrays.asList(KNOWN_UNITS).contains(simpleUnit)) {
                    throw new IllegalArgumentException();
                }

                return new MetricUnit(simpleValue, simpleUnit);

            } else {
                throw new IllegalArgumentException();
            }
        }


    }

    public MetricUnit add(MetricUnit other) {
        if (other == null) {
            return this;
        }

        MetricUnit result = null;
        String targetUnit = null;
        if (unitIndex(this.getUnit()) > unitIndex(other.getUnit())) {
            targetUnit = other.getUnit();
        } else {
            targetUnit = this.getUnit();
        }

        double thisValue = convertTo(targetUnit);

        double thatValue = other.convertTo(targetUnit);

        result = new MetricUnit(thisValue + thatValue, targetUnit);

        return result;
    }

    private int unitIndex(String unit) {
        return Arrays.asList(KNOWN_UNITS).indexOf(unit);
    }

    private double convertTo(String unit) {

        return getValue() * Math.pow(10, unitIndex(this.getUnit()) - unitIndex(unit));
    }


    public MetricUnit subtract(MetricUnit other) {
        if (other == null) {
            return this;
        }

        MetricUnit result = null;
        String targetUnit = null;
        if (unitIndex(this.getUnit()) > unitIndex(other.getUnit())) {
            targetUnit = other.getUnit();
        } else {
            targetUnit = this.getUnit();
        }

        double thisValue = convertTo(targetUnit);

        double thatValue = other.convertTo(targetUnit);

        result = new MetricUnit(thisValue - thatValue, targetUnit);

        return result;
    }


    /**
     * This method calculate an given expression.
     * @param expression that we need to extract the values and calculate.
     * @return an object of MetricUnit class.
     */
    public MetricUnit calculateExpression(String expression) {

        MetricUnit m1;
        MetricUnit m2;
        MetricUnit m3;
        MetricUnit result;

        String first;
        String second;
        String third;

        String[] stringArray = expression.split(" ");


        if (stringArray.length == 5) {
            if (stringArray[2].equals("+")){
                first = stringArray[0] +" "+ stringArray[1];
                second = stringArray[3] +" "+ stringArray[4];
                m1 = fromString(first);
                m2 = fromString(second);
                result = m1.add(m2);
                return result;
            }else if(stringArray[2].equals("-")){
                first = stringArray[0] +" "+ stringArray[1];
                second = stringArray[3] +" "+ stringArray[4];
                m1 = fromString(first);
                m2 = fromString(second);
                result = m1.subtract(m2);
                return result;
            }else{
                throw new IllegalArgumentException("Invalid element");
            }

        } else if (stringArray.length == 8) {
            if (stringArray[2].equals("+") && stringArray[5].equals("+")){
                stringArray = expression.split(" ");
                first = stringArray[0] +" "+ stringArray[1];
                second = stringArray[3] +" "+ stringArray[4];
                third = stringArray[6] +" "+ stringArray[7];
                m1 = fromString(first);
                m2 = fromString(second);
                m3 = fromString(third);

                result = m1.add(m2).add(m3);

                return result;
            }else if(stringArray[2].equals("+") && stringArray[5].equals("-")){
                stringArray = expression.split(" ");
                first = stringArray[0] +" "+ stringArray[1];
                second = stringArray[3] +" "+ stringArray[4];
                third = stringArray[6] +" "+ stringArray[7];
                m1 = fromString(first);
                m2 = fromString(second);
                m3 = fromString(third);

                result = m1.add(m2).subtract(m3);

                return result;
            }else if(stringArray[2].equals("-") && stringArray[5].equals("-")) {
                stringArray = expression.split(" ");
                first = stringArray[0] + " " + stringArray[1];
                second = stringArray[3] + " " + stringArray[4];
                third = stringArray[6] + " " + stringArray[7];
                m1 = fromString(first);
                m2 = fromString(second);
                m3 = fromString(third);

                result = m1.subtract(m2).subtract(m3);

                return result;
            }else if(stringArray[2].equals("-") && stringArray[5].equals("+")) {
                stringArray = expression.split(" ");
                first = stringArray[0] + " " + stringArray[1];
                second = stringArray[3] + " " + stringArray[4];
                third = stringArray[6] + " " + stringArray[7];
                m1 = fromString(first);
                m2 = fromString(second);
                m3 = fromString(third);

                result = m1.subtract(m2).add(m3);

                return result;
            } else{
                throw new IllegalArgumentException("Invalid element.");
            }

        } else {
            throw new IllegalArgumentException("Bad expression.");
        }
    }
}
