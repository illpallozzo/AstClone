package asteroids.Shapes;

import java.awt.Color;

/**
 *
 * @author nels quinlog
 */
public interface ShapeFactory{

    public static enum Type { 
        FIGHTER,
        BOMBER,
        ROCK,
        MISSILE,
        LASER,
        THRUSTER
    }
    
    public static Shape getShape(Type type, Color color) {
        Shape shape = null;
        switch(type){
            case FIGHTER : {
                shape = new Fighter(color);
            } break;
            case BOMBER : {
                shape = new Bomber(color);
            } break;
            case ROCK : {
                shape = new Rock(color);
            } break;
            case MISSILE : {
                shape = new Missile(color);
            } break;
            case LASER : {
                shape = new Laser(color);
            } break;
            case THRUSTER : {
                shape = new Thruster(color);
            } break;
            default: {
                shape = new Rock(color);
            }break;
        }
        return shape;
    }
}
