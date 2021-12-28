package cijferschrijver.controller;

import cijferschrijver.logging.AbstractCrudLogger;
import cijferschrijver.model.Student;
import cijferschrijver.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController implements Controller {
    @Autowired
    private StudentService studentService;
    private List<Student> students;

    // query data using, for example, curl:
    // curl -v -X GET http://localhost:8080/students
    @GetMapping("/students")
    public ResponseEntity<List<?>> readAll() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    // query data using, for example, curl:
    // curl -v -X GET http://localhost:8080/student/1
    @GetMapping("/student/{id}")
    public Optional<Student> read(@PathVariable Long id) {
        if (this.students == null)
            this.students = studentService.findAll();

        return (Optional<Student>) studentService.find(id);
    }

    // add a record using, for example, curl:
    // curl -v -H "content-type: application/json" -d '{"name": "Barbara", "surname": "Liskov"}' -X POST http://localhost:8080/student/add
    @PostMapping(path = "/student/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> add(@RequestBody Student newStudent)  {
        Student student = studentService.save(newStudent);
        try {
            return new ResponseEntity<>(student,  HttpStatus.CREATED);
            } catch (Exception e) {
            AbstractCrudLogger.writeException(e.getMessage());
        }
        return null;
    }

    @PutMapping(path = "/student/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PatchMapping(path = "/student/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> update(@RequestBody Student student) {
        try {
            return new ResponseEntity<>(studentService.update(student), HttpStatus.OK);
        } catch (Exception e) {
            AbstractCrudLogger.writeException(e.getMessage());
        }
        return null;
    }

    @DeleteMapping(path = "/student/delete/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> delete(@RequestBody Student student) {
        try {
            return new ResponseEntity<>(studentService.delete(student), HttpStatus.OK);
        } catch (Exception e) {
            AbstractCrudLogger.writeException(e.getMessage());
        }
        return null;
    }
}
