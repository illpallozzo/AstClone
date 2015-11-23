package asteroids.Physical;

/**
 *
 * @author Nels Quinlog
 */
public class Physical implements CollisionListener {
    
    private final static double TAO = 2 * Math.PI;
    private final static int DIMENSIONS = 3;
    public double[] location = new double[DIMENSIONS];
    public double[] vectors = new double[DIMENSIONS];
    private double[] affectingVector = new double[DIMENSIONS];
    private double inertia = 1.0;
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

    public void update(double friction) {
        for(int i=0;i<location.length;++i) {
            vectors[i] += affectingVector[i];
            vectors[i]  *= inertia - friction;
            location[i] += vectors[i];
            affectingVector[i] = 0.0;
        }
    }

    @Override
    public void collide(CollisionListener cl) {  //TODO correct physics
        affectingVector = cl.getVector().clone();
        double multiplier = (cl.getMass() / this.mass);
        affectingVector[2] *= -1;
        for(int j=0; j<affectingVector.length;++j) {
            affectingVector[j] *= multiplier;
            
            System.out.print(": "+ affectingVector[j] + " :");
        }
        System.out.print(":: " + this + "\n");
    }
    
    @Override
    public double[] getVector() { return vectors.clone(); }    
    protected int getHP() { return this.hp; }
    @Override
    public double getMass() { return mass; }
    @Override
    public int getSize() { return size; }
    @Override
    public double[] getLoc() { return location; }
}
