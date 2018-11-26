// Name: Alfonso Miguel Santos-Tankia
// Class: CS5405
// Student ID: 12432809
// HW9

//Note: To compile:     javac -d . source/*.java
//      To run:         java code.Demo
//      To create .jar: jar -cvfm Demo.jar source/Demo.txt *
//      To run .jar:    <Double click on Demo.jar>
//      To run .jar:    java -jar Demo.jar

package code;

import javafx.scene.layout.*;
import javafx.scene.media.MediaView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.nio.file.*;
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
    Text descriptionText1, descriptionText2, descriptionText3, descriptionText4, descriptionText5, descriptionText6, descriptionText7, descriptionText8;

    Pane referencePane = new Pane();
    Button referenceButton;
    Text referenceText1;

    Pane audioDemoPane = new Pane();
    Button audioDemoButton, audioDemoPlayPauseButton;
    File audioDirectory;
    ComboBox audioComboBox;
    Text audioDemoText1;
    boolean audioPlayPause = false;

    Pane videoDemoPane = new Pane();
    Button videoDemoButton, videoDemoPlayPauseButton;
    File videoDirectory;
    ListView<String> videoListView = new ListView<String>();
    Text videoDemoText1;
    boolean videoPlayPause = false;
    MediaPlayer videoMediaPlayer;
    MediaView videoMediaView;
    int videoCount = 0;

    Scene scene;
    Stage stage;

    @Override
    public void start(Stage stage){
        root = createFrontPage();
        scene = new Scene(root,720,720,Color.GRAY);
        stage.setTitle("CS5405 HW9");
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
        descriptionText1.setText("CS5405 HW08 (Canvas Upload Due Tuesday November 27, 2018)");
        descriptionText1.setFill(Color.RED);
        descriptionText2 = new Text(10, 65, "Description2");
        descriptionText2.setText("This assignment enforces your learning of audio, video clips including ComboBox and Listview as I showed audio and video\ndemo in the class. Select five audioclips and five video clips and your program will select a clip and play it. The user\ninterface allows the user to select a clip from the list you have. The user may replace your list with his/her own list\nof clips. The program should still work. That is once your program creates File object f, you can get the file name as\nFile directory = new File(directoryName); //address of your files directory.\nFile[] fList = directory.listFiles(); //for all the files from a directory\nfor (File file : fList){  System.out.println(file.getName());} //for names of the files from a directory");
        descriptionText2.setFill(Color.BLUE);
        descriptionText3 = new Text(10, 185, "Description3");
        descriptionText3.setText("Deliverables");
        descriptionText3.setFill(Color.BLUE);
        descriptionText4 = new Text(10, 200, "Description4");
        descriptionText4.setText("1.  Place .java files and a manifest file in \"source\" directory, compiled byte code  in \"code\" directory, images in \"images\" directory,\n    audioclips in audios, videos clips in videos directory.\n2.  Name the program driver as Demo.java, manifest file Demo.txt, jar file is Demo.jar.  Demo.jar contains the folders: source, code,\n    images, audios, videos.\n3.  Upload  Demo.jar file to Canvas\n4.  Bring to class a printed copy of java source code, a sample of program execution output of the program\n5.  Attach this assignment on top of the printed copy for recording score and grade feedback. Write your name on it.\n6.  Late Homework will not be accepted/graded by the grader. Do not ask for partial credit for turning in late, it will not happen.\n    The grader has his own exams, classes, interviews.  He is not paid for grading the same work multiple times.  It is not at all fair\n    to you or the grader to accept late work. You have a week to do it. If you have any questions ask me next class day. It gives you\n    time to ask question to do it on time in addition to it being discussed in the class before it is assigned.\n7.  You will write your own code. If any sort of plagiarism occurs, guidelines were given in the class.\n    Copying the program will result in loss of ALL credit and will be reported to dept for proper credit.");
        descriptionText4.setFill(Color.BLUE);
        descriptionText5 = new Text(10, 410, "Description5");
        descriptionText5.setText("If the program works as specified, then check list for grading,");
        descriptionText5.setFill(Color.RED);
        descriptionText6 = new Text(10, 425, "Description6");
        descriptionText6.setText("[15]  Is the project stapled or binder-clipped. Does it have this assignment page on top of printout. Does it have\n        correct Problem Description. Does it have complete list references. Sources cited to make your work authentic\n        and to give credit to the original author(s). Does the printed copy include Samples of program executions.\n[10] 	Is the driver named Demo.java. Does it open with front page with correct: your picture, name, email, phone,\n        ownership copyright etc.\n[15]  Does it have buttons with icons along with text for author,description,references,AudioClipsDemo,VideoClipsDemo\n[30] 	Does AudioPlayer work on files from your directory if the audios directory contents are replaced.\n[30] 	Does MediaPlayer work on files from your directory if the videos directory contents are replaced.");
        descriptionText6.setFill(Color.RED);
        descriptionText7 = new Text(10, 560, "Description7");
        descriptionText7.setText("As normal, do not use any IDs. This will ensure that you will lose points if you do not follow the guidelines.\nIt has been iterated and reiterated to refrain from such activity in this course. The source or code directory\ndoes not contain any extra files");
        descriptionText7.setFill(Color.BLUE);
        descriptionText8 = new Text(10, 620, "Descriptiopn8");
        descriptionText8.setText("You will write your own code. If any sort of plagiarism occurs, guidelines were given in the class. Copying the\nprogram will result in loss of ALL credit and will be reported to dept for proper credit.  This is required by\nhonor code and the school of undergraduate/graduate studies to keep reminding with every HW.");
        descriptionText8.setFill(Color.BLUE);

        //----- REFERENCE PANE -----//
        referenceText1 = new Text(10, 100, "Reference1");
        referenceText1.setText("I did not use any external reference other than notes from class");

        //----- AUDIO DEMO PANE -----//
        // ComboBox
        audioDemoText1 = new Text(10, 50, "AudioText1");
        audioDemoText1.setText("Please choose a song from the COMBO BOX below");
        audioComboBox = new ComboBox();
        audioDirectory = new File("audios");
        File[] audioFileList = audioDirectory.listFiles();
        for(File audioFile:audioFileList){
            audioComboBox.getItems().add(audioFile.getName());
        }
        audioComboBox.setLayoutX(10);
        audioComboBox.setLayoutY(65);
        // Button for play/pause
        audioDemoPlayPauseButton = new Button();
        ImageView audioDemoImageView = new ImageView(new Image("images/playpause.png"));
        audioDemoImageView.setFitHeight(60);
        audioDemoImageView.setFitWidth(60);
        audioDemoPlayPauseButton.setGraphic(audioDemoImageView);
        audioDemoPlayPauseButton.setLayoutX(450);
        audioDemoPlayPauseButton.setLayoutY(50);
        audioDemoPlayPauseButton.setOnAction(ae->{
            //play or pause music
            audioPlayPause = !audioPlayPause;
        });


        //----- VIDEO DEMO PANE -----//
        videoDemoText1 = new Text(10, 50, "VideoText1");
        videoDemoText1.setText("Please choose a video from the LIST VIEW below");
        videoDirectory = new File("videos");
        File[] videoFileList = videoDirectory.listFiles();
        for(File videoFile:videoFileList){
            videoListView.getItems().add(videoFile.getName());
        }
        videoListView.setPrefWidth(200);
        videoListView.setPrefHeight(150);
        videoListView.setLayoutX(10);
        videoListView.setLayoutY(65);
        videoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(videoCount > 0){ // stops the old video from playing then removes the player to be replaced by a new video
                    videoMediaPlayer.pause();
                }
                videoDemoPane.getChildren().remove(videoMediaView);

                String listViewStringPath = "videos/" + videoListView.getSelectionModel().getSelectedItem();
                File videoFile = new File(listViewStringPath);
                
                //System.out.println(videoFile.getName());
                
                Media videoMedia = new Media(videoFile.toURI().toString());
                videoMediaPlayer = new MediaPlayer(videoMedia);
                videoMediaView = new MediaView(videoMediaPlayer);
                videoMediaView.setFitWidth(500); //1920x1080 scale
                videoMediaView.setFitHeight(281.25);
                videoMediaView.setLayoutX(100);
                videoMediaView.setLayoutY(300);
                videoDemoPane.getChildren().add(videoMediaView);

                // aims to reset the field to allow the user to switch between videos
                videoCount++;
                videoPlayPause = false;
        }});
        // Button for play/pause
        videoDemoPlayPauseButton = new Button();
        ImageView videoDemoImageView = new ImageView(new Image("images/playpause.png"));
        videoDemoImageView.setFitHeight(60);
        videoDemoImageView.setFitWidth(60);
        videoDemoPlayPauseButton.setGraphic(videoDemoImageView);
        videoDemoPlayPauseButton.setLayoutX(450);
        videoDemoPlayPauseButton.setLayoutY(50);
        videoDemoPlayPauseButton.setOnAction(ae->{
            //play or pause music
            videoPlayPause = !videoPlayPause;
            if(videoPlayPause){ // play
                videoMediaPlayer.play();
            }else{
                videoMediaPlayer.pause();
            }
        });


        //----- PANE SETUP -----//
        authorButton =  new Button("Author");
        descriptionButton =  new Button("Description");
        referenceButton =  new Button("Reference");
        audioDemoButton = new Button("Audio");
        videoDemoButton = new Button("Video");


        root.getChildren().addAll(authorButton, descriptionButton, referenceButton, audioDemoButton, videoDemoButton, authorPane);

        authorPane.getChildren().addAll(authorText1, authorText2, authorText3, authorImageView);
        descriptionPane.getChildren().addAll(descriptionText1, descriptionText2, descriptionText3, descriptionText4, descriptionText5, descriptionText6, descriptionText7, descriptionText8);
        referencePane.getChildren().addAll(referenceText1);
        audioDemoPane.getChildren().addAll(audioComboBox, audioDemoText1, audioDemoPlayPauseButton);
        videoDemoPane.getChildren().addAll(videoListView, videoDemoText1, videoDemoPlayPauseButton);
        
        authorPane.setLayoutX(10);
        authorPane.setLayoutY(50);

        descriptionPane.setLayoutX(10);
        descriptionPane.setLayoutY(50);

        referencePane.setLayoutX(10);
        referencePane.setLayoutY(50);

        audioDemoPane.setLayoutX(10);
        audioDemoPane.setLayoutY(50);

        videoDemoPane.setLayoutX(10);
        videoDemoPane.setLayoutY(50);
        
        authorButton.setLayoutX(100);
        authorButton.setLayoutY(20);

        descriptionButton.setLayoutX(220);
        descriptionButton.setLayoutY(20);

        referenceButton.setLayoutX(340);
        referenceButton.setLayoutY(20);

        audioDemoButton.setLayoutX(460);
        audioDemoButton.setLayoutY(20);

        videoDemoButton.setLayoutX(580);
        videoDemoButton.setLayoutY(20);
     
        authorButton.setOnAction(ae->{
            root.getChildren().removeAll(authorPane, descriptionPane, referencePane, audioDemoPane, videoDemoPane);
            root.getChildren().add(authorPane);
        });
       
        descriptionButton.setOnAction(ae->{
            root.getChildren().removeAll(authorPane, descriptionPane, referencePane, audioDemoPane, videoDemoPane);
            root.getChildren().add(descriptionPane);
        });
        
        referenceButton.setOnAction(ae->{
            root.getChildren().removeAll(authorPane, descriptionPane, referencePane, audioDemoPane, videoDemoPane);
            root.getChildren().add(referencePane);
        });

        audioDemoButton.setOnAction(ae->{
            root.getChildren().removeAll(authorPane, descriptionPane, referencePane, audioDemoPane, videoDemoPane);
            root.getChildren().add(audioDemoPane);
        });

        videoDemoButton.setOnAction(ae->{
            root.getChildren().removeAll(authorPane, descriptionPane, referencePane, audioDemoPane, videoDemoPane);
            root.getChildren().add(videoDemoPane);
        });

        return root;
    }
}