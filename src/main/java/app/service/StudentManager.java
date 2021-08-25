package app.service;

import app.Interfaces.StudentRepository;
import app.modules.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentManager {
    private StudentRepository studentRepository;

    @Autowired
    StudentManager(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
}
    public Iterable<Student> findAllStudents() {
        return this.studentRepository.findAll();

    }





}
