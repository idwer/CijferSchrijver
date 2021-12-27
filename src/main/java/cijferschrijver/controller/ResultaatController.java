package cijferschrijver.controller;

import cijferschrijver.logging.AbstractCrudLogger;
import cijferschrijver.model.Resultaat;
import cijferschrijver.service.ResultaatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ResultaatController {
    @Autowired
    private ResultaatService resultaatService;
    private List<Resultaat> results;

    // query data using, for example, curl:
    // curl -v -X GET http://localhost:8080/results
    @GetMapping("/results")
    public ResponseEntity<List<?>> readAll() {
        return new ResponseEntity<>(resultaatService.findAll(), HttpStatus.OK);
    }

    // query data using, for example, curl:
    // curl -v -X GET http://localhost:8080/result/1
    @GetMapping("/result/{id}")
    public Optional<Resultaat> read(@PathVariable Long id) {
        if (this.results == null)
            this.results = resultaatService.findAll();

        return resultaatService.find(id);
    }

    @PostMapping(path = "/result/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resultaat> add(@RequestBody Resultaat newResultaat) {
        try {
            Resultaat resultaat = resultaatService.save(newResultaat);
            return new ResponseEntity<>(resultaat,  HttpStatus.CREATED);
        } catch (Exception e) {
            AbstractCrudLogger.writeException(e.getMessage());
        }

        return null;
    }

    @PutMapping(path = "/result/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PatchMapping(path = "/result/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resultaat> update(@RequestBody Resultaat resultaat) {
        try {
            return new ResponseEntity<>(resultaatService.update(resultaat), HttpStatus.OK);
           } catch (Exception e) {
            AbstractCrudLogger.writeException(e.getMessage());
        }

        return null;
    }

    @DeleteMapping(path = "/result/delete/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resultaat> delete(@RequestBody Resultaat resultaat) {
        try {
            return new ResponseEntity<>(resultaatService.delete(resultaat), HttpStatus.OK);
        } catch (Exception e) {
            AbstractCrudLogger.writeException(e.getMessage());
        }
        return null;
    }
}
