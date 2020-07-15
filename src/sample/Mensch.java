package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static sample.Const.*;


public class Mensch {
    private final Circle circle;
    private final boolean isSick;
    private final Pane world;
    private MoveDirection moveDirection;


    public Mensch(boolean isSick, Pane world) {
        this.isSick = isSick;
        this.world = world;
        this.moveDirection = new MoveDirection(DIRECTION());
        this.circle = !isSick ? new Circle(RAND.nextDouble() * (WIDTH - RADIUS * 2), RAND.nextDouble() * (HEIGHT - RADIUS * 2), RADIUS, Color.GREEN) :
                new Circle(RAND.nextDouble() * (WIDTH - RADIUS * 2), RAND.nextDouble() * (HEIGHT - RADIUS * 2), RADIUS, Color.RED);
        this.world.getChildren().add(this.circle);
    }

//    public Mensch(Circle c, boolean isSick, Pane world, Position position) {
//        this.isSick = isSick;
//        this.world = world;
//        this.position = position;
//        this.circle = c;
//        drawShape();
//        this.world.getChildren().remove(c);
//        this.world.getChildren().add(circle);
//        shortAcceleration();
//    }


    public void move() {
        moveShape(moveDirection.getCos(), moveDirection.getSin());
        if (RAND.nextDouble() < CHANCE)
            this.moveDirection = new MoveDirection(DIRECTION());
    }

    public void moveShape(double cos, double sin) {
        if (this.circle.getCenterX() + cos > WIDTH - RADIUS * 2 || this.circle.getCenterX() + cos < RADIUS) {
            cos *= -1;
            this.moveDirection = new MoveDirection(DIRECTION());
        }

        if (this.circle.getCenterY() + sin > HEIGHT - RADIUS * 2 || this.circle.getCenterY() + sin < RADIUS) {
            sin *= -1;
            this.moveDirection = new MoveDirection(DIRECTION());
        }

        this.circle.setCenterX(this.circle.getCenterX() + cos);
        this.circle.setCenterY(this.circle.getCenterY() + sin);
    }

//    public void shortAcceleration() {
//        double dir = Math.random() * 2 * Math.PI;
//        double cos = Math.cos(dir);
//        double sin = Math.sin(dir);
//        for (int i = 0; i < 150; i++) {
//            this.circle.setCenterX(position.getX() + cos);
//            this.circle.setCenterY(position.getY() + sin);
//        }
//
//    }


}
