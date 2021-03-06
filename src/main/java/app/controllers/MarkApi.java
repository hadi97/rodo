package app.controllers;

import app.modules.Mark;
import app.service.MarkManager;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;



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

    //marks for one subject
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/get")
    public Iterable<Mark> getById(@RequestParam Long subjectId) {
        return markManager.findMarksBySubjectId(subjectId);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST )
    public Mark addMark(@RequestBody Mark mark) {
        return markManager.save(mark);
    }

}
