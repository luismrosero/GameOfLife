package prove02;


import java.util.Random;
import java.awt.Color;


public class EatingPlants extends Plant implements Aggressor, Movable {

    private int _counter;
    private Random _rand;

    EatingPlants() {
        super();
        _counter = 0;
        _rand = new Random();
    }

    @Override
    public void attack(Creature target) {
        if (target instanceof Zombie) {
            target.takeDamage(1);
            _health++;
        }
    }

    @Override
    public Color getColor() {
        return new Color(0, 64, 128);
    }

    @Override
    public void move() {
        _counter++;
        if (_counter % (_rand.nextInt(10) + 5) == 0) {
            _location.y--;
        }
    }
}