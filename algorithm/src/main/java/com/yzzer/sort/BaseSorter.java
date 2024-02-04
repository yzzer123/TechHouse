package com.yzzer.sort;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@SuppressWarnings("unchecked")
public abstract class BaseSorter<T> implements Sorter<T> {

    @SuppressWarnings("rawtypes")
    @Override
    public void sort(T[] data) {

        if (!(data instanceof Comparable[])) {
            ParameterizedType genericSuperclass = (ParameterizedType) (getClass().getGenericSuperclass());
            Type actualTypeArgument = genericSuperclass.getActualTypeArguments()[0];

            throw new IllegalArgumentException("Can not generate default comparator for class: " + actualTypeArgument);
        }

        sort(data, (o1, o2) -> {
            if (!(o1 instanceof Comparable) || !(o2 instanceof Comparable)) {
                throw new IllegalArgumentException("Can not compare obj of class: o1-" + o1.getClass() + "\t o2-" + o2.getClass());
            }
            return ((Comparable) o1).compareTo(o2);
        });
    }
}
