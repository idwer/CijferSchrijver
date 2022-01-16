package cijferschrijver.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class ResultId implements Serializable {
    private Timestamp timestamp;
    private long student;
    private long module;

    public ResultId() {
    }

    public ResultId(Timestamp timestamp, long student, long module) {
        this.timestamp = timestamp;
        this.student = student;
        this.module = module;
    }
}
