package asteroids.PlayerParts;

/**
 *
 * @author nels quinlog
 */

public abstract interface Item {
    
    
    public enum Command {
        LEFT (-1),
        CENTER (0),
        RIGHT (1),
        THRUST_ON (2),
        THRUST_OFF (3),
        FIRE1 (4),
        FIRE2 (5);
        private final int command;
        
        Command(int command) {
            this.command = command;
        }
        public int getCommand() { return command; };
    }
    
    public double[] getLoc();    
    public void command(Command command);
    
}
