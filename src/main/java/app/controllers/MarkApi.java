package app.controllers;

import app.modules.Mark;
import app.service.MarkManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

import java.util.Optional;

@RestController
@RequestMapping("api/marks")
public class MarkApi {
    private MarkManager markManager;

    @Autowired
    public MarkApi(MarkManager markManager) {
        this.markManager = markManager;

    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public Iterable<Mark> getAll() {
        return markManager.findAll();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/get")
    public Optional<Mark> getById(@RequestParam Long id) {
        return markManager.findById(id);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public Mark addMark(@RequestBody Mark mark) {
        return markManager.save(mark);
    }

}
