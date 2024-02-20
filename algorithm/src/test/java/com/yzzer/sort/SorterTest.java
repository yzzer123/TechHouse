package com.yzzer.sort;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author yzzer
 */
public class SorterTest {
    private final int CASE_SIZE = 300;
    private final Integer[][] testCases = new Integer[CASE_SIZE][];
    private final Integer[][] rightResults = new Integer[CASE_SIZE][];
    private Sorter<Integer> sorter;


    @Before
    public void setUp() throws Exception {
        // generate test data
        for (int i = 0; i < CASE_SIZE; i++) {
            Integer[] data = new Integer[i < 30 ? 30: 1000];
            for (int j = 0; j < data.length; j++) {
              data[j] = (int) (Math.random() * 1000);
            }
            testCases[i] = data;

            Integer[] sortedData = Arrays.copyOf(data, data.length);
            Arrays.sort(sortedData);
            rightResults[i] = sortedData;
        }
    }

    @Test
    public void testHeapSort() {
      sorter = new HeapSorter<>();
    }

    @Test
    public void testBubbleSort() {
      sorter = new BubbleSorter<>();
    }

    @Test
    public void testInsertSort() {
      sorter = new InsertSorter<>();
    }

    @Test
    public void testBinaryInsertSort() {
      sorter = new BinaryInsertSorter<>();
    }

    @Test
    public void testSelectSort() {
      sorter = new SelectSorter<>();
    }

    @Test
    public void testMergeSort() {
      sorter = new MergeSorter<>();
    }

    @Test
    public void testQuickSort() {
      sorter = new OnePivotQuickSorter<>();
    }

  @Test
  public void testQuickSort2() {
    sorter = new DualPivotsQuickSorter<>();
  }

    @After
    public void tearDown() throws Exception {
      StopWatch stopWatch = StopWatch.createStarted();
      for (int i = 0; i < CASE_SIZE; i++) {
        sorter.sort(testCases[i]);
        try {
          assertArrayEquals(testCases[i], rightResults[i]);
        } catch (AssertionError e) {
          System.out.println("CASE " + i + ":");
          System.out.println(Arrays.toString(testCases[i]));
          System.out.println(Arrays.toString(rightResults[i]));
          throw e;
        }
      }
      stopWatch.stop();
      System.out.println("sort " + CASE_SIZE + " arrays costs: " + stopWatch.getTime(TimeUnit.MILLISECONDS) + "ms");

    }
}