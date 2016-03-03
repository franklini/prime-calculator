package com.calculator;

import com.calculator.util.PrimeNumberUtil;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Franklin on 02/03/2016.
 */
@RestController
public class PrimeController {

    private static Logger logger = Logger.getLogger(PrimeController.class);

    /**
     * will return a boolean signifying whether the passed number is a prime or not
     * @param number
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/isPrime")
    public Boolean isPrimeNumber(@RequestParam(value="number", required=true) int number){
        long start = System.nanoTime();

        Boolean result = PrimeNumberUtil.isPrime(number);

        long duration = (System.nanoTime() - start) / 1_000_000;
        logger.info("isPrimeNumber(" + number + ") took " + duration + " msecs");
        return result;
    }

    /**
     * compute all prime numbers from 2 to n and return as int[]
     * @param number
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/primesWithinRange")
    public int[] primesWithinRange(@RequestParam(value="number", required=true) int number){
        long start = System.nanoTime();

        int[] result = PrimeNumberUtil.primesWithinRange(number);

        long duration = (System.nanoTime() - start) / 1_000_000;
        logger.info("primesWithinRange(" + number + ") took " + duration + " msecs");
        return result;
    }

    /**
     * compute all prime numbers from 2 to n and return as int[]. This solution uses ParallelStream
     * @param number
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/primesWithinRangeUsingParallelStream")
    public int[] primesWithinRangeUsingParallelStream(@RequestParam(value="number", required=true) int number){
        long start = System.nanoTime();

        int[] result = PrimeNumberUtil.primesWithinRangeUsingParallelStream(number);

        long duration = (System.nanoTime() - start) / 1_000_000;
        logger.info("primesWithinRangeUsingParallelStream(" + number + ") took " + duration + " msecs");
        return result;
    }

    /**
     * compute all prime numbers from 2 to n and return the highest prime in the range
     * @param number
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/highestPrimeWithinRangeByForkJoin")
    public int highestPrimeWithinRangeByForkJoin(@RequestParam(value="number", required=true) int number){
        long start = System.nanoTime();

        int result = PrimeNumberUtil.highestPrimeWithinRangeByForkJoin(number);

        long duration = (System.nanoTime() - start) / 1_000_000;
        logger.info("highestPrimeWithinRangeByForkJoin(" + number + ") took " + duration + " msecs");
        return result;
    }

    /**
     * compute all prime numbers from 2 to n and return the highest prime in the range. This solution is more efficient
     * @param number
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/highestPrimeWithinRangeBestSolution")
    public int highestPrimeWithinRangeBestSolution(@RequestParam(value="number", required=true) int number){
        long start = System.nanoTime();

        int result = PrimeNumberUtil.highestPrimeWithinRangeBestSolution(number);

        long duration = (System.nanoTime() - start) / 1_000_000;
        logger.info("highestPrimeWithinRangeBestSolution(" + number + ") took " + duration + " msecs");
        return result;
    }




}
