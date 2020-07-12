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
        world.getChildren().add(this.circle);
    }

    public Circle getCircle() {
        return circle;
    }

    public void move(double dx, double dy) {

        circle.setCenterX(circle.getCenterX()+dx);
        circle.setCenterY(circle.getCenterY()+dy);

    }
}
