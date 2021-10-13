package prove02;

import java.awt.Color;

public class Zombie extends Creature implements Movable, Aggressor {

    public Zombie() {
        _health = 1;
    }


    @Override
    public void move() {
        _location.x++;
    }


    @Override
    public void attack(Creature target) {
        if (target == null || target instanceof Plant) {
            return;
        }

        target.takeDamage(10);
    }

    @Override
    Shape getShape() {
        return Shape.Square;
    }

    @Override
    Color getColor() {
        return new Color(0, 0, 255);
    }

    @Override
    Boolean isAlive() {
        return _health > 0;
    }
}