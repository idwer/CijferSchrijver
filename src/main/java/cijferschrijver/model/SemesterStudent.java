package cijferschrijver.model;

import javax.persistence.*;

@Entity
public class SemesterStudent {
    @EmbeddedId
    SemesterStudentId id;

    @ManyToOne
    @MapsId("idStudent")
    @JoinColumn(name = "id_student")
    Student student;

    @ManyToOne
    @MapsId("idSemester")
    @JoinColumn(name = "id_semester")
    Semester semester;
}
