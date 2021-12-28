package cijferschrijver.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 100, nullable = false)
    private String surname;

    @OneToMany(mappedBy = "student")
    private List<Result> results;

    @OneToMany(mappedBy = "student")
    List<SemesterStudent> semesterStudents;

    public Student() {
    }

    public Student(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
