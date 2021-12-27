package cijferschrijver.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Controller {
    public ResponseEntity<List<?>> readAll();
}
