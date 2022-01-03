package cijferschrijver.controller;

import cijferschrijver.logging.AbstractCrudLogger;
import cijferschrijver.model.Module;
import cijferschrijver.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ModuleController implements Controller {
    @Autowired
    private ModuleService moduleService;
    private List<Module> modules;

    // query data using, for example, curl:
    // curl -v -X GET http://localhost:8080/modules
    @GetMapping("/modules")
    public ResponseEntity<List<?>> readAll() {
        return new ResponseEntity<>(moduleService.findAll(), HttpStatus.OK);
    }

    // query data using, for example, curl:
    // curl -v -X GET http://localhost:8080/module/1
    @GetMapping("/module/{id}")
    public Optional<Module> read(@PathVariable Long id) {
        if (this.modules == null)
            this.modules = moduleService.findAll();

        return moduleService.find(id);
    }

    // add a record using, for example, curl:
    // curl -v -H "content-type: application/json" -d '{"name" : "BIT", "semester" : {"id": "1"}}' -X POST http://localhost:8080/module/add
    @PostMapping(path = "/module/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Module> add(@RequestBody Module newModule) {
        try {
            Module module = moduleService.save(newModule);
            return new ResponseEntity<>(moduleService.save(newModule), HttpStatus.CREATED);

        } catch (Exception e) {
            AbstractCrudLogger.writeException(e.getMessage());
        }
        return null;
    }

    @PutMapping(path = "/module/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PatchMapping(path = "/module/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Module> update(@RequestBody Module module) {
        try {
            return new ResponseEntity<>(moduleService.update(module), HttpStatus.OK);
        } catch (Exception e) {
            AbstractCrudLogger.writeException(e.getMessage());
        }
        return null;
    }

    @DeleteMapping(path = "/module/delete/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Module> delete(@RequestBody Module module) {
        try {
            return new ResponseEntity<>(moduleService.delete(module), HttpStatus.OK);
        } catch (Exception e) {
            AbstractCrudLogger.writeException(e.getMessage());
        }
        return null;
    }
}
