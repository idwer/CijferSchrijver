package cijferschrijver.service;

import cijferschrijver.utility.TimestampGenerator;
import cijferschrijver.logging.AbstractCrudLogger;
import cijferschrijver.model.Student;
import cijferschrijver.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService<T> implements cijferschrijver.service.Service<T> {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        AbstractCrudLogger.writeEntry(String.format("Retrieved every student on %s",
                TimestampGenerator.generateTimestamp()));

        return (List<Student>) studentRepository.findAll();
    }

    public Optional<Student> find(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        Student logStudent = student.get();

        AbstractCrudLogger.writeEntry(String.format("Retrieved student %s %s (ID %d) on %s",
                logStudent.getName(),
                logStudent.getSurname(),
                logStudent.getId(),
                TimestampGenerator.generateTimestamp()));

        return student;
    }

    public Student save(Student student) {
        if (student.getName() != null && student.getSurname() != null) {
            studentRepository.save(student);

            AbstractCrudLogger.writeEntry(String.format("Created student %s %s (ID %d) on %s",
                    student.getName(),
                    student.getSurname(),
                    student.getId(),
                    TimestampGenerator.generateTimestamp()));

            return student;
        }

        return null;
    }

    public Student update(Student student) {
        if (studentRepository.existsById(student.getId())) {
            studentRepository.save(student);

            AbstractCrudLogger.writeEntry(String.format("Updated student %s %s (ID %d) on %s",
                    student.getName(),
                    student.getSurname(),
                    student.getId(),
                    TimestampGenerator.generateTimestamp()));
        }

        return student;
    }

    public Student delete(Student student) {
        if (studentRepository.existsById(student.getId())) {
            studentRepository.deleteById(student.getId());

            AbstractCrudLogger.writeEntry(String.format("Deleted student %s %s (ID %d) on %s",
                    student.getName(),
                    student.getSurname(),
                    student.getId(),
                    TimestampGenerator.generateTimestamp()));
            return student;
        }

        return null;
    }
}
