package asteroids.Physical;

import java.awt.Color;

/**
 *
 * @author nels quinlog
 */

public class Rock extends Physical {

    public Rock(double[] location, double[] vectors, int size,Color color) {
        super(location,vectors,size,(size * 10),true);
    }
    
    @Override
    protected void collide(Physical phys) {
        super.collide(phys);
        
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
