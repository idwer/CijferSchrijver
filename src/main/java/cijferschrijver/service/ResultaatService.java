package cijferschrijver.service;

import cijferschrijver.Utility.TimestampGenerator;
import cijferschrijver.logging.AbstractCrudLogger;
import cijferschrijver.model.Resultaat;
import cijferschrijver.model.Student;
import cijferschrijver.repository.ResultaatRepository;
import cijferschrijver.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultaatService<T> implements cijferschrijver.service.Service<T> {
    @Autowired
    private ResultaatRepository resultaatRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Resultaat> findAll() {
        AbstractCrudLogger.writeEntry(String.format("Retrieved every result on %s",
                TimestampGenerator.generateTimestamp()));

        return (List<Resultaat>) resultaatRepository.findAll();
    }

    public Optional<Resultaat> find(Long id) {
        Long studentId = resultaatRepository.findById(id).get().getIdStudent();

        AbstractCrudLogger.writeEntry(String.format("Retrieved results for module %s, ",
                "student %s %s (ID %d), on %s",
                resultaatRepository.findById(id).get().getStudieOnderdeel().getNaam(),
                studentRepository.findById(studentId).get().getVoornaam(),
                studentRepository.findById(studentId).get().getAchternaam(),
                studentRepository.findById(studentId).get().getId(),
                TimestampGenerator.generateTimestamp()));

        return resultaatRepository.findById(id);
    }

    public Resultaat save(Resultaat resultaat) {
        resultaat.setTimestamp(TimestampGenerator.generateTimestamp());
        Student student = studentRepository.findById(resultaat.getIdStudent()).get();

        if (resultaat.getCijfer() != null && resultaat.getIdOnderdeel() != null && resultaat.getIdStudent() != null) {
            resultaatRepository.save(resultaat);

            AbstractCrudLogger.writeEntry(String.format("Created results for student %s %s (ID %d), ",
                    "module %s on %s",
                    student.getVoornaam(),
                    student.getAchternaam(),
                    student.getId(),
                    resultaat.getStudieOnderdeel().getNaam(),
                    TimestampGenerator.generateTimestamp()));

            return resultaat;
        }

        return null;
    }

    public Resultaat update(Resultaat resultaat) {
        Student student = studentRepository.findById(resultaat.getIdStudent()).get();

        if (resultaatRepository.existsById(resultaat.getIdStudent())) {
            resultaatRepository.save(resultaat);

            AbstractCrudLogger.writeEntry(String.format("Updated results for student %s %s (ID %d), ",
                    "module %s on %s",
                    student.getVoornaam(),
                    student.getAchternaam(),
                    student.getId(),
                    resultaat.getStudieOnderdeel().getNaam(),
                    TimestampGenerator.generateTimestamp()));
        }

        return resultaat;
    }

    public Resultaat delete(Resultaat resultaat) {
        Student student = studentRepository.findById(resultaat.getIdStudent()).get();

        if (resultaatRepository.existsById(resultaat.getIdStudent())) {
            resultaatRepository.deleteById(resultaat.getIdStudent());

            AbstractCrudLogger.writeEntry(String.format("Deleted results for student %s %s (ID %d), ",
                    "module %s on %s",
                    student.getVoornaam(),
                    student.getAchternaam(),
                    student.getId(),
                    resultaat.getStudieOnderdeel().getNaam(),
                    TimestampGenerator.generateTimestamp()));

            return resultaat;
        }

        return null;
    }
}
