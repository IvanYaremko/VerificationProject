package cm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.lang.model.type.NullType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class YaremkoIvanTestTask3 {

    /**
     * Testing partition normalRate <= reducedRate
     * Expect exception thrown
     */
    @Test
    void testCase1() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 24), new Period(1, 9)));
        BigDecimal normalRate = new BigDecimal(1);
        BigDecimal reducedRate = new BigDecimal(2);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    /**
     * Testing partition normalRate <= reducedRate
     * Expect exception thrown
     */
    @Test
    void testCase2() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 24), new Period(1, 9)));
        BigDecimal normalRate = new BigDecimal(0);
        BigDecimal reducedRate = new BigDecimal(1);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    /**
     * Testing partition normalRate <= reducedRate
     * Expect no exception to be thrown
     */
    @Test
    void testCase3() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 24), new Period(1, 9)));
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(1);
        Assertions.assertDoesNotThrow(() -> new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    /**
     * Testing partition normalRate < 0 OR reducedRate < 0
     * Expect exception thrown
     */
    @Test
    void testCase4() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 24), new Period(1, 9)));
        BigDecimal normalRate = new BigDecimal(-1);
        BigDecimal reducedRate = new BigDecimal(1);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    /**
     * Testing partition normalRate < 0 OR reducedRate < 0
     * Expect exception thrown
     */
    @Test
    void testCase5() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 24), new Period(1, 9)));
        BigDecimal normalRate = new BigDecimal(0);
        BigDecimal reducedRate = new BigDecimal(1);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    /**
     * Testing partition normalRate > 0 OR reducedRate > 0
     * Expect no exception to be thrown
     */
    @Test
    void testCase6() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 24), new Period(1, 9)));
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        Assertions.assertDoesNotThrow(() -> new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    @Test
    void testCaseReducedRateNull() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 24), new Period(1, 9)));
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.STAFF, normalRate, null, reducedPeriods, normalPeriods));
    }

    @Test
    void testCaseNormalPeriodNull() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 24), new Period(1, 9)));
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, null));
    }


    /**
     * Testing partition normalRate < 0 OR reducedRate < 0
     * Expect exception thrown
     */
    @Test
    void testCase7() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 24), new Period(1, 9)));
        BigDecimal normalRate = new BigDecimal(0);
        BigDecimal reducedRate = new BigDecimal(-1);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    /**
     * Testing partition normalRate < 0 OR reducedRate < 0
     * Expect exception thrown
     */
    @Test
    void testCase8() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 24), new Period(1, 9)));
        BigDecimal normalRate = new BigDecimal(0);
        BigDecimal reducedRate = new BigDecimal(0);
        Assertions.assertDoesNotThrow(() ->
                new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    /**
     * Testing partition normalRate > 0 OR reducedRate > 0
     * Expect no exception to be thrown
     */
    @Test
    void testCase9() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 24), new Period(1, 9)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(1);
        Assertions.assertDoesNotThrow(() -> new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    /**
     * Testing partition normalPeriods DO overlap
     * Expect exception thrown
     */
    @Test
    void testCase10() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(12, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 24), new Period(1, 9)));
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    /**
     * Testing partition normalPeriods DO NOT overlap
     * Expect no exception to be thrown
     */
    @Test
    void testCase11() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 24), new Period(1, 9)));
        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = new BigDecimal(3);
        Assertions.assertDoesNotThrow(() -> new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    /**
     * Testing partition reducedPeriods DO overlap
     * Expect exception thrown
     */
    @Test
    void testCase12() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 24), new Period(1, 20)));
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(1);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    /**
     * Testing partition reducedPeriods DO NOT overlap
     * Expect no exception to be thrown
     */
    @Test
    void testCase13() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 24), new Period(1, 9)));
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        Assertions.assertDoesNotThrow(() -> new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    /**
     * Testing partition normalPeriod AND reducedPeriod DO overlap
     * Expect exception thrown
     */
    @Test
    void testCase14() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(10, 13), new Period(1, 9)));
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(2);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    /**
     * Testing partition normalPeriod AND reducedPeriod DO NOT overlap
     * Expect no exception to be thrown
     */
    @Test
    void testCase15() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 24), new Period(1, 9)));
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);
        Assertions.assertDoesNotThrow(() -> new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }

    /**
     * Testing partition startHour >= endHour
     * Expect exception thrown
     */
    @Test
    void testCase16() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Period(3, 1));
    }

    /**
     * Testing partition startHour >= endHour
     * Expect exception thrown
     */
    @Test
    void testCase17() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->new Period(0, 0));
    }

    /**
     * Testing partition startHour < 0 OR startHour > 24
     * Expect exception thrown
     */
    @Test
    void testCase18() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Period(-1, 1));
    }

    /**
     * Testing partition startHour < 0 OR startHour > 24
     * Expect exception thrown
     */
    @Test
    void testCase19() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->new Period(24, 1));
    }

    /**
     * Testing partition endHour < 0 OR endHour > 24
     * Expect exception thrown
     */
    @Test
    void testCase20() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->new Period(23, 0));
    }

    /**
     * Testing partition endHour > 0 OR endHour < 24
     * Expect exception thrown
     */
    @Test
    void testCase21() {
        Assertions.assertDoesNotThrow(() -> new Period(23, 24));
    }


    @Test
    void testCase22() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 24), new Period(1, 9)));
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(1);
        Rate rate = new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Period period = new Period(10, 12);
        Assertions.assertEquals(new BigDecimal("6.00"), rate.calculate(period));
    }

    @Test
    void testCas23() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 24), new Period(1, 9)));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.STAFF, null, null, reducedPeriods, normalPeriods));
    }

    @Test
    void testCas24() {
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.STAFF, normalRate, reducedRate, null, null));
    }

    /**
     * Testing normalRate compared to reduced rate
     */
    @Test
    void testCase25() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 24), new Period(1, 9)));
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(2);
        Assertions.assertDoesNotThrow(() ->
                new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods ));
    }

    /**
     * Test case to check visitor gets €10 discount
      */
    @Test
    void rateCalculateVisitorTest1() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 24), new Period(1, 9)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        Rate rate = new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal("0.00"), rate.calculate(new Period(9,11)));
    }

    /**
     * Test case to check visitor gets €10 discount, and 50% off
     */
    @Test
    void rateCalculateVisitorTest2() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 24), new Period(1, 9)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        Rate rate = new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods );
        Assertions.assertEquals(new BigDecimal("2.50"), rate.calculate(new Period(9,12)));
    }

    /**
     * Test case to check management pays minimum €4 when staying at "free hours"
     */
    @Test
    void rateCalculateManagerTest1() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 23), new Period(2, 4)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        Rate rate = new Rate(CarParkKind.MANAGEMENT, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal("4.00"), rate.calculate(new Period(5,7)));
    }

    /**
     * Test case to check management pays minimum €4 when staying at "normal periods"
     */
    @Test
    void rateCalculateManagerTest2() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 23), new Period(1, 9)));
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        Rate rate = new Rate(CarParkKind.MANAGEMENT, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal("4.00"), rate.calculate(new Period(9,10)));
    }

    /**
     * Test case to check management pays minimum €4 when staying at "reduced periods"
     */
    @Test
    void rateCalculateManagerTest3() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 23), new Period(1, 9)));
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        Rate rate = new Rate(CarParkKind.MANAGEMENT, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal("4.00"), rate.calculate(new Period(18,19)));
    }

    /**
     * Test case to check management pays above €4 when staying at "normal periods"
     */
    @Test
    void rateCalculateManagerTest4() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 23), new Period(1, 9)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(1);
        Rate rate = new Rate(CarParkKind.MANAGEMENT, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal("10.00"), rate.calculate(new Period(9,11)));
    }

    /**
     * Test case to check student pays  below €5.50 without discount applied
     */
    @Test
    void rateCalculateStudentTest1() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 23), new Period(1, 9)));
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        Rate rate = new Rate(CarParkKind.STUDENT, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal("4.00"), rate.calculate(new Period(9,11)));
    }

    /**
     * Test case to check student pays exactly €5.50 without discount applied
     */
    @Test
    void rateCalculateStudentTest2() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 23), new Period(1, 9)));
        BigDecimal normalRate = new BigDecimal("2.75");
        BigDecimal reducedRate = new BigDecimal(1);
        Rate rate = new Rate(CarParkKind.STUDENT, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal("5.50"), rate.calculate(new Period(9,11)));
    }

    /**
     * Test case to check student pays above €5.50 with a 25% discount applied
     */
    @Test
    void rateCalculateStudentTest3() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 23), new Period(1, 9)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(1);
        Rate rate = new Rate(CarParkKind.STUDENT, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal("7.50"), rate.calculate(new Period(9,11)));
    }

    /**
     * Test case to check staff pays max €16.
     */
    @Test
    void rateCalculateStaffTest1() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 23), new Period(1, 9)));
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(1);
        Rate rate = new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal("16.00"), rate.calculate(new Period(9,12)));
    }

    /**
     * Test case to check staff pays max €16.
     */
    @Test
    void rateCalculateStaffTest2() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 23), new Period(1, 9)));
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        Rate rate = new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Assertions.assertEquals(new BigDecimal("6.00"), rate.calculate(new Period(9,12)));
    }

    @Test
    public void testRateIsValidPeriod1(){
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(0,12), new Period(14,18), new Period(15,24)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(13,14)));
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriods, normalPeriods));
    }
}
