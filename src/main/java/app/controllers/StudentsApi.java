package app.controllers;


import app.modules.Student;
import app.modules.StudentDTO;
import app.service.StudentManager;
import app.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentsApi {

    private final StudentManager studentManager;
    private final UserManager userManager;

    @Autowired
    public StudentsApi(StudentManager studentRepository, UserManager userRepository) {
        this.studentManager = studentRepository;
        this.userManager = userRepository;
    }

    @GetMapping
    public List<StudentDTO> getStudents(){
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student student : studentManager.findAllStudents()){
            studentDTOS.add(new StudentDTO(student.getStudentId(),userManager.getName(student.getAccountId()),student.getIndexNr()));
        }
        return studentDTOS;
    }

}
