/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samples;

/**
 *
 * @author Nguyen Duc Hoang
 */
public class Calculation {
    private Integer x;//encapsulation
    private Integer y;
    public void doSomething() {
        System.out.println("Do something");
        String str1 = null;
        String str2 = "this is a string";
        if (str1 == null) {
            str1 = "Hello";
        } else {
            str1 = str2;
        }
        str1 = (str1 == null) ? "Hello" : str2;
    }
    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
    
    
}
