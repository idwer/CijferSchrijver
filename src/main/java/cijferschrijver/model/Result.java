package cijferschrijver.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@IdClass(ResultaatId.class)
public class Resultaat {
    @Id
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss.SSSSSS",  timezone = "Europe/Amsterdam")
    private Timestamp timestamp;

    @Column(nullable = false)
    private Double cijfer;

    @ManyToOne
    @JoinColumn(name="id_student", nullable = false)
    private Student student;

    @OneToOne
    @JoinColumn(name="id_onderdeel", nullable = false)
    private StudieOnderdeel studieOnderdeel;

    @Transient
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private Long id_onderdeel;

    @Transient
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private Long id_student;

    public Resultaat() {
    }

    public Resultaat(Double cijfer, Long id_onderdeel, Long id_student) {
        this.cijfer = cijfer;
        this.id_onderdeel = id_onderdeel;
        this.id_student = id_student;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Long getIdOnderdeel() {
        return this.studieOnderdeel.getId();
    }

    public Double getCijfer() {
        return cijfer;
    }

    public Long getIdStudent() {
        return this.student.getId();
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public StudieOnderdeel getStudieOnderdeel() {
        return studieOnderdeel;
    }

    public Student getStudent() {
        return student;
    }
}
