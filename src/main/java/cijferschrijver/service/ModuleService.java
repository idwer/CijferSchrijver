package cijferschrijver.service;

import cijferschrijver.utility.TimestampGenerator;
import cijferschrijver.logging.AbstractCrudLogger;
import cijferschrijver.model.Module;
import cijferschrijver.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleService<T> implements cijferschrijver.service.Service<T> {
    @Autowired
    private ModuleRepository moduleRepository;

    @Override
    public List<Module> findAll() {
        AbstractCrudLogger.writeEntry(String.format("Retrieved every module on %s",
                TimestampGenerator.generateTimestamp()));

        return (List<Module>) moduleRepository.findAll();
    }

    public Optional<Module> find(Long id) {
        Module module = moduleRepository.findById(id).get();

        AbstractCrudLogger.writeEntry(String.format("Retrieved module %s on %s",
                module.getName(),
                TimestampGenerator.generateTimestamp()));

        return moduleRepository.findById(id);
    }

    public Module save(Module module) {
        if (module.getName() != null && module.getSemester() != null)  {
            moduleRepository.save(module);

            AbstractCrudLogger.writeEntry(String.format("Created module %s on %s",
                    module.getName(),
                    TimestampGenerator.generateTimestamp()));

            return module;
        }

        return null;
    }

    public Module update(Module module) {
        if (moduleRepository.existsById(module.getId())) {
            moduleRepository.save(module);
            AbstractCrudLogger.writeEntry(String.format("Updated module %s on %s",
                    module.getName(),
                    TimestampGenerator.generateTimestamp()));
        }

        return module;
    }

    public Module delete(Module module) {
        if (moduleRepository.existsById(module.getId())) {
            moduleRepository.deleteById(module.getId());
            AbstractCrudLogger.writeEntry(String.format("Deleted module %s on %s",
                    module.getName(),
                    TimestampGenerator.generateTimestamp()));

            return module;
        }

        return null;
    }
}
