package asteroids.Physical;

/**
 *
 * @author Nels Quinlog
 */
public abstract class Physical {
      
    protected double[] vectors = {0,0,0};
    protected double[] location = {0,0,0};
    protected double[] collisionVector = {0,0,0};
    protected double bounce = 1;
    protected double gravity;
    protected int size;
    protected int hp;
    private final boolean loop;
    
    protected Physical(double[] location,double[] vectors,int size,int hp,boolean loop) {
        this.location = location;
        this.vectors = vectors;
        this.size = size;
        this.hp = hp;
        this.loop = loop;
        this.bounce += (size / 100);
    }

    
        
    protected void collide(Physical phys) { 
        //this.hp -= phys.getDmg();
        this.collisionVector = phys.getVector().clone();
        this.collisionVector[2] *= -1;
        for(int j=0; j<collisionVector.length;++j) {
            System.out.print(": "+ collisionVector[j] + " :");
        }
        System.out.print(":: " + this + "\n");
    }
    
    protected double[] getVector() { return vectors.clone(); }    
    protected double[] getLoc() { return this.location; }
    protected int getSize() { return this.size; }
    protected int getHP() { return this.hp; }
    protected boolean looping() { return this.loop; }
    protected abstract int getDmg();
    protected abstract void explode();
}
