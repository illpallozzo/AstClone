package asteroids;

import java.awt.Color;

/**
 *
 * @author illpallozzo
 */

public class Rock extends Physical {

    public Rock(int vertices,double[] location, double[] vectors, int size,Color color) {
        super(location,vectors,4,24,true);
        this.getShape(Shapes.ROCK, new Color(230,230,80));
    }
    
    @Override
    protected void collide(Physical phys) {
        super.collide(phys);
        int top = this.getVertices();
        for(int i=0 ; i<top; ++i) {
            if(this.shape[0][i] <= 0) {
                this.size = 0;
            } else {
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
