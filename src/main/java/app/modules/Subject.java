package app.modules;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subject {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long subjectId;
    private String name;

    public Subject(String name, long subjectId) {
        this.name = name;
        this.subjectId = subjectId;
    }

    public Subject() {
    }

    public String getName() {
        return name;
    }

    public long getSubjectId() {
        return subjectId;
    }
}
