package cijferschrijver.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="studieonderdeel")
public class StudieOnderdeel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20, nullable = false)
    private String naam;

    @ManyToOne
    @JoinColumn(name="id_semester", nullable = false)
    private Semester semester;

    @OneToMany
    @JoinColumn(name="subonderdeel")
    private List<StudieOnderdeel> studieOnderdelen;

    public StudieOnderdeel() {
    }

    public Long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public Semester getSemester() {
        return semester;
    }
}
