package app.controllers;

import app.modules.Mark;
import app.service.MarkManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/marks")
public class MarkApi {
    private MarkManager markManager;

    @Autowired
    public MarkApi(MarkManager markManager) {
        this.markManager = markManager;

    }
    @CrossOrigin
    @GetMapping("/all")
    public Iterable<Mark> getAll() {
        return markManager.findAll();
    }

    @CrossOrigin
    @GetMapping
    public Optional<Mark> getById(@RequestParam Long id) {
        return markManager.findById(id);
    }

    @CrossOrigin
    @PostMapping
    public Mark addMark(@RequestBody Mark mark) {
        return markManager.save(mark);
    }

}
