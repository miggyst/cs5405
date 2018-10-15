// Name: Alfonso Miguel Santos-Tankia
// Class: CS5405
// Student ID: 12432809
// HW5

//Note: To compile:     javac -d . source/*.java
//      To run:         java code.Circles
//      To create .jar: jar -cvfm Circles.jar source/Circles.txt *
//      To run .jar:    <Double click on Circles.jar>
//      To run .jar:    java -jar Circles.jar

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

public class Circles extends Application {

    Pane root = new Pane();

    Pane authorPane = new Pane();
    Button authorButton;
    Text authorText1, authorText2, authorText3;

    Pane descriptionPane = new Pane();
    Button descriptionButton;
    Text descriptionText1, descriptionText2, descriptionText3, descriptionText4, descriptionText5, descriptionText6, descriptionText7, descriptionText8;

    Pane referencePane = new Pane();
    Button referenceButton;
    Text referenceText1;

    Pane circlePane = new Pane();
    Button circleButton;
    Text circleText1;

    Pane textFieldPane = new Pane();
    Button textFieldButton;
    //Text textFieldPane;

    Scene scene;
    Stage stage;

    String circleLabelData;
    int[][] circleInputs;

    @Override
    public void start(Stage stage){
        circleInputs = new int[8][6];
        try{
            File txtFile = new File("data/data.txt");
            Scanner scan = new Scanner(txtFile);
            int i = 0;
            while(scan.hasNextLine()){
                String[] line = (scan.nextLine()).split(" ");
                for(int j = 0; j < 6; j++){
                    circleInputs[i][j] = Integer.parseInt(line[j]);
                    System.out.print(circleInputs[i][j] + " ");
                }
                System.out.println();
                i++;
            }
        } catch (Exception e){
            System.out.println("Error: " + e);
        }

        // CHECKS FOR DISJOINT, TOUCH, INSIDE, OR OVERLAP
        int xDiff = circleInputs[0][0] - circleInputs[0][3];
        int yDiff = circleInputs[0][1] - circleInputs[0][4];
        double xySqrt = Math.sqrt(Math.pow(xDiff,2)+Math.pow(yDiff,2));

        int absRadDiff = Math.abs(circleInputs[0][2] - circleInputs[0][5]);
        int radAdd = circleInputs[0][2] + circleInputs[0][5];

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
            if((xySqrt <= circleInputs[0][2]) || (xySqrt <= circleInputs[0][5])){
                circleLabelData = "The circles TOUCH, and are INSIDE each other";
            }
            else{
                circleLabelData = "The circles TOUCH, and are OUTSIDE of each other";
            }
        }
        if((circleInputs[0][0] == circleInputs[0][3]) && (circleInputs[0][1] == circleInputs[0][4]) && (circleInputs[0][2] == circleInputs[0][5])){
            circleLabelData = "The circles are EQUAL";
        }

	    root = createFrontPage();
        scene = new Scene(root,700,700,Color.GRAY);
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

        descriptionText1 = new Text(10, 50, "Description1");
        descriptionText1.setText("CS5405HW06(Due Tuesday October16, 2018, 10:59A.M.)\nHW will NOT be graded if submitted after 11:00AM or it is incomplete or jar file does not execute.");
        descriptionText1.setFill(Color.RED);
        descriptionText2 = new Text(10, 80, "Description2");
        descriptionText2.setText("The purpose of HW is to grasp what is taught in the class. If there is any question, ask me directly.\nI am there to help so that you learn/know what you do. Refrain from using concepts/topics beyond what\nwe have covered in the class. Copying from someone else or giving your code to someone will not be\neducational for both the getter/giver and is also a violation of student honor code.");
        descriptionText2.setFill(Color.BLUE);
        descriptionText3 = new Text(10, 140, "Description3");
        descriptionText3.setText("Deliverables:");
        descriptionText3.setFill(Color.RED);
        descriptionText4 = new Text(10, 155, "Description4");
        descriptionText4.setText("Before uploading, double click the jar file and see it works and meets the specifications of the assignment.\nThere will be no credit if jar file does not work for any reason, such as missing manifest files etc.\n\t[5] On Canvas: Upload only Circles.jar file containing everything in CWD related to the program\n\t[15] In Class: Sample of program execution showing all eight cases and printed source code\n\t\tbefore the class begins.");
        descriptionText4.setFill(Color.BLUE);
        descriptionText5 = new Text(10, 230, "Description5");
        descriptionText5.setText("Program must have the user interface with buttons as discussed in the class to view each option\nby just clicking the buttons.");
        descriptionText5.setFill(Color.RED);
        descriptionText6 = new Text(10, 260, "Description6");
        descriptionText6.setText("\t[5] Author – show this at the start of the program, be consistent with the student honor code\n\t[5] Problem Description as assignment sheet\n\t[5] Reference  - complete reference to sources other than what is taught in the class.\n\t[5] Demos\nThis exercise also extends your previous HW04. This is a variation of ex 14.23 p.590, it is circles\ninstead of rectangles. You are experts on circles.  By now, everyone should be able to do it correctly.\nDo it right, it will be used again\n\t[5] TextField to read str from textField all at once as a string str and display the values on a label.\nConvert input to numbers to x1, y1, r1, x2, y2, r2:\nDraw two circles on the screen with radii r1, r2, and distance between the centers d = sqrt((x1-x2)2+(y1-y2)2)");
        descriptionText6.setFill(Color.BLUE);
        descriptionText7 = new Text(10, 410, "Description7");
        descriptionText7.setText("Test all eight cases:\n\t[5] identical, [5] disjoint, [5] externally touch, [5] circle1 is proper part and not touching circle2,\n\t[5] circle1 is proper part and touching circle2, [5] circle2 is proper part and not touching circle1.\n\t[5] circle2 is proper part and touching circle1,[5] proper overlap");
        descriptionText7.setFill(Color.BLUE);
        descriptionText8 = new Text(10, 470, "Descriptiopn8");
        descriptionText8.setText("Using OOP, you may write JUST one method to analyze the two circles using  if…if else struture.\nThe output will be one of the eight possibilities.\nName the program: Circles.java, manifest file: Circles.txt, jar file Circles.jar. Jar file will include ONLY:\n\t[5]code: code directory will have .class files\n\t[5]source: source directory will have .java and .txt files,\n\t[5]data: data.txt file with eight test cases used to test the program (six numbers per line).");
        descriptionText8.setFill(Color.BLUE);

