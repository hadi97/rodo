package app.modules;

public class StudentDTO {
    private Integer studentId;
    private String name;
    private Integer index;

    public StudentDTO(Integer studentId, String name, Integer index) {
        this.studentId = studentId;
        this.name = name;

        this.index = index;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
