package app.service;

import app.Interfaces.SubjectRepository;
import app.modules.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectManager {
    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectManager(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }


    public Optional<Subject> findById(Long id) {
        return subjectRepository.findById(id);
    }

    public Iterable<Subject> findAll() {
        return subjectRepository.findAll();
    }

    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new Subject("Programming",1));
        save(new Subject("Designing",2));
    }
}
