package sample;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class Controller {
    @FXML
    Pane world;
    Simulation simulation;

    @FXML
    public void initialize() {

        simulation = new Simulation(world,500);
    }

    @FXML
    public void start() {
        simulation.start();

    }
    @FXML
    public void end() {
        simulation.stop();

    }
}
