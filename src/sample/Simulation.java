package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

import static sample.Const.INTERVAL;

public class Simulation extends AnimationTimer {
    private final ArrayList<Mensch> people = new ArrayList<>();
    private final Pane world;
    long last = 0;

    public Simulation(Pane world, int count) {
        this.world = world;
        fillListWithPeople(count);
    }

    @Override
    public void handle(long l) {
        if (l - last > INTERVAL) {
            for (Mensch p : people) {
                people.set(people.indexOf(p), p.move());
            }
            last = l;
        }
    }

    public void fillListWithPeople(int count) {
        int tmp = 0;
        Mensch m = new Mensch(true, world);
        people.add(m);
        while (tmp < count) {
            m = new Mensch(false, world);
            people.add(m);
            tmp++;
        }
    }


}
