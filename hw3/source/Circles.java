// Name: Alfonso Miguel Santos-Tankia
// Class: CS5405
// Student ID: 12432809
// HW3

//Note: To compile:     javac -d . <filepath>
//      To run:         java code.Circles
//      To create .jar: jar -cvfm Circles.jar Circles.txt *
//      To run .jar:    <Double click on Circles.jar>
//      To run .jar:    java -jar Circles.jar

package code;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Circles extends Application{
    Pane root;

    @Override
    public void start(Stage stage){
        int[] circleInputs = new int[6];

        try{
            File txtFile = new File("source/inCircle.txt");
            Scanner scan = new Scanner(txtFile);
            int i = 0;
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                circleInputs[i] = Integer.parseInt(line);
                System.out.println(circleInputs[i]);
                i++;
            }
        } catch (Exception e){
            System.out.println("Error: " + e);
        }

        // CHECKS FOR DISJOINT, TOUCH, INSIDE, OR OVERLAP
        int xDiff = circleInputs[0] - circleInputs[3];
        int yDiff = circleInputs[1] - circleInputs[4];
        double xySqrt = Math.sqrt(Math.pow(xDiff,2)+Math.pow(yDiff,2));

        int absRadDiff = Math.abs(circleInputs[2] - circleInputs[5]);
        int radAdd = circleInputs[2] + circleInputs[5];

        String labelData = "";
        if(xySqrt ==radAdd ||  xySqrt == absRadDiff){
            labelData = "The circles TOUCH";
        }
        if(xySqrt > radAdd){
            labelData = "The circles are DISJOINT";
        }
        if(xySqrt < radAdd){
            labelData = "The circles OVERLAP";
        }
        if(xySqrt < absRadDiff){
            labelData = "The circles are INSIDE of each other";
        }

        // CREATES CIRCLES
        root = new Pane();
        createCircle(circleInputs[0], circleInputs[1], circleInputs[2], labelData);
        createCircle(circleInputs[3], circleInputs[4], circleInputs[5], labelData);
        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("CS5405 HW3");
    }

    public Circle createCircle(int centerX, int centerY, int radius, String labelData){
        Circle circle = new Circle();
        circle.setCenterX(centerX);
        circle.setCenterY(centerY);
        circle.setRadius(radius);
        circle.setStroke(Color.BLUE);
        circle.setFill(Color.CYAN);
        // NEED TO SEE IF I CAN DELETE LABEL FROM HERE
        Label label = new Label(labelData);
        root.getChildren().addAll(circle,label);
        return circle;

    }
}