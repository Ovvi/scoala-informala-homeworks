import org.junit.Assert;
import org.junit.Test;


/**
 * Created by sebi on 1/27/17.
 */
public class MetricUnitTest {

    /**
     * Start testing fromString();
     */

    @Test(expected = IllegalArgumentException.class)
    public void invalidUnit() {
            MetricUnit unit = MetricUnit.fromString("10 ana");
    }

    @Test
    public void invalidUnit_3() {
        try {
            MetricUnit unit = MetricUnit.fromString("10 ana");
            Assert.fail("ana is not a valid unit!!!");
        }catch (IllegalArgumentException ex) {
            //expected
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void noSpaceSeparator() {
        MetricUnit unit = MetricUnit.fromString("10cm");
    }

    @Test(expected = IllegalArgumentException.class)
    public void noUnit() {
        MetricUnit unit = MetricUnit.fromString("10");
    }

    @Test(expected = IllegalArgumentException.class)
    public void noValue() {
        MetricUnit unit = MetricUnit.fromString("cm");
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidValue() {
        MetricUnit unit = MetricUnit.fromString("XX cm");
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidSwitchedUnitAndValue() {
        MetricUnit unit = MetricUnit.fromString("cm 10");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullString() {
        MetricUnit unit = MetricUnit.fromString(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void empty() {
        MetricUnit unit = MetricUnit.fromString("");
    }


    @Test
    public void one_cm() {
        MetricUnit unit = MetricUnit.fromString("1 cm");
        Assert.assertEquals(1, unit.getValue(), 0.0001);
        Assert.assertEquals("cm", unit.getUnit());
    }

    @Test
    public void one_cm_upper_case() {
        MetricUnit unit = MetricUnit.fromString("1 CM");
        Assert.assertEquals(1, unit.getValue(), 0.0001);
        Assert.assertEquals("cm", unit.getUnit());
    }

    @Test
    public void one_cm_camel_case() {
        MetricUnit unit = MetricUnit.fromString("1 Cm");
        Assert.assertEquals(1, unit.getValue(), 0.0001);
        Assert.assertEquals("cm", unit.getUnit());
    }

    @Test
    public void one_mm() {
        MetricUnit unit = MetricUnit.fromString("1 mm");
        Assert.assertEquals(1, unit.getValue(), 0.0001);
        Assert.assertEquals("mm", unit.getUnit());
    }

    @Test
    public void one_m() {
        MetricUnit unit = MetricUnit.fromString("1 m");
        Assert.assertEquals(1, unit.getValue(), 0.0001);
        Assert.assertEquals("m", unit.getUnit());
    }


    @Test
    public void smallValue() {
        MetricUnit unit = MetricUnit.fromString("0.01 m");
        Assert.assertEquals(0.01, unit.getValue(), 0.0001);
        Assert.assertEquals("m", unit.getUnit());
    }

    @Test
    public void largeValue() {
        MetricUnit unit = MetricUnit.fromString("1000.99 m");
        Assert.assertEquals(1000.99, unit.getValue(), 0.0001);
        Assert.assertEquals("m", unit.getUnit());
    }

    @Test
    public void negativeValue() {
        MetricUnit unit = MetricUnit.fromString("-10.5 cm");
        Assert.assertEquals(-10.5, unit.getValue(), 0.0001);
        Assert.assertEquals("cm", unit.getUnit());
    }

    /**
     * End testing fromString();
     */


    /**
     * Start testing add();
     */

    @Test
    public void addWithNull() {
        MetricUnit m1 = new MetricUnit(1, "cm");
        MetricUnit m2 = m1.add(null);
        Assert.assertEquals(m1, m2);
    }


    @Test
    public void multiplyWithTwo() {
        MetricUnit m1 = new MetricUnit(1, "cm");
        MetricUnit m2 = m1.add(m1);
        Assert.assertEquals(2, m2.getValue(), 0.0001);
        Assert.assertEquals("cm", m2.getUnit());
    }

    @Test
    public void addCmToM() {
        MetricUnit m1 = new MetricUnit(10, "cm");
        MetricUnit m2 = new MetricUnit(2, "m");
        MetricUnit m3 = m1.add(m2);
        Assert.assertEquals(210, m3.getValue(), 0.0001);
        Assert.assertEquals("cm", m3.getUnit());
    }

    @Test
    public void addMMToM() {
        MetricUnit m1 = new MetricUnit(10, "mm");
        MetricUnit m2 = new MetricUnit(2, "m");
        MetricUnit m3 = m1.add(m2);
        Assert.assertEquals(2010, m3.getValue(), 0.0001);
        Assert.assertEquals("mm", m3.getUnit());
    }

    @Test
    public void addMMToCm() {
        MetricUnit m1 = new MetricUnit(10, "mm");
        MetricUnit m2 = new MetricUnit(2, "cm");
        MetricUnit m3 = m1.add(m2);
        Assert.assertEquals(30, m3.getValue(), 0.0001);
        Assert.assertEquals("mm", m3.getUnit());
    }

    @Test
    public void addMMToMM() {
        MetricUnit m1 = new MetricUnit(10, "mm");
        MetricUnit m2 = new MetricUnit(2, "mm");
        MetricUnit m3 = m1.add(m2);
        Assert.assertEquals(12, m3.getValue(), 0.0001);
        Assert.assertEquals("mm", m3.getUnit());
    }


    @Test
    public void substractMMToCm() {
        MetricUnit m1 = new MetricUnit(-10, "mm");
        MetricUnit m2 = new MetricUnit(2, "cm");
        MetricUnit m3 = m1.add(m2);
        Assert.assertEquals(10, m3.getValue(), 0.0001);
        Assert.assertEquals("mm", m3.getUnit());
    }

    @Test
    public void substractMMToMM() {
        MetricUnit m1 = new MetricUnit(10, "mm");
        MetricUnit m2 = new MetricUnit(-2, "mm");
        MetricUnit m3 = m1.add(m2);
        Assert.assertEquals(8, m3.getValue(), 0.0001);
        Assert.assertEquals("mm", m3.getUnit());
    }

    /**
     * End testing add();
     */



    /**
     * Start testing calculateExpression();
     */

    @Test
    public void calculateValidExpressionSub(){
        String s = "10 mm - 2 mm";
        MetricUnit m1 = new MetricUnit().calculateExpression(s);
        Assert.assertEquals(8, m1.getValue(), 0.0001);
        Assert.assertEquals("mm", m1.getUnit());
    }

    @Test
    public void calculateValidExpressionAdd(){
        String s = "10 mm + 2 mm";
        MetricUnit m1 = new MetricUnit().calculateExpression(s);
        Assert.assertEquals(12, m1.getValue(), 0.0001);
        Assert.assertEquals("mm", m1.getUnit());
    }

    @Test
    public void calculateLongValidExpression(){
        String s = "10 mm + 2 mm + 1 mm";
        MetricUnit m1 = new MetricUnit().calculateExpression(s);
        Assert.assertEquals(13, m1.getValue(), 0.0001);
        Assert.assertEquals("mm", m1.getUnit());
    }

    @Test
    public void calculateLongValidExpression_add_sub(){
        String s = "10 mm + 2 mm - 1 mm";
        MetricUnit m1 = new MetricUnit().calculateExpression(s);
        Assert.assertEquals(11, m1.getValue(), 0.0001);
        Assert.assertEquals("mm", m1.getUnit());
    }

    @Test
    public void calculateLongValidExpression_sub_sub(){
        String s = "10 mm - 2 mm - 1 mm";
        MetricUnit m1 = new MetricUnit().calculateExpression(s);
        Assert.assertEquals(7, m1.getValue(), 0.0001);
        Assert.assertEquals("mm", m1.getUnit());
    }

    @Test
    public void calculateLongValidExpression_sub_add(){
        String s = "10 mm - 2 mm + 1 mm";
        MetricUnit m1 = new MetricUnit().calculateExpression(s);
        Assert.assertEquals(9, m1.getValue(), 0.0001);
        Assert.assertEquals("mm", m1.getUnit());
    }

    @Test
    public void calculateLongValidExpression_diff_unit(){
        String s = "10 mm + 2 mm + 1 cm";
        MetricUnit m1 = new MetricUnit().calculateExpression(s);
        Assert.assertEquals(22, m1.getValue(), 0.0001);
        Assert.assertEquals("mm", m1.getUnit());
    }

    @Test
    public void calculateLongValidExpression_sub_diff_unit(){
        String s = "10 mm + 2 mm - 1 cm";
        MetricUnit m1 = new MetricUnit().calculateExpression(s);
        Assert.assertEquals(2, m1.getValue(), 0.0001);
        Assert.assertEquals("mm", m1.getUnit());
    }

    @Test
    public void calculateLongValidExpression_ignore_case(){
        String s = "10 mm + 2 MM + 1 mm";
        MetricUnit m1 = new MetricUnit().calculateExpression(s);
        Assert.assertEquals(13, m1.getValue(), 0.0001);
        Assert.assertEquals("mm", m1.getUnit());
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateInvalidExpression_illegal_operation() {
        String s = "10 mm + 2 mm * 1 cm";
        MetricUnit m1 = new MetricUnit().calculateExpression(s);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateInvalidExpression_illegal_expression() {
        String s = "10 mm + 2 mm - 1 cm + 2 m";
        MetricUnit m1 = new MetricUnit().calculateExpression(s);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateInvalidExpression_illegal_unit() {
        String s = "10 mm + 2 mm + 1 cmm";
        MetricUnit m1 = new MetricUnit().calculateExpression(s);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateInvalidExpression_illegal_unit_expression() {
        String s = "10mm + 2 mm + 1 cmm";
        MetricUnit m1 = new MetricUnit().calculateExpression(s);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateInvalidExpression_bad_expression() {
        String s = "10mm + 2 mm + 1 cm";
        MetricUnit m1 = new MetricUnit().calculateExpression(s);
    }
    /**
     * End testing calculateExpression();
     */
}
