package cijferschrijver.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String voornaam;
    @Column(length = 100, nullable = false)
    private String achternaam;

    @OneToMany(mappedBy = "student")
    private List<Resultaat> resultaten;

    @OneToMany(mappedBy = "student")
    List<SemesterStudent> semesterStudents;

    public Student() {
    }

    public Student(Long id, String voornaam, String achternaam) {
        this.id = id;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
    }

    public Long getId() {
        return id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }
}
