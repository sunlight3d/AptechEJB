/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai03;
/**
 *
 * @author Nguyen Duc Hoang
 */
public class Person implements Playable, Printable{
    private String name;
    Person(String name) {
        this.name = name;
    }

    Person() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void playSomething() {
         System.out.println("Play something");
    }

    @Override
    public void printAPage() {
        System.out.println("Print a page");
    }
    
}
