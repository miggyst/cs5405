// Name: Alfonso Miguel Santos-Tankia
// Class: CS5405
// Student ID: 12432809
// HW7

//Note: To compile:     javac -d . source/*.java
//      To run:         java code.Demo
//      To create .jar: jar -cvfm Demo.jar source/Demo.txt *
//      To run .jar:    <Double click on Demo.jar>
//      To run .jar:    java -jar Demo.jar

package code;

import javafx.application.Application;

import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.text.*;

import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.beans.property.Property;
import javafx.scene.shape.Path;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Demo extends Application {

    Pane root = new Pane();
    Scene scene;

    Pane authorPane = new Pane();
    Button authorButton;
    Text authorText1, authorText2, authorText3;

    Pane descriptionPane = new Pane();
    Button descriptionButton;
    ImageView descriptionImageView1, descriptionImageView2;
    Image descriptionImage1, descriptionImage2;
    Text descriptionText1, descriptionText2, descriptionText3, descriptionText4, descriptionText5, descriptionText6, descriptionText7;

    Pane referencePane = new Pane();
    Button referenceButton;
    Text referenceText1;

    Pane demoPane = new Pane();
    Button demoButton;
    Path demoPath;
    LineTo lineTo = new LineTo();
    MoveTo moveTo = new MoveTo();
    boolean demoCanDraw = true;
    boolean demoStartPoint = true;
    int xCoordinate = 0;
    int yCoordinate = 0;
    int demoCount = 0;

    @Override
    public void start(Stage stage){
        root = createFrontPage();
        scene = new Scene(root, 750, 750, Color.GRAY);
        stage.setTitle("CS5405 HW7");
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
        descriptionText1.setText("CS5405HW7 (Due Tuesday October 30, 2018 in class)");
        descriptionText1.setFill(Color.RED);
        descriptionText2 = new Text(10, 65, "Description2");
        descriptionText2.setText("We are Chapter 15. We have covered step by step up to Section 15.9.  To do this assignment do NOT use any\nstructures beyond what you learnt in this class. You may use any java code from the examples\nin the book or demos on the Canvas.");
        descriptionText2.setFill(Color.BLUE);
        descriptionText3 = new Text(10, 110, "Description3");
        descriptionText3.setText("I showed you the demo in the class with lines and polylines. Read and understand JavaFX8 GUI Shapes.\n[50] This Homework is  as proposed by you in the class.  Draw two free hand polylines. Be as\nartistic as you can. ON Canvas, Demo code for one polyline is for your guidance.\nRefer to how two functions of mouse are used: MouseMoved,and MouseClicked\nHere are two samples each has two polylines.");
        descriptionText3.setFill(Color.BLUE);

        descriptionImageView1 = new ImageView();   
        descriptionImage1 = new Image("source/polyline1.png");
        descriptionImageView1.setImage(descriptionImage1);
        descriptionImageView1.setFitHeight(120);
        descriptionImageView1.setFitWidth(120);
        descriptionImageView1.setX(200);
        descriptionImageView1.setY(175);
        descriptionImageView2 = new ImageView();   
        descriptionImage2 = new Image("source/polyline2.png");
        descriptionImageView2.setImage(descriptionImage2);
        descriptionImageView2.setFitHeight(120);
        descriptionImageView2.setFitWidth(120);
        descriptionImageView2.setX(345);
        descriptionImageView2.setY(175);

        descriptionText4 = new Text(10, 305, "Description4");
        descriptionText4.setText("Deliverables Before you turn it in, check mark these things.");
        descriptionText4.setFill(Color.BLUE);
        descriptionText5 = new Text(10, 320, "Description5");
        descriptionText5.setText("\t[5]\tUser interface buttons for Author, Problem description, References as usual.\n\t\tUpdate them for this assignment.\n\t[5]\tOnce two polylines are done, deactivate the mouse from drawing any more.\n\t[5]\tClear the drawing area except for buttons for interaction with the program.\n\t[10]\tDo not use any IDs. This will ensure that you will lose points if you do not follow the\n\t\tguidelines. It has been iterated and reiterated to refrain from such activity in this course.\n\t[10]\tAny files that are not needed in code and source directories must be removed.\n\t[10]\tjar file works with correctly with this assignment program, works  on double click.\n\t[5]\tName the program driver as Demo.java.\n\t[5]\tPlace .java files in source directory, compiled byte code will be in “code” directory\n\t[5]\tthe source directory has manifest file.\n\t[5]\tCreate one jar file named Demo.jar containing the folders: source and code \n\t[5]\tUpload  Demo.jar file to Canvas, do not turn it to me if you missed the due time on Canvas.\n\t[5]\tBring to class a printed copy of java source code, a sample of program execution output of the program\n\t[5]\tPrint this assignment description and place it on top of the printed copy for grade feedback. Write your name on it.\n\t[20]\tProgram works correctly, use self documenting variables.");
        descriptionText5.setFill(Color.RED);
        descriptionText6 = new Text(10, 570, "Description6");
        descriptionText6.setText("You will write your own code. If any sort of plagiarism occurs, guidelines were given in the class. Copying\nthe program will result in loss of ALL credit and will be reported to dept for proper credit. This is required by honor\ncode and the school of undergraduate/graduate studies.");
        descriptionText6.setFill(Color.BLUE);
        descriptionText7 = new Text(10, 630, "Description7");
        descriptionText7.setText("Late Homework will not be accepted/graded by the grader. Do not ask for partial credit for turning in late,\nit will not happen. The grader has his own exams, classes, interviews.  He is not paid for grading the same work\nmultiple times. It is not at all fair to you or the grader to accept late work. You have a week to do it. If you have any\nquestions ask me thursday.  It gives you time to ask question to do it on time inspite of it\nbeing discussed in the class before it is assigned.");
        descriptionText7.setFill(Color.BLUE);

        referenceText1 = new Text(10, 100, "Reference1");
        referenceText1.setText("I did not use any external reference other than notes from class");
        
        authorButton =  new Button("Author");
        descriptionButton =  new Button("Description");
        referenceButton =  new Button("Reference");
        demoButton = new Button("Demo");

        root.getChildren().addAll(authorButton, descriptionButton, referenceButton, demoButton, authorPane);

        authorPane.getChildren().addAll(authorText1, authorText2, authorText3);
        descriptionPane.getChildren().addAll(descriptionText1, descriptionText2, descriptionText3, descriptionText4, descriptionText5, descriptionText6, descriptionText7, descriptionImageView1, descriptionImageView2);
        referencePane.getChildren().addAll(referenceText1);
        
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
            if(demoCount < 2){
                polylineDrawing();
            }
        });

        return root;
    }

    public void polylineDrawing(){
        // Reset variables to be used 'n' times (in this case, just twice)
        demoCanDraw = true;
        demoStartPoint = true;

        demoPath = new Path();
        demoPath.getElements().add(new MoveTo(xCoordinate,yCoordinate));
        demoPath.setStrokeWidth(3);
        demoPath.setStroke(Color.BLUE);
        if(demoCount%2 == 1){
            demoPath.setStroke(Color.RED);
        }
        scene.setOnMouseMoved(mouseHandler);
        scene.setOnMouseClicked(mouseEvent->{
            if(demoStartPoint){
                if (mouseEvent.getClickCount() == 1){
                    demoStartPoint = false;
                    xCoordinate = (int)mouseEvent.getX() - 10; // x coordinate offset due to pane sizing
                    yCoordinate = (int)mouseEvent.getY() - 50; // y coordinate offset due to pane sizing

                    demoPane.getChildren().remove(demoPath);
                    lineTo.setX(xCoordinate);
                    lineTo.setY(yCoordinate);
                    demoPath = new Path();
                    demoPath.getElements().add(new MoveTo(xCoordinate,yCoordinate));

                    demoPath.setStrokeWidth(3);
                    demoPath.setStroke(Color.BLUE);
                    if(demoCount%2 == 1){
                        demoPath.setStroke(Color.RED);
                    }
                    demoPane.getChildren().add(demoPath);
                }
            }
            else{
                if(mouseEvent.getClickCount() == 1){
                    xCoordinate = (int)mouseEvent.getX() - 10; // x coordinate offset due to pane sizing
                    yCoordinate = (int)mouseEvent.getY() - 50; // y coordinate offset due to pane sizing
                    lineTo = new LineTo();
                    lineTo.setX(xCoordinate);
                    lineTo.setY(yCoordinate);
                    moveTo.setX(xCoordinate);
                    moveTo.setY(yCoordinate);
                    if(demoCanDraw){
                        demoPath.getElements().add(new LineTo(xCoordinate,yCoordinate));
                    }
                }
            }
            if (mouseEvent.getClickCount() > 1){
                // only allows 'n' polylines (in this case it will just be 2 times)
                demoCount++;
                if(demoCount < 2){
                    polylineDrawing();
                }
                else{
                    demoCanDraw = false;
                }
            }
        });
    }
    
    EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent mouseEvent){
            double xMouseEventCoordinate = mouseEvent.getX() - 10; // x coordinate offset due to pane sizing
            double yMouseEventCoordinate = mouseEvent.getY() - 50; // y coordinate offset due to pane sizing
            if(demoCanDraw){
                lineTo.setX(xMouseEventCoordinate);
                lineTo.setY(yMouseEventCoordinate);
                demoPath.getElements().add(lineTo);
            }
        }
    };
}