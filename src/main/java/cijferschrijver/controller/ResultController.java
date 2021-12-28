package cijferschrijver.controller;

import cijferschrijver.logging.AbstractCrudLogger;
import cijferschrijver.model.Result;
import cijferschrijver.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ResultController {
    @Autowired
    private ResultService resultService;
    private List<Result> results;

    // query data using, for example, curl:
    // curl -v -X GET http://localhost:8080/results
    @GetMapping("/results")
    public ResponseEntity<List<?>> readAll() {
        return new ResponseEntity<>(resultService.findAll(), HttpStatus.OK);
    }

    // query data using, for example, curl:
    // curl -v -X GET http://localhost:8080/result/1
    @GetMapping("/result/{id}")
    public Optional<Result> read(@PathVariable Long id) {
        if (this.results == null)
            this.results = resultService.findAll();

        return resultService.find(id);
    }

    @PostMapping(path = "/result/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> add(@RequestBody Result newResult) {
        try {
            Result result = resultService.save(newResult);
            return new ResponseEntity<>(result,  HttpStatus.CREATED);
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
    public ResponseEntity<Result> update(@RequestBody Result result) {
        try {
            return new ResponseEntity<>(resultService.update(result), HttpStatus.OK);
           } catch (Exception e) {
            AbstractCrudLogger.writeException(e.getMessage());
        }

        return null;
    }

    @DeleteMapping(path = "/result/delete/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> delete(@RequestBody Result result) {
        try {
            return new ResponseEntity<>(resultService.delete(result), HttpStatus.OK);
        } catch (Exception e) {
            AbstractCrudLogger.writeException(e.getMessage());
        }
        return null;
    }
}
