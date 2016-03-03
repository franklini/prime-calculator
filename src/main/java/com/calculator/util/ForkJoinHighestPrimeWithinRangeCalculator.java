package com.calculator.util;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

/**
 * Created by Franklin on 02/03/2016.
 */
public class ForkJoinHighestPrimeWithinRangeCalculator extends RecursiveTask<Integer> {
    public static final long THRESHOLD = 10_000;
    private final int[] primes;
    private final int start;
    private final int end;

    public ForkJoinHighestPrimeWithinRangeCalculator(int[] primes) {
        this(primes, 0, primes.length);
    }

    private ForkJoinHighestPrimeWithinRangeCalculator(int[] primes, int start, int end) {
        this.primes = primes;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        if (end - start <= THRESHOLD) {
            // number of elements is at or below the threshold - compute directly
            return computeSequentially();
        } else {
            int mid = start + (end-start) / 2;
            ForkJoinHighestPrimeWithinRangeCalculator left = new ForkJoinHighestPrimeWithinRangeCalculator(primes, start, mid);
            ForkJoinHighestPrimeWithinRangeCalculator right = new ForkJoinHighestPrimeWithinRangeCalculator(primes, mid, end);

            invokeAll(left, right);

            return Math.max(left.join(), right.join());

        }

    }

    /**
     * not using lambda here for variety
     * @return
     */
    private Integer computeSequentially() {
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            if (primes[i] > max) {
                max = primes[i];
            }
        }
        return max;
    }

    public static Integer forkJoinHighestPrimeinRange(int[] primesInRange) {

        ForkJoinHighestPrimeWithinRangeCalculator task = new ForkJoinHighestPrimeWithinRangeCalculator(primesInRange);
        return new ForkJoinPool().invoke(task);
    }
}