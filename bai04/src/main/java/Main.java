import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args){
        Application.launch(args);
    }
    private static String FAKE_LOGIN = "FAKE_LOGIN";
    @Override
    public void start(Stage primaryStage) throws Exception {
        if(FAKE_LOGIN == "FAKE_LOGIN") {
            SecondStage secondStage = new SecondStage("xxx");
            secondStage.show();
        } else {
            Login login = new Login();
            login.initUI();
            login.setupActions();
            login.show();
        }

    }
}
