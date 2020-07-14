package sample;

import static sample.Const.*;

public class Position {
    private final double x;
    private final double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Position newMoveDirection(double dx, double dy) {
        double dir = Math.random() * 2 * Math.PI;
        double cos = Math.cos(dir) * 3;
        double sin = Math.sin(dir) * 3;
        if (dx + cos > WIDTH - RADIUS * 2 || dx + cos < 0)
            cos *= -1;
        if (dy + sin > HEIGHT - RADIUS * 2 || dy + sin < 0)
            sin *= -1;
        return new Position(dx + cos, dy + sin);
    }
}
