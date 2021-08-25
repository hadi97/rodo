package app.controllers;


import app.modules.Mark;
import app.modules.MarkDTO;
import app.service.MarkManager;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;


@RestController
@RequestMapping(value = "/marks")
public class MarkApi {
    private MarkManager markManager;

    @Autowired
    public MarkApi(MarkManager markManager) {
        this.markManager = markManager;

    }

    @CrossOrigin
    @GetMapping(value = "/getAll/{username}")
    public Iterable<Mark> getAll(@PathVariable String username) {
        return markManager.findAll(username);
    }

    //marks for one subject
  //  @CrossOrigin
  //  @GetMapping(value = "/get")
  //  public Iterable<Mark> getById(@RequestParam Long subjectId) {
 //       return markManager.findMarksBySubjectId(subjectId);
  //  }

    @CrossOrigin
    @PostMapping
    public Mark addMark(@RequestBody MarkDTO markDTO) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Integer studentId = markManager.getStudentId(markDTO.getIndex());
        Mark mark = new Mark(studentId,Double.valueOf(markDTO.getMark()),sdf.parse(markDTO.getDate()),false);
        return markManager.save(mark);
    }



}
