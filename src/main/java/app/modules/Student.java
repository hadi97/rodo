package app.modules;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;


    private Integer indexNr;

    private Integer accountId;

    public Student(Integer indexNr, Integer accountId) {
        this.indexNr = indexNr;
        this.accountId = accountId;
    }



    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Student() {
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }



    public Integer getIndexNr() {
        return indexNr;
    }

    public void setIndexNr(Integer indexNr) {
        this.indexNr = indexNr;
    }
}
