package asteroids.Physical;

/**
 *
 * @author illpallozzo
 */
public class RockUpdate implements UpdateType {
    
    @Override
    public double[] update(double[] location, double[] vectors, double bounce) {
        double[] collisionVector = new double[vectors.length];
        for(int i=0;i<location.length;++i) {
            vectors[i] += collisionVector[i] * bounce;
            location[i] += vectors[i];
            collisionVector[i] = 0.0;
        }
        return collisionVector;
    }
}
