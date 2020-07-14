package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static sample.Const.HEIGHT;
import static sample.Const.WIDTH;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("COVID19_Simulation");
        Pane pane = new Pane();
        //Start the simulation
        Simulation sim = new Simulation(pane, 100);
        sim.start();
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
