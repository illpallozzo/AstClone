/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids.Physical;

/**
 *
 * @author illpallozzo
 */
public class PoweredUpdate implements UpdateType{

    @Override
    public double[] update(double[] location, double[] vectors, double bounce) {
        vectors[0] += (thrust * Math.cos(location[2]));
        vectors[1] += (thrust * Math.sin(location[2]));
        super.update();
    }
    
}
