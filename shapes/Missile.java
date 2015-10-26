/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids.shapes;

/**
 *
 * @author illpallozzo
 */
public class Missile extends Shape {
    private final static double[][] shape = {{3,2,2},{0,3,3.28}};

    public Missile() {
        super.vertices = shape[0].length;
    }
}
