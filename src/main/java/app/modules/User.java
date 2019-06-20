package app.modules;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    private String name;
    private String role;
    private String password;
    private long subjectId;

    public User() {
    }

    public User(long userId, String name, String role, String password, long subjectId, long markId) {
        this.userId=userId;
        this.name = name;
        this.role = role;
        this.password = password;
        this.subjectId = subjectId;
    }

    public long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public long getSubjectId() {
        return subjectId;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                ", subjectId=" + subjectId +
                '}';
    }
}
