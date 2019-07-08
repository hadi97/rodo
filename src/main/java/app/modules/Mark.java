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
    private long userId;
    private long subjectId;
    private int points;
    private double mark;
    private LocalDate date;

    public Mark() {
    }

    public Mark(long userId, long subjectId, int points, double mark, LocalDate date) {
        this.userId = userId;
        this.subjectId = subjectId;
        this.points = points;
        this.mark = mark;
        this.date = date;
    }

    public long getUserId() {
        return userId;
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
                "userId=" + userId +
                ", subjectId=" + subjectId +
                ", points=" + points +
                ", mark=" + mark +
                ", date=" + date +
                '}';
    }
}
