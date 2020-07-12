package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.util.Random;

import static sample.Const.*;

public class Main extends Application {
    int count = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("COVID19_Simulation");
        Pane pane = new Pane();
        Random r = new Random();
        Path path = new Path();

        while (count < 30) {

            Mensch m = new Mensch(false, pane);
            pane.getChildren().add(m.getCircle());
            count++;
        }
        Circle circle = new Circle(1 * r.nextInt(1280 - 1) + 1, 1 * r.nextInt(720 - 1) + 1, 4, Color.RED);


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                Line traceLine = new Line();
                traceLine.setStroke(Color.rgb(23, 0, 0, 0.5));
                traceLine.setStrokeWidth(0.5);
                traceLine.setStartX(circle.getCenterX());
                traceLine.setStartY(circle.getCenterY());
                circle.setCenterX(circle.getCenterX() + ARR[r.nextInt(2)]);
                circle.setCenterY(circle.getCenterY() + ARR[r.nextInt(2)]);
                traceLine.setEndX(circle.getCenterX());
                traceLine.setEndY(circle.getCenterY());
                pane.getChildren().add(traceLine);
            }
        };
        pane.getChildren().addAll(circle, path);

        timer.start();

        Scene scene = new Scene(pane, 1280, 720);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
