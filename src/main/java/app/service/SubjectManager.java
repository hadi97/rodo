package app.service;

import app.Interfaces.SubjectRepository;
import app.Interfaces.UserRepository;
import app.modules.Subject;
import app.modules.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectManager {
    private final SubjectRepository subjectRepository;
    private final UserRepository userRepository;

    @Autowired
    public SubjectManager(UserRepository userRepository, SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
        this.userRepository = userRepository;
    }


    //get subject by userID
    public Optional<Subject> findByUserId(Long userId) {
        Optional<User> user= userRepository.findById(userId);
        return user.flatMap(user1 -> (subjectRepository.findById(user1.getSubjectId())));
    }


    //get all subjects
    public Iterable<Subject> findAll() {
        return subjectRepository.findAll();
    }

    //adding subject
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new Subject(1,"Programming", 1));
        save(new Subject(2,"Designing",2));
    }
}
