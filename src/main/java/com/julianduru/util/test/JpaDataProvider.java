package com.julianduru.util.test;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * created by julian
 */
public interface JpaDataProvider<T> extends DataProvider<T> {


    JpaRepository<T, Long> getRepository();


    default T getOrSave() {
        JpaRepository<T, Long> repository = getRepository();
        Page<T> page = repository.findAll(PageRequest.of(0, 1));
        if (page.hasContent()) {
            return page.getContent().get(0);
        }

        return save();
    }


    default T getOrSave(T sample) {
        JpaRepository<T, Long> repository = getRepository();
        Page<T> page = repository.findAll(PageRequest.of(0, 1));
        if (page.hasContent()) {
            return page.getContent().get(0);
        }

        return save(sample);
    }


    default T save() {
        return getRepository().save(provide());
    }


    default T save(T sample) {
        return getRepository().save(provide(sample));
    }


    default List<T> save(int count) {
        List<T> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            list.add(save());
        }

        return list;
    }


    default List<T> save(T sample, int count) {
        List<T> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            list.add(save(sample));
        }

        return list;
    }


    default List<T> save(T... samples) {
        JpaRepository<T, Long> repository = getRepository();

        return Arrays
            .asList(samples)
            .stream()
            .map(sample -> repository.save(provide(sample)))
            .collect(Collectors.toList());
    }


}
