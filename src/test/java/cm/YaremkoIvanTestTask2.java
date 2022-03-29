package cm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.lang.model.type.NullType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ivan Yaremko 01/03/2022
 */

public class YaremkoIvanTestTask2 {


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
        BigDecimal normalRate = new BigDecimal(1);
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
        Assertions.assertThrows(IllegalArgumentException.class, () ->
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

    /**

     */
    @Test
    void testCase22() {
        ArrayList<Period> normalPeriods = new ArrayList<>(Arrays.asList(new Period(9, 13), new Period(13, 18)));
        ArrayList<Period> reducedPeriods = new ArrayList<>(Arrays.asList(new Period(18, 24), new Period(1, 9)));
        BigDecimal normalRate = new BigDecimal(3);
        BigDecimal reducedRate = new BigDecimal(1);
        Rate rate = new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriods, normalPeriods);
        Period period = new Period(10, 12);
        Assertions.assertEquals(new BigDecimal(6), rate.calculate(period));
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
}
