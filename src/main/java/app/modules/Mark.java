package app.modules;

import javax.persistence.*;

import java.util.Date;
@Entity
@Table(name = "marks")
public class Mark {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer markId;
    private Integer studentId;
    private double mark;
    private Date date;
    private boolean isRead;

    public Mark() {
    }

    public Mark(Integer studentId,  double mark, Date date,boolean isRead) {

        this.studentId = studentId;
        this.mark = mark;
        this.date = date;
        this.isRead = isRead;
    }

    public long getMarkId() {
        return markId;
    }

    public Integer getUserId() {
        return studentId;
    }


    public double getMark() {
        return mark;
    }

    public Date getDate() {
        return date;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public boolean isRead() {
        return isRead;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "userId=" + studentId +
                ", mark=" + mark +
                ", date=" + date +
                '}';
    }
}
