package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;

public class Controller {
    @FXML
    Pane world;
    Simulation simulation;

    @FXML
    public void initialize() {

        simulation = new Simulation(world, 500);
    }

    @FXML
    public void start() {
        simulation.start();

    }

    @FXML
    public void end() {
        simulation.stop();

    }

    //in the Controller class
    @FXML
    private Slider slider;

    @FXML
    public void setSpeed() {
        Const.SPEED = slider.getValue();

    }
}
