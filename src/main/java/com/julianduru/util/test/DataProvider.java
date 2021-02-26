package com.julianduru.util.test;


import com.github.javafaker.Faker;
import com.julianduru.util.NullAwareBeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * created by julian
 */
public interface DataProvider<T> {


    Faker faker = new Faker();


    T provide();


    default T provide(T sample) {
        T data = provide();
        NullAwareBeanUtils.copy(sample, data);

        return data;
    }


    default List<T> provide(int count) {
        List<T> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            list.add(provide());
        }

        return list;
    }


    default List<T> provide(T sample, int count) {
        List<T> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            list.add(provide(sample));
        }

        return list;
    }



}
