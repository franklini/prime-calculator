package com.calculator.util;

import org.apache.log4j.Logger;

import java.util.stream.IntStream;

/**
 * This is a prime number utility class which mostly uses java 8 futures to calculate prime numbers for different scenarios
 * Created by Franklin on 02/03/2016.
 */
public class PrimeNumberUtil {

    static Logger logger = Logger.getLogger(PrimeNumberUtil.class);

    /**
     * this method returns a boolean stating whether the given number is a prime number
     * @param candidate
     * @return
     */
    public static Boolean isPrime(int candidate) {
        if(candidate <= 1)
            return false;
        return IntStream.rangeClosed(2, candidate-1)
                .limit((long) Math.floor(Math.sqrt((double) candidate)) - 1)
                .noneMatch(i -> candidate % i == 0);
    }


    public static int[] primesWithinRangeUsingParallelStream(int range){
        if(range <= 1)
            return new int[]{};

        return IntStream.rangeClosed(1, range).parallel().filter(PrimeNumberUtil::isPrime).toArray();
    }

    public static int[] primesWithinRange(int range){
        if(range <= 1)
            return new int[]{};

        return IntStream.rangeClosed(1, range).filter(PrimeNumberUtil::isPrime).toArray();
    }

    /**
     * this method is overkill but was implemented to use Fork/Join as a current implementaion for this task. the method
     * highestPrimeWithinRangeBestSolution is a better and more efficient approach
     * @param range
     * @return
     */
    public static int highestPrimeWithinRangeByForkJoin(int range){
        int[] primesInRange = primesWithinRangeUsingParallelStream(range);

        int highestPrimeWithinRange = ForkJoinHighestPrimeWithinRangeCalculator.forkJoinHighestPrimeinRange(primesInRange);

        return highestPrimeWithinRange;

    }

    public static int highestPrimeWithinRangeBestSolution(int range){
        if(range <= 1)
            return 0;

        return IntStream.rangeClosed(1, range).parallel().filter(PrimeNumberUtil::isPrime).max().getAsInt();
    }

}
