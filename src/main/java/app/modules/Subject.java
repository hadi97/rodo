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
    private int i;
    private int lol;

    public Subject(long subjectId, String name) {
        this.subjectId = subjectId;
        this.name = name;
    }
//hdaawd
    public Subject() {
    }

    public String getName() {
        return name;
    }

    public long getSubjectId() {
        return subjectId;
    }

}
