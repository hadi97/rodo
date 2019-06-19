package app.controllers;

import app.modules.Subject;
import app.service.SubjectManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/subjects")
public class SubjectApi {
    private SubjectManager subjectManager;

    @Autowired
    public SubjectApi(SubjectManager subjectManager) {
        this.subjectManager = subjectManager;
    }

    @CrossOrigin
    @GetMapping("/all")
    public Iterable<Subject> getAll() {
        return subjectManager.findAll();
    }

    @CrossOrigin
    @GetMapping
    public Optional<Subject> getById(@RequestParam Long index) {
        return subjectManager.findById(index);
    }

    @CrossOrigin
    @PostMapping
    public Subject addSubject(@RequestBody Subject subject) {
        return subjectManager.save(subject);
    }

}
