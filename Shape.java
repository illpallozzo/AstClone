/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author illpallozzo
 */
public class Shape {
    double TAO = 2 * Math.PI;
    Random rand = new Random();
    double[][] shipShape = {{8,6,1,6,},{0,2.7,Math.PI,3.58}};
    double[][] weapShape = {{3,2,2},{0,3,3.28}};
    double[][] shape;
    int vertices;  

    
    
    public enum Shapes {
        FIGHTER,
        BOMBER,
        MISSILE,
        LASER,
        ROCK,
        THRUSTER;
    }
    
    public void getShape(Shapes shape, Color color) {
        
        switch (shape) {
            case FIGHTER : {
                this.vertices = (shipShape[0].length);
                this.shape = shipShape;
            }break;
            case BOMBER : {
                
            }break;
            case MISSILE : {
                this.vertices = (weapShape[0].length);
                this.shape = weapShape;
            }break;
            case LASER : {
                //this = new Shaper().getLaser();
            }break;
            case ROCK : {
                this.getRockShape();
            }break;
            case THRUSTER : {
                
            }break;
            default: {
                
            }break;
        }
    }
    
    protected void getRockShape() {
        int minimum = 4;
        int maximum = 16;
        int size = minimum + rand.nextInt(maximum);
        vertices = minimum + rand.nextInt(size - minimum);
        double point = 0;
        double[][] vertexArray = new double[2][vertices];
        for(int j=0;j<vertexArray[0].length;++j) {
            int extend = rand.nextInt(12) -4;
        vertexArray[0][j] = size + extend;
        }
        for(int i=0;i<vertexArray[1].length;++i) {
            vertexArray[1][i] = point;
            point += TAO / vertices;
        }
        this.shape = vertexArray;
        this.vertices = vertexArray[0].length;
    }
    
    public int[] getXs(double[] location) {
        int[] retX = new int[shape[0].length];
        for(int i=0;i<this.vertices;++i) {
            retX[i] = (int)(location[0] + (this.shape[0][i] * Math.cos(this.shape[1][i] + location[2])));
        }
        return retX;
    }   
    public int[] getYs(double[] location) {
        int[] retY = new int[this.vertices];
        for(int i=0;i<this.vertices;++i) {
            retY[i] = (int)(location[1] + (this.shape[0][i] * Math.sin(this.shape[1][i] + location[2])));
        }
        return retY;
    }
    int getVertices() {return this.vertices; }
}
