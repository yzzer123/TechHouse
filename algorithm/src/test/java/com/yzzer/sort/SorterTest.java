package com.yzzer.sort;

import org.junit.After;
import org.junit.Before;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author yzzer
 */
public class SorterTest {
    private final int CASE_SIZE = 1000;
    private final Integer[][] testCases = new Integer[CASE_SIZE][];
    private final Integer[][] rightResults = new Integer[CASE_SIZE][];


    @Before
    public void setUp() throws Exception {
        // generate test data
        for (int i = 0; i < CASE_SIZE; i++) {
            Integer[] data = new Integer[(int) (Math.random() * 10000)];
            for (int j = 0; j < data.length; j++) {
              data[j] = (int) (Math.random() * 1000);
            }
            testCases[i] = data;

            Integer[] sortedData = Arrays.copyOf(data, data.length);
            Arrays.sort(sortedData);
            rightResults[i] = sortedData;
        }


    }



    @After
    public void tearDown() throws Exception {
        for (int i = 0; i < CASE_SIZE; i++) {
          assertArrayEquals(testCases[i], rightResults[i]);
        }
    }
}