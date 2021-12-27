package cijferschrijver.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public abstract class AbstractCrudLogger {
    private static final Logger logger = Logger.getLogger(AbstractCrudLogger.class.toString());
    private static FileHandler fileHandlerCrud;
    private static FileHandler fileHandlerExceptions;

    public static void writeEntry(String message) {
        try {
            fileHandlerCrud = new FileHandler("crud_operations.log", true);
            logger.addHandler(fileHandlerCrud);
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandlerCrud.setFormatter(simpleFormatter);

            logger.info(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeException(String message) {
        try {
            fileHandlerExceptions = new FileHandler("exceptions.log");
            logger.addHandler(fileHandlerExceptions);
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandlerExceptions.setFormatter(simpleFormatter);

            logger.info(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
