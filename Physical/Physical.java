package asteroids.Physical;

import java.util.ArrayList;

/**
 *
 * @author Nels Quinlog
 */
public class Physical {
    
    private final static double TAO = 2 * Math.PI;
    private final static int DIMENSIONS = 3;
    private static final ArrayList<Physical> physicals;
    public double[] location = new double[DIMENSIONS];
    public double[] vectors = new double[DIMENSIONS];
    private double[] affectingVector = new double[DIMENSIONS];
    private double inertia = 1.0;
    private double mass;
    private int size;
    private int hp;
    
    protected Physical(double[] location,double[] vectors,int size,int hp) {
        this.location = location;
        this.vectors = vectors;
        this.size = size;
        this.hp = hp;
    }

    
        
    protected void collide(Physical phys) { 
        affectingVector = phys.getVector().clone();
        double multiplier = (phys.getMass() / this.mass);
        affectingVector[2] *= -1;
        for(int j=0; j<affectingVector.length;++j) {
            affectingVector[j] *= multiplier;
            
            System.out.print(": "+ affectingVector[j] + " :");
        }
        System.out.print(":: " + this + "\n");
    }
    
    
    public void collision(ArrayList<Physical> physicales) {
        ArrayList<double[]> collMap = new ArrayList();
        for(Physical phys : physicales) {
            double[] loc = phys.getLoc();
            double[] cur = {loc[0],loc[1],phys.getSize(),physicales.indexOf(phys)};
            for(double[] listed: collMap) {
                if(Math.hypot((cur[0]-listed[0]), (cur[1]-listed[1])) < (cur[2]+listed[2])) {
                    physicales.get((int) cur[3]).collide(physicales.get((int) listed[3]));
                    physicales.get((int) listed[3]).collide(physicales.get((int) cur[3]));
                }
            }
            collMap.add(cur);
        }
    }

    public void update(double friction) {
        for(int i=0;i<location.length;++i) {
            vectors[i] += affectingVector[i];
            vectors[i]  *= inertia - friction;
            location[i] += vectors[i];
            affectingVector[i] = 0.0;
        }
    }

    protected double[] getVector() { return vectors.clone(); }    
    protected double[] getLoc() { return location; }
    protected int getHP() { return this.hp; }
    public double[] getLocation() { return location; }
    public int getSize() { return size; }
    public double getMass() { return mass; }
}
