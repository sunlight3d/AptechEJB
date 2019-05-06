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
public class Bai03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Rectangle r1 = new Rectangle(1.0, 2.0);
        Rectangle r2 = new Rectangle(1.0, 2.0);
        Rectangle r3 = new Rectangle(1.0, 2.0);
        Rectangle r4 = new Rectangle(1.0, 2.0);
        System.out.println("No Objects"+Rectangle.NUMBER_OF_OBJECTS);
        r1.methodA();
        Playable p1 = new Person("Hoang");
        Printable p2 = new Person("Hoang");
        p1.playSomething();
        p2.printAPage();
        
        
    }
    
}
