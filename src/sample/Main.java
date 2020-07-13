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
        while (count < 50) {
            m = new Mensch(false, pane);
            people.add(m);
            count++;
        }
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                for (Mensch p : people) {
                    p.move(Math.cos(Math.random() * 2 * Math.PI)*ARR[RAND.nextInt(3)],
                            Math.sin(Math.random() * 2 * Math.PI)*ARR[RAND.nextInt(3)]);
                }
                double p =Math.random();
                System.out.println("Random: "+p);
                System.out.println("Random mal PI: "+(p * 2 * Math.PI));

                System.out.println("Cos: "+Math.cos(p * (2 * Math.PI))*ARR[2]);
                System.out.println("Sin: "+Math.sin(p * (2 * Math.PI))*ARR[2]);

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
