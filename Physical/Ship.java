package asteroids.Physical;

import java.awt.Color;

/**
 * @author Nels Quinlog
 */
public class Ship extends Physical {
    
    public enum Maneuver {
        LEFT (-1),
        CENTER (0),
        RIGHT (1),
        THRUST_ON (2),
        THRUST_OFF (3),
        FIRE1 (4),
        FIRE2 (5);
        private final int command;
        
        Maneuver(int command) {
            this.command = command;
        }
        public int getManeuver() { return command; };
    }
    
    private double thrust;
    private final double maxSpeed = 0.004;
    private final double turnSpeed = 0.01;
    private final double exceleration = .0008;
    private final double fireOffset = 15;

    public Ship(double[] location, double[] vectors) {
        super(location,vectors,4,240,true);
        this.getShape(Shapes.FIGHTER, new Color(230,230,80));
        thrust = 0;
    }
    
    public void maneuver(Maneuver command) {
        switch (command) {
            case LEFT: {
                vectors[2] = (turnSpeed * -1);
            } break;
            case CENTER : {
                vectors[2] = 0;
            }break;
            case RIGHT : {
                vectors[2] = turnSpeed;
            }break;
            case THRUST_ON : {
                if(thrust < maxSpeed) {
                    thrust += exceleration;
                } else {
                    thrust = maxSpeed;
                }
            } break;
            case THRUST_OFF : {
                thrust = 0;
            }break;
            case FIRE1 : {
                
            }break;
            case FIRE2 : {
                
            }break;
            default : { }
        }
    }

    
    
    public Weapon getWeapon() { 
        double[] weapLoc = new double[location.length];
        double[] weapVec = new double[vectors.length];
        weapLoc[2] = location[2];
        weapVec[2] = 0;
        weapLoc[0] = location[0] + (fireOffset * Math.cos(weapLoc[2]));
        weapVec[0] = (thrust) * Math.cos(weapLoc[2]);
        weapLoc[1] = location[1] + (fireOffset * Math.sin(weapLoc[2]));
        weapVec[1] = (thrust) * Math.sin(weapVec[2]);
        Weapon weapon = new Weapon(weapLoc,weapVec);
        return weapon;
    }
    
    @Override
    protected int getDmg() { return 0; }
    @Override
    protected void explode() { System.out.println("dead"); }    
}
