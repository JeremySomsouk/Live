package com.tippers.containment.live.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Java13 {
    static Logger LOGGER = LoggerFactory.getLogger(Java13.class);

    // What's new ?
    // Text Blocks – JEP 355
    // New Methods in String Class for Text Blocks
    // Switch Expressions Enhancements – JEP 354
    // Reimplement the Legacy Socket API – JEP 353
    // Dynamic CDS Archive – JEP 350
    // ZGC: Uncommit Unused Memory – JEP 351
    // FileSystems.newFileSystem() Method
    // Support for Unicode 12.1
    // DOM and SAX Factories with Namespace Support

    private enum Day {
        SUN, MON, TUE
    };

    public static String getDay(int month, Day d) {
        int x = switch (month) {
            case 1, 2, 3, 4, 5, 6, 7, 8 ,9 ,10 ,11, 12:
                yield month;
            default:
                yield -1;
        };

        String day = switch (d) {
            case SUN -> "Sunday";
            case MON -> "Monday";
            case TUE -> "Tuesday";
        };
        return day;
    }

    public static void main(String[] args) {
        LOGGER.info(getDay(1, Day.MON));
    }
}
