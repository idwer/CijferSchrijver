package cijferschrijver.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public abstract class AbstractCrudLogger {
    private static final Logger crudLogger = Logger.getLogger(AbstractCrudLogger.class.toString());
    private static final Logger exceptionLogger = Logger.getLogger(AbstractCrudLogger.class.toString());
    private static FileHandler fileHandlerCrud;
    private static FileHandler fileHandlerExceptions;

    public static void writeEntry(String message) {
        try {
            fileHandlerCrud = new FileHandler("crud_operations.log", true);
            crudLogger.addHandler(fileHandlerCrud);
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandlerCrud.setFormatter(simpleFormatter);

            crudLogger.info(message);

            fileHandlerCrud.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeException(String message) {
        try {
            fileHandlerExceptions = new FileHandler("exceptions.log", true);
            crudLogger.addHandler(fileHandlerExceptions);
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandlerExceptions.setFormatter(simpleFormatter);

            exceptionLogger.info(message);

            fileHandlerExceptions.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
