package com.tippers.containment.live.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.summingDouble;

public class Java12 {
    static Logger LOGGER = LoggerFactory.getLogger(Java12.class);

    // What's new ?
    // JVM Changes :
    // 1) Shenandoah: A Low-Pause-Time Garbage Collector
    // 2) Promptly Return Unused Committed Memory from G1
    // 3) Abortable Mixed Collections for G1, prioritize on collecting the mandatory set first to meet the pause time goal.

    public static String executeNewSwitchExpression(String day) {
        return switch (day) {
            case "M", "W", "F" -> "MWF";
            case "T", "TH", "S" -> "TTS";
            default -> "unknown day";
        };
    }

    public static long getMismatchPosition(String str1, String str2) throws IOException {
        Path filePath1 = Files.createTempFile("file1", ".txt");
        Path filePath2 = Files.createTempFile("file2", ".txt");
        Files.writeString(filePath1, str1);
        Files.writeString(filePath2, str2);

        return Files.mismatch(filePath1, filePath2);
    }

    public static String numberShortFormat(Integer numberToFormat) {
        NumberFormat formatter = NumberFormat
                .getCompactNumberInstance(new Locale("fr", "FR"), NumberFormat.Style.SHORT);
        formatter.setMaximumFractionDigits(1);
        return formatter.format(numberToFormat);
    }

    public static double teeCollector() {
        return Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.teeing(
                        summingDouble(i -> i),
                        counting(),
                        (sum, n) -> sum / n
                ));
    }

    public static List<String> stringAPIEnhancement() {
        String s = "Hi,Hello,Howdy";
        List<String> stringList = s.transform(s1 -> Arrays.asList(s1.split(",")));
        return stringList.stream().map(str -> str.indent(1)).collect(Collectors.toUnmodifiableList());
    }

    /*
    public static String instanceOfPatternMatching(Object obj) {
        if (obj instanceof String s) {
            return "Object is a String of value : " + s;
        }

        return "Object is not a String";
    }*/

    public static void main(String[] args) throws IOException {
        LOGGER.info("Switch Monday : " + executeNewSwitchExpression("M"));
        LOGGER.info("Switch Unknown : " + executeNewSwitchExpression("Z"));
        LOGGER.info("Mismatch() same files : " + getMismatchPosition("same", "same"));
        LOGGER.info("Mismatch() different files at second char : " + getMismatchPosition("same", "sAme"));
        LOGGER.info(numberShortFormat(12345));
        LOGGER.info(numberShortFormat(123));
        LOGGER.info("Teeing collector : " + teeCollector());
        LOGGER.info(stringAPIEnhancement().toString());
    }
}
