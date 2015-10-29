package asteroids.shapes;

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
        LASER
    }
    
    public static Shape getShape(Type type) {
        Shape shape = null;
        switch(type){
            case FIGHTER : {
                shape = new Fighter();
            } break;
            case BOMBER : {
                //shape = new Bomber();
            } break;
            case ROCK : {
                shape = new Rock();
            } break;
            case MISSILE : {
                shape = new Missile();
            } break;
            case LASER : {
                //shape = new Laser();
            } break;
            default: {
                shape = new Rock();
            }break;
        }
        return shape;
    }
}
