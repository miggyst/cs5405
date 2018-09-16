// Name: Alfonso Miguel Santos-Tankia
// Class: CS5405
// Student ID: 12432809
// HW2

//Note: To compile:     javac -d . <filepath>
//      To run:         java code.Demo
//      To create .jar: jar -cvfm Demo.jar manifest.txt *
//      To run .jar:    <Double click on Demo.jar>
//      To run .jar:    java -jar Demo.jar

package code;

import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.application.Application;

public class Demo extends Application{
    @Override
    public void start(Stage stage){
        Label label = new Label("Alfonso Miguel Santos-Tankia");
        Scene scene = new Scene(label, 300, 300);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("CS5405 HW2");
    }
}