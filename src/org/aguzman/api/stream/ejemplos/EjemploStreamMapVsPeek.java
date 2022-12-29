package org.aguzman.api.stream.ejemplos;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamMapVsPeek {

    /***
     * Note peek is documented to be mainly for debugging purposes
     * Something that ends up being processed inside peek might not be eligible for the terminal operation at all and streams are executed only by a terminal operation.
     ***/
    public static void main(String args[]) {
        example1();
        example2();
    }

    public static void example1() {
        List<Integer> list = new ArrayList<>();
        List<Integer> result = Stream.of(1, 2, 3, 4)
                .peek(x -> list.add(x))
                .map(x -> x * 2)
                .collect(Collectors.toList());

        System.out.println("Example 1 - Peek -> " + list);
        System.out.println("Example 1 - Map -> " + result);
    }

    public static void example2() {
        List<Integer> list = new ArrayList<>();
        List<Integer> result = Stream.of(1, 2, 3, 4)
                .peek(x -> list.add(x))
                .map(x -> x * 2)
                .filter(x -> x > 8)
                .collect(Collectors.toList());

        System.out.println("Example 2 - Peek -> " + list);
        System.out.println("Example 2 - Map -> " + result);
    }

}