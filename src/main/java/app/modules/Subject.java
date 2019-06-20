package app.modules;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subject {


    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long subjectId;
    private long markId;
    private String name;

    public Subject(long subjectId,String name, long markId) {
        this.subjectId = subjectId;
        this.name = name;
        this.markId = markId;
    }

    public Subject() {
    }

    public String getName() {
        return name;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public long getMarkId() {
        return markId;
    }
}
