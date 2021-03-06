package app.controllers;

import app.modules.Subject;
import app.service.SubjectManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/subjects")
public class SubjectApi {
    private SubjectManager subjectManager;

    @Autowired
    public SubjectApi(SubjectManager subjectManager) {
        this.subjectManager = subjectManager;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET,value = "/getAll")
    public Iterable<Subject> getAll() {
        return subjectManager.findAll();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET,value = "/get")
    public Optional<Subject> getByUserId(@RequestParam Long id ){
        return subjectManager.findByUserId(id);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public Subject addSubject(@RequestBody Subject subject) {
        return subjectManager.save(subject);
    }

}
