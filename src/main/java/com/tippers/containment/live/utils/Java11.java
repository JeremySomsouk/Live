package com.tippers.containment.live.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.function.BiConsumer;

public class Java11 {
    static Logger LOGGER = LoggerFactory.getLogger(Java11.class);

    // What's new ?
    // - Epsilon: A No-Op Garbage Collector
    // - Nested Based Access Control
    // - Running Java File with single command
    // - Remove the Java EE and CORBA Modules
    // - Flight Recorder : profiling tool used to gather diagnostics and profiling data from a running Java application.
    // Its performance overhead is negligible and that’s usually below 1%. Hence it can be used in production applications.
    // - HTTP 2 client standardized
    // - ChaCha20 and Poly1305 Cryptographic Algorithms
    // - ZGC: A Scalable Low-Latency Garbage Collector (Experimental)

    // String API enhancement : isBlank(), strip(), stripLeading(), stripTrailing(), repeat(x);
    public static void stringAPIEnhancement() {
        String a = "";
        if (a.isBlank()) {
            String allInOne = " A \n B \n C ";
            long count = allInOne.lines()
                    .peek(line -> LOGGER.info(line))
                    .map(String::strip)
                    .peek(line -> LOGGER.info(line))
                    .map(line -> line.repeat(5))
                    .peek(line -> LOGGER.info(line))
                    .count();
            LOGGER.info(String.format("String has %d lines", count));
        }
    }

    public static void varLambdaLanguageFeature() {
        String a = "a";
        String b = "b";
        BiConsumer<String, String> c = (var s1, var s2) -> LOGGER.info(s1 + s2);
        c.accept(a, b);
    }

    public static void readAndWriteFiles() throws IOException {
        Files.readString(Path.of("lalala"));
        Files.writeString(Path.of("lololo"), "Hello", StandardOpenOption.APPEND);
    }

    public static void main(String[] args) {
        stringAPIEnhancement();
        varLambdaLanguageFeature();
    }
}
