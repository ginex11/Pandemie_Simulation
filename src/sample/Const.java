package sample;

import java.util.Random;

public class Const {
    public static final int RADIUS = 3;
    public static final double SPEED = 1;
    public static final Random RAND = new Random();
    public static final double WIDTH = 1200.0;
    public static final double HEIGHT = 630.0;
    public static final long FRAMES_PER_SEC = 60L;
    public static final long INTERVAL = 1000000000L / FRAMES_PER_SEC;
    public static final double CHANCE = 0.13;
    public static final double CONSTAGIOUSINDEX = 0.75;
    public static final double DIRECTION() {
        return Math.random() * 2 * Math.PI;
    }
}

