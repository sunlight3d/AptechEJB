import javafx.beans.property.*;

public class Student {
    private SimpleIntegerProperty studentId;
    private SimpleStringProperty studentName;
    private SimpleStringProperty description;

    public Student(Integer studentId, String studentName, String description) {
        this.studentId = new SimpleIntegerProperty(studentId);
        this.studentName = new SimpleStringProperty(studentName);
        this.description = new SimpleStringProperty(description);
    }

    public int getStudentId() {
        return studentId.get();
    }

    public String getStudentName() {
        return studentName.get();
    }

    public String getDescription() {
        return description.get();
    }


    public void setStudentId(int studentId) {
        this.studentId.set(studentId);
    }

    public void setStudentName(String studentName) {
        this.studentName.set(studentName);
    }

    public void setDescription(String description) {
        this.description.set(description);
    }
}
