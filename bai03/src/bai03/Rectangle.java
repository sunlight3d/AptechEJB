/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai03;
public class Rectangle extends Shape {
    private Double width = 0.0;
    private Double height = 0.0;
    public static int NUMBER_OF_OBJECTS = 0;

    public Rectangle(Double width, Double height) {
        this.width = width;
        this.height = height;
        Rectangle.NUMBER_OF_OBJECTS ++;
    }

    @Override
    protected void methodA() {
        super.methodA();
        System.out.println("Method A of Rectangle");
    }

    @Override
    public void methodB() {
         //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
