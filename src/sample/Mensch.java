package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.util.Random;

import static sample.Const.HEIGHT;
import static sample.Const.WIDTH;

public class Mensch {

    public Random r = new Random();
    Line traceLine;
    private Circle circle;
    private boolean isSick;
    Pane world;

    public Mensch(boolean isSick, Pane world) {
        this.isSick = isSick;
        this.world = world;
        circle = !isSick ? new Circle(r.nextInt( WIDTH- 1) + 1, r.nextInt(HEIGHT - 1) + 1, 2, Color.LIGHTGREEN) :
                new Circle(r.nextInt(WIDTH - 1) + 1, r.nextInt(HEIGHT - 1) + 1, 2, Color.RED);
        this.traceLine = new Line();
        traceLine.setStartX(circle.getCenterX());
        traceLine.setStartY(circle.getCenterY());
        traceLine.setEndX(circle.getCenterX());
        traceLine.setEndY(circle.getCenterY());
        world.getChildren().addAll(this.circle, traceLine);
    }

    public Circle getCircle() {
        return circle;
    }

    public void move(double dx, double dy) {
        this.traceLine = new Line();
        traceLine.setStroke(Color.rgb(23, 0, 0, 0.5));
        traceLine.setStrokeWidth(0.5);
        traceLine.setStartX(circle.getCenterX());
        traceLine.setStartY(circle.getCenterY());
        circle.setCenterX(circle.getCenterX()+dx);
        circle.setCenterY(circle.getCenterY()+dy);
        traceLine.setEndX(circle.getCenterX());
        traceLine.setEndY(circle.getCenterY());
        world.getChildren().add(traceLine);
    }
}
