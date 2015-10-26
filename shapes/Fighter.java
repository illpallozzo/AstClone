/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids.shapes;

/**
 *
 * @author nels quinlog
 */
public class Fighter extends Shape {
    private final static double[][] shape = {{8,6,1,6,},{0,2.7,Math.PI,3.58}};
    
    public Fighter() {
        super.vertices = shape[0].length;
    }
}
