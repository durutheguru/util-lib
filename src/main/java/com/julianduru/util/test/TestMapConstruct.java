package com.julianduru.util.test;




import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * created by julian
 */
public class TestMapConstruct<T, U> {


    private Map<T, Pair<U, U>> map = new HashMap<>();


    public void put(T key, U value) throws IllegalStateException {
        if (map.containsKey(key)) {
            var pair = map.get(key);
            if (pair.getValue() != null) {
                throw new IllegalStateException(
                    String.format("Map Key %s contains a fully initialized pair", key)
                );
            }

            pair.setValue(value);
        }
        else {
            map.put(key, Pair.of(value, null));
        }
    }


    private void assertResultEquality(Function<U, U> func) {
        map.forEach(
            (key, pair) ->
                assertThat(pair.getRight())
                    .isEqualTo(func.apply(pair.getLeft()))
        );
    }


}
