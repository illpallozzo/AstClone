/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids.shapes;

import java.util.Random;

/**
 *
 * @author illpallozzo
 */
public class Rock extends Shape {
    Random rand = new Random();

    
    public Rock() {
        int minimum = 8;
        int maximum = 16;
        int size = minimum + rand.nextInt(maximum);
        vertices = minimum + rand.nextInt(size);
        double point = 0;
        this.shape = new double[2][vertices];
        for(int j=0;j<shape[0].length;++j) {
            int extend = rand.nextInt(minimum) - minimum;
            shape[0][j] = size + extend;
        }
        for(int i=0;i<shape[1].length;++i) {
            shape[1][i] = point;
            point += TAO / vertices;
        }
        this.vertices = shape[0].length;
    }
}
