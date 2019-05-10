import com.sun.org.apache.bcel.internal.generic.TABLESWITCH;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Optional;

public class SecondStage extends Stage {
    private VBox vbox = new VBox();
    private Scene scene;
    private Label label = new Label();
    private String name = "";
    //Table
    private TableView tableView = new TableView<Student>();
    //columns
    private TableColumn columnStudentId = new TableColumn("Id sinh vien");
    private TableColumn columnStudentName = new TableColumn("Ten sinh vien");
    private TableColumn columnDescription  = new TableColumn("Mo ta");
    private ObservableList<Student> students = FXCollections.observableArrayList(
            new Student(1, "Hoang", "This is 1"),
            new Student(2, "Hoang 2", "This is 2"),
            new Student(3, "Hoang 3", "This is 3")

    );
    private Button btnAdd = new Button("Add new Student");
    private Integer numberOfClicks = 0;
    private ContextMenu contextMenu = new ContextMenu();
    private MenuItem menuItemDelete = new MenuItem("Delete");
    private MenuItem menuItemProperties = new MenuItem("Properties ");
    private Student selectedStudent;
    private DetailStudentStage detailStudentStage;
    private void setupTable() {
        columnStudentId.setMinWidth(120);
        columnStudentId.setCellValueFactory(new PropertyValueFactory<String, String>("studentId"));

        columnStudentName.setMinWidth(120);
        columnStudentName.setCellValueFactory(new PropertyValueFactory<String, String>("studentName"));

        columnDescription.setMinWidth(120);
        columnDescription.setCellValueFactory(new PropertyValueFactory<String, String>("description"));
        tableView.setItems(students);
        tableView.getColumns().addAll(columnStudentId, columnStudentName, columnDescription);

        tableView.setRowFactory(tv -> {
            final TableRow<Student> tableRow = new TableRow<Student>();
            tableRow.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    try {
                        numberOfClicks++;
    //                    System.out.println("Mouse click: "+numberOfClicks);
                        selectedStudent = (Student)tableRow.getItem();
                        System.out.println("selected student"+selectedStudent.getStudentName());
                        if(event.getClickCount() == 2) {
                            System.out.println("Double click");
                            showUpdateStudent();
                        } else if(event.getButton() == MouseButton.SECONDARY) {
                            System.out.println("Right click");
                            contextMenu.show(tableRow, event.getScreenX(), event.getScreenY());
                        }
                    } catch (NullPointerException e) {
                        //
                    }
                }
            });
            return tableRow;
        });
        contextMenu.getItems().addAll(menuItemDelete, menuItemProperties);
        menuItemDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showConfirmation();
            }
        });
        menuItemProperties.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showUpdateStudent();
            }
        });
    }
    private void showUpdateStudent() {
        System.out.println("You press properties");
        detailStudentStage = new DetailStudentStage(selectedStudent);
        detailStudentStage.setParent(SecondStage.this);
        detailStudentStage.setType("update");
        detailStudentStage.setOnHiding(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.out.println("ddd");
                tableView.refresh();
            }
        });
        detailStudentStage.showAndWait();
    }
    public void addNewStudent(Student newStudent) {
        students.add(newStudent);
        tableView.refresh();
    }
    private void showConfirmation() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete a student");
        alert.setHeaderText("Delete a student ");

        ButtonType btnYes = new ButtonType("Yes");
        ButtonType btnNo = new ButtonType("No");

        alert.getButtonTypes().clear();

        alert.getButtonTypes().addAll(btnYes, btnNo);
        Optional<ButtonType> option = alert.showAndWait();

        if (option.get() == null) {
            this.label.setText("No selection!");
        } else if (option.get() == btnYes) {
            System.out.println("Yes");
            students.remove(selectedStudent);
            tableView.setItems(students);
        } else if (option.get() == btnNo) {
            System.out.println("No");
        }
    }

    SecondStage(String name){
        super();
        this.name = name;
        this.initUI();
    }
    public void initUI() {
        this.setTitle("Second screen");
        setupTable();
        vbox.setPadding(new Insets(30,10,10,10));
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setSpacing(10);
        label.setText("This is second screen:\n"+this.name);
        label.setFont(Font.font(30));
        vbox.getChildren().addAll(label, tableView, btnAdd);
        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                detailStudentStage = new DetailStudentStage(null);
                detailStudentStage.setType("insert");
                detailStudentStage.setParent(SecondStage.this);
                detailStudentStage.show();
            }
        });
        scene = new Scene(vbox, 600,680);
        this.setScene(scene);

    }

}
