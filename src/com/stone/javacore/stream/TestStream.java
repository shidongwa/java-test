package com.stone.javacore.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {

    public static void main(String[] args) {
        List<List<Integer>> result = Stream.of(Arrays.asList(1), Arrays.asList(2, 3))
                .collect(Collectors.toList());
        // [[1], [2, 3]]
        System.out.println("result:" + result);

        List<Integer> result2 = Stream.of(Arrays.asList(1), Arrays.asList(2, 3))
                //.flatMap(Collection::stream)
                .flatMap(l -> l.stream())
                .collect(Collectors.toList());
        // [1, 2, 3]
        System.out.println("result2:" + result2);
    }
}
