package prove02;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;


public class Wolf extends Creature implements Movable, Aware, Aggressor, Spanwer {

    private Direction _preferredDirection;
    private Boolean _canSpawn;


    public Wolf() {
        _preferredDirection = Direction.fromInt(new Random().nextInt(4));
        _health = 1;
        _canSpawn = false;
    }


    @Override
    public void move() {

        switch (_preferredDirection) {
            case RIGHT:
                _location.x++;
                break;
            case LEFT:
                _location.x--;
                break;
            case BELOW:
                _location.y++;
                break;
            case ABOVE:
                _location.y--;
                break;
            default:
                break;
        }
    }


    @Override
    public void attack(Creature target) {


        if (target == null || target instanceof Plant || target instanceof Zombie) {
            return;
        }

        target.takeDamage(5);
        _health++;
        _canSpawn = true;
    }


    @Override
    public void senseNeighbors(Creature above, Creature below, Creature left, Creature right) {


        if (above == null && below == null && left == null && right == null) {
            return;
        }


        switch (_preferredDirection) {
            case RIGHT:
                if (right instanceof Animal) {
                    return;
                }
                break;
            case LEFT:
                if (left instanceof Animal) {
                    return;
                }
                break;
            case ABOVE:
                if (above instanceof Animal) {
                    return;
                }
                break;
            case BELOW:
                if (below instanceof Animal) {
                    return;
                }
                break;
            default:
                break;
        }


        if (above instanceof Animal) {
            _preferredDirection = Direction.ABOVE;
        } else if (right instanceof Animal) {
            _preferredDirection = Direction.RIGHT;
        } else if (below instanceof Animal) {
            _preferredDirection = Direction.BELOW;
        } else if (left instanceof Animal) {
            _preferredDirection = Direction.LEFT;
        }


    }

    @Override
    Shape getShape() {
        return Shape.Square;
    }

    @Override
    Color getColor() {
        return new Color(128, 128, 128);
    }

    @Override
    Boolean isAlive() {
        return _health > 0;
    }


    @Override
    public Creature spanwNewCreature() {

        if (_canSpawn) {
            _canSpawn = false;
            Wolf child = new Wolf();
            child.setLocation((Point) _location.clone());

            child._location.x--;
            return child;
        }



        return null;
    }
}