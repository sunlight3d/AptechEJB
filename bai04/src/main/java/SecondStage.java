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

public class SecondStage extends Stage {
    private VBox vbox = new VBox();
    private Scene scene;
    private Label label = new Label();
    private String name = "";
    SecondStage(String name){
        super();
        this.name = name;
    }
    public void initUI() {
        this.setTitle("Second screen");
        vbox.setPadding(new Insets(30,10,10,10));
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setSpacing(10);
        label.setText("This is second screen:\n"+this.name);
        label.setFont(Font.font(30));
        vbox.getChildren().addAll(label);
        scene = new Scene(vbox, 320,680);
        this.setScene(scene);
    }

}
