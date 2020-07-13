package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static sample.Const.*;


public class Mensch {

    private Circle circle;
    private boolean isSick;
    private Pane world;
    private double x;
    private double y;

    public Mensch(boolean isSick, Pane world) {
        this.isSick = isSick;
        this.world = world;
        this.x = RAND.nextDouble() * (WIDTH - RADIUS * 2);
        this.y = RAND.nextDouble() * (HEIGHT - RADIUS * 2);
        circle = !isSick ? new Circle(this.x, this.y, RADIUS, Color.GREEN) :
                new Circle(this.x, this.y, RADIUS, Color.RED);
        this.world.getChildren().add(this.circle);
    }

    public Circle getCircle() {
        return circle;
    }

    public void move(double dx, double dy) {
        /**Line line = new Line();
        line.setFill(Color.TRANSPARENT);
        line.setStrokeWidth(0.3);
        line.setStartX(this.x);
        line.setStartY(this.y);**/


        if (this.x + dx > WIDTH - RADIUS * 2 || this.x + dx < RADIUS)
            dx *= -1;
        if (this.y + dy > HEIGHT - RADIUS * 2 || this.y + dy < RADIUS)
            dy *= -1;
        circle.setCenterX(this.x += dx);
        circle.setCenterX(this.x += dx);
        circle.setCenterY(this.y += dy);
        circle.setCenterY(this.y += dy);
       /** line.setEndX(this.x);
        line.setEndY(this.y);

        world.getChildren().add(line);**/

    }


}
