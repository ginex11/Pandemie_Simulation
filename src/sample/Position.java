package sample;

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
        double cos = Math.cos(Math.random() * 2 * Math.PI);
        double sin = Math.sin(Math.random() * 2 * Math.PI);
        System.out.println("dx: " + dx + " cos: " + cos + " = " + (dx + cos));
        Position p = new Position(dx + cos , dy +sin);
        System.out.println("X: "+p.getX());
        return p;
    }
}
