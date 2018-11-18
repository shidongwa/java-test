package com.stone.log;

import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class JavaUtilLogTest {
    private static Logger LOGGER = null;

    static {
        Logger mainLogger = Logger.getLogger(JavaUtilLogTest.class.getName());
        mainLogger.setUseParentHandlers(false);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter() {
//            private static final String format = "[%1$tF %1$tT] [%2$-7s] %3$s %n";
            private static final String format = "%1$tF %1$tH:%1$tM:%1$tS %2$s%n";


            @Override
            public synchronized String format(LogRecord lr) {
                return String.format(format,
                        new Date(lr.getMillis()),
                        lr.getLevel().getLocalizedName(),
                        lr.getMessage()
                );
            }
        });
        mainLogger.addHandler(handler);
        LOGGER = Logger.getLogger(JavaUtilLogTest.class.getName());
    }

    public static void main(String[] args) {
        System.out.println("-- main method starts --");
        LOGGER.info("in MyClass3");
        LOGGER.warning("a test warning");
    }
}
