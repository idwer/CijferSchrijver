package cijferschrijver.service;

import cijferschrijver.Utility.TimestampGenerator;
import cijferschrijver.logging.AbstractCrudLogger;
import cijferschrijver.model.Semester;
import cijferschrijver.repository.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class SemesterService<T> implements cijferschrijver.service.Service<T> {
    @Autowired
    private SemesterRepository semesterRepository;

    @Override
    public List<Semester> findAll() {
        AbstractCrudLogger.writeEntry(String.format("Retrieved every semester on %s",
                TimestampGenerator.generateTimestamp()));

        return (List<Semester>) semesterRepository.findAll();
    }

    public Optional<Semester> find(Long id) {
        Semester semester = semesterRepository.findById(id).get();
        AbstractCrudLogger.writeEntry(String.format("Retrieved semester %s on %s",
                semester.getNaam(),
                TimestampGenerator.generateTimestamp()));

        return semesterRepository.findById(id);
    }

    public Semester save(Semester semester) {
        if (semester.getNaam() != null)  {
            semesterRepository.save(semester);
            AbstractCrudLogger.writeEntry(String.format("Created semester %s on %s",
                    semester.getNaam(),
                    TimestampGenerator.generateTimestamp()));

            return semester;
        }

        return null;
    }

    public Semester update(Semester semester) {
        if (semesterRepository.existsById(semester.getId())) {
            semesterRepository.save(semester);
        }
        AbstractCrudLogger.writeEntry(String.format("Updated semester %s on %s",
                semester.getNaam(),
                TimestampGenerator.generateTimestamp()));
        return semester;
    }

    public Semester delete(Semester semester) {
        if (semesterRepository.existsById(semester.getId())) {
            semesterRepository.deleteById(semester.getId());
            AbstractCrudLogger.writeEntry(String.format("Deleted semester %s on %s",
                    semester.getNaam(),
                    TimestampGenerator.generateTimestamp()));
            return semester;
        }

        return null;
    }
}
