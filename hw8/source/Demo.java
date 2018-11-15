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
import javafx.scene.control.Slider;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.util.Duration;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Demo extends Application {

    Pane root = new Pane();

    Pane authorPane = new Pane();
    Button authorButton;
    ImageView authorImageView;
    Image authorImage;
    Text authorText1, authorText2, authorText3;

    Pane descriptionPane = new Pane();
    Button descriptionButton;
    ImageView descriptionImageView;
    Image descriptionImage;
    Text descriptionText1, descriptionText2, descriptionText3, descriptionText4, descriptionText5, descriptionText6, descriptionText7, descriptionText8, descriptionText9, descriptionText10, descriptionText11;

    Pane referencePane = new Pane();
    Button referenceButton;
    Text referenceText1;

    Pane demoPane = new Pane();
    Pane demoFanPane = new Pane();
    Button demoButton, demoPauseButton, demoReverseButton;
    Text demoText1, demoText2, demoText3, demoNumFanBladesSliderText, demoFanSpeedSliderText;
    TextField demoTextField;
    Slider demoNumFanBladesSlider, demoFanSpeedSlider;
    ImageView demoPauseButtonImageView, demoReverseButtonImageView;
    Image demoPauseButtonImage, demoReverseButtonImage;
    RotateTransition demoRotateTransition;
    int numFanBlades, rotationDirection = 360;
    boolean rotationPause = true;
    Circle circle1, circle2, circle3;
    Arc demoArc;

    Scene scene;
    Stage stage;

    @Override
    public void start(Stage stage){
        root = createFrontPage();
        scene = new Scene(root,720,600,Color.GRAY);
        stage.setTitle("CS5405 HW6");
        stage.setScene(scene);
        stage.show();
    }
    
    public Pane createFrontPage(){
        //----- AUTHOR PANE -----//
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
        authorImageView = new ImageView();   
        authorImage = new Image("images/miggy.png");
        authorImageView.setImage(authorImage);
        authorImageView.setFitHeight(200);
        authorImageView.setFitWidth(150);
        authorImageView.setX(190);
        authorImageView.setY(320);

        //----- DESCRIPTION PANE -----//
        descriptionText1 = new Text(10, 50, "Description1");
        descriptionText1.setText("CS5405HW (Canvas Upload Due THursday November 15)");
        descriptionText1.setFill(Color.RED);
        descriptionText2 = new Text(10, 65, "Description2");
        descriptionText2.setText("I showed you the demo in the class with fan creation, animation to control the motion and blades\nRead and understand JavaFX8 GUI Shapes and Animation.");
        descriptionText2.setFill(Color.BLUE);
        descriptionText3 = new Text(10, 95, "Description3");
        descriptionText3.setText("This Homework extension of HW06. This enforces your learning of icons, color and shapes circle and arc.\nOnce you have a function for creating one fan, you can call it any number of times create Four fans.\nYou may make your display as fancy as possible. Here is a sample of one fan, I showed in the class.");
        descriptionText3.setFill(Color.BLUE);
        descriptionImageView = new ImageView();   
        descriptionImage = new Image("images/fan.png");
        descriptionImageView.setImage(descriptionImage);
        descriptionImageView.setFitHeight(120);
        descriptionImageView.setFitWidth(150);
        descriptionImageView.setX(140);
        descriptionImageView.setY(140);
        descriptionText4 = new Text(10, 270, "Description4");
        descriptionText4.setText("Deliverables");
        descriptionText4.setFill(Color.BLUE);
        descriptionText5 = new Text(10, 290, "Description5");
        descriptionText5.setText("\t1.  Place .java files and a manifest file in \"source\" directory, compiled byte code  in \"code\" directory,\n\t    images in \"images\" directory");
        descriptionText5.setFill(Color.BLUE);
        descriptionText6 = new Text(10, 320, "Description6");
        descriptionText6.setText("\t2.  Name the program drive as Demo.java, manifest file Demo.txt, jar file.\n\t    Demo.jar contains the folders: source, code, images.");
        descriptionText6.setFill(Color.BLUE);
        descriptionText7 = new Text(10, 350, "Description7");
        descriptionText7.setText("\t3.  Upload  Demo.jar file to Canvas");
        descriptionText7.setFill(Color.BLUE);
        descriptionText8 = new Text(10, 365, "Descriptiopn8");
        descriptionText8.setText("\t4.  Bring to class a printed copy of java source code, a sample of program execution output of the program");
        descriptionText8.setFill(Color.BLUE);
        descriptionText9 = new Text(10, 380, "Description9");
        descriptionText9.setText("\t5.  Attach this assignment on top of the printed copy for grade feedback. Write your name on it.");
        descriptionText9.setFill(Color.BLUE);
        descriptionText10 = new Text(10, 395, "Description10");
        descriptionText10.setText("\t6.  Late Homework will not be accepted/graded by the grader. Do not ask for partial credit for turning in late,\n\t    it will not happen. The grader has his own exams, classes, interviews. He is not paid for grading the\n\t    same work multiple times. It is not at all fair to you or the grader to accept late work. You have a week\n\t    to do it. If you have any questions ask me next class day. It gives you time to ask question to do it on time\n\t    in addition to it being discussed in the class before it is assigned.");
        descriptionText10.setFill(Color.BLUE);
        descriptionText11 = new Text(10, 475, "Description11");
        descriptionText11.setText("\t7.  You will write your own code. If any sort of plagiarism occurs, guidelines were given in the class. Copying\n\t    the program will result in loss of ALL credit and will be reported to dept for proper credit.");
        descriptionText11.setFill(Color.BLUE);

        //----- REFERENCE PANE -----//
        referenceText1 = new Text(10, 100, "Reference1");
        referenceText1.setText("I did not use any external reference other than notes from class");

        //----- DEMO & DEMOFAN PANE -----//
        demoRotateTransition = new RotateTransition(Duration.seconds(15), demoFanPane);
        demoRotateTransition.setByAngle(rotationDirection);
        demoRotateTransition.setCycleCount(Animation.INDEFINITE);
        circle1 = new Circle();
        circle2 = new Circle();
        circle3 = new Circle();
        makeFan(0);
        // Pause Button
        demoPauseButtonImageView = new ImageView();   
        demoPauseButtonImage = new Image("images/pauseButton.png");
        demoPauseButtonImageView.setImage(demoPauseButtonImage);
        demoPauseButtonImageView.setFitHeight(100);
        demoPauseButtonImageView.setFitWidth(100);
        demoPauseButton = new Button();
        demoPauseButton.setGraphic(demoPauseButtonImageView);
        demoPauseButton.setLayoutX(50);
        demoPauseButton.setLayoutY(10);
        // Reverse Button
        demoReverseButtonImageView = new ImageView();   
        demoReverseButtonImage = new Image("images/reverseButton.png");
        demoReverseButtonImageView.setImage(demoReverseButtonImage);
        demoReverseButtonImageView.setFitHeight(100);
        demoReverseButtonImageView.setFitWidth(100);
        demoReverseButton = new Button();
        demoReverseButton.setGraphic(demoReverseButtonImageView);
        demoReverseButton.setLayoutX(200);
        demoReverseButton.setLayoutY(10);
        // Number of Fan Blade Slider
        demoNumFanBladesSliderText = new Text(425, 20, "Slider to Adjust Number of Fan Blades");
        demoNumFanBladesSlider = new Slider(0, 15, 0);
        demoNumFanBladesSlider.setMaxSize(300, 200);
        demoNumFanBladesSlider.setMajorTickUnit(1);
        demoNumFanBladesSlider.setMinorTickCount(0);
        demoNumFanBladesSlider.setOrientation(Orientation.HORIZONTAL);
        demoNumFanBladesSlider.setSnapToTicks(true);
        demoNumFanBladesSlider.setShowTickLabels(true);
        demoNumFanBladesSlider.setShowTickMarks(true);
        demoNumFanBladesSlider.setLayoutX(450);
        demoNumFanBladesSlider.setLayoutY(50);
        demoNumFanBladesSlider.setScaleX(2);
        demoNumFanBladesSlider.setScaleY(2);
        // Animation Speed of Fan Slider
        demoFanSpeedSliderText = new Text(200, 400, "Slider to Adjust Fan Speed");
        demoFanSpeedSlider = new Slider(0, 15, 0);
        demoFanSpeedSlider.setMaxSize(400, 600);
        demoFanSpeedSlider.setMajorTickUnit(1);
        demoFanSpeedSlider.setMinorTickCount(0);
        demoFanSpeedSlider.setOrientation(Orientation.HORIZONTAL);
        demoFanSpeedSlider.setSnapToTicks(true);
        demoFanSpeedSlider.setShowTickLabels(true);
        demoFanSpeedSlider.setShowTickMarks(true);
        demoFanSpeedSlider.setLayoutX(200);
        demoFanSpeedSlider.setLayoutY(430);
        demoFanSpeedSlider.setScaleX(2);
        demoFanSpeedSlider.setScaleY(2);
        // On action listeners
        demoNumFanBladesSlider.valueProperty().addListener(ov->{
            demoFanPane.getChildren().clear();
            numFanBlades = (int) demoNumFanBladesSlider.getValue();
            makeFan(numFanBlades);
        });
        demoFanSpeedSlider.valueProperty().addListener(ov->{
            int rateValue = (int) demoFanSpeedSlider.getValue();
            demoRotateTransition.setRate(rateValue);
            demoRotateTransition.play();
        });
        demoPauseButton.setOnAction(ae->{
            rotationPause = !rotationPause;
            if(rotationPause){
                demoRotateTransition.play();
            }
            else{
                demoRotateTransition.pause();
            }
        });
        demoReverseButton.setOnAction(ae->{
            demoRotateTransition.stop();
            rotationDirection = rotationDirection*-1;
            demoRotateTransition.setByAngle(rotationDirection);
            demoRotateTransition.play();
        });
        
        //----- PANE SETUP -----//
        authorButton =  new Button("Author");
        descriptionButton =  new Button("Description");
        referenceButton =  new Button("Reference");
        demoButton = new Button("Demo");

        root.getChildren().addAll(authorButton, descriptionButton, referenceButton, demoButton, authorPane);

        authorPane.getChildren().addAll(authorText1, authorText2, authorText3, authorImageView);
        descriptionPane.getChildren().addAll(descriptionText1, descriptionText2, descriptionText3, descriptionText4, descriptionText5, descriptionText6, descriptionText7, descriptionText8, descriptionText9, descriptionText10, descriptionText11, descriptionImageView);
        referencePane.getChildren().addAll(referenceText1);
        demoPane.getChildren().addAll(circle3, circle2, circle1, demoNumFanBladesSlider, demoNumFanBladesSliderText, demoPauseButton, demoReverseButton, demoFanSpeedSlider, demoFanSpeedSliderText);
        
        authorPane.setLayoutX(10);
        authorPane.setLayoutY(50);

        descriptionPane.setLayoutX(10);
        descriptionPane.setLayoutY(50);

        referencePane.setLayoutX(10);
        referencePane.setLayoutY(50);

        //demoPane.setAlignment(demoFanPane, Pos.CENTER);
        demoPane.setLayoutX(10);
        demoPane.setLayoutY(50);
        demoFanPane.setLayoutX(180);
        demoFanPane.setLayoutY(220);
        
        authorButton.setLayoutX(100);
        authorButton.setLayoutY(20);

        descriptionButton.setLayoutX(250);
        descriptionButton.setLayoutY(20);

        referenceButton.setLayoutX(400);
        referenceButton.setLayoutY(20);

        demoButton.setLayoutX(550);
        demoButton.setLayoutY(20);
     
        authorButton.setOnAction(ae->{
            root.getChildren().removeAll(authorPane, descriptionPane, referencePane, demoPane, demoFanPane);
            root.getChildren().add(authorPane);
        });
       
        descriptionButton.setOnAction(ae->{
            root.getChildren().removeAll(authorPane, descriptionPane, referencePane, demoPane, demoFanPane);
            root.getChildren().add(descriptionPane);
        });
        
        referenceButton.setOnAction(ae->{
            root.getChildren().removeAll(authorPane, descriptionPane, referencePane, demoPane, demoFanPane);
            root.getChildren().add(referencePane);
        });

        demoButton.setOnAction(ae->{
            root.getChildren().removeAll(authorPane, descriptionPane, referencePane, demoPane, demoFanPane);
            root.getChildren().addAll(demoPane, demoFanPane);
        });

        return root;
    }

    public void makeFan(int numFanBlades){
        circle1.setCenterX(250);
        circle1.setCenterY(250);
        circle1.setRadius(30);
        circle1.setStroke(Color.PINK);
        circle1.setFill(Color.BLUE);
        circle2.setCenterX(250);
        circle2.setCenterY(250);
        circle2.setRadius(60);
        circle2.setStroke(Color.PINK);
        circle2.setFill(Color.PINK);
        circle3.setCenterX(250);
        circle3.setCenterY(250);
        circle3.setRadius(90);
        circle3.setStroke(Color.RED);
        circle3.setFill(Color.WHITE);
        if(numFanBlades == 1 || numFanBlades == 2){
            if(numFanBlades == 1){
                demoArc = new Arc(80, 15, 80, 80, 0, 20);
                demoArc.setFill(Color.RED);
                demoArc.setType(ArcType.ROUND);
                demoFanPane.getChildren().add(demoArc);
                //offset
                demoFanPane.relocate(180, 285);
            }else{
                for(int i = 0; i < numFanBlades; i++){
                    int fanPlacement = (360/numFanBlades) * i;
                    int fanBladeLength = 20;
                    // centerX and centerY value of 80 is used to offset offcenter Pane (Now the arcs are in the middle of the Pane, so that when the Pane rotates, it rotates properly)
                    demoArc = new Arc(80, 30, 80, 80, fanPlacement, fanBladeLength);
                    demoArc.setFill(Color.RED);
                    demoArc.setType(ArcType.ROUND);
                    demoFanPane.getChildren().add(demoArc);
                }
                // offset
                demoFanPane.relocate(180, 270);
            }
        }else{
            for(int i = 0; i < numFanBlades; i++){
                int fanPlacement = (360/numFanBlades) * i;
                int fanBladeLength = 20;
                // centerX and centerY value of 80 is used to offset offcenter Pane (Now the arcs are in the middle of the Pane, so that when the Pane rotates, it rotates properly)
                demoArc = new Arc(80, 80, 80, 80, fanPlacement, fanBladeLength);
                demoArc.setFill(Color.RED);
                demoArc.setType(ArcType.ROUND);
                demoFanPane.getChildren().add(demoArc);
            }
            // offset
            demoFanPane.relocate(180, 220);
        }
    }
}