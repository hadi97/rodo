package app.modules;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
@Entity
public class Mark {

    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private long markId;
    private long subjectId;
    private int points;
    private double mark;
    private LocalDate date;

    public Mark() {
    }

    public Mark(long markId, long subjectId, int points, double mark, LocalDate date) {
        this.markId = markId;
        this.subjectId = subjectId;
        this.points = points;
        this.mark = mark;
        this.date = date;
    }

    public long getMarkId() {
        return markId;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public int getPoints() {
        return points;
    }

    public double getMark() {
        return mark;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "markId=" + markId +
                ", subjectId=" + subjectId +
                ", points=" + points +
                ", mark=" + mark +
                ", date=" + date +
                '}';
    }
}
