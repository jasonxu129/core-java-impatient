package ch5;

import java.util.Date;
import java.util.logging.*;

public class Ch5_15 {
    public static class HtmlFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            return "<tr><td>" + (new Date(record.getMillis())).toString() + "</td><td>"
                    + record.getMessage() + "</td></tr>\n";
        }

        @Override
        public String getHead(Handler h) {
            return "<html>\n  <body>\n" + "<table>\n<tr><td>Time</td><td>Log Message</td></tr>\n";
        }

        @Override
        public String getTail(Handler h) {
            return "</table>\n</body>\n</html>";
        }
    }

    public static void testLogger() {
        Logger logger = Logger.getLogger("ch5.Ch5_15");
        logger.setUseParentHandlers(false);
        try {
            FileHandler handler = new FileHandler();
            handler.setFormatter(new HtmlFormatter());
            logger.addHandler(handler);
        } catch (Exception ex) {
            logger.log(Level.INFO, "Fail to create File handler", ex);
        }

        logger.info("Hello world!");
        logger.info("Java is awesome");
    }

    public static void main(String[] args) {
        testLogger();
    }
}
