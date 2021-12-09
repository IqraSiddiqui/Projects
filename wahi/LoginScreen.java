import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.GridPane;
import static java.lang.Math.random;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.control.PasswordField;
import java.sql.ResultSet;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Paint;
import javafx.scene.layout.Background;
import javafx.scene.layout.CornerRadii;

/*
This class contains a method screen controller that creates a login screen and render it on the primary stage. If user enters correct credentials then it is taken to the WAhi listening screen and hence gui object screen is rendered otherwise error prompt
*/

public class LoginScreen {
    public void screencontroller(Stage primaryStage, Scene scene){
        AccessJDBC aj=new AccessJDBC();
        ResultSet rs=aj.accessLogin();
        try{
            rs.next();
        }catch(Exception e){
            System.out.print(e);
        }
        GridPane grid = new GridPane();
        grid.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene1 = new Scene(grid, 800, 600);
        primaryStage.setScene(scene1);
        Text scenetitle = new Text("Welcome");
        scenetitle.setFill(Color.WHITE);
        scenetitle.setFont(Font.font("Arial Black", FontWeight.NORMAL, 70));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        userName.setFont(new Font("Open Sans", 24));
        userName.setTextFill(Color.WHITE);
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        pw.setFont(new Font("Open Sans", 24));
        pw.setTextFill(Color.WHITE);
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");

                btn.setStyle(
                    "-fx-background-radius: 15px; " + "-fx-background-color: #ffffff; "
            );
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
                grid.add(actiontarget, 1, 6);


                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                public void handle(ActionEvent event) {
                String checkUser = userTextField.getText().toString();
                String checkPw = pwBox.getText().toString();
                try{
                    
                if(checkUser.equals(rs.getString("name")) && checkPw.equals(rs.getString("password"))){
                primaryStage.setScene(scene);
                primaryStage.show();
                }
                else{
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setStyle("-fx-font-weight: bold");
                    actiontarget.setText("INVALID CREDENTIALS, TRY AGAIN!");
                }
                }
                catch(Exception e){
                    System.out.print(e);
                }
                }}); 

                primaryStage.show();
            
            }
        }
