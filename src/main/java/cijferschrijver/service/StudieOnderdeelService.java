package cijferschrijver.service;

import cijferschrijver.utility.TimestampGenerator;
import cijferschrijver.logging.AbstractCrudLogger;
import cijferschrijver.model.StudieOnderdeel;
import cijferschrijver.repository.StudieOnderdeelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudieOnderdeelService<T> implements cijferschrijver.service.Service<T> {
    @Autowired
    private StudieOnderdeelRepository studieOnderdeelRepository;

    @Override
    public List<StudieOnderdeel> findAll() {
        AbstractCrudLogger.writeEntry(String.format("Retrieved every module on %s",
                TimestampGenerator.generateTimestamp()));

        return (List<StudieOnderdeel>) studieOnderdeelRepository.findAll();
    }

    public Optional<StudieOnderdeel> find(Long id) {
        StudieOnderdeel studieOnderdeel = studieOnderdeelRepository.findById(id).get();

        AbstractCrudLogger.writeEntry(String.format("Retrieved module %s on %s",
                studieOnderdeel.getNaam(),
                TimestampGenerator.generateTimestamp()));

        return studieOnderdeelRepository.findById(id);
    }

    public StudieOnderdeel save(StudieOnderdeel studieOnderdeel) {
        if (studieOnderdeel.getNaam() != null && studieOnderdeel.getSemester() != null)  {
            studieOnderdeelRepository.save(studieOnderdeel);

            AbstractCrudLogger.writeEntry(String.format("Created module %s on %s",
                    studieOnderdeel.getNaam(),
                    TimestampGenerator.generateTimestamp()));

            return studieOnderdeel;
        }

        return null;
    }

    public StudieOnderdeel update(StudieOnderdeel studieOnderdeel) {
        if (studieOnderdeelRepository.existsById(studieOnderdeel.getId())) {
            studieOnderdeelRepository.save(studieOnderdeel);
            AbstractCrudLogger.writeEntry(String.format("Updated module %s on %s",
                    studieOnderdeel.getNaam(),
                    TimestampGenerator.generateTimestamp()));
        }

        return studieOnderdeel;
    }

    public StudieOnderdeel delete(StudieOnderdeel studieOnderdeel) {
        if (studieOnderdeelRepository.existsById(studieOnderdeel.getId())) {
            studieOnderdeelRepository.deleteById(studieOnderdeel.getId());
            AbstractCrudLogger.writeEntry(String.format("Deleted module %s on %s",
                    studieOnderdeel.getNaam(),
                    TimestampGenerator.generateTimestamp()));

            return studieOnderdeel;
        }

        return null;
    }
}
