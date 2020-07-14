package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static sample.Const.*;


public class Mensch {
    private Circle circle;
    private final boolean isSick;
    private Pane world;
    private final Position position;


    public Mensch(boolean isSick, Pane world) {
        System.out.println("Mensch wurde erzeugt");
        this.isSick = isSick;
        this.world = world;
        this.position = new Position(RAND.nextDouble() * (WIDTH - RADIUS * 2),
                RAND.nextDouble() * (HEIGHT - RADIUS * 2));

        this.circle = !isSick ? new Circle(position.getX(), position.getY(), RADIUS, Color.GREEN) :
                new Circle(position.getX(), position.getY(), RADIUS, Color.RED);
        this.world.getChildren().add(this.circle);
        System.out.println(this.world.getChildren().indexOf(circle));
    }

    public Mensch(Circle c, boolean isSick, Pane world, Position position) {
        System.out.println("Mensch wurde bewegt");
        this.isSick = isSick;
        this.world = world;
        this.position = position;

        this.circle = c;
        System.out.println("MainX: " + this.circle.getCenterX());
        drawShape();
        this.world.getChildren().remove(c);
        this.world.getChildren().add(circle);
        System.out.println(this.world.getChildren().indexOf(circle) + " und " + this.world.getChildren().size());

    }


    public Circle getCircle() {
        return circle;
    }

    public Mensch move() {
        Position pos = position.newMoveDirection(this.position.getX(), this.position.getY());
        return new Mensch(circle, isSick, this.world, pos);
    }

    public void drawShape() {
        this.circle.setCenterX(position.getX());
        this.circle.setCenterY(position.getY());
    }

    public Position getPosition() {
        return position;
    }
}
