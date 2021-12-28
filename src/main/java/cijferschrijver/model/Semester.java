package cijferschrijver.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20, nullable = false)
    private String name;

    @OneToMany(mappedBy = "semester")
    private List<Module> modules;

    @OneToMany(mappedBy = "semester")
    List<SemesterStudent> semesterStudents;

    public Semester() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
