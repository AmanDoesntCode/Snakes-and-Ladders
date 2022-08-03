package com.example.snakesladders;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.util.Random;

public class MainGrid extends Application {

    public int rand;
    public Label randno;
    public static final int subGridsize = 70; //we declare it already so that we could code the sizes dynamically
    public static final int subGridwidth = 10;
    public static final int subGridheight = 10;

    public Circle p1;
    public Circle p2;

    public int p1pos = 1;
    public int p2pos = 1;

    boolean p1turn = true;
    boolean p2turn = true;

    public static int p1posX = 35;
    public static int p1posY = 665;

    public static int p2posX = 35;
    public static int p2posY = 665;

    public boolean start = false;
    public Button gB; //game button

    public int poscirc1 = 1;
    public int poscirc2 = 1;


    private Group subGridGroup = new Group();

    private Parent ContentCreate  () {
        Pane root = new Pane ();
        root.setPrefSize(subGridsize * subGridwidth,(subGridsize * subGridheight) + subGridsize ); // + 80 to make space for buttons
//        gives the height and width of the grid consisting of 100 sub grids
//          each subgrid is supposed to be sized 80*80 units
        root.getChildren().addAll(subGridGroup);
        for (int i =0; i < subGridheight ; i++)
            for (int j = 0; j < subGridwidth; j++ ){
                SubGrid sg = new SubGrid (subGridsize,subGridsize);
                sg.setTranslateX(j * subGridsize);
                sg.setTranslateY(i * subGridsize);
                subGridGroup.getChildren().add(sg);

            }
        p1 = new Circle(35);
        p1.getStyleClass().add("icons/style.css");
        p1.setFill(Color.CHOCOLATE);
        p1.setId("aman");
        p1.setTranslateX(p1posX);
        p1.setTranslateY(p1posY);

        p2 = new Circle(35);
        p2.getStyleClass().add("icons/style.css");
        p2.setId("raghav");
        p2.setTranslateX(p2posX);
        p2.setTranslateY(p2posY);

        Button button = new Button("aman");
        button.setTranslateX(70);
        button.setTranslateY(720);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (start == true){
                    if(p1turn){
                        Roll();
                        randno.setText(String.valueOf(rand));
                        moveplayer1();
                        playermove(p1posX,p1posY,p1);
                        p1pos += rand;
                        p1turn = false;
                        p2turn = true;

                        //ladder
                        if (p1posX == 175 && p1posY ==  665 ){playermove(p1posX = 105,p1posY = 455,p1);poscirc1=0;}
                        if (p1posX == 665 && p1posY == 665 ){playermove(p1posX = 595,p1posY = 595,p1);poscirc1=0;}
                        if (p1posX == 455 && p1posY ==  525 ){playermove(p1posX = 525,p1posY = 315,p1);poscirc1=0;}
                        if (p1posX == 315 && p1posY ==  315 ){playermove(p1posX = 245,p1posY = 105,p1);poscirc1=1;}
                        if (p1posX == 35 && p1posY ==  245 ){playermove(p1posX = 105,p1posY = 35,p1);poscirc1=0;}
                        if (p1posX == 595 && p1posY ==  175 ){playermove(p1posX = 665,p1posY = 105,p1);poscirc1=1;}

                        //snakes
                        if (p1posX == 315 && p1posY ==  595 ){playermove(p1posX = 525,p1posY = 595,p1);poscirc1=0;}
                        if (p1posX == 665 && p1posY == 455 ){playermove(p1posX = 245,p1posY = 665,p1);poscirc1=1;}
                        if (p1posX == 455 && p1posY ==  385 ){playermove(p1posX = 315,p1posY = 525,p1);poscirc1=1;}
                        if (p1posX == 175 && p1posY ==  245 ){playermove(p1posX = 35,p1posY = 315,p1);poscirc1=0;}
                        if (p1posX == 385 && p1posY ==  245 ){playermove(p1posX = 595,p1posY = 315,p1);poscirc1=0;}
                        if (p1posX == 245 && p1posY ==  35 ){playermove(p1posX = 385,p1posY = 175,p1);poscirc1=0;}


                    }
                }
            }
        });

        Button button2 = new Button("Raghav");
        button2.setTranslateX(600);
        button2.setTranslateY(720);
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (start == true){
                    if(p2turn){
                        Roll();
                        randno.setText(String.valueOf(rand));
                        moveplayer2();
                        playermove(p2posX,p2posY,p2);
                        p2pos += rand;
                        p2turn = false;
                        p1turn = true;

//                        //ladders
                        if (p2posX == 175 && p2posY ==  665 ){playermove(p2posX = 105,p2posY = 455,p2);poscirc2=0;}
                        if (p2posX == 665 && p2posY == 665 ){playermove(p2posX = 595,p2posY = 595,p2);poscirc2=0;}
                        if (p2posX == 455 && p2posY ==  525 ){playermove(p2posX = 525,p2posY = 315,p2);poscirc2=0;}
                        if (p2posX == 315 && p2posY ==  315 ){playermove(p2posX = 245,p2posY = 105,p2);poscirc2=1;}
                        if (p2posX == 35 && p2posY ==  245 ){playermove(p2posX = 205,p2posY = 35,p2);poscirc2=0;}
                        if (p2posX == 595 && p2posY ==  175 ){playermove(p2posX = 665,p2posY = 105,p2);poscirc2=1;}

                        //snakes
                        if (p2posX == 315 && p2posY ==  595 ){playermove(p2posX = 525,p2posY = 595,p2);poscirc1=0;}
                        if (p2posX == 665 && p2posY == 455 ){playermove(p2posX = 245,p2posY = 665,p2);poscirc2=1;}
                        if (p2posX == 455 && p2posY ==  385 ){playermove(p2posX = 315,p2posY = 525,p2);poscirc2=1;}
                        if (p2posX == 175 && p2posY ==  245 ){playermove(p2posX = 35,p2posY = 315,p2);poscirc2=0;}
                        if (p2posX == 385 && p2posY ==  245 ){playermove(p2posX = 595,p2posY = 315,p2);poscirc2=0;}
                        if (p2posX == 245 && p2posY ==  35 ){playermove(p2posX = 385,p2posY = 175,p2);poscirc2=0;}

                    }
                }
            }
        });
        gB = new Button("Start Game");
        gB.setTranslateX(310);
        gB.setTranslateY(720);
        gB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gB.setText("Game Started");
                p1posX = 35;
                p1posY = 665;

                p2posX = 35;
                p2posY = 665;

                p1.setTranslateX(p1posX);
                p1.setTranslateY(p1posY);

                p2.setTranslateX(p2posX);
                p2.setTranslateY(p2posY);
                start = true;


            }
        });
        randno = new Label("0");
        randno.setTranslateX(345);
        randno.setTranslateY(745);

        Image imgbg = new Image("D:\\Java\\SnakesLadders\\src\\main\\resources\\icons\\SNAKES AND LADDERS.png");
        ImageView bgphoto = new ImageView();
        bgphoto.setImage(imgbg);
        bgphoto.setFitHeight(700);
        bgphoto.setFitWidth(700);

        subGridGroup.getChildren().addAll(bgphoto,p1,p2,button,button2,gB,randno);
        return root;
    }

 private void moveplayer1(){
        for(int i = 0; i < rand ; i++){
            if(poscirc1%2 == 1)p1posX += 70;
            if(poscirc1%2 == 0)p1posX -= 70;
            if(p1posX>665){ p1posY-=70; p1posX-=70; poscirc1 ++; }
            if(p1posX<35){ p1posY-=70; p1posX+=70; poscirc1 ++; }
            if(p1posX<35 || p1posY<35){ p1posY=35; p1posX=35; randno.setText("aman wonnn !!"); gB.setText("Start Again !"); break; }

        }
 }

    private void moveplayer2(){
        for(int i = 0; i < rand ; i++){
            if(poscirc2%2 == 1)p2posX += 70;
            if(poscirc2%2 == 0)p2posX -= 70;
            if(p2posX>665){ p2posY-=70; p2posX-=70; poscirc2 ++; }
            if(p2posX<35){ p2posY-=70; p2posX+=70; poscirc2 ++; }
            if(p2posX<35 || p2posY<35){ p2posY=35; p2posX=35; randno.setText("Raghav wonnn !!"); gB.setText("Start Again !"); break; }

        }
    }

private void Roll(){
    Random r = new Random();
    rand = r.nextInt(1,7);
}


private void playermove (int x, int y, Circle c){
    TranslateTransition animation = new TranslateTransition(Duration.millis (1000),c);
    animation.setToX(x);
    animation.setToY(y);
    animation.setAutoReverse(false);
    animation.play();
}

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(ContentCreate());
        Image img = new Image("D:\\Java\\SnakesLadders\\src\\main\\resources\\icons\\icon.png");
        stage.getIcons().add(img);
        stage.setTitle("Snakes and Ladders");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
#end