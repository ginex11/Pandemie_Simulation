package sample;

import java.util.Random;

public class Const {
    public static final double[] ARR = {1.0, 1.0, 1.0};
    public static final int RADIUS = 5;
    public static final Random RAND = new Random();
    public static final double WIDTH = 1280.0;
    public static final double HEIGHT = 720.0;
    public static final long FRAMES_PER_SEC = 30L;
    public static final long INTERVAL = 1000000000L / FRAMES_PER_SEC;
    public static final double CHANCE = 0.06;

    public static final double DIRECTION() {
        return Math.random() * 2 * Math.PI;
    }
}
