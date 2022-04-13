package cijferschrijver.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@IdClass(ResultId.class)
public class Result {
    @Id
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss.SSSSSS",  timezone = "Europe/Amsterdam")
    private Timestamp timestamp;

    @Column(nullable = false)
    private Double grade;

    @ManyToOne
    @JoinColumn(name="id_student", nullable = false)
    @Id
    private Student student;

    @OneToOne
    @JoinColumn(name="id_module", nullable = false)
    @Id
    private Module module;

    @Transient
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private Long id_module;

    @Transient
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private Long id_student;

    public Result() {
    }

    public Result(Double grade, Long id_module, Long id_student) {
        this.grade = grade;
        this.id_module = id_module;
        this.id_student = id_student;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Long getModuleId() {
        return this.module.getId();
    }

    public Double getGrade() {
        return grade;
    }

    public Long getStudentId() {
        return this.student.getId();
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public Module getModule() {
        return module;
    }

    public Student getStudent() {
        return student;
    }
}
