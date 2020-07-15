package sample;

class MoveDirection {
    private final double direction;

    public MoveDirection(double direction) {
        this.direction = direction;
    }

    public double getCos() {
        return Math.cos(direction);
    }

    public double getSin() {
        return Math.sin(direction);
    }
}
