package test01;


import test01.Shape;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen Duc Hoang
 */
public class Retangle extends Shape{
    private Double width, height;
   
    
    @Override
    public Double calculateArea() {
        return width * height;
    }
    
}
