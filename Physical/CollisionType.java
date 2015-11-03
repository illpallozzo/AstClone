package asteroids.Physical;

/**
 *
 * @author illpallozzo
 */
public interface CollisionType {
    public void collide(Physical phys);
    public Physical explode(Physical phys);
}
