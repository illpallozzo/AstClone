/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids.shapes;

import java.awt.Color;

/**
 *
 * @author nels quinlog
 */
public class Shape {
    public final static double TAO = 2 * Math.PI;
    protected double[][] shape;
    protected int vertices;
    Color color;

    
    
    public enum Shapes {
        
        BOMBER,
        MISSILE,
        LASER,
        
        THRUSTER;
    }
    
    public void getShape(Shapes shape, Color color) {
        this.color = color;
        switch (shape) {
            
            case BOMBER : {
                
            }break;
            
            case LASER : {
                //this = new Shaper().getLaser();
            }break;
            
            case THRUSTER : {
                
            }break;
            default: {
                
            }break;
        }
    }
    
    protected void getRockShape() {
        
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
    protected int getVertices() {return this.vertices; }
    protected Color getColor() { return this.color; }
}
