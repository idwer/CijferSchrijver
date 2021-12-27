package cijferschrijver.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SemesterStudentId implements Serializable {
    private Long idStudent;
    private Long idSemester;
}
