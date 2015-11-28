package asteroids.Physical;

/**
 *
 * @author Nels Quinlog
 */
public class Physical implements CollisionListener {
    
    public double[] location = new double[DIMENSIONS];
    public double[] vectors = new double[DIMENSIONS];
    private double inertia = 0.99;
    private double mass;
    private int size;
    private int hp;
    
    protected Physical(double[] location,double[] vectors,int size,int hp, Collision col) {
        this.location = location;
        this.vectors = vectors;
        this.size = size;
        this.hp = hp;
        col.registerListener(this);
    }

    @Override
    public void update(double[] affectingVector,double friction) {
        for(int i=0;i<DIMENSIONS;++i) {
            vectors[i] += affectingVector[i];
            vectors[i]  *= inertia - friction;
            location[i] += vectors[i];
        }
    }

    @Override
    public void collide(CollisionListener cl) {  //TODO correct physics here
        double[] impactVector = cl.getVector().clone();
        double multiplier = (cl.getMass() / this.mass);
        impactVector[2] *= -1;
        for(int j=0; j<DIMENSIONS;++j) {
            impactVector[j] *= multiplier;
            
            System.out.print(": "+ impactVector[j] + " :");
        }
        System.out.print(":: " + this + "\n");
    }
    
    protected int getHP() { return this.hp; }
    
    @Override
    public double[] getVector() { return vectors; }    
    @Override
    public double getMass() { return mass; }
    @Override
    public int getSize() { return size; }
    @Override
    public double[] getLoc() { return location; }
}
