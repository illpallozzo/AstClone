package asteroids;

import java.awt.Color;

/**
 *
 * @author illpallozzo
 */
public class Weapon extends Physical {

    private final double thrust = 0.05;
    private final int damage = 1000;

    public Weapon(double[] location, double[] vectors) {
        super(location.clone(),vectors.clone(),2,80,false);
        this.getShape(Shapes.MISSILE, new Color(130,180,20));
    }

    @Override
    public void update() {
        vectors[0] += (thrust * Math.cos(location[2]));
        vectors[1] += (thrust * Math.sin(location[2]));
        super.hp -= 1;
        super.update();
    }

    @Override
    protected void collide(Physical phys) {
        super.collide(phys);
        super.hp = 0;
    }

    @Override
    protected int getDmg() { return this.damage; }
    @Override
    protected void explode() { }
}
