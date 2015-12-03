package asteroids.Physical;

/**
 *
 * @author Nels Quinlog
 */
public class Physical implements CollisionListener {
    
    private Collision collider;
    private double[] location = new double[DIMENSIONS];
    private double[] vectors = new double[DIMENSIONS];
    private double[] impactVector = new double[DIMENSIONS];
    private double inertia = 0.99;
    private double mass;
    private int size;
    
    protected Physical(double[] location,double[] vectors,int size) {
        this.location = location;
        this.vectors = vectors;
        this.size = size;
    }

    @Override
    public double[] getLoc() { return location; }
        @Override
    public double[] getVector() { return vectors; }    
    @Override
    public double getMass() { return mass; }
    @Override
    public int getSize() { return size; }
    @Override
    public void update(double[] affectingVector,double friction) {
        for(int i=0;i<DIMENSIONS;++i) {
            vectors[i] += affectingVector[i];
            vectors[i]  = inertia * (vectors[i] - friction);
            location[i] += vectors[i];
        }
    }
    @Override
    public void collide(CollisionListener cl) {  //TODO correct physics here
        impactVector = cl.getVector().clone();
        double multiplier = (cl.getMass() / this.mass);
        impactVector[2] *= -1;
        for(int j=0; j<DIMENSIONS;++j) {
            impactVector[j] *= multiplier;
            
            System.out.print(": "+ impactVector[j] + " :");
        }
        System.out.print(":: " + this + "\n");
    }
    @Override
    public CollisionListener clone(double[] loc) {
        return new Physical(loc,this.vectors,this.size);
    }
}
