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
        long FRAMES_PER_SEC = 30L;
        long INTERVAL = 1000000000L / FRAMES_PER_SEC;

        primaryStage.setTitle("COVID19_Simulation");
        Pane pane = new Pane();
        ArrayList<Mensch> people = new ArrayList<>();
        Mensch m = new Mensch(true, pane);
        people.add(m);
        while (count < 50) {
            m = new Mensch(false, pane);
            people.add(m);
            count++;
        }
        AnimationTimer timer = new AnimationTimer() {
            long last = 0;

            @Override
            public void handle(long l) {
                if (l - last > INTERVAL) {
                    last = l;

                    for (Mensch p : people) {
                        people.set(people.indexOf(p),p.move());
                    }
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
