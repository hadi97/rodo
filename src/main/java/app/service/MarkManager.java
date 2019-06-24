package app.service;

import app.Interfaces.MarkRepository;
import app.Interfaces.SubjectRepository;
import app.modules.Mark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MarkManager {
    private final MarkRepository markRepository;
    private final SubjectRepository subjectRepository;

    @Autowired
    public MarkManager(MarkRepository markRepository, SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
        this.markRepository = markRepository;
    }

    //get marks by subjectID
    public Iterable<Mark> findMarksBySubjectId(Long subjectId) {
        Iterable <Mark> marks = markRepository.findAll();
        return StreamSupport.stream(marks.spliterator(),false)
                .filter(mark -> mark.getSubjectId() == subjectId)
                .collect(Collectors.toList());
    }
    //get all marks
    public Iterable<Mark> findAll() {
        return markRepository.findAll();
    }



    public Mark save(Mark mark) {
        return markRepository.save(mark);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new Mark(211111, 1, 16, 4.5, LocalDate.of(2018, 2, 3)));
        save(new Mark(209999, 1, 15, 4, LocalDate.of(2018, 2, 3)));
        save(new Mark(212322, 2, 17, 4.5, LocalDate.of(2018, 2, 1)));
        save(new Mark(223121, 2, 13, 3.5, LocalDate.of(2018, 2, 1)));
        save(new Mark(212151, 2, 17, 4.5, LocalDate.of(2018, 2, 1)));
        save(new Mark(201231, 2, 15, 4, LocalDate.of(2018, 2, 1)));
        save(new Mark(192312, 1, 4, 2, LocalDate.of(2018, 2, 3)));
        save(new Mark(213531, 1, 10, 3, LocalDate.of(2018, 2, 3)));

    }
}
