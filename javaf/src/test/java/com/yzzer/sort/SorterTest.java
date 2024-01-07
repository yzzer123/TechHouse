package com.yzzer.sort;

import org.junit.After;
import org.junit.Before;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author yzzer
 */
public class SorterTest {
    private Integer[] data;
    private Integer[] sortedData;
    
    @Before
    public void setUp() throws Exception {
        // generate test data
        data = new Integer[(int) (Math.random() * 20)];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 100);
        }

        sortedData = Arrays.copyOf(data, data.length);
        Arrays.sort(sortedData);
    }



    @After
    public void tearDown() throws Exception {
        assertArrayEquals(data, sortedData);
    }
}