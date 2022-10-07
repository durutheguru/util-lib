package com.julianduru.util;

import java.util.List;
import java.util.stream.Collectors;

/**
 * created by julian on 18/07/2022
 */
public class StringUtil {


    public static String stringifyList(List<String> strings) {
        return stringifyList(strings, "\"");
    }


    public static String stringifyList(List<String> strings, String delimiter) {
        var preparedStringList = strings.stream()
            .map(
                str -> str.trim()
                    .replaceAll("^", delimiter)
                    .replaceAll("$", delimiter)
            )
            .toList();
        return preparedStringList.toString();
    }


}

