// Name: Alfonso Miguel Santos-Tankia
// Class: CS5405
// Student ID: 12432809
// HW6

//Note: To compile:     javac -d . source/*.java
//      To run:         java code.Demo
//      To create .jar: jar -cvfm Demo.jar source/Demo.txt *
//      To run .jar:    <Double click on Demo.jar>
//      To run .jar:    java -jar Demo.jar

package code;

import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
    ImageView descriptionImageView;
    Image descriptionImage;
    Text descriptionText1, descriptionText2, descriptionText3, descriptionText4, descriptionText5, descriptionText6, descriptionText7, descriptionText8;

    Pane referencePane = new Pane();
    Button referenceButton;
    Text referenceText1;

    Pane demoPane = new Pane();
    Button demoButton;
    Text demoText1, demoText2, demoText3;
    TextField demoTextField;

    Scene scene;
    Stage stage;

    int[] circleInputs;
    String circleLabelData = "";
    Circle circle1, circle2;

    @Override
    public void start(Stage stage){
        root = createFrontPage();
        scene = new Scene(root,720,700,Color.GRAY);
        stage.setTitle("CS5405 HW6");
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
        authorText2.setText("Presented by:\nAlfonso Miguel Pascual Santos-Tankia\nEmail: apsdr3@mst.edu\nPhone: +1 314 443 0785\nStudent ID: 12432809");
        authorText2.setFill(Color.GREEN);
        authorText2.setFont(new Font(20));
        authorText2.setTextAlignment(TextAlignment.CENTER);
        authorText2.setWrappingWidth(500);
        authorText3 = new Text(10, 290, "Author3");
        authorText3.setText("This is my original Code, no IDE used in the submission.\nI did not give my code to anyone or use anyone's code in this work");
        authorText3.setFill(Color.BLUE);
        authorText3.setTextAlignment(TextAlignment.CENTER);
        authorText3.setWrappingWidth(500);

        descriptionText1 = new Text(10, 50, "Description1");
        descriptionText1.setText("CS5405HW (Due Tuesday October 23, 2017 in class)");
        descriptionText1.setFill(Color.RED);
        descriptionText2 = new Text(10, 65, "Description2");
        descriptionText2.setText("I showed you the demo in the class with circles and arcs. Read and understand JavaFX8 GUI Shapes.");
        descriptionText2.setFill(Color.BLUE);
        descriptionText3 = new Text(10, 80, "Description3");
        descriptionText3.setText("[50] This Homework is  Problem 14.9 page 587. This enforces your learning of color and shapes circle and arc.\nOnce you have a function for creating one fan, you can call it n times to create n fans.\nYou may make your display as fancy as possible, but stay within the confines of material what we covered\nin the class. Here is a sample of one fan. Take advantage of the course material covered so far.\nWrite is as generic as possible. You will be extending the HW in the next assigments.");
        descriptionText3.setFill(Color.BLUE);
        //ADD IMAGE HERE!!!
        descriptionImageView = new ImageView();   
        descriptionImage = new Image("source/fan.png");
        descriptionImageView.setImage(descriptionImage);
        //ADD IMAGE HERE!!
        descriptionText4 = new Text(10, 275, "Description4");
        descriptionText4.setText("Deliverables");
        descriptionText4.setFill(Color.BLUE);
        descriptionText5 = new Text(10, 290, "Description5");
        descriptionText5.setText("\t[20]jar file works with correct program, works  on double click.\n\t[5]Place .java files in source directory, compiled byte code will be in “code” directory\n\t[5]Create a jar file Demo.jar containing the folders:source and code,the source directory has manifest file.");
        descriptionText5.setFill(Color.RED);
        descriptionText6 = new Text(10, 335, "Description6");
        descriptionText6.setText("\t[5]Upload  Demo.jar file to Canvas, do not turn it to me if you missed the due time on Canvas.\n\t[5]Bring to class a printed copy of java source code,a sample of program execution output of the program");
        descriptionText6.setFill(Color.RED);
        descriptionText7 = new Text(10, 365, "Description7");
        descriptionText7.setText("\t[5] Place assignment page on top of the printed copy for grade feedback. Write your name on it.\n\n\tYou will write your own code. If any sort of plagiarism occurs, guidelines were given in the class.\n\tCopying the program will result in loss of ALL credit and will be reported to dept for proper credit.\n\tThis is required by honor code and the school of undergraduate/graduate studies.");
        descriptionText7.setFill(Color.BLUE);
        descriptionText8 = new Text(10, 440, "Descriptiopn8");
        descriptionText8.setText("Late Homework will not be accepted/graded by the grader.\nDo not ask for partial credit for turning in late, it will not happen. The grader has his own exams, classes,\ninterviews. He is not paid for grading the same work multiple times.  It is not at all fair to you or the grader\nto accept late work. You have a week to do it. If you have any questions ask me thursday.  It gives you time to ask\nquestion to do it on time. You may use any java code from the examples in the book or demos on the Canvas. ");
        descriptionText8.setFill(Color.BLUE);

        referenceText1 = new Text(10, 100, "Reference1");
        referenceText1.setText("I did not use any external reference other than notes from class");

        //INSERT CIRCLE TEXT HERE!
        demoTextField = new TextField("");
        demoTextField.setOnAction(new TextFieldHandler());
        demoText1 = new Text(10, 50, "Circles1");
        demoText1.setText("Circles Spatial Relations Demo");
        demoText1.setFill(Color.RED);
        demoText2 = new Text(10, 65, "Circles2");
        demoText2.setText("Input Circles: x1 y1 r1 x2 y2 r2");
        demoText3 = new Text(10, 80, "Circles3");
        demoText3.setText(circleLabelData);

        // CREATES CIRCLES
        circle1 = new Circle();
        circle2 = new Circle();
        
        authorButton =  new Button("Author");
        descriptionButton =  new Button("Description");
        referenceButton =  new Button("Reference");
        demoButton = new Button("Demo");

        root.getChildren().addAll(authorButton, descriptionButton, referenceButton, demoButton, authorPane);

        authorPane.getChildren().addAll(authorText1, authorText2, authorText3);
        descriptionPane.getChildren().addAll(descriptionText1, descriptionText2, descriptionText3, descriptionText4, descriptionText5, descriptionText6, descriptionText7, descriptionText8, descriptionImageView);
        referencePane.getChildren().addAll(referenceText1);
        demoPane.getChildren().addAll(demoText1, demoText2, demoText3, demoTextField, circle1, circle2);
        
        authorPane.setLayoutX(10);
        authorPane.setLayoutY(50);

        descriptionPane.setLayoutX(10);
        descriptionPane.setLayoutY(50);

        referencePane.setLayoutX(10);
        referencePane.setLayoutY(50);

        demoPane.setLayoutX(10);
        demoPane.setLayoutY(50);
        
        authorButton.setLayoutX(100);
        authorButton.setLayoutY(20);

        descriptionButton.setLayoutX(250);
        descriptionButton.setLayoutY(20);

        referenceButton.setLayoutX(400);
        referenceButton.setLayoutY(20);

        demoButton.setLayoutX(550);
        demoButton.setLayoutY(20);
     
        authorButton.setOnAction(ae->{
            root.getChildren().removeAll(authorPane, descriptionPane, referencePane, demoPane);
            root.getChildren().add(authorPane);
        });
       
        descriptionButton.setOnAction(ae->{
            root.getChildren().removeAll(authorPane, descriptionPane, referencePane, demoPane);
            root.getChildren().add(descriptionPane);
        });
        
        referenceButton.setOnAction(ae->{
            root.getChildren().removeAll(authorPane, descriptionPane, referencePane, demoPane);
            root.getChildren().add(referencePane);
        });

        demoButton.setOnAction(ae->{
            root.getChildren().removeAll(authorPane, descriptionPane, referencePane, demoPane);
            root.getChildren().add(demoPane);
        });

        return root;
    }
    

    public class TextFieldHandler implements EventHandler<ActionEvent>{
        public void handle(ActionEvent e){
            circleInputs = new int[6];
            String str = demoTextField.getText();
            try{
                String[] line = str.split(" ");
                for(int i = 0; i < 6; i++){
                    circleInputs[i] = Integer.parseInt(line[i]);
                }
                checkCircleStringOutput();
                demoTextField.setText("");
                demoText3.setText(circleLabelData);
                circle1.setCenterX(circleInputs[0]);
                circle1.setCenterY(circleInputs[1]);
                circle1.setRadius(circleInputs[2]);
                circle1.setStroke(Color.BLUE);
                circle1.setFill(Color.CYAN);
                circle1.setOpacity(0.8);
                circle2.setCenterX(circleInputs[3]);
                circle2.setCenterY(circleInputs[4]);
                circle2.setRadius(circleInputs[5]);
                circle2.setStroke(Color.RED);
                circle2.setFill(Color.PINK);
                circle2.setOpacity(0.8);
            }catch(Exception f){
                demoTextField.setText("");
                demoText3.setText("Please input a valid string");
            }
        }
    }

    public void checkCircleStringOutput(){
        int xDiff = circleInputs[0] - circleInputs[3];
        int yDiff = circleInputs[1] - circleInputs[4];
        double xySqrt = Math.sqrt(Math.pow(xDiff,2)+Math.pow(yDiff,2));

        int absRadDiff = Math.abs(circleInputs[2] - circleInputs[5]);
        int radDiff1 = circleInputs[2] - circleInputs[5];
        int radDiff2 = circleInputs[5] - circleInputs[2];
        int radAdd = circleInputs[2] + circleInputs[5];

        if(xySqrt >= radAdd){
            if(xySqrt > radAdd){
                circleLabelData = "The circles are DISJOINT";
            }
            else{
                circleLabelData = "The circles TOUCH EXTERNALLY";
            }
        }
        
        if(xySqrt < radAdd){
            circleLabelData = "The circles PROPERLY OVERLAP";
        }

        if(xySqrt <= radDiff2){
            if(xySqrt < radDiff2){
                circleLabelData = "circle1 is INSIDE and DOES NOT TOUCH circle2";
            }
            else{
                circleLabelData = "circle1 is INSIDE and DOES TOUCH circle2";
            }
        }

        if(xySqrt <= radDiff1){
            if(xySqrt < radDiff1){
                circleLabelData = "circle2 is INSIDE and DOES NOT TOUCH circle1";
            }
            else{
                circleLabelData = "circle2 is INSIDE and DOES TOUCH circle1";
            }
        }

        if((circleInputs[0] == circleInputs[3]) && (circleInputs[1] == circleInputs[4]) && (circleInputs[2] == circleInputs[5])){
            circleLabelData = "The circles are IDENTICAL";
        }
    }

}