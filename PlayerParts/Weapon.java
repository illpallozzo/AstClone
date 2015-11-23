package asteroids.PlayerParts;

import asteroids.Physical.Physical;

/**
 *
 * @author nels quinlog
 */
public interface Weapon {

    private final double thrust = 0.05;
    private final int damage = 1;

    public Weapon(double[] location, double[] vectors) {
        super(location.clone(),vectors.clone(),2,80,false);
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
