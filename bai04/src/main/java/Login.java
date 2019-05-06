import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Login extends Stage {
    private VBox vbox = new VBox();
    private HBox hBoxButton = new HBox();
    private TextField txtName;
    private Button btnLogin;
    private PasswordField passwordField;
    private Scene scene;
    private Label labelOutputText = new Label();
    private SecondStage secondStage;
    public void initUI() {
        this.setTitle("Login screen");
        vbox.setPadding(new Insets(30,10,10,10));
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setSpacing(10);
        txtName = new TextField();
        txtName.setMinHeight(40);
        btnLogin = new Button("Login");
        passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");
        passwordField.setMinHeight(40);
        hBoxButton.getChildren().add(btnLogin);
        hBoxButton.setAlignment(Pos.CENTER);
        btnLogin.setMinWidth(120);
        btnLogin.setMinHeight(40);
        btnLogin.setFont(Font.font(20));
        vbox.getChildren().addAll(txtName,passwordField, hBoxButton, labelOutputText);
        scene = new Scene(vbox, 320,680);
        this.setScene(scene);
    }
    public void setupActions() {
        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String name = Login.this.txtName.getText();
                String password = Login.this.passwordField.getText();
                Login.this.labelOutputText.setText("Passwword is:"+password+"Name :"+name);
                if(!validateName()) {
                    return;
                } else {
                    SecondStage secondStage = new SecondStage(Login.this.txtName.getText());
                    secondStage.initUI();
                    secondStage.showAndWait();
                }
            }
        });
    }
    private Boolean validateName() {
        if(txtName.getText().length() < 3) {
            labelOutputText.setTextFill(Color.web("#ff0000"));
            return false;
        }
        labelOutputText.setTextFill(Color.web("#00ff00"));
        return true;
    }
}
