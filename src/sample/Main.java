package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

import static sample.Const.*;

public class Main extends Application {
    int count = 1;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("COVID19_Simulation");
        Pane pane = new Pane();
        ArrayList<Mensch> people = new ArrayList<>();
        Mensch m = new Mensch(true, pane);
        people.add(m);
        while (count < 1000) {
            m = new Mensch(false, pane);
            people.add(m);
            count++;
        }
        System.out.println(people.size());


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                for (Mensch p : people) {
                    p.move(ARR[RAND.nextInt(2)], ARR[RAND.nextInt(2)]);
                }

            }
        };

        timer.start();

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
