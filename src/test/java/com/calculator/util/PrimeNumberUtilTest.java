package com.calculator.util;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * In the interest of simplicity, will just test the util methods as opposed to the services
 * Created by Franklin on 03/03/2016.
 */
public class PrimeNumberUtilTest {

    @Test
    public void isPrimeTest(){
        List<Integer> primesBetweenMinusOneAndTen = Arrays.asList(new Integer[]{2,3,5,7});
        for(int a = -1; a <= 10; a++ ){
            assertEquals(PrimeNumberUtil.isPrime(a), primesBetweenMinusOneAndTen.contains(Integer.valueOf(a)));
        }
        assertTrue(PrimeNumberUtil.isPrime(99999989));
    }

    @Test
    public void isPrimesWithinRangeUsingParallelStreamTest(){
        int[] primesBetweenOneAndTen = new int[]{2,3,5,7};

        int[] calculatedPrimes = PrimeNumberUtil.primesWithinRangeUsingParallelStream(10);
        Arrays.sort(calculatedPrimes);

        assertTrue(Arrays.equals(primesBetweenOneAndTen, calculatedPrimes));
    }

    @Test
    public void isPrimesWithinRangeTest(){
        int[] primesBetweenOneAndTen = new int[]{2,3,5,7};

        int[] calculatedPrimes = PrimeNumberUtil.primesWithinRange(10);
        Arrays.sort(calculatedPrimes);

        assertTrue(Arrays.equals(primesBetweenOneAndTen, calculatedPrimes));
    }

    @Test
    public void highestPrimeWithinRangeByForkJoinTest(){
        int highestPrime = PrimeNumberUtil.highestPrimeWithinRangeByForkJoin(10);

        assertEquals(7, highestPrime);

        highestPrime = PrimeNumberUtil.highestPrimeWithinRangeByForkJoin(100);

        assertEquals(97, highestPrime);
    }

    @Test
    public void highestPrimeWithinRangeBestSolutionTest(){
        int highestPrime = PrimeNumberUtil.highestPrimeWithinRangeBestSolution(10);

        assertEquals(7, highestPrime);

        highestPrime = PrimeNumberUtil.highestPrimeWithinRangeBestSolution(100);

        assertEquals(97, highestPrime);
    }


}
