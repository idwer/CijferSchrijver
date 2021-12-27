package cijferschrijver.controller;

import cijferschrijver.logging.AbstractCrudLogger;
import cijferschrijver.model.StudieOnderdeel;
import cijferschrijver.service.StudieOnderdeelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudieOnderdeelController implements Controller {
    @Autowired
    private StudieOnderdeelService studieOnderdeelService;
    private List<StudieOnderdeel> studieOnderdelen;

    // query data using, for example, curl:
    // curl -v -X GET http://localhost:8080/modules
    @GetMapping("/modules")
    public ResponseEntity<List<?>> readAll() {
        return new ResponseEntity<>(studieOnderdeelService.findAll(), HttpStatus.OK);
    }

    // query data using, for example, curl:
    // curl -v -X GET http://localhost:8080/module/1
    @GetMapping("/module/{id}")
    public Optional<StudieOnderdeel> read(@PathVariable Long id) {
        if (this.studieOnderdelen == null)
            this.studieOnderdelen = studieOnderdeelService.findAll();

        return studieOnderdeelService.find(id);
    }

    // add a record using, for example, curl:
    // curl -v -H "content-type: application/json" -d '{"naam" : "BIT", "semester" : {"id": "1"}}' -X POST http://localhost:8080/module/add
    @PostMapping(path = "/module/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudieOnderdeel> add(@RequestBody StudieOnderdeel newStudieOnderdeel) {
        try {
            StudieOnderdeel studieOnderdeel = studieOnderdeelService.save(newStudieOnderdeel);
            return new ResponseEntity<>(studieOnderdeelService.save(newStudieOnderdeel), HttpStatus.CREATED);

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
    public ResponseEntity<StudieOnderdeel> update(@RequestBody StudieOnderdeel studieOnderdeel) {
        try {
            return new ResponseEntity<>(studieOnderdeelService.update(studieOnderdeel), HttpStatus.OK);
        } catch (Exception e) {
            AbstractCrudLogger.writeException(e.getMessage());
        }
        return null;
    }

    @DeleteMapping(path = "/module/delete/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudieOnderdeel> delete(@RequestBody StudieOnderdeel studieOnderdeel) {
        try {
            return new ResponseEntity<>(studieOnderdeelService.delete(studieOnderdeel), HttpStatus.OK);
        } catch (Exception e) {
            AbstractCrudLogger.writeException(e.getMessage());
        }
        return null;
    }
}
