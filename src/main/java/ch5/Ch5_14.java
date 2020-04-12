package ch5;

import java.util.logging.Logger;

public class Ch5_14 {
    public static void testLogger() {
        Logger logger = Logger.getLogger("ch5.Ch5_14");
        logger.setFilter(logRecord -> {
            String msg = logRecord.getMessage().toLowerCase();
            if (msg.contains("sex") || msg.contains("drug") || msg.contains("c++")) {
                return false;
            }
            return true;
        });

        logger.info("Hello Logger!");
        // Use Supplier interface.
        logger.info(() -> "No sex");
        logger.info("No drug");
        logger.info("Java and c++");
        logger.info("Logger and LogHandler");
    }

    public static void main(String[] args) {
        testLogger();
    }
}
