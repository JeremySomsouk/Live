package com.tippers.containment.live.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

public class Java10 {
    static Logger LOGGER = LoggerFactory.getLogger(Java10.class);

    // What's new ?
    // - Container awareness
    // - JIT Compiler C++ / Graal Plugin in full Java
    // - Parallel full GC
    // - Garbage-Collector Interface
    // - Thread-Local Handshakes
    // - Some removed API marked as deprecated in Java 9
    // - Time-Based Release Versioning

    public static void printOneToFiveVariables() {
        var numberList = List.of(1, 2, 3, 4, 5);

        for (var number : numberList) {
            LOGGER.info(number.toString());
        }
    }

    public static List<String> getCopyOf(List<String> collection) {
        return List.copyOf(collection);
    }

    public static List<String> getUnmodifiableList(List<String> collection) {
        return collection.stream().collect(Collectors.toUnmodifiableList());
    }

    public static Double getDoubleOrElseThrow() {
        Optional<Double> age = Optional.ofNullable(Math.random());
        LOGGER.info("Age = " + age);
        return age.orElseThrow();
    }

    public static void main(String[] args) {
        printOneToFiveVariables();
        List<String> copyOf = getCopyOf(List.of("a", "b", "c"));
        getUnmodifiableList(copyOf);
        getDoubleOrElseThrow();
    }
}
