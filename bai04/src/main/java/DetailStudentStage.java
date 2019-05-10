import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.*;
import javafx.scene.*;

public class DetailStudentStage extends Stage {
    private Scene scene;
    private GridPane gridPane = new GridPane();
    private Label lblName = new Label("Enter name: ");
    private TextField textFieldName = new TextField();

    private Label lblDescription = new Label("Description: ");
    private TextField textFieldDescription = new TextField();

    private Button btnSave = new Button("Save");
    private Button btnCancel = new Button("Cancel");
    private Student selectedStudent;
    private SecondStage secondStage;
    private String type = "insert";

    public void setType(String type) {
        this.type = type;
        this.loadData();
    }

    public void setParent(SecondStage secondStage) {
        this.secondStage = secondStage;
    }
    public DetailStudentStage(Student selectedStudent) {
        super();
        this.selectedStudent = selectedStudent;
        this.setupUI();
    }
    public void loadData() {
        if(type == "update") {
            textFieldName.setText(selectedStudent.getStudentName());
            textFieldDescription.setText(selectedStudent.getDescription());
            btnSave.setText("Update");
        } else if(type=="insert"){
            //Insert new Student
            selectedStudent = new Student();
            btnSave.setText("Insert");
            System.out.println("dddd");
        }
    }
    private void setupUI() {
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(lblName, 0, 0);
        gridPane.add(textFieldName, 1, 0);

        gridPane.add(lblDescription, 0, 1);
        gridPane.add(textFieldDescription, 1, 1);

        gridPane.add(btnSave, 0, 2);
        gridPane.add(btnCancel, 1, 2);

        scene = new Scene(gridPane, 300, 250);
        this.setScene(scene);
        btnCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                close();
            }
        });
        btnSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                selectedStudent.setStudentName(textFieldName.getText());
                selectedStudent.setDescription(textFieldDescription.getText());
                if(type == "insert"){
                    secondStage.addNewStudent(selectedStudent);
                }
                close();
            }
        });

    }
}
