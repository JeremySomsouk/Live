package com.tippers.containment.live.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java9 {
    static Logger LOGGER = LoggerFactory.getLogger(Java9.class);

    // What's new ?
    // - Java Shell
    // - Jigsaw Project : modular system
    // - Reactive Stream API
    // - Enhanced @Deprecated annotation : forRemoval=true
    // - HTTP 2 client

    @Deprecated(since = "1.9", forRemoval = true)
    public static void deprecatedMethodSinceForRemoval() {}

    public static Set getImmutableSet() {
        List<Integer> integers = List.of(1, 2, 3);
        Map.of();
        return Set.of();
    }

    public static void printProcessInfos() {
        ProcessHandle currentProcess = ProcessHandle.current();
        LOGGER.info("Current Process Infos: = " + currentProcess.info());
        LOGGER.info("Current Process Id: = " + currentProcess.pid());
    }

    public static List<Integer> getListFromOptionalOf(Integer integer) {

        Optional<Integer> one = Optional.empty();
        one.ifPresentOrElse(opt -> { LOGGER.info(opt.toString()); }, () -> LOGGER.warn("Empty optional"));

        one = Optional.of(integer);
        one.ifPresentOrElse(opt -> { LOGGER.info(opt.toString()); }, () -> LOGGER.warn("Empty optional"));

        one = Optional.empty();
        one = one.or(() -> Optional.of(2));
        one.ifPresentOrElse(opt -> { LOGGER.info(opt.toString()); }, () -> LOGGER.warn("Empty optional"));

        return one.stream().collect(Collectors.toList());
    }

    public static void dropNTakeFromStream() {
        Stream.of(1,2,3,4,5,6,7,8,9,10).takeWhile(i -> i < 5 )
                .forEach(elt -> LOGGER.info("First stream : " + elt));
        Stream.of(1,2,3,4,5,6,7,8,9,10).dropWhile(i -> i < 5 )
                .forEach(elt -> LOGGER.info("Second stream : " + elt));
    }

    public static void tryResourceManagement() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("someFile"));
        try (reader) {
            LOGGER.info(reader.readLine());
        }
    }

    public static void completableFuture()  {
        Executor exe = CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS);
    }

    public interface PrivateMethod {
        static String createCardID() {
            return "1234";
        }

        static void displayCardDetails() {
            LOGGER.info(createCardID());
        }
    }

    public static void main(String[] args) {
        getImmutableSet();
        printProcessInfos();
        completableFuture();
        getListFromOptionalOf(1);
        dropNTakeFromStream();
    }
}
