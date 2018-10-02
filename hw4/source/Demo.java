// Name: Alfonso Miguel Santos-Tankia
// Class: CS5405
// Student ID: 12432809
// HW3

//Note: To compile:     javac -d . source/*.java
//      To run:         java code.Demo
//      To create .jar: jar -cvfm Demo.jar manifest.txt *
//      To run .jar:    <Double click on Demo.jar>
//      To run .jar:    java -jar Demo.jar

package code;
// AUTHOR SHOULD SHOW WHEN APP IS OPENED!
/*
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

public class Demo extends Application{
    Pane root;

    @Override
    public void start(Stage stage){
        int[] circleInputs = new int[6];

        try{
            File txtFile = new File("data/inFile.txt");
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
        createCircle(circleInputs, labelData);//circleInputs[0], circleInputs[1], circleInputs[2], labelData);
        //createCircle(circleInputs[3], circleInputs[4], circleInputs[5], labelData);
        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("CS5405 HW3");
    }

    public Circle createCircle(int[] circleInputs, String labelData){//int centerX, int centerY, int radius, String labelData){
        Circle circle1 = new Circle();
        circle1.setCenterX(circleInputs[0]);
        circle1.setCenterY(circleInputs[1]);
        circle1.setRadius(circleInputs[2]);
        circle1.setStroke(Color.BLUE);
        circle1.setFill(Color.CYAN);

        Circle circle2 = new Circle();
        circle2.setCenterX(circleInputs[3]);
        circle2.setCenterY(circleInputs[4]);
        circle2.setRadius(circleInputs[5]);
        circle2.setStroke(Color.RED);
        circle2.setFill(Color.PINK);

        // NEED TO SEE IF I CAN DELETE LABEL FROM HERE
        Label label = new Label(labelData);
        root.getChildren().addAll(circle1,circle2,label);
        return circle1;

    }
}
*/
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.application.Application;
//actions items
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
//paint and othe useful classes
import javafx.scene.paint.Color;
import javafx.scene.text.*;//Font,FontWeight,FontPosture,TextAlignment
//Textalignment

/**
 *
 * @author Chaman Sabharwal
 */
import javafx.scene.text.*;

public class Demo extends Application {

    Pane root = new Pane();

    Pane authorPane = new Pane();
    Button authorButton;
    Text authorText1;

    Pane descriptionPane = new Pane();
    Button descriptionButton;
    Text descriptionText1, descriptionText2, descriptionText3, descriptionText4, descriptionText5, descriptionText6;

    Pane problemPane = new Pane();
    Button problemButton;
    Text problemText1;

    Pane circlePane = new Pane();
    Button circleButton;
    Text circleText1;

    Scene scene;
    Stage stage;

    public void start(Stage stage) {
	    root = createFrontPage();
        scene = new Scene(root,700,600,Color.GRAY);
        stage.setTitle("CS5405 HW4");
        stage.setScene(scene);
        stage.show();
    }
    
    public Pane createFrontPage()
    {
        authorText1 = new Text(10, 100, "Author1");
        authorText1.setText("Alfonso Miguel Pascual Santos-Tankia");
        
        descriptionText1 = new Text(10, 100, "Description1");
        descriptionText1.setText("CS5405HW04(Due Thursday October04, 2018, 11:00A.M.)\nHW will not be graded if submitted after 11:00AM.");
        descriptionText1.setFill(Color.RED);
        descriptionText2 = new Text(10, 150, "Description2");
        descriptionText2.setText("Write a program as shown in the class.\nUse four buttons, On clicking a button corresponding action should take place.\n");
        descriptionText2.setFill(Color.BLUE);
        descriptionText3 = new Text(10, 180, "Description3");
        descriptionText3.setText("\t[5] Author\n\t[5] Description for  problem description\n\t[5] Problems for Java related problems encountered.\n\t[5] Demo\n");
        descriptionText3.setFill(Color.BLUE);
        descriptionText4 = new Text(10, 240, "Description4");
        descriptionText4.setText("(Hint: root pane contains buttons and a pane1  You can create any more panes in a pane1.\nCreate pane2 for Author , pane3 for problem Description, pane4 for problems encountered,\npane 5 for Demos, on button click, remove the current pane, and add new pane. It was explained in the class.");
        descriptionText4.setFill(Color.BLUE);
        descriptionText5 = new Text(10, 290, "Description5");
        descriptionText5.setText("Deliverables");
        descriptionText5.setFill(Color.BLUE);
        descriptionText6 = new Text(10.305, "Description6");
        descriptionText6.setText("\t[5] Name the program: Demo.java, manifest file: Demo.txt, jar file Demo.jar\n\t[5] source directory will include all .java files and Demo.txt file,\n\tcode directory will have .class files,\n\tdata directory will have inFile.txt file for data\n\tall of CWD (source, code, data directories) will be jarred into executable .jar file.");
        descriptionText6.setFill(Color.BLUE);
        /*Canvas: Upload only Demo.jar file containing everything in CWD related to the program 
Class:  Sample of program execution and source code in the class.
Note feel free to use anything in handouts or what was discussed in the class
Maintain the honor code, refrain from copying or giving your code to anyone.
*/



        problemText1 = new Text(10, 100, "Problem1");
        problemText1.setText("I did not have any problems working on this homework.");

        circleText1 = new Text(10, 100, "Circles1");
        circleText1.setText("Insert HW3 code here");

        authorPane.getChildren().addAll(authorText1);
        descriptionPane.getChildren().addAll(descriptionText1, descriptionText2, descriptionText3, descriptionText4, descriptionText5, descriptionText6);
        problemPane.getChildren().addAll(problemText1);
        circlePane.getChildren().addAll(circleText1);
        
        authorPane.setLayoutX(10);
        authorPane.setLayoutY(50);

        descriptionPane.setLayoutX(10);
        descriptionPane.setLayoutY(50);

        problemPane.setLayoutX(10);
        problemPane.setLayoutY(50);

        circlePane.setLayoutX(10);
        circlePane.setLayoutY(50);
        
        authorButton =  new Button("Author");
        descriptionButton =  new Button("Description");
        problemButton =  new Button("Problem");
        circleButton = new Button("Circle");
        
        authorButton.setLayoutX(100);
        authorButton.setLayoutY(20);

        descriptionButton.setLayoutX(250);
        descriptionButton.setLayoutY(20);

        problemButton.setLayoutX(400);
        problemButton.setLayoutY(20);

        circleButton.setLayoutX(550);
        circleButton.setLayoutY(20);
        
        
        root.getChildren().addAll(authorPane, authorButton, descriptionButton, problemButton, circleButton);
     
        authorButton.setOnAction(ae->{
            root.getChildren().removeAll(authorPane, descriptionPane, problemPane, circlePane);
            root.getChildren().add(authorPane);
        });
       
        descriptionButton.setOnAction(ae->{
            root.getChildren().removeAll(authorPane, descriptionPane, problemPane, circlePane);
            root.getChildren().add(descriptionPane);
        });
        
        problemButton.setOnAction(ae->{
            root.getChildren().removeAll(authorPane, descriptionPane, problemPane, circlePane);
            root.getChildren().add(problemPane);
        });

        circleButton.setOnAction(ae->{
            root.getChildren().removeAll(authorPane, descriptionPane, problemPane, circlePane);
            root.getChildren().add(circlePane);
        });
        
       
        return root;
    }
}
