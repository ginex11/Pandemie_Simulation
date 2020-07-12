package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.util.Random;

public class Mensch {

    public Random r = new Random();
    Line traceLine=new Line();
    private Circle circle;
    private boolean isSick;
    Pane world;

    public Mensch(boolean isSick, Pane world) {
        this.isSick = isSick;
        this.world = world;
        circle = isSick == false ? new Circle(1 * r.nextInt(1280 - 1) + 1, 1 * r.nextInt(720 - 1) + 1, 2, Color.LIGHTGREEN) :
                new Circle(1 * r.nextInt(1280 - 1) + 1, 1 * r.nextInt(720 - 1) + 1, 2, Color.RED);
        traceLine.setStartX(circle.getCenterX());
        traceLine.setStartY(circle.getCenterY());
        world.getChildren().addAll(this.circle, traceLine);
    }

    public Circle getCircle() {
        return circle;
    }

    public void move(double dx, double dy) {
        traceLine.setStroke(Color.rgb(23, 0, 0, 0.5));
        traceLine.setStrokeWidth(0.5);
        traceLine.setStartX(circle.getCenterX());
        traceLine.setStartY(circle.getCenterY());
        circle.setCenterX(dx);
        circle.setCenterY(dy);
        traceLine.setEndX(circle.getCenterX());
        traceLine.setEndY(circle.getCenterY());
        //this.world.getChildren().add(traceLine);
    }
}
