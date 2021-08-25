package app.service;

import app.Interfaces.MarkRepository;
import app.Interfaces.StudentRepository;

import app.Interfaces.UserRepository;
import app.modules.Mark;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MarkManager {
    private final MarkRepository markRepository;
    private final StudentRepository studentRepository;
    private final UserRepository userRepository;

    @Autowired
    public MarkManager(MarkRepository markRepository,StudentRepository studentRepository,UserRepository userRepository) {
        this.markRepository = markRepository;
        this.studentRepository=studentRepository;
        this.userRepository=userRepository;
    }

    //get marks by subjectID
   /* public Iterable<Mark> findMarksBySubjectId(Long subjectId) {
        Iterable<Mark> marks = markRepository.findAll();
        return StreamSupport.stream(marks.spliterator(), false)
                .filter(mark -> mark.getSubjectId() == subjectId)
                .collect(Collectors.toList());
    }*/

    //get all marks
    public Iterable<Mark> findAll(String username) {
        Integer userId = userRepository.findAll().stream().filter(account -> account.getUsername().equals(username))
                .findAny().get().getAccountId();
        Integer studentId = studentRepository.findAll().stream().filter(student -> student.getAccountId().equals(userId))
                .findAny().get().getStudentId();

        return markRepository.findAll().stream().filter(mark -> mark.getStudentId().equals(studentId)).collect(Collectors.toList());

    }


    public Mark save(Mark mark) {
        return markRepository.save(mark);
    }


    public Integer getStudentId(String index){
        return studentRepository.findAll()
                .stream()
                .filter(student -> student.getIndexNr().equals(Integer.valueOf(index)))
                .findAny()
                .get()
                .getStudentId();
    }

/*
    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new Mark(211111, 1, 4.5, LocalDate.of(2018, 2, 3)));
        save(new Mark(209999, 1, 4, LocalDate.of(2018, 2, 3)));
        save(new Mark(212322, 2, 4.5, LocalDate.of(2018, 2, 1)));
        save(new Mark(223121, 2, 3.5, LocalDate.of(2018, 2, 1)));
        save(new Mark(212151, 2, 4.5, LocalDate.of(2018, 2, 1)));
        save(new Mark(201231, 2, 4, LocalDate.of(2018, 2, 1)));
        save(new Mark(192312, 1, 2, LocalDate.of(2018, 2, 3)));
        save(new Mark(213531, 1, 3, LocalDate.of(2018, 2, 3)));

    }
*/
}