        referenceText1 = new Text(10, 100, "Problem1");
        referenceText1.setText("NEED TO ADD REFERENCE LIST!");

        //INSERT CIRCLE TEXT HERE!
        circleText1 = new Text(10, 50, "Circles1");
        circleText1.setText(circleLabelData);
        // CREATES CIRCLES
        Circle circle1 = new Circle();
        circle1.setCenterX(circleInputs[0][0]);
        circle1.setCenterY(circleInputs[0][1]);
        circle1.setRadius(circleInputs[0][2]);
        circle1.setStroke(Color.BLUE);
        circle1.setFill(Color.CYAN);
        Circle circle2 = new Circle();
        circle2.setCenterX(circleInputs[0][3]);
        circle2.setCenterY(circleInputs[0][4]);
        circle2.setRadius(circleInputs[0][5]);
        circle2.setStroke(Color.RED);
        circle2.setFill(Color.PINK);

        authorPane.getChildren().addAll(authorText1, authorText2, authorText3);
        descriptionPane.getChildren().addAll(descriptionText1, descriptionText2, descriptionText3, descriptionText4, descriptionText5, descriptionText6, descriptionText7, descriptionText8);
        referencePane.getChildren().addAll(referenceText1);
        circlePane.getChildren().addAll(circleText1, circle1, circle2);
        
        authorPane.setLayoutX(10);
        authorPane.setLayoutY(50);

        descriptionPane.setLayoutX(10);
        descriptionPane.setLayoutY(50);

        referencePane.setLayoutX(10);
        referencePane.setLayoutY(50);

        circlePane.setLayoutX(10);
        circlePane.setLayoutY(50);
        
        authorButton =  new Button("Author");
        descriptionButton =  new Button("Description");
        referenceButton =  new Button("Reference");
        circleButton = new Button("Demo");
        textFieldButton = new Button("TextField");
        
        authorButton.setLayoutX(100);
        authorButton.setLayoutY(20);

        descriptionButton.setLayoutX(200);
        descriptionButton.setLayoutY(20);

        referenceButton.setLayoutX(300);
        referenceButton.setLayoutY(20);

        circleButton.setLayoutX(400);
        circleButton.setLayoutY(20);

        textFieldButton.setLayoutX(500);
        textFieldButton.setLayoutY(20);
        
        
        root.getChildren().addAll(authorPane, authorButton, descriptionButton, referenceButton, circleButton, textFieldButton);
     
        authorButton.setOnAction(ae->{
            root.getChildren().removeAll(authorPane, descriptionPane, referencePane, circlePane, textFieldPane);
            root.getChildren().add(authorPane);
        });
       
        descriptionButton.setOnAction(ae->{
            root.getChildren().removeAll(authorPane, descriptionPane, referencePane, circlePane);
            root.getChildren().add(descriptionPane);
        });
        
        referenceButton.setOnAction(ae->{
            root.getChildren().removeAll(authorPane, descriptionPane, referencePane, circlePane);
            root.getChildren().add(referencePane);
        });

        circleButton.setOnAction(ae->{
            root.getChildren().removeAll(authorPane, descriptionPane, referencePane, circlePane);
            root.getChildren().add(circlePane);
        });

        textFieldButton.setOnAction(ae->{
            root.getChildren().removeAll(authorPane, descriptionPane, referencePane, circlePane, textFieldPane);
            root.getChildren().add(textFieldPane);
        });
        
       
        return root;
    }

}
