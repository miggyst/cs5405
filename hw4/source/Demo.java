// Name: Alfonso Miguel Santos-Tankia
// Class: CS5405
// Student ID: 12432809
// HW4

//Note: To compile:     javac -d . source/*.java
//      To run:         java code.Demo
//      To create .jar: jar -cvfm Demo.jar source/Demo.txt *
//      To run .jar:    <Double click on Demo.jar>
//      To run .jar:    java -jar Demo.jar

package code;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Demo extends Application {

    Pane root = new Pane();

    Pane authorPane = new Pane();
    Button authorButton;
    Text authorText1, authorText2, authorText3;

    Pane descriptionPane = new Pane();
    Button descriptionButton;
    Text descriptionText1, descriptionText2, descriptionText3, descriptionText4, descriptionText5, descriptionText6, descriptionText7;

    Pane problemPane = new Pane();
    Button problemButton;
    Text problemText1;

    Pane circlePane = new Pane();
    Button circleButton;
    Text circleText1;

    Scene scene;
    Stage stage;

    String circleLabelData;
    int[] circleInputs;

    public void start(Stage stage){
        //GET Circle Information
        circleInputs = new int[6];
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

        if(xySqrt > radAdd){
            circleLabelData = "The circles are DISJOINT";
        }
        if(xySqrt < radAdd){
            circleLabelData = "The circles OVERLAP";
        }
        if(xySqrt < absRadDiff){
            circleLabelData = "The circles are INSIDE of each other";
        }
        if(xySqrt == radAdd ||  xySqrt == absRadDiff){
            circleLabelData = "The circles TOUCH";
            if((xySqrt <= circleInputs[2]) || (xySqrt <= circleInputs[5])){
                circleLabelData = "The circles TOUCH, and are INSIDE each other";
            }
            else{
                circleLabelData = "The circles TOUCH, and are OUTSIDE of each other";
            }
        }
        if((circleInputs[0] == circleInputs[3]) && (circleInputs[1] == circleInputs[4]) && (circleInputs[2] == circleInputs[5])){
            circleLabelData = "The circles are EQUAL";
        }

	    root = createFrontPage();
        scene = new Scene(root,700,600,Color.GRAY);
        stage.setTitle("CS5405 HW4");
        stage.setScene(scene);
        stage.show();
    }
    
    public Pane createFrontPage(){
        authorText1 = new Text(10,100, "Author1");
        authorText1.setText("Demonstration of Assignment for\nJava GUI and Visualitzation: CS5405");
        authorText1.setFill(Color.RED);
        authorText1.setTextAlignment(TextAlignment.CENTER);
        authorText1.setWrappingWidth(500);
        authorText2 = new Text(10, 150, "Author2");
        authorText2.setText("Presented by:\nAlfonso Miguel Pascual Santos-Tankia\nEmail: apsdr3@mst.edu\nStudent ID: 12432809");
        authorText2.setFill(Color.GREEN);
        authorText2.setFont(new Font(20));
        authorText2.setTextAlignment(TextAlignment.CENTER);
        authorText2.setWrappingWidth(500);
        authorText3 = new Text(10, 270, "Author3");
        authorText3.setText("This is my original Code, no IDE used in the submission.\nI did not give my code to anyone or use anyone's code in this work");
        authorText3.setFill(Color.BLUE);
        authorText3.setTextAlignment(TextAlignment.CENTER);
        authorText3.setWrappingWidth(500);

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
        descriptionText5 = new Text(10, 310, "Description5");
        descriptionText5.setText("Deliverables");
        descriptionText5.setFill(Color.BLUE);
        descriptionText6 = new Text(10, 325, "Description6");
        descriptionText6.setText("\t[5] Name the program: Demo.java, manifest file: Demo.txt, jar file Demo.jar\n\t[5] source directory will include all .java files and Demo.txt file,\n\tcode directory will have .class files,\n\tdata directory will have inFile.txt file for data\n\tall of CWD (source, code, data directories) will be jarred into executable .jar file.");
        descriptionText6.setFill(Color.BLUE);
        descriptionText7 = new Text(10, 410, "Description7");
        descriptionText7.setText("Canvas: Upload only Demo.jar file containing everything in CWD related to the program\nClass:  Sample of program execution and source code in the class.\nNote feel free to use anything in handouts or what was discussed in the class\nMaintain the honor code, refrain from copying or giving your code to anyone.");
        descriptionText7.setFill(Color.BLUE);

        problemText1 = new Text(10, 100, "Problem1");
        problemText1.setText("I did not have any problems working on this homework.");

        //INSERT CIRCLE TEXT HERE!
        circleText1 = new Text(10, 50, "Circles1");
        circleText1.setText(circleLabelData);
        // CREATES CIRCLES
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

        authorPane.getChildren().addAll(authorText1, authorText2, authorText3);
        descriptionPane.getChildren().addAll(descriptionText1, descriptionText2, descriptionText3, descriptionText4, descriptionText5, descriptionText6, descriptionText7);
        problemPane.getChildren().addAll(problemText1);
        circlePane.getChildren().addAll(circleText1, circle1, circle2);
        
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
