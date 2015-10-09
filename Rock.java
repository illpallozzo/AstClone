package asteroids;

import java.awt.Color;

/**
 *
 * @author illpallozzo
 */

public class Rock extends Physical {

    public Rock(int vertices,double[] location, double[] vectors, int size,Color color) {
        super(location,vectors,size,(size * 10),true);
        this.getShape(Shapes.ROCK, new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
    }
    
    @Override
    protected void collide(Physical phys) {
        double[] ploc = phys.getLoc().clone();
        super.collide(phys);
        if((ploc[0] > this.location[0]) || (ploc[1] > this.location[1])) {
            this.collisionVector[2] *= -1;
        }
        for(int i=0 ; i<shape[0].length; ++i) {
            if(super.shape[0][i] <= 0) {
                this.size = 0;
                this.hp = 0;
            } else {
                shape[0][i] -= phys.getDmg() / 10;
                this.size -= phys.getDmg() / 10;
            }  
        }
    }
    
    @Override
    protected int getHP() { return (int)(this.size*10); }
    @Override
    protected int getSize() { return (int)(this.size); }
    @Override
    protected int getDmg() { return (int) size; }
    @Override
    protected void explode() { }
}
