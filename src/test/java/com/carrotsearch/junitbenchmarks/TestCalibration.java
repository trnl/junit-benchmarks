package com.carrotsearch.junitbenchmarks;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author Uladzimir Mihura
 *         Date: 10/8/12
 *         Time: 6:17 PM
 */
public class TestCalibration
{


    double k = 0;

    @Rule
    public TestRule benchmarkRun = new BenchmarkRule();

    @Test
    @BenchmarkOptions(estimatedTime = 10000, benchmarkRounds = 1, warmupRounds = 1)
    public void test1() throws InterruptedException
    {
        for (int i = 0; i < Globals.ITERATIONS; i++)
        {
            k += Math.sqrt(1000+i);
        }
    }

    @Test
    @BenchmarkOptions(estimatedTime = 5000, benchmarkRounds = 1,warmupRounds = 1)
    public void test2() throws InterruptedException
    {
        for (int i = 0; i < Globals.ITERATIONS; i++)
        {
            TimeUnit.SECONDS.sleep(1);
        }
    }

    @Test
    @BenchmarkOptions(estimatedTime = 3000, benchmarkRounds = 1,warmupRounds = 1)
    public void test3() throws InterruptedException
    {
        for (int i = 0; i < Globals.ITERATIONS; i++)
        {
            TimeUnit.SECONDS.sleep(1);
        }
    }

    @Test
    @BenchmarkOptions(estimatedTime = 10000, benchmarkRounds = 1,warmupRounds = 1)
    public void test4() throws InterruptedException
    {
        for (int i = 0; i < Globals.ITERATIONS; i++)
        {
            UUID u = new UUID(100,System.currentTimeMillis());
        }
    }
}
