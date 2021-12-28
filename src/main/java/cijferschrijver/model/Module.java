package cijferschrijver.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="module")
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name="id_semester", nullable = false)
    private Semester semester;

    @OneToMany
    @JoinColumn(name="submodule")
    private List<Module> modules;

    public Module() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Semester getSemester() {
        return semester;
    }
}
