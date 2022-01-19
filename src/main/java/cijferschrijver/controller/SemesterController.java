package cijferschrijver.controller;

import cijferschrijver.logging.AbstractCrudLogger;
import cijferschrijver.model.Semester;
import cijferschrijver.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class SemesterController {
    @Autowired
    private SemesterService semesterService;
    private List<Semester> semesters;

    // query data using, for example, curl:
    // curl -v -X GET http://localhost:8080/semesters
    @GetMapping("/semesters")
    public ResponseEntity<List<?>> readAll() {
        return new ResponseEntity<>(semesterService.findAll(), HttpStatus.OK);
    }

    // query data using, for example, curl:
    // curl -v -X GET http://localhost:8080/semester/1
    @GetMapping("/semester/{id}")
    public Optional<Semester> read(@PathVariable Long id) {
        if (this.semesters == null)
            this.semesters = semesterService.findAll();

        return semesterService.find(id);
    }

    // add a record using, for example, curl:
    // curl -v -H "content-type: application/json" -d '{"name" : "H-SE-OOSE"}' -X POST http://localhost:8080/semester/add
    @PostMapping(path = "/semester/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Semester> add(@RequestBody Semester newSemester) {
        try {
            Semester semester = semesterService.save(newSemester);
            return new ResponseEntity<>(semesterService.save(newSemester), HttpStatus.CREATED);
        } catch (Exception e) {
            AbstractCrudLogger.writeException(e.getMessage());
        }
        return null;
    }

    @PutMapping(path = "/semester/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PatchMapping(path = "/semester/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Semester> update(@RequestBody Semester semester) {
        try {
            return new ResponseEntity<>(semesterService.update(semester), HttpStatus.OK);
        } catch (Exception e) {
            AbstractCrudLogger.writeException(e.getMessage());
        }
        return null;
    }

    @DeleteMapping(path = "/semester/delete/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Semester> delete(@RequestBody Semester semester) {
        try {
            return new ResponseEntity<>(semesterService.delete(semester), HttpStatus.OK);
        } catch (Exception e) {
            AbstractCrudLogger.writeException(e.getMessage());
        }
        return null;
    }
}
