package com.yzzer.sort;

import java.util.Comparator;

/**
 * @author youzhangzheng
 */
public interface Sorter <T> {

    /**
     * T need to be comparable, will generate default comparator
     * @param data data array
     */
    void sort(T[] data);

    void sort(T[] data, Comparator<T> comparator);
}
