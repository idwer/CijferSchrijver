package cijferschrijver.Utility;

import java.sql.Timestamp;
import java.util.Date;

public class TimestampGenerator {
    public static Timestamp generateTimestamp() {
        Date date = new Date();
        return new Timestamp(date.getTime());
    }
}
