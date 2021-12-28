package cijferschrijver.service;

import cijferschrijver.utility.TimestampGenerator;
import cijferschrijver.logging.AbstractCrudLogger;
import cijferschrijver.model.Result;
import cijferschrijver.model.Student;
import cijferschrijver.repository.ResultRepository;
import cijferschrijver.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultService<T> implements cijferschrijver.service.Service<T> {
    @Autowired
    private ResultRepository resultRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Result> findAll() {
        AbstractCrudLogger.writeEntry(String.format("Retrieved every result on %s",
                TimestampGenerator.generateTimestamp()));

        return (List<Result>) resultRepository.findAll();
    }

    public Optional<Result> find(Long id) {
        Long studentId = resultRepository.findById(id).get().getIdStudent();

        AbstractCrudLogger.writeEntry(String.format("Retrieved results for module %s, ",
                "student %s %s (ID %d), on %s",
                resultRepository.findById(id).get().getModule().getName(),
                studentRepository.findById(studentId).get().getName(),
                studentRepository.findById(studentId).get().getSurname(),
                studentRepository.findById(studentId).get().getId(),
                TimestampGenerator.generateTimestamp()));

        return resultRepository.findById(id);
    }

    public Result save(Result result) {
        result.setTimestamp(TimestampGenerator.generateTimestamp());
        Student student = studentRepository.findById(result.getIdStudent()).get();

        if (result.getGrade() != null && result.getIdModule() != null && result.getIdStudent() != null) {
            resultRepository.save(result);

            AbstractCrudLogger.writeEntry(String.format("Created results for student %s %s (ID %d), ",
                    "module %s on %s",
                    student.getName(),
                    student.getSurname(),
                    student.getId(),
                    result.getModule().getName(),
                    TimestampGenerator.generateTimestamp()));

            return result;
        }

        return null;
    }

    public Result update(Result result) {
        Student student = studentRepository.findById(result.getIdStudent()).get();

        if (resultRepository.existsById(result.getIdStudent())) {
            resultRepository.save(result);

            AbstractCrudLogger.writeEntry(String.format("Updated results for student %s %s (ID %d), ",
                    "module %s on %s",
                    student.getName(),
                    student.getSurname(),
                    student.getId(),
                    result.getModule().getName(),
                    TimestampGenerator.generateTimestamp()));
        }

        return result;
    }

    public Result delete(Result result) {
        Student student = studentRepository.findById(result.getIdStudent()).get();

        if (resultRepository.existsById(result.getIdStudent())) {
            resultRepository.deleteById(result.getIdStudent());

            AbstractCrudLogger.writeEntry(String.format("Deleted results for student %s %s (ID %d), ",
                    "module %s on %s",
                    student.getName(),
                    student.getSurname(),
                    student.getId(),
                    result.getModule().getName(),
                    TimestampGenerator.generateTimestamp()));

            return result;
        }

        return null;
    }
}
