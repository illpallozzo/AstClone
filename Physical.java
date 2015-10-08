/*
 * created by Nels Quinlog
 */
package asteroids;

import java.awt.Color;

/**
 *
 * @author illpallozzo
 */
public abstract class Physical extends Shape {
      
    protected double[] vectors = {0,0,0};
    protected double[] location = {0,0,0};
    protected double[] collisionVector = {0,0,0};
    protected double bounce = 1.9;
    protected double gravity;
    protected int size;
    protected int hp;
    protected Color color;
    private final boolean loop;
    
    protected Physical(double[] location,double[] vectors,int size,int hp,boolean loop) {
        this.location = location;
        this.vectors = vectors;
        this.size = size;
        this.hp = hp;
        this.loop = loop;
    }

    public void update() {
        for(int i=0;i<location.length;++i) {
            this.vectors[i] += this.collisionVector[i] * bounce;
            this.location[i] += this.vectors[i];
            this.collisionVector[i] = 0.0;
        }
    }
        
    protected void collide(Physical phys) { 
        hp -= phys.getDmg();
        this.collisionVector = phys.getVector();
    }
    
    protected double[] getVector() { return vectors.clone(); }    
    protected double[] getLoc() { return this.location; }
    protected int getSize() { return this.size; }
    protected int getHP() { return this.hp; }
    protected Color getColor() { return this.color; }
    protected boolean looping() { return this.loop; }
    protected abstract int getDmg();
    protected abstract void explode();
}
