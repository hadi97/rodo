package app.service;

import app.Interfaces.MarkRepository;
import app.Interfaces.SubjectRepository;
import app.modules.Mark;
import app.modules.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class MarkManager {
    private final MarkRepository markRepository;
    private final SubjectRepository subjectRepository;

    @Autowired
    public MarkManager(MarkRepository markRepository, SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
        this.markRepository = markRepository;
    }

    //get mark by subjectID
    public Optional<Mark> findBySubjectId(Long subjectId) {
        Optional<Subject> subject= subjectRepository.findById(subjectId);
        return subject.flatMap(subject1 -> markRepository.findById(subject1.getMarkId()));
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
        save(new Mark(1, 1, 16, 4.5, LocalDate.of(2018, 2, 3)));
        save(new Mark(2, 2, 15, 4, LocalDate.of(2018, 1, 2)));
    }
}
